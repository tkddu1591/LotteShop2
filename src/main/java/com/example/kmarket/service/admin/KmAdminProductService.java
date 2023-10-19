package com.example.kmarket.service.admin;

import com.example.kmarket.dto.KmProductDTO;
import com.example.kmarket.mapper.admin.KmProductMapper;
import com.example.kmarket.repository.KmProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KmAdminProductService {

    @Autowired
    private KmProductMapper kmProductMapper;

    public int insertProduct(KmProductDTO dto){
        return kmProductMapper.insertProduct(dto);
    }

    public KmProductDTO selectProduct(int prodNo){
        return kmProductMapper.selectProduct(prodNo);
    }
    public List<KmProductDTO> selectProducts(){
        return kmProductMapper.selectProducts();
    }
    public int updateProduct(KmProductDTO dto){
        return kmProductMapper.updateProduct(dto);
    }
    public int deleteProduct(int prodNo){
        return kmProductMapper.deleteProduct(prodNo);
    }
}
