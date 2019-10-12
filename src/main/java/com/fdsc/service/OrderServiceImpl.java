package com.fdsc.service;

import com.fdsc.dao.OrderDetailsMapper;
import com.fdsc.dao.RfiduserMapper;
import com.fdsc.model.OrderDetails;
import com.fdsc.model.Rfiduser;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderDetailsMapper orderDetailsMapper;

    public String  findOrderByColor(String color) {
        List<OrderDetails>list= orderDetailsMapper.findByColor(color);
        return  new Gson().toJson(list);
    }
}
