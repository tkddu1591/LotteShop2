package com.example.kmarket.controller.admin.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigBannerController {
    @GetMapping("/admin/config/banner")
    public String banner(){
        return "/admin/config/banner";
    }

}
