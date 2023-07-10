package com.poly.controller.admin;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BanHangController {

    @Getter
    @Setter
    public static class SearchForm{
        String keyword ="";
    }

    @GetMapping("/ban-hang/counter")
    public String hienThi(Model model){
        model.addAttribute("view","../ban_hang_tai_quay/ban-hang.jsp");
        model.addAttribute("searchForm",new SearchForm());
        return "admin/index";
    }
}
