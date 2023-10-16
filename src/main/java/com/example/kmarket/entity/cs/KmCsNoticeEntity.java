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
@Table(name = "km_cs_notice")
public class KmCsNoticeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noticeNo;
	private int cate1;
	private int cate2;
	private String title;
	private String content;
	private String writer;
	private String regip;

	@CreationTimestamp
    private LocalDateTime rdate;

	public LocalDateTime getRdateSub() {
		String formatDate
				= LocalDateTime.now()
				.format(DateTimeFormatter.ofPattern("yy.MM.dd"));
		return LocalDateTime.parse(formatDate);
	}
}
