package com.example.kmarket.mapper.cs;

import com.example.kmarket.dto.cs.KmCsFaqDTO;
import com.example.kmarket.dto.cs.KmCsFaqDTO.KmCsFaqDTOBuilder;
import com.example.kmarket.entity.cs.KmCsCateEntity;
import com.example.kmarket.entity.cs.KmCsCateEntity.KmCsCateEntityBuilder;
import com.example.kmarket.entity.cs.KmCsFaqEntity;
import com.example.kmarket.entity.cs.KmCsFaqEntity.KmCsFaqEntityBuilder;
import com.example.kmarket.entity.cs.KmCsTypeEntity;
import com.example.kmarket.entity.cs.KmCsTypeEntity.KmCsTypeEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T12:35:36+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmCsFaqMapperImpl implements KmCsFaqMapper {

    @Override
    public KmCsFaqDTO toDTO(KmCsFaqEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmCsFaqDTOBuilder kmCsFaqDTO = KmCsFaqDTO.builder();

        kmCsFaqDTO.cateName( articleEntityKmCsCateEntityCateName( articleEntity ) );
        kmCsFaqDTO.typeName( articleEntityKmCsTypeEntityTypeName( articleEntity ) );
        kmCsFaqDTO.faqNo( articleEntity.getFaqNo() );
        kmCsFaqDTO.title( articleEntity.getTitle() );
        kmCsFaqDTO.content( articleEntity.getContent() );
        kmCsFaqDTO.relatedFaq( articleEntity.getRelatedFaq() );
        kmCsFaqDTO.writer( articleEntity.getWriter() );
        kmCsFaqDTO.regip( articleEntity.getRegip() );
        kmCsFaqDTO.hit( articleEntity.getHit() );
        kmCsFaqDTO.rdate( articleEntity.getRdate() );

        return kmCsFaqDTO.build();
    }

    @Override
    public KmCsFaqEntity toEntity(KmCsFaqDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmCsFaqEntityBuilder kmCsFaqEntity = KmCsFaqEntity.builder();

        kmCsFaqEntity.kmCsCateEntity( kmCsFaqDTOToKmCsCateEntity( articleDTO ) );
        kmCsFaqEntity.kmCsTypeEntity( kmCsFaqDTOToKmCsTypeEntity( articleDTO ) );
        kmCsFaqEntity.faqNo( articleDTO.getFaqNo() );
        kmCsFaqEntity.title( articleDTO.getTitle() );
        kmCsFaqEntity.content( articleDTO.getContent() );
        kmCsFaqEntity.relatedFaq( articleDTO.getRelatedFaq() );
        kmCsFaqEntity.writer( articleDTO.getWriter() );
        kmCsFaqEntity.regip( articleDTO.getRegip() );
        kmCsFaqEntity.hit( articleDTO.getHit() );
        kmCsFaqEntity.rdate( articleDTO.getRdate() );

        return kmCsFaqEntity.build();
    }

    private String articleEntityKmCsCateEntityCateName(KmCsFaqEntity kmCsFaqEntity) {
        if ( kmCsFaqEntity == null ) {
            return null;
        }
        KmCsCateEntity kmCsCateEntity = kmCsFaqEntity.getKmCsCateEntity();
        if ( kmCsCateEntity == null ) {
            return null;
        }
        String cateName = kmCsCateEntity.getCateName();
        if ( cateName == null ) {
            return null;
        }
        return cateName;
    }

    private String articleEntityKmCsTypeEntityTypeName(KmCsFaqEntity kmCsFaqEntity) {
        if ( kmCsFaqEntity == null ) {
            return null;
        }
        KmCsTypeEntity kmCsTypeEntity = kmCsFaqEntity.getKmCsTypeEntity();
        if ( kmCsTypeEntity == null ) {
            return null;
        }
        String typeName = kmCsTypeEntity.getTypeName();
        if ( typeName == null ) {
            return null;
        }
        return typeName;
    }

    protected KmCsCateEntity kmCsFaqDTOToKmCsCateEntity(KmCsFaqDTO kmCsFaqDTO) {
        if ( kmCsFaqDTO == null ) {
            return null;
        }

        KmCsCateEntityBuilder kmCsCateEntity = KmCsCateEntity.builder();

        kmCsCateEntity.cateName( kmCsFaqDTO.getCateName() );

        return kmCsCateEntity.build();
    }

    protected KmCsTypeEntity kmCsFaqDTOToKmCsTypeEntity(KmCsFaqDTO kmCsFaqDTO) {
        if ( kmCsFaqDTO == null ) {
            return null;
        }

        KmCsTypeEntityBuilder kmCsTypeEntity = KmCsTypeEntity.builder();

        kmCsTypeEntity.typeName( kmCsFaqDTO.getTypeName() );

        return kmCsTypeEntity.build();
    }
}
