package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmCsQnaDTO;
import com.example.kmarket.entity.KmCsQnaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmCsQnaMapper {
    public KmCsQnaDTO toDTO(KmCsQnaEntity articleEntity);
    public KmCsQnaEntity toEntity(KmCsQnaDTO articleDTO);
}

