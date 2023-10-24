package com.example.kmarket.mapper.cs;


import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.entity.cs.KmCsQnaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KmCsQnaMapper {

    @Mapping(source = "kmCsCateEntity.cateName", target = "cateName")
    @Mapping(source = "kmCsCateEntity.cate", target = "cate")
    @Mapping(source = "kmCsTypeEntity.typeName", target = "typeName")
    @Mapping(source = "kmCsTypeEntity.type", target = "type")
    @Mapping(source = "kmProductOrderItemEntity.orderItemId", target = "orderItemId")
    @Mapping(source = "kmProductOrderItemEntity.kmProductEntity.prodName", target = "prodName")
    @Mapping(source = "kmProductOrderItemEntity.kmProductEntity.prodNo", target = "prodNo")
    public KmCsQnaDTO toDTO(KmCsQnaEntity articleEntity);

    @Mapping(source = "cateName", target = "kmCsCateEntity.cateName")
    @Mapping(source = "cate", target = "kmCsCateEntity.cate")
    @Mapping(source = "typeName", target = "kmCsTypeEntity.typeName")
    @Mapping(source = "type", target = "kmCsTypeEntity.type")
    @Mapping(source = "orderItemId", target = "kmProductOrderItemEntity.orderItemId")
    @Mapping(source = "prodName", target = "kmProductOrderItemEntity.kmProductEntity.prodName")
    @Mapping(source = "prodNo", target = "kmProductOrderItemEntity.kmProductEntity.prodNo")
    public KmCsQnaEntity toEntity(KmCsQnaDTO articleDTO);
}

