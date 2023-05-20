package com.ex230519.board.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberDto {
    private String name;
    private String id;
    private String password;
}
