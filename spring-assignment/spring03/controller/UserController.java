package com.talk.talk.controller;

import com.talk.talk.dto.SignupRequestDto;
import com.talk.talk.dto.UserInfoDto;
import com.talk.talk.security.UserDetailsImpl;
import com.talk.talk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @RequestMapping("/user/{login}")
    public ModelAndView register(Model model, @PathVariable String login) {
        model.addAttribute("login",true);
        model.addAttribute("title","로그인");
        //회원가입
        if(login.equals("sign")){
            model.addAttribute("login",false);
            model.addAttribute("sign",true);
            model.addAttribute("title","회원가입");
        }
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
    //회원가입 요청 처리
    @PostMapping("/user/signup")
    public void registerUser(@RequestBody SignupRequestDto requestDto){
        userService.registerUser(requestDto);
    }

    // 로그인한 사용자 정보 받기
    @PostMapping("/user/info")
    @ResponseBody
    public UserInfoDto getMyInfo(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        String username = userDetails.getUsername();
        String name = userDetails.getName();
        String profile = userDetails.getProfile();

        return new UserInfoDto(username, name, profile);
    }
}
