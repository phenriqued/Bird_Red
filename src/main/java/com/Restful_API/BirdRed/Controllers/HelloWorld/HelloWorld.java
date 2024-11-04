package com.Restful_API.BirdRed.Controllers.HelloWorld;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HelloBird")
public class HelloWorld {

    @GetMapping
    public String helloWorld(){
        return "\uD83D\uDC26";
    }

}
