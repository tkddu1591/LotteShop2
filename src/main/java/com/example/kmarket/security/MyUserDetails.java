package com.example.crud_project.security;


import com.example.crud_project.entity.UserEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MyUserDetails implements UserDetails {
/*
    private String username;
    private String password;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;
    private Collection<? extends GrantedAuthority> authorities;
    public MyUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.authorities = authorities;
    }
*/

    private UserEntity userEntity;

    public MyUserDetails(String uid, String pass, String name, int age, String hp, String role, LocalDateTime regDate) {
        this.userEntity.setUid(uid);
        this.userEntity.setPass(pass);
        this.userEntity.setName(name);
        this.userEntity.setAge(age);
        this.userEntity.setHp(hp);
        this.userEntity.setRole(role);
        this.userEntity.setRegDate(regDate);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        //role 역할 치중 ex. 기본사용자, 관리자, 매니저, 실버회원, 골드회원 등
        //authorities 권한 치중
        list.add(new SimpleGrantedAuthority("ROLE_"+ userEntity.getRole()));
        return list;
    }

    @Override
    public String getPassword() {
        //계정이 갖는 비밀번호
        return userEntity.getPass();
    }

    @Override
    public String getUsername() {
        //계정이 갖는 아이디
        return userEntity.getUid();
    }

    @Override
    public boolean isAccountNonExpired() {
        //계정 만료 여부(true:만료안됨, false:만료)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //계정 잠금 여부(true: 잠금안됨, false: 잠금)
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //비밀번호 만료 여부(true: 만료안됨, false: 만료)
        return true;
    }

    @Override
    public boolean isEnabled() {
        //계정 활성화 여부(true: 활성화됨, false: 비활성화됨)
        return true;
    }

}
