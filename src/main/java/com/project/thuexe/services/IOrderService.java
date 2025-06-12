package com.project.thuexe.services;

import com.project.thuexe.Response.OrderReponse;
import com.project.thuexe.dtos.OrderDTO;
import com.project.thuexe.models.Order;

import java.util.List;

public interface IOrderService {
    public Order createOrder (OrderDTO  orderDTO) throws Exception;
    Order updateOrder (long OrderId,OrderDTO orderDTO) throws Exception;
    Order getOrderId (long id) throws Exception;

    void deleteOrder (long id)throws Exception;

    List<Order> findByUserId (long id) throws Exception;
}
