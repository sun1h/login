package com.login.oauth.domain;

import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name ="USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자의 생성을 방지하고 지정한 생성자를 사용하도록 강제하여 무조건 완전한 상태의 객체를 생성할 수 있도록 도움
@AllArgsConstructor //클래스에 모들 필드에 대한 생성자를 자동으로 생성해준다. @NoArgsConstructor로 기본 생성자의 생성을 방지하고 @Builder를 이용하여 객체의 생성에 유연성을 더 해주면 좋겠지만, 이 두 개의 어노테이션을 함께 사용하려면 @AllArgsConstructor가 필요하다.
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //키 생성 전용 테이블을 하나 만들어서 데이터베이스 시퀀스를 흉내내는 전략
    @Column(name="user_id")
    private Long id;

    private String email;
    private String password;
    private String nickname;

    @Enumerated(EnumType.STRING)
    private  Role role;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    private String socialId;

    private String refreshToken;

    public void authorizeUser(){
        this.role = Role.USER;
    }

    public void passwordEncode (PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }

    public void updateRefreshToken(String updateRefreshToken){
        this.refreshToken = updateRefreshToken;
    }
}
