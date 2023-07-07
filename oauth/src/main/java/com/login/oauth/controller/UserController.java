package com.login.oauth.controller;

import com.login.oauth.dto.UserSignupDto;
import com.login.oauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public String signUp(@RequestBody UserSignupDto userSignupDto) throws Exception{
        userService.signUp(userSignupDto);
        return "회원가입 성공";
    }

    @GetMapping("/jwt-test")
    public String jwtTest(){
        return "jwt 성공";
    }
}
