package com.poly.controller.admin;

import com.google.zxing.WriterException;
import com.poly.entity.*;
import com.poly.repository.*;
import com.poly.service.ChatLieuService;
import com.poly.service.ChiTietSPService;
import com.poly.service.KichCoService;
import com.poly.service.SanPhamService;
import com.poly.utils.QRCodeGenerator;
import jakarta.servlet.annotation.MultipartConfig;
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
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import java.util.*;

@Controller
@MultipartConfig
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

    @ModelAttribute("dsGioiTinh")
    public Map<Boolean, String> getDsGioiTinh() {
        Map<Boolean, String> dsGT = new HashMap<>();
        dsGT.put(true, "Nam");
        dsGT.put(false, "Nữ");
        return dsGT;
    }

    @Getter
    @Setter
    public static class SearchForm {
        String keyword = "";
    }

    private String fileUpload = "C:\\Users\\Admin\\Desktop\\Da_Website_Sell_Sport_Shos\\src\\main\\resources\\static\\image\\";

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
        Pageable pageable = PageRequest.of(p, 5, sort);
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
        model.addAttribute("SP",product);
        SanPham sp = sanPhamService.getOne(id);
        String tensp = sp.getTenSP();
        model.addAttribute("tensp", tensp);
        return "admin/index";
    }

    @PostMapping("/san-pham/add")
    public String add(Model model, @Valid @ModelAttribute("SP") SanPham sanPham, BindingResult result) {
        Boolean hasError = result.hasErrors();
        SanPham product = sanPhamService.getSP(sanPham.getMaSP());
        if (sanPham.getMaSP().trim().length() < 5) {
            hasError = true;
            model.addAttribute("erorLenghMa", "Mã sản phẩm phải lớn hơn hoặc bằng 5");
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
        if (sanPham.getMaSP().trim().length() < 5) {
            hasError = true;
            model.addAttribute("erorLenghMa", "Mã sản phẩm phải lớn hơn hoặc bằng 5");
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
        model.addAttribute("tensp", sp.getTenSP());
        sanPhamService.update(sp);
        return "redirect:/san-pham/hien-thi";
    }

    //view-add chi tiết sản phẩm

    @RequestMapping("/quan-ly-san-pham/view-add/{id}")
    public String viewAdd(@ModelAttribute("sanpham") QLSanPham sp, @PathVariable("id") UUID id, Model model) {
        model.addAttribute("lg", new LoaiGiay());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("ms", new MauSac());
        SanPham sanPham1 = sanPhamService.getOne(id);
        model.addAttribute("tensp", sanPham1.getTenSP());
        model.addAttribute("action", "/quan-ly-san-pham/add/" + sanPham1.getId());
        model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
        return "/admin/index";
    }

    // add ctsp
    @PostMapping("/quan-ly-san-pham/add/{id}")
    public String AddSanPham(Model model, @PathVariable("id") UUID id, @ModelAttribute("sanpham") QLSanPham sp

            , BindingResult result) throws WriterException, IOException {
        SanPham sanPham1 = sanPhamService.getOne(id);
        sp.setSanPham(sanPham1);

        ChiTietSanPham ctsp = new ChiTietSanPham();
        ctsp.loadFromViewModel(sp);
        MultipartFile multipartFile = sp.getHinhAnh();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(sp.getHinhAnh().getBytes(), new File(this.fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ctsp.setHinhAnh(fileName);
        //
        model.addAttribute("lg", new LoaiGiay());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("vm", new ChatLieu());

        model.addAttribute("ms", new MauSac());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("tensp", sanPham1.getTenSP());
        service.addKC(ctsp);

        //generate code qr
        String documentsPath = System.getProperty("user.home") + File.separator + "Documents";
        String qrCodeFolderPath = documentsPath + File.separator + "QRCode";
        new File(qrCodeFolderPath).mkdirs(); // Tạo thư mục "QRCode" nếu chưa tồn tại

        // Lưu QR code vào thư mục "QRCode" trong "Documents"
        QRCodeGenerator.generatorQRCode(ctsp, qrCodeFolderPath);
//        List<ChiTietSanPham> qlSanPhams = service.getList();
//        if (qlSanPhams.size() != 0) {
//            for (ChiTietSanPham ct : qlSanPhams
//            ) {
//                QRCodeGenerator.generatorQRCode(ct);
//            }
//        }
        return "redirect:/admin/quan-ly-san-pham";
    }

    //add modal loai giay
    @RequestMapping("/san-pham/loai-giay/add/{id}")
    public String save(Model model, @ModelAttribute("lg") LoaiGiay loaiGiay, @PathVariable("id") UUID id, BindingResult result) {
        Boolean hasE = result.hasErrors();
        List<LoaiGiay> list = loaiGiayRepo.findAll();
        SanPham sanPham1 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham1.getId());
        model.addAttribute("tensp", sanPham1.getTenSP());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("kichco", new KichCo());
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

            model.addAttribute("sanpham", new QLSanPham());
            model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
            return "/quan-ly-san-pham/view-add/" + sanPham1.getId();
        }
        loaiGiay.setTrangthai(1);
        loaiGiayRepo.save(loaiGiay);
        model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
        return "redirect:/quan-ly-san-pham/view-add/" + sanPham1.getId();
    }

    @RequestMapping("/san-pham/kich-co/add/{id}")
    public String addKC(Model model, @PathVariable("id") UUID id, @Valid @ModelAttribute("kichco") KichCo kichCo, BindingResult resultt) {
        SanPham sanPham2 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham2.getId());
        model.addAttribute("tensp", sanPham2.getTenSP());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("lg", new LoaiGiay());
        if (resultt.hasErrors()) {
            model.addAttribute("sanpham", new QLSanPham());
            model.addAttribute("mess", "Lỗi! Vui lòng kiểm tra các trường trên !");
            model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
            return "/quan-ly-san-pham/view-add/" + sanPham2.getId();
        }
        if (kichCo.getMaKichCo() != null) {
            model.addAttribute("sanpham", new QLSanPham());
            model.addAttribute("messMa", "Lỗi! Vui lòng kiểm tra mã không được trùng !");
            model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
            return "/quan-ly-san-pham/view-add/" + sanPham2.getId();
        }
        kichCoService.addKC(kichCo);
        model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
        return "redirect:/quan-ly-san-pham/view-add/" + sanPham2.getId();
    }

    @PostMapping("/san-pham/mau-sac/add/{id}")
    public String add(@Valid @ModelAttribute("ms") MauSac ms, @PathVariable("id") UUID id, BindingResult result, Model model) {
        SanPham sanPham2 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham2.getId());
        model.addAttribute("tensp", sanPham2.getTenSP());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("lg", new LoaiGiay());
        if (result.hasErrors()) {
            return "redirect:/quan-ly-san-pham/view-add/" + sanPham2.getId();
        } else {
            this.mauSacReponsitories.save(ms);
        }
        model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
        return "redirect:/quan-ly-san-pham/view-add/" + sanPham2.getId();
    }

    @Autowired
    ChatLieuService chatLieuService;

    @RequestMapping("/san-pham/chat-lieu/add/{id}")
    public String store(Model model, @PathVariable("id") UUID id,
                        @Valid @ModelAttribute("vm") ChatLieu cl,
                        BindingResult result
    ) {
        SanPham sanPham2 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham2.getId());
        model.addAttribute("tensp", sanPham2.getTenSP());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("degiay", new DeGiay());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("lg", new LoaiGiay());
        Boolean hasError = result.hasErrors();
        ChatLieu product = chatLieuService.getOne(cl.getMa());
        if (product != null) {
            hasError = true;
            model.addAttribute("maspError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
            return "redirect:/quan-ly-san-pham/view-add/" + sanPham2.getId();
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
            return "redirect:/quan-ly-san-pham/view-add/" + sanPham2.getId();
        }
        this.chatLieuRepo.save(cl);
        model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
        return "redirect:/quan-ly-san-pham/view-add/" + sanPham2.getId();
    }

    @PostMapping("/san-pham/de-giay/add/{id}")
    public String add(Model model, @PathVariable("id") UUID id, @Valid @ModelAttribute("degiay") DeGiay degiay, BindingResult result) {
        SanPham sanPham2 = sanPhamService.getOne(id);
        model.addAttribute("idsp", sanPham2.getId());
        model.addAttribute("tensp", sanPham2.getTenSP());
        model.addAttribute("ms", new MauSac());
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("kichco", new KichCo());
        model.addAttribute("lg", new LoaiGiay());
        if (result.hasErrors()) {
            model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
            return "redirect:/quan-ly-san-pham/view-add/" + sanPham2.getId();
        }

        if (deGiayRepo.findByMa(degiay.getMa()) != null) {
            model.addAttribute("mess_Ma", "Lỗi! Mã không được trùng");
            model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
            return "redirect:/quan-ly-san-pham/view-add/" + sanPham2.getId();
        }

        deGiayRepo.save(degiay);
        model.addAttribute("view", "../quan-ly-san-pham/index.jsp");
        return "redirect:/quan-ly-san-pham/view-add/" + sanPham2.getId();
    }
}
