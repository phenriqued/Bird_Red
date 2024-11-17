package com.Restful_API.BirdRed.Services.UserService;


import com.Restful_API.BirdRed.DTOs.User.SignUp.UserSignUpDTO;
import com.Restful_API.BirdRed.Entities.User.User;
import com.Restful_API.BirdRed.Repositories.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserSignUpDTO userDTO){
        return userRepository.save(new User(userDTO));
    }


}
