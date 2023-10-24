package com.example.kmarket.repository.member;

import com.example.kmarket.entity.member.KmMemberCouponEntity;
import com.example.kmarket.entity.member.KmMemberPointEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmMemberCouponRepository extends JpaRepository<KmMemberCouponEntity, Integer> {
    int countByUidAndState(String uid, int state);
}

