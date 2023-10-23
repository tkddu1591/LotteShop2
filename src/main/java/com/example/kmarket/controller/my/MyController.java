package com.example.kmarket.controller.my;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.service.cs.CsCateService;
import com.example.kmarket.service.cs.KmQnaService;
import com.example.kmarket.service.member.KmMemberPointService;
import com.example.kmarket.service.product.KmProductOrderItemService;
import com.example.kmarket.service.product.KmProductReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
@RequiredArgsConstructor
@Slf4j
public class MyController {

    private final KmQnaService qnaService;
    private final KmProductReviewService reviewService;
    private final KmProductOrderItemService productOrderItemService;
    private final KmMemberPointService memberPointService;
    @GetMapping("list")
    public PageResponseDTO list(PageRequestDTO pageRequestDTO){
        log.info(pageRequestDTO.toString());
        PageResponseDTO pageResponseDTO = null;
        if(pageRequestDTO.getType().equals("point")){
            pageResponseDTO = memberPointService.findByUid(pageRequestDTO);
        }else if(pageRequestDTO.getType().equals("review")){
            pageResponseDTO = reviewService.findByUid(pageRequestDTO);
        }else if(pageRequestDTO.getType().equals("qna")){
            pageResponseDTO = qnaService.findByWriter(pageRequestDTO);
        }else if(pageRequestDTO.getType().equals("order")){
            pageResponseDTO = productOrderItemService.findByUid(pageRequestDTO);
        }
        return pageResponseDTO;
    }
}
