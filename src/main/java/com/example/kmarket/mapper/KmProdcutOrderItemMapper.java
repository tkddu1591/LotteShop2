package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmProductOrderItemDTO;
import com.example.kmarket.entity.KmProductOrderItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmProdcutOrderItemMapper {
    public KmProductOrderItemDTO toDTO(KmProductOrderItemEntity articleEntity);
    public KmProductOrderItemEntity toEntity(KmProductOrderItemDTO articleDTO);
}

