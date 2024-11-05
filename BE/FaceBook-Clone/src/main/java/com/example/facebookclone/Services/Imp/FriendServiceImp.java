package com.example.facebookclone.Services.Imp;

import com.example.facebookclone.ExceptionHandle.NotFoundDataException;
import com.example.facebookclone.Models.Users;
import com.example.facebookclone.Repositories.UserRepo;
import com.example.facebookclone.Services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendServiceImp implements FriendService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public void addFriend(Long userId, Long friendId) {
        Users user = findUsers(userId);
        Users friend = findUsers(friendId);
        user.getFriends().add(friend);
        userRepo.save(user);
        friend.getFriends().add(user);
        userRepo.save(friend);
    }

    @Override
    public List<Users> getFriends(Long userId) {
        Users user  = findUsers(userId);
        return new ArrayList<>(user.getFriends());
    }

    @Override
    public void removeFriend(Long userId, Long friendId) {
        Users user  = findUsers(userId);
        Users friend  = findUsers(friendId);
        user.getFriends().remove(friend);
        userRepo.save(user);
        friend.getFriends().remove(user);
        userRepo.save(friend);

    }

    @Override
    public Users searchFriend(String keyWord) {
        return null;
    }

    private Users findUsers(Long userId){
        return userRepo.findById(userId)
                .orElseThrow(()-> new NotFoundDataException("không tìm thấy người dùng"));
    }
}
