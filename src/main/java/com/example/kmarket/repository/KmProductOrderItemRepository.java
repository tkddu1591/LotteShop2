package com.example.kmarket.repository;


import com.example.kmarket.dto.KmProductOrderDTO;
import com.example.kmarket.entity.KmProductOrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KmProductOrderItemRepository extends JpaRepository<KmProductOrderItemEntity, Integer> {
    List<KmProductOrderItemEntity> findByKmProductOrderEntity_OrdNo(int ordNo);
}

