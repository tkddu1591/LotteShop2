package com.example.kmarket.mapper.member;


import com.example.kmarket.dto.member.KmMemberPointDTO;
import com.example.kmarket.entity.member.KmMemberPointEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KmMemberPointMapper {
    @Mapping(source = "orderEntity.ordNo", target = "ordNo")
    @Mapping(source = "orderEntity.ordDate", target = "ordDate")
    @Mapping(source = "orderEntity.ordComplete", target = "ordComplete")
    public KmMemberPointDTO toDTO(KmMemberPointEntity articleEntity);
    @Mapping(source = "ordNo", target = "orderEntity.ordNo")
    @Mapping(source = "ordDate", target = "orderEntity.ordDate")
    @Mapping(source = "ordComplete", target = "orderEntity.ordComplete")
    public KmMemberPointEntity toEntity(KmMemberPointDTO articleDTO);
}

