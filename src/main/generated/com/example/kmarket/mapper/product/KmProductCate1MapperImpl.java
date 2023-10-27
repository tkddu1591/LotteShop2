package com.example.kmarket.mapper.product;

import com.example.kmarket.dto.product.KmProductCate1DTO;
import com.example.kmarket.dto.product.KmProductCate1DTO.KmProductCate1DTOBuilder;
import com.example.kmarket.entity.product.KmProductCate1Entity;
import com.example.kmarket.entity.product.KmProductCate1Entity.KmProductCate1EntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmProductCate1MapperImpl implements KmProductCate1Mapper {

    @Override
    public KmProductCate1DTO toDTO(KmProductCate1Entity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmProductCate1DTOBuilder kmProductCate1DTO = KmProductCate1DTO.builder();

        kmProductCate1DTO.cate1( articleEntity.getCate1() );
        kmProductCate1DTO.c1Name( articleEntity.getC1Name() );
        kmProductCate1DTO.icon( articleEntity.getIcon() );

        return kmProductCate1DTO.build();
    }

    @Override
    public KmProductCate1Entity toEntity(KmProductCate1DTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmProductCate1EntityBuilder kmProductCate1Entity = KmProductCate1Entity.builder();

        kmProductCate1Entity.cate1( articleDTO.getCate1() );
        kmProductCate1Entity.c1Name( articleDTO.getC1Name() );
        kmProductCate1Entity.icon( articleDTO.getIcon() );

        return kmProductCate1Entity.build();
    }
}
