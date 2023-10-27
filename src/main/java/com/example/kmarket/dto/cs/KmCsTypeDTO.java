package com.example.kmarket.dto.cs;

import lombok.*;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmCsTypeDTO {

	private int typeNo;
	private String cate;
	private int type;
	private String typeName;
	
	// 추가 필드
	private List<KmCsFaqDTO> faqDTO;
	private String cateName;

}
