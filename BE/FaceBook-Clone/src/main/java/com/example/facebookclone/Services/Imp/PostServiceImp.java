package com.example.facebookclone.Services.Imp;

import com.example.facebookclone.DTOs.PostDTO;
import com.example.facebookclone.ExceptionHandle.NotFoundDataException;
import com.example.facebookclone.Models.Posts;
import com.example.facebookclone.Models.Users;
import com.example.facebookclone.Repositories.PostRepo;
import com.example.facebookclone.Repositories.UserRepo;
import com.example.facebookclone.Response.PostResponse;
import com.example.facebookclone.Services.PostService;
import com.example.facebookclone.Utils.AuthUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService{
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<PostResponse> getAllPosts() {
        List<Posts> postsList = postRepo.findAllByOrderByPostTimeDesc();
        List<PostResponse> postResponses = new ArrayList<>();
        for(Posts post: postsList){
            postResponses
                    .add(PostResponse.builder()
                            .id(post.getId())
                            .user_id(post.getUser_id().getId())
                            .email(post.getUser_id().getEmail())
                            .content(post.getContent())
                            .post_time(post.getPostTime())
                            .likes(post.getLikes())
                    .build());
        }
        return postResponses;
    }

    @Override
    public PostResponse createPost(PostDTO postDTO) {
        postDTO.setUser_id(AuthUtil.getCurrentUserId());
        Users user = userRepo.findById(postDTO.getUser_id())
                .orElseThrow(()->new NotFoundDataException("không tìm thấy user"));
        Posts post = new Posts();
        post.setUser_id(user);
        post.setContent(postDTO.getContent());
        post.setPostTime(LocalDateTime.now());
        Posts saved = postRepo.save(post);
        return PostResponse.builder()
                .id(saved.getId())
                .user_id(saved.getId())
                .email(saved.getUser_id().getEmail())
                .content(saved.getContent())
                .post_time(saved.getPostTime())
                .likes(saved.getLikes())
                .build();
    }

    @Override
    public void deletePost(Long user_id) {

    }
}
