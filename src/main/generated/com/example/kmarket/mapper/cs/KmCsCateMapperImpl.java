package com.example.kmarket.mapper.cs;

import com.example.kmarket.dto.cs.KmCsCateDTO;
import com.example.kmarket.dto.cs.KmCsCateDTO.KmCsCateDTOBuilder;
import com.example.kmarket.entity.cs.KmCsCateEntity;
import com.example.kmarket.entity.cs.KmCsCateEntity.KmCsCateEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmCsCateMapperImpl implements KmCsCateMapper {

    @Override
    public KmCsCateDTO toDTO(KmCsCateEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmCsCateDTOBuilder kmCsCateDTO = KmCsCateDTO.builder();

        kmCsCateDTO.cate( articleEntity.getCate() );
        kmCsCateDTO.cateName( articleEntity.getCateName() );

        return kmCsCateDTO.build();
    }

    @Override
    public KmCsCateEntity toEntity(KmCsCateDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmCsCateEntityBuilder kmCsCateEntity = KmCsCateEntity.builder();

        kmCsCateEntity.cate( articleDTO.getCate() );
        kmCsCateEntity.cateName( articleDTO.getCateName() );

        return kmCsCateEntity.build();
    }
}
