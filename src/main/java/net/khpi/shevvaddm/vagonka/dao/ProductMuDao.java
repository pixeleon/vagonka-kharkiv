package net.khpi.shevvaddm.vagonka.dao;

import net.khpi.shevvaddm.vagonka.model.ProductMu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductMuDao extends JpaRepository<ProductMu, Long> {
    @Query("select pmu from ProductMu pmu where lower(pmu.muAbbr) = lower(:muAbbr)")
    Optional<ProductMu> findByMuAbbr(@Param("muAbbr") String muAbbr);
}
