package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmMemberPointDTO;
import com.example.kmarket.entity.KmMemberPointEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmMemberPointMapper {
    public KmMemberPointDTO toDTO(KmMemberPointEntity articleEntity);
    public KmMemberPointEntity toEntity(KmMemberPointDTO articleDTO);
}

