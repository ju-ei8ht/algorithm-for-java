package com.talk.talk.dto;

import lombok.Getter;

@Getter
public class ReTalkRequestDto {
    private String username;
    private String title;
    private String contents;
    private Long talkId;
}
