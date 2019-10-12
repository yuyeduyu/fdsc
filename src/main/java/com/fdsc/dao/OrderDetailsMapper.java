package com.fdsc.dao;

import com.fdsc.model.OrderDetails;
import com.fdsc.model.Rfiduser;

import java.util.List;

public interface OrderDetailsMapper {
    public List<OrderDetails> findByColor(String color);
}