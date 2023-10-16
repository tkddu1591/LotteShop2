package com.example.kmarket.controller.cs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cs/*")
public class CSMainController {

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "cs/index";
    }


}
