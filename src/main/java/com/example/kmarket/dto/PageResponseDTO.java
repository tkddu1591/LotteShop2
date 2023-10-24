package com.example.kmarket.dto;

import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.dto.member.KmMemberCouponDTO;
import com.example.kmarket.dto.member.KmMemberPointDTO;
import com.example.kmarket.dto.product.*;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PageResponseDTO {

    //dto List
    private List<KmProductDTO> dtoList;
    private List<KmProductReviewDTO> reviewDtoList;
    private List<KmProductCartDTO> cartDTOS;
    private List<KmMemberPointDTO> pointDTOS;
    private List<KmProductOrderDTO> orderDTOS;
    private List<KmProductOrderItemDTO> orderItemDTOS;
    private List<KmCsQnaDTO> qnaDTOS;
    private List<KmMemberCouponDTO> couponDTOS;
    //필수로 나오는 데이터
    private int cate;
    private int pg;
    private int size;
    private int total;

    private int start, end, last;
    private boolean prev, next;

    // 1~ 10 페이지 설정
    @Builder.Default
    private int pageSize =10;

    @Builder
    public PageResponseDTO(PageRequestDTO pageRequestDTO,
                           List<KmProductDTO> dtoList,
                           List<KmProductReviewDTO> reviewDtoList,
                           List<KmProductCartDTO> cartDTOS,
                           List<KmMemberPointDTO> pointDTOS,
                           List<KmProductOrderDTO> orderDTOS,
                           List<KmProductOrderItemDTO> orderItemDTOS,
                           List<KmCsQnaDTO> qnaDTOS,
                           List<KmMemberCouponDTO> couponDTOS,
                           int total) {
        this.cate = pageRequestDTO.getCate();
        this.pg = pageRequestDTO.getPg();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;
        this.reviewDtoList = reviewDtoList;
        this.cartDTOS = cartDTOS;
        this.pointDTOS = pointDTOS;
        this.orderDTOS = orderDTOS;
        this.orderItemDTOS = orderItemDTOS;
        this.qnaDTOS = qnaDTOS;
        this.couponDTOS = couponDTOS;

        this.end = (int) (Math.ceil(this.pg / (float)pageSize)) * pageSize;
        this.start = this.end - pageSize+1;


        this.last = (int) (Math.ceil(total / (double) size));
        this.end = end > last ? last : end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
