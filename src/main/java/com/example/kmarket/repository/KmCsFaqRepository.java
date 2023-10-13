package com.example.kmarket.repository;


import com.example.kmarket.entity.KmCsFaqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmCsFaqRepository extends JpaRepository<KmCsFaqEntity, Integer> {
}

