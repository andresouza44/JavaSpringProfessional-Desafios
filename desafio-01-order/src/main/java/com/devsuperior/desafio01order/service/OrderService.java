package com.devsuperior.desafio01order.service;

import com.devsuperior.desafio01order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    ShippingService shippingService;

    public Double total (Order order){
        var basic = order.getBasic();
        return basic + shippingService.shipment(order) - order.getDiscount()*basic/100;
    }

}
