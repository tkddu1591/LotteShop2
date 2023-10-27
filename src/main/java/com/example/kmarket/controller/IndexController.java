package com.example.kmarket.controller;

import com.example.kmarket.service.cs.CsCateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Log4j2
public class IndexController  {

    private final CsCateService ccs;

    @PostMapping(value = {"/cs/index","/index", "/"})
    public String index(String memberUid, String expirationTime, String token, Model model, String authority) {
        model.addAttribute("memberUid", memberUid);
        model.addAttribute("expirationTime", expirationTime);
        model.addAttribute("token", token);
        model.addAttribute("authority", authority);
        return "cs/index";
    }
    @GetMapping(value = {"/index", "/"})
    public String index() {
        return "index";
    }

}