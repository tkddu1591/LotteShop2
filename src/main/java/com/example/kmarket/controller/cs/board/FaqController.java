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
    private final KmFaqService kfs;
    private final CsCateService ccs;

    @GetMapping("/list")
    public String list(Model model, String cate) {
        KmCsCateDTO cateDTO = ccs.findByCate(cate);
        model.addAttribute("cateDto", cateDTO);

        List<KmCsFaqDTO> faqDTOList = kfs.selectFaqList(cate);
        log.info("faqDTOList : " + faqDTOList);

        /*
        List<KmCsTypeDTO> typeDTO = ccs.findByType(type);
        log.info("typeDTO : "+ typeDTO);
        for(KmCsTypeDTO types : typeDTO) {
            List<KmCsFaqDTO> faqBoard = new ArrayList<>();
            for(KmCsFaqDTO board : faqDTOList) {
                if(types.getType() == board.getType()) {
                    faqBoard.add(board);
                }
            }
            types.setFaqDTO(faqBoard);
        }

        model.addAttribute("typeDTO", typeDTO);*/
        model.addAttribute("faqDTOList", faqDTOList);

        return "cs/faq/list";
    }

    @GetMapping("/view")
    public String view() {
        return "cs/faq/view";
    }

}