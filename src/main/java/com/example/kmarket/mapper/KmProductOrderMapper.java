package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmProductOrderDTO;
import com.example.kmarket.entity.KmProductOrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmProductOrderRepository {
    public KmProductOrderDTO toDTO(KmProductOrderEntity articleEntity);
    public KmProductOrderEntity toEntity(KmProductOrderDTO articleDTO);
}

