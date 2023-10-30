package com.example.kmarket.mapper.admin;

import com.example.kmarket.dto.admin.KmAdminCsCateDTO;
import com.example.kmarket.dto.admin.KmAdminFaqDTO;
import com.example.kmarket.dto.admin.KmAdminQnaDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KmAdminQnaMapper {

    // 게시글 리스트 10개씩 출력
    public List<KmAdminQnaDTO> selectCsQnaAll(int start);

    // 글 보기
    public KmAdminQnaDTO selectArticleQna(int qnaNo);

    // 페이징 - 전체 상품 갯수 계산
    public int selectQnaCountTotal();

    // cateName 값 찾기
    public List<KmAdminCsCateDTO> findCname(KmAdminCsCateDTO kmAdminCsCateDTO);

    // typeName 값 찾기
    public List<KmAdminQnaDTO> selectTname(KmAdminQnaDTO kmAdminQnaDTO);

    // 답변 쓰기
    public void updateAnswerQna(KmAdminQnaDTO KmAdminQnaDTO);

    // 게시글 삭제
    public void deleteArticleQna(int qnaNo);

}
