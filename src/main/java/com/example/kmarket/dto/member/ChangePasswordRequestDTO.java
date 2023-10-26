package com.example.kmarket.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChangePasswordRequestDTO {
    private String uid;
    private String exPassword;
    private String newPassword;
}
