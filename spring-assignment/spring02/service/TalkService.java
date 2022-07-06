package com.talk.talk.service;

import com.talk.talk.domain.Talk;
import com.talk.talk.domain.TalkRepo;
import com.talk.talk.domain.TalkRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class TalkService {
    private final TalkRepo talkRepo;
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Transactional
    public Talk create(TalkRequestDto requestDto){
        String pwd = encoder.encode(requestDto.getPassword()); //password 암호화
        Talk talk = new Talk(requestDto.getUsername(),requestDto.getTitle(),requestDto.getContents(),pwd,requestDto.getAdmin(),requestDto.getProfile());
        return talkRepo.save(talk);
    }

    @Transactional
    public String delete(Long id, TalkRequestDto requestDto) {
        String msg = "";
        Talk talk = talkRepo.findById(id).get();
        if(encoder.matches(requestDto.getPassword(), talk.getPassword())) {
            talkRepo.deleteById(id); //password 일치해야 delete
        }else msg = "wrong password";
        return msg;
    }

    @Transactional
    public String update(Long id, TalkRequestDto requestDto) {
        String msg = "";
        Talk talk = talkRepo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        if(encoder.matches(requestDto.getPassword(), talk.getPassword())) {
            talk.update(requestDto); //password 일치해야 update
        }else msg = "wrong password";
        return msg;
    }
}
