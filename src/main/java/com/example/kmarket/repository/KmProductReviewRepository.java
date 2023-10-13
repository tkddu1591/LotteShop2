package com.example.kmarket.repository;


import com.example.kmarket.entity.KmProductReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmProductReviewRepository extends JpaRepository<KmProductReviewEntity, Integer> {
}

