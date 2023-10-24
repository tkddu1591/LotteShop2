package com.example.kmarket.controller.admin.product;

import com.example.kmarket.dto.product.KmProductDTO;
import com.example.kmarket.service.admin.KmAdminRegisterService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Log4j2
@Controller
public class RegisterController {

  @Autowired
  private KmAdminRegisterService kmAdminRegisterService;


  @GetMapping ("/admin/product/register")
    public String register(){
      return "admin/product/register";

    }

    @PostMapping("/admin/product/register")
    public String register(KmProductDTO dto){
     /*
      String prodName
      String descript
      String company
      int price
      int discount
      int stock
      int delivery
      String status
      String duty
      String receipt
      String bizType
      String origin


      */
      return null;

    }


}
