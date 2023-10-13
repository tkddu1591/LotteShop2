package com.example.kmarket.repository;


import com.example.kmarket.dto.KmCsCate1DTO;
import com.example.kmarket.entity.KmCsCate1Entity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmCsCate2Repository {
    public KmCsCate1DTO toDTO(KmCsCate1Entity articleEntity);
    public KmCsCate1Entity toEntity(KmCsCate1DTO articleDTO);
}

