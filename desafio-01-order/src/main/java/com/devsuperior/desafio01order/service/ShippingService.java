package com.devsuperior.desafio01order.service;

import com.devsuperior.desafio01order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ShippingService {


    public ShippingService() {
    }
    public Double shipment(Order order){
        var basic = order.getBasic();
        if (basic < 100){
            return 20d;
        }else
            if (basic>100 && basic<200) {
                return 12d;
        }
        else{
            return 0d;
            }

    }



}
