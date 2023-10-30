package com.example.kmarket.mapper.product;

import com.example.kmarket.dto.product.KmProductCate2DTO;
import com.example.kmarket.dto.product.KmProductCate2DTO.KmProductCate2DTOBuilder;
import com.example.kmarket.entity.product.KmProductCate2Entity;
import com.example.kmarket.entity.product.KmProductCate2Entity.KmProductCate2EntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmProductCate2MapperImpl implements KmProductCate2Mapper {

    @Override
    public KmProductCate2DTO toDTO(KmProductCate2Entity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmProductCate2DTOBuilder kmProductCate2DTO = KmProductCate2DTO.builder();

        kmProductCate2DTO.cate2( articleEntity.getCate2() );
        kmProductCate2DTO.cate1( articleEntity.getCate1() );
        kmProductCate2DTO.c2Name( articleEntity.getC2Name() );

        return kmProductCate2DTO.build();
    }

    @Override
    public KmProductCate2Entity toEntity(KmProductCate2DTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmProductCate2EntityBuilder kmProductCate2Entity = KmProductCate2Entity.builder();

        kmProductCate2Entity.cate2( articleDTO.getCate2() );
        kmProductCate2Entity.cate1( articleDTO.getCate1() );
        kmProductCate2Entity.c2Name( articleDTO.getC2Name() );

        return kmProductCate2Entity.build();
    }
}
