package ru.itis.danyook.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.danyook.model.UserEntity;
import ru.itis.danyook.service.auth.AuthUserService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {


    private final AuthUserService userService;

    @GetMapping("/login")
    public String login() {
        return "user/login";
    }

    @GetMapping("/register")
    public String registerForm() {
        return "user/register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") UserEntity user, Model model) {
        try {
            userService.save(user);
            model.addAttribute("message", "Registration successful!");
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "user/register";
        }
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/auth/register";
    }

}