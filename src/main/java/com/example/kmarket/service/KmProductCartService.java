package com.example.kmarket.service;

import com.example.kmarket.dto.KmProductCartDTO;
import com.example.kmarket.entity.KmProductCartEntity;
import com.example.kmarket.mapper.KmProductCartMapper;
import com.example.kmarket.repository.KmProductCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class KmProductCartService {
    @Autowired
    KmProductCartRepository kmProductCartRepository;
    @Autowired
    KmProductCartMapper kmProductCartMapper;

    public List<KmProductCartDTO> findByUid(String uid) {
        return kmProductCartRepository
                .findByKmMemberEntity_UidOrderByCartNoDesc(uid)
                .stream()
                .map(kmProductCartMapper::toDTO)
                .toList();
    }

    public void save(KmProductCartDTO kmProductCartDTO) {
        kmProductCartDTO.setRdate(LocalDateTime.now());
        KmProductCartEntity checkEntity = kmProductCartRepository.findKmProductCartEntityByProdNo(kmProductCartDTO.getProdNo());
        if (checkEntity != null) {
            kmProductCartDTO.setCartNo(checkEntity.getCartNo());
            kmProductCartDTO.setCount(checkEntity.getCount() + kmProductCartDTO.getCount());
            kmProductCartDTO.setTotal(checkEntity.getTotal() + kmProductCartDTO.getTotal());
            kmProductCartRepository.save(kmProductCartMapper.toEntity(kmProductCartDTO));
        } else {
            kmProductCartRepository.save(kmProductCartMapper.toEntity(kmProductCartDTO));
        }
    }
}
