package net.khpi.shevvaddm.vagonka.service;

import net.khpi.shevvaddm.vagonka.dto.AdminProductDto;
import net.khpi.shevvaddm.vagonka.dto.ProductMuDto;
import net.khpi.shevvaddm.vagonka.dto.ProductTypeDto;
import net.khpi.shevvaddm.vagonka.dto.SaveProductDto;
import net.khpi.shevvaddm.vagonka.dto.UserProductDto;

import java.util.List;

public interface ProductService {
    List<UserProductDto> findAllUserProducts();

    List<AdminProductDto> findAllAdminProducts();

    AdminProductDto findAdminProductById(Long productId);

    void updateProduct(AdminProductDto productDto);

    List<ProductTypeDto> findAllProductTypes();

    List<ProductMuDto> findAllProductMus();

    void saveProduct(SaveProductDto productDto);

    SaveProductDto findSaveProductById(Long productId);

    void deleteProductById(Long productId);
}
