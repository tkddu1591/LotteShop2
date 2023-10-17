package com.example.kmarket.dto;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmMemberTermsDTO {
    private String terms;
    private String privacy;
    private String location;
    private String finance;
    private String tax;

}
