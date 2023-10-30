package com.example.kmarket.repository.cs;


import com.example.kmarket.entity.cs.KmCsFaqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KmCsFaqRepository extends JpaRepository<KmCsFaqEntity, Integer> {
    List<KmCsFaqEntity> findTop10ByKmCsTypeEntity_TypeOrderByFaqNoDesc(int type);

    void deleteByFaqNo(int faqNo);
}

