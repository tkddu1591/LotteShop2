package com.example.kmarket.mapper.member;


import com.example.kmarket.dto.member.KmMemberCouponDTO;
import com.example.kmarket.dto.member.KmMemberRequestDTO;
import com.example.kmarket.entity.member.KmMemberCouponEntity;
import com.example.kmarket.entity.member.KmMemberEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmMemberCouponMapper {
    public KmMemberCouponDTO toDTO(KmMemberCouponEntity articleEntity);
    public KmMemberCouponEntity toEntity(KmMemberCouponDTO articleDTO);
}

