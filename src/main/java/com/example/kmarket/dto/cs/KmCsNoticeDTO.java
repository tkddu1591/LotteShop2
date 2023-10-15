package com.example.kmarket.dto.cs;

import lombok.*;

import java.time.LocalDateTime;

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
	private LocalDateTime rdate;
}
