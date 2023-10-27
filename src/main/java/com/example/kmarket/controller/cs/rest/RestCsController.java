package com.example.kmarket.controller.cs.rest;

import com.example.kmarket.dto.cs.KmCsFileDTO;
import com.example.kmarket.dto.cs.KmCsTypeDTO;
import com.example.kmarket.entity.cs.KmCsTypeEntity;
import com.example.kmarket.service.cs.CsCateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cs/*")
@RestController
@RequiredArgsConstructor
@Log4j2
public class RestCsController {

    public final CsCateService ccs;

    // cate로 type 찾기
    @GetMapping("/cate")
    public List<KmCsTypeDTO> cateForType(String optionValue, int type){
        log.info(optionValue);
        return ccs.cateForType(optionValue, 90);
    }

    @PostMapping("/files")
    public List<KmCsFileDTO> files(String qnaNo){

        return null;
    }


}
