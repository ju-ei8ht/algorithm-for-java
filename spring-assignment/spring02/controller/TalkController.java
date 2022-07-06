package com.talk.talk.controller;

import com.talk.talk.domain.Talk;
import com.talk.talk.domain.TalkRepo;
import com.talk.talk.domain.TalkRequestDto;
import com.talk.talk.service.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TalkController {
    private final TalkRepo talkRepo;
    private final TalkService talkService;


    @RequestMapping("/read/{date}")
    public ModelAndView readDate(@PathVariable String date) {
        ModelAndView mav = new ModelAndView("/read.html?="+date);
        return mav;
    }


    //Get
    @GetMapping("/api/talk")
    public List<Talk> getTalk() {
        return talkRepo.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/talk/list") //list에서 distinct된 date만 출력하고 싶어서
    public List<LocalDate> getList(){
        return talkRepo.getDistinctTalksByDate();
    }

    @GetMapping("/api/talk/{date}") //read에서 path의 date로 get
    public List<Talk> getReadDate(@PathVariable String date) {
        LocalDate dates = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
        return talkRepo.findAllByDateOrderByCreatedAtAsc(dates);
    }

    //Post
    @PostMapping("/api/talk")
    public String createTalk(@RequestBody TalkRequestDto requestDto) {
        String msg = "";
        talkService.create(requestDto);
        return msg;
    }

    //Delete
    @DeleteMapping("/api/talk/{id}")
    public String deleteTalk(@PathVariable Long id, @RequestBody TalkRequestDto requestDto) {
        return talkService.delete(id,requestDto);
    }

    //Update
    @PutMapping("/api/talk/{id}")
    public String updateTalk(@PathVariable Long id, @RequestBody TalkRequestDto requestDto){
        return talkService.update(id,requestDto);
    }
}
