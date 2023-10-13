package com.example.kmarket.entity;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmMemberDTO {
    private String uid;
    private String pass;
    private String name;
    private int gender;
    private String hp;
    private String email;
    private int type;
    private int point;
    private int level;
    private String zip;
    private String addr1;
    private String addr2;
    private String company;
    private String ceo;
    private String bizRegNum;
    private String comRegNum;
    private String tel;
    private String manager;
    private String managerHp;
    private String fax;
    private String regIp;
    private String wDate;
    private String rDate;
    private int etc1;
    private int etc2;
    private String etc3;
    private String etc4;
    private String etc5;

    
    
}
