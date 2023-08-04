package com.example.facebookclone.Controller;

import com.example.facebookclone.DTOs.LoginDTO;
import com.example.facebookclone.DTOs.PostsDTO;
import com.example.facebookclone.DTOs.SignUpDTO;
import com.example.facebookclone.Model.Users;
import com.example.facebookclone.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/")
@Slf4j
public class AuthController {
    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("")
    public ModelAndView signUp(){
        return new ModelAndView("SignUp").addObject("signUpForm", new SignUpDTO());
    }
    @PostMapping ("/sign-up")
    public ModelAndView signUp(SignUpDTO signUpDTO, BindingResult bindingResult){
        Users user = userService.saveUser(signUpDTO);
        bindingResult.hasErrors();
            if (user != null) {
                return new ModelAndView("LogIn")
                        .addObject("login", new LoginDTO())
                        .addObject("userMessage", "Sign up successful, please login.");
            }
//        }
        return new ModelAndView("SignUp")
                .addObject("signUpForm",  new SignUpDTO());
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("LogIn")
                .addObject("login", new LoginDTO());
    }
    @PostMapping("/login")

    public ModelAndView login(LoginDTO loginDTO ){
        //loginDTO is creating our method object dependencies dependency injection through inversion of control
        log.info("USER - EMAIL-----> {"+loginDTO.getEmail()+"} ");
        Users user = userService.findFirstByEmail(loginDTO.getEmail());
        PostsDTO postDTO = new PostsDTO();
        postDTO.setUser(user);
        if (user == null) {
            return new ModelAndView("LogIn")
                    .addObject("login", loginDTO)
                    .addObject("errorMessage", "Invalid email or password");
        }
        return new ModelAndView("WelcomePage")
                .addObject("dashboard",
                        "Welcome, user with email: "+loginDTO.getEmail())
                .addObject("post", postDTO);
    }

}
