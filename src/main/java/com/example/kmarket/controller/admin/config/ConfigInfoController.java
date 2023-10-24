package com.example.kmarket.controller.admin.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigInfoController {
    @GetMapping("/admin/config/info")
    public String Info(){
        return "/admin/config/info";
    }
}
