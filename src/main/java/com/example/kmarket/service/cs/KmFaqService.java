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

    public List<KmCsFaqDTO> selectFaqList(String cate){
        List<KmCsFaqDTO> faqCate = mybatisCsMapper.selectFaqList(cate);

        return faqCate;
    }

    public KmCsFaqDTO findById(int faqNo){
        KmCsFaqEntity entity = kmFaqRepo.findById(faqNo).get();
        KmCsFaqDTO dto = mapper.toDTO(entity);
        log.info("viewProd dto: " + dto);

        return dto;
    }
}
