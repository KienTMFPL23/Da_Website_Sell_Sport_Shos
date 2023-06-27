package com.poly.controller;

import com.poly.entity.KichCo;
import com.poly.service.KichCoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class KichCoController {
    @Autowired
    KichCoService service;

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDsTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "Hoạt động");
        dsTrangThai.put(0, "Không hoạt động");
        return dsTrangThai;
    }

    @ModelAttribute("dsGioiTinh")
    public Map<Boolean, String> getDsGioiTinh() {
        Map<Boolean, String> dsGT = new HashMap<>();
        dsGT.put(true, "Nam");
        dsGT.put(false, "Nữ");
        return dsGT;
    }

    @RequestMapping("/kich-co/hien-thi")
    public String hienthi(@ModelAttribute("kichco") KichCo kichCo, Model model) {
        List<KichCo> listKC = service.getList();
        model.addAttribute("listKC", listKC);
        return "/kich-co/list-kich-co";
    }

    @RequestMapping("/kich-co/view-add")
    public String viewAdd(@ModelAttribute("kichco") KichCo kichCo, Model model) {
        model.addAttribute("action", "/kich-co/add");
        return "/kich-co/index";
    }

    @RequestMapping("/kich-co/add")
    public String addKC(Model model, @Valid @ModelAttribute("kichco") KichCo kichCo, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Lỗi! Vui lòng kiểm tra các trường trên !");
            return "/kich-co/index";
        }
        service.addKC(kichCo);
        return "redirect:/kich-co/hien-thi";
    }

    @RequestMapping("/kich-co/update/{id}")
    public String updateKC(Model model, @Valid @ModelAttribute("kichco") KichCo kichCo, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Lỗi! Vui lòng kiểm tra các trường trên !");
            return "/kich-co/index";
        }

        service.addKC(kichCo);
        return "redirect:/kich-co/hien-thi";
    }

    @RequestMapping("/kich-co/remove/{id}")
    public String removeKC(@ModelAttribute("kichco") KichCo kichCo, Model model) {
        service.deleteKC(kichCo.getId());
        return "redirect:/kich-co/hien-thi";
    }

    @RequestMapping("/kich-co/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        KichCo co = service.getOne(id);
        model.addAttribute("action", "/kich-co/update/" + co.getId());
        model.addAttribute("kichco", co);

        return "/kich-co/index";
    }
}
