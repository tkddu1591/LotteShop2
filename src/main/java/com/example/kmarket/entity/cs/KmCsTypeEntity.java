package com.example.kmarket.entity.cs;

import jakarta.persistence.*;
import lombok.*;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "km_cs_type")
public class KmCsTypeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int typeNo;
	private String cate;
	private int type;
	private String typeName;
	

}
