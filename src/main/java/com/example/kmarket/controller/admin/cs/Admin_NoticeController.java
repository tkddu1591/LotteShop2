package com.example.kmarket.controller.admin.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Admin_NoticeController {

    @GetMapping("/admin/notice/list")
    public String list(){
        return "admin/notice/list";
    }

    @GetMapping("/admin/notice/view")
    public String view(){
        return "admin/notice/view";
    }


}
