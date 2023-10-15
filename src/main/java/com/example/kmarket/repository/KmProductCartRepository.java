package com.example.kmarket.repository;


import com.example.kmarket.entity.KmProductCartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KmProductCartRepository extends JpaRepository<KmProductCartEntity, Integer> {
    KmProductCartEntity findKmProductCartEntityByProdNo(int prodNo);

    List<KmProductCartEntity> findByKmMemberEntity_UidOrderByCartNoDesc(String uid);
}

