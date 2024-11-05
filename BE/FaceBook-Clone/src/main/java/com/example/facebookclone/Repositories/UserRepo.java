package com.example.facebookclone.Repositories;

import com.example.facebookclone.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Long> {
    Optional<Users> findUsersByEmail(String email);

    @Query("select u from Users u where u.email like %:keyWord%")
    List<Users> searchUserByKeyWord(@Param("keyWord") String keyWord);
}
