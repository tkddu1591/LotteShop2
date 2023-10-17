package com.example.kmarket.entity;

import com.example.kmarket.dto.KmAdminNoticeDTO;
import com.example.kmarket.dto.KmMemberDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class KmAdminNoticeEntity {

    @Id
    @GeneratedValue
    private String cate;
    private String cateName;

    public KmAdminNoticeDTO toDTO(){
        return KmAdminNoticeDTO.builder()
                .cate(cate)
                .cateName(cateName)
                .build();
    }
}
