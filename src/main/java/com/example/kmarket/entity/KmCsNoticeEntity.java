package com.example.kmarket.entity;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmCsNoticeDTO {
	private int noticeNo;
	private int cate1;
	private int cate2;
	private String title;
	private String content;
	private String writer;
	private String regip;
	private String rdate;
}
