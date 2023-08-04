package com.example.facebookclone.ServiceImpl;

import com.example.facebookclone.DTOs.SignUpDTO;
import com.example.facebookclone.Model.Users;
import com.example.facebookclone.Repositories.UserRepository;
import com.example.facebookclone.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users saveUser(SignUpDTO signUpDTO) {
        signUpDTO.setPassword(signUpDTO.getPassword());
        Users user = new Users(signUpDTO);
        return userRepository.save(user);
    }

    @Override
    public Users findById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new NullPointerException("User Not found with ID: "+id));
    }

    @Override
    public Users findFirstByEmail(String email) {
        return userRepository.findFirstByEmail(email);
    }
}
