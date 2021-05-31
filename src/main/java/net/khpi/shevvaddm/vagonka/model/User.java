package net.khpi.shevvaddm.vagonka.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "US_ER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;
    @Column(name = "USERNAME", length = 48, nullable = false)
    @Size(min = 4, max = 48)
    @NotNull
    private String username;
    @Column(name = "PASSWORD", length = 48, nullable = false)
    @Size(min = 8, max = 48)
    @NotNull
    private String password;
    @Column(name = "EMAIL", length = 48, nullable = false)
    @Size(min = 8, max = 48)
    @NotNull
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "USER_ROLE_ID", nullable = false)
    @NotNull
    private UserRole userRole;

//    @OneToMany(mappedBy = "user", cascade = { CascadeType.PERSIST,
//            CascadeType.MERGE })
//    private List<UserOrder> userOrders = new ArrayList<>();

    public User() {
    }

    public User(String username, String password, String email, UserRole userRole) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRole = userRole;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    //    public List<UserOrder> getUserOrders() {
    //        return userOrders;
    //    }
    //
    //    public void setUserOrders(List<UserOrder> userOrders) {
    //        this.userOrders = userOrders;
    //    }

    //    public void addUserOrder(UserOrder userOrder) {
    //        userOrders.add(userOrder);
    //        userOrder.setUser(this);
    //    }

    //    public void removeUserOrder(UserOrder userOrder) {
    //        userOrders.remove(userOrder);
    //        userOrder.setUser(null);
    //    }

    @Override
    public String toString() {
        return '{' + "userId=" + userId + ", username='" + username + '\''
                + ", password='" + password + '\'' + ", email='" + email + '\''
                + ", userRole=" + userRole + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof User))
            return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
