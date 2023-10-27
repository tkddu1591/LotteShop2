package com.example.kmarket.service.cs;

import com.example.kmarket.dto.cs.KmCsCateDTO;
import com.example.kmarket.dto.cs.KmCsFaqDTO;
import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.dto.cs.KmCsTypeDTO;
import com.example.kmarket.entity.cs.KmCsQnaEntity;
import com.example.kmarket.mapper.cs.KmCsCateMapper;
import com.example.kmarket.mapper.cs.KmCsFaqMapper;
import com.example.kmarket.mapper.cs.KmCsQnaMapper;
import com.example.kmarket.mapper.cs.KmCsTypeMapper;
import com.example.kmarket.repository.cs.KmCsCateRepository;
import com.example.kmarket.repository.cs.KmCsFaqRepository;
import com.example.kmarket.repository.cs.KmCsQnaRepository;
import com.example.kmarket.repository.cs.KmCsTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class CsAPIService {

    private final KmCsCateRepository cateRepo;
    private final KmCsCateMapper cateMapper;

    private final KmCsTypeRepository typeRepo;
    private final KmCsTypeMapper typeMapper;

    private final KmCsQnaRepository qnaRepository;
    private final KmCsQnaMapper qnaMapper;

    private final KmCsFaqRepository faqRepository;
    private final KmCsFaqMapper faqMapper;
    public List<KmCsTypeDTO> TypefindByCate(String cate) {
        return typeRepo.findByCate(cate).stream().map(typeMapper::toDTO).toList();
    }

    public List<KmCsCateDTO> findAllCate() {
        return cateRepo.findAll().stream().map(cateMapper::toDTO).toList();
    }

    public void qnaSave(KmCsQnaDTO dto) {
        qnaRepository.save(qnaMapper.toEntity(dto));
    }

    public void qnaCancel(int qnaNo) {
        KmCsQnaEntity qnaEntity = qnaRepository.findByQnaNo(qnaNo);
        qnaEntity.setAnswerComplete(3);
        qnaRepository.save(qnaEntity);
    }


    public List<KmCsFaqDTO> faqList(int type) {
        return faqRepository.findTop10ByKmCsTypeEntity_TypeOrderByFaqNoDesc(type).stream().map(faqMapper::toDTO).toList();
    }
}
