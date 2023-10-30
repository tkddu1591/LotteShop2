package com.example.kmarket.mapper.cs;

import com.example.kmarket.dto.cs.KmCsNoticeDTO;
import com.example.kmarket.dto.cs.KmCsNoticeDTO.KmCsNoticeDTOBuilder;
import com.example.kmarket.entity.cs.KmCsCateEntity;
import com.example.kmarket.entity.cs.KmCsCateEntity.KmCsCateEntityBuilder;
import com.example.kmarket.entity.cs.KmCsNoticeEntity;
import com.example.kmarket.entity.cs.KmCsNoticeEntity.KmCsNoticeEntityBuilder;
import com.example.kmarket.entity.cs.KmCsTypeEntity;
import com.example.kmarket.entity.cs.KmCsTypeEntity.KmCsTypeEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T12:35:37+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmCsNoticeMapperImpl implements KmCsNoticeMapper {

    @Override
    public KmCsNoticeDTO toDTO(KmCsNoticeEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmCsNoticeDTOBuilder kmCsNoticeDTO = KmCsNoticeDTO.builder();

        kmCsNoticeDTO.cateName( articleEntityKmCsCateEntityCateName( articleEntity ) );
        kmCsNoticeDTO.typeName( articleEntityKmCsTypeEntityTypeName( articleEntity ) );
        kmCsNoticeDTO.noticeNo( articleEntity.getNoticeNo() );
        kmCsNoticeDTO.title( articleEntity.getTitle() );
        kmCsNoticeDTO.content( articleEntity.getContent() );
        kmCsNoticeDTO.writer( articleEntity.getWriter() );
        kmCsNoticeDTO.regip( articleEntity.getRegip() );
        kmCsNoticeDTO.rdate( articleEntity.getRdate() );

        return kmCsNoticeDTO.build();
    }

    @Override
    public KmCsNoticeEntity toEntity(KmCsNoticeDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmCsNoticeEntityBuilder kmCsNoticeEntity = KmCsNoticeEntity.builder();

        kmCsNoticeEntity.kmCsCateEntity( kmCsNoticeDTOToKmCsCateEntity( articleDTO ) );
        kmCsNoticeEntity.kmCsTypeEntity( kmCsNoticeDTOToKmCsTypeEntity( articleDTO ) );
        kmCsNoticeEntity.noticeNo( articleDTO.getNoticeNo() );
        kmCsNoticeEntity.title( articleDTO.getTitle() );
        kmCsNoticeEntity.content( articleDTO.getContent() );
        kmCsNoticeEntity.writer( articleDTO.getWriter() );
        kmCsNoticeEntity.regip( articleDTO.getRegip() );
        kmCsNoticeEntity.rdate( articleDTO.getRdate() );

        return kmCsNoticeEntity.build();
    }

    private String articleEntityKmCsCateEntityCateName(KmCsNoticeEntity kmCsNoticeEntity) {
        if ( kmCsNoticeEntity == null ) {
            return null;
        }
        KmCsCateEntity kmCsCateEntity = kmCsNoticeEntity.getKmCsCateEntity();
        if ( kmCsCateEntity == null ) {
            return null;
        }
        String cateName = kmCsCateEntity.getCateName();
        if ( cateName == null ) {
            return null;
        }
        return cateName;
    }

    private String articleEntityKmCsTypeEntityTypeName(KmCsNoticeEntity kmCsNoticeEntity) {
        if ( kmCsNoticeEntity == null ) {
            return null;
        }
        KmCsTypeEntity kmCsTypeEntity = kmCsNoticeEntity.getKmCsTypeEntity();
        if ( kmCsTypeEntity == null ) {
            return null;
        }
        String typeName = kmCsTypeEntity.getTypeName();
        if ( typeName == null ) {
            return null;
        }
        return typeName;
    }

    protected KmCsCateEntity kmCsNoticeDTOToKmCsCateEntity(KmCsNoticeDTO kmCsNoticeDTO) {
        if ( kmCsNoticeDTO == null ) {
            return null;
        }

        KmCsCateEntityBuilder kmCsCateEntity = KmCsCateEntity.builder();

        kmCsCateEntity.cateName( kmCsNoticeDTO.getCateName() );

        return kmCsCateEntity.build();
    }

    protected KmCsTypeEntity kmCsNoticeDTOToKmCsTypeEntity(KmCsNoticeDTO kmCsNoticeDTO) {
        if ( kmCsNoticeDTO == null ) {
            return null;
        }

        KmCsTypeEntityBuilder kmCsTypeEntity = KmCsTypeEntity.builder();

        kmCsTypeEntity.typeName( kmCsNoticeDTO.getTypeName() );

        return kmCsTypeEntity.build();
    }
}
