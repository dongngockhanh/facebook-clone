package com.example.facebookclone.DTOs;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDTO {
    private String content;
    private Long user_id;
}
