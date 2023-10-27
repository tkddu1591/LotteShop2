package com.example.kmarket.controller.admin.cs;

import com.example.kmarket.dto.admin.KmAdminCsCateDTO;
import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import com.example.kmarket.service.admin.KmAdminNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@Log4j2
public class Admin_NoticeController {

    @Autowired
    private KmAdminNoticeService kmAdminNoticeService;

    @GetMapping("/admin/notice/list")
    public String list(Model model, String pg, KmAdminCsCateDTO kmAdminCsCateDTO){

        // 페이징 처리
        // 현재 페이지 번호
        int currentPage = kmAdminNoticeService.getCurrentPage(pg);

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

        // 상품 목록 출력
        List<KmAdminNoticeDTO> noticeList = kmAdminNoticeService.selectCsNoticeAll(start);

        // 1차 카테고리 출력
        List<KmAdminCsCateDTO> findCname = kmAdminNoticeService.findCname(kmAdminCsCateDTO);


        // 뷰(템플릿)에서 참조하기 위해 모델 참조
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("findCname", findCname);

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageGroupStart", result[0]);
        model.addAttribute("pageGroupEnd", result[1]);
        model.addAttribute("pageStartNum", pageStartNum+1);

        return "admin/notice/list";
    }

    @GetMapping("/admin/notice/view")
    public String view(Model model, int noticeNo){

        KmAdminNoticeDTO noticeView = kmAdminNoticeService.selectArticleNotice(noticeNo);
        model.addAttribute("noticeView", noticeView);

        return "admin/notice/view";
    }

    @GetMapping("/admin/notice/write")
    public String write(){


        return "/admin/notice/write";
    }

    @PostMapping("/admin/notice/write")
    public String write(KmAdminNoticeDTO kmAdminNoticeDTO){

        kmAdminNoticeService.insertArticleNotice(kmAdminNoticeDTO);

        return "redirect:/admin/notice/list";
    }

    @GetMapping("/admin/notice/modify")
    public String modify(Model model, int noticeNo){

        KmAdminNoticeDTO noticeView = kmAdminNoticeService.selectArticleNotice(noticeNo);

        model.addAttribute("noticeView", noticeView);

        return "/admin/notice/modify";
    }

    @PostMapping("/admin/notice/modify")
    public String modify(KmAdminNoticeDTO kmAdminNoticeDTO){

        kmAdminNoticeService.updateArticleNotice(kmAdminNoticeDTO);

        return "redirect:/admin/notice/view?noticeNo="+kmAdminNoticeDTO.getNoticeNo();

    }

    @GetMapping ("/admin/notice/delete")
    public String delete(@RequestParam int noticeNo){

        kmAdminNoticeService.deleteArticleNotice(noticeNo);

        return "redirect:/admin/notice/list";

    }
}
