package net.khpi.shevvaddm.vagonka.dao;

import net.khpi.shevvaddm.vagonka.dto.UserProductDto;
import net.khpi.shevvaddm.vagonka.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductDao extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.visible = true")
    List<Product> findAllVisibleProducts();
}
