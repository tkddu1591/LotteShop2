package com.example.kmarket.mapper.admin;

import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface KmAdminNoticeMapper {

    public List<KmAdminNoticeDTO> selectCsNoticeAll(int start);

    // 페이징
    // 전체 게시글 갯수 계산
    public int selectNoticeCountTotal();
    // 게시글 10개씩 출력
    public List<KmAdminNoticeDTO> selectNoticesCurrentPage(int start);

    // 글 보기
    public KmAdminNoticeDTO selectArticleNotice(int noticeNo);

}
