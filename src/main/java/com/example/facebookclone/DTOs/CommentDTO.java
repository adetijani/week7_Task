package com.example.facebookclone.DTOs;

import com.example.facebookclone.Model.Posts;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private long commentId;
    private String content;
    private Posts posts;
}
