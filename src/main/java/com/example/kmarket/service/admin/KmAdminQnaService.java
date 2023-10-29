package com.example.kmarket.service.admin;

import com.example.kmarket.dto.admin.KmAdminCsCateDTO;
import com.example.kmarket.dto.admin.KmAdminFaqDTO;
import com.example.kmarket.dto.admin.KmAdminQnaDTO;
import com.example.kmarket.mapper.admin.KmAdminQnaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
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
public class KmAdminQnaService {


    private final KmAdminQnaMapper kmAdminQnaMapper;

    // 게시글 리스트 10개씩 출력
    public List<KmAdminQnaDTO> selectCsQnaAll(int start){

        List<KmAdminQnaDTO> qnaList = kmAdminQnaMapper.selectCsQnaAll(start);

        return qnaList;
    }

    // 중복을 제거하는 람다 함수
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    // 유형 선택 중복 제거
    public List<KmAdminQnaDTO> distinctCate(int start){

        List<KmAdminQnaDTO> qnaList = kmAdminQnaMapper.selectCsQnaAll(start);

        List<KmAdminQnaDTO> distinctCate = qnaList.stream()
                .filter(distinctByKey(KmAdminQnaDTO::getCate))
                .collect(Collectors.toList());

        return  distinctCate;
    }


    // 페이징 시작
    public int selectQnaCountTotal(){
        return kmAdminQnaMapper.selectQnaCountTotal();
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
    public KmAdminQnaDTO selectArticleQna(int qnaNo){

        KmAdminQnaDTO kmAdminQnaDTO = kmAdminQnaMapper.selectArticleQna(qnaNo);

        return kmAdminQnaDTO;
    }

    // cateName 찾기
    public List<KmAdminCsCateDTO> findCname(KmAdminCsCateDTO kmAdminCsCateDTO){

        return kmAdminQnaMapper.findCname(kmAdminCsCateDTO);
    }

    // typeName 찾기
    public List<KmAdminQnaDTO> selectTname(KmAdminQnaDTO kmAdminQnaDTO){

        return kmAdminQnaMapper.selectTname(kmAdminQnaDTO);
    }

    // 답변 쓰기
    public void updateAnswerQna(KmAdminQnaDTO KmAdminQnaDTO){

        kmAdminQnaMapper.updateAnswerQna(KmAdminQnaDTO);

    }

    // 게시글 삭제
    public void deleteArticleQna(int qnaNo){

        kmAdminQnaMapper.deleteArticleQna(qnaNo);

    }
}
