package com.example.kmarket.service.cs;

import com.example.kmarket.dto.KmProductCartDTO;
import com.example.kmarket.dto.cs.*;
import com.example.kmarket.entity.KmProductCartEntity;
import com.example.kmarket.entity.cs.KmCsCateEntity;
import com.example.kmarket.entity.cs.KmCsNoticeEntity;
import com.example.kmarket.entity.cs.KmCsTypeEntity;
import com.example.kmarket.mapper.cs.KmCsCateMapper;
import com.example.kmarket.mapper.cs.KmCsNoticeMapper;
import com.example.kmarket.mapper.cs.KmCsTypeMapper;
import com.example.kmarket.repository.cs.KmCsCateRepository;
import com.example.kmarket.repository.cs.KmCsNoticeRepository;
import com.example.kmarket.repository.cs.KmCsTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class KmNoticeService {

    private final KmCsNoticeRepository repo;
    private final KmCsNoticeMapper mapper;
    private final KmCsTypeRepository kmCsTypeRepository;
    private final KmCsTypeMapper kmCsTypeMapper;
    private final KmCsCateRepository kmCsCateRepository;
    private final KmCsCateMapper kmCsCateMapper;

    public PageResponseDTO findByCate(PageRequestDTO pageRequestDTO){
        // getPageable(뭘 가지고 정렬 할껀지 -> 칼럼명 적어주면 됨)
        Pageable pageable = pageRequestDTO.getPageable("noticeNo");
        log.info("pageable : " + pageable);


        // List 출력해주는 구문
        // -> size 수 만큼 List 출력
        Page<KmCsNoticeEntity> result
                = repo.findByKmCsCateEntity_Cate(pageable, pageRequestDTO.getCate());
        log.info("noticeEntity result : " + result.getTotalElements());

        // page의 List로 받은 걸 content List로 변경
        List<KmCsNoticeDTO> dtoList
                = result.getContent()
                        .stream()
                        .map(mapper::toDTO)
                        .toList();
        log.info("noticeDTO dtoList : " + dtoList.size());

        // 페이지 정보
        int total = (int) result.getTotalElements();

        // builder로 리턴 받으면 됨
        // -> pageRequestDTO, dtoList, total이 필수, 그 외는 선택
        return PageResponseDTO.builder()
                // content List
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .total(total)
                .build();
    }

    public void saveNotice(KmCsNoticeDTO dto){
        KmCsNoticeEntity entity = mapper.toEntity(dto);
        repo.save(entity);
    }

    public KmCsNoticeDTO findById(int noticeNo){
        KmCsNoticeEntity entity = repo.findById(noticeNo).get();
        KmCsNoticeDTO dto = mapper.toDTO(entity);
        return dto;
    }

    public KmCsCateDTO findByCate(String cate){
        KmCsCateEntity entity = kmCsCateRepository.findByCate(cate);
        KmCsCateDTO dto = kmCsCateMapper.toDTO(entity);
        return dto;
    }

    public List<KmCsNoticeDTO> findAll(){
        List<KmCsNoticeEntity> entity = repo.findAll();
        return entity.stream().map(mapper::toDTO).toList();
    }

    public List<KmCsNoticeDTO> find(String cate){
        List<Object[]> objects = repo.findNoticeAndCateAndTypeByCate(cate);

        KmCsNoticeDTO dto = null;
        List<KmCsNoticeDTO>  notices = new ArrayList<>();
        for (Object[] result : objects) {
            KmCsNoticeEntity noticeEntity = (KmCsNoticeEntity) result[0];
            log.info("result : " + result[0]);
            String cateName = (String) result[1];

            KmCsTypeEntity typeEntity = null;
            if(cate.equals("all")){
                typeEntity = kmCsTypeRepository.findAll().get(0);
            }else{
                typeEntity = kmCsTypeRepository.findByTypeAndCate(noticeEntity.getType(),cate);
            }
            KmCsTypeDTO typeDTO = kmCsTypeMapper.toDTO(typeEntity);

            dto = mapper.toDTO(noticeEntity);
            dto.setTypeName(typeDTO.getTypeName());
            dto.setCateName(cateName);
            notices.add(dto);
        }
        return notices;
    }



}
