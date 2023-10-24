package com.example.kmarket.repository.member;

import com.example.kmarket.entity.member.KmMemberCouponEntity;
import com.example.kmarket.entity.member.KmMemberPointEntity;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface KmMemberCouponRepository extends JpaRepository<KmMemberCouponEntity, Integer> {
    int countByUidAndStateAndWdateAfter(String uid, int state, LocalDateTime today);

    Page<KmMemberCouponEntity> findByUid(String memberUid, Pageable pageable);
}

