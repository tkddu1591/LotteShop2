package com.example.kmarket.controller.admin.product;

import com.example.kmarket.dto.KmMemberDTO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class ListController {

    /*
    @GetMapping("/admin/product/list")
    public String List(HttpServletRequest req) {
        // 검색조건과 검색내용 가져오기
        String searchType = req.getParameter("searchType");
        if (searchType == null || searchType.equals("null")) {
            searchType = "prodName";
        }
        String search = req.getParameter("search");
        if (search == null || search.equals("null")) {
            search = "";
        }
        // 현재 페이지 가져오기
        String pg = req.getParameter("pg");

        // 세션에서 현재 로그인 사용자의 정보를 가져온다
        KmMemberDTO member = (KmMemberDTO) req.getSession().getAttribute("sessMember");

        // 검색조건들을 모으기 위한 form

    }

     */
}

