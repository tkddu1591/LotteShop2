package com.example.kmarket.entity.product;

import com.example.kmarket.entity.member.KmMemberEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_product")
public class KmProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prodNo;
    private int prodCate1;
    private int prodCate2;
    private String prodName;
    private String descript;
    private String company;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller")
    private KmMemberEntity memberEntity;
    @Column(nullable = true)
    private int price;
    @Column(nullable = true)
    private int discount;
    @Column(nullable = true)
    private int point;
    @Column(nullable = true)
    private int stock;
    @Column(nullable = true)
    private int sold;
    @Column(nullable = true)
    private int delivery;
    @Column(nullable = true)
    private int hit;
    @Column(nullable = true)
    private int score;
    @Column(nullable = true)
    private int review;
    private String thumb1;
    private String thumb2;
    private String thumb3;
    private String detail;
    private String status;
    private String duty;
    private String receipt;
    private String bizType;
    private String origin;
    private String ip;
    private LocalDateTime rdate;
    @Column(nullable = true)
    private int etc1;
    @Column(nullable = true)
    private int etc2;
    private String etc3;
    private String etc4;
    private String etc5;


}

