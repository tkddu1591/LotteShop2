package com.example.kmarket.dto.product;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmProductReviewDTO {
    private int revNo;
    private int prodNo;
    private String content;
    private String uid;
    private int rating;
    private String regIp;
    private LocalDateTime rdate;
    //추가데이터
    private String prodName;

}
