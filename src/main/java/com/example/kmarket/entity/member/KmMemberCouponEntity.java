package com.example.kmarket.entity.member;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_member_coupon")
public class KmMemberCouponEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 쿠폰 넘버
    private int cno;
    // 쿠폰 이름
    private String cname;
    // 쿠폰 할인금액
    private int discount;
    // 쿠폰 사용조건(얼마 이상)
    @Builder.Default
    private int termsOfUse = 0;
    // 쿠폰 종료시점
    private LocalDateTime wdate;
    // 쿠폰 상태 (0: 사용안함, 1: 사용함)
    @Builder.Default
    private int state = 0;
    // 쿠폰 사용자
    private String uid;


}
