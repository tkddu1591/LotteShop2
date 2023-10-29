package com.example.kmarket.mapper.product;

import com.example.kmarket.dto.product.KmProductDTO;
import com.example.kmarket.dto.product.KmProductDTO.KmProductDTOBuilder;
import com.example.kmarket.entity.member.KmMemberEntity;
import com.example.kmarket.entity.member.KmMemberEntity.KmMemberEntityBuilder;
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
public class KmProductMapperImpl implements KmProductMapper {

    @Override
    public KmProductDTO toDTO(KmProductEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmProductDTOBuilder kmProductDTO = KmProductDTO.builder();

        kmProductDTO.seller( articleEntityMemberEntityUid( articleEntity ) );
        kmProductDTO.company( articleEntityMemberEntityCompany( articleEntity ) );
        kmProductDTO.ceo( articleEntityMemberEntityCeo( articleEntity ) );
        kmProductDTO.bizRegNum( articleEntityMemberEntityBizRegNum( articleEntity ) );
        kmProductDTO.tel( articleEntityMemberEntityTel( articleEntity ) );
        kmProductDTO.fax( articleEntityMemberEntityFax( articleEntity ) );
        kmProductDTO.prodNo( articleEntity.getProdNo() );
        kmProductDTO.prodCate1( articleEntity.getProdCate1() );
        kmProductDTO.prodCate2( articleEntity.getProdCate2() );
        kmProductDTO.prodName( articleEntity.getProdName() );
        kmProductDTO.descript( articleEntity.getDescript() );
        kmProductDTO.price( articleEntity.getPrice() );
        kmProductDTO.discount( articleEntity.getDiscount() );
        kmProductDTO.point( articleEntity.getPoint() );
        kmProductDTO.stock( articleEntity.getStock() );
        kmProductDTO.sold( articleEntity.getSold() );
        kmProductDTO.delivery( articleEntity.getDelivery() );
        kmProductDTO.hit( articleEntity.getHit() );
        kmProductDTO.score( articleEntity.getScore() );
        kmProductDTO.review( articleEntity.getReview() );
        kmProductDTO.thumb1( articleEntity.getThumb1() );
        kmProductDTO.thumb2( articleEntity.getThumb2() );
        kmProductDTO.thumb3( articleEntity.getThumb3() );
        kmProductDTO.detail( articleEntity.getDetail() );
        kmProductDTO.status( articleEntity.getStatus() );
        kmProductDTO.duty( articleEntity.getDuty() );
        kmProductDTO.receipt( articleEntity.getReceipt() );
        kmProductDTO.bizType( articleEntity.getBizType() );
        kmProductDTO.origin( articleEntity.getOrigin() );
        kmProductDTO.ip( articleEntity.getIp() );
        kmProductDTO.rdate( articleEntity.getRdate() );
        kmProductDTO.etc1( articleEntity.getEtc1() );
        kmProductDTO.etc2( articleEntity.getEtc2() );
        kmProductDTO.etc3( articleEntity.getEtc3() );
        kmProductDTO.etc4( articleEntity.getEtc4() );
        kmProductDTO.etc5( articleEntity.getEtc5() );

        return kmProductDTO.build();
    }

    @Override
    public KmProductEntity toEntity(KmProductDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmProductEntityBuilder kmProductEntity = KmProductEntity.builder();

        kmProductEntity.memberEntity( kmProductDTOToKmMemberEntity( articleDTO ) );
        kmProductEntity.prodNo( articleDTO.getProdNo() );
        kmProductEntity.prodCate1( articleDTO.getProdCate1() );
        kmProductEntity.prodCate2( articleDTO.getProdCate2() );
        kmProductEntity.prodName( articleDTO.getProdName() );
        kmProductEntity.descript( articleDTO.getDescript() );
        kmProductEntity.company( articleDTO.getCompany() );
        kmProductEntity.price( articleDTO.getPrice() );
        kmProductEntity.discount( articleDTO.getDiscount() );
        kmProductEntity.point( articleDTO.getPoint() );
        kmProductEntity.stock( articleDTO.getStock() );
        kmProductEntity.sold( articleDTO.getSold() );
        kmProductEntity.delivery( articleDTO.getDelivery() );
        kmProductEntity.hit( articleDTO.getHit() );
        kmProductEntity.score( articleDTO.getScore() );
        kmProductEntity.review( articleDTO.getReview() );
        kmProductEntity.thumb1( articleDTO.getThumb1() );
        kmProductEntity.thumb2( articleDTO.getThumb2() );
        kmProductEntity.thumb3( articleDTO.getThumb3() );
        kmProductEntity.detail( articleDTO.getDetail() );
        kmProductEntity.status( articleDTO.getStatus() );
        kmProductEntity.duty( articleDTO.getDuty() );
        kmProductEntity.receipt( articleDTO.getReceipt() );
        kmProductEntity.bizType( articleDTO.getBizType() );
        kmProductEntity.origin( articleDTO.getOrigin() );
        kmProductEntity.ip( articleDTO.getIp() );
        kmProductEntity.rdate( articleDTO.getRdate() );
        kmProductEntity.etc1( articleDTO.getEtc1() );
        kmProductEntity.etc2( articleDTO.getEtc2() );
        kmProductEntity.etc3( articleDTO.getEtc3() );
        kmProductEntity.etc4( articleDTO.getEtc4() );
        kmProductEntity.etc5( articleDTO.getEtc5() );

        return kmProductEntity.build();
    }

    private String articleEntityMemberEntityUid(KmProductEntity kmProductEntity) {
        if ( kmProductEntity == null ) {
            return null;
        }
        KmMemberEntity memberEntity = kmProductEntity.getMemberEntity();
        if ( memberEntity == null ) {
            return null;
        }
        String uid = memberEntity.getUid();
        if ( uid == null ) {
            return null;
        }
        return uid;
    }

    private String articleEntityMemberEntityCompany(KmProductEntity kmProductEntity) {
        if ( kmProductEntity == null ) {
            return null;
        }
        KmMemberEntity memberEntity = kmProductEntity.getMemberEntity();
        if ( memberEntity == null ) {
            return null;
        }
        String company = memberEntity.getCompany();
        if ( company == null ) {
            return null;
        }
        return company;
    }

    private String articleEntityMemberEntityCeo(KmProductEntity kmProductEntity) {
        if ( kmProductEntity == null ) {
            return null;
        }
        KmMemberEntity memberEntity = kmProductEntity.getMemberEntity();
        if ( memberEntity == null ) {
            return null;
        }
        String ceo = memberEntity.getCeo();
        if ( ceo == null ) {
            return null;
        }
        return ceo;
    }

    private String articleEntityMemberEntityBizRegNum(KmProductEntity kmProductEntity) {
        if ( kmProductEntity == null ) {
            return null;
        }
        KmMemberEntity memberEntity = kmProductEntity.getMemberEntity();
        if ( memberEntity == null ) {
            return null;
        }
        String bizRegNum = memberEntity.getBizRegNum();
        if ( bizRegNum == null ) {
            return null;
        }
        return bizRegNum;
    }

    private String articleEntityMemberEntityTel(KmProductEntity kmProductEntity) {
        if ( kmProductEntity == null ) {
            return null;
        }
        KmMemberEntity memberEntity = kmProductEntity.getMemberEntity();
        if ( memberEntity == null ) {
            return null;
        }
        String tel = memberEntity.getTel();
        if ( tel == null ) {
            return null;
        }
        return tel;
    }

    private String articleEntityMemberEntityFax(KmProductEntity kmProductEntity) {
        if ( kmProductEntity == null ) {
            return null;
        }
        KmMemberEntity memberEntity = kmProductEntity.getMemberEntity();
        if ( memberEntity == null ) {
            return null;
        }
        String fax = memberEntity.getFax();
        if ( fax == null ) {
            return null;
        }
        return fax;
    }

    protected KmMemberEntity kmProductDTOToKmMemberEntity(KmProductDTO kmProductDTO) {
        if ( kmProductDTO == null ) {
            return null;
        }

        KmMemberEntityBuilder kmMemberEntity = KmMemberEntity.builder();

        kmMemberEntity.uid( kmProductDTO.getSeller() );
        kmMemberEntity.company( kmProductDTO.getCompany() );
        kmMemberEntity.ceo( kmProductDTO.getCeo() );
        kmMemberEntity.bizRegNum( kmProductDTO.getBizRegNum() );
        kmMemberEntity.tel( kmProductDTO.getTel() );
        kmMemberEntity.fax( kmProductDTO.getFax() );

        return kmMemberEntity.build();
    }
}
