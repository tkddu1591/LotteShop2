package com.example.kmarket.dto.cs;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmCsFileDTO {

    private int fno;
    private String qnaNo;
    private String oName;
    private String sName;
    private int download;
    private LocalDateTime rdate;
}
