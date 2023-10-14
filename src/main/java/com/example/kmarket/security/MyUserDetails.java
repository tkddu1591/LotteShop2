package com.example.kmarket.security;


import com.example.kmarket.entity.KmMemberEntity;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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


    private KmMemberEntity userEntity;

    public MyUserDetails(String uid, String pass, String name, int gender, String hp, String email, String type
            , int point, int level, String zip, String addr1, String addr2, String company,
                         String ceo, String bizRegNum, String comRegNum, String tel, String manager,
                         String managerHp, String fax, String regIp, String wDate, String rDate,
                         int etc1, int etc2, String etc3, String etc4, String etc5) {
        this.userEntity.setUid(uid);
        this.userEntity.setPass(pass);
        this.userEntity.setName(name);
        this.userEntity.setGender(gender);
        this.userEntity.setHp(hp);
        this.userEntity.setEmail(email);
        this.userEntity.setType(type);
        this.userEntity.setPoint(point);
        this.userEntity.setLevel(level);
        this.userEntity.setZip(zip);
        this.userEntity.setAddr1(addr1);
        this.userEntity.setAddr2(addr2);
        this.userEntity.setCompany(company);
        this.userEntity.setCeo(ceo);
        this.userEntity.setBizRegNum(bizRegNum);
        this.userEntity.setComRegNum(comRegNum);
        this.userEntity.setTel(tel);
        this.userEntity.setManager(manager);
        this.userEntity.setManagerHp(managerHp);
        this.userEntity.setFax(fax);
        this.userEntity.setRegIp(regIp);
        this.userEntity.setWDate(wDate);
        this.userEntity.setRDate(rDate);
        this.userEntity.setEtc1(etc1);
        this.userEntity.setEtc2(etc2);
        this.userEntity.setEtc3(etc3);
        this.userEntity.setEtc4(etc4);
        this.userEntity.setEtc5(etc5);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        //role 역할 치중 ex. 기본사용자, 관리자, 매니저, 실버회원, 골드회원 등
        //authorities 권한 치중
        list.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getType()));
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
