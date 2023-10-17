package com.example.kmarket.repository.cs;


import com.example.kmarket.entity.cs.KmCsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmCsCate2Repository extends JpaRepository<KmCsTypeEntity, Integer> {
}

