package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmProductReviewDTO;
import com.example.kmarket.entity.KmProductReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KmProductReviewMapper {
    public KmProductReviewDTO toDTO(KmProductReviewEntity articleEntity);
    public KmProductReviewEntity toEntity(KmProductReviewDTO articleDTO);
}

