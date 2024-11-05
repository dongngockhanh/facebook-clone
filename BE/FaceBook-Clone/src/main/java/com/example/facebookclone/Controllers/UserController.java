package com.example.facebookclone.Controllers;

import com.example.facebookclone.Models.Users;
import com.example.facebookclone.Response.UserResponse;
import com.example.facebookclone.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> login (@RequestBody Users users) {
        return ResponseEntity.ok().body(userService.login(users));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users users){
        return ResponseEntity.ok().body(userService.register(users));
    }
    @GetMapping("/search")
    public ResponseEntity<?> findUser(@RequestParam("name") String keyWord){
        return ResponseEntity.ok().body(userService.searchUser(keyWord));
    }
}
