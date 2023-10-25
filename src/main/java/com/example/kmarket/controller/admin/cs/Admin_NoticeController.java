package com.example.kmarket.controller.admin.cs;

import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import com.example.kmarket.service.admin.KmAdminNoticeService;
import jakarta.transaction.Transactional;
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
    public String list(Model model, String pg){

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

        // 1,2차 선택 중복 제거
        List<KmAdminNoticeDTO> distinctCate = kmAdminNoticeService.distinctCate(start);

        // 상품 목록 출력
        List<KmAdminNoticeDTO> notices = kmAdminNoticeService.selectCsNoticeAll(start);

        // 뷰(템플릿)에서 참조하기 위해 모델 참조
        model.addAttribute("notices", notices);
        model.addAttribute("distinctCate", distinctCate);

        model.addAttribute("currentPage", currentPage);
        model.addAttribute("lastPageNum", lastPageNum);
        model.addAttribute("pageGroupStart", result[0]);
        model.addAttribute("pageGroupEnd", result[1]);
        model.addAttribute("pageStartNum", pageStartNum+1);

        return "admin/notice/list";
    }

    @GetMapping("/admin/notice/view")
    public String view(Model model, int noticeNo){

        log.info("noticeNo : " + noticeNo);
        KmAdminNoticeDTO noticeView = kmAdminNoticeService.selectArticleNotice(noticeNo);
        model.addAttribute("noticeView", noticeView);
        log.info("noticeView : " + noticeView);


        return "admin/notice/view";
    }

    @GetMapping("/admin/notice/write")
    public String write(Model model, String cateName){

        List<KmAdminNoticeDTO> findCateName = kmAdminNoticeService.findCateName(cateName);
        int noticeWrite = kmAdminNoticeService.insertArticleNotice(KmAdminNoticeDTO.builder().build());

        model.addAttribute("CnameTname", findCateName);
        model.addAttribute("noticeWrite", noticeWrite);


        return "/admin/notice/write";
    }

    @PostMapping("/admin/notice/write")
    public String write(Model model, KmAdminNoticeDTO kmAdminNoticeDTO){

        log.info("kmAdminNoticeDTO : " + kmAdminNoticeDTO);
        kmAdminNoticeService.insertArticleNotice(kmAdminNoticeDTO);

        return "redirect:/admin/notice/list";
    }

    @GetMapping("/admin/notice/modify")
    public String update(Model model, int noticeNo, String cateName){

        KmAdminNoticeDTO kmAdminNoticeDTO = kmAdminNoticeService.selectArticleNotice(noticeNo);
        List<KmAdminNoticeDTO> findCateName = kmAdminNoticeService.findCateName(cateName);

        model.addAttribute("kmAdminNoticeDTO", kmAdminNoticeDTO);
        model.addAttribute("findCateName", findCateName);

        return "/admin/notice/modify";
    }

    @PostMapping("/admin/notice/modify")
    public String update(Model model, KmAdminNoticeDTO kmAdminNoticeDTO){

        kmAdminNoticeService.updateArticleNotice(kmAdminNoticeDTO);

        return "redirect:/admin/notice/list";
    }

    @DeleteMapping("/admin/notice/delete/{noticeNo}")
    @Transactional
    public void delete(@PathVariable("noticeNo") int noticeNo){

        kmAdminNoticeService.deleteArticleNotice(noticeNo);
    }
}
