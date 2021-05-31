package net.khpi.shevvaddm.vagonka.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public class SaveProductDto {
    private Long productId;

    @NotNull
    private Long typeId;

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
    private Long muId;

    public SaveProductDto() {
    }

    public SaveProductDto(Long productId, @NotNull Long typeId,
            @NotBlank String woodType, @NotBlank String woodKind,
            @NotNull @Positive BigDecimal price,
            @NotNull @PositiveOrZero Integer amount, @NotNull Boolean visible,
            @NotNull Long muId) {
        this.productId = productId;
        this.typeId = typeId;
        this.woodType = woodType;
        this.woodKind = woodKind;
        this.price = price;
        this.amount = amount;
        this.visible = visible;
        this.muId = muId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
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

    public Long getMuId() {
        return muId;
    }

    public void setMuId(Long muId) {
        this.muId = muId;
    }
}
