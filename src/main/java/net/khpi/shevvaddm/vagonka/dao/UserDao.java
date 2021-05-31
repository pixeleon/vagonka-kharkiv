package net.khpi.shevvaddm.vagonka.dao;

import net.khpi.shevvaddm.vagonka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    @Query("select u from User u where lower(u.username) = lower(:username)")
    Optional<User> findByUsername(String username);

    @Query("select u from User u where u.userRole.userRoleId = :userRoleId")
    List<User> findAllByUserRoleId(@Param("userRoleId") Long userRoleId);
}
