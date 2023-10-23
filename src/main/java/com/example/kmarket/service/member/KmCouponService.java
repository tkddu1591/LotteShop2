package com.example.kmarket.service.member;

import com.example.kmarket.mapper.member.KmMemberCouponMapper;
import com.example.kmarket.repository.member.KmMemberCouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KmCouponService {
    private final KmMemberCouponRepository couponRepository;
    private final KmMemberCouponMapper couponMapper;
    public int countByUid(String uid) {
        //사용 가능한 coupon만 검색
        return couponRepository.countByUidAndState(uid, 0);
    }
}
