package com.example.kmarket.mapper.admin;

import com.example.kmarket.dto.KmProductCartDTO;
import com.example.kmarket.dto.KmProductDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KmProductMapper {

    public int insertProduct(KmProductDTO dto);
    public KmProductDTO selectProduct(int prodNo);
    public List<KmProductDTO> selectProducts();
    public int updateProduct(KmProductDTO dto);
    public int deleteProduct(int prodNo);


}
