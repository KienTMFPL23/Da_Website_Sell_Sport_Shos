package com.poly.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThongKecontroller {

    @RequestMapping("/admin/thong-ke")
    public String index(Model model){
        model.addAttribute("view", "../thong-ke/index.jsp");
        return "/admin/index";
    }
}
