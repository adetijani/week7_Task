package com.example.facebookclone.ServiceImpl;

import com.example.facebookclone.DTOs.PostsDTO;
import com.example.facebookclone.Model.Posts;
import com.example.facebookclone.Repositories.PostRepository;
import com.example.facebookclone.Services.PostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Posts savePosts(PostsDTO postsDTO) {
        Posts posts = new Posts();
        BeanUtils.copyProperties(postsDTO, posts);
        return postRepository.save(posts);
    }

    @Override
    public List<Posts> findAllPostsByUserId(Long id) {
        return postRepository.findAllByUsersId(id);
    }
}
