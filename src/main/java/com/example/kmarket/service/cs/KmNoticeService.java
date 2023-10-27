package com.example.kmarket.service.cs;

import com.example.kmarket.dto.cs.*;
import com.example.kmarket.entity.cs.KmCsNoticeEntity;
import com.example.kmarket.mapper.cs.KmCsCateMapper;
import com.example.kmarket.mapper.cs.KmCsNoticeMapper;
import com.example.kmarket.mapper.cs.KmCsTypeMapper;
import com.example.kmarket.mapper.cs.MybatisCSMapper;
import com.example.kmarket.repository.cs.KmCsCateRepository;
import com.example.kmarket.repository.cs.KmCsNoticeRepository;
import com.example.kmarket.repository.cs.KmCsTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class KmNoticeService {

    private final KmCsNoticeRepository kmNoticeRepo;
    private final KmCsNoticeMapper mapper;
    private final KmCsTypeRepository kmCsTypeRepository;
    private final KmCsTypeMapper kmCsTypeMapper;
    private final KmCsCateRepository kmCsCateRepository;
    private final KmCsCateMapper kmCsCateMapper;

    private final MybatisCSMapper mybatisCsMapper;

    public CsPageResponseDTO findByCate(CsPageRequestDTO csPageRequestDTO) {
        // getPageable(뭘 가지고 정렬 할껀지 -> 칼럼명 적어주면 됨)
        Pageable pageable = csPageRequestDTO.getPageable("noticeNo");

        // List 출력해주는 구문
        // -> size 수 만큼 List 출력
        Page<KmCsNoticeEntity> result = null;
        if(csPageRequestDTO.getCate().equals("all")){
            result = kmNoticeRepo.findAll(pageable);
        }else {
            result = kmNoticeRepo.findByKmCsCateEntity_CateOrderByRdateDesc(pageable, csPageRequestDTO.getCate());
        }
        // page의 List로 받은 걸 content List로 변경
        List<KmCsNoticeDTO> noticeList
                = result.getContent()
                        .stream()
                        .map(mapper::toDTO)
                        .toList();

        // 페이지 정보
        int total = (int) result.getTotalElements();
        log.info("notice pageResponse noticeList : " + noticeList);

        // builder로 리턴 받으면 됨
        // -> pageRequestDTO, dtoList(responsDTO에서 설정한 변수값) , total이 필수, 그 외는 선택
        return CsPageResponseDTO.builder()
                // content List
                .noticeList(noticeList)
                .csPageRequestDTO(csPageRequestDTO)
                .total(total)
                .build();
    }

    public void saveNotice(KmCsNoticeDTO dto) {
        KmCsNoticeEntity entity = mapper.toEntity(dto);
        kmNoticeRepo.save(entity);
    }

    public KmCsNoticeDTO findById(int noticeNo) {
        log.info("@@@@@@@@@ notice Service noticeNo : " + noticeNo);
        KmCsNoticeEntity entity = kmNoticeRepo.findById(noticeNo).get();
        KmCsNoticeDTO dto = mapper.toDTO(entity);
        return dto;
    }

    public List<KmCsNoticeDTO> findAll() {
        List<KmCsNoticeEntity> entity = kmNoticeRepo.findAll();
        return entity.stream()
                    .map(mapper::toDTO)
                    .toList();
    }

    public List<KmCsNoticeDTO> indexNoticeList(){
        List<KmCsNoticeDTO> noticeList = mybatisCsMapper.indexNoticeList();
        log.info("!!!!!!!!!!!!!!!!!!!!!!!!!notice List : " + noticeList);

/*        return noticeList.stream()
                .map(mapper::toDTO)
                .toList();*/
        return noticeList;
    }
}
