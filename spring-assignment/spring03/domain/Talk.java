package com.talk.talk.domain;

import com.talk.talk.dto.TalkRequestDto;
import com.talk.talk.security.UserDetailsImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Talk extends Timestamped{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    String title;
    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private String profile;

    public Talk(Long id, String username, String name, String title, String contents, String profile) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.title = title;
        this.contents = contents;
        this.profile = profile;
    }

    public Talk(TalkRequestDto requestDto, UserDetailsImpl userDetails){
        this.username = userDetails.getUsername();
        this.name = userDetails.getName();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.profile = userDetails.getProfile();
    }
    public void update(TalkRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
