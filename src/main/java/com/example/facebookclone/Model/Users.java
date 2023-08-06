package com.example.facebookclone.Model;

import com.example.facebookclone.DTOs.SignUpDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static java.sql.Date.valueOf;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String birthdate;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Gender gender;

    public Users(SignUpDTO signUpDTO) {
        this.birthdate = signUpDTO.getBirthdate();
        this.email = signUpDTO.getEmail();
        this.firstName = signUpDTO.getFirstName();
        this.gender = Gender.valueOf(signUpDTO.getGender());
        this.lastName = signUpDTO.getLastName();
        this.password = signUpDTO.getPassword();
        this.phoneNumber = signUpDTO.getPhoneNumber();
    }
}
