package com.example.kmarket.repository.product;


import com.example.kmarket.dto.product.KmProductDTO;
import com.example.kmarket.entity.product.KmProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface KmProductRepository extends JpaRepository<KmProductEntity, Integer> {
    public Page<KmProductEntity> findByProdCate1(int i, Pageable pageable);

    public Page<KmProductEntity> findByProdCate2(int i, Pageable pageable);

    public Page<KmProductEntity> findByProdNameContaining(String prodName, Pageable pageable);

    public Page<KmProductEntity> findByProdCate2AndProdNameContaining(int prodCate2, String prodName, Pageable pageable);

    public Page<KmProductEntity> findByProdCate1AndProdNameContaining(int prodCate2, String prodName, Pageable pageable);

    public Page<KmProductEntity> findByProdNameContainingAndPriceIsBetween(String prodName, int min, int max, Pageable pageable);

    public Page<KmProductEntity> findByProdNameContainingAndProdCate1AndPriceIsBetween(String prodName, int prodCate1, int price, int price2, Pageable pageable);

    public Page<KmProductEntity> findByProdNameContainingAndProdCate2AndPriceIsBetween(String prodName, int prodCate1, int price, int price2, Pageable pageable);

    public Page<KmProductEntity> findByDescriptContainingAndProdCate1AndPriceIsBetween(String prodName, int prodCate1, int price, int price2, Pageable pageable);

    public Page<KmProductEntity> findByDescriptContainingAndProdCate2AndPriceIsBetween(String prodName, int prodCate1, int price, int price2, Pageable pageable);

    public Page<KmProductEntity> findByDescriptContainingAndPriceIsBetween(String descript, int min, int max, Pageable pageable);

    public Page<KmProductEntity> findByDescriptContaining(String search, Pageable pageable);

    public Page<KmProductEntity> findByDescriptContainingAndProdCate1(String search, int cate, Pageable pageable);

    public Page<KmProductEntity> findByDescriptContainingAndProdCate2(String search, int cate, Pageable pageable);

    public Page<KmProductEntity> findByProdNameContainingAndProdCate2(String search, int cate, Pageable pageable);

    public Page<KmProductEntity> findByProdNameContainingAndProdCate1(String search, int cate, Pageable pageable);

    public Page<KmProductEntity> findByPriceIsBetween(int min, int max, Pageable pageable);

    public Page<KmProductEntity> findByPriceIsBetweenAndProdCate1(int min, int max, int cate, Pageable pageable);

    public Page<KmProductEntity> findByPriceIsBetweenAndProdCate2(int min, int max, int cate, Pageable pageable);

    List<KmProductEntity> findTop8ByOrderByHitDesc();

    List<KmProductEntity> findTop8ByOrderByReviewDesc();

    List<KmProductEntity> findTop8ByOrderByRdateDesc();

    List<KmProductEntity> findTop8ByOrderByDiscountDesc();

    List<KmProductEntity> findTop5ByOrderByScoreDesc();

    KmProductEntity findByProdNo(int prodNo);
}
