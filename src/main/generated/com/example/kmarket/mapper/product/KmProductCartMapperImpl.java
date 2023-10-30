package com.example.kmarket.mapper.product;

import com.example.kmarket.dto.product.KmProductCartDTO;
import com.example.kmarket.dto.product.KmProductCartDTO.KmProductCartDTOBuilder;
import com.example.kmarket.entity.member.KmMemberEntity;
import com.example.kmarket.entity.member.KmMemberEntity.KmMemberEntityBuilder;
import com.example.kmarket.entity.product.KmProductCartEntity;
import com.example.kmarket.entity.product.KmProductCartEntity.KmProductCartEntityBuilder;
import com.example.kmarket.entity.product.KmProductEntity;
import com.example.kmarket.entity.product.KmProductEntity.KmProductEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmProductCartMapperImpl implements KmProductCartMapper {

    @Override
    public KmProductCartDTO toDTO(KmProductCartEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmProductCartDTOBuilder kmProductCartDTO = KmProductCartDTO.builder();

        kmProductCartDTO.uid( articleEntityKmMemberEntityUid( articleEntity ) );
        kmProductCartDTO.prodNo( articleEntityKmProductEntityProdNo( articleEntity ) );
        kmProductCartDTO.thumb1( articleEntityKmProductEntityThumb1( articleEntity ) );
        kmProductCartDTO.prodName( articleEntityKmProductEntityProdName( articleEntity ) );
        kmProductCartDTO.descript( articleEntityKmProductEntityDescript( articleEntity ) );
        kmProductCartDTO.cartNo( articleEntity.getCartNo() );
        kmProductCartDTO.count( articleEntity.getCount() );
        kmProductCartDTO.price( articleEntity.getPrice() );
        kmProductCartDTO.discount( articleEntity.getDiscount() );
        kmProductCartDTO.point( articleEntity.getPoint() );
        kmProductCartDTO.delivery( articleEntity.getDelivery() );
        kmProductCartDTO.total( articleEntity.getTotal() );
        kmProductCartDTO.rdate( articleEntity.getRdate() );

        return kmProductCartDTO.build();
    }

    @Override
    public KmProductCartEntity toEntity(KmProductCartDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmProductCartEntityBuilder kmProductCartEntity = KmProductCartEntity.builder();

        kmProductCartEntity.kmMemberEntity( kmProductCartDTOToKmMemberEntity( articleDTO ) );
        kmProductCartEntity.kmProductEntity( kmProductCartDTOToKmProductEntity( articleDTO ) );
        kmProductCartEntity.cartNo( articleDTO.getCartNo() );
        kmProductCartEntity.count( articleDTO.getCount() );
        kmProductCartEntity.price( articleDTO.getPrice() );
        kmProductCartEntity.discount( articleDTO.getDiscount() );
        kmProductCartEntity.point( articleDTO.getPoint() );
        kmProductCartEntity.delivery( articleDTO.getDelivery() );
        kmProductCartEntity.total( articleDTO.getTotal() );
        kmProductCartEntity.rdate( articleDTO.getRdate() );

        return kmProductCartEntity.build();
    }

    private String articleEntityKmMemberEntityUid(KmProductCartEntity kmProductCartEntity) {
        if ( kmProductCartEntity == null ) {
            return null;
        }
        KmMemberEntity kmMemberEntity = kmProductCartEntity.getKmMemberEntity();
        if ( kmMemberEntity == null ) {
            return null;
        }
        String uid = kmMemberEntity.getUid();
        if ( uid == null ) {
            return null;
        }
        return uid;
    }

    private int articleEntityKmProductEntityProdNo(KmProductCartEntity kmProductCartEntity) {
        if ( kmProductCartEntity == null ) {
            return 0;
        }
        KmProductEntity kmProductEntity = kmProductCartEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return 0;
        }
        int prodNo = kmProductEntity.getProdNo();
        return prodNo;
    }

    private String articleEntityKmProductEntityThumb1(KmProductCartEntity kmProductCartEntity) {
        if ( kmProductCartEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductCartEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return null;
        }
        String thumb1 = kmProductEntity.getThumb1();
        if ( thumb1 == null ) {
            return null;
        }
        return thumb1;
    }

    private String articleEntityKmProductEntityProdName(KmProductCartEntity kmProductCartEntity) {
        if ( kmProductCartEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductCartEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return null;
        }
        String prodName = kmProductEntity.getProdName();
        if ( prodName == null ) {
            return null;
        }
        return prodName;
    }

    private String articleEntityKmProductEntityDescript(KmProductCartEntity kmProductCartEntity) {
        if ( kmProductCartEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductCartEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return null;
        }
        String descript = kmProductEntity.getDescript();
        if ( descript == null ) {
            return null;
        }
        return descript;
    }

    protected KmMemberEntity kmProductCartDTOToKmMemberEntity(KmProductCartDTO kmProductCartDTO) {
        if ( kmProductCartDTO == null ) {
            return null;
        }

        KmMemberEntityBuilder kmMemberEntity = KmMemberEntity.builder();

        kmMemberEntity.uid( kmProductCartDTO.getUid() );

        return kmMemberEntity.build();
    }

    protected KmProductEntity kmProductCartDTOToKmProductEntity(KmProductCartDTO kmProductCartDTO) {
        if ( kmProductCartDTO == null ) {
            return null;
        }

        KmProductEntityBuilder kmProductEntity = KmProductEntity.builder();

        kmProductEntity.prodNo( kmProductCartDTO.getProdNo() );
        kmProductEntity.thumb1( kmProductCartDTO.getThumb1() );
        kmProductEntity.prodName( kmProductCartDTO.getProdName() );
        kmProductEntity.descript( kmProductCartDTO.getDescript() );

        return kmProductEntity.build();
    }
}
