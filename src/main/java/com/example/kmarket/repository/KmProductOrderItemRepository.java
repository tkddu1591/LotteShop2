package com.example.kmarket.repository;


import com.example.kmarket.entity.KmProductOrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmProductOrderItemRepository extends JpaRepository<KmProductOrderItemEntity, Integer> {
}

