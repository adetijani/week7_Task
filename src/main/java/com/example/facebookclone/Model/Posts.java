package com.example.facebookclone.Model;

import com.example.facebookclone.DTOs.PostsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String content;
    @ManyToOne
    private Users users;

//    public Posts(PostsDTO postsDTO) {
//    }

//    public Posts(PostsDTO postsDTO) {
//    }
}
