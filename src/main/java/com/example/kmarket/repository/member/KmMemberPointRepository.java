package com.example.kmarket.repository.member;

import com.example.kmarket.entity.member.KmMemberPointEntity;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface KmMemberPointRepository extends JpaRepository<KmMemberPointEntity, Integer> {
    Page<KmMemberPointEntity> findByUid(String memberUid, Pageable pageable);
    KmMemberPointEntity findByUid(String memberUid);
    Page<KmMemberPointEntity> findByUidAndOrderEntity_OrdDateBetween(String uid, LocalDateTime pointDate, LocalDateTime pointDate2, Pageable pageable);
}

