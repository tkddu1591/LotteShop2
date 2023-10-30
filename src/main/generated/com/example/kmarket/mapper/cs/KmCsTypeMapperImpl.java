package com.example.kmarket.mapper.cs;

import com.example.kmarket.dto.cs.KmCsTypeDTO;
import com.example.kmarket.dto.cs.KmCsTypeDTO.KmCsTypeDTOBuilder;
import com.example.kmarket.entity.cs.KmCsCateEntity;
import com.example.kmarket.entity.cs.KmCsCateEntity.KmCsCateEntityBuilder;
import com.example.kmarket.entity.cs.KmCsTypeEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T12:35:36+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmCsTypeMapperImpl implements KmCsTypeMapper {

    @Override
    public KmCsTypeDTO toDTO(KmCsTypeEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmCsTypeDTOBuilder kmCsTypeDTO = KmCsTypeDTO.builder();

        kmCsTypeDTO.cate( articleEntity.getCate() );
        kmCsTypeDTO.type( articleEntity.getType() );
        kmCsTypeDTO.typeName( articleEntity.getTypeName() );

        return kmCsTypeDTO.build();
    }

    @Override
    public KmCsCateEntity toEntity(KmCsTypeDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmCsCateEntityBuilder kmCsCateEntity = KmCsCateEntity.builder();

        kmCsCateEntity.cate( articleDTO.getCate() );
        kmCsCateEntity.cateName( articleDTO.getCateName() );

        return kmCsCateEntity.build();
    }
}
