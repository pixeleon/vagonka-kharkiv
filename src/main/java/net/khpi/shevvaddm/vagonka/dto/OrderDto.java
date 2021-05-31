package net.khpi.shevvaddm.vagonka.dto;

import net.khpi.shevvaddm.vagonka.model.OrderStatus;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;

public class OrderDto {
    private Long orderId;

    @NotBlank
    private String customerName;

    @NotBlank
    private String customerPhone;

    @Email
    private String customerEmail;

    private String orderDetails;

    @PastOrPresent
    private LocalDateTime orderDate;

    private OrderStatus orderStatus;

    public OrderDto() {
    }

    public OrderDto(@NotBlank String customerName,
            @NotBlank String customerPhone, @Email String customerEmail,
            String orderDetails, @PastOrPresent LocalDateTime orderDate,
            OrderStatus orderStatus) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.orderDetails = orderDetails;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public OrderDto(Long orderId, @NotBlank String customerName,
            @NotBlank String customerPhone, @Email String customerEmail,
            String orderDetails, @PastOrPresent LocalDateTime orderDate,
            OrderStatus orderStatus) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.orderDetails = orderDetails;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
