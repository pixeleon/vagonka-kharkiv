package net.khpi.shevvaddm.vagonka.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRODUCT_MU")
public class ProductMu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MU_ID")
    private Long muId;

    @Column(name = "MU_ABBR")
    @NotBlank
    private String muAbbr;

    @OneToMany(mappedBy = "productMu", cascade = { CascadeType.PERSIST,
            CascadeType.MERGE })
    private List<Product> products = new ArrayList<>();

    public ProductMu() {
    }

    public ProductMu(String muAbbr) {
        this.muAbbr = muAbbr;
    }

    public ProductMu(Long muId, String muAbbr) {
        this.muId = muId;
        this.muAbbr = muAbbr;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setProductMu(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setProductMu(null);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    public void setMuAbbr(String muAbbrv) {
        this.muAbbr = muAbbrv;
    }

    @Override
    public String toString() {
        return "ProductMu{" + "muId=" + muId + ", muAbbrv='" + muAbbr + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ProductMu))
            return false;
        ProductMu productMu = (ProductMu) o;
        return muId.equals(productMu.muId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
