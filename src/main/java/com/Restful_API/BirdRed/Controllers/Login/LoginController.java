package com.Restful_API.BirdRed.Controllers.Login;


import com.Restful_API.BirdRed.DTOs.User.SignIn.UserSingInDTO;
import com.Restful_API.BirdRed.DTOs.User.SignUp.UserSingUpDTO;
import com.Restful_API.BirdRed.Services.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/singup")
    @Transactional
    public ResponseEntity signUp(@RequestBody UserSingUpDTO userDTO, UriComponentsBuilder uriComponentsBuilder){
        var user = userService.saveUser(userDTO);
        URI uri = uriComponentsBuilder.path("/{nickname}").buildAndExpand(user.getNickname()).toUri();
        return ResponseEntity.created(uri).body(user);
    }


    //For now, Spring Security has not been implemented
    @PostMapping("/singin")
    public ResponseEntity signIn(@RequestBody UserSingInDTO userDTO)  {
        try{
            return userService.checkCredentials(userDTO);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Password or email is incorrect");
        }

    }



}
