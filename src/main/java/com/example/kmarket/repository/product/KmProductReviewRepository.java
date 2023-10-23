package com.example.kmarket.repository.product;


import com.example.kmarket.entity.product.KmProductReviewEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmProductReviewRepository extends JpaRepository<KmProductReviewEntity, Integer> {
    public Page<KmProductReviewEntity> findByKmProductEntity_ProdNo(int prodNo, Pageable pageable);
    public int countByKmProductEntity_ProdNo(int prodNo);

    Page<KmProductReviewEntity> findByUid(String uid, Pageable pageable);
}

