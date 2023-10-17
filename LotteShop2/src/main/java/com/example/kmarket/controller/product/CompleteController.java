package com.example.kmarket.controller.product;

import com.example.kmarket.dto.KmProductCartDTO;
import com.example.kmarket.dto.KmProductOrderDTO;
import com.example.kmarket.dto.KmProductOrderItemDTO;
import com.example.kmarket.service.KmProductOrderItemService;
import com.example.kmarket.service.KmProductOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Slf4j
public class CompleteController {
    @Autowired
    KmProductOrderItemService kmProductOrderItemService;
    @Autowired
    KmProductOrderService kmProductOrderService;
    @GetMapping("/complete/list")
    public List<KmProductOrderItemDTO> listOrderItem(String uid){
        log.info(uid);
        int lastNo = kmProductOrderService.listOrderNo();
        log.info(uid, lastNo);
        return kmProductOrderItemService.findByUidByOrdNo(lastNo, uid);
    }
    @GetMapping("/complete/total")
    public KmProductOrderDTO lastOrdertotal(String uid){
        log.info(uid);
        return kmProductOrderService.findByOrdNo( uid);
    }



}
