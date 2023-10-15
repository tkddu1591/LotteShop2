package com.example.kmarket.repository.cs;


import com.example.kmarket.entity.cs.KmCsNoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmCsNoticeRepository extends JpaRepository<KmCsNoticeEntity, Integer> {
}

