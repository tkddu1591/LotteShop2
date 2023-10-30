package com.example.kmarket.dto.product;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;


@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmProductDTO {
    private int prodNo;
    private int prodCate1;
    private int prodCate2;
    private String prodName;
    private String descript;
    private String seller;
    private int price;
    private int discount;
    private int point;
    private int stock;
    private int sold;
    private int delivery;
    private int hit;
    private int score;
    private int review;

    private MultipartFile fileThumb1;
    private MultipartFile fileThumb2;
    private MultipartFile fileThumb3;
    private MultipartFile fileDetail;

    private String thumb1;
    private String thumb2;
    private String thumb3;
    private String detail;
    private String status;
    private String duty;
    private String receipt;
    private String bizType;
    private String origin;
    private String ip;
    private LocalDateTime rdate;
    private int etc1;
    private int etc2;
    private String etc3;
    private String etc4;
    private String etc5;


    //추가정보

    private String company;
    private String ceo;
    private String bizRegNum;
    private String comRegNum;
    private String tel;
    private String fax;

}

