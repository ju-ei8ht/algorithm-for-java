package com.talk.talk.service;

import com.talk.talk.domain.User;
import com.talk.talk.dto.SignupRequestDto;
import com.talk.talk.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;

    @Transactional
    public void registerUser(SignupRequestDto requestDto){
        String username = requestDto.getUsername();
        //ID 제한
        if(!Pattern.matches("^[0-9a-zA-Z]*$",username) && username.length() < 3){
            throw new IllegalArgumentException("ID는 최소 3자 이상, 알파벳 대소문자, 숫자만 가능합니다.");
        }
        //ID 중복
        Optional<User> found = userRepo.findByUsername(username);
        if(found.isPresent()){
            throw new IllegalArgumentException("중복된 사용자 ID가 존재합니다.");
        }
        if(requestDto.getPassword().length() < 4 || requestDto.getPassword().contains(username)){
            throw new IllegalArgumentException("비밀번호는 최소 4자 이상이며 ID와 같은 값이 포함될 수 없습니다.");
        }
        //password 암호화
        String password = passwordEncoder.encode(requestDto.getPassword());
        String name = requestDto.getName();
        String profile = requestDto.getProfile();

        User user = new User(username, password, name, profile);
        userRepo.save(user);
    }
}

