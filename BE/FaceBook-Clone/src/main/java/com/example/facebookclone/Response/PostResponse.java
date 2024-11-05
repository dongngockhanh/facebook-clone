package com.example.facebookclone.Response;

import com.example.facebookclone.Models.Users;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostResponse {
    private Long id;

    private Long user_id;

    private String email;

    private String content;

    private LocalDateTime post_time;

    private int likes;
}
