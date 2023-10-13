package com.example.kmarket.repository;


import com.example.kmarket.dto.KmCsQnaDTO;
import com.example.kmarket.entity.KmCsQnaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmCsQnaRepository {
    public KmCsQnaDTO toDTO(KmCsQnaEntity articleEntity);
    public KmCsQnaEntity toEntity(KmCsQnaDTO articleDTO);
}

