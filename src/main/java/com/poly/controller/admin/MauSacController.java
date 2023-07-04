package com.poly.controller.admin;

import com.poly.entity.MauSac;
import com.poly.repository.MauSacReponsitories;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@Controller

public class MauSacController {
    @Autowired
    MauSacReponsitories msr;

    @GetMapping("mau-sac/hien-thi")
    public String hien(Model model,@ModelAttribute("ms") MauSac mauSac,@RequestParam(defaultValue = "0",name = "page")Integer Number) {
        Pageable pageable = PageRequest.of(Number,5);
        Page<MauSac> pgg = this.msr.findAll(pageable);
        model.addAttribute("list", pgg);
//        model.addAttribute("ms", mauSac);
        return "mau_sac/index";
    }

//    @GetMapping("delete/{id}")
//    public String xoa(@PathVariable("id") MauSac ms) {
//        this.msr.delete(ms);
//        return "redirect:/mau-sac/hien-thi";
//
//    }

    @RequestMapping("mau-sac/update/{id}")
    public String vupdate(@PathVariable("id") UUID id, Model model) {
        MauSac ms = this.msr.findById(id).orElse(null);
        model.addAttribute("ms", ms);
        return "mau_sac/update";
    }

    @GetMapping("mau-sac/hien-thi-add")
    public String vthem(Model model, MauSac ms) {
        model.addAttribute("ms", ms);
        return "mau_sac/add";
    }

    @RequestMapping("mau-sac/update")
    public String update(@Valid @ModelAttribute("ms") MauSac ms, BindingResult result) {
        if (result.hasErrors()) {
            return "mau_sac/index";
        }else{
            this.msr.save(ms);
        }
        return "redirect:/mau-sac/hien-thi";
    }
    @PostMapping("mau-sac/add")
    public String add(@Valid @ModelAttribute("ms") MauSac ms, BindingResult result) {
        if (result.hasErrors()) {
            return "mau_sac/add";
        }else{
            this.msr.save(ms);
        }
        return "redirect:/mau-sac/hien-thi";
    }

}
