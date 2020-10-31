package com.rides.application.controller;

import com.rides.application.model.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("usertest", new UserTest("oee", 88));
        model.addAttribute("testinput", "wwwww");
        return "index";
    }
}