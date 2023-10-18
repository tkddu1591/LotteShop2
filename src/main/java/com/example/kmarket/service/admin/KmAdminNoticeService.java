package com.example.kmarket.service.admin;

import com.example.kmarket.dto.admin.PageRequestDTO;
import com.example.kmarket.dto.admin.KmAdminNoticeDTO;
import com.example.kmarket.dto.admin.PageResponseDTO;
import com.example.kmarket.entity.admin.KmAdminNoticeEntity;
import com.example.kmarket.mapper.admin.KmAdminNoticeMapper;
import com.example.kmarket.mapper.cs.KmCsCateMapper;
import com.example.kmarket.repository.admin.KmAdminNoticeRepository;
import com.example.kmarket.repository.cs.KmCsCateRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Log4j2
public class KmAdminNoticeService {

    private final KmAdminNoticeRepository kmAdminNoticeRepository;
    private final KmAdminNoticeMapper kmAdminNoticeMapper;
    private final KmCsCateRepository kmCsCateRepository;
    private final KmCsCateMapper kmCsCateMapper;

    public PageResponseDTO findByCate(PageRequestDTO pageRequestDTO) {

       /* // getPageable(뭘 가지고 정렬 할껀지 -> 칼럼명 적어주면 됨)
        Pageable pageable = pageRequestDTO.getPageable("noticeNo");

        // 관리자 - 공지사항 페이지는 전체 카테고리가 없기 때문에 result = kmNoticeRepo.findAll(pageable); 사용 X
        Page<KmAdminNoticeEntity> result = kmAdminNoticeRepository.findByKmCsCateEntity_Cate(pageable, pageRequestDTO.getCate());

        // page의 List로 받은 걸 content List로 변경
        List<KmAdminNoticeDTO> dtoList = result.getContent().stream().map(kmAdminNoticeMapper::toDTO).toList();
        
        // 페이지 정보
        int total = (int) result.getTotalElements();

        // builder로 리턴 받으면 됨
        // -> pageRequestDTO, dtoList, total이 필수, 그 외는 선택
        return PageResponseDTO.builder()
                // content List
                .dtoList(dtoList)
                .pageRequestDTO(pageRequestDTO)
                .total(total)
                .build();*/
        return null;
    }

}
