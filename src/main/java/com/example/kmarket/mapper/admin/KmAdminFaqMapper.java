package com.example.kmarket.mapper.admin;

import com.example.kmarket.dto.admin.KmAdminCsCateDTO;
import com.example.kmarket.dto.admin.KmAdminCsTypeDTO;
import com.example.kmarket.dto.admin.KmAdminFaqDTO;
import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface KmAdminFaqMapper {

   // 페이징 - 전체 게시글 갯수 계산
   public int selectFaqCountTotal();

   // 게시글 리스트 10개씩 출력
   public List<KmAdminFaqDTO> selectCsFaqAll(int start);

   // 글 보기
   public KmAdminFaqDTO selectArticleFaq(int faqNo);

   // cateName, typeName 값 찾기
   public List<KmAdminCsCateDTO> findCname(KmAdminCsCateDTO kmAdminCsCateDTO);
   public List<KmAdminCsTypeDTO> findTname(String cate);

   // 글 작성
   public int insertArticleFaq(KmAdminFaqDTO kmAdminFaqDTO);

   // 글 수정
   public void updateArticleFaq(KmAdminFaqDTO kmAdminFaqDTO);

}
