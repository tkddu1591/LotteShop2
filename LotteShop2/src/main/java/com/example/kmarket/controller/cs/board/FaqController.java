package com.example.kmarket.controller.cs.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cs/faq/*")
@Controller
public class FaqController {

    @GetMapping("/list")
    public String list() {
        return "cs/faq/list";
    }

    @GetMapping("/view")
    public String view() {
        return "cs/faq/view";
    }

}