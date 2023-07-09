package com.poly.controller.admin;

import com.poly.entity.*;
import com.poly.repository.*;
import com.poly.service.ChiTietSPService;
import com.poly.service.KichCoService;
import com.poly.service.SanPhamService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;
    @Autowired
    ChiTietSPService service;

    @Autowired
    DeGiayRepo deGiayRepo;

    @Autowired
    ChatLieuRepo chatLieuRepo;
    @Autowired
    KichCoService kichCoService;
    @Autowired
    LoaiGiayRepo loaiGiayRepo;
    @Autowired
    MauSacReponsitories mauSacReponsitories;
    @Autowired
    SanPhamRepo sanPhamRepo;
    @ModelAttribute("listDeGiay")
    List<DeGiay> listDeGiay() {
        return deGiayRepo.findAll();
    }

    @ModelAttribute("listChatLieu")
    List<ChatLieu> listChatLieu() {
        return chatLieuRepo.findAll();
    }

    @ModelAttribute("listKichCo")
    List<KichCo> listKichCo() {
        return kichCoService.getList();
    }

    @ModelAttribute("listMau")
    List<MauSac> listMauSac() {
        return mauSacReponsitories.findAll();
    }

    @ModelAttribute("listLoaiGiay")
    List<LoaiGiay> listLoaiGiay() {
        return loaiGiayRepo.findAll();
    }

    @ModelAttribute("listSP")
    List<SanPham> listSP() {
        return sanPhamRepo.findAll();
    }

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDSTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "Hoạt động");
        dsTrangThai.put(0, "Ngưng Hoạt động");
        return dsTrangThai;
    }
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
        String tensp = sp.getTenSP();
        model.addAttribute("tensp", tensp);
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
    public String update(@PathVariable("id") UUID id, Model model, @Valid @ModelAttribute("SP") SanPham sanPham,
                         BindingResult result) {
        Boolean hasError = result.hasErrors();
        if (hasError) {
            model.addAttribute("view", "../san_pham/add_update.jsp");
            return "admin/index";
        }
        SanPham sp = sanPhamService.getOne(id);
        sp.setMaSP(sanPham.getMaSP());
        sp.setTenSP(sanPham.getTenSP());
        model.addAttribute("tensp", sp.getTenSP());
        sanPhamService.update(sp);
        return "redirect:/san-pham/hien-thi";
    }

    @RequestMapping("/quan-ly-san-pham/view-add/{id}")
    public String viewAdd(@ModelAttribute("sanpham") QLSanPham sp,@PathVariable("id") UUID id, Model model) {

        SanPham sanPham1 = sanPhamService.getOne(id);
        model.addAttribute("tensp", sanPham1.getTenSP());
        model.addAttribute("action", "/quan-ly-san-pham/add/"+sanPham1.getId());
        model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
        return "/admin/index";
    }

    @PostMapping("/quan-ly-san-pham/add/{id}")
    public String AddSanPham(@PathVariable("id") UUID id,@ModelAttribute("sanpham") QLSanPham sp, Model model) {
        SanPham sanPham1 = sanPhamService.getOne(id);
        sp.setSanPham(sanPham1);
        model.addAttribute("tensp", sanPham1.getTenSP());
        service.addKC(sp);
        return "redirect:/admin/quan-ly-san-pham";
    }
}
