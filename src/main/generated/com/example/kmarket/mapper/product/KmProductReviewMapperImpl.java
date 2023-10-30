package com.example.kmarket.mapper.product;

import com.example.kmarket.dto.product.KmProductReviewDTO;
import com.example.kmarket.dto.product.KmProductReviewDTO.KmProductReviewDTOBuilder;
import com.example.kmarket.entity.product.KmProductEntity;
import com.example.kmarket.entity.product.KmProductEntity.KmProductEntityBuilder;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import com.example.kmarket.entity.product.KmProductReviewEntity.KmProductReviewEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmProductReviewMapperImpl implements KmProductReviewMapper {

    @Override
    public KmProductReviewDTO toDTO(KmProductReviewEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmProductReviewDTOBuilder kmProductReviewDTO = KmProductReviewDTO.builder();

        kmProductReviewDTO.prodNo( articleEntityKmProductEntityProdNo( articleEntity ) );
        kmProductReviewDTO.prodName( articleEntityKmProductEntityProdName( articleEntity ) );
        kmProductReviewDTO.revNo( articleEntity.getRevNo() );
        kmProductReviewDTO.content( articleEntity.getContent() );
        kmProductReviewDTO.uid( articleEntity.getUid() );
        kmProductReviewDTO.rating( articleEntity.getRating() );
        kmProductReviewDTO.regIp( articleEntity.getRegIp() );
        kmProductReviewDTO.rdate( articleEntity.getRdate() );

        return kmProductReviewDTO.build();
    }

    @Override
    public KmProductReviewEntity toEntity(KmProductReviewDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmProductReviewEntityBuilder kmProductReviewEntity = KmProductReviewEntity.builder();

        kmProductReviewEntity.kmProductEntity( kmProductReviewDTOToKmProductEntity( articleDTO ) );
        kmProductReviewEntity.revNo( articleDTO.getRevNo() );
        kmProductReviewEntity.content( articleDTO.getContent() );
        kmProductReviewEntity.uid( articleDTO.getUid() );
        kmProductReviewEntity.rating( articleDTO.getRating() );
        kmProductReviewEntity.regIp( articleDTO.getRegIp() );
        kmProductReviewEntity.rdate( articleDTO.getRdate() );

        return kmProductReviewEntity.build();
    }

    private int articleEntityKmProductEntityProdNo(KmProductReviewEntity kmProductReviewEntity) {
        if ( kmProductReviewEntity == null ) {
            return 0;
        }
        KmProductEntity kmProductEntity = kmProductReviewEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return 0;
        }
        int prodNo = kmProductEntity.getProdNo();
        return prodNo;
    }

    private String articleEntityKmProductEntityProdName(KmProductReviewEntity kmProductReviewEntity) {
        if ( kmProductReviewEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductReviewEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return null;
        }
        String prodName = kmProductEntity.getProdName();
        if ( prodName == null ) {
            return null;
        }
        return prodName;
    }

    protected KmProductEntity kmProductReviewDTOToKmProductEntity(KmProductReviewDTO kmProductReviewDTO) {
        if ( kmProductReviewDTO == null ) {
            return null;
        }

        KmProductEntityBuilder kmProductEntity = KmProductEntity.builder();

        kmProductEntity.prodNo( kmProductReviewDTO.getProdNo() );
        kmProductEntity.prodName( kmProductReviewDTO.getProdName() );

        return kmProductEntity.build();
    }
}
