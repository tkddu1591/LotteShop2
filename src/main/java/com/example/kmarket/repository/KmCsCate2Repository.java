package com.example.kmarket.repository;


import com.example.kmarket.entity.KmCsCate2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmCsCate2Repository extends JpaRepository<KmCsCate2Entity, Integer> {
}

