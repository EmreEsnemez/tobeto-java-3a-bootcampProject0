package com.tobeto.java3a.bootcampproject.core.dtos.user.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public abstract class UserDto {

    private Long id;

    private String userName;

    private String firstName;
    private String lastName;

    private LocalDateTime dateOfBirth;

    private String nationalIdentity;

    private String email;
    private String password;
}
