package com.example.kmarket.repository.cs;


import com.example.kmarket.entity.cs.KmCsFaqEntity;
import com.example.kmarket.entity.cs.KmCsFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface KmCsFileRepository extends JpaRepository<KmCsFileEntity, Integer> {

//    public KmCsFileEntity findByQnaNo(int qnaNo);

}

