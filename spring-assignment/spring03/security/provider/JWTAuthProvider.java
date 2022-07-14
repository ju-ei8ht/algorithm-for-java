package com.talk.talk.security.provider;

import com.talk.talk.domain.User;
import com.talk.talk.repo.UserRepo;
import com.talk.talk.security.UserDetailsImpl;
import com.talk.talk.security.jwt.JwtDecoder;
import com.talk.talk.security.jwt.JwtPreProcessingToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JWTAuthProvider implements AuthenticationProvider {

    private final JwtDecoder jwtDecoder;

    private final UserRepo userRepo;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String token = (String) authentication.getPrincipal();
        String username = jwtDecoder.decodeUsername(token);

        User user = userRepo.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("Can't find " + username));
                .orElseThrow(() -> new UsernameNotFoundException("ID 또는 비밀번호를 확인해주세요."));
        UserDetailsImpl userDetails = new UserDetailsImpl(user.getId(), user.getUsername(), user.getPassword(), user.getName(), user.getProfile());
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtPreProcessingToken.class.isAssignableFrom(authentication);
    }
}
