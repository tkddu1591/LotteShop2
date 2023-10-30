package com.example.kmarket.controller.product;

import com.example.kmarket.dto.product.KmProductOrderDTO;
import com.example.kmarket.dto.product.KmProductOrderItemDTO;
import com.example.kmarket.mapper.product.KmProdcutOrderItemMapper;
import com.example.kmarket.service.member.KmMemberPointService;
import com.example.kmarket.service.product.KmProductOrderItemService;
import com.example.kmarket.service.product.KmProductOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//RequestMappin 이거 2단으로 뚫으면 프록시 에러뜸 왜지
@RestController
@Slf4j
@RequestMapping("/product")
public class OrderController {
    @Autowired
    KmProductOrderService kmProductOrderService;
    @Autowired
    KmProductOrderItemService kmProductOrderItemService;
    @Autowired
    KmProdcutOrderItemMapper kmProdcutOrderItemMapper;
    @Autowired
    KmMemberPointService kmMemberPointService;
    @PostMapping("/order/total")
    public void saveOrderTotal(@RequestBody KmProductOrderDTO orderEnd) {
        log.info(orderEnd.toString());
        kmProductOrderService.save(orderEnd);
    }

    @GetMapping("/order/total")
    public KmProductOrderDTO listCart() {
        return kmProductOrderService.findByLast();
    }

    @PostMapping("/order/products")
    public void orderTotals(@RequestBody List<KmProductOrderItemDTO> orderProducts) {
        int lastNo = kmProductOrderService.listOrderNo();
        for(KmProductOrderItemDTO orderProduct : orderProducts) {
            orderProduct.setOrdNo(lastNo);
        }
        kmProductOrderItemService.save(orderProducts);
        kmProductOrderService.newSave();
    }
    @DeleteMapping("/order/delete")
    public void deleteOrder(@RequestParam int ordNo) {
        kmProductOrderService.delete(ordNo);
    }

    @PostMapping("/order/complete")
    public void receiveCheck(@RequestBody KmProductOrderDTO orderReceive) {
        kmProductOrderService.receiveCheck(orderReceive);
    }
}
