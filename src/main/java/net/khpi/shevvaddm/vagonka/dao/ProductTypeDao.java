package net.khpi.shevvaddm.vagonka.dao;

import net.khpi.shevvaddm.vagonka.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductTypeDao extends JpaRepository<ProductType, Long> {
    @Query("select pt from ProductType pt where lower(pt.typeName) = lower(:typeName)")
    Optional<ProductType> findByTypeName(@Param("typeName") String typeName);
}
