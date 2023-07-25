package com.poly.controller.admin;

import com.google.zxing.WriterException;
import com.poly.entity.*;
import com.poly.repository.*;
import com.poly.service.ChiTietSPService;
import com.poly.service.KichCoService;
import com.poly.utils.QRCodeGenerator;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

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

    @ModelAttribute("dsGioiTinh")
    public Map<Boolean, String> getDsGioiTinh() {
        Map<Boolean, String> dsGT = new HashMap<>();
        dsGT.put(true, "Nam");
        dsGT.put(false, "Nữ");
        return dsGT;
    }

    @Data
    public static class SearchFormSP {
        String keyword;
        String tenmau;
    }

    @Data
    public static class SortFormSP {
        String key = "";
    }

    @ModelAttribute("listSP")
    List<SanPham> listSP() {
        return sanPhamRepo.findAll();
    }

    @RequestMapping("/admin/quan-ly-san-pham")

    public String hienThiSanPham(@ModelAttribute("sortForm") SortFormSP sortFormSP, @ModelAttribute("sanpham") QLSanPham sp, @RequestParam(defaultValue = "0") int p, Model model) throws IOException, WriterException {

        if (p < 0) {
            p = 0;
        }

        Pageable pageable = PageRequest.of(p, 5);
        Page<ChiTietSanPham> qlSanPhamPage = service.getListSP(pageable);
        model.addAttribute("page", qlSanPhamPage);
        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("searchForm", new SearchFormSP());
        return "/admin/index";
    }

    @RequestMapping("/quan-ly-san-pham/search")
    public String searchSP(@ModelAttribute("searchForm") SearchFormSP searchFormSP, @RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Pageable pageable = PageRequest.of(p, 5);
        Page<ChiTietSanPham> qlSanPhamPage = service.searchCTSP(searchFormSP.keyword, searchFormSP.tenmau, pageable);

        model.addAttribute("page", qlSanPhamPage);
        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("sanpham", new QLSanPham());
        model.addAttribute("sortForm", new SortFormSP());
        return "/admin/index";
    }

    // filer with combobox
//    @RequestMapping("/quan-ly-san-pham/search-by-mausac")
//    public String searchByMau(@RequestParam(value = "tenmau1", required = false) String tenmau1, @RequestParam(defaultValue = "0") int p, Model model) {
//        if (p < 0) {
//            p = 0;
//        }
//        Page<ChiTietSanPham> qlSanPhamPage;
//        Pageable pageable = PageRequest.of(p, 5);
//        if (tenmau1 != null && !tenmau1.isEmpty()) {
//            qlSanPhamPage = service.searchMau(tenmau1, pageable);
//        }else{
//            qlSanPhamPage=service.getListSP(pageable);
//        }
//
//        model.addAttribute("page", qlSanPhamPage);
//        model.addAttribute("searchForm", new SearchFormSP());
//
//        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
//        model.addAttribute("sanpham", new QLSanPham());
//        model.addAttribute("sortForm", new SortFormSP());
//        return "/admin/index";
//    }

    @RequestMapping("/quan-ly-san-pham/sort")
    public String sort(@ModelAttribute("sortForm") SortFormSP sortFormSP, @ModelAttribute("searchForm") SearchFormSP searchFormSP, @RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Sort sort;
        sort = sortFormSP.key.equals("dongia") ? Sort.by(Sort.Direction.DESC, "donGia") : Sort.by(Sort.Direction.DESC, "soLuong");
        Pageable pageable = PageRequest.of(p, 5, sort);
        Page<ChiTietSanPham> qlSanPhamPage = service.getListSP(pageable);
        model.addAttribute("page", qlSanPhamPage);

        System.out.println(sortFormSP.key);
        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("sanpham", new QLSanPham());
        return "/admin/index";
    }

    private String fileUpload = "C:\\Users\\Admin\\Desktop\\Da_Website_Sell_Sport_Shos\\src\\main\\resources\\static\\image\\";

    @RequestMapping("/quan-ly-san-pham/update/{id}")
    public String updateKC(Model model, @ModelAttribute("sanpham") QLSanPham qlSanPham, BindingResult result) throws IOException, WriterException {
        model.addAttribute("lg", new LoaiGiay());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("kichco", new KichCo());
        if (result.hasErrors()) {
            model.addAttribute("mess", "Lỗi! Vui lòng kiểm tra các trường trên !");
            model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
            return "/admin/index";
        }
        ChiTietSanPham ctsp = service.getOne(qlSanPham.getId());
        ctsp.loadFromViewModel(qlSanPham);
        MultipartFile multipartFile = qlSanPham.getHinhAnh();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(qlSanPham.getHinhAnh().getBytes(), new File(this.fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ctsp.setHinhAnh(fileName);
        service.addKC(ctsp);
        //generate code qr
        List<ChiTietSanPham> qlSanPhams = service.getList();
        if (qlSanPhams.size() != 0) {
            for (ChiTietSanPham ct : qlSanPhams
            ) {
                QRCodeGenerator.generatorQRCode(ct);
            }
        }
        return "redirect:/admin/quan-ly-san-pham";
    }

    @RequestMapping("/quan-ly-san-pham/view-update/{id}")
    public String viewUpdate(@PathVariable("id") UUID id, Model model) {
        ChiTietSanPham sp = service.getOne(id);
        model.addAttribute("lg", new LoaiGiay());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("action", "/quan-ly-san-pham/update/" + sp.getId());
        model.addAttribute("sanpham", sp);
        model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
        return "/admin/index";
    }


}
