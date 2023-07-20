package com.poly.controller.admin;

import com.poly.entity.HoaDon;
import com.poly.entity.HoaDonChiTiet;
import com.poly.entity.QLSanPham;
import com.poly.entity.SanPham;
import com.poly.service.ChiTietSPService;
import com.poly.service.HoaDonChiTietService;
import com.poly.service.HoaDonService;
import com.poly.service.SanPhamService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class BanHangController {

    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    HoaDonService hoaDonService;

    @Autowired
    HoaDonChiTietService hoaDonChiTietService;

    @Autowired
    ChiTietSPService ctspService;

    @Autowired
    HttpSession session;

    private UUID idHoaDon = null;
    private UUID idHoaDonCT = null;
    private List<HoaDonChiTiet> dsHoaDonCT = null;
    private Double sumMoney = 0.0;
    private Integer soLuongTon = 0;
    private QLSanPham ctsp = null;

    @Getter
    @Setter
    public static class SearchForm {
        String keyword = "";
    }


    @GetMapping("/ban-hang/counter")
    public String hienThi(Model model) {
        model.addAttribute("view", "../ban_hang_tai_quay/ban-hang.jsp");
        List<HoaDon> listHoaDon = hoaDonService.dsHoaDon();
        model.addAttribute("listSP", ctspService.getList());
        model.addAttribute("listHoaDon", hoaDonService.dsHoaDon());
        model.addAttribute("dsHoaDonCT", dsHoaDonCT);
        model.addAttribute("hoaDon", new HoaDon());
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("idHoaDon", idHoaDon);
        List<HoaDonChiTiet> list = hoaDonChiTietService.findAllById(idHoaDon);
        Double sum = hoaDonChiTietService.getTotal(list);
        model.addAttribute("sum",sum);
        return "admin/index";
    }

    private HoaDon CreateInvoice() {
        HoaDon hoaDon = new HoaDon();
        Random random = new Random();
        hoaDon.setMaHD("HD" + random.nextInt(999999));
        int sdt = random.nextInt(9999999);
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        hoaDon.setNgayTao(date);
        hoaDon.setSoDienThoai(String.valueOf(sdt));
        hoaDon.setTrangThai(0);
        return hoaDonService.saveHoaDon(hoaDon);
    }

    @RequestMapping("/ban-hang/createInvoice")
    public String themHoaDon(Model model) {
        model.addAttribute("view", "../ban_hang_tai_quay/ban-hang.jsp");
        this.CreateInvoice();
        return "redirect:/ban-hang/counter";
    }

    @RequestMapping("/ban-hang/remove/{Id}")
    public String removeHoaDon(Model model, @PathVariable("Id") UUID id) {
        model.addAttribute("view", "../ban_hang_tai_quay/ban-hang.jsp");
//        hoaDonChiTietService.removeByIdHOaDon(id);
        hoaDonService.removeHoaDon(id);
        return "redirect:/ban-hang/counter";
    }

    @RequestMapping("/ban-hang/hoadonchitiet/{Id}")
    public String hoaDonChiTiet(Model model, @PathVariable("Id") UUID id) {
        idHoaDon = id;
        model.addAttribute("id", idHoaDon);
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("view", "../ban_hang_tai_quay/ban-hang.jsp");
        idHoaDonCT = id;
        dsHoaDonCT = hoaDonChiTietService.findAllById(id);
        return "redirect:/ban-hang/counter";
    }

    @RequestMapping("/ban-hang/update-cart/{Id}")
    public String updateGioHang(Model model, @PathVariable("Id") UUID id, int soLuong) {
        model.addAttribute("view", "../ban_hang_tai_quay/ban-hang.jsp");
        List<HoaDonChiTiet> dsHDCT = hoaDonChiTietService.findALl();
        HoaDonChiTiet hoaDonChiTiet = hoaDonChiTietService.getOne(id);
//        Integer soLuongTon = ctspService.getSoLuongSP(id);
        if (hoaDonChiTiet != null) {
            hoaDonChiTiet.setSoLuong(soLuong);
            hoaDonChiTietService.saveHDCT(hoaDonChiTiet);
        }
        return "redirect:/ban-hang/hoadonchitiet/" + idHoaDonCT;
    }

    @RequestMapping("/ban-hang/removeHoaDonChiTiet/{Id}")
    public String removeHoaDonCT(Model model, @PathVariable("Id") UUID id) {
        model.addAttribute("view", "../ban_hang_tai_quay/ban-hang.jsp");
        HoaDonChiTiet hdct = hoaDonChiTietService.getOne(id);
        ctsp = ctspService.getOne(hdct.getQlSanPham().getId());
        hoaDonChiTietService.deleteHoaDonChiTiet(id);
        soLuongTon = ctsp.getSoLuong() + hdct.getSoLuong();
        ctsp.setSoLuong(soLuongTon);
        ctspService.updateCTSP(ctsp);
        return "redirect:/ban-hang/hoadonchitiet/" + idHoaDonCT;
    }

    @RequestMapping("/ban-hang/searchSanPham")
    public String searchSanPham(Model model, @ModelAttribute("searchForm") SearchForm searchForm) {
        model.addAttribute("view", "../ban_hang_tai_quay/ban-hang.jsp");

        QLSanPham sanPham = sanPhamService.findCTSPByKey("" + searchForm.keyword + "");
        HoaDon hoaDon = hoaDonService.findHoaDon(idHoaDon);
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        List<HoaDonChiTiet> listHoaDonCT = hoaDonChiTietService.findAllById(idHoaDon);
        if (sanPham != null) {
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setQlSanPham(sanPham);
            hoaDonChiTiet.setSoLuong(1);
            hoaDonChiTiet.setDonGia(sanPham.getDonGia());
            hoaDonChiTietService.saveHDCT(hoaDonChiTiet);
        }
        soLuongTon = sanPham.getSoLuong() - 1;
        sanPham.setSoLuong(soLuongTon);
        ctspService.updateCTSP(sanPham);
        return "redirect:/ban-hang/hoadonchitiet/" + idHoaDonCT;
    }

    @RequestMapping("/ban-hang/them-san-pham/{Id}")
    public String themSanPham(Model model, @PathVariable("Id") UUID id) {
        model.addAttribute("view", "../ban_hang_tai_quay/ban-hang.jsp");
        ctsp = ctspService.getOne(id);
        HoaDon hoaDon = hoaDonService.findHoaDon(idHoaDon);
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        if (ctsp != null) {
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setQlSanPham(ctsp);
            hoaDonChiTiet.setSoLuong(1);
            hoaDonChiTiet.setDonGia(ctsp.getDonGia());
            hoaDonChiTietService.saveHDCT(hoaDonChiTiet);
            soLuongTon = ctsp.getSoLuong() - 1;
            ctsp.setSoLuong(soLuongTon);
            ctspService.updateCTSP(ctsp);
        }

        return "redirect:/ban-hang/hoadonchitiet/" + idHoaDonCT;
    }

    @RequestMapping("/ban-hang/thanhtoan/{idHoaDon}")
    public String thanhToan(Model model, @PathVariable("idHoaDon") UUID id, @ModelAttribute("hoaDon") HoaDon hoaDon) {
        HoaDon hoaDonThanhToan = hoaDonService.findHoaDon(idHoaDon);
        if (hoaDonThanhToan != null) {
            long millis = System.currentTimeMillis();
            Date date = new Date(millis);
            hoaDonThanhToan.setNgayThanhToan(date);
            hoaDonThanhToan.setTenNguoiNhan(hoaDon.getTenNguoiNhan());
            hoaDonThanhToan.setTrangThai(1);
            hoaDonService.saveHoaDon(hoaDonThanhToan);
            this.sumMoney = 0.0;
            this.dsHoaDonCT = null;
        }
        return "redirect:/ban-hang/counter";
    }
}
