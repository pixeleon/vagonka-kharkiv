package net.khpi.shevvaddm.vagonka.service;

import net.khpi.shevvaddm.vagonka.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAllOrders();


    OrderDto findOrderById(Long orderId);

    void saveOrder(OrderDto orderDto);

    void deleteOrderById(Long orderId);

    void insertOrder(OrderDto orderDto);
}
