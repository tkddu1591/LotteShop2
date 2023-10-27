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

    public List<KmCsTypeDTO> cateForType(String cate, int type){
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

    public List<KmCsTypeDTO> findByType(int type){
        List<KmCsTypeEntity> typeEntity = typeRepo.findByType(type);

        return typeEntity.stream()
                .map(typeMapper::toDTO)
                .toList();
    }

}
