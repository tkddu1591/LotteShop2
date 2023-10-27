package com.example.kmarket.controller.admin.cs;

import com.example.kmarket.dto.admin.KmAdminCsCateDTO;
import com.example.kmarket.dto.admin.KmAdminCsTypeDTO;
import com.example.kmarket.service.admin.KmAdminFaqService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@Log4j2
public class Faq_CateAndTypeController {

    @Autowired
    private KmAdminFaqService kmAdminFaqService;

    @GetMapping("/admin/faq/cate")
    public List<KmAdminCsCateDTO> getCsCate(KmAdminCsCateDTO kmAdminCsCateDTO){

        List<KmAdminCsCateDTO> findCname = kmAdminFaqService.findCname(kmAdminCsCateDTO);

        return findCname;
    }

    @GetMapping("/admin/faq/type/{cateValue}")
    public List<KmAdminCsTypeDTO> getCsType(@PathVariable("cateValue") String cateValue){

        List<KmAdminCsTypeDTO> findTname = kmAdminFaqService.findTname(cateValue);

        return findTname;
    }


}
