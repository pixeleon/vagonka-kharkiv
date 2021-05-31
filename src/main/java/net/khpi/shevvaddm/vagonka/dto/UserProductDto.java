package net.khpi.shevvaddm.vagonka.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class UserProductDto {
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
    private String muAbbr;

    public UserProductDto() {
    }

    public UserProductDto(Long productId, String woodType, String woodKind,
            BigDecimal price, String typeName, String muAbbr) {
        this.productId = productId;
        this.woodType = woodType;
        this.woodKind = woodKind;
        this.price = price;
        this.typeName = typeName;
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

    public String getMuAbbr() {
        return muAbbr;
    }

    public void setMuAbbr(String muAbbr) {
        this.muAbbr = muAbbr;
    }
}
