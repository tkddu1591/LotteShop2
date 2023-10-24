package com.example.kmarket.mapper.admin;

import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KmAdminNoticeMapper {

    // 게시글 리스트 10개씩 출력
    public List<KmAdminNoticeDTO> selectCsNoticeAll(int start);

    // 글 보기
    public KmAdminNoticeDTO selectArticleNotice(int noticeNo);

    // 페이징
    // 전체 게시글 갯수 계산
    public int selectNoticeCountTotal();

    // cateName, typeName 값 찾기
    public List<KmAdminNoticeDTO> findCateNameAndTypeName(String cateName, String typeName);

    // 게시글 작성
    public int insertArticleNotice(KmAdminNoticeDTO kmAdminNoticeDTO);


}
