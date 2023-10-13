package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmProductDTO;
import com.example.kmarket.entity.KmProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmProductMapper {
    public KmProductDTO toDTO(KmProductEntity articleEntity);
    public KmProductEntity toEntity(KmProductDTO articleDTO);
}

