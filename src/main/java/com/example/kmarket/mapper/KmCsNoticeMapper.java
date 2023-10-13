package com.example.kmarket.mapper;


import com.example.kmarket.dto.KmCsNoticeDTO;
import com.example.kmarket.entity.KmCsNoticeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmCsNoticeRepository {
    public KmCsNoticeDTO toDTO(KmCsNoticeEntity articleEntity);
    public KmCsNoticeEntity toEntity(KmCsNoticeDTO articleDTO);
}

