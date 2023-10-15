package com.example.kmarket.service;

import com.example.kmarket.dto.KmProductOrderDTO;
import com.example.kmarket.dto.KmProductOrderItemDTO;
import com.example.kmarket.entity.KmProductOrderItemEntity;
import com.example.kmarket.mapper.KmProdcutOrderItemMapper;
import com.example.kmarket.repository.KmProductOrderItemRepository;
import com.example.kmarket.repository.KmProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KmProductOrderItemService {
    @Autowired
    private KmProductOrderItemRepository kmProductOrderItemRepository;
    @Autowired
    private KmProdcutOrderItemMapper kmProdcutOrderItemMapper;

    public List<KmProductOrderItemDTO> saveOrderItem(int ordNo){
        return kmProductOrderItemRepository.findByKmProductOrderEntity_OrdNo(ordNo).stream().map(kmProdcutOrderItemMapper::toDTO).toList();
    }

    public void save(List<KmProductOrderItemDTO> orderEnd) {
        for(KmProductOrderItemDTO order : orderEnd){

            kmProductOrderItemRepository.save(kmProdcutOrderItemMapper.toEntity(order));
        }
    }
}
