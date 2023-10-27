package com.example.kmarket.controller.cs.board;

import com.example.kmarket.service.cs.CsCateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.kmarket.dto.cs.CsPageRequestDTO;

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

        List<KmCsTypeDTO> cateDTOList = ccs.findByTypeForCate(cate);
        log.info("cateDTOList : "+ cateDTOList);

        for(KmCsTypeDTO cates : cateDTOList) {
            List<KmCsFaqDTO> faqBoard = new ArrayList<>();
            for(KmCsFaqDTO board : faqDTOList) {
                if(cates.getType() == board.getType()) {
                    faqBoard.add(board);
                }
            }
            cates.setFaqDTO(faqBoard);
            log.info("cates : " + cates);
        }

        model.addAttribute("cateDTOList", cateDTOList);
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