package com.project.thuexe.services;

import com.project.thuexe.Response.OrderReponse;
import com.project.thuexe.dtos.OrderDTO;
import com.project.thuexe.models.Order;

import java.util.List;

public interface IOrderService {
    public Order createOrder (OrderDTO  orderDTO) throws Exception;
    OrderReponse updateOrder (OrderDTO  orderDTO);
    OrderReponse getOrder (OrderDTO  orderDTO);

    void deleteOrder (OrderDTO  orderDTO);

    List<OrderReponse> getAllOrders (OrderDTO  orderDTO);
}
