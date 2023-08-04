package com.example.facebookclone.ServiceImpl;

import com.example.facebookclone.DTOs.PostsDTO;
import com.example.facebookclone.Model.Posts;
import com.example.facebookclone.Repositories.PostRepository;
import com.example.facebookclone.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Posts savePosts(PostsDTO postsDTO) {
        return postRepository.save(new Posts(postsDTO));
    }

    @Override
    public List<Posts> findAllPostsByUserId(Long id) {
        return postRepository.findAllByUsersId(id);
    }
}
