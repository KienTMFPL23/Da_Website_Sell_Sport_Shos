package com.poly.controller.admin;

import com.poly.entity.NguoiDung;
import com.poly.entity.TaiKhoan;
import com.poly.repository.NguoiDungReponsitory;
import com.poly.service.Impl.NguoiDungServiceimpl;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @Autowired
    HttpSession session;
    @Autowired
    NguoiDungServiceimpl nguoiDungService;

    @RequestMapping("/admin/dashboard")
    public String hienthi(Model model) {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        NguoiDung nguoiDung = nguoiDungService.findById(taiKhoan.getId());
        model.addAttribute("username", taiKhoan.getUsername());
        return "/admin/index";
    }
}
