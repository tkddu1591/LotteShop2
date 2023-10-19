package com.example.kmarket.security;


import com.example.kmarket.dto.member.KmMemberDTO;
import com.example.kmarket.entity.member.KmMemberEntity;
import com.example.kmarket.mapper.member.KmMemberMapper;
import com.example.kmarket.repository.member.KmMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {

    //패스워드에 대한 검사는 이전 컴포넌트(AuthenticationProvider)에서 처리되어 사용자 아이디만 넘어옴.
    @Autowired
    private KmMemberRepository kmMemberRepository;

    @Autowired
    KmMemberMapper kmMemberMapper;

    //사용자 인증객체 생성(세션에 저장)
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
        KmMemberEntity user = kmMemberRepository.findById(username).
                orElseThrow(() -> new org.springframework.security.core.userdetails.UsernameNotFoundException(username));

        KmMemberDTO kmMemberDTO = kmMemberMapper.toDTO(user);

        return MyUserDetails.builder().userEntity(user).build();
    }
}
