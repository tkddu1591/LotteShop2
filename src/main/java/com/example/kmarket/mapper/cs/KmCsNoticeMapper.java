package com.example.kmarket.mapper.cs;


import com.example.kmarket.dto.cs.KmCsNoticeDTO;
import com.example.kmarket.entity.cs.KmCsNoticeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface KmCsNoticeMapper {
    public KmCsNoticeDTO toDTO(KmCsNoticeEntity articleEntity);
    public KmCsNoticeEntity toEntity(KmCsNoticeDTO articleDTO);
}

