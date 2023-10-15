package com.example.kmarket.repository.cs;


import com.example.kmarket.entity.cs.KmCsCate2Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmCsCate2Repository extends JpaRepository<KmCsCate2Entity, Integer> {
}

