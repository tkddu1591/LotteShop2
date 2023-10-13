package com.example.kmarket.entity;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmProductCartDTO {

    private int cartNo;
    private String  uid;
    private int prodNo;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;
    private String rDate;


}
