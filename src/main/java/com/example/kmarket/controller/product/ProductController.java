package com.example.kmarket.controller.product;

import com.example.kmarket.dto.*;
import com.example.kmarket.entity.KmProductReviewEntity;
import com.example.kmarket.repository.KmProductReviewRepository;
import com.example.kmarket.service.KmProductCartService;
import com.example.kmarket.service.KmProductReviewService;
import com.example.kmarket.service.KmProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
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
        return kmProductService.findByProducts(pageRequestDTO);
    }
    @GetMapping("/view")
    public KmProductDTO view(int prodNo){
        return kmProductService.findById(prodNo);
    }
    @GetMapping("/view/review")
    public PageResponseDTO viewReview(PageRequestDTO pageResponseDTO){
        log.info(String.valueOf(pageResponseDTO.getProdNo()));
        log.info(String.valueOf(kmProductReviewService.countProdNo(pageResponseDTO.getProdNo())));
        if(kmProductReviewService.countProdNo(pageResponseDTO.getProdNo())==0){
            return null;
        }
        return kmProductReviewService.findByProducts(pageResponseDTO);
    }


}
