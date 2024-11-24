package com.Restful_API.BirdRed.Entities.User;

import com.Restful_API.BirdRed.DTOs.User.SignUp.UserSingUpDTO;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document("User")
public class User{

    @Id
    private String id;

    @Indexed(name = "email", unique = true, sparse = true)
    private String email;

    @Indexed(name = "nickname", unique = true, sparse = true)
    private String nickname;

    private String password;
    @Deprecated
    public User() {
    }

    public User(UserSingUpDTO signUpDTO) {
        this.email = signUpDTO.email();
        this.nickname = signUpDTO.nickname();
        this.password = signUpDTO.password();
    }
}
