package com.example.kmarket.controller.admin.cs;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.dto.admin.KmAdminFaqDTO;
import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import com.example.kmarket.mapper.admin.KmAdminFaqMapper;
import com.example.kmarket.service.admin.KmAdminFaqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Admin_FaqController {

    @Autowired
    private KmAdminFaqService kmAdminFaqService;

    @GetMapping("/admin/faq/list")
    public String list(Model model, String pg){

        // 페이징 처리
        // 현재 페이지 번호
        int currentPage = kmAdminFaqService.getCurrentPage(pg);

        // 전체 게시물 갯수
        int total = kmAdminFaqService.selectFaqCountTotal();

        // 마지막 페이지 번호
        int lastPageNum = kmAdminFaqService.getLastPageNum(total);

        // 페이지 그룹 start, end 번호
        int[] result = kmAdminFaqService.getPageGroupNum(currentPage, lastPageNum);

        // 페이지 시작 번호
        int pageStartNum = kmAdminFaqService.getPageStartNum(currentPage, lastPageNum);

        // 시작 인덱스
        int start = kmAdminFaqService.getStartNum(currentPage);

        // 1,2차 선택 중복 제거
        List<KmAdminFaqDTO> distinctCate = kmAdminFaqService.distinctCate(start);

        // 상품 목록 출력
        List<KmAdminFaqDTO> faqList = kmAdminFaqService.selectCsFaqAll(start);

        // 뷰(템플릿)에서 참조하기 위해 모델 참조
        model.addAttribute("faqList", faqList);
        model.addAttribute("distinctCate", distinctCate);

        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("pageGroupStart", result[0]);
        model.addAttribute("pageGroupEnd", result[1]);
        model.addAttribute("lastPageNum", lastPageNum);

        return "admin/faq/list";
    }

    @GetMapping("/admin/faq/view")
    public String view(Model model, int faqNo){

        KmAdminFaqDTO faqView = kmAdminFaqService.selectArticleFaq(faqNo);
        model.addAttribute("faqView", faqView);


        return "admin/faq/view";
    }



}
