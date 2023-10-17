package com.example.kmarket.repository;

import com.example.kmarket.entity.KmAdminNoticeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmAdminCsRepository extends JpaRepository<KmAdminNoticeEntity, String> {
}
