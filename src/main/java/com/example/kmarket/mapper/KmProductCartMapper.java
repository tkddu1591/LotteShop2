package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmProductCartDTO;
import com.example.kmarket.entity.KmProductCartEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KmProductCartMapper {
    @Mapping(source = "kmMemberEntity.uid", target = "uid")
    KmProductCartDTO toDTO(KmProductCartEntity articleEntity);
    @Mapping(source = "uid", target = "kmMemberEntity.uid")
    KmProductCartEntity toEntity(KmProductCartDTO articleDTO);
}

