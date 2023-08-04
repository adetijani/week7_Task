package com.example.facebookclone.DTOs;

import com.example.facebookclone.Model.Users;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostsDTO{
    private String content;
    private Users users;
    List<CommentDTO> comments;

    public void setUser(Users users) {
    }
}
