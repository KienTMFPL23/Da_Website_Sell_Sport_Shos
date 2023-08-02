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
    }

    @Data
    public static class SearchFormSPByMau {
        UUID idMau;
    }

    @Data
    public static class SearchDeGiay {
        UUID idDe;
    }

    @Data
    public static class SearchKC {
        UUID idKC;
    }
 @Data
    public static class SearchLoaiGiay {
        UUID idLG;
    }

    @Data
    public static class SearchChatlieu {
        UUID idChatLieu;
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
        model.addAttribute("searchChatLieu", new SearchChatlieu());
        model.addAttribute("lg", new SearchLoaiGiay());

        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("searchForm", new SearchFormSP());
        model.addAttribute("searchFormByMau", new SearchFormSPByMau());
        model.addAttribute("searchKC", new SearchKC());
        model.addAttribute("searchDG", new SearchDeGiay());

        return "/admin/index";
    }

    @RequestMapping("/quan-ly-san-pham/search")
    public String searchSP(@ModelAttribute("searchForm") SearchFormSP searchFormSP, @RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Page<ChiTietSanPham> qlSanPhamPage;
        Pageable pageable = PageRequest.of(p, 5);
        if (searchFormSP.keyword != null && !searchFormSP.keyword.equals("")) {
            qlSanPhamPage = service.searchCTSP(searchFormSP.keyword, pageable);
        } else {
            qlSanPhamPage = service.getListSP(pageable);
        }
        model.addAttribute("lg", new SearchLoaiGiay());

        model.addAttribute("searchDG", new SearchDeGiay());
        model.addAttribute("searchChatLieu", new SearchChatlieu());
        model.addAttribute("searchKC", new SearchKC());
        model.addAttribute("searchFormByMau", new SearchFormSPByMau());
        model.addAttribute("page", qlSanPhamPage);
        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("sanpham", new QLSanPham());
        model.addAttribute("sortForm", new SortFormSP());
        return "/admin/index";
    }

    // filer with combobox mau-sac
    @RequestMapping("/quan-ly-san-pham/search-by-mausac")
    public String searchByMau(@ModelAttribute("searchFormByMau") SearchFormSPByMau searchFormSPByMau, @RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Page<ChiTietSanPham> qlSanPhamPage;
        Pageable pageable = PageRequest.of(p, 5);
        if (searchFormSPByMau.idMau != null && !searchFormSPByMau.idMau.equals("")) {
            qlSanPhamPage = service.searchByMau(searchFormSPByMau.idMau, pageable);
        } else {
            qlSanPhamPage = service.getListSP(pageable);
        }
        model.addAttribute("lg", new SearchLoaiGiay());

        model.addAttribute("searchDG", new SearchDeGiay());
        model.addAttribute("searchChatLieu", new SearchChatlieu());
        model.addAttribute("page", qlSanPhamPage);
        model.addAttribute("searchForm", new SearchFormSP());
        model.addAttribute("searchKC", new SearchKC());
        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("sanpham", new QLSanPham());
        model.addAttribute("sortForm", new SortFormSP());
        return "/admin/index";
    }

    // filer with combobox kich co
    @RequestMapping("/quan-ly-san-pham/search-by-kichco")
    public String searchByKC(@ModelAttribute("searchKC") SearchKC searchKC, @RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Page<ChiTietSanPham> qlSanPhamPage;
        Pageable pageable = PageRequest.of(p, 5);
        if (searchKC.idKC != null && !searchKC.idKC.equals("")) {
            qlSanPhamPage = service.searchKichCo(searchKC.idKC, pageable);
        } else {
            qlSanPhamPage = service.getListSP(pageable);
        }
        model.addAttribute("lg", new SearchLoaiGiay());

        model.addAttribute("searchChatLieu", new SearchChatlieu());
        model.addAttribute("searchFormByMau", new SearchFormSPByMau());
        model.addAttribute("page", qlSanPhamPage);
        model.addAttribute("searchForm", new SearchFormSP());
        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("sanpham", new QLSanPham());
        model.addAttribute("searchDG", new SearchDeGiay());
        model.addAttribute("sortForm", new SortFormSP());
        return "/admin/index";
    }

    // filer with combobox de giay
    @RequestMapping("/quan-ly-san-pham/search-by-degiay")
    public String searchByDeGiay(@ModelAttribute("searchDG") SearchDeGiay searchDeGiay, @RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Page<ChiTietSanPham> qlSanPhamPage;
        Pageable pageable = PageRequest.of(p, 5);
        if (searchDeGiay.idDe != null && !searchDeGiay.idDe.equals("")) {
            qlSanPhamPage = service.searchDeGiay(searchDeGiay.idDe, pageable);
        } else {
            qlSanPhamPage = service.getListSP(pageable);
        }
        model.addAttribute("lg", new SearchLoaiGiay());

        model.addAttribute("searchKC", new SearchKC());
        model.addAttribute("searchChatLieu", new SearchChatlieu());
        model.addAttribute("searchFormByMau", new SearchFormSPByMau());
        model.addAttribute("page", qlSanPhamPage);
        model.addAttribute("searchForm", new SearchFormSP());
        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("sanpham", new QLSanPham());
        model.addAttribute("sortForm", new SortFormSP());
        return "/admin/index";
    }

    // filer with combobox chat lieu
    @RequestMapping("/quan-ly-san-pham/search-by-chatlieu")
    public String searchByChatLieu(@ModelAttribute("searchChatLieu") SearchChatlieu searchChatlieu, @RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Page<ChiTietSanPham> qlSanPhamPage;
        Pageable pageable = PageRequest.of(p, 5);
        if (searchChatlieu.idChatLieu != null && !searchChatlieu.idChatLieu.equals("")) {
            qlSanPhamPage = service.searchCL(searchChatlieu.idChatLieu, pageable);
        } else {
            qlSanPhamPage = service.getListSP(pageable);
        }
        model.addAttribute("searchKC", new SearchKC());
        model.addAttribute("searchDG", new SearchDeGiay());
        model.addAttribute("lg", new SearchLoaiGiay());

        model.addAttribute("searchFormByMau", new SearchFormSPByMau());
        model.addAttribute("page", qlSanPhamPage);
        model.addAttribute("searchForm", new SearchFormSP());
        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("sanpham", new QLSanPham());
        model.addAttribute("sortForm", new SortFormSP());
        return "/admin/index";
    }
  // filer with combobox loai giay
    @RequestMapping("/quan-ly-san-pham/search-by-loaigiay")
    public String searchByLoaiGiay(@ModelAttribute("lg") SearchLoaiGiay searchLoaiGiay, @RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Page<ChiTietSanPham> qlSanPhamPage;
        Pageable pageable = PageRequest.of(p, 5);
        if (searchLoaiGiay.idLG != null && !searchLoaiGiay.idLG.equals("")) {
            qlSanPhamPage = service.searchLoaiGiay(searchLoaiGiay.idLG, pageable);
        } else {
            qlSanPhamPage = service.getListSP(pageable);
        }
        model.addAttribute("searchKC", new SearchKC());
        model.addAttribute("searchDG", new SearchDeGiay());
        model.addAttribute("searchChatLieu", new SearchChatlieu());
        model.addAttribute("searchFormByMau", new SearchFormSPByMau());
        model.addAttribute("page", qlSanPhamPage);
        model.addAttribute("searchForm", new SearchFormSP());
        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("sanpham", new QLSanPham());
        model.addAttribute("sortForm", new SortFormSP());
        return "/admin/index";
    }

    @RequestMapping("/quan-ly-san-pham/sort")
    public String sort(@ModelAttribute("sortForm") SortFormSP sortFormSP, @ModelAttribute("searchForm") SearchFormSP searchFormSP, @RequestParam(defaultValue = "0") int p, Model model) {
        if (p < 0) {
            p = 0;
        }
        Sort sort;
        model.addAttribute("searchDG", new SearchDeGiay());
        model.addAttribute("searchChatLieu", new SearchChatlieu());
        model.addAttribute("searchKC", new SearchKC());
        model.addAttribute("lg", new SearchLoaiGiay());

        model.addAttribute("searchFormByMau", new SearchFormSPByMau());
        sort = sortFormSP.key.equals("dongia") ? Sort.by(Sort.Direction.DESC, "donGia") : Sort.by(Sort.Direction.DESC, "soLuong");
        Pageable pageable = PageRequest.of(p, 5, sort);
        Page<ChiTietSanPham> qlSanPhamPage = service.getListSP(pageable);
        model.addAttribute("page", qlSanPhamPage);

        System.out.println(sortFormSP.key);
        model.addAttribute("view", "../quan-ly-san-pham/list-san-pham.jsp");
        model.addAttribute("sanpham", new QLSanPham());
        return "/admin/index";
    }

    private String fileUpload = "C:\\Users\\NamNguyenTien\\Desktop\\Da_Website_Sell_Sport_Shos\\src\\main\\resources\\static\\image\\";

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
        String documentsPath = System.getProperty("user.home") + File.separator + "Documents";
        String qrCodeFolderPath = documentsPath + File.separator + "QRCode";
        new File(qrCodeFolderPath).mkdirs(); // Tạo thư mục "QRCode" nếu chưa tồn tại

        // Lưu QR code vào thư mục "QRCode" trong "Documents"
        QRCodeGenerator.generatorQRCode(ctsp, qrCodeFolderPath);

        //generate code qr
//        List<ChiTietSanPham> qlSanPhams = service.getList();
//        if (qlSanPhams.size() != 0) {
//            for (ChiTietSanPham ct : qlSanPhams
//            ) {
//                QRCodeGenerator.generatorQRCode(ct);
//            }
//        }
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
