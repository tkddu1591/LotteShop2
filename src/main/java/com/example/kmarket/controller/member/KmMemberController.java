package com.example.kmarket.controller.member;

import com.example.kmarket.dto.member.KmMemberDTO;
import com.example.kmarket.service.member.KmMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class KmMemberController {

    @Autowired
    private KmMemberService service;
    @PostMapping("/login")
    public KmMemberDTO login(@RequestBody KmMemberDTO dto){
        return service.findByUidAndPass(dto);
    }

}
