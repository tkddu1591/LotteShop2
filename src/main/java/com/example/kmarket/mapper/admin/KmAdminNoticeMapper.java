package com.example.kmarket.mapper.admin;

import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KmAdminNoticeMapper {

    // 페이징 - 전체 게시글 갯수 계산
    public int selectNoticeCountTotal();

    // 게시글 리스트 10개씩 출력
    public List<KmAdminNoticeDTO> selectCsNoticeAll(int start);

    // 글 보기
    public KmAdminNoticeDTO selectArticleNotice(int noticeNo);

    // cateName 값 찾기
    public List<KmAdminNoticeDTO> findCateName(String cateName);

    // 게시글 작성
    public int insertArticleNotice(KmAdminNoticeDTO kmAdminNoticeDTO);

    // 게시글 수정
    public void updateArticleNotice(KmAdminNoticeDTO kmAdminNoticeDTO);

    // 게시글 삭제
    public int deleteAriticleNotice(int noticeNo);


}
