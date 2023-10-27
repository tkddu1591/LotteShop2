package com.example.kmarket.service.member;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.dto.member.KmMemberPointDTO;
import com.example.kmarket.dto.product.KmProductReviewDTO;
import com.example.kmarket.entity.member.KmMemberPointEntity;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import com.example.kmarket.mapper.member.KmMemberPointMapper;
import com.example.kmarket.repository.member.KmMemberPointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KmMemberPointService {
    @Autowired
    private KmMemberPointRepository kmMemberPointRepository;
    @Autowired
    private KmMemberPointMapper kmMemberPointMapper;
    public PageResponseDTO findByUid(PageRequestDTO pageRequestDTO) {

        //Order By 정렬할 컬럼명 Desc
        //getPageableDesc 내림차순 getPageableAsc 오름차순 ("정렬할 컬럼명")
        //pg , size 가공해서 같이 ordet by랑 섞어줌
        Pageable pageable = pageRequestDTO.getPageableDesc("orderEntity.ordDate");

        //Page
        Page<KmMemberPointEntity> result = null;
        //dtoList
        //findBy머시기 by뒤가 where절이라고 보면 됨니다.
        if(pageRequestDTO.getStartDate()==null) {
            result = kmMemberPointRepository.findByUid(pageRequestDTO.getMemberUid(), pageable);
        }else {
            result = kmMemberPointRepository.findByUidAndOrderEntity_OrdDateBetween(pageRequestDTO.getMemberUid(), pageRequestDTO.getStartDate(), pageRequestDTO.getEndDate(), pageable);
        }

        result.getContent(); // Entity
        result.getTotalElements(); // 숫자 형이 double -> int변경해줘야함

        // content를 dto로 변환 해주는 역할
        List<KmMemberPointDTO> dtoList = result.getContent()
                .stream()
                .map(kmMemberPointMapper::toDTO)
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .pointDTOS(dtoList)
                .total(totalElement)
                .build();
    }


}
