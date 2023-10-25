package com.example.kmarket.entity.member;

import com.example.kmarket.entity.product.KmProductOrderEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_member_point")
public class KmMemberPointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pointNo;
    private String uid;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordNo")
    private KmProductOrderEntity orderEntity;
    private int point;
    private String comment;
    private LocalDateTime pointDate;

}
