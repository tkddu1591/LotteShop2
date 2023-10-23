package com.example.kmarket.dto.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmMemberCouponDTO {

    // 쿠폰 넘버
    private String cno;
    // 쿠폰 이름
    private String cname;
    // 쿠폰 할인금액
    private int discount;
    // 쿠폰 사용조건(얼마 이상)
    private int condition;
    // 쿠폰 종료시점
    private LocalDateTime wdate;
    // 쿠폰 상태 (0: 사용안함, 1: 사용함)
    private int state;
    // 쿠폰 사용자
    private String uid;
}
