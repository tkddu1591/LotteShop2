package com.example.kmarket.controller.admin.cs;

import com.example.kmarket.dto.admin.PageResponseDTO;
import com.example.kmarket.dto.admin.PageRequestDTO;
import com.example.kmarket.service.admin.KmAdminNoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@Log4j2
public class Admin_NoticeController {

    @Autowired
    private KmAdminNoticeService kmAdminNoticeService;

    @GetMapping("/admin/notice/list")
    public String list(Model model, PageRequestDTO pageRequestDTO){
/*
       log.info(pageRequestDTO);
        PageResponseDTO pageResponseDTO = kmAdminNoticeService.findByCate(pageRequestDTO);*/
/*

        model.addAttribute(pageResponseDTO);
*/

        return "admin/notice/list";
    }

    @GetMapping("/view")
    public String view(){
        return "admin/notice/view";
    }

    @GetMapping("/write")
    public String write(){
        return "/admin/notice/write";
    }

}
