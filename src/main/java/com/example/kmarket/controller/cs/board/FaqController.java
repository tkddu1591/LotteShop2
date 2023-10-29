package com.example.kmarket.controller.cs.board;

import com.example.kmarket.dto.cs.*;
import com.example.kmarket.service.cs.CsCateService;
import com.example.kmarket.service.cs.KmFaqService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/cs/faq/*")
@RequiredArgsConstructor
@Controller
@Log4j2
public class FaqController {

    private final KmFaqService fs;
    private final CsCateService ccs;

    @GetMapping("/list")
    public String list(Model model, String cate) {
        KmCsCateDTO cateDTO = ccs.findByCate(cate);
        model.addAttribute("cateDto", cateDTO);

        List<KmCsFaqDTO> faqDTOList = fs.selectFaqList(cate);
        log.info("faqDTOList : " + faqDTOList);

        List<KmCsTypeDTO> typeDTOList = ccs.findByTypeForCate(cate);
        log.info("typeDTOList : "+ typeDTOList);

        for(KmCsTypeDTO typeDTO : typeDTOList) {
            List<KmCsFaqDTO> faqBoard = new ArrayList<>();
            int i = 0;
            for(KmCsFaqDTO board : faqDTOList) {
                if(typeDTO.getType() == board.getType()) {
                    board.setIndex(i);
                    i++;
                    faqBoard.add(board);
                }
            }
            typeDTO.setFaqDTO(faqBoard);
            log.info("typeDTO : " + typeDTO);
        }

        model.addAttribute("typeDTOList", typeDTOList);
        model.addAttribute("faqDTOList", faqDTOList);
        return "cs/faq/list";
    }

    @GetMapping("/view")
    public String view(Model model, int no) {
        KmCsFaqDTO dto = fs.findById(no);
        model.addAttribute("faq", dto);

        return "cs/faq/view";
    }


}