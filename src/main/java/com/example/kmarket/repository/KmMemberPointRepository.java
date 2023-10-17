package com.example.kmarket.repository;

import com.example.kmarket.entity.KmMemberPointEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmMemberPointRepository extends JpaRepository<KmMemberPointEntity, Integer> {
}

