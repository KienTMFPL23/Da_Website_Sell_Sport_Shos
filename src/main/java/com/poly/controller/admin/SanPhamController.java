package com.poly.controller.admin;

import com.poly.entity.SanPham;
import com.poly.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("/san-pham/hien-thi")
    public String hienthi(Model model) {
        model.addAttribute("listSP", sanPhamService.findALlSP());
        model.addAttribute("view", "../san_pham/index.jsp");
        return "admin/index";
    }

    @GetMapping("/san-pham/view-add")
    public String viewAdd(Model model, @ModelAttribute("SP") SanPham sanPham) {
        model.addAttribute("action", "/san-pham/add");
        model.addAttribute("view", "../san_pham/add_update.jsp");
        return "admin/index";
    }

    @GetMapping("/san-pham/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable("id") UUID id, @ModelAttribute("SP") SanPham sanPham) {
        model.addAttribute("view", "../san_pham/add_update.jsp");
        SanPham product = sanPhamService.getOne(id);
        model.addAttribute("action", "/san-pham/update/" + product.getId());
        SanPham sp = sanPhamService.getOne(id);
        model.addAttribute("SP", sp);
        return "admin/index";
    }

    @PostMapping("/san-pham/add")
    public String add(Model model, @Valid @ModelAttribute("SP") SanPham sanPham, BindingResult result) {
        Boolean hasError = result.hasErrors();
        SanPham product = sanPhamService.getSP(sanPham.getMaSP());
        if (product != null) {
            hasError = true;
            model.addAttribute("maspError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "../san_pham/add_update.jsp");
            return "admin/index";
        }
        if (hasError) {
            model.addAttribute("view", "../san_pham/add_update.jsp");
            return "admin/index";
        }
        sanPhamService.addSP(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("/san-pham/update/{id}")
    public String update(@PathVariable("id") UUID id, Model model,@Valid @ModelAttribute("SP") SanPham sanPham,
                         BindingResult result) {
        Boolean hasError = result.hasErrors();
        if (hasError) {
            model.addAttribute("view", "../san_pham/add_update.jsp");
            return "admin/index";
        }
        SanPham sp = sanPhamService.getOne(id);
        sp.setMaSP(sanPham.getMaSP());
        sp.setTenSP(sanPham.getTenSP());
        sanPhamService.update(sp);
        return "redirect:/san-pham/hien-thi";
    }
}
