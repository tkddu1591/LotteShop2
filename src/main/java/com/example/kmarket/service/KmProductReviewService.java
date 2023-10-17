package com.example.kmarket.service;

import com.example.kmarket.dto.KmProductDTO;
import com.example.kmarket.dto.KmProductReviewDTO;
import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.entity.KmProductEntity;
import com.example.kmarket.entity.KmProductReviewEntity;
import com.example.kmarket.mapper.KmProductReviewMapper;
import com.example.kmarket.repository.KmProductReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KmProductReviewService {
    @Autowired
    private KmProductReviewRepository kmProductReviewRepository;

    @Autowired
    private KmProductReviewMapper kmProductReviewMapper;


    public int countProdNo(int prodNo) {
        return kmProductReviewRepository.countByProdNo(prodNo);
    }
    public PageResponseDTO findByProducts(PageRequestDTO pageRequestDTO) {


        //카테고리 10~ 1000까지 cate1, 카테고리 1000~ cate2 10 이하는 존재하지 않음
        //tpye값으로 정렬 처리
        Pageable pageable = null;
        pageable = pageRequestDTO.getPageableDesc("revNo");


        Page<KmProductReviewEntity> result = null;

        //카테고리 확인 -> 서치 확인 -> 아무것도 없으면 findAll
        result = kmProductReviewRepository.findByProdNo(pageRequestDTO.getProdNo(), pageable);
        List<KmProductReviewDTO> dtoList = result.getContent()
                .stream()
                .map(kmProductReviewMapper::toDTO)
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .reviewDtoList(dtoList)
                .total(totalElement)
                .build();
    }

}
