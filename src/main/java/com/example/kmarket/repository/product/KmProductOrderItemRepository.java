package com.example.kmarket.repository.product;


import com.example.kmarket.entity.product.KmProductOrderItemEntity;
import com.example.kmarket.entity.product.KmProductReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface KmProductOrderItemRepository extends JpaRepository<KmProductOrderItemEntity, Integer> {
    List<KmProductOrderItemEntity> findByKmProductOrderEntity_OrdNo(int ordNo);

    List<KmProductOrderItemEntity> findByKmProductOrderEntity_OrdNoAndKmProductOrderEntity_OrdUid(int ordNo,String ordUid);

    Page<KmProductOrderItemEntity> findByKmProductOrderEntity_OrdUid(String memberUid, Pageable pageable);

    Page<KmProductOrderItemEntity> findByKmProductOrderEntity_OrdUidAndKmProductOrderEntity_OrdDateBetween(String memberUid, LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

    int countByKmProductOrderEntity_OrdUidAndKmProductOrderEntity_OrdCompleteBetween(String ordUid, int start, int end);
}

