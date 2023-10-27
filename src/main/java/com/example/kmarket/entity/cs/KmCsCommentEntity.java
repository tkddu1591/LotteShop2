package com.example.kmarket.entity.cs;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_cs_comment")
public class KmCsCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;
    private String qnaNo;
    private String answer;
    private String comment;

    @CreationTimestamp
    private String rdate;
}
