package com.example.pizzamania.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/inicioGoogle")
public class UserController {

    @GetMapping
    public String login(@AuthenticationPrincipal OAuth2User oAuth2User, Model model) {
        String name = oAuth2User.getAttribute("name");
        String email = oAuth2User.getAttribute("email");
        String picture = oAuth2User.getAttribute("picture");
        model.addAttribute("name", name);
        model.addAttribute("email", email);
        model.addAttribute("picture", picture);
        return "home";
    }
}
