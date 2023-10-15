package com.example.kmarket.controller.product;

import com.example.kmarket.dto.KmProductOrderDTO;
import com.example.kmarket.dto.KmProductOrderItemDTO;
import com.example.kmarket.service.KmProductOrderItemService;
import com.example.kmarket.service.KmProductOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@Slf4j
@RequestMapping("/product")
public class OrderItemController {
    @Autowired
    KmProductOrderItemService kmProductOrderItemService;

    @Autowired
    KmProductOrderService kmProductOrderService;


/*    @PostMapping("/order/allItems")
    public void saveOrderItem(@RequestBody List<KmProductOrderItemDTO> orderProducts , String ordUid) {
        log.info(ordUid);
        int lastOrderNo = kmProductOrderService.listOrderNo(ordUid);
        for (KmProductOrderItemDTO order : orderProducts) {
            log.info(order.toString());
            order.setOrdNo(lastOrderNo);
        }

        kmProductOrderItemService.save(orderProducts);
    }*/



}
