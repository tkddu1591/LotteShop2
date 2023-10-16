package com.example.kmarket.dto.cs;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class PageResponseDTO {
    // 위에는 추가해야 되는 값
    private List<KmCsNoticeDTO> dtoList;
    private List<KmCsFaqDTO> faqList;
    
    // 아래는 기본값
    private int pg;
    private int size;
    private int total;
    private String cate;

    private int start, end;
    private boolean prev, next;

    @Builder
    public PageResponseDTO(PageRequestDTO pageRequestDTO,
                           List<KmCsNoticeDTO> dtoList, int total,
                           List<KmCsFaqDTO> faqList) {
        this.cate = pageRequestDTO.getCate();
        this.pg = pageRequestDTO.getPg();
        this.size = pageRequestDTO.getSize();
        this.total = total;

        this.dtoList = dtoList;
        this.faqList = faqList;

        this.end = (int) (Math.ceil(this.pg / 10.0)) * 10;
        this.start = this.end - 9;
        int last = (int)(Math.ceil(total / (double)size));

        this.end = end > last ? last:end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
