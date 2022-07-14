package com.talk.talk.security;

import com.talk.talk.domain.User;
import com.talk.talk.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + username));
                .orElseThrow(() -> new UsernameNotFoundException("ID 또는 비밀번호를 확인해주세요."));

        return new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), user.getName(), user.getProfile());
    }
}