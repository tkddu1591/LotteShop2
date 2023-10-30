package com.example.kmarket.mapper.product;


import com.example.kmarket.dto.product.KmProductOrderItemDTO;
import com.example.kmarket.entity.product.KmProductOrderItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KmProdcutOrderItemMapper {
    @Mapping(source = "kmProductOrderEntity.ordNo", target = "ordNo")
    @Mapping(source = "kmProductOrderEntity.ordCompleteDate", target = "ordCompleteDate")
    @Mapping(source = "kmProductOrderEntity.ordDate", target = "ordDate")
    @Mapping(source = "kmProductOrderEntity.ordComplete", target = "ordComplete")
    @Mapping(source = "kmProductOrderEntity.recipComment", target = "recipComment")
    @Mapping(source = "kmProductOrderEntity.recipName", target = "recipName")
    @Mapping(source = "kmProductOrderEntity.recipAddr1", target = "recipAddr1")
    @Mapping(source = "kmProductOrderEntity.recipHp", target = "recipHp")
    @Mapping(source = "kmProductOrderEntity.recipAddr2", target = "recipAddr2")
    @Mapping(source = "kmProductOrderEntity.recipZip", target = "recipZip")
    @Mapping(source = "kmProductEntity.prodNo", target = "prodNo")
    @Mapping(source = "kmProductEntity.thumb1", target = "thumb1")
    @Mapping(source = "kmProductEntity.prodName", target = "prodName")
    @Mapping(source = "kmProductEntity.descript", target = "descript")

    @Mapping(source = "kmProductEntity.memberEntity.uid", target = "seller")
    @Mapping(source = "kmProductEntity.memberEntity.company", target = "company")
    @Mapping(source = "kmProductEntity.memberEntity.ceo", target = "ceo")
    @Mapping(source = "kmProductEntity.memberEntity.bizRegNum", target = "bizRegNum")
    @Mapping(source = "kmProductEntity.memberEntity.tel", target = "tel")
    @Mapping(source = "kmProductEntity.memberEntity.fax", target = "fax")
    @Mapping(source = "kmProductEntity.memberEntity.level", target = "level")
    @Mapping(source = "kmProductEntity.memberEntity.email", target = "email")
    public KmProductOrderItemDTO toDTO(KmProductOrderItemEntity articleEntity);

    @Mapping(source = "ordNo", target = "kmProductOrderEntity.ordNo")
    @Mapping(source = "ordCompleteDate", target = "kmProductOrderEntity.ordCompleteDate")
    @Mapping(source = "ordDate", target = "kmProductOrderEntity.ordDate")
    @Mapping(source = "ordComplete", target = "kmProductOrderEntity.ordComplete")
    @Mapping(target = "kmProductOrderEntity.recipComment", source= "recipComment")
    @Mapping(target = "kmProductOrderEntity.recipName", source= "recipName")
    @Mapping(target = "kmProductOrderEntity.recipAddr1", source= "recipAddr1")
    @Mapping(target = "kmProductOrderEntity.recipHp", source= "recipHp")
    @Mapping(target = "kmProductOrderEntity.recipAddr2", source= "recipAddr2")
    @Mapping(target = "kmProductOrderEntity.recipZip", source= "recipZip")


    @Mapping(source = "prodNo", target = "kmProductEntity.prodNo")
    @Mapping(source = "thumb1", target = "kmProductEntity.thumb1")
    @Mapping(source = "prodName", target = "kmProductEntity.prodName")
    @Mapping(source = "descript", target = "kmProductEntity.descript")
    @Mapping(target = "kmProductEntity.memberEntity.uid", source = "seller")
    @Mapping(target = "kmProductEntity.memberEntity.company", source = "company")
    @Mapping(target = "kmProductEntity.memberEntity.ceo", source = "ceo")
    @Mapping(target = "kmProductEntity.memberEntity.bizRegNum", source = "bizRegNum")
    @Mapping(target = "kmProductEntity.memberEntity.tel", source = "tel")
    @Mapping(target = "kmProductEntity.memberEntity.fax", source = "fax")
    @Mapping(target = "kmProductEntity.memberEntity.email", source = "email")
    public KmProductOrderItemEntity toEntity(KmProductOrderItemDTO articleDTO);
}

