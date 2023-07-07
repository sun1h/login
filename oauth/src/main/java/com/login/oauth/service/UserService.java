package com.login.oauth.service;

import com.login.oauth.domain.Role;
import com.login.oauth.domain.User;
import com.login.oauth.dto.UserSignupDto;
import com.login.oauth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(UserSignupDto userSignupDto) throws Exception{
        if(userRepository.findByEmail(userSignupDto.getEmail()).isPresent()){
            throw new Exception("이미 존재하는 이메일입니다.");
        }
        User user = User.builder()
                .email(userSignupDto.getEmail())
                .password(userSignupDto.getPassword())
                .nickname(userSignupDto.getNickname())
                .role(Role.USER)
                .build();

        user.passwordEncode(passwordEncoder);
        userRepository.save(user);
    }

}
