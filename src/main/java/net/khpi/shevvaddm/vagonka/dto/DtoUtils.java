package net.khpi.shevvaddm.vagonka.dto;

import net.khpi.shevvaddm.vagonka.model.Order;
import net.khpi.shevvaddm.vagonka.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DtoUtils {

    public Order mapOrderDtoToOrderEntity(OrderDto dto) {
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

    public OrderDto mapOrderEntityToOrderDto(Order order) {
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


    public UserDto mapUserEntityToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserId(userDto.getUserId());
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setUserRoleId(userDto.getUserRoleId());
        return userDto;
    }

    public User mapUserDtoToUserEntity(UserDto dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        return user;
    }

    //TO-DO
    public List<String> mapUserDtoToStringArray(UserDto dto) {
        List<String> result = new ArrayList<>();
        return result;
    }

    public List<String> mapAdminProductDtoToStringArray(AdminProductDto dto) {
        List<String> result = new ArrayList<>();
        result.add(dto.getTypeName());
        result.add(dto.getWoodType());
        result.add(dto.getWoodKind());
        result.add(String.valueOf(dto.getPrice()));
        result.add(dto.getMuAbbr());
        result.add(String.valueOf(dto.getAmount()));
        result.add(String.valueOf(dto.getVisible()));
        return result;
    }


}
