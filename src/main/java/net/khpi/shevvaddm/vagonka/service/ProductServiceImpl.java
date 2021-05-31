package net.khpi.shevvaddm.vagonka.service;

import net.khpi.shevvaddm.vagonka.dao.ProductDao;
import net.khpi.shevvaddm.vagonka.dao.ProductMuDao;
import net.khpi.shevvaddm.vagonka.dao.ProductTypeDao;
import net.khpi.shevvaddm.vagonka.dto.AdminProductDto;
import net.khpi.shevvaddm.vagonka.dto.ProductMuDto;
import net.khpi.shevvaddm.vagonka.dto.ProductTypeDto;
import net.khpi.shevvaddm.vagonka.dto.SaveProductDto;
import net.khpi.shevvaddm.vagonka.dto.UserProductDto;
import net.khpi.shevvaddm.vagonka.model.Product;
import net.khpi.shevvaddm.vagonka.model.ProductMu;
import net.khpi.shevvaddm.vagonka.model.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductTypeDao productTypeDao;
    private ProductMuDao productMuDao;
    private ProductDao productDao;

    @Autowired
    public void setProductTypeDao(ProductTypeDao productTypeDao) {
        this.productTypeDao = productTypeDao;
    }

    @Autowired
    public void setProductMuDao(ProductMuDao productMuDao) {
        this.productMuDao = productMuDao;
    }

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<UserProductDto> findAllUserProducts() {
        return productDao.findAllVisibleProducts().stream()
                .map(this::mapProductEntityToUserProductDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<AdminProductDto> findAllAdminProducts() {
        return productDao.findAll().stream()
                .map(this::mapProductEntityToAdminProductDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public AdminProductDto findAdminProductById(Long productId) {
        return mapProductEntityToAdminProductDto(productDao.getById(productId));
    }

    @Transactional
    @Override
    public void updateProduct(AdminProductDto productDto) {
        productDao.save(convertAdminProductDtoToProductEntity(productDto));
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductTypeDto> findAllProductTypes() {
        return productTypeDao.findAll().stream()
                .map(this::mapProductTypeEntityToProductTypeDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductMuDto> findAllProductMus() {
        return productMuDao.findAll().stream()
                .map(this::mapProductMuEntityToProductMuDto)
                .collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void saveProduct(SaveProductDto productDto) {
        productDao.save(mapSaveProductDtoToProductEntity(productDto));
    }

    @Override
    public SaveProductDto findSaveProductById(Long productId) {
        return mapProductEntityToSaveProductDto(productDao.getById(productId));
    }

    @Override
    public void deleteProductById(Long productId) {
        Product product = productDao.getById(productId);
        productDao.delete(product);
    }

    private Product mapSaveProductDtoToProductEntity(SaveProductDto dto) {
        Product product = new Product();
        product.setProductId(dto.getProductId());
        product.setWoodType(dto.getWoodType());
        product.setWoodKind(dto.getWoodKind());
        product.setPrice(dto.getPrice());
        product.setAmount(dto.getAmount());
        product.setVisible(dto.getVisible());
        product.setProductType(productTypeDao.getById(dto.getTypeId()));
        product.setProductMu(productMuDao.getById(dto.getMuId()));
        return product;
    }

    private ProductMuDto mapProductMuEntityToProductMuDto(ProductMu productMu) {
        ProductMuDto dto = new ProductMuDto();
        dto.setMuId(productMu.getMuId());
        dto.setMuAbbr(productMu.getMuAbbr());
        return dto;
    }

    private ProductTypeDto mapProductTypeEntityToProductTypeDto(
            ProductType productType) {
        ProductTypeDto dto = new ProductTypeDto();
        dto.setTypeId(productType.getTypeId());
        dto.setTypeName(productType.getTypeName());
        return dto;
    }

    private UserProductDto mapProductEntityToUserProductDto(Product product) {
        UserProductDto dto = new UserProductDto();
        dto.setProductId(dto.getProductId());
        dto.setTypeName(product.getProductType().getTypeName());
        dto.setWoodType(product.getWoodType());
        dto.setWoodKind(product.getWoodKind());
        dto.setPrice(product.getPrice());
        dto.setMuAbbr(product.getProductMu().getMuAbbr());
        return dto;
    }

    private AdminProductDto mapProductEntityToAdminProductDto(Product product) {
        AdminProductDto dto = new AdminProductDto();
        dto.setProductId(product.getProductId());
        dto.setTypeName(product.getProductType().getTypeName());
        dto.setWoodType(product.getWoodType());
        dto.setWoodKind(product.getWoodKind());
        dto.setPrice(product.getPrice());
        dto.setMuAbbr(product.getProductMu().getMuAbbr());
        dto.setAmount(product.getAmount());
        dto.setVisible(product.getVisible());
        return dto;
    }

    private SaveProductDto mapProductEntityToSaveProductDto(Product product) {
        SaveProductDto dto = new SaveProductDto();
        dto.setProductId(product.getProductId());
        dto.setWoodType(product.getWoodType());
        dto.setWoodKind(product.getWoodKind());
        dto.setPrice(product.getPrice());
        dto.setAmount(product.getAmount());
        dto.setVisible(product.getVisible());
        dto.setTypeId(product.getProductType().getTypeId());
        dto.setMuId(product.getProductMu().getMuId());
        return dto;
    }

    private Product convertAdminProductDtoToProductEntity(AdminProductDto dto) {
        return productDao.getById(dto.getProductId());
    }
}
