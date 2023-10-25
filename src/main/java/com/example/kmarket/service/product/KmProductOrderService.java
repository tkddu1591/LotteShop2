package com.example.kmarket.service.product;

import com.example.kmarket.dto.product.KmProductOrderDTO;
import com.example.kmarket.entity.product.KmProductOrderEntity;
import com.example.kmarket.mapper.product.KmProductOrderMapper;
import com.example.kmarket.repository.product.KmProductOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

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
    public int listOrderNo(){
        return kmProductOrderRepository.findFirstByOrderByOrdNoDesc().getOrdNo();
    }


    public KmProductOrderDTO findByLast() {
        return kmProductOrderMapper.toDTO(kmProductOrderRepository.findFirstByOrderByOrdNoDesc());
    }

    public KmProductOrderDTO findByOrdNo(String uid) {
        return kmProductOrderMapper.toDTO(kmProductOrderRepository.findTopByOrdUidOrderByOrdNoDesc(uid));
    }

    public int countByUid(String memberUid) {
        return kmProductOrderRepository.countByOrdUidAndOrdCompleteBetween(memberUid, 0,1);
    }

    public void delete(int ordNo) {
        Optional<KmProductOrderEntity> optionalEntity = kmProductOrderRepository.findById(ordNo);

        if (optionalEntity.isPresent()) {
            KmProductOrderEntity kmProductOrderEntity = optionalEntity.get();
            kmProductOrderEntity.setOrdComplete(3);
            kmProductOrderRepository.save(kmProductOrderEntity);
        }

    }
}
