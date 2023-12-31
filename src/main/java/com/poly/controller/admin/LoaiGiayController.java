package com.poly.controller.admin;

import com.poly.entity.LoaiGiay;
import com.poly.repository.LoaiGiayRepo;
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

import java.util.List;
import java.util.UUID;

@Controller
public class LoaiGiayController {

    @Autowired
    LoaiGiayRepo repo;

    @Data
    public static class SearchForm {
        String keyword = "";
    }

    @RequestMapping("/loai-giay/sort")
    public String sortLG(Model model, @ModelAttribute SearchForm searchForm, @RequestParam(defaultValue = "0") int p) {
        if (p < 0) {
            p = 0;
        }
        Sort sort = Sort.by(Sort.Direction.ASC, "tentheloai");
        Pageable pageable = PageRequest.of(p, 5, sort);
        Page<LoaiGiay> page = repo.getAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("view", "../loai-giay/list.jsp");
        return "/admin/index";
    }

    @RequestMapping("/admin/loai-giay")

    public String index(Model model, @ModelAttribute SearchForm searchForm, @RequestParam(defaultValue = "0") int p) {
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        if (searchForm.keyword.equals("")) {
            Page<LoaiGiay> page = repo.getAll(pageable);
            model.addAttribute("page", page);
        } else {
            Page<LoaiGiay> page = repo.searchByMaLoaiGiay("%" + searchForm.keyword + "%", pageable);
            model.addAttribute("page", page);
        }
        model.addAttribute("lg", new LoaiGiay());
        model.addAttribute("searchForm", searchForm);
        model.addAttribute("view", "../loai-giay/list.jsp");
        return "/admin/index";
    }

    @RequestMapping("/admin/loai-giay/add")
    public String save(@Valid @ModelAttribute("lg") LoaiGiay loaiGiay, BindingResult result, Model model) {
        Boolean hasE = result.hasErrors();
        List<LoaiGiay> list = repo.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMa().equals(loaiGiay.getMa())) {
                model.addAttribute("errorMa", "Ma loai giay da ton tai");
                hasE = true;
            }
            if (loaiGiay.getMa().length() < 5) {
                model.addAttribute("errorMa", "Ma loai giay nhieu hon 5 ki tu");
                hasE = true;
            }
            if (loaiGiay.getMa().length() > 100) {
                model.addAttribute("errorMa", "Ma loai giay it hon 100 ki tu");
                hasE = true;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getTentheloai().equals(loaiGiay.getTentheloai())) {
                model.addAttribute("errorTen", "Ten loai giay da ton tai");
                hasE = true;
            }
            if (loaiGiay.getTentheloai().length() > 150) {
                model.addAttribute("errorTen", "Ten loai giay it hon 150 ki tu");
                hasE = true;
            }
            if (loaiGiay.getTentheloai().length() == 0) {
                model.addAttribute("errorTen", "Ten loai giay khong duoc bo trong");
                hasE = true;
            }
        }
        if (hasE) {
            model.addAttribute("lg", new LoaiGiay());
            model.addAttribute("view", "../loai-giay/form.jsp");
            return "/admin/index";
        }
        loaiGiay.setTrangthai(1);
        repo.save(loaiGiay);
        return "redirect:/admin/loai-giay";
    }

    @RequestMapping("/admin/loai-giay/update/{id}")
    public String update(@Valid @ModelAttribute("lg") LoaiGiay loaiGiay, BindingResult result, Model model, @PathVariable UUID id) {
        boolean hasE = result.hasErrors();
        List<LoaiGiay> list = repo.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (loaiGiay.getMa().length() < 5) {
                model.addAttribute("errorMa", "Ma loai giay nhieu hon 5 ki tu");
                hasE = true;
            }
            if (loaiGiay.getMa().length() > 100) {
                model.addAttribute("errorMa", "Ma loai giay it hon 100 ki tu");
                hasE = true;
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (loaiGiay.getTentheloai().length() > 150) {
                model.addAttribute("errorTen", "Ten loai giay it hon 150 ki tu");
                hasE = true;
            }
            if (loaiGiay.getTentheloai().length() == 0) {
                model.addAttribute("errorTen", "Ten loai giay khong duoc bo trong");
                hasE = true;
            }
        }
        if (hasE) {
            model.addAttribute("lg", new LoaiGiay());
            model.addAttribute("view", "../loai-giay/view-update.jsp");
            return "/admin/index";
        }
        repo.save(loaiGiay);
        return "redirect:/admin/loai-giay";
    }

    @RequestMapping("/loai-giay/edit/{id}")
    public String edit(Model model, @PathVariable UUID id) {
        model.addAttribute("id", id);
        model.addAttribute("lg", repo.findById(id));
        model.addAttribute("listLG", repo.findAll());
        model.addAttribute("view", "../loai-giay/view-update.jsp");
        return "/admin/index";

    }

    @RequestMapping("/loai-giay/form")
    public String form(Model model) {
        model.addAttribute("lg", new LoaiGiay());
        model.addAttribute("view", "../loai-giay/form.jsp");
        return "/admin/index";
    }
}
