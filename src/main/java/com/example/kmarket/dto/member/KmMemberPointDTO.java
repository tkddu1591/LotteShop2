package com.example.kmarket.dto.member;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmMemberPointDTO {
    private int pointNo;
    private String uid;
    private int ordNo;
    private int point;
    private LocalDateTime pointDate;
    private String comment;

    //추가 데이터
/*  <th>날짜</th>
    <th>구분</th>
    <th>주문번호</th>
    <th>적립금액</th>
    <th>비고</th>
    <th>유효기간</th>*/

    private LocalDateTime ordDate;
    private int ordComplete;
}
