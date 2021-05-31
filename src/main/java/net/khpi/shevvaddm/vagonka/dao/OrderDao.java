package net.khpi.shevvaddm.vagonka.dao;

import net.khpi.shevvaddm.vagonka.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Long> {
}
