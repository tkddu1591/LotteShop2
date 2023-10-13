package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmProductCate1DTO;
import com.example.kmarket.entity.KmProductCate1Entity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmProductCate1Mapper {
    public KmProductCate1DTO toDTO(KmProductCate1Entity articleEntity);
    public KmProductCate1Entity toEntity(KmProductCate1DTO articleDTO);
}

