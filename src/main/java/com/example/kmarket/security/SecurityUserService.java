package com.example.crud_project.security;


import com.example.crud_project.dto.UserDTO;
import com.example.crud_project.entity.UserEntity;
import com.example.crud_project.mapper.UserMapper;
import com.example.crud_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService implements UserDetailsService {

    //패스워드에 대한 검사는 이전 컴포넌트(AuthenticationProvider)에서 처리되어 사용자 아이디만 넘어옴.
    @Autowired
    private UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    //사용자 인증객체 생성(세션에 저장)
    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws org.springframework.security.core.userdetails.UsernameNotFoundException {
        UserEntity user = userRepository.findById(username).
                orElseThrow(() -> new org.springframework.security.core.userdetails.UsernameNotFoundException(username));

        UserDTO userDTO = userMapper.toDTO(user);

        return MyUserDetails.builder().userEntity(user).build();
    }
}
