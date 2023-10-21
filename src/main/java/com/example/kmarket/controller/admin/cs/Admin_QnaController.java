package com.example.kmarket.controller.admin.cs;

import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import com.example.kmarket.dto.admin.KmAdminQnaDTO;
import com.example.kmarket.service.admin.KmAdminQnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class Admin_QnaController {

    @Autowired
    private KmAdminQnaService kmAdminQnaService;

    @GetMapping("/admin/qna/list")
    public String list(Model model, String pg){

        List<KmAdminQnaDTO> qnaList = kmAdminQnaService.selectCsQnaAll();

        // 1,2차 선택 중복 제거
        List<KmAdminQnaDTO> distinctCate = kmAdminQnaService.distinctCate();

        // 페이징 처리
        // 현재 페이지 번호
        int currentPage = kmAdminQnaService.getCurrentPage(pg);
        // 전체 게시글 갯수
        int total = kmAdminQnaService.selectQnaCountTotal();
        // 마지막 페이지 번호
        int lastPageNum = kmAdminQnaService.getLastPageNum(total);
        // 페이지 그룹 start, end 번호
        int[] result = kmAdminQnaService.getPageGroupNum(currentPage, lastPageNum);
        // 페이지 시작번호
        int pageStartNum = kmAdminQnaService.getPageStartNum(currentPage, lastPageNum);
        // 시작 인덱스
        int start = kmAdminQnaService.getStartNum(currentPage);
        // 게시글 목록 출력
        List<KmAdminQnaDTO> qna = kmAdminQnaService.selectQnaCurrentPage(start);

        // 뷰(템플릿)에서 참조하기 위해 모델 참조
        model.addAttribute("qnaList", qnaList);
        model.addAttribute("distinctCate", distinctCate);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("total", total);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageGroupStart", result[0]);
        model.addAttribute("pageGroupEnd", result[1]);
        model.addAttribute("qna", qna);

        return "admin/qna/list";
    }

    @GetMapping("/admin/qna/view")
    public String view(){
        return "admin/qna/view";
    }


    @GetMapping("/admin/qna/reply")
    public String reply(){
        return "admin/qna/reply";
    }

}
