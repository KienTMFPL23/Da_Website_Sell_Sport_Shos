package com.poly.controller.admin;


import com.poly.entity.MauSac;
import com.poly.repository.MauSacReponsitories;
import com.poly.service.Impl.MauSacServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller

public class MauSacController {
    @Autowired
    MauSacReponsitories msr;
    @Autowired
    MauSacServiceImpl mss;

    @GetMapping("mau-sac/hien-thi")
    public String hien(@Param("key") String key, Model model, @ModelAttribute("ms") MauSac mauSac, @RequestParam(defaultValue = "1") int page) {


        if (page < 1) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page - 1, 6);
        Page<MauSac> pgg = this.mss.search(key, pageable);
        model.addAttribute("list", pgg);
//        model.addAttribute("ms", mauSac);
        model.addAttribute("view", "../mau_sac/index.jsp");
        return "/admin/index";
    }

    //    @GetMapping("delete/{id}")
//    public String xoa(@PathVariable("id") MauSac ms) {
//        this.msr.delete(ms);
//        return "redirect:/mau-sac/hien-thi";
//
//    }
    @RequestMapping("/mau-sac/sort")
    public  String Sort(@RequestParam(defaultValue = "1") int p, Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "ten");
        Pageable pageable = PageRequest.of(p-1, 5, sort);
        Page<MauSac> page = msr.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("view", "../mau_sac/index.jsp");
        return "/admin/index";
    }

    @RequestMapping("mau-sac/update/{id}")
    public String vupdate(@PathVariable("id") UUID id, Model model) {
        MauSac ms = this.msr.findById(id).orElse(null);
        model.addAttribute("ms", ms);
        model.addAttribute("view", "../mau_sac/update.jsp");
        return "/admin/index";
    }

    @GetMapping("mau-sac/hien-thi-add")
    public String vthem(Model model, MauSac ms) {
        model.addAttribute("ms", ms);
        model.addAttribute("view", "../mau_sac/add.jsp");
        return "/admin/index";
    }

    @RequestMapping("mau-sac/update")
    public String update(@Valid @ModelAttribute("ms") MauSac ms, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "mau-sac/update";
        } else {
            this.msr.save(ms);
        }
        model.addAttribute("view", "../mau_sac/index.jsp");
        return "redirect:/mau-sac/hien-thi";
    }

    @PostMapping("mau-sac/add")
    public String add(@Valid @ModelAttribute("ms") MauSac ms, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "mau_sac/add";
        } else {
            this.msr.save(ms);
        }
        model.addAttribute("view", "../mau_sac/index.jsp");
        return "redirect:/mau-sac/hien-thi";
    }

}
