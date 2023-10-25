package com.example.kmarket.entity.product;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_product_review")
public class KmProductReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int revNo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prodNo")
    private KmProductEntity kmProductEntity;
    private String content;
    private String uid;
    private int rating;

    private String regIp;
    @CreationTimestamp
    private LocalDateTime rdate;

}
