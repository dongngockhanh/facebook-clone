package com.example.facebookclone.Controllers;

import com.example.facebookclone.Models.Users;
import com.example.facebookclone.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {
    @GetMapping()
    public ResponseEntity<Map<String,String>> test(){
        Map<String,String> response = new HashMap<>();
        response.put("message","It's Work");
        return ResponseEntity.ok().body(response);
    }
}
