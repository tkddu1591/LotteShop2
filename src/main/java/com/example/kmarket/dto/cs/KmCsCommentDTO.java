package com.example.kmarket.dto.cs;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KmCsCommentDTO {

    private int cno;
    private String qnaNo;
    private String answer;
    private String comment;
    private String rdate;
}
