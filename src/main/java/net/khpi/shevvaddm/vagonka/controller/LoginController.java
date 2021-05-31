package net.khpi.shevvaddm.vagonka.controller;

import net.khpi.shevvaddm.vagonka.dto.LoginDto;
import net.khpi.shevvaddm.vagonka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        LoginDto loginDto = new LoginDto();
        model.addAttribute("login", loginDto);
        return "login";
    }


}
