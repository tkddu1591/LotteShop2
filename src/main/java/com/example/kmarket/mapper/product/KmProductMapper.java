package com.example.kmarket.mapper.product;


import com.example.kmarket.dto.product.KmProductDTO;
import com.example.kmarket.entity.product.KmProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface KmProductMapper {
    @Mapping(source = "memberEntity.uid", target = "seller")
    @Mapping(source = "memberEntity.company", target = "company")
    @Mapping(source = "memberEntity.ceo", target = "ceo")
    @Mapping(source = "memberEntity.bizRegNum", target = "bizRegNum")
    @Mapping(source = "memberEntity.tel", target = "tel")
    @Mapping(source = "memberEntity.fax", target = "fax")
    public KmProductDTO toDTO(KmProductEntity articleEntity);

    @Mapping(target = "memberEntity.uid", source = "seller")
    @Mapping(target = "memberEntity.company", source = "company")
    @Mapping(target = "memberEntity.ceo", source = "ceo")
    @Mapping(target = "memberEntity.bizRegNum", source = "bizRegNum")
    @Mapping(target = "memberEntity.tel", source = "tel")
    @Mapping(target = "memberEntity.fax", source = "fax")
    public KmProductEntity toEntity(KmProductDTO articleDTO);
}

