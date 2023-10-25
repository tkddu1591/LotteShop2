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
    @Mapping(source = "kmProductEntity.prodNo", target = "prodNo")
    @Mapping(source = "kmProductEntity.thumb1", target = "thumb1")
    @Mapping(source = "kmProductEntity.prodName", target = "prodName")
    @Mapping(source = "kmProductEntity.descript", target = "descript")
    @Mapping(source = "kmProductEntity.company", target = "company")
    public KmProductOrderItemDTO toDTO(KmProductOrderItemEntity articleEntity);

    @Mapping(source = "ordNo", target = "kmProductOrderEntity.ordNo")
    @Mapping(source = "ordCompleteDate", target = "kmProductOrderEntity.ordCompleteDate")
    @Mapping(source = "ordDate", target = "kmProductOrderEntity.ordDate")
    @Mapping(source = "ordComplete", target = "kmProductOrderEntity.ordComplete")
    @Mapping(source = "prodNo", target = "kmProductEntity.prodNo")
    @Mapping(source = "thumb1", target = "kmProductEntity.thumb1")
    @Mapping(source = "prodName", target = "kmProductEntity.prodName")
    @Mapping(source = "descript", target = "kmProductEntity.descript")
    @Mapping(source = "company", target = "kmProductEntity.company")
    public KmProductOrderItemEntity toEntity(KmProductOrderItemDTO articleDTO);
}

