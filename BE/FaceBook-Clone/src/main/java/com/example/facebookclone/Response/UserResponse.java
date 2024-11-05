package com.example.facebookclone.Response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserResponse {
    private Long id;
    private String email;
    private String username;
}
