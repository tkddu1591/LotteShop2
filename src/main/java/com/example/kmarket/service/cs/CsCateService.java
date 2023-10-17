package com.example.kmarket.service.cs;

import com.example.kmarket.dto.cs.KmCsCateDTO;
import com.example.kmarket.mapper.cs.KmCsCateMapper;
import com.example.kmarket.mapper.cs.KmCsTypeMapper;
import com.example.kmarket.repository.cs.KmCsCateRepository;
import com.example.kmarket.repository.cs.KmCsTypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CsCateService {

    private final KmCsCateRepository cateRepo;
    private final KmCsCateMapper cateMapper;

    private final KmCsTypeRepository typeRepo;
    private final KmCsTypeMapper typeMapper;

    public KmCsCateDTO findByCate(String cate){
        return cateMapper.toDTO(cateRepo.findByCate(cate));
    }
}
