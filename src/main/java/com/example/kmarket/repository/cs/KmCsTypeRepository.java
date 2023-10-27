package com.example.kmarket.repository.cs;

import com.example.kmarket.entity.cs.KmCsTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KmCsTypeRepository extends JpaRepository<KmCsTypeEntity, Integer> {
    List<KmCsTypeEntity> findByCate(String cate);

    List<KmCsTypeEntity> findByCateAndTypeLessThan(String cate, int type);

    List<KmCsTypeEntity> findByType(int type);
}
