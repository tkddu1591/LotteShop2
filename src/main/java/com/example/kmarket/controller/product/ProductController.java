package com.example.kmarket.controller.product;

import com.example.kmarket.dto.KmProductCartDTO;
import com.example.kmarket.dto.KmProductDTO;
import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.entity.KmProductReviewEntity;
import com.example.kmarket.repository.KmProductReviewRepository;
import com.example.kmarket.service.KmProductCartService;
import com.example.kmarket.service.KmProductReviewService;
import com.example.kmarket.service.KmProductService;
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
            log.info("no review");
            return null;
        }
        return kmProductReviewService.findByProducts(pageResponseDTO);
    }
    @PostMapping("/cart")
    public void saveCart(@RequestBody KmProductCartDTO kmProductCartDTO){
        log.info(kmProductCartDTO.toString());
        kmProductCartService.save(kmProductCartDTO);
    }
    @GetMapping("/cart")
    public List<KmProductCartDTO> listCart(String uid){
        return kmProductCartService.findByUid(uid);
    }


}
