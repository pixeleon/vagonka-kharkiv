package net.khpi.shevvaddm.vagonka.controller;

import net.khpi.shevvaddm.vagonka.dto.OrderDto;
import net.khpi.shevvaddm.vagonka.dto.UserProductDto;
import net.khpi.shevvaddm.vagonka.service.OrderService;
import net.khpi.shevvaddm.vagonka.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    private ProductService productService;
    private OrderService orderService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/index")
    public String showMain(Model model) {
        return "index";
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<UserProductDto> products = productService.findAllUserProducts();
        model.addAttribute("products", products);
        return "userProducts";
    }

    @GetMapping("/about")
    public String showAbout() {
        return "about";
    }

    @GetMapping("/make-order")
    public String showMakeOrderForm(Model model) {
        OrderDto order = new OrderDto();
        model.addAttribute("order", order);
        return "makeOrder";
    }

    @PostMapping("/make-order")
    public String processMakeOrderForm(
            @Valid @ModelAttribute("order") OrderDto orderDto,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            //            populateProductSaveForm(model);
            return "makeOrder";
        } else {
            orderService.saveOrder(orderDto);
            return "redirect:/index";
        }
    }
}
