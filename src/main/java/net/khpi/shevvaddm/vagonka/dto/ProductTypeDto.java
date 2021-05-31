package net.khpi.shevvaddm.vagonka.dto;

import javax.validation.constraints.NotBlank;

public class ProductTypeDto {
    private Long typeId;

    @NotBlank
    private String typeName;

    public ProductTypeDto() {
    }

    public ProductTypeDto(Long typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
