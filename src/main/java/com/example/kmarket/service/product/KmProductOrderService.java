package com.example.kmarket.service.product;

import com.example.kmarket.dto.member.KmMemberDTO;
import com.example.kmarket.dto.member.KmMemberPointDTO;
import com.example.kmarket.dto.product.KmProductOrderDTO;
import com.example.kmarket.entity.member.KmMemberEntity;
import com.example.kmarket.entity.member.KmMemberPointEntity;
import com.example.kmarket.entity.product.KmProductOrderEntity;
import com.example.kmarket.mapper.member.KmMemberMapper;
import com.example.kmarket.mapper.member.KmMemberPointMapper;
import com.example.kmarket.mapper.product.KmProductOrderMapper;
import com.example.kmarket.repository.member.KmMemberPointRepository;
import com.example.kmarket.repository.member.KmMemberRepository;
import com.example.kmarket.repository.product.KmProductOrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    KmMemberRepository kmMemberRepository;
    @Autowired
    KmMemberMapper kmMemberMapper;

    @Autowired
    KmMemberPointRepository kmMemberPointRepository;
    @Autowired
    KmMemberPointMapper kmMemberPointMapper;
    public void save(KmProductOrderDTO kmProductOrderDTO) {
        kmProductOrderDTO.setOrdDate(LocalDateTime.now());
        //멤버 포인트 변환
        KmMemberEntity kmMemberEntity = kmMemberRepository.findByUid(kmProductOrderDTO.getOrdUid()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));;
        kmMemberEntity.setPoint(kmProductOrderDTO.getSavePoint()-kmProductOrderDTO.getUsedPoint()+kmMemberEntity.getPoint());
        kmMemberRepository.save(kmMemberEntity);
        KmMemberPointDTO kmMemberPointDTO = new KmMemberPointDTO();

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
        KmProductOrderEntity orderDTO = kmProductOrderRepository.findById(orderReceive.getOrdNo()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
        orderDTO.setOrdComplete(orderReceive.getOrdComplete());
        orderDTO.setOrdCompleteDate(LocalDateTime.now());
        kmProductOrderRepository.save(orderDTO);
    }

    public void newSave() {
        KmProductOrderEntity kmProductOrderEntity = kmProductOrderRepository.findFirstByOrderByOrdNoDesc();
        KmProductOrderDTO kmProductOrderDTO = kmProductOrderMapper.toDTO(kmProductOrderEntity);
        KmMemberPointDTO kmMemberPointDTO = new KmMemberPointDTO();
        if(kmProductOrderDTO.getSavePoint() != 0) {
            kmMemberPointDTO.setPoint(kmProductOrderDTO.getSavePoint());
            kmMemberPointDTO.setUid(kmProductOrderDTO.getOrdUid());
            kmMemberPointDTO.setPointDate(LocalDateTime.now());
            kmMemberPointDTO.setComment("상품 구매 확정 포인트 지급");
            kmMemberPointDTO.setOrdNo(kmProductOrderDTO.getOrdNo());
            log.error(kmMemberPointDTO.toString());
            kmMemberPointRepository.save(kmMemberPointMapper.toEntity(kmMemberPointDTO));
        }
        if(kmProductOrderDTO.getUsedPoint() != 0) {
            kmMemberPointDTO.setPoint(-kmProductOrderDTO.getUsedPoint());
            kmMemberPointDTO.setUid(kmProductOrderDTO.getOrdUid());
            kmMemberPointDTO.setPointDate(LocalDateTime.now());
            kmMemberPointDTO.setComment("상품 구매 포인트 사용");
            kmMemberPointDTO.setOrdNo(kmProductOrderDTO.getOrdNo());
            log.error(kmMemberPointDTO.toString());
            kmMemberPointRepository.save(kmMemberPointMapper.toEntity(kmMemberPointDTO));
        }

    }
}
