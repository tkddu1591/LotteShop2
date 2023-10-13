package com.example.kmarket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_cs_cate1")
public class KmCsCate2DTO {

	private int cate1;
	private int cate2;
	private String c2Name;
	

}
