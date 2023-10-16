package com.example.kmarket.entity.cs;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_cs_qna")
public class KmCsQnaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qnaNo;
	private int cate1;
	private int cate2;
	private String title;
	private String content;
	private String file1;
	private String file2;
	private String file3;
	private String file4;
	private String writer;
	private String ordNo; //null 값 넣기 위해 String으로 변경 
	private String prodNo;
	private int parent;
	private int answerComplete;
	private String regip;

	@CreationTimestamp
	private LocalDateTime rdate;
	
	//추가 필드
	private String writerName;
	private String c1Name;
	private String c2Name;
	private String writerMarking;
	private LocalDateTime rdateSub;

	// 이거 되는지 안 되는지는 모르겠지만,
	// 일단 나중에 테스트 해봐야될 듯
	public LocalDateTime getRdateSub() {
		String formatDate
				= LocalDateTime.now()
						.format(DateTimeFormatter.ofPattern("yy.MM.dd"));
		return LocalDateTime.parse(formatDate);
	}

	// 운영자 및 자기가 쓴 글에 대해서는 아이디 보이게
	// 자기글이 아닌 경우 masking처리
	public String maskingUid(String uid) {
		StringBuilder maskingUid = new StringBuilder(uid);
		int length = uid.length();
		if (length > 1) {
			for (int i = 1; i < Math.max(2, length - 1); i++) {
				maskingUid.setCharAt(i, '*');
			}
		}
		return maskingUid.toString();
	}
	
}
