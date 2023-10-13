package com.example.kmarket.repository;


import com.example.kmarket.entity.KmCsFaqRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmCsFaqRateRepository extends JpaRepository<KmCsFaqRateEntity, Integer> {
}

