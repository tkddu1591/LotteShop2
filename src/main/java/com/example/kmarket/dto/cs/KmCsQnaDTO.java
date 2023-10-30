package com.example.kmarket.dto.cs;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmCsQnaDTO {
	
	private int qnaNo;
	private String cate;
	private int type;
	private String title;
	private String content;
	private String file1;
	private String file2;
	private String file3;
	private String file4;
/*	private MultipartFile file1;
	private MultipartFile file2;
	private MultipartFile file3;
	private MultipartFile file4;*/
	private String writer;
	private String regip;
	private int answerComplete;
	private LocalDateTime rdate;
	private String answer;
	private int orderItemId;
	private LocalDateTime answerDate;

	private MultipartFile mFile1;

	//추가 필드
	private String writerName;
	private String cateName;
	private String typeName;
	private String prodName;
	private int prodNo;

}
