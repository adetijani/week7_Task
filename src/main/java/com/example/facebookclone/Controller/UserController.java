package com.example.facebookclone.Controller;

import com.example.facebookclone.DTOs.PostsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class UserController {

    @GetMapping("/users")
    public ModelAndView getUserProfile(){
        log.info("UserController Class --> USERS-ID : ");
        return new ModelAndView("WelcomePage").addObject("post", new PostsDTO());
    }
}
