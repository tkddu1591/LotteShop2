package com.example.kmarket.repository.product;


import com.example.kmarket.entity.product.KmProductOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface KmProductOrderRepository extends JpaRepository<KmProductOrderEntity, Integer> {
    KmProductOrderEntity findTopByOrdUidOrderByOrdNoDesc(String uid);

    KmProductOrderEntity findFirstByOrderByOrdNoDesc();

    KmProductOrderEntity findByOrdUidOrderByOrdNoDesc(String uid);

    int countByOrdUidAndOrdCompleteBetween(String memberUid, int start, int end);


    void deleteByOrdNo(int ordNo);

    void save(int ordNo);
}

