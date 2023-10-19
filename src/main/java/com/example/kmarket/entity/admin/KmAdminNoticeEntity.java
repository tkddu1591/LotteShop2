package com.example.kmarket.entity.admin;

import com.example.kmarket.entity.cs.KmCsCateEntity;
import com.example.kmarket.entity.cs.KmCsTypeEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString(exclude = {"kmCsCateEntity", "kmCsTypeEntity"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_cs_notice")
public class KmAdminNoticeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cate")
    private KmCsCateEntity kmCsCateEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type")
    private KmCsTypeEntity kmCsTypeEntity;

    private String content;
    private String regip;
    private String title;
    private String writer;
    private String hit;

    @CreationTimestamp
    private LocalDateTime rdate;

    // rdat컬럼을 yy-mm-dd 형태로 수정
    public String getFormattedRdate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd");
        return rdate.format(formatter);
    }

}
