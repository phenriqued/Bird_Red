package com.Restful_API.BirdRed.Services.UserService;


import com.Restful_API.BirdRed.DTOs.User.SignIn.UserSingInDTO;
import com.Restful_API.BirdRed.DTOs.User.SignUp.UserSingUpDTO;
import com.Restful_API.BirdRed.Entities.User.User;
import com.Restful_API.BirdRed.Repositories.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserSingUpDTO userDTO){
        return userRepository.save(new User(userDTO));
    }


    //For now, Spring Security has not been implemented
    public ResponseEntity checkCredentials(UserSingInDTO userDTO) throws IllegalArgumentException {
        if (userDTO.email() == null && userDTO.nickname() == null){
            return ResponseEntity.badRequest().body("email or nickname must be filled in");
        }

        var user = userRepository.findByNicknameOrEmail(userDTO.nickname(), userDTO.email())
                .orElseThrow(IllegalArgumentException::new);

        if(!user.getPassword().equals(userDTO.password())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Wrong password");
        }
        return ResponseEntity.ok().build();
    }


}
