package com.example.kmarket.entity.cs;

import com.example.kmarket.entity.product.KmProductOrderItemEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString(exclude = {"kmCsCateEntity", "kmCsTypeEntity", "kmCsQnaEntity"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Setter
@Table(name = "km_cs_qna")
public class KmCsQnaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qnaNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate")
    private KmCsCateEntity kmCsCateEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private KmCsTypeEntity kmCsTypeEntity;
    private String title;
    private String content;
    private String file1;
    private String file2;
    private String file3;
    private String file4;
    private String writer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderItemId")
    private KmProductOrderItemEntity kmProductOrderItemEntity;
    @Builder.Default
    private int answerComplete = 0;
    private String regip;
    private String answer;
    @CreationTimestamp
    private LocalDateTime rdate;
    private LocalDateTime answerDate;
}
