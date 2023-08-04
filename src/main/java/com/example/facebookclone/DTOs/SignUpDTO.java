package com.example.facebookclone.DTOs;

import com.example.facebookclone.Model.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpDTO {
    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String birthdate;

    private String password;

    private String gender;

}
