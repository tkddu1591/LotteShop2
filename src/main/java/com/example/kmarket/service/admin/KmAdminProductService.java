package com.example.kmarket.service.admin;

import com.example.kmarket.dto.KmProductDTO;
import com.example.kmarket.repository.KmProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KmAdminProductService {
    @Autowired
    private KmProductRepository kmProductRepository;
    public KmProductDTO findById(int prodNo) {
        return kmProductMapper.toDTO(kmProductRepository.findById(prodNo).get());
    }
}
