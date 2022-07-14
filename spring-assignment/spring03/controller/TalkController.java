package com.talk.talk.controller;

import com.talk.talk.domain.ReTalk;
import com.talk.talk.domain.Talk;
import com.talk.talk.dto.ReTalkRequestDto;
import com.talk.talk.dto.TalkRequestDto;
import com.talk.talk.repo.ReTalkRepo;
import com.talk.talk.repo.TalkRepo;
import com.talk.talk.repo.UserRepo;
import com.talk.talk.security.UserDetailsImpl;
import com.talk.talk.service.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TalkController {
    private final TalkRepo talkRepo;
    private final UserRepo userRepo;
    private final ReTalkRepo reTalkRepo;
    private final TalkService talkService;

    @RequestMapping("/read/{id}")
    public ModelAndView read() {
        ModelAndView mav = new ModelAndView("read");
        return mav;
    }
    @RequestMapping("/write")
    public ModelAndView write(Model model){
        LocalDate date = LocalDate.now();
        model.addAttribute("date",date);
        ModelAndView mav = new ModelAndView("write");
        return mav;
    }

    //Get
//    @GetMapping("/api/talk")
//    public TalkListDto getTalk() {
//        Talk talk = (Talk) talkRepo.findAllByOrderByCreatedAtDesc();
//        String username = talk.getUsername();
//        String title = talk.getTitle();
//        String contents = talk.getContents();
//        LocalDate date = talk.getDate();
//        LocalTime createdAt = talk.getCreatedAt();
//        LocalTime modifiedAt = talk.getModifiedAt();
//        User user = userRepo.findByUsername(username).orElseThrow(
//                () -> new IllegalArgumentException("유저를 찾을 수 없습니다.")
//        );
//        String name = user.getName();
//        String profile = user.getProfile();
//        return new TalkListDto(username,name,profile,title,contents,date,createdAt,modifiedAt);
//    }

//    @GetMapping("/api/user/{username}")
//    public UserInfoDto getUser(@PathVariable String username){
//        User user = userRepo.findByUsername(username).orElseThrow(
//                () -> new IllegalArgumentException("해당 유저를 찾을 수 없습니다.")
//        );
//        return new UserInfoDto(user.getUsername(),user.getName(),user.getProfile());
//    }
    @GetMapping("/api/talk")
    public List<Talk> getTalk(){
        return talkRepo.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/talk/{id}") //read
    public List<Talk> getTalkRead(@PathVariable Long id) {
        return talkRepo.findAllById(id);
    }
    @GetMapping("/api/retalk/{id}") //rply
    public List<ReTalk> getReTalkRead(@PathVariable Long id) {
        return reTalkRepo.findAllByTalkIdOrderByCreatedAtAsc(id);
    }

    //Post
    @PostMapping("/api/talk")
    public void createTalk(@RequestBody TalkRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        talkService.create(requestDto,userDetails);
    }

    @PostMapping("/api/retalk")
    public void createReTalk(@RequestBody ReTalkRequestDto requestDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        talkService.create(requestDto,userDetails);
    }

    //Delete
    @DeleteMapping("/api/talk/{id}")
    public String deleteTalk(@PathVariable Long id, @RequestBody TalkRequestDto requestDto) {
        return talkService.delete(id,requestDto);
    }

    @DeleteMapping("/api/retalk/{id}")
    public String deletaReTalk(@PathVariable Long id, @RequestBody ReTalkRequestDto requestDto){
        return talkService.delete(id, requestDto);
    }

    //Update
    @PutMapping("/api/talk/{id}")
    public String updateTalk(@PathVariable Long id, @RequestBody TalkRequestDto requestDto){
        return talkService.update(id,requestDto);
    }

    @PutMapping("/api/retalk/{id}")
    public String updateReTalk(@PathVariable Long id, @RequestBody ReTalkRequestDto requestDto){
        return talkService.update(id,requestDto);
    }
}
