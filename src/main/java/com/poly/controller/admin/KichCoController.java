package com.poly.controller.admin;

import com.poly.entity.KichCo;
import com.poly.service.KichCoService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Data
    public static class SearchForm {
        String loaisize;
        Integer size;

    }

    @RequestMapping("/kich-co/hien-thi")
    public String hienthi(@ModelAttribute("kichco") KichCo kichCo, @RequestParam(defaultValue = "0") int p, Model model) {
        List<KichCo> listKC = service.getList();
        Pageable pageable = PageRequest.of(p, 5);
        Page<KichCo> page = service.getListKC(pageable);
        model.addAttribute("page", page);
        model.addAttribute("searchForm", new SearchForm());
        return "/kich-co/list-kich-co";
    }
    @RequestMapping("/kich-co/search")
    public String Search(@ModelAttribute("searchForm") SearchForm searchForm, @RequestParam(defaultValue = "0") int p, Model model) {
        List<KichCo> listKC = service.getList();
        Pageable pageable = PageRequest.of(p, 5);
        Page<KichCo> page = service.searchKH(searchForm.loaisize,searchForm.size,pageable);
        model.addAttribute("page", page);

        return "/kich-co/list-kich-co";
    }
    @RequestMapping("/kich-co/sort")
    public String Sort(@ModelAttribute("searchForm") SearchForm searchForm, @RequestParam(defaultValue = "0") int p, Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "size");
        Pageable pageable = PageRequest.of(p, 5,sort);
        Page<KichCo> page = service.searchKH(searchForm.loaisize,searchForm.size,pageable);
        model.addAttribute("page", page);

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
        if (kichCo.getMaKichCo() != null) {
            model.addAttribute("messMa", "Lỗi! Vui lòng kiểm tra mã không được trùng !");
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
