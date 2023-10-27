package com.example.kmarket.service.cs;

import com.example.kmarket.dto.cs.KmCsCateDTO;
import com.example.kmarket.dto.cs.KmCsTypeDTO;
import com.example.kmarket.entity.cs.KmCsCateEntity;
import com.example.kmarket.entity.cs.KmCsTypeEntity;
import com.example.kmarket.mapper.cs.KmCsCateMapper;
import com.example.kmarket.mapper.cs.KmCsTypeMapper;
import com.example.kmarket.mapper.cs.MybatisCSMapper;
import com.example.kmarket.repository.cs.KmCsCateRepository;
import com.example.kmarket.repository.cs.KmCsTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class CsCateService {

    private final KmCsCateRepository cateRepo;
    private final KmCsCateMapper cateMapper;
    private final KmCsTypeRepository typeRepo;
    private final KmCsTypeMapper typeMapper;

    private final MybatisCSMapper mybatisCsMapper;

    public KmCsCateDTO findByCate(String cate){
        KmCsCateEntity entity = cateRepo.findByCate(cate);
        KmCsCateDTO dto = cateMapper.toDTO(entity);
        return dto;
    }

    // faq에서 cate에 따라 type 선택 하는 로직 -> ajax에서 사용
    public List<KmCsTypeDTO> cateForType(String cate, int type) {
        List<KmCsTypeEntity> cateEntityList = typeRepo.findByCateAndTypeLessThan(cate, type);
        log.info("ccs CateForType typeName : "+cateEntityList.toString());
        List<KmCsTypeDTO> dtoList
                = cateEntityList
                .stream()
                .map(typeMapper::toDTO)
                .toList();

        return dtoList;
    }

    public List<KmCsCateEntity> findAll(){
        List<KmCsCateEntity> cateEntityList = cateRepo.findAll();
        return cateEntityList;
    }

    // faq에서 cate별로 type을 출력하는 List
    public List<KmCsTypeDTO> findByTypeForCate(String cate){
        List<KmCsTypeDTO> typeDTO
                = mybatisCsMapper.findByTypeForCate(cate);
        log.info("@@@@@ CCS findByTypeForCate typeDTO : "+typeDTO);

        return typeDTO;
    }

}
