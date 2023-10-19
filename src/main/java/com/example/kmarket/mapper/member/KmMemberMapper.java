package com.example.kmarket.mapper.member;


import com.example.kmarket.dto.member.KmMemberDTO;
import com.example.kmarket.entity.member.KmMemberEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmMemberMapper {
    public KmMemberDTO toDTO(KmMemberEntity articleEntity);
    public KmMemberEntity toEntity(KmMemberDTO articleDTO);
}

