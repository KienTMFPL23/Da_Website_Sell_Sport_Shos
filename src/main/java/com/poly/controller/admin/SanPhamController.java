package com.poly.controller.admin;

import com.poly.entity.SanPham;
import com.poly.service.SanPhamService;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Getter
    @Setter
    public static class SearchForm {
        String keyword ="";
    }
    @GetMapping("/san-pham/hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "0") int p) {
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<SanPham> page = sanPhamService.findALlSP(pageable);
        model.addAttribute("page", page);
        model.addAttribute("search", new SearchForm());
        model.addAttribute("view", "../san_pham/index.jsp");
        return "admin/index";
    }

    @RequestMapping("/san-pham/search")
    public String search(Model model, @ModelAttribute("search") SearchForm searchForm, @RequestParam(defaultValue = "0") int p) {
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<SanPham> page = sanPhamService.findAllByKeyword(searchForm.keyword, pageable);
        model.addAttribute("page", page);
        model.addAttribute("view", "../san_pham/index.jsp");
        return "admin/index";
    }
    @RequestMapping("/san-pham/sort")
    public String sort(Model model, @ModelAttribute("search") SearchForm searchForm, @RequestParam(defaultValue = "0") int p) {
        if (p < 0) {
            p = 0;
        }
        Sort sort = Sort.by(
                new Sort.Order(Sort.Direction.DESC, "maSP"),
                new Sort.Order(Sort.Direction.DESC, "tenSP")
        );
        Pageable pageable = PageRequest.of(p,5,sort);
        Page<SanPham> page = sanPhamService.findALlSP(pageable);
        model.addAttribute("page", page);
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
        if (sanPham.getMaSP().trim().length() < 5){
            hasError = true;
            model.addAttribute("erorLenghMa","Mã sản phẩm phải lớn hơn hoặc bằng 5");
            model.addAttribute("view", "../san_pham/add_update.jsp");
            return "admin/index";
        }
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
    public String update(@PathVariable("id") UUID id, Model model, @Valid @ModelAttribute("SP") SanPham sanPham,
                         BindingResult result) {
        Boolean hasError = result.hasErrors();
        if (sanPham.getMaSP().trim().length() < 5){
            hasError = true;
            model.addAttribute("erorLenghMa","Mã sản phẩm phải lớn hơn hoặc bằng 5");
            model.addAttribute("view", "../san_pham/add_update.jsp");
            return "admin/index";
        }
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
