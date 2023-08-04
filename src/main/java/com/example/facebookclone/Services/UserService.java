package com.example.facebookclone.Services;

import com.example.facebookclone.DTOs.SignUpDTO;
import com.example.facebookclone.Model.Users;

public interface UserService {
    Users saveUser(SignUpDTO signUpDTO);

    Users findById(Long id);

    Users findFirstByEmail(String email);
}
