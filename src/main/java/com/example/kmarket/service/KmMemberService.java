package com.example.kmarket.service;

import com.example.kmarket.dto.KmMemberDTO;
import com.example.kmarket.mapper.KmMemberMapper;
import com.example.kmarket.repository.KmMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KmMemberService {
    @Autowired
    KmMemberRepository kmMemberRepository;
    @Autowired
    KmMemberMapper kmMemberMapper;
    public KmMemberDTO findByUidAndPass(KmMemberDTO kmMemberDTO){
        return kmMemberMapper.toDTO(kmMemberRepository.findByUidAndPass(kmMemberDTO.getUid(),kmMemberDTO.getPass()));
    }

}
