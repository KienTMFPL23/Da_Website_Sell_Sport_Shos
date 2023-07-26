//package com.poly.controller.admin;
//
//import com.poly.repository.HoaDonChiTietRepo;
//import com.poly.repository.NguoiDungReponsitory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//public class ChiTietHoaDonController {
//
//    @Autowired
//    private HoaDonChiTietRepo hdctRepo;
//
//    @Autowired
//    private NguoiDungReponsitory nguoiDungRepo;
//
//    @RequestMapping("/hoa-don-chi-tiet/hien-thi")
//    public String hienThiChiTiet(Model model) {
////        model.addAttribute("listHDCT", this.hdctRepo.findAll());
//        model.addAttribute("listKH", this.nguoiDungRepo.findAll());
//        model.addAttribute("view", "../chi_tiet_hd/chi_tiet_hoa_don.jsp");
//        return "admin/index";
//    }
//}
