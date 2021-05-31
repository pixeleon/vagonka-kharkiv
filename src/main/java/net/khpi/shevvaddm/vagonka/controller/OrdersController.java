package net.khpi.shevvaddm.vagonka.controller;

import net.khpi.shevvaddm.vagonka.dto.OrderDto;
import net.khpi.shevvaddm.vagonka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class OrdersController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public String showOrders(Model model) {
        List<OrderDto> orders = orderService.findAllOrders();
        model.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/edit-order")
    public String showOrderSaveForm(@RequestParam("orderId") Long orderId, Model model) {
        OrderDto order = orderService.findOrderById(orderId);
        model.addAttribute("order", order);
        return "saveOrder";
    }

    @PostMapping("/edit-order")
    public String processProductSaveForm(
            @Valid @ModelAttribute("order") OrderDto orderDto,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
//            populateProductSaveForm(model);
            return "saveOrder";
        } else {
            orderService.saveOrder(orderDto);
            return "redirect:/admin/orders";
        }
    }

    @PostMapping("/delete-order")
    public String processProductRemoval(
            @RequestParam("orderId") Long orderId) {
        orderService.deleteOrderById(orderId);
        return "redirect:/admin/orders";
    }


}
