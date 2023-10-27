package com.example.kmarket.controller.cs;

import com.example.kmarket.dto.cs.KmCsCateDTO;
import com.example.kmarket.dto.cs.KmCsFaqDTO;
import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.dto.cs.KmCsTypeDTO;
import com.example.kmarket.service.cs.CsCateService;
import com.example.kmarket.service.cs.CsAPIService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/cs")
@RestController
@Slf4j
@RequiredArgsConstructor
public class CsAPIController {
    private final CsAPIService apiService;

    @GetMapping("/cateAll")
    public List<KmCsCateDTO> cateList() {
        return apiService.findAllCate();
    }


    @GetMapping("/typeByCate")
    public List<KmCsTypeDTO> typeList(@RequestParam String cate) {
        return apiService.TypefindByCate(cate);
    }

    @PostMapping("/qna/writing")
    public void postWrite(@RequestBody KmCsQnaDTO dto) {
        apiService.qnaSave(dto);
    }

    @DeleteMapping("/qna/cancel")
    public void postCancel(@RequestParam int qnaNo){
        apiService.qnaCancel(qnaNo);
    }


    @GetMapping("/faq/listByType")
    public List<KmCsFaqDTO> qnaList(@RequestParam int type) {
        return apiService.faqList(type);
    }
}
