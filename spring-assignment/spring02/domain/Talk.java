package com.talk.talk.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

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
    String title;
    @Column(nullable = false)
    private String contents;
    @Column(nullable = false)
    private String password;
    @Column
    private String admin;
    @Column(nullable = false)
    private int profile;
    public Talk(String username, String title, String contents, String password, String admin, int profile) {
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.password = password;
        this.admin = admin;
        this.profile = profile;
    }

    public Talk(TalkRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.password = requestDto.getPassword();
        this.admin = requestDto.getAdmin();
        this.profile = requestDto.getProfile();
    }
    public void update(TalkRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
