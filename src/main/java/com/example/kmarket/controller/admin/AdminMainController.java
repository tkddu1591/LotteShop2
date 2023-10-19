package com.example.kmarket.controller.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
@RequiredArgsConstructor
public class AdminMainController {

    @GetMapping(value = {"/", "/index"})
    public String index(){
        return "admin/index";
    }
}
