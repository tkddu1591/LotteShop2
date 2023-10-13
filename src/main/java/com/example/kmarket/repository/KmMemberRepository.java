package com.example.kmarket.repository;

import com.example.kmarket.entity.KmMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KmMemberRepository extends JpaRepository<KmMemberEntity, String> {
    KmMemberEntity findByUid(String uid);
}

