package com.example.kmarket.repository;


import com.example.kmarket.entity.KmProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmProductOrderRepository extends JpaRepository<KmProductOrderEntity, Integer> {
}

