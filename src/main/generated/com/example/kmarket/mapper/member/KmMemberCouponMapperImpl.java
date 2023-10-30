package com.example.kmarket.mapper.member;

import com.example.kmarket.dto.member.KmMemberCouponDTO;
import com.example.kmarket.dto.member.KmMemberCouponDTO.KmMemberCouponDTOBuilder;
import com.example.kmarket.entity.member.KmMemberCouponEntity;
import com.example.kmarket.entity.member.KmMemberCouponEntity.KmMemberCouponEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmMemberCouponMapperImpl implements KmMemberCouponMapper {

    @Override
    public KmMemberCouponDTO toDTO(KmMemberCouponEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmMemberCouponDTOBuilder kmMemberCouponDTO = KmMemberCouponDTO.builder();

        kmMemberCouponDTO.cno( articleEntity.getCno() );
        kmMemberCouponDTO.cname( articleEntity.getCname() );
        kmMemberCouponDTO.discount( articleEntity.getDiscount() );
        kmMemberCouponDTO.termsOfUse( articleEntity.getTermsOfUse() );
        kmMemberCouponDTO.wdate( articleEntity.getWdate() );
        kmMemberCouponDTO.state( articleEntity.getState() );
        kmMemberCouponDTO.uid( articleEntity.getUid() );

        return kmMemberCouponDTO.build();
    }

    @Override
    public KmMemberCouponEntity toEntity(KmMemberCouponDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmMemberCouponEntityBuilder kmMemberCouponEntity = KmMemberCouponEntity.builder();

        kmMemberCouponEntity.cno( articleDTO.getCno() );
        kmMemberCouponEntity.cname( articleDTO.getCname() );
        kmMemberCouponEntity.discount( articleDTO.getDiscount() );
        kmMemberCouponEntity.termsOfUse( articleDTO.getTermsOfUse() );
        kmMemberCouponEntity.wdate( articleDTO.getWdate() );
        kmMemberCouponEntity.state( articleDTO.getState() );
        kmMemberCouponEntity.uid( articleDTO.getUid() );

        return kmMemberCouponEntity.build();
    }
}
