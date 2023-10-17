package com.example.kmarket.mapper.cs;


import com.example.kmarket.dto.cs.KmCsCate1DTO;
import com.example.kmarket.entity.cs.KmCsCate1Entity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmCsCate2Mapper {
    public KmCsCate1DTO toDTO(KmCsCate1Entity articleEntity);
    public KmCsCate1Entity toEntity(KmCsCate1DTO articleDTO);
}

