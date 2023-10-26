package com.example.kmarket.controller.cs;

import com.example.kmarket.dto.cs.KmCsNoticeDTO;
import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.service.cs.CsCateService;
import com.example.kmarket.service.cs.KmNoticeService;
import com.example.kmarket.service.cs.KmQnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cs/*")
@RequiredArgsConstructor
@Log4j2
public class CSMainController {

    private final KmNoticeService kmNoticeService;
    private final KmQnaService kmQnaService;
    private final CsCateService csCateService;

    @GetMapping(value = {"/", "/index"})
    public String index(Model model) {
        log.info("===================index Controller=========================");
        List<KmCsNoticeDTO> noticeList = kmNoticeService.indexNoticeList();
        List<KmCsQnaDTO> qnaList = kmQnaService.indexQnaList();

        log.info("noticeList: " + noticeList);
        log.info("qnaList: " + qnaList);
        model.addAttribute("noticeList", noticeList);
        model.addAttribute("qnaList", qnaList);

        return "cs/index";
    }

   /* @GetMapping("/*")
    public KmCsTypeEntity csCate(int type){
        return csCateService.findTypeForCate(type);
    }*/


}
