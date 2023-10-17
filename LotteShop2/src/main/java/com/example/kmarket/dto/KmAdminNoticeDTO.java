package com.example.kmarket.dto;

import com.example.kmarket.entity.KmAdminNoticeEntity;
import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmAdminNoticeDTO {
    private String cate;
    private String cateName;

    public KmAdminNoticeEntity toEntity(){
        return KmAdminNoticeEntity.builder()
                .cate(cate)
                .cateName(cateName)
                .build();
    }
}
