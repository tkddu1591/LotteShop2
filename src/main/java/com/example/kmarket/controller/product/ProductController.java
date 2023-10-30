package com.example.kmarket.controller.product;

import com.example.kmarket.dto.*;
import com.example.kmarket.dto.product.KmProductDTO;
import com.example.kmarket.service.product.KmProductCartService;
import com.example.kmarket.service.product.KmProductReviewService;
import com.example.kmarket.service.product.KmProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {
    @Autowired
    KmProductService kmProductService;
    @Autowired
    KmProductReviewService kmProductReviewService;
    @Autowired
    KmProductCartService kmProductCartService;

    @GetMapping("/list")
    public PageResponseDTO list(PageRequestDTO pageRequestDTO){
        log.info(pageRequestDTO.toString());
        return kmProductService.findByProducts(pageRequestDTO);
    }
    @GetMapping("/view")
    public KmProductDTO view(int prodNo){
        return kmProductService.viewProd(prodNo);
    }
    @GetMapping("/view/review")
    public PageResponseDTO viewReview(PageRequestDTO pageResponseDTO){
        return kmProductReviewService.findByProducts(pageResponseDTO);
    }
    @GetMapping("/indexList")
    public List<KmProductDTO> indexList(@RequestParam String type){
        return kmProductService.findByType(type);
    }
/*
    @DeleteMapping("/delete")
    public void deleteProduct(@RequestParam int prodNo){
        kmProductService.deleteById(prodNo);
    }*/

    @GetMapping("/delete")
    public void deleteProduct(@RequestParam int prodNo){
        kmProductService.deleteById(prodNo);
    }
}
