package net.khpi.shevvaddm.vagonka.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class AdminProductDto {

    private Long productId;

    @NotNull
    private String typeName;

    @NotBlank
    private String woodType;

    @NotBlank
    private String woodKind;

    @NotNull
    @Positive
    private BigDecimal price;

    @NotNull
    @PositiveOrZero
    private Integer amount;

    @NotNull
    private Boolean visible;

    @NotNull
    private String muAbbr;

    public AdminProductDto() {
    }

    public AdminProductDto(Long productId, String typeName, String woodType,
            String woodKind, BigDecimal price, Integer amount, Boolean visible,
            String muAbbr) {
        this.productId = productId;
        this.typeName = typeName;
        this.woodType = woodType;
        this.woodKind = woodKind;
        this.price = price;
        this.amount = amount;
        this.visible = visible;
        this.muAbbr = muAbbr;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public String getMuAbbr() {
        return muAbbr;
    }

    public void setMuAbbr(String muAbbr) {
        this.muAbbr = muAbbr;
    }
}
