package com.example.kmarket.repository.cs;


import com.example.kmarket.entity.cs.KmCsNoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KmCsNoticeRepository extends JpaRepository<KmCsNoticeEntity, Integer> {
    public Page<KmCsNoticeEntity> findAll(Pageable pageable);

    public Page<KmCsNoticeEntity> findByKmCsCateEntity_CateOrderByRdateDesc(Pageable pageable, String cate);

    void deleteByNoticeNo(int noticeNo);
}

