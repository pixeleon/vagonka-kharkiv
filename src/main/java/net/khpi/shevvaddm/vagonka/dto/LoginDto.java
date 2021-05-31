package net.khpi.shevvaddm.vagonka.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class LoginDto implements Serializable {

    @NotBlank
    @Size(min = 3, max = 48)
    private String username;

    @NotBlank
    @Size(min = 8, max = 48)
    private String password;

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginDto() {
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
}