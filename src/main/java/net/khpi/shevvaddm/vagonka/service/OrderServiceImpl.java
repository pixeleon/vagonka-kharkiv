package net.khpi.shevvaddm.vagonka.service;

import net.khpi.shevvaddm.vagonka.dao.OrderDao;
import net.khpi.shevvaddm.vagonka.dto.DtoUtils;
import net.khpi.shevvaddm.vagonka.dto.OrderDto;
import net.khpi.shevvaddm.vagonka.model.Order;
import net.khpi.shevvaddm.vagonka.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private DtoUtils dtoUtils;
    private OrderDao orderDao;

    @Autowired
    public void setDtoUtils(DtoUtils dtoUtils) {
        this.dtoUtils = dtoUtils;
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<OrderDto> findAllOrders() {
        return orderDao
                .findAll()
                .stream()
                .map(dtoUtils::mapOrderEntityToOrderDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public OrderDto findOrderById(Long orderId) {
        return dtoUtils.mapOrderEntityToOrderDto(orderDao.getById(orderId));
    }

    @Transactional
    @Override
    public void saveOrder(OrderDto orderDto) {
        orderDto.setOrderStatus(OrderStatus.NEW);
        orderDao.save(dtoUtils.mapOrderDtoToOrderEntity(orderDto));
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
        orderDao.save(dtoUtils.mapOrderDtoToOrderEntity(orderDto));
    }

}
