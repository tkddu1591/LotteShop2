package com.example.kmarket.mapper.admin;

import com.example.kmarket.dto.admin.KmAdminQnaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KmAdminQnaMapper {

    public List<KmAdminQnaDTO> selectCsQnaAll(int start);

    // 페이징
    // 전체 상품 갯수 계산
    public int selectQnaCountTotal();
    // 게시글 10개씩 출력
    public List<KmAdminQnaDTO> selectQnaCurrentPage(int start);

    // 글 보기
    public KmAdminQnaDTO selectArticleQna(int qnaNo);
}
