package com.example.kmarket.service.product;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.dto.product.KmProductOrderItemDTO;
import com.example.kmarket.dto.product.KmProductReviewDTO;
import com.example.kmarket.entity.product.KmProductOrderItemEntity;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import com.example.kmarket.mapper.product.KmProdcutOrderItemMapper;
import com.example.kmarket.repository.product.KmProductOrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public List<KmProductOrderItemDTO> findByUidByOrdNo(int ordNo, String ordUid) {
        return kmProductOrderItemRepository.findByKmProductOrderEntity_OrdNoAndKmProductOrderEntity_OrdUid(ordNo, ordUid).stream().map(kmProdcutOrderItemMapper::toDTO).toList();
    }
    public PageResponseDTO findByUid(PageRequestDTO pageRequestDTO) {

        //Order By 정렬할 컬럼명 Desc
        //getPageableDesc 내림차순 getPageableAsc 오름차순 ("정렬할 컬럼명")
        //pg , size 가공해서 같이 ordet by랑 섞어줌
        Pageable pageable = pageRequestDTO.getPageableDesc("orderItemId");

        //Page
        Page<KmProductOrderItemEntity> result = null;
        //dtoList
        //findBy머시기 by뒤가 where절이라고 보면 됨니다.

        if(pageRequestDTO.getStartDate()==null) {
            result = kmProductOrderItemRepository.findByKmProductOrderEntity_OrdUid(pageRequestDTO.getMemberUid(), pageable);
        }else {
            result = kmProductOrderItemRepository.findByKmProductOrderEntity_OrdUidAndKmProductOrderEntity_OrdDateBetween(pageRequestDTO.getMemberUid(), pageRequestDTO.getStartDate(), pageRequestDTO.getEndDate(), pageable);
        }

        result.getContent(); // Entity
        result.getTotalElements(); // 숫자 형이 double -> int변경해줘야함

        // content를 dto로 변환 해주는 역할
        List<KmProductOrderItemDTO> dtoList = result.getContent()
                .stream()
                .map(kmProdcutOrderItemMapper::toDTO)
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .orderItemDTOS(dtoList)
                .total(totalElement)
                .build();
    }

    public int countByUid(String memberUid) {
        return kmProductOrderItemRepository.countByKmProductOrderEntity_OrdUidAndKmProductOrderEntity_OrdCompleteBetween(memberUid, 0,1);
    }
}
