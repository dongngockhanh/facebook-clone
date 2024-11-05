package com.example.facebookclone.Services;

import com.example.facebookclone.DTOs.PostDTO;
import com.example.facebookclone.Models.Posts;
import com.example.facebookclone.Response.PostResponse;

import java.util.List;

public interface PostService {
    public List<PostResponse> getAllPosts();
    public PostResponse createPost(PostDTO postDTO);
    public void deletePost(Long user_id);
}
