package com.example.facebookclone.Services.Imp;

import com.example.facebookclone.ExceptionHandle.ExistingDataException;
import com.example.facebookclone.ExceptionHandle.GlobalException;
import com.example.facebookclone.ExceptionHandle.NotFoundDataException;
import com.example.facebookclone.Models.Token;
import com.example.facebookclone.Models.Users;
import com.example.facebookclone.Repositories.UserRepo;
import com.example.facebookclone.Response.UserResponse;
import com.example.facebookclone.Services.JwtService;
import com.example.facebookclone.Services.UserService;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Override
    public List<Users> listUsers() {
        return userRepo.findAll();
    }

    @Override
    public List<UserResponse> searchUser(String keyWord) {
        List<Users> userList = userRepo.searchUserByKeyWord(keyWord);
        List<UserResponse> userResponseList = new ArrayList<>();
        if(keyWord.length()==0) {
            return userResponseList;
        }
        for(Users user : userList){
            userResponseList.add(UserResponse.builder()
                            .id(user.getId())
                            .email(user.getEmail())
                            .username(user.getUsername())
                    .build());
        }
        return userResponseList;
    }

    @Override
    public Token login(Users users) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(users.getEmail(),users.getPassword())
        );
        if(authentication.isAuthenticated()){
            return Token.builder().token(jwtService.generateToken(users.getEmail())).build();
        }
        return null;
    }

    @Override
    public String register(Users users) {
        Optional<Users> existing = userRepo.findUsersByEmail(users.getEmail());
        if(existing.isPresent()){
            throw new ExistingDataException("Tài khoản đã tồn tại");
        }
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepo.save(users);
        return "thành công";
    }
}
