package com.example.kmarket.service.member;

import com.example.kmarket.dto.PageRequestDTO;
import com.example.kmarket.dto.PageResponseDTO;
import com.example.kmarket.dto.member.KmMemberCouponDTO;
import com.example.kmarket.dto.product.KmProductReviewDTO;
import com.example.kmarket.entity.member.KmMemberCouponEntity;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import com.example.kmarket.mapper.member.KmMemberCouponMapper;
import com.example.kmarket.repository.member.KmMemberCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KmCouponService {
    private final KmMemberCouponRepository couponRepository;
    private final KmMemberCouponMapper couponMapper;
    public int countByUid(String uid) {
        //사용 가능한 coupon만 검색
        return couponRepository.countByUidAndStateAndWdateAfter(uid, 0, LocalDateTime.now());
    }

    public PageResponseDTO findByUid(PageRequestDTO pageRequestDTO) {
        //Order By 정렬할 컬럼명 Desc
        //getPageableDesc 내림차순 getPageableAsc 오름차순 ("정렬할 컬럼명")
        //pg , size 가공해서 같이 ordet by랑 섞어줌
        Pageable pageable = pageRequestDTO.getPageableDesc("cno");

        //Page
        Page<KmMemberCouponEntity> result = null;
        //dtoList
        //findBy머시기 by뒤가 where절이라고 보면 됨니다.
        result = couponRepository.findByUid(pageRequestDTO.getMemberUid(), pageable);

        result.getContent(); // Entity
        result.getTotalElements(); // 숫자 형이 double -> int변경해줘야함

        // content를 dto로 변환 해주는 역할
        List<KmMemberCouponDTO> dtoList = result.getContent()
                .stream()
                .map(couponMapper::toDTO)
                .toList();

        int totalElement = (int) result.getTotalElements();

        return PageResponseDTO.builder()
                .pageRequestDTO(pageRequestDTO)
                .couponDTOS(dtoList)
                .total(totalElement)
                .build();
    }
}
