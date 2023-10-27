package com.example.kmarket.dto.admin;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class KmAdminCsTypeDTO {

    private int type;
    private String cate;
    private String typeName;

}
