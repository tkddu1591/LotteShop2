package com.example.kmarket.controller.company;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class CompanyController {

    @GetMapping(value = {"/company/index"})
    public String index(Model model){

        return "company/index";
    }

    @GetMapping("/company/introduce")
    public String introduce(Model model){
        return "company/introduce";
    }

    @GetMapping("/company/notice")
    public String notice(Model model){
        return "company/notice";
    }

    @GetMapping("/company/promote")
    public String promote(Model model){
        return "company/promote";
    }

    @GetMapping("/company/manage")
    public String manage(Model model){
        return "company/manage";
    }
}
