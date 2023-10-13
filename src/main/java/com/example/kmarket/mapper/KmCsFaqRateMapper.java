package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmCsFaqRateDTO;
import com.example.kmarket.entity.KmCsFaqRateEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmCsFaqRateRepository {
    public KmCsFaqRateDTO toDTO(KmCsFaqRateEntity articleEntity);
    public KmCsFaqRateEntity toEntity(KmCsFaqRateDTO articleDTO);
}

