package com.epam.eshop.domain;

import com.epam.eshop.dto.CreateUserDto;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Data
public class UserEntity extends AbstractEntity {

    public UserEntity() {
    }

    public UserEntity(CreateUserDto createUserDto, Class<UserEntity> userEntityClass) {
    }

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "role")
    private UserRole role;

}
