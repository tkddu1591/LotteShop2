package com.example.kmarket.dto.product;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmProductOrderItemDTO {
    private int orderItemId;
    private int ordNo;
    private int prodNo;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;

    // 추가 데이터
    private String thumb1;
    private String prodName;
    private String descript;
    private LocalDateTime ordDate;
    private String company;
    private int ordComplete;
}
