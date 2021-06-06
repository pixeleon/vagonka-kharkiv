package net.khpi.shevvaddm.vagonka.controller;

import net.khpi.shevvaddm.vagonka.dto.AdminProductDto;
import net.khpi.shevvaddm.vagonka.service.ProductService;
import net.khpi.shevvaddm.vagonka.export.ExportUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductFilesController {

    private ExportUtils exportUtils;
    private ProductService productService;

    @Autowired
    public void setExportUtils(ExportUtils exportUtils) {
        this.exportUtils = exportUtils;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products-to-csv")
    public String productsToCsv(Model model) {
        List<AdminProductDto> products = productService.findAllAdminProducts();
        exportUtils.exportProductsToCsv(products);
        model.addAttribute(products);
        return "redirect:/admin/products";
    }

    @GetMapping("/products-to-txt")
    public String productsToTxt(Model model) {
        List<AdminProductDto> products = productService.findAllAdminProducts();
        exportUtils.exportProductsToTxt(products);
        model.addAttribute(products);
        return "redirect:/admin/products";
    }

    @GetMapping("/products-to-xls")
    public String productsToXls(Model model) {
        List<AdminProductDto> products = productService.findAllAdminProducts();
        exportUtils.exportProductsToExcel(products);
        model.addAttribute(products);
        return "redirect:/admin/products";
    }

    @GetMapping("/products-to-pdf")
    public String productsToPdf(Model model) {
        List<AdminProductDto> products = productService.findAllAdminProducts();
        exportUtils.exportProductsToPdf(products);
        model.addAttribute(products);
        return "redirect:/admin/products";
    }
}
