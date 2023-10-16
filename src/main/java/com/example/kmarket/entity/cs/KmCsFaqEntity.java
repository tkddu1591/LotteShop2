package com.example.kmarket.entity.cs;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_cs_faq")
public class KmCsFaqEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int faqNo;
	private String cate;
	private int type;
	private String title;
	private String content;
	private int relatedFaq;
	private String writer;
	private String regip;

	@CreationTimestamp
	private LocalDateTime rdate;


	
}
