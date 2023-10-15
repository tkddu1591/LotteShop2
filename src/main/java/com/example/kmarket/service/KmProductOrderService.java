package com.example.kmarket.service;

import com.example.kmarket.dto.KmProductCartDTO;
import com.example.kmarket.dto.KmProductOrderDTO;
import com.example.kmarket.dto.KmProductOrderItemDTO;
import com.example.kmarket.mapper.KmProductOrderMapper;
import com.example.kmarket.repository.KmProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KmProductOrderService {
    @Autowired
    KmProductOrderRepository kmProductOrderRepository;
    @Autowired
    KmProductOrderMapper kmProductOrderMapper;

    public void save(KmProductOrderDTO kmProductOrderDTO) {
        kmProductOrderDTO.setOrdDate(LocalDateTime.now());
        kmProductOrderRepository.save(kmProductOrderMapper.toEntity(kmProductOrderDTO));
    }
    public int listByUidOrderNo(String ordUid){
        return kmProductOrderRepository.findTopByOrdUidOrderByOrdNoDesc(ordUid);
    }
    public int listOrderNo(){
        return kmProductOrderRepository.findFirstByOrderByOrdNoDesc().getOrdNo();
    }


    public KmProductOrderDTO findByLast() {
        return kmProductOrderMapper.toDTO(kmProductOrderRepository.findFirstByOrderByOrdNoDesc());
    }

}
