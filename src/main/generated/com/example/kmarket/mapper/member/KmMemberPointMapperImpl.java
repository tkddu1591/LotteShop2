package com.example.kmarket.mapper.member;

import com.example.kmarket.dto.member.KmMemberPointDTO;
import com.example.kmarket.dto.member.KmMemberPointDTO.KmMemberPointDTOBuilder;
import com.example.kmarket.entity.member.KmMemberPointEntity;
import com.example.kmarket.entity.member.KmMemberPointEntity.KmMemberPointEntityBuilder;
import com.example.kmarket.entity.product.KmProductOrderEntity;
import com.example.kmarket.entity.product.KmProductOrderEntity.KmProductOrderEntityBuilder;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmMemberPointMapperImpl implements KmMemberPointMapper {

    @Override
    public KmMemberPointDTO toDTO(KmMemberPointEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmMemberPointDTOBuilder kmMemberPointDTO = KmMemberPointDTO.builder();

        kmMemberPointDTO.ordNo( articleEntityOrderEntityOrdNo( articleEntity ) );
        kmMemberPointDTO.ordDate( articleEntityOrderEntityOrdDate( articleEntity ) );
        kmMemberPointDTO.ordComplete( articleEntityOrderEntityOrdComplete( articleEntity ) );
        kmMemberPointDTO.pointNo( articleEntity.getPointNo() );
        kmMemberPointDTO.uid( articleEntity.getUid() );
        kmMemberPointDTO.point( articleEntity.getPoint() );
        kmMemberPointDTO.pointDate( articleEntity.getPointDate() );
        kmMemberPointDTO.comment( articleEntity.getComment() );

        return kmMemberPointDTO.build();
    }

    @Override
    public KmMemberPointEntity toEntity(KmMemberPointDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmMemberPointEntityBuilder kmMemberPointEntity = KmMemberPointEntity.builder();

        kmMemberPointEntity.orderEntity( kmMemberPointDTOToKmProductOrderEntity( articleDTO ) );
        kmMemberPointEntity.pointNo( articleDTO.getPointNo() );
        kmMemberPointEntity.uid( articleDTO.getUid() );
        kmMemberPointEntity.point( articleDTO.getPoint() );
        kmMemberPointEntity.comment( articleDTO.getComment() );
        kmMemberPointEntity.pointDate( articleDTO.getPointDate() );

        return kmMemberPointEntity.build();
    }

    private int articleEntityOrderEntityOrdNo(KmMemberPointEntity kmMemberPointEntity) {
        if ( kmMemberPointEntity == null ) {
            return 0;
        }
        KmProductOrderEntity orderEntity = kmMemberPointEntity.getOrderEntity();
        if ( orderEntity == null ) {
            return 0;
        }
        int ordNo = orderEntity.getOrdNo();
        return ordNo;
    }

    private LocalDateTime articleEntityOrderEntityOrdDate(KmMemberPointEntity kmMemberPointEntity) {
        if ( kmMemberPointEntity == null ) {
            return null;
        }
        KmProductOrderEntity orderEntity = kmMemberPointEntity.getOrderEntity();
        if ( orderEntity == null ) {
            return null;
        }
        LocalDateTime ordDate = orderEntity.getOrdDate();
        if ( ordDate == null ) {
            return null;
        }
        return ordDate;
    }

    private int articleEntityOrderEntityOrdComplete(KmMemberPointEntity kmMemberPointEntity) {
        if ( kmMemberPointEntity == null ) {
            return 0;
        }
        KmProductOrderEntity orderEntity = kmMemberPointEntity.getOrderEntity();
        if ( orderEntity == null ) {
            return 0;
        }
        int ordComplete = orderEntity.getOrdComplete();
        return ordComplete;
    }

    protected KmProductOrderEntity kmMemberPointDTOToKmProductOrderEntity(KmMemberPointDTO kmMemberPointDTO) {
        if ( kmMemberPointDTO == null ) {
            return null;
        }

        KmProductOrderEntityBuilder kmProductOrderEntity = KmProductOrderEntity.builder();

        kmProductOrderEntity.ordNo( kmMemberPointDTO.getOrdNo() );
        kmProductOrderEntity.ordDate( kmMemberPointDTO.getOrdDate() );
        kmProductOrderEntity.ordComplete( kmMemberPointDTO.getOrdComplete() );

        return kmProductOrderEntity.build();
    }
}
