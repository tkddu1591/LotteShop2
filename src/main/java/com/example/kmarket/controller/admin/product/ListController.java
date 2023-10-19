package com.example.kmarket.controller.admin.product;

import com.example.kmarket.dto.KmMemberDTO;
import com.example.kmarket.dto.KmProductCartDTO;
import com.example.kmarket.dto.KmProductDTO;
import com.example.kmarket.service.admin.KmAdminProductService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Log4j2
@Controller
public class ListController {

    @Autowired
    private KmAdminProductService kmAdminProductService;

    @GetMapping("/admin/product/list")
    public String list(Model model) {
        // 상품 목록 출력
        List<KmProductDTO> products = kmAdminProductService.selectProducts();

        // 뷰(템플릿)에서 참조하기 위해 모델 참조
        model.addAttribute("products", products);

        return "/admin/product/list";
    }


}

