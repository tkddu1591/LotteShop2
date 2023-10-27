package com.example.kmarket.mapper.cs;

import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.dto.cs.KmCsQnaDTO.KmCsQnaDTOBuilder;
import com.example.kmarket.entity.cs.KmCsCateEntity;
import com.example.kmarket.entity.cs.KmCsCateEntity.KmCsCateEntityBuilder;
import com.example.kmarket.entity.cs.KmCsQnaEntity;
import com.example.kmarket.entity.cs.KmCsQnaEntity.KmCsQnaEntityBuilder;
import com.example.kmarket.entity.cs.KmCsTypeEntity;
import com.example.kmarket.entity.cs.KmCsTypeEntity.KmCsTypeEntityBuilder;
import com.example.kmarket.entity.product.KmProductEntity;
import com.example.kmarket.entity.product.KmProductEntity.KmProductEntityBuilder;
import com.example.kmarket.entity.product.KmProductOrderItemEntity;
import com.example.kmarket.entity.product.KmProductOrderItemEntity.KmProductOrderItemEntityBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-27T12:35:37+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmCsQnaMapperImpl implements KmCsQnaMapper {

    @Override
    public KmCsQnaDTO toDTO(KmCsQnaEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmCsQnaDTOBuilder kmCsQnaDTO = KmCsQnaDTO.builder();

        kmCsQnaDTO.cateName( articleEntityKmCsCateEntityCateName( articleEntity ) );
        kmCsQnaDTO.cate( articleEntityKmCsCateEntityCate( articleEntity ) );
        kmCsQnaDTO.typeName( articleEntityKmCsTypeEntityTypeName( articleEntity ) );
        kmCsQnaDTO.type( articleEntityKmCsTypeEntityType( articleEntity ) );
        kmCsQnaDTO.orderItemId( articleEntityKmProductOrderItemEntityOrderItemId( articleEntity ) );
        kmCsQnaDTO.prodName( articleEntityKmProductOrderItemEntityKmProductEntityProdName( articleEntity ) );
        kmCsQnaDTO.prodNo( articleEntityKmProductOrderItemEntityKmProductEntityProdNo( articleEntity ) );
        kmCsQnaDTO.qnaNo( articleEntity.getQnaNo() );
        kmCsQnaDTO.title( articleEntity.getTitle() );
        kmCsQnaDTO.content( articleEntity.getContent() );
        kmCsQnaDTO.file1( articleEntity.getFile1() );
        kmCsQnaDTO.file2( articleEntity.getFile2() );
        kmCsQnaDTO.file3( articleEntity.getFile3() );
        kmCsQnaDTO.file4( articleEntity.getFile4() );
        kmCsQnaDTO.writer( articleEntity.getWriter() );
        kmCsQnaDTO.regip( articleEntity.getRegip() );
        kmCsQnaDTO.answerComplete( articleEntity.getAnswerComplete() );
        kmCsQnaDTO.rdate( articleEntity.getRdate() );
        kmCsQnaDTO.answer( articleEntity.getAnswer() );
        kmCsQnaDTO.answerDate( articleEntity.getAnswerDate() );

        return kmCsQnaDTO.build();
    }

    @Override
    public KmCsQnaEntity toEntity(KmCsQnaDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmCsQnaEntityBuilder kmCsQnaEntity = KmCsQnaEntity.builder();

        kmCsQnaEntity.kmCsCateEntity( kmCsQnaDTOToKmCsCateEntity( articleDTO ) );
        kmCsQnaEntity.kmCsTypeEntity( kmCsQnaDTOToKmCsTypeEntity( articleDTO ) );
        kmCsQnaEntity.kmProductOrderItemEntity( kmCsQnaDTOToKmProductOrderItemEntity( articleDTO ) );
        kmCsQnaEntity.qnaNo( articleDTO.getQnaNo() );
        kmCsQnaEntity.title( articleDTO.getTitle() );
        kmCsQnaEntity.content( articleDTO.getContent() );
        kmCsQnaEntity.file1( articleDTO.getFile1() );
        kmCsQnaEntity.file2( articleDTO.getFile2() );
        kmCsQnaEntity.file3( articleDTO.getFile3() );
        kmCsQnaEntity.file4( articleDTO.getFile4() );
        kmCsQnaEntity.writer( articleDTO.getWriter() );
        kmCsQnaEntity.answerComplete( articleDTO.getAnswerComplete() );
        kmCsQnaEntity.regip( articleDTO.getRegip() );
        kmCsQnaEntity.answer( articleDTO.getAnswer() );
        kmCsQnaEntity.rdate( articleDTO.getRdate() );
        kmCsQnaEntity.answerDate( articleDTO.getAnswerDate() );

        return kmCsQnaEntity.build();
    }

    private String articleEntityKmCsCateEntityCateName(KmCsQnaEntity kmCsQnaEntity) {
        if ( kmCsQnaEntity == null ) {
            return null;
        }
        KmCsCateEntity kmCsCateEntity = kmCsQnaEntity.getKmCsCateEntity();
        if ( kmCsCateEntity == null ) {
            return null;
        }
        String cateName = kmCsCateEntity.getCateName();
        if ( cateName == null ) {
            return null;
        }
        return cateName;
    }

    private String articleEntityKmCsCateEntityCate(KmCsQnaEntity kmCsQnaEntity) {
        if ( kmCsQnaEntity == null ) {
            return null;
        }
        KmCsCateEntity kmCsCateEntity = kmCsQnaEntity.getKmCsCateEntity();
        if ( kmCsCateEntity == null ) {
            return null;
        }
        String cate = kmCsCateEntity.getCate();
        if ( cate == null ) {
            return null;
        }
        return cate;
    }

    private String articleEntityKmCsTypeEntityTypeName(KmCsQnaEntity kmCsQnaEntity) {
        if ( kmCsQnaEntity == null ) {
            return null;
        }
        KmCsTypeEntity kmCsTypeEntity = kmCsQnaEntity.getKmCsTypeEntity();
        if ( kmCsTypeEntity == null ) {
            return null;
        }
        String typeName = kmCsTypeEntity.getTypeName();
        if ( typeName == null ) {
            return null;
        }
        return typeName;
    }

    private int articleEntityKmCsTypeEntityType(KmCsQnaEntity kmCsQnaEntity) {
        if ( kmCsQnaEntity == null ) {
            return 0;
        }
        KmCsTypeEntity kmCsTypeEntity = kmCsQnaEntity.getKmCsTypeEntity();
        if ( kmCsTypeEntity == null ) {
            return 0;
        }
        int type = kmCsTypeEntity.getType();
        return type;
    }

    private int articleEntityKmProductOrderItemEntityOrderItemId(KmCsQnaEntity kmCsQnaEntity) {
        if ( kmCsQnaEntity == null ) {
            return 0;
        }
        KmProductOrderItemEntity kmProductOrderItemEntity = kmCsQnaEntity.getKmProductOrderItemEntity();
        if ( kmProductOrderItemEntity == null ) {
            return 0;
        }
        int orderItemId = kmProductOrderItemEntity.getOrderItemId();
        return orderItemId;
    }

    private String articleEntityKmProductOrderItemEntityKmProductEntityProdName(KmCsQnaEntity kmCsQnaEntity) {
        if ( kmCsQnaEntity == null ) {
            return null;
        }
        KmProductOrderItemEntity kmProductOrderItemEntity = kmCsQnaEntity.getKmProductOrderItemEntity();
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return null;
        }
        String prodName = kmProductEntity.getProdName();
        if ( prodName == null ) {
            return null;
        }
        return prodName;
    }

    private int articleEntityKmProductOrderItemEntityKmProductEntityProdNo(KmCsQnaEntity kmCsQnaEntity) {
        if ( kmCsQnaEntity == null ) {
            return 0;
        }
        KmProductOrderItemEntity kmProductOrderItemEntity = kmCsQnaEntity.getKmProductOrderItemEntity();
        if ( kmProductOrderItemEntity == null ) {
            return 0;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return 0;
        }
        int prodNo = kmProductEntity.getProdNo();
        return prodNo;
    }

    protected KmCsCateEntity kmCsQnaDTOToKmCsCateEntity(KmCsQnaDTO kmCsQnaDTO) {
        if ( kmCsQnaDTO == null ) {
            return null;
        }

        KmCsCateEntityBuilder kmCsCateEntity = KmCsCateEntity.builder();

        kmCsCateEntity.cateName( kmCsQnaDTO.getCateName() );
        kmCsCateEntity.cate( kmCsQnaDTO.getCate() );

        return kmCsCateEntity.build();
    }

    protected KmCsTypeEntity kmCsQnaDTOToKmCsTypeEntity(KmCsQnaDTO kmCsQnaDTO) {
        if ( kmCsQnaDTO == null ) {
            return null;
        }

        KmCsTypeEntityBuilder kmCsTypeEntity = KmCsTypeEntity.builder();

        kmCsTypeEntity.typeName( kmCsQnaDTO.getTypeName() );
        kmCsTypeEntity.type( kmCsQnaDTO.getType() );

        return kmCsTypeEntity.build();
    }

    protected KmProductEntity kmCsQnaDTOToKmProductEntity(KmCsQnaDTO kmCsQnaDTO) {
        if ( kmCsQnaDTO == null ) {
            return null;
        }

        KmProductEntityBuilder kmProductEntity = KmProductEntity.builder();

        kmProductEntity.prodName( kmCsQnaDTO.getProdName() );
        kmProductEntity.prodNo( kmCsQnaDTO.getProdNo() );

        return kmProductEntity.build();
    }

    protected KmProductOrderItemEntity kmCsQnaDTOToKmProductOrderItemEntity(KmCsQnaDTO kmCsQnaDTO) {
        if ( kmCsQnaDTO == null ) {
            return null;
        }

        KmProductOrderItemEntityBuilder kmProductOrderItemEntity = KmProductOrderItemEntity.builder();

        kmProductOrderItemEntity.kmProductEntity( kmCsQnaDTOToKmProductEntity( kmCsQnaDTO ) );
        kmProductOrderItemEntity.orderItemId( kmCsQnaDTO.getOrderItemId() );

        return kmProductOrderItemEntity.build();
    }
}
