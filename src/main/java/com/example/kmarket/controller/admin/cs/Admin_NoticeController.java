package com.example.kmarket.controller.admin.cs;

import com.example.kmarket.dto.admin.AdminPageResponseDTO;
import com.example.kmarket.dto.admin.AdminPageRequestDTO;
import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import com.example.kmarket.service.admin.KmAdminNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
@Log4j2
public class Admin_NoticeController {

    @Autowired
    private KmAdminNoticeService kmAdminNoticeService;

    @GetMapping("/admin/notice/list")
    public String list(Model model, String pg){

        log.info("pg : " + pg);


        List<KmAdminNoticeDTO> selectCsNoticesjoinCsCate = kmAdminNoticeService.selectCsNoticesjoinCsCate();

        // 1,2차 선택 중복 제거
        List<KmAdminNoticeDTO> distinctCate = kmAdminNoticeService.distinctCate();

        // 페이징 처리
        // 현재 페이지 번호
        int currentPage = kmAdminNoticeService.getCurrentPage(pg);
        log.info("currentPage : " + currentPage);


        // 전체 게시물 갯수
        int total = kmAdminNoticeService.selectNoticeCountTotal();

        // 마지막 페이지 번호
        int lastPageNum = kmAdminNoticeService.getLastPageNum(total);

        // 페이지 그룹 start, end 번호
        int[] result = kmAdminNoticeService.getPageGroupNum(currentPage, lastPageNum);

        // 페이지 시작번호
        int pageStartNum = kmAdminNoticeService.getPageStartNum(currentPage, lastPageNum);

        // 시작 인덱스
        int start = kmAdminNoticeService.getStartNum(currentPage);
        log.info("start : " + start);

        // 상품 목록 출력
        List<KmAdminNoticeDTO> notices = kmAdminNoticeService.selectNoticesCurrentPage(start);
        log.info("notices : " + notices);


        // 뷰(템플릿)에서 참조하기 위해 모델 참조
        model.addAttribute("selectCsNoticesjoinCsCate", selectCsNoticesjoinCsCate);
        model.addAttribute("distinctCate", distinctCate);

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageGroupStart", result[0]);
        model.addAttribute("pageGroupEnd", result[1]);
        model.addAttribute("pageStartNum", pageStartNum+1);
        model.addAttribute("notices", notices);


        return "admin/notice/list";
    }

    @GetMapping("/view")
    public String view(Model model, @RequestParam int pg){

        KmAdminNoticeDTO selectCsNoticeBynoticeNo = kmAdminNoticeService.selectCsNoticeBynoticeNo();

        model.addAttribute("noticeBynoticeNo", selectCsNoticeBynoticeNo);

        return "admin/notice/view";
    }

    @GetMapping("/write")
    public String write(){
        return "/admin/notice/write";
    }

}
