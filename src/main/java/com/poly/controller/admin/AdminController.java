package com.poly.controller.admin;

import com.poly.entity.KichCo;
import com.poly.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    KichCoService service;

    @RequestMapping("/admin/dashboard")
    public String hienthi() {
        return "/admin/index";
    }
//    @RequestMapping("/admin/kich-co")
//    public String kichcow(@ModelAttribute("kichco") KichCo kichCo, @RequestParam(defaultValue = "0") int p, Model model) {
//        List<KichCo> listKC = service.getList();
//        Pageable pageable = PageRequest.of(p, 5);
//        Page<KichCo> page = service.getListKC(pageable);
//        model.addAttribute("page", page);
//        model.addAttribute("searchForm", new KichCoController.SearchForm());
//        model.addAttribute("view","../kich-co/list-kich-co.jsp");
//        return "/admin/index";
//    }
}
