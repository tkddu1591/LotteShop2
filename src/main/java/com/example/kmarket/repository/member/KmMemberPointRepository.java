package com.example.kmarket.repository.member;

import com.example.kmarket.entity.member.KmMemberPointEntity;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmMemberPointRepository extends JpaRepository<KmMemberPointEntity, Integer> {
    Page<KmMemberPointEntity> findByUid(String memberUid, Pageable pageable);
}

