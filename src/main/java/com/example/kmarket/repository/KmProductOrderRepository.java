package com.example.kmarket.repository;


import com.example.kmarket.dto.KmProductCartDTO;
import com.example.kmarket.entity.KmProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KmProductOrderRepository extends JpaRepository<KmProductOrderEntity, Integer> {
    int findTopByOrdUidOrderByOrdNoDesc(String uid);

    KmProductOrderEntity findFirstByOrderByOrdNoDesc();

}

