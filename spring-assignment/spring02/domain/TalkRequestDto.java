package com.talk.talk.domain;

import lombok.Getter;

@Getter
public class TalkRequestDto {
    private String username;
    private String title;
    private String contents;
    private String password;
    private String admin;
    private int profile;
}
