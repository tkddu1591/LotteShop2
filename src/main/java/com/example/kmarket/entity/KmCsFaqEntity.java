package com.example.kmarket.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
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
	private int cate1;
	private int cate2;
	private String title;
	private String content;
	private int relatedFaq;
	private String writer;
	private String regip;
	private String rdate;


	
}
