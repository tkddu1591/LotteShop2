package com.example.kmarket.controller.admin.product;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
public class ListController {


    @GetMapping("/admin/product/list")
    // 상품 목록 출력
    public String List() {

       // 이미지 상품코드 상품명 판매가격 할인율 포인트 재고 판매자 조회  필요
              km_product  thumb1 prodNo prodName price discount point stock seller hit



    }


}

