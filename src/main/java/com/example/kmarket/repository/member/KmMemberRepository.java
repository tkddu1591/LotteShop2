package com.example.kmarket.repository.member;

import com.example.kmarket.entity.member.KmMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KmMemberRepository extends JpaRepository<KmMemberEntity, String> {
    KmMemberEntity findByUidAndPass(String uid, String pass);
}

