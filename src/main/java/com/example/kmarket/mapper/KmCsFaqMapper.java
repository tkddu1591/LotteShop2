package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmCsFaqDTO;
import com.example.kmarket.entity.KmCsFaqEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmCsFaqMapper {
    public KmCsFaqDTO toDTO(KmCsFaqEntity articleEntity);
    public KmCsFaqEntity toEntity(KmCsFaqDTO articleDTO);
}

