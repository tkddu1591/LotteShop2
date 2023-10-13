package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmMemberDTO;
import com.example.kmarket.entity.KmMemberEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface kmMemberRepository {
    public KmMemberDTO toDTO(KmMemberEntity articleEntity);
    public KmMemberEntity toEntity(KmMemberDTO articleDTO);
}

