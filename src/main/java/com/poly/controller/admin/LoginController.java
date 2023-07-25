package com.poly.controller.admin;

import com.poly.entity.TaiKhoan;
import com.poly.repository.TaiKhoanRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    private TaiKhoanRepo taiKhoanRepo;

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDsTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "User");
        dsTrangThai.put(0, "Admin");
        return dsTrangThai;
    }

    @GetMapping("/login")
    public String getLoginForm(Model model) {

        model.addAttribute("taikhoan", new TaiKhoan());
        return "/dang-nhap/login";
    }

    @PostMapping("/login")
    public String login(Model model,
                        @ModelAttribute(name = "taikhoan") TaiKhoan taikhoan,
                        HttpSession session) {

        // Login success
        TaiKhoan accountFromDB = taiKhoanRepo.findByUsernameAndPassword(taikhoan.getUsername(),
                taikhoan.getPassword());

        if (accountFromDB != null) {
            session.setAttribute("userLogged", accountFromDB);
            return "redirect:/admin/dashboard";
        }

        // Login false
        model.addAttribute("message1", "Tài khoản hoặc Mật khẩu không đúng !!!");
        model.addAttribute("message2", "Vui lòng thử lại");
        return "/dang-nhap/login";
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("taikhoan", new TaiKhoan());
        return "/dang-nhap/register";
    }

    @PostMapping("/register")
    public String register(Model model,
                           @ModelAttribute(name = "taikhoan") TaiKhoan taikhoan, HttpSession session,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "confirmpassword") String confirmpassword
    ) {

        if (!password.equalsIgnoreCase(confirmpassword)) {
            model.addAttribute("messageConfirmPass", "Mật khẩu không trùng khớp");
            return "/dang-nhap/register";
        }

        taiKhoanRepo.save(taikhoan);
        session.setAttribute("userLogged", taikhoan);
        return "redirect:/admin/dashboard";


    }

    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {
        session.removeAttribute("userLogged");
        return "redirect:/login";
    }


}
