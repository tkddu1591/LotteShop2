package com.example.kmarket.service.product;

import com.example.kmarket.dto.product.KmProductDTO;
import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.entity.product.KmProductEntity;
import com.example.kmarket.mapper.product.KmProductMapper;
import com.example.kmarket.repository.product.KmProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class KmProductService {
    @Autowired
    private KmProductRepository kmProductRepository;
    @Autowired
    private KmProductMapper kmProductMapper;


    public KmProductDTO viewProd(int prodNo) {
        KmProductEntity kmProductEntity = kmProductRepository.findById(prodNo).get();
        //hit 1 상승
        kmProductEntity.setHit(kmProductEntity.getHit()+1);
        kmProductRepository.save(kmProductEntity);

        return kmProductMapper.toDTO(kmProductEntity);
    }

    public PageResponseDTO findByProducts(PageRequestDTO pageRequestDTO) {


        //카테고리 10~ 1000까지 cate1, 카테고리 1000~ cate2 10 이하는 존재하지 않음
        //tpye값으로 정렬 처리
        Pageable pageable = null;
        if (pageRequestDTO.getType().equals("priceAsc")) {
            pageable = pageRequestDTO.getPageableAsc("price");
        } else {
            pageable = pageRequestDTO.getPageableDesc(pageRequestDTO.getType());
        }


        Page<KmProductEntity> result = null;

        if (!pageRequestDTO.getIsDescript() || !pageRequestDTO.getIsNum() || !pageRequestDTO.getIsProdName()) {
            // 카테고리 없이 전체검색일때
            if (pageRequestDTO.getCate() == 0) {
                //가격 검색이 있는 검색
                if (Boolean.TRUE.equals(pageRequestDTO.getIsNum())) {
                    //가격 검색만 있는 검색
                    if (Boolean.TRUE.equals(!pageRequestDTO.getIsDescript()) && Boolean.TRUE.equals(!pageRequestDTO.getIsProdName())) {
                        result = kmProductRepository.findByPriceIsBetween(pageRequestDTO.getMin(), pageRequestDTO.getMax(), pageable);
                    }
                    //상품명, 설명 검색중 어떤것인지 확인
                    else if (Boolean.TRUE.equals(pageRequestDTO.getIsProdName())) {
                        //가격이 있는 상품명 검색
                        result = kmProductRepository.findByProdNameContainingAndPriceIsBetween(pageRequestDTO.getSearch(), pageRequestDTO.getMin(), pageRequestDTO.getMax(), pageable);
                    } else {
                        //가격이 있는 상품설명 검색
                        result = kmProductRepository.findByDescriptContainingAndPriceIsBetween(pageRequestDTO.getSearch(), pageRequestDTO.getMin(), pageRequestDTO.getMax(), pageable);
                    }
                }
                //가격 검색이 없는 검색
                else {
                    //상품명, 설명 검색중 어떤것인지 확인
                    if (Boolean.TRUE.equals(pageRequestDTO.getIsProdName())) {
                        //가격이 없는 상품명 검색
                        result = kmProductRepository.findByProdNameContaining(pageRequestDTO.getSearch(), pageable);
                    } else {
                        //가격이 없는 상품설명 검색
                        result = kmProductRepository.findByDescriptContaining(pageRequestDTO.getSearch(), pageable);
                    }
                }
            }//카테고리별로 나눠서 검색일때
            else {
                //카테고리 2 검색
                if (pageRequestDTO.getCate() >= 1000) {
                    //가격 검색이 있는 검색
                    if (Boolean.TRUE.equals(pageRequestDTO.getIsNum())) {
                        //가격 검색만 있는 검색
                        if (Boolean.TRUE.equals(!pageRequestDTO.getIsDescript()) && Boolean.TRUE.equals(!pageRequestDTO.getIsProdName())) {
                            result = kmProductRepository.findByPriceIsBetweenAndProdCate2(pageRequestDTO.getMin(), pageRequestDTO.getMax(), pageRequestDTO.getCate(), pageable);
                        }
                        //상품명, 설명 검색중 어떤것인지 확인
                        else if (Boolean.TRUE.equals(pageRequestDTO.getIsProdName())) {
                            //가격이 있는 상품명 검색
                            result = kmProductRepository.findByProdNameContainingAndProdCate2AndPriceIsBetween(pageRequestDTO.getSearch(), pageRequestDTO.getCate(), pageRequestDTO.getMin(), pageRequestDTO.getMax(), pageable);
                        } else {
                            //가격이 있는 상품설명 검색
                            result = kmProductRepository.findByDescriptContainingAndProdCate2AndPriceIsBetween(pageRequestDTO.getSearch(), pageRequestDTO.getCate(), pageRequestDTO.getMin(), pageRequestDTO.getMax(), pageable);
                        }
                    }
                    //가격 검색이 없는 검색
                    else {

                        //가격 검색만 있는 검색
                        if (Boolean.TRUE.equals(!pageRequestDTO.getIsDescript()) && Boolean.TRUE.equals(!pageRequestDTO.getIsProdName())) {
                            result = kmProductRepository.findByPriceIsBetweenAndProdCate2(pageRequestDTO.getMin(), pageRequestDTO.getMax(), pageRequestDTO.getCate(), pageable);
                        }
                        //상품명, 설명 검색중 어떤것인지 확인
                        else if (Boolean.TRUE.equals(pageRequestDTO.getIsProdName())) {

                            //가격이 없는 상품명 검색
                            result = kmProductRepository.findByProdNameContainingAndProdCate2(pageRequestDTO.getSearch(), pageRequestDTO.getCate(), pageable);
                        } else {
                            //가격이 없는 상품설명 검색
                            result = kmProductRepository.findByDescriptContainingAndProdCate2(pageRequestDTO.getSearch(), pageRequestDTO.getCate(), pageable);
                        }
                    }
                }
                //카테고리 1 검색
                else if (pageRequestDTO.getCate() >= 10) {
                    //가격 검색이 있는 검색
                    if (Boolean.TRUE.equals(pageRequestDTO.getIsNum())) {
                        //상품명, 설명 검색중 어떤것인지 확인
                        if (Boolean.TRUE.equals(pageRequestDTO.getIsProdName())) {
                            //가격이 있는 상품명 검색
                            result = kmProductRepository.findByProdNameContainingAndProdCate1AndPriceIsBetween(pageRequestDTO.getSearch(), pageRequestDTO.getCate(), pageRequestDTO.getMin(), pageRequestDTO.getMax(), pageable);
                        } else {
                            //가격이 있는 상품설명 검색
                            result = kmProductRepository.findByDescriptContainingAndProdCate1AndPriceIsBetween(pageRequestDTO.getSearch(), pageRequestDTO.getCate(), pageRequestDTO.getMin(), pageRequestDTO.getMax(), pageable);
                        }
                    }
                    //가격 검색이 없는 검색
                    else {
                        //상품명, 설명 검색중 어떤것인지 확인
                        if (Boolean.TRUE.equals(pageRequestDTO.getIsProdName())) {
                            //가격이 없는 상품명 검색
                            result = kmProductRepository.findByProdNameContainingAndProdCate1(pageRequestDTO.getSearch(), pageRequestDTO.getCate(), pageable);
                        } else {
                            //가격이 없는 상품설명 검색
                            result = kmProductRepository.findByDescriptContainingAndProdCate1(pageRequestDTO.getSearch(), pageRequestDTO.getCate(), pageable);
                        }
                    }
                }
            }

        }
        // 상품명, 상품 설명인지 확인
        // 상품 가격도 있는지 확인
        // 카테고리별로 처리한지 확인




/*
        //카테고리 확인 -> 서치 확인 -> 아무것도 없으면 findAll
        if(pageRequestDTO.getCate() != 0&& !pageRequestDTO.getSearch().isEmpty()){
            if (pageRequestDTO.getCate() >= 1000) {
                result = kmProductRepository.findByProdCate2AndProdNameContaining(pageRequestDTO.getCate(),pageRequestDTO.getSearch(), pageable);
            } else if (pageRequestDTO.getCate() >= 10) {
                result = kmProductRepository.findByProdCate1AndProdNameContaining(pageRequestDTO.getCate(),pageRequestDTO.getSearch(), pageable);
            }
        }*/
        else {
            if (!pageRequestDTO.getSearch().isEmpty()) {
                result = kmProductRepository.findByProdNameContaining(pageRequestDTO.getSearch(), pageable);
            } else if (pageRequestDTO.getCate() != 0) {
                if (pageRequestDTO.getCate() >= 1000) {
                    result = kmProductRepository.findByProdCate2(pageRequestDTO.getCate(), pageable);
                } else if (pageRequestDTO.getCate() >= 10) {
                    result = kmProductRepository.findByProdCate1(pageRequestDTO.getCate(), pageable);
                }
            } else {
                result = kmProductRepository.findAll(pageable);
            }
        }
        List<KmProductDTO> dtoList = result.getContent()
                .stream()
                .map(kmProductMapper::toDTO)
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalElement)
                .build();
    }

    public List<KmProductDTO> findByType(String type) {

        List<KmProductDTO> result = null;
        if(Objects.equals(type, "hit")){
            result = kmProductRepository.findTop8ByOrderByHitDesc().stream().map(kmProductMapper::toDTO).toList();
        }else if(Objects.equals(type, "recomment")){
            result = kmProductRepository.findTop8ByOrderByReviewDesc().stream().map(kmProductMapper::toDTO).toList();
        }else if(Objects.equals(type, "new")){
            result = kmProductRepository.findTop8ByOrderByRdateDesc().stream().map(kmProductMapper::toDTO).toList();
        }else if(Objects.equals(type, "discount")){
            result = kmProductRepository.findTop8ByOrderByDiscountDesc().stream().map(kmProductMapper::toDTO).toList();
        }else if(Objects.equals(type, "best")){
            result = kmProductRepository.findTop5ByOrderByScoreDesc().stream().map(kmProductMapper::toDTO).toList();
        }

        return result;
    }

    public void deleteById(int prodNo) {
        kmProductRepository.deleteById(prodNo);
    }
}
