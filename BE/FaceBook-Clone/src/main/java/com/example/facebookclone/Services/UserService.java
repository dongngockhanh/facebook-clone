package com.example.facebookclone.Services;

import com.example.facebookclone.Models.Token;
import com.example.facebookclone.Models.Users;
import com.example.facebookclone.Response.UserResponse;

import java.util.List;

public interface UserService {
    Token login(Users users);
    String register(Users users);
    List<Users> listUsers();
    List<UserResponse> searchUser(String keyWord);
}
