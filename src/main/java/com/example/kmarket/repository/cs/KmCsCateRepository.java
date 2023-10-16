package com.example.kmarket.repository.cs;


import com.example.kmarket.entity.cs.KmCsCateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmCsCateRepository extends JpaRepository<KmCsCateEntity, Integer> {

    KmCsCateEntity findByCate(String cate);
}

