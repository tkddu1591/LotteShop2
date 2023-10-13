package com.example.kmarket.repository;


import com.example.kmarket.entity.KmProductCate2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmProductCate2Repository extends JpaRepository<KmProductCate2Entity, Integer> {
}

