package com.talk.talk.domain;


import com.talk.talk.dto.ReTalkRequestDto;
import com.talk.talk.security.UserDetailsImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class ReTalk extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private Long talkId;
    @Column(nullable = false)
    private String profile;

    public ReTalk(Long id, String username,String name, String title, String contents, Long talkId,String profile) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.title = title;
        this.contents = contents;
        this.talkId = talkId;
        this.profile = profile;
    }

    public ReTalk(ReTalkRequestDto requestDto, UserDetailsImpl userDetails){
        this.username = userDetails.getUsername();
        this.name = userDetails.getName();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.talkId = requestDto.getTalkId();
        this.profile = userDetails.getProfile();
    }

    public void update(ReTalkRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
