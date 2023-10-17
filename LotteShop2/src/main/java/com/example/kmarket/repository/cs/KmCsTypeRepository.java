package com.example.kmarket.repository.cs;

import com.example.kmarket.entity.cs.KmCsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KmCsTypeRepository extends JpaRepository<KmCsTypeEntity, Integer> {
    KmCsTypeEntity findByTypeAndCate(int type, String cate);
}
