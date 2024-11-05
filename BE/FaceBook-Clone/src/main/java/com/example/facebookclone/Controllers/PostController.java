package com.example.facebookclone.Controllers;

import com.example.facebookclone.DTOs.PostDTO;
import com.example.facebookclone.Models.Posts;
import com.example.facebookclone.Models.Users;
import com.example.facebookclone.Response.PostResponse;
import com.example.facebookclone.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("")
    public ResponseEntity<?> getAllPosts(){
        return ResponseEntity.ok().body(postService.getAllPosts());
    }

    @PostMapping("create")
    public ResponseEntity<?> createPost(@RequestBody PostDTO postDTO, Authentication authentication){
        return ResponseEntity.ok().body(postService.createPost(postDTO));
    }
}
