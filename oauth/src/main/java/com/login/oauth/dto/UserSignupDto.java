package com.login.oauth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.core.SpringVersion;

@NoArgsConstructor
@Getter
public class UserSignupDto {
    private String email;
    private String password;
    private String nickname;
}
