package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmProductCartDTO;
import com.example.kmarket.entity.KmProductCartEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmProductCartRepository {
    public KmProductCartDTO toDTO(KmProductCartEntity articleEntity);
    public KmProductCartEntity toEntity(KmProductCartDTO articleDTO);
}

