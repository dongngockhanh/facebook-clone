package com.example.facebookclone.Utils;
import com.example.facebookclone.Models.Users;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtil {
    public static Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Users) {
            return ((Users) authentication.getPrincipal()).getId();
        }
        throw new IllegalStateException("Không thể lấy thông tin người dùng hiện tại");
    }
}
