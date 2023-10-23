package com.example.kmarket.mapper.product;


import com.example.kmarket.dto.product.KmProductReviewDTO;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KmProductReviewMapper {
    @Mapping(source = "kmProductEntity.prodNo", target = "prodNo")
    @Mapping(source = "kmProductEntity.prodName", target = "prodName")
    public KmProductReviewDTO toDTO(KmProductReviewEntity articleEntity);
    @Mapping(source = "prodNo", target = "kmProductEntity.prodNo")
    @Mapping(source = "prodName", target = "kmProductEntity.prodName")
    public KmProductReviewEntity toEntity(KmProductReviewDTO articleDTO);
}

