package net.khpi.shevvaddm.vagonka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "ORD_ER")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID")
    private Long orderId;

    @NotBlank
    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @NotBlank
    @Column(name = "CUSTOMER_PHONE")
    private String customerPhone;

    @Email
    @Column(name = "CUSTOMER_EMAIL")
    private String customerEmail;

    @Column(name = "ORDER_DETAILS")
    private String orderDetails;

    @Column(name = "ORDER_DATE")
    private LocalDateTime orderDate;

    @NotNull
    @Column(name = "ORDER_STATUS")
    @Enumerated
    private OrderStatus orderStatus;

    public Order() {
    }

    public Order(String customerName, String customerPhone,
            String customerEmail, String orderDetails, LocalDateTime orderDate,
            OrderStatus orderStatus) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.orderDetails = orderDetails;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }

    public Order(Long orderId, String customerName, String customerPhone,
            String customerEmail, String orderDetails, LocalDateTime orderDate,
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

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerName='"
                + customerName + '\'' + ", customerPhone='" + customerPhone
                + '\'' + ", customerEmail='" + customerEmail + '\''
                + ", orderDetails='" + orderDetails + '\'' + ", orderDate="
                + orderDate + ", orderStatus=" + orderStatus + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Order))
            return false;
        Order order = (Order) o;
        return orderId.equals(order.orderId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
