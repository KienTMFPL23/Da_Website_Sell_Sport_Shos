package com.poly.controller.admin;

import com.poly.entity.*;
import com.poly.repository.*;
import com.poly.service.ChiTietSPService;
import com.poly.service.KichCoService;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class QuanLySanPhamController {
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

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDSTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "Hoạt động");
        dsTrangThai.put(0, "Ngưng Hoạt động");
        return dsTrangThai;
    }

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
    @Data
    public static class SearchFormSP {
        String keyword;

    }
    @ModelAttribute("listSP")
    List<SanPham> listSP() {
        return sanPhamRepo.findAll();
    }
  @RequestMapping("/admin/san-pham")
    public String hienThiSanPham(@ModelAttribute("sanpham") QLSanPham sp, @RequestParam(defaultValue = "0") int p, Model model){
      if (p < 0) {
          p = 0;
      }
      Pageable pageable= PageRequest.of(p,5);
      Page<QLSanPham> qlSanPhamPage=service.getListSP(pageable);
      model.addAttribute("page",qlSanPhamPage);
      model.addAttribute("view","../quan-ly-san-pham/list-san-pham.jsp");
     model.addAttribute("searchForm",new SearchFormSP());
        return "/admin/index";
  }

  @RequestMapping("/san-pham/view-add")
  public String viewAdd(@ModelAttribute("sanpham") QLSanPham sp,Model model){
        model.addAttribute("action","/san-pham/add");
      model.addAttribute("view","../quan-ly-san-pham/index.jsp");
      return  "/admin/index";
  }

  @PostMapping("/san-pham/add")
    public String themSanPham(@ModelAttribute("sanpham") QLSanPham sp,Model model){
      System.out.println(sp.getChatLieu());
      service.addKC(sp);
      return "redirect:/admin/san-pham";
  }

    @RequestMapping("/san-pham/update/{id}")
    public String updateKC(Model model, @Valid @ModelAttribute("sanpham") QLSanPham qlSanPham, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("mess", "Lỗi! Vui lòng kiểm tra các trường trên !");
            model.addAttribute("view","../quan-ly-san-pham/index.jsp");
            return  "/admin/index";
        }

        service.addKC(qlSanPham);
        return "redirect:/admin/san-pham";
    }
    @RequestMapping("/san-pham/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        QLSanPham sp = service.getOne(id);
        model.addAttribute("action", "/san-pham/update/" + sp.getId());
        model.addAttribute("sanpham", sp);
        model.addAttribute("view","../quan-ly-san-pham/index.jsp");
        return  "/admin/index";
    }
}
