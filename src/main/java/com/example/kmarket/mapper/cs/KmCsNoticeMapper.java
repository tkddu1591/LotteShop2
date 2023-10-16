package com.example.kmarket.mapper.cs;


import com.example.kmarket.dto.cs.KmCsNoticeDTO;
import com.example.kmarket.entity.cs.KmCsNoticeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KmCsNoticeMapper {

    @Mapping(source = "kmCsCateEntity.cateName", target = "cateName")
    public KmCsNoticeDTO toDTO(KmCsNoticeEntity articleEntity);

    @Mapping(source = "cateName", target = "kmCsCateEntity.cateName")
    public KmCsNoticeEntity toEntity(KmCsNoticeDTO articleDTO);

}

