package com.example.facebookclone.Services;

import com.example.facebookclone.Models.Users;

import java.util.List;

public interface FriendService {
    public void addFriend(Long userId, Long friendId);
    public List<Users> getFriends(Long userId);
    public void removeFriend(Long userId, Long friendId);
    public Users searchFriend(String keyWord);
}
