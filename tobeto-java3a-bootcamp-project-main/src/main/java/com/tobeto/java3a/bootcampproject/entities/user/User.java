package com.tobeto.java3a.bootcampproject.entities.user;

import com.tobeto.java3a.bootcampproject.entities.common.BaseEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public abstract class User extends BaseEntity {

    private String userName;

    private String firstName;
    private String lastName;

    private LocalDateTime dateOfBirth;

    private String nationalIdentity;

    private String email;
    private String password;
}
