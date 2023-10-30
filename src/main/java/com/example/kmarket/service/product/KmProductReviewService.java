package com.example.kmarket.service.product;

import com.example.kmarket.dto.product.KmProductReviewDTO;
import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.entity.product.KmProductEntity;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import com.example.kmarket.mapper.product.KmProductMapper;
import com.example.kmarket.mapper.product.KmProductReviewMapper;
import com.example.kmarket.repository.product.KmProductRepository;
import com.example.kmarket.repository.product.KmProductReviewRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KmProductReviewService {
    @Autowired
    private KmProductReviewRepository kmProductReviewRepository;

    @Autowired
    private KmProductReviewMapper kmProductReviewMapper;

    @Autowired
    private KmProductRepository kmProductRepository;
    @Autowired
    private KmProductMapper kmProductMapper;

    public int countProdNo(int prodNo) {
        return kmProductReviewRepository.countByKmProductEntity_ProdNo(prodNo);
    }
    public void save(KmProductReviewDTO kmProductReviewDTO) {
        KmProductReviewEntity kmProductReviewEntity = kmProductReviewMapper.toEntity(kmProductReviewDTO);
        KmProductEntity kmProductEntity= kmProductRepository.findByProdNo(kmProductReviewDTO.getProdNo());
        kmProductEntity.setReview(kmProductEntity.getReview()+1);
        kmProductEntity.setScore(kmProductReviewRepository.averageByRatingKmProductEntity_ProdNo(kmProductEntity.getProdNo()));
        log.info(String.valueOf(kmProductReviewRepository.averageByRatingKmProductEntity_ProdNo(kmProductEntity.getProdNo())));
        kmProductReviewRepository.save(kmProductReviewEntity);
        kmProductRepository.save(kmProductEntity);

    }
    public PageResponseDTO findByProducts(PageRequestDTO pageRequestDTO) {


        //카테고리 10~ 1000까지 cate1, 카테고리 1000~ cate2 10 이하는 존재하지 않음
        //tpye값으로 정렬 처리

        //Order By 정렬할 컬럼명 Desc
        //getPageableDesc 내림차순 getPageableAsc 오름차순 ("정렬할 컬럼명")
        //pg , size 가공해서 같이 ordet by랑 섞어줌
        Pageable pageable = pageRequestDTO.getPageableDesc("revNo");


        //Page
        Page<KmProductReviewEntity> result = null;
        //dtoList
        //findBy머시기 by뒤가 where절이라고 보면 됨니다.
        result = kmProductReviewRepository.findByKmProductEntity_ProdNo(pageRequestDTO.getProdNo(), pageable);

        result.getContent(); // Entity
        result.getTotalElements(); // 숫자 형이 double -> int변경해줘야함

        // content를 dto로 변환 해주는 역할
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

    public PageResponseDTO findByUid(PageRequestDTO pageRequestDTO) {

        //Order By 정렬할 컬럼명 Desc
        //getPageableDesc 내림차순 getPageableAsc 오름차순 ("정렬할 컬럼명")
        //pg , size 가공해서 같이 ordet by랑 섞어줌
        Pageable pageable = pageRequestDTO.getPageableDesc("revNo");

        //Page
        Page<KmProductReviewEntity> result = null;
        //dtoList
        //findBy머시기 by뒤가 where절이라고 보면 됨니다.
        result = kmProductReviewRepository.findByUid(pageRequestDTO.getMemberUid(), pageable);

        result.getContent(); // Entity
        result.getTotalElements(); // 숫자 형이 double -> int변경해줘야함

        // content를 dto로 변환 해주는 역할
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
