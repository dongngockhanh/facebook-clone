package com.example.facebookclone.Repositories;

import com.example.facebookclone.Models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends JpaRepository<Posts,Long> {
    List<Posts> findAllByOrderByPostTimeDesc();// lấy danh sách từ gần nhất tới lâu nhất
}
