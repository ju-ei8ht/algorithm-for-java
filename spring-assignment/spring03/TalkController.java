package com.talk.talk.controller;

import com.talk.talk.domain.Talk;
import com.talk.talk.dto.TalkRequestDto;
import com.talk.talk.repo.TalkRepo;
import com.talk.talk.service.TalkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class TalkController {
    private final TalkRepo talkRepo;
    private final TalkService talkService;

    @RequestMapping("/read/{date}")
    public ModelAndView readDate(Model model, @PathVariable String date) {
        model.addAttribute("date", date);
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
    @Secured("ROLE_ADMIN")
    @GetMapping("/api/write")
    public String write(){
        return "성공";
    }

    //Get
    @GetMapping("/api/talk")
    public List<Talk> getTalk() {
        return talkRepo.findAllByOrderByCreatedAtDesc();
    }

    //Post
    @PostMapping("/api/talk")
    public void createTalk(@RequestBody TalkRequestDto requestDto) {
        talkService.create(requestDto);
    }

    //Delete
    @DeleteMapping("/api/talk/{id}")
    public void deleteTalk(@PathVariable Long id, @RequestBody TalkRequestDto requestDto) {
        talkService.delete(id,requestDto);
    }

    //Update
    @PutMapping("/api/talk/{id}")
    public void updateTalk(@PathVariable Long id, @RequestBody TalkRequestDto requestDto){
        talkService.update(id,requestDto);
    }
}
