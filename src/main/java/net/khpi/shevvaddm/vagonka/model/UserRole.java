package net.khpi.shevvaddm.vagonka.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USER_ROLE")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 9220733435033587229L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ROLE_ID")
    private Long userRoleId = null;

    @Column(name = "USER_ROLE_NAME", length = 48, nullable = false)
    @Size(min = 3, max = 48)
    @NotNull
    private String userRoleName;

    @OneToMany(mappedBy = "userRole", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<User> users = new ArrayList<>();

    public UserRole() {    }

    public UserRole(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public UserRole(Long userRoleId, String userRoleName) {
        this.userRoleId = userRoleId;
        this.userRoleName = userRoleName;
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
        user.setUserRole(this);
    }

    public void removeUser(User user) {
        users.remove(user);
        user.setUserRole(null);
    }

    @Override
    public String toString() {
        return '{' + "userRoleId=" + userRoleId + ", userRoleName='"
                + userRoleName + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof UserRole))
            return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(userRoleId, userRole.userRoleId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}


