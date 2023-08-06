package com.example.facebookclone.Controller;

import com.example.facebookclone.DTOs.LoginDTO;
import com.example.facebookclone.DTOs.PostsDTO;
import com.example.facebookclone.DTOs.SignUpDTO;
import com.example.facebookclone.Model.Posts;
import com.example.facebookclone.Model.Users;
import com.example.facebookclone.ServiceImpl.PostServiceImpl;
import com.example.facebookclone.Services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("/")
@Slf4j
public class AuthController {
    private PostServiceImpl postService;
    private UserService userService;

    @Autowired
    public AuthController(UserService userService, PostServiceImpl postService) {
        this.userService = userService;
        this.postService = postService;
    }


    @GetMapping("/")
    public ModelAndView signUp(){
        return new ModelAndView("SignUp")
                .addObject("signUpForm", new SignUpDTO());
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
    public ModelAndView login(LoginDTO loginDTO, HttpSession session) {

        log.info("USER - EMAIL-----> {" + loginDTO.getEmail() + " " + loginDTO.getPassword() + "}");
        Users user = userService.findFirstByEmail(loginDTO.getEmail());

        if (user == null) {
            log.error("User not found for email: " + loginDTO.getEmail());
            return new ModelAndView("LogIn")
                    .addObject("login", loginDTO)
                    .addObject("errorMessage", "Invalid email or password");
        }

//        user.setId(user.getId());

        Posts post = new Posts();
        session.setAttribute("users", user);
//        session.getAttribute("users");
//        Users users = (Users) session.getAttribute("users");
//        log.error(users.getEmail());
//        postDTO.setUsers(user); // Set the Users object in the PostsDTO
        log.info("Creating post for user with email: " + user.getEmail());

        return new ModelAndView("WelcomePage")
                .addObject("dashboard", "Welcome, user with email: " + loginDTO.getEmail())
                .addObject("post", post);
    }
//    @PostMapping("/create-post")
//    public ModelAndView createPost(PostsDTO postDTO) {
//        Users user = postDTO.getUsers();
//        if (user == null) {
//            log.error("User not found for creating post. The Users object in the PostsDTO is null.");
//            return new ModelAndView("redirect:/WelcomePage");
//        }
//
//        String userEmail = user.getEmail();
//        log.info("Creating post for user with email: " + userEmail);
//        Users userFromDB = userService.findFirstByEmail(userEmail);
//        if (userFromDB == null) {
//            log.error("User not found for email: " + userEmail);
//            // Handle the case when the user is not found in the database, e.g., show an error message
//            return new ModelAndView("redirect:/WelcomePage");
//        }
////
//        postDTO.setUsers(userFromDB); // Update the Users object in the PostsDTO
//        postService.savePosts(postDTO);
//        // Redirect to the same page to refresh the content after post creation
//        return new ModelAndView("redirect:/WelcomePage");
//    }
}
