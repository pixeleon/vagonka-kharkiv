package net.khpi.shevvaddm.vagonka.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {
    private Long userId;

    @NotBlank
    @Size(min = 3, max = 64)
    private String username;

    @NotBlank
    @Size(min = 8, max = 64)
    private String password;

    @NotBlank
    @Size(min = 8, max = 64)
    @Email
    private String email;

    private Long userRoleId;

    public UserDto(Long userId, String username, String password, String email,
            Long userRoleId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleId = userRoleId;
    }

    public UserDto(String username, String password, String email, Long userRoleId) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userRoleId = userRoleId;
    }

    public UserDto() {
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

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }
}
