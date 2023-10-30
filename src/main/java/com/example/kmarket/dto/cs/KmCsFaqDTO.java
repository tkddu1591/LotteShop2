package com.example.kmarket.dto.cs;

import lombok.*;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmCsFaqDTO {
	private int faqNo;
	private String cate;
	private int type;
	private String title;
	private String content;
	private int relatedFaq;
	private String writer;
	private String regip;
	private int hit;
	private LocalDateTime rdate;

	//추가 필드
	private String cateName;
	private String typeName;
	private int index;
	
}
