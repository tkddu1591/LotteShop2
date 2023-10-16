package com.example.kmarket.mapper.cs;


import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.entity.cs.KmCsQnaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmCsQnaMapper {
    public KmCsQnaDTO toDTO(KmCsQnaEntity articleEntity);
    public KmCsQnaEntity toEntity(KmCsQnaDTO articleDTO);
}

