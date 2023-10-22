package com.example.kmarket.controller.member;

import com.example.kmarket.dto.member.KmMemberRequestDTO;
import com.example.kmarket.service.member.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Transactional
@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class EmailController {
    private final MailService mailService;


    @PostMapping("/email")
    public String emailConfirm(@RequestBody KmMemberRequestDTO kmMemberRequestDTO) throws Exception {
        log.info(kmMemberRequestDTO.toString());
        log.info("send email to {}", kmMemberRequestDTO.getEmail());
        String confirm = mailService.sendSimpleMessage(kmMemberRequestDTO.getEmail());

        return confirm;
    }
}