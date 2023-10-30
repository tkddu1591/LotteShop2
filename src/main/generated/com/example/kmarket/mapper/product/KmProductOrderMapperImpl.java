package com.example.kmarket.mapper.product;

import com.example.kmarket.dto.product.KmProductOrderDTO;
import com.example.kmarket.dto.product.KmProductOrderDTO.KmProductOrderDTOBuilder;
import com.example.kmarket.entity.product.KmProductOrderEntity;
import com.example.kmarket.entity.product.KmProductOrderEntity.KmProductOrderEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T09:48:52+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmProductOrderMapperImpl implements KmProductOrderMapper {

    @Override
    public KmProductOrderDTO toDTO(KmProductOrderEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmProductOrderDTOBuilder kmProductOrderDTO = KmProductOrderDTO.builder();

        kmProductOrderDTO.ordNo( articleEntity.getOrdNo() );
        kmProductOrderDTO.ordUid( articleEntity.getOrdUid() );
        kmProductOrderDTO.ordCount( articleEntity.getOrdCount() );
        kmProductOrderDTO.ordPrice( articleEntity.getOrdPrice() );
        kmProductOrderDTO.ordDiscount( articleEntity.getOrdDiscount() );
        kmProductOrderDTO.ordDelivery( articleEntity.getOrdDelivery() );
        kmProductOrderDTO.savePoint( articleEntity.getSavePoint() );
        kmProductOrderDTO.usedPoint( articleEntity.getUsedPoint() );
        kmProductOrderDTO.recipName( articleEntity.getRecipName() );
        kmProductOrderDTO.recipHp( articleEntity.getRecipHp() );
        kmProductOrderDTO.recipZip( articleEntity.getRecipZip() );
        kmProductOrderDTO.recipAddr1( articleEntity.getRecipAddr1() );
        kmProductOrderDTO.recipAddr2( articleEntity.getRecipAddr2() );
        kmProductOrderDTO.ordPayment( articleEntity.getOrdPayment() );
        kmProductOrderDTO.ordComplete( articleEntity.getOrdComplete() );
        kmProductOrderDTO.ordTotPrice( articleEntity.getOrdTotPrice() );
        kmProductOrderDTO.ordDate( articleEntity.getOrdDate() );
        kmProductOrderDTO.ordCompleteDate( articleEntity.getOrdCompleteDate() );

        return kmProductOrderDTO.build();
    }

    @Override
    public KmProductOrderEntity toEntity(KmProductOrderDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmProductOrderEntityBuilder kmProductOrderEntity = KmProductOrderEntity.builder();

        kmProductOrderEntity.ordNo( articleDTO.getOrdNo() );
        kmProductOrderEntity.ordUid( articleDTO.getOrdUid() );
        kmProductOrderEntity.ordCount( articleDTO.getOrdCount() );
        kmProductOrderEntity.ordPrice( articleDTO.getOrdPrice() );
        kmProductOrderEntity.ordDiscount( articleDTO.getOrdDiscount() );
        kmProductOrderEntity.ordDelivery( articleDTO.getOrdDelivery() );
        kmProductOrderEntity.savePoint( articleDTO.getSavePoint() );
        kmProductOrderEntity.usedPoint( articleDTO.getUsedPoint() );
        kmProductOrderEntity.recipName( articleDTO.getRecipName() );
        kmProductOrderEntity.recipHp( articleDTO.getRecipHp() );
        kmProductOrderEntity.recipZip( articleDTO.getRecipZip() );
        kmProductOrderEntity.recipAddr1( articleDTO.getRecipAddr1() );
        kmProductOrderEntity.recipAddr2( articleDTO.getRecipAddr2() );
        kmProductOrderEntity.ordPayment( articleDTO.getOrdPayment() );
        kmProductOrderEntity.ordComplete( articleDTO.getOrdComplete() );
        kmProductOrderEntity.ordTotPrice( articleDTO.getOrdTotPrice() );
        kmProductOrderEntity.ordDate( articleDTO.getOrdDate() );
        kmProductOrderEntity.ordCompleteDate( articleDTO.getOrdCompleteDate() );

        return kmProductOrderEntity.build();
    }
}
