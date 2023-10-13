package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmMemberTermsDTO;
import com.example.kmarket.entity.KmMemberTermsEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmMemberTermsMapper {
    public KmMemberTermsDTO toDTO(KmMemberTermsEntity articleEntity);
    public KmMemberTermsEntity toEntity(KmMemberTermsDTO articleDTO);
}

