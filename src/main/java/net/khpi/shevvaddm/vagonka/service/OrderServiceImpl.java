package net.khpi.shevvaddm.vagonka.service;

import net.khpi.shevvaddm.vagonka.dao.OrderDao;
import net.khpi.shevvaddm.vagonka.dto.OrderDto;
import net.khpi.shevvaddm.vagonka.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<OrderDto> findAllOrders() {
        return orderDao.findAll().stream().map(this::mapOrderEntityToOrderTo)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public OrderDto findOrderById(Long orderId) {
        return mapOrderEntityToOrderTo(orderDao.getById(orderId));
    }

    @Transactional
    @Override
    public void saveOrder(OrderDto orderDto) {
        orderDao.save(mapOrderDtoToOrderEntity(orderDto));
    }


    @Transactional
    @Override
    public void deleteOrderById(Long orderId) {
        Order order = orderDao.getById(orderId);
        orderDao.delete(order);
    }

    @Transactional
    @Override
    public void insertOrder(OrderDto orderDto) {
        orderDao.save(mapOrderDtoToOrderEntity(orderDto));
    }

    private Order mapOrderDtoToOrderEntity(OrderDto dto) {
        Order order = new Order();
        order.setOrderId(dto.getOrderId());
        order.setCustomerName(dto.getCustomerName());
        order.setCustomerPhone(dto.getCustomerPhone());
        order.setCustomerEmail(dto.getCustomerEmail());
        order.setOrderDetails(dto.getOrderDetails());
        order.setOrderDate(dto.getOrderDate());
        order.setOrderStatus(dto.getOrderStatus());
        return order;
    }



    private OrderDto mapOrderEntityToOrderTo(Order order) {
        OrderDto dto = new OrderDto();
        dto.setOrderId(order.getOrderId());
        dto.setCustomerName(order.getCustomerName());
        dto.setCustomerPhone(order.getCustomerPhone());
        dto.setCustomerEmail(order.getCustomerEmail());
        dto.setOrderDetails(order.getOrderDetails());
        dto.setOrderDate(order.getOrderDate());
        dto.setOrderStatus(order.getOrderStatus());
        return dto;
    }
}
