package net.khpi.shevvaddm.vagonka.service;

import net.khpi.shevvaddm.vagonka.dto.OrderDto;
import net.khpi.shevvaddm.vagonka.model.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderService {
    List<OrderDto> findAllOrders();


    OrderDto findOrderById(Long orderId);

    void saveOrder(OrderDto orderDto);

    @Transactional
    void deleteOrderById(Long orderId);

    @Transactional
    void insertOrder(OrderDto orderDto);
}
