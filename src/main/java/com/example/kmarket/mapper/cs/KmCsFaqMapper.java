package com.example.kmarket.mapper.cs;


import com.example.kmarket.dto.cs.KmCsFaqDTO;
import com.example.kmarket.entity.cs.KmCsFaqEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KmCsFaqMapper {
    @Mapping(source = "kmCsCateEntity.cateName", target = "cateName")
    @Mapping(source = "kmCsTypeEntity.typeName", target = "typeName")
    public KmCsFaqDTO toDTO(KmCsFaqEntity articleEntity);
    @Mapping(source = "cateName", target = "kmCsCateEntity.cateName")
    @Mapping(source = "typeName", target = "kmCsTypeEntity.typeName")
    public KmCsFaqEntity toEntity(KmCsFaqDTO articleDTO);
}

