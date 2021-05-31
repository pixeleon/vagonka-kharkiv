package net.khpi.shevvaddm.vagonka.dao;

import net.khpi.shevvaddm.vagonka.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRoleDao extends JpaRepository<UserRole, Long> {
    @Query("SELECT ur FROM UserRole ur WHERE LOWER(ur.userRoleName) = LOWER(:userRoleName)")
    UserRole findByUserRoleName(@Param("userRoleName") String userRoleName);
}
