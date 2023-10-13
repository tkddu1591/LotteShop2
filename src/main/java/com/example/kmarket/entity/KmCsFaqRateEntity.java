package com.example.kmarket.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_cs_faq_rate")
public class KmCsFaqRateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int faqNo;
	private String uid;
	private int rate;

}
