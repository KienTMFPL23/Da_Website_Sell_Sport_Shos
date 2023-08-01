package com.poly.Interceptor;

import com.poly.entity.TaiKhoan;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

@Service
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    HttpSession session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        TaiKhoan user = (TaiKhoan) session.getAttribute("userLogged");
        String error = "";
        if(user == null) {
            error = "Please login!";
            return false;
        }
        return true;

    }
}
