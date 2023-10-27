package com.example.kmarket.service.cs;

import com.example.kmarket.dto.cs.CsPageRequestDTO;
import com.example.kmarket.dto.cs.CsPageResponseDTO;
import com.example.kmarket.dto.cs.KmCsFaqDTO;
import com.example.kmarket.dto.cs.KmCsNoticeDTO;
import com.example.kmarket.entity.cs.KmCsFaqEntity;
import com.example.kmarket.entity.cs.KmCsNoticeEntity;
import com.example.kmarket.mapper.cs.KmCsFaqMapper;
import com.example.kmarket.mapper.cs.KmCsNoticeMapper;
import com.example.kmarket.mapper.cs.MybatisCSMapper;
import com.example.kmarket.repository.cs.KmCsFaqRepository;
import com.example.kmarket.repository.cs.KmCsNoticeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class KmFaqService {

    private final KmCsFaqRepository kmFaqRepo;
    private final KmCsFaqMapper mapper;

    private final MybatisCSMapper mybatisCsMapper;

   /* public CsPageResponseDTO findByCate(CsPageRequestDTO csPageRequestDTO) {
        // getPageable(뭘 가지고 정렬 할껀지 -> 칼럼명 적어주면 됨)
        Pageable pageable = csPageRequestDTO.getPageable("faqNo");

        // List 출력해주는 구문
        // -> size 수 만큼 List 출력
        Page<KmCsFaqEntity> result = null;
        result = kmFaqRepo.findByKmCsCateEntity_CateOrderByRdateDesc(pageable, csPageRequestDTO.getCate());
        // page의 List로 받은 걸 content List로 변경
        List<KmCsFaqDTO> faqList
                = result.getContent()
                .stream()
                .map(mapper::toDTO)
                .toList();

        // 페이지 정보
        int total = (int) result.getTotalElements();
        log.info("faq pageResponse faqList : " + faqList);

        return CsPageResponseDTO.builder()
                // content List
                .faqList(faqList)
                .csPageRequestDTO(csPageRequestDTO)
                .total(total)
                .build();
    }*/

    public List<KmCsFaqDTO> selectFaqList(String cate){
        List<KmCsFaqDTO> faqEntity = mybatisCsMapper.selectFaqList(cate);

        return faqEntity;
    }



}
