package com.example.kmarket.repository.admin;

import com.example.kmarket.entity.admin.KmAdminNoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmAdminNoticeRepository extends JpaRepository<KmAdminNoticeEntity, Integer> {

    public Page<KmAdminNoticeEntity> findAll(Pageable pageable);

    public Page<KmAdminNoticeEntity> findByKmCsCateEntity_Cate(Pageable pageable, String cate);


}
