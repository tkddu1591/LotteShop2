package com.example.kmarket.controller.admin.cs;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Admin_FaqController {

    @GetMapping("/admin/faq/view")
    public String view(){
        return "admin/faq/view";
    }

    @GetMapping("/admin/faq/list")
    public String list(Model model, PageRequestDTO pageRequestDTO){
        PageResponseDTO pageResponseDTO = null;

        return "admin/faq/list";
    }

}
