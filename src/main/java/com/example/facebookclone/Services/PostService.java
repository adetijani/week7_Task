package com.example.facebookclone.Services;

import com.example.facebookclone.DTOs.PostsDTO;
import com.example.facebookclone.Model.Posts;

import java.util.List;

public interface PostService {
    Posts savePosts(PostsDTO postsDTO);
    List<Posts> findAllPostsByUserId(Long id);
}
