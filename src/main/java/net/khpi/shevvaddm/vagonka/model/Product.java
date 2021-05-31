package net.khpi.shevvaddm.vagonka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "PRODUCT")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "WOOD_TYPE")
    @NotBlank
    private String woodType;

    @Column(name = "WOOD_KIND")
    @NotBlank
    private String woodKind;

    @Column(name = "PRICE")
    @NotNull
    @Positive
    private BigDecimal price;

    @Column(name = "AMOUNT")
    @NotNull
    @PositiveOrZero
    private Integer amount;

    @Column(name = "VISIBLE")
    @NotNull
    private Boolean visible;

    @ManyToOne
    @JoinColumn(name = "TYPE_ID", nullable = false)
    private ProductType productType;

    @ManyToOne
    @JoinColumn(name = "MU_ID", nullable = false)
    private ProductMu productMu;

    public Product() {
    }

    public Product(String woodType, String woodKind, BigDecimal price,
            Integer amount, Boolean visible, ProductType productType,
            ProductMu productMu) {
        this.woodType = woodType;
        this.woodKind = woodKind;
        this.price = price;
        this.amount = amount;
        this.visible = visible;
        this.productType = productType;
        this.productMu = productMu;
    }

    public Product(Long productId, String woodType, String woodKind,
            BigDecimal price, Integer amount, Boolean visible,
            ProductType productType, ProductMu productMu) {
        this.productId = productId;
        this.woodType = woodType;
        this.woodKind = woodKind;
        this.price = price;
        this.amount = amount;
        this.visible = visible;
        this.productType = productType;
        this.productMu = productMu;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getWoodType() {
        return woodType;
    }

    public void setWoodType(String woodType) {
        this.woodType = woodType;
    }

    public String getWoodKind() {
        return woodKind;
    }

    public void setWoodKind(String woodKind) {
        this.woodKind = woodKind;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal priceHrn) {
        this.price = priceHrn;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductMu getProductMu() {
        return productMu;
    }

    public void setProductMu(ProductMu productMu) {
        this.productMu = productMu;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", woodType='" + woodType
                + '\'' + ", woodKind='" + woodKind + '\'' + ", price=" + price
                + ", amount=" + amount + ", visible=" + visible + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return productId.equals(product.productId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
