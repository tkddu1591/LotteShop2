package com.example.kmarket.controller.cs.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cs/notice/*")
@Controller
public class NoticeController {
    @GetMapping("/list")
    public String list() {
        return "cs/notice/list";
    }

    @GetMapping("/view")
    public String view() {
        return "cs/notice/view";
    }
}
