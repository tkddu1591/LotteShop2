package com.example.kmarket.controller.admin.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Admin_QnaController {

    @GetMapping("/admin/qna/view")
    public String view(){
        return "admin/notice/view";
    }

    @GetMapping("/admin/qna/list")
    public String list(){
        return "admin/notice/list";
    }

}
