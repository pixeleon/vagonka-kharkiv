package net.khpi.shevvaddm.vagonka.dto;

import javax.validation.constraints.NotBlank;

public class ProductMuDto {
    private Long muId;

    @NotBlank
    private String muAbbr;

    public ProductMuDto() {
    }

    public ProductMuDto(Long muId, String muAbbr) {
        this.muId = muId;
        this.muAbbr = muAbbr;
    }

    public Long getMuId() {
        return muId;
    }

    public void setMuId(Long muId) {
        this.muId = muId;
    }

    public String getMuAbbr() {
        return muAbbr;
    }

    public void setMuAbbr(String muAbbr) {
        this.muAbbr = muAbbr;
    }
}
