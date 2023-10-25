package com.example.kmarket.dto.cs;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class CsPageResponseDTO {
    // 위에는 추가해야 되는 값
    private List<KmCsNoticeDTO> noticeList;
    private List<KmCsQnaDTO> qnaList;
    private List<KmCsFaqDTO> faqList;
    
    // 아래는 기본값
    private String cate;
    private int pg;
    private int size;
    private int total;
    private int last;

    private int start, end;
    private boolean prev, next;

    @Builder
    public CsPageResponseDTO(CsPageRequestDTO csPageRequestDTO,
                             List<KmCsNoticeDTO> noticeList, int total,
                             List<KmCsQnaDTO> qnaList,
                             List<KmCsFaqDTO> faqList) {
        this.cate = csPageRequestDTO.getCate();
        this.pg = csPageRequestDTO.getPg();
        this.size = csPageRequestDTO.getSize();
        this.total = total;

        this.noticeList = noticeList;
        this.qnaList = qnaList;
        this.faqList = faqList;

        // 이게 페이지 번호 개수 나타내는거임
        // 5로 잡으면 5개씩 페이지 출력함
        this.end = (int) (Math.ceil(this.pg / 5.0)) * 5;
        this.start = this.end - 4;

        int last = (int)(Math.ceil(total / (double)size));
        this.last = last;

        this.end = end > last ? last:end;
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;
    }
}
