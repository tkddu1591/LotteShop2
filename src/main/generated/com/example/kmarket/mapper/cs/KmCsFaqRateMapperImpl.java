package com.example.kmarket.mapper.cs;

import com.example.kmarket.dto.cs.KmCsFaqRateDTO;
import com.example.kmarket.dto.cs.KmCsFaqRateDTO.KmCsFaqRateDTOBuilder;
import com.example.kmarket.entity.cs.KmCsFaqRateEntity;
import com.example.kmarket.entity.cs.KmCsFaqRateEntity.KmCsFaqRateEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmCsFaqRateMapperImpl implements KmCsFaqRateMapper {

    @Override
    public KmCsFaqRateDTO toDTO(KmCsFaqRateEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmCsFaqRateDTOBuilder kmCsFaqRateDTO = KmCsFaqRateDTO.builder();

        kmCsFaqRateDTO.faqNo( articleEntity.getFaqNo() );
        kmCsFaqRateDTO.uid( articleEntity.getUid() );
        kmCsFaqRateDTO.rate( articleEntity.getRate() );

        return kmCsFaqRateDTO.build();
    }

    @Override
    public KmCsFaqRateEntity toEntity(KmCsFaqRateDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmCsFaqRateEntityBuilder kmCsFaqRateEntity = KmCsFaqRateEntity.builder();

        kmCsFaqRateEntity.faqNo( articleDTO.getFaqNo() );
        kmCsFaqRateEntity.uid( articleDTO.getUid() );
        kmCsFaqRateEntity.rate( articleDTO.getRate() );

        return kmCsFaqRateEntity.build();
    }
}
