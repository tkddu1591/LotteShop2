package com.example.kmarket.service.member;

import com.example.kmarket.dto.member.ChangePasswordRequestDTO;
import com.example.kmarket.dto.member.KmMemberRequestDTO;
import com.example.kmarket.dto.member.KmMemberResponseDTO;
import com.example.kmarket.entity.member.KmMemberEntity;
import com.example.kmarket.repository.member.KmMemberRepository;
import com.example.kmarket.security.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class KmMemberService {
    private final KmMemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public KmMemberResponseDTO getMyInfoBySecurity() {
        return memberRepository.findById(SecurityUtil.getCurrentMemberId())
                .map(KmMemberResponseDTO::of)
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
    }

    @Transactional
    public KmMemberResponseDTO changeMemberNickname(String email, String nickname) {
        KmMemberEntity member = memberRepository.findByUid(email).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
        member.setUid(nickname);
        return KmMemberResponseDTO.of(memberRepository.save(member));
    }

    @Transactional
    public KmMemberResponseDTO changeMemberPassword(ChangePasswordRequestDTO request) {
        KmMemberEntity member = memberRepository.findById(request.getUid()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
        if (!passwordEncoder.matches(request.getExPassword(), member.getPass())) {
            throw new RuntimeException("비밀번호가 맞지 않습니다");
        }
        member.setPassword(passwordEncoder.encode((request.getNewPassword())));
        return KmMemberResponseDTO.of(memberRepository.save(member));
    }

    public int checkUid(String uid) {
        return memberRepository.countByUid(uid);
    }

    public int checkEmail(String email) {
        return memberRepository.countByEmail(email);
    }


    public int findByUidAndPoint(String memberUid) {
        return (memberRepository.findById(memberUid).get().getPoint());
    }


    @Transactional
    public KmMemberResponseDTO change(KmMemberRequestDTO request) {
        KmMemberEntity member = memberRepository.findById(request.getUid()).orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다"));
        member.setEmail(request.getEmail());
        member.setZip(request.getZip());
        member.setAddr1(request.getAddr1());
        member.setAddr2(request.getAddr2());
        member.setHp(request.getHp());
        return KmMemberResponseDTO.of(memberRepository.save(member));
    }

}
