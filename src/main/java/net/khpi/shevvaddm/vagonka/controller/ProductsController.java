package net.khpi.shevvaddm.vagonka.controller;

import net.khpi.shevvaddm.vagonka.dto.AdminProductDto;
import net.khpi.shevvaddm.vagonka.dto.ProductMuDto;
import net.khpi.shevvaddm.vagonka.dto.ProductTypeDto;
import net.khpi.shevvaddm.vagonka.dto.SaveProductDto;
import net.khpi.shevvaddm.vagonka.service.ProductService;
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
public class ProductsController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
        List<AdminProductDto> productsDto = productService
                .findAllAdminProducts();
        model.addAttribute("products", productsDto);
        return "adminProducts";
    }

    @GetMapping("/edit-product")
    public String showProductSaveForm(@RequestParam Long productId,
            Model model) {
        SaveProductDto product = productService.findSaveProductById(productId);
        model.addAttribute("product", product);
        populateProductSaveForm(model);
        return "saveProduct";
    }

    @PostMapping("/edit-product")
    public String processProductSaveForm(
            @Valid @ModelAttribute("product") SaveProductDto productDto,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            populateProductSaveForm(model);
            return "saveProduct";
        } else {
            productService.saveProduct(productDto);
            return "redirect:/admin/products";
        }
    }

    @PostMapping("/delete-product")
    public String processProductRemoval(
            @RequestParam("productId") Long productId) {
        productService.deleteProductById(productId);
        return "redirect:/admin/products";
    }

    @GetMapping("/create-product")
    public String showProductCreateForm(Model model) {
        SaveProductDto product = new SaveProductDto();
        model.addAttribute("product", product);
        populateProductSaveForm(model);
        return "saveProduct";
    }

    @PostMapping("/create-product")
    public String processProductCreateForm(
            @Valid @ModelAttribute("product") SaveProductDto productDto,
            BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            populateProductSaveForm(model);
            return "saveProduct";
        } else {
            productService.saveProduct(productDto);
            return "redirect:/admin/products";
        }
    }

    private void populateProductSaveForm(Model model) {
        List<ProductTypeDto> productTypes = productService
                .findAllProductTypes();
        List<ProductMuDto> productMus = productService.findAllProductMus();
        model.addAttribute("productTypes", productTypes);
        model.addAttribute("productMus", productMus);
    }
}
