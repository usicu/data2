package cn.edu.ctbu.data.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {
    @RequestMapping("/login/user")
    public String login(){
        return "/login/user";

    }


}
