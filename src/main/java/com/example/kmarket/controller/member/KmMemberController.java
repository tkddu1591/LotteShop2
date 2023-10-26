package com.example.kmarket.controller.member;

import com.example.kmarket.dto.member.ChangePasswordRequestDTO;
import com.example.kmarket.dto.member.KmMemberRequestDTO;
import com.example.kmarket.dto.member.KmMemberResponseDTO;
import com.example.kmarket.service.member.KmMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/member")
@RequiredArgsConstructor
public class KmMemberController {

    private final KmMemberService memberService;

    @GetMapping("/me")
    public ResponseEntity<KmMemberResponseDTO> getMyMemberInfo() {
        KmMemberResponseDTO myInfoBySecurity = memberService.getMyInfoBySecurity();
        System.out.println(myInfoBySecurity.getNick());
        return ResponseEntity.ok((myInfoBySecurity));
        // return ResponseEntity.ok(memberService.getMyInfoBySecurity());
    }
    @PostMapping("/checkUid")
    public int checkUid(@RequestBody KmMemberRequestDTO request){
        return memberService.checkUid(request.getUid());
    }
    @PostMapping("/checkEmail")
    public int checkEmail(@RequestBody KmMemberRequestDTO request){
        return memberService.checkEmail(request.getEmail());
    }

    @PostMapping("/nickChagne")
    public ResponseEntity<KmMemberResponseDTO> setMemberNickname(@RequestBody KmMemberRequestDTO request) {
        return ResponseEntity.ok(memberService.changeMemberNickname(request.getEmail(), request.getNick()));
    }
    @PostMapping("/change")
    public ResponseEntity<KmMemberResponseDTO> change(@RequestBody KmMemberRequestDTO request) {
        return ResponseEntity.ok(memberService.change(request));
    }

    @PostMapping("/passChagne")
    public ResponseEntity<KmMemberResponseDTO> setMemberPassword(@RequestBody ChangePasswordRequestDTO request) {
        log.info(request.toString());
        return ResponseEntity.ok(memberService.changeMemberPassword(request));
    }

}
