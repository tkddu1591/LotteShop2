package com.example.kmarket.repository;


import com.example.kmarket.dto.KmCsFaqDTO;
import com.example.kmarket.entity.KmCsFaqEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmCsFaqRepository {
    public KmCsFaqDTO toDTO(KmCsFaqEntity articleEntity);
    public KmCsFaqEntity toEntity(KmCsFaqDTO articleDTO);
}

