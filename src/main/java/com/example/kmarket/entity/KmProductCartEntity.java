package com.example.kmarket.entity;

import com.example.kmarket.dto.KmProductDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString(exclude = {"kmMemberEntity", "kmProductEntity"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_product_cart")
public class KmProductCartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartNo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    private KmMemberEntity kmMemberEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodNo")
    private KmProductEntity kmProductEntity;

    private int count;
    private int price;
    private int discount;
    private int point;
    private int delivery;
    private int total;
    private LocalDateTime rdate;


}
