package com.example.kmarket.repository;


import com.example.kmarket.entity.KmCsCate1Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmCsCate1Repository extends JpaRepository<KmCsCate1Entity, Integer> {
}

