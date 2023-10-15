package com.example.kmarket.controller.cs.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cs/qna/*")
@Controller
public class QnaController {

    @GetMapping("/list")
    public String list() {
        return "cs/qna/list";
    }
    @GetMapping("/view")
    public String view() {
        return "cs/qna/view";
    }
    @GetMapping("/write")
    public String write() {
        return "cs/qna/write";
    }
}
