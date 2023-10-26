package com.example.kmarket.service.product;

import com.example.kmarket.dto.product.KmProductOrderDTO;
import com.example.kmarket.entity.product.KmProductOrderEntity;
import com.example.kmarket.mapper.product.KmProductOrderMapper;
import com.example.kmarket.repository.product.KmProductOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class KmProductOrderService {
    @Autowired
    KmProductOrderRepository kmProductOrderRepository;
    @Autowired
    KmProductOrderMapper kmProductOrderMapper;

    public void save(KmProductOrderDTO kmProductOrderDTO) {
        kmProductOrderDTO.setOrdDate(LocalDateTime.now());
        kmProductOrderRepository.save(kmProductOrderMapper.toEntity(kmProductOrderDTO));
    }

    public int listOrderNo() {
        return kmProductOrderRepository.findFirstByOrderByOrdNoDesc().getOrdNo();
    }


    public KmProductOrderDTO findByLast() {
        return kmProductOrderMapper.toDTO(kmProductOrderRepository.findFirstByOrderByOrdNoDesc());
    }

    public KmProductOrderDTO findByOrdNo(String uid) {
        return kmProductOrderMapper.toDTO(kmProductOrderRepository.findTopByOrdUidOrderByOrdNoDesc(uid));
    }

    public int countByUid(String memberUid) {
        return kmProductOrderRepository.countByOrdUidAndOrdCompleteBetween(memberUid, 0, 1);
    }

    public void delete(int ordNo) {
        Optional<KmProductOrderEntity> optionalEntity = kmProductOrderRepository.findById(ordNo);

        if (optionalEntity.isPresent()) {
            KmProductOrderEntity kmProductOrderEntity = optionalEntity.get();
            kmProductOrderEntity.setOrdComplete(3);
            kmProductOrderRepository.save(kmProductOrderEntity);
        }

    }

    public void receiveCheck(@RequestBody KmProductOrderDTO orderReceive) {
        log.info(orderReceive.toString());
        KmProductOrderEntity orderDTO = kmProductOrderRepository.findById(orderReceive.getOrdNo()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
        orderDTO.setOrdComplete(orderReceive.getOrdComplete());
        kmProductOrderRepository.save(orderDTO);
    }
}
