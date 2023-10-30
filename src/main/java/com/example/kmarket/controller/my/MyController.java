package com.example.kmarket.controller.my;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.dto.member.KmMemberDTO;
import com.example.kmarket.dto.member.KmMemberResponseDTO;
import com.example.kmarket.dto.product.KmProductReviewDTO;
import com.example.kmarket.service.cs.CsCateService;
import com.example.kmarket.service.cs.KmQnaService;
import com.example.kmarket.service.member.KmCouponService;
import com.example.kmarket.service.member.KmMemberPointService;
import com.example.kmarket.service.member.KmMemberService;
import com.example.kmarket.service.product.KmProductOrderItemService;
import com.example.kmarket.service.product.KmProductOrderService;
import com.example.kmarket.service.product.KmProductReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/my")
@RequiredArgsConstructor
@Slf4j
public class MyController {

    private final KmQnaService qnaService;
    private final KmProductReviewService reviewService;
    private final KmProductOrderItemService productOrderItemService;
    private final KmMemberPointService memberPointService;
    private final KmCouponService couponService;
    private final KmMemberService memberService;
    @GetMapping("list")
    public PageResponseDTO list(PageRequestDTO pageRequestDTO){
        log.info(String.valueOf(((pageRequestDTO.getStartDate()))));
        log.info(String.valueOf(((pageRequestDTO.getEndDate()))));
        PageResponseDTO pageResponseDTO = null;
        if(pageRequestDTO.getType().equals("point")){
            pageResponseDTO = memberPointService.findByUid(pageRequestDTO);
        }else if(pageRequestDTO.getType().equals("review")){
            pageResponseDTO = reviewService.findByUid(pageRequestDTO);
        }else if(pageRequestDTO.getType().equals("qna")){
            pageResponseDTO = qnaService.findByWriter(pageRequestDTO);
        }else if(pageRequestDTO.getType().equals("order")){
            pageResponseDTO = productOrderItemService.findByUid(pageRequestDTO);
        }else if(pageRequestDTO.getType().equals("coupon")){
            pageResponseDTO = couponService.findByUid(pageRequestDTO);
        }
        return pageResponseDTO;
    }

    @GetMapping("memberCount")
    public KmMemberDTO coupon(@RequestParam String memberUid ){
        KmMemberDTO memberDTO = new KmMemberDTO();

        memberDTO.setCoupon(couponService.countByUid(memberUid));
        memberDTO.setQna(qnaService.countByUid(memberUid));
        memberDTO.setPoint(memberService.findByUidAndPoint(memberUid));
        memberDTO.setOrder(productOrderItemService.countByUid(memberUid));
        log.info(String.valueOf(couponService.countByUid(memberUid)));
        log.info(memberDTO.toString());
        return memberDTO;
    }
    @PostMapping("review/write")
    public void writeReview(@RequestBody KmProductReviewDTO reviewDTO){
        reviewService.save(reviewDTO);
    }
}
