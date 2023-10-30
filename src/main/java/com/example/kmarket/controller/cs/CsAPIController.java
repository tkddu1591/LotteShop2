package com.example.kmarket.controller.cs;

import com.example.kmarket.dto.cs.KmCsCateDTO;
import com.example.kmarket.dto.cs.KmCsQnaDTO;
import com.example.kmarket.dto.cs.KmCsTypeDTO;
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
    public void qnaPostCancel(@RequestParam int qnaNo){
        apiService.qnaCancel(qnaNo);
    }
    @DeleteMapping("/notice/cancel")
    public void noticePostCancel(@RequestParam int noticeNo){
        apiService.noticeCancel(noticeNo);
    }
    @DeleteMapping("/faq/cancel")
    public void faqPostCancel(@RequestParam int faqNo){
        apiService.faqCancel(faqNo);
    }

}
