package io.github.parkyc.budgetlog.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/user")
@Controller
public class UserController {

    @GetMapping("/info")
    public String getUserInfo() {
        return "abc";
    }

}
