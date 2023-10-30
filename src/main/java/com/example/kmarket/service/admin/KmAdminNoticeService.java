package com.example.kmarket.service.admin;

import com.example.kmarket.dto.admin.KmAdminCsCateDTO;
import com.example.kmarket.dto.admin.KmAdminCsTypeDTO;
import com.example.kmarket.dto.admin.KmAdminFaqDTO;
import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import com.example.kmarket.mapper.admin.KmAdminNoticeMapper;
import com.example.kmarket.mapper.cs.KmCsCateMapper;
import com.example.kmarket.repository.cs.KmCsCateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Log4j2
public class KmAdminNoticeService {

    private final KmAdminNoticeMapper kmAdminNoticeMapper;

    // 게시글 리스트 10개씩 출력
    public List<KmAdminNoticeDTO> selectCsNoticeAll(int start) {

        List<KmAdminNoticeDTO> selectCsNoticeAll = kmAdminNoticeMapper.selectCsNoticeAll(start);

        return selectCsNoticeAll;
    }


    // 페이징 시작
    public int selectNoticeCountTotal(){
        return kmAdminNoticeMapper.selectNoticeCountTotal();
    }


    public int getLastPageNum(int total) {

        int lastPageNum = 0;

        if(total % 10 == 0){
            lastPageNum = total / 10;
        }else{
            lastPageNum = total / 10 + 1;
        }

        return lastPageNum;
    }

    // 페이지 그룹
    public int[] getPageGroupNum(int currentPage, int lastPageNum) {
        int currentPageGroup = (int)Math.ceil(currentPage / 10.0);
        int pageGroupStart = (currentPageGroup - 1) * 10 + 1;
        int pageGroupEnd = currentPageGroup * 10;

        if(pageGroupEnd > lastPageNum){
            pageGroupEnd = lastPageNum;
        }

        int[] result = {pageGroupStart, pageGroupEnd};

        return result;
    }

    // 페이지 시작번호
    public int getPageStartNum(int total, int currentPage) {
        int start = (currentPage - 1) * 10;
        return total - start;
    }

    // 현재 페이지 번호
    public int getCurrentPage(String pg) {
        int currentPage = 1;

        if(pg != null){
            currentPage = Integer.parseInt(pg);
        }

        return currentPage;
    }

    // Limit 시작번호
    public int getStartNum(int currentPage) {
        return (currentPage - 1) * 10;
    }

    // 글 보기
    public KmAdminNoticeDTO selectArticleNotice(int noticeNo){

        KmAdminNoticeDTO kmAdminNoticeDTO = kmAdminNoticeMapper.selectArticleNotice(noticeNo);

        return kmAdminNoticeDTO;
    }

    // cateName 찾기
    public List<KmAdminCsCateDTO> findCname(KmAdminCsCateDTO kmAdminCsCateDTO){

        return kmAdminNoticeMapper.findCname(kmAdminCsCateDTO);
    }

    // AJAX typeName 찾기
    public List<KmAdminCsTypeDTO> findTname(String cate){

        return kmAdminNoticeMapper.findTname(cate);
    }

    // 글 쓰기
    public int insertArticleNotice(KmAdminNoticeDTO kmAdminNoticeDTO){

        return kmAdminNoticeMapper.insertArticleNotice(kmAdminNoticeDTO);

    }

    // 글 수정
    public void updateArticleNotice(KmAdminNoticeDTO kmAdminNoticeDTO){

        kmAdminNoticeMapper.updateArticleNotice(kmAdminNoticeDTO);
    }

    // 글 삭제
    public void deleteArticleNotice(int noticeNo){

        kmAdminNoticeMapper.deleteArticleNotice(noticeNo);
    }

}
