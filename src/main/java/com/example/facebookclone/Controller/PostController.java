package com.example.facebookclone.Controller;

import com.example.facebookclone.DTOs.PostsDTO;
import com.example.facebookclone.Model.Posts;
import com.example.facebookclone.Model.Users;
import com.example.facebookclone.Services.PostService;
import com.example.facebookclone.Services.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@Slf4j
public class PostController {
    private PostService postService;
    private UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }
    @GetMapping("/post")
    public ModelAndView viewPosts(@PathVariable("id") Long id){
        List<Posts> postList = postService.findAllPostsByUserId(id);
        return new ModelAndView("WelcomePage").addObject("postList", postList);
    }

    @PostMapping("/post")
    public ModelAndView savePost(PostsDTO postDTO, HttpSession session){
        Users user = (Users) session.getAttribute("users");
        postDTO.setUsers(user);
        log.error(String.valueOf(postDTO));
        postService.savePosts(postDTO);
        List<Posts> postList =  postService.findAllPostsByUserId(postDTO.getUsers().getId());
        log.info(" Here is this users post: "+ postList);
        return new ModelAndView("WelcomePage")
                .addObject("postList", postList)
                .addObject("post", new Posts());
    }
}
