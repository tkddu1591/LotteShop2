package com.example.kmarket.mapper.admin;

import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import com.example.kmarket.entity.admin.KmAdminNoticeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KmAdminNoticeMapper {

    @Mapping(source = "kmCsCateEntity.cateName", target = "cateName")
    @Mapping(source = "kmCsTypeEntity.typeName", target = "typeName")
    public KmAdminNoticeDTO toDTO(KmAdminNoticeEntity adminNotcieEntity);

    @Mapping(source = "cateName", target = "kmCsCateEntity.cateName")
    @Mapping(source = "typeName", target = "kmCsTypeEntity.typeName")
    public KmAdminNoticeEntity toEntity(KmAdminNoticeDTO kmAdminNoticeDTO);
}
