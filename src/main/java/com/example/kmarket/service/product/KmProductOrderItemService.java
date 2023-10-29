package com.example.kmarket.service.product;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.dto.product.KmProductOrderDTO;
import com.example.kmarket.dto.product.KmProductOrderItemDTO;
import com.example.kmarket.dto.product.KmProductReviewDTO;
import com.example.kmarket.entity.product.KmProductEntity;
import com.example.kmarket.entity.product.KmProductOrderItemEntity;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import com.example.kmarket.mapper.product.KmProdcutOrderItemMapper;
import com.example.kmarket.mapper.product.KmProductMapper;
import com.example.kmarket.repository.product.KmProductOrderItemRepository;
import com.example.kmarket.repository.product.KmProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KmProductOrderItemService {
    @Autowired
    private KmProductOrderItemRepository kmProductOrderItemRepository;
    @Autowired
    private KmProdcutOrderItemMapper kmProdcutOrderItemMapper;

    @Autowired
    private KmProductRepository kmProductRepository;
    @Autowired
    private KmProductMapper kmProductMapper;
    public List<KmProductOrderItemDTO> saveOrderItem(int ordNo){
        return kmProductOrderItemRepository.findByKmProductOrderEntity_OrdNo(ordNo).stream().map(kmProdcutOrderItemMapper::toDTO).toList();
    }

    public void save(List<KmProductOrderItemDTO> orderEnd) {
        for(KmProductOrderItemDTO order : orderEnd){
            KmProductEntity kmProductEntity= kmProductRepository.findByProdNo(order.getProdNo());
            kmProductEntity.setSold(kmProductEntity.getSold()+order.getCount());
            kmProductEntity.setStock(kmProductEntity.getStock()-order.getCount());
            kmProductOrderItemRepository.save(kmProdcutOrderItemMapper.toEntity(order));
            kmProductRepository.save(kmProductEntity);
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
