package com.example.kmarket.repository;


import com.example.kmarket.entity.KmProductCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmProductCartRepository extends JpaRepository<KmProductCartEntity, Integer> {
}

