package com.example.kmarket.entity.cs;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString(exclude = {"kmCsCateEntity", "kmCsTypeEntity", "kmCsQnaEntity"})
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_cs_faq")
public class KmCsFaqEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int faqNo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cate")
	private KmCsCateEntity kmCsCateEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type")
	private KmCsTypeEntity kmCsTypeEntity;
	private String title;
	private String content;
	@Builder.Default
	private int relatedFaq = 0;
	private String writer;
	private String regip;
	@Builder.Default
	private int hit = 0;
	@CreationTimestamp
	private LocalDateTime rdate;


	
}
