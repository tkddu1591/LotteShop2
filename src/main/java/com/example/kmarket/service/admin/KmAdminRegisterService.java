package com.example.kmarket.service.admin;

import com.example.kmarket.dto.product.KmProductDTO;
import com.example.kmarket.mapper.admin.KmAdminRegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KmAdminRegisterService {

    @Autowired
    KmAdminRegisterMapper  kmAdminRegisterMapper;

    public int insertProduct(KmProductDTO dto) {
        return kmAdminRegisterMapper.insertProduct(dto);
    }

    public KmProductDTO selectProduct(int prodNo) {
        return kmAdminRegisterMapper.selectProduct(prodNo);
    }

    public List<KmProductDTO> selectProducts(){
        return kmAdminRegisterMapper.selectProducts();
    }
    public int updateProduct(KmProductDTO dto){
        return kmAdminRegisterMapper.updateProduct(dto);
    }
    public int deleteProduct(int prodNo){
        return kmAdminRegisterMapper.deleteProduct(prodNo);

    }
}
