package com.example.kmarket.entity.product;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString(exclude = {"kmProductOrderEntity"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_product_order_item")
public class KmProductOrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordNo")
    private KmProductOrderEntity kmProductOrderEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodNo")
    private KmProductEntity kmProductEntity;
    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;



}
