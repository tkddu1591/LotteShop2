package com.example.kmarket.repository.cs;


import com.example.kmarket.entity.cs.KmCsFaqEntity;
import com.example.kmarket.entity.cs.KmCsNoticeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KmCsFaqRepository extends JpaRepository<KmCsFaqEntity, Integer> {


}

