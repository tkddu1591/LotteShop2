package com.example.kmarket.repository.member;

import com.example.kmarket.entity.member.KmMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface KmMemberRepository extends JpaRepository<KmMemberEntity, String> {
    KmMemberEntity findByUidAndPass(String uid, String pass);

    Optional<KmMemberEntity> findByUid(String uid);
    boolean existsByUid(String email);

    int countByUid(String uid);

    int countByEmail(String email);
}

