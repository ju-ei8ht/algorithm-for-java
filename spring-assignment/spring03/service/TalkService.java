package com.talk.talk.service;

import com.talk.talk.domain.ReTalk;
import com.talk.talk.domain.Talk;
import com.talk.talk.dto.ReTalkRequestDto;
import com.talk.talk.dto.TalkRequestDto;
import com.talk.talk.repo.ReTalkRepo;
import com.talk.talk.repo.TalkRepo;
import com.talk.talk.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class TalkService {
    private final TalkRepo talkRepo;
    private final ReTalkRepo reTalkRepo;

    @Transactional
    public Talk create(TalkRequestDto requestDto, UserDetailsImpl userDetails){
        Talk talk = new Talk(requestDto, userDetails);
        return talkRepo.save(talk);
    }
    @Transactional
    public ReTalk create(ReTalkRequestDto requestDto, UserDetailsImpl userDetails){
        ReTalk reTalk = new ReTalk(requestDto,userDetails);
        return reTalkRepo.save(reTalk);
    }

    @Transactional
    public String delete(Long id, TalkRequestDto requestDto) {
        String msg = "";
        String username = requestDto.getUsername();
        Talk talk = talkRepo.findById(id).get();
        if(username.equals(talk.getUsername())){
            talkRepo.deleteById(id);
            reTalkRepo.deleteByTalkId(id);
        }
        else msg = "wrong id";

        return msg;
    }
    @Transactional
    public String delete(Long id, ReTalkRequestDto requestDto) {
        String msg = "";
        String username = requestDto.getUsername();
        ReTalk reTalk = reTalkRepo.findById(id).get();
        if(username.equals(reTalk.getUsername())) reTalkRepo.deleteById(id);
        else msg = "wrong id";

        return msg;
    }

    @Transactional
    public String update(Long id, TalkRequestDto requestDto) {
        String msg = "";
        String username = requestDto.getUsername();
        Talk talk = talkRepo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        if(username.equals(talk.getUsername())) talk.update(requestDto);
        else msg = "wrong id";

        return msg;
    }
    @Transactional
    public String update(Long id, ReTalkRequestDto requestDto) {
        String msg = "";
        String username = requestDto.getUsername();
        ReTalk reTalk = reTalkRepo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
        if(username.equals(reTalk.getUsername())) reTalk.update(requestDto);
        else msg = "wrong id";

        return msg;
    }
}
