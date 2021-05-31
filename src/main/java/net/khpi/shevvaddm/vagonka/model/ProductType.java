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
@Table(name = "PRODUCT_TYPE")
public class ProductType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;

    @Column(name = "TYPE_NAME")
    @NotBlank
    private String typeName;

    @OneToMany(mappedBy = "productType",
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Product> products = new ArrayList<>();

    public ProductType() {
    }

    public ProductType(String typeName) {
        this.typeName = typeName;
    }

    public ProductType(Long typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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

    public void addProduct(Product product) {
        products.add(product);
        product.setProductType(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setProductType(null);
    }

    @Override
    public String toString() {
        return "ProductType{" + "typeId=" + typeId + ", typeName='" + typeName
                + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ProductType))
            return false;
        ProductType productType = (ProductType) o;
        return typeId.equals(productType.typeId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
