package com.example.kmarket.repository;


import com.example.kmarket.entity.KmMemberTermsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmMemberTermsRepository extends JpaRepository<KmMemberTermsEntity, Integer> {
}

