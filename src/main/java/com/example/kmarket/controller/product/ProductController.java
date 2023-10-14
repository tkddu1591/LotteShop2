package com.example.kmarket.controller.product;

import com.example.kmarket.dto.KmProductDTO;
import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.entity.KmProductReviewEntity;
import com.example.kmarket.repository.KmProductReviewRepository;
import com.example.kmarket.service.KmProductReviewService;
import com.example.kmarket.service.KmProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {
    @Autowired
    KmProductService kmProductService;
    @Autowired
    KmProductReviewService kmProductReviewService;
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
        log.info(pageResponseDTO.toString());
        return kmProductReviewService.findByProducts(pageResponseDTO);
    }
}
