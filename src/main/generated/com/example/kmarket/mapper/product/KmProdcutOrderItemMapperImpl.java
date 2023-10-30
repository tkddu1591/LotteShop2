package com.example.kmarket.mapper.product;

import com.example.kmarket.dto.product.KmProductOrderItemDTO;
import com.example.kmarket.dto.product.KmProductOrderItemDTO.KmProductOrderItemDTOBuilder;
import com.example.kmarket.entity.member.KmMemberEntity;
import com.example.kmarket.entity.member.KmMemberEntity.KmMemberEntityBuilder;
import com.example.kmarket.entity.product.KmProductEntity;
import com.example.kmarket.entity.product.KmProductEntity.KmProductEntityBuilder;
import com.example.kmarket.entity.product.KmProductOrderEntity;
import com.example.kmarket.entity.product.KmProductOrderEntity.KmProductOrderEntityBuilder;
import com.example.kmarket.entity.product.KmProductOrderItemEntity;
import com.example.kmarket.entity.product.KmProductOrderItemEntity.KmProductOrderItemEntityBuilder;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T10:50:44+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class KmProdcutOrderItemMapperImpl implements KmProdcutOrderItemMapper {

    @Override
    public KmProductOrderItemDTO toDTO(KmProductOrderItemEntity articleEntity) {
        if ( articleEntity == null ) {
            return null;
        }

        KmProductOrderItemDTOBuilder kmProductOrderItemDTO = KmProductOrderItemDTO.builder();

        kmProductOrderItemDTO.ordNo( articleEntityKmProductOrderEntityOrdNo( articleEntity ) );
        kmProductOrderItemDTO.ordCompleteDate( articleEntityKmProductOrderEntityOrdCompleteDate( articleEntity ) );
        kmProductOrderItemDTO.ordDate( articleEntityKmProductOrderEntityOrdDate( articleEntity ) );
        kmProductOrderItemDTO.ordComplete( articleEntityKmProductOrderEntityOrdComplete( articleEntity ) );
        kmProductOrderItemDTO.recipComment( articleEntityKmProductOrderEntityRecipComment( articleEntity ) );
        kmProductOrderItemDTO.recipName( articleEntityKmProductOrderEntityRecipName( articleEntity ) );
        kmProductOrderItemDTO.recipAddr1( articleEntityKmProductOrderEntityRecipAddr1( articleEntity ) );
        kmProductOrderItemDTO.recipHp( articleEntityKmProductOrderEntityRecipHp( articleEntity ) );
        kmProductOrderItemDTO.recipAddr2( articleEntityKmProductOrderEntityRecipAddr2( articleEntity ) );
        kmProductOrderItemDTO.recipZip( articleEntityKmProductOrderEntityRecipZip( articleEntity ) );
        kmProductOrderItemDTO.prodNo( articleEntityKmProductEntityProdNo( articleEntity ) );
        kmProductOrderItemDTO.thumb1( articleEntityKmProductEntityThumb1( articleEntity ) );
        kmProductOrderItemDTO.prodName( articleEntityKmProductEntityProdName( articleEntity ) );
        kmProductOrderItemDTO.descript( articleEntityKmProductEntityDescript( articleEntity ) );
        kmProductOrderItemDTO.seller( articleEntityKmProductEntityMemberEntityUid( articleEntity ) );
        kmProductOrderItemDTO.company( articleEntityKmProductEntityMemberEntityCompany( articleEntity ) );
        kmProductOrderItemDTO.ceo( articleEntityKmProductEntityMemberEntityCeo( articleEntity ) );
        kmProductOrderItemDTO.bizRegNum( articleEntityKmProductEntityMemberEntityBizRegNum( articleEntity ) );
        kmProductOrderItemDTO.tel( articleEntityKmProductEntityMemberEntityTel( articleEntity ) );
        kmProductOrderItemDTO.fax( articleEntityKmProductEntityMemberEntityFax( articleEntity ) );
        kmProductOrderItemDTO.level( articleEntityKmProductEntityMemberEntityLevel( articleEntity ) );
        kmProductOrderItemDTO.email( articleEntityKmProductEntityMemberEntityEmail( articleEntity ) );
        kmProductOrderItemDTO.orderItemId( articleEntity.getOrderItemId() );
        kmProductOrderItemDTO.count( articleEntity.getCount() );
        kmProductOrderItemDTO.price( articleEntity.getPrice() );
        kmProductOrderItemDTO.discount( articleEntity.getDiscount() );
        kmProductOrderItemDTO.point( articleEntity.getPoint() );
        kmProductOrderItemDTO.delivery( articleEntity.getDelivery() );
        kmProductOrderItemDTO.total( articleEntity.getTotal() );

        return kmProductOrderItemDTO.build();
    }

    @Override
    public KmProductOrderItemEntity toEntity(KmProductOrderItemDTO articleDTO) {
        if ( articleDTO == null ) {
            return null;
        }

        KmProductOrderItemEntityBuilder kmProductOrderItemEntity = KmProductOrderItemEntity.builder();

        kmProductOrderItemEntity.kmProductOrderEntity( kmProductOrderItemDTOToKmProductOrderEntity( articleDTO ) );
        kmProductOrderItemEntity.kmProductEntity( kmProductOrderItemDTOToKmProductEntity( articleDTO ) );
        kmProductOrderItemEntity.orderItemId( articleDTO.getOrderItemId() );
        kmProductOrderItemEntity.count( articleDTO.getCount() );
        kmProductOrderItemEntity.price( articleDTO.getPrice() );
        kmProductOrderItemEntity.discount( articleDTO.getDiscount() );
        kmProductOrderItemEntity.point( articleDTO.getPoint() );
        kmProductOrderItemEntity.delivery( articleDTO.getDelivery() );
        kmProductOrderItemEntity.total( articleDTO.getTotal() );

        return kmProductOrderItemEntity.build();
    }

    private int articleEntityKmProductOrderEntityOrdNo(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return 0;
        }
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderItemEntity.getKmProductOrderEntity();
        if ( kmProductOrderEntity == null ) {
            return 0;
        }
        int ordNo = kmProductOrderEntity.getOrdNo();
        return ordNo;
    }

    private LocalDateTime articleEntityKmProductOrderEntityOrdCompleteDate(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderItemEntity.getKmProductOrderEntity();
        if ( kmProductOrderEntity == null ) {
            return null;
        }
        LocalDateTime ordCompleteDate = kmProductOrderEntity.getOrdCompleteDate();
        if ( ordCompleteDate == null ) {
            return null;
        }
        return ordCompleteDate;
    }

    private LocalDateTime articleEntityKmProductOrderEntityOrdDate(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderItemEntity.getKmProductOrderEntity();
        if ( kmProductOrderEntity == null ) {
            return null;
        }
        LocalDateTime ordDate = kmProductOrderEntity.getOrdDate();
        if ( ordDate == null ) {
            return null;
        }
        return ordDate;
    }

    private int articleEntityKmProductOrderEntityOrdComplete(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return 0;
        }
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderItemEntity.getKmProductOrderEntity();
        if ( kmProductOrderEntity == null ) {
            return 0;
        }
        int ordComplete = kmProductOrderEntity.getOrdComplete();
        return ordComplete;
    }

    private String articleEntityKmProductOrderEntityRecipComment(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderItemEntity.getKmProductOrderEntity();
        if ( kmProductOrderEntity == null ) {
            return null;
        }
        String recipComment = kmProductOrderEntity.getRecipComment();
        if ( recipComment == null ) {
            return null;
        }
        return recipComment;
    }

    private String articleEntityKmProductOrderEntityRecipName(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderItemEntity.getKmProductOrderEntity();
        if ( kmProductOrderEntity == null ) {
            return null;
        }
        String recipName = kmProductOrderEntity.getRecipName();
        if ( recipName == null ) {
            return null;
        }
        return recipName;
    }

    private String articleEntityKmProductOrderEntityRecipAddr1(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderItemEntity.getKmProductOrderEntity();
        if ( kmProductOrderEntity == null ) {
            return null;
        }
        String recipAddr1 = kmProductOrderEntity.getRecipAddr1();
        if ( recipAddr1 == null ) {
            return null;
        }
        return recipAddr1;
    }

    private String articleEntityKmProductOrderEntityRecipHp(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderItemEntity.getKmProductOrderEntity();
        if ( kmProductOrderEntity == null ) {
            return null;
        }
        String recipHp = kmProductOrderEntity.getRecipHp();
        if ( recipHp == null ) {
            return null;
        }
        return recipHp;
    }

    private String articleEntityKmProductOrderEntityRecipAddr2(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderItemEntity.getKmProductOrderEntity();
        if ( kmProductOrderEntity == null ) {
            return null;
        }
        String recipAddr2 = kmProductOrderEntity.getRecipAddr2();
        if ( recipAddr2 == null ) {
            return null;
        }
        return recipAddr2;
    }

    private String articleEntityKmProductOrderEntityRecipZip(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderItemEntity.getKmProductOrderEntity();
        if ( kmProductOrderEntity == null ) {
            return null;
        }
        String recipZip = kmProductOrderEntity.getRecipZip();
        if ( recipZip == null ) {
            return null;
        }
        return recipZip;
    }

    private int articleEntityKmProductEntityProdNo(KmProductOrderItemEntity kmProductOrderItemEntity) {
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

    private String articleEntityKmProductEntityThumb1(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return null;
        }
        String thumb1 = kmProductEntity.getThumb1();
        if ( thumb1 == null ) {
            return null;
        }
        return thumb1;
    }

    private String articleEntityKmProductEntityProdName(KmProductOrderItemEntity kmProductOrderItemEntity) {
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

    private String articleEntityKmProductEntityDescript(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return null;
        }
        String descript = kmProductEntity.getDescript();
        if ( descript == null ) {
            return null;
        }
        return descript;
    }

    private String articleEntityKmProductEntityMemberEntityUid(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
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

    private String articleEntityKmProductEntityMemberEntityCompany(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
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

    private String articleEntityKmProductEntityMemberEntityCeo(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
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

    private String articleEntityKmProductEntityMemberEntityBizRegNum(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
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

    private String articleEntityKmProductEntityMemberEntityTel(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
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

    private String articleEntityKmProductEntityMemberEntityFax(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
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

    private int articleEntityKmProductEntityMemberEntityLevel(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return 0;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return 0;
        }
        KmMemberEntity memberEntity = kmProductEntity.getMemberEntity();
        if ( memberEntity == null ) {
            return 0;
        }
        int level = memberEntity.getLevel();
        return level;
    }

    private String articleEntityKmProductEntityMemberEntityEmail(KmProductOrderItemEntity kmProductOrderItemEntity) {
        if ( kmProductOrderItemEntity == null ) {
            return null;
        }
        KmProductEntity kmProductEntity = kmProductOrderItemEntity.getKmProductEntity();
        if ( kmProductEntity == null ) {
            return null;
        }
        KmMemberEntity memberEntity = kmProductEntity.getMemberEntity();
        if ( memberEntity == null ) {
            return null;
        }
        String email = memberEntity.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }

    protected KmProductOrderEntity kmProductOrderItemDTOToKmProductOrderEntity(KmProductOrderItemDTO kmProductOrderItemDTO) {
        if ( kmProductOrderItemDTO == null ) {
            return null;
        }

        KmProductOrderEntityBuilder kmProductOrderEntity = KmProductOrderEntity.builder();

        kmProductOrderEntity.ordNo( kmProductOrderItemDTO.getOrdNo() );
        kmProductOrderEntity.ordCompleteDate( kmProductOrderItemDTO.getOrdCompleteDate() );
        kmProductOrderEntity.ordDate( kmProductOrderItemDTO.getOrdDate() );
        kmProductOrderEntity.ordComplete( kmProductOrderItemDTO.getOrdComplete() );
        kmProductOrderEntity.recipComment( kmProductOrderItemDTO.getRecipComment() );
        kmProductOrderEntity.recipName( kmProductOrderItemDTO.getRecipName() );
        kmProductOrderEntity.recipAddr1( kmProductOrderItemDTO.getRecipAddr1() );
        kmProductOrderEntity.recipHp( kmProductOrderItemDTO.getRecipHp() );
        kmProductOrderEntity.recipAddr2( kmProductOrderItemDTO.getRecipAddr2() );
        kmProductOrderEntity.recipZip( kmProductOrderItemDTO.getRecipZip() );

        return kmProductOrderEntity.build();
    }

    protected KmMemberEntity kmProductOrderItemDTOToKmMemberEntity(KmProductOrderItemDTO kmProductOrderItemDTO) {
        if ( kmProductOrderItemDTO == null ) {
            return null;
        }

        KmMemberEntityBuilder kmMemberEntity = KmMemberEntity.builder();

        kmMemberEntity.uid( kmProductOrderItemDTO.getSeller() );
        kmMemberEntity.company( kmProductOrderItemDTO.getCompany() );
        kmMemberEntity.ceo( kmProductOrderItemDTO.getCeo() );
        kmMemberEntity.bizRegNum( kmProductOrderItemDTO.getBizRegNum() );
        kmMemberEntity.tel( kmProductOrderItemDTO.getTel() );
        kmMemberEntity.fax( kmProductOrderItemDTO.getFax() );
        kmMemberEntity.email( kmProductOrderItemDTO.getEmail() );

        return kmMemberEntity.build();
    }

    protected KmProductEntity kmProductOrderItemDTOToKmProductEntity(KmProductOrderItemDTO kmProductOrderItemDTO) {
        if ( kmProductOrderItemDTO == null ) {
            return null;
        }

        KmProductEntityBuilder kmProductEntity = KmProductEntity.builder();

        kmProductEntity.memberEntity( kmProductOrderItemDTOToKmMemberEntity( kmProductOrderItemDTO ) );
        kmProductEntity.prodNo( kmProductOrderItemDTO.getProdNo() );
        kmProductEntity.thumb1( kmProductOrderItemDTO.getThumb1() );
        kmProductEntity.prodName( kmProductOrderItemDTO.getProdName() );
        kmProductEntity.descript( kmProductOrderItemDTO.getDescript() );

        return kmProductEntity.build();
    }
}
