package com.poly.controller.admin;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.poly.entity.*;
import com.poly.service.ChiTietSPService;
import com.poly.service.HoaDonChiTietService;
import com.poly.service.HoaDonService;
import com.poly.service.Impl.NguoiDungServiceimpl;
import com.poly.service.SanPhamService;
import jakarta.servlet.http.HttpSession;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

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
    NguoiDungServiceimpl nguoiDungService;

    @Autowired
    HttpSession session;

    private UUID idHoaDon = null;
    private UUID idHoaDonCT = null;
    private List<HoaDonChiTiet> dsHoaDonCT = null;
    private Double sumMoney = 0.0;
    private Integer soLuongTon = 0;
    private ChiTietSanPham ctsp = null;
    private NguoiDung nguoiDung = null;
//    private List<ChiTietSanPham> listSanPhamCT = ctspService.getList();

    @Getter
    @Setter
    public static class SearchForm {
        String keyword = "";
    }


    @GetMapping("/ban-hang/counter")
    public String hienThi(Model model) {
        model.addAttribute("view", "../ban_hang_tai_quay/ban-hang.jsp");
        this.getTaiKhoan(model);
        List<HoaDon> listHoaDon = hoaDonService.dsHoaDon();
        model.addAttribute("listKhachHang", nguoiDungService.findAllKhachHang());
        model.addAttribute("listSP", ctspService.getList());
        model.addAttribute("filterCTSP", new ChiTietSanPham());
        model.addAttribute("listHoaDon", hoaDonService.dsHoaDon());
        model.addAttribute("dsHoaDonCT", dsHoaDonCT);
        model.addAttribute("hoaDon", new HoaDon());
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("idHoaDon", idHoaDon);
        List<HoaDonChiTiet> list = hoaDonChiTietService.findAllById(idHoaDon);
        sumMoney = hoaDonChiTietService.getTotal(list);
        model.addAttribute("sum", this.sumMoney);
        return "admin/index";
    }

    private HoaDon CreateInvoice() {
        HoaDon hoaDon = new HoaDon();
        Random random = new Random();
        hoaDon.setMaHD("HD" + random.nextInt(999999));
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        hoaDon.setNgayTao(date);
        hoaDon.setTrangThai(0);
        return hoaDonService.saveHoaDon(hoaDon);
    }

    private void getTaiKhoan(Model model) {
        TaiKhoan taiKhoan = (TaiKhoan) session.getAttribute("userLogged");
        nguoiDung = nguoiDungService.findById(taiKhoan.getId());
        model.addAttribute("username", taiKhoan.getUsername());
        String fullname = nguoiDung.getHo() + " " + nguoiDung.getTendem() + " " + nguoiDung.getTen();
        model.addAttribute("fullNameStaff", fullname);
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
            hoaDonChiTietService.updateHDCT(hoaDonChiTiet);
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

        ChiTietSanPham sanPham = sanPhamService.findCTSPByKey("" + searchForm.keyword + "");
        HoaDon hoaDon = hoaDonService.findHoaDon(idHoaDon);
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        if (sanPham != null) {
            hoaDonChiTiet.setHoaDon(hoaDon);
            hoaDonChiTiet.setQlSanPham(sanPham);
            hoaDonChiTiet.setSoLuong(1);
            hoaDonChiTiet.setDonGia(sanPham.getDonGia());
            hoaDonChiTietService.saveHDCT(hoaDonChiTiet, sanPham.getId(),this.idHoaDon);
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
            hoaDonChiTietService.saveHDCT(hoaDonChiTiet, ctsp.getId(),this.idHoaDon);
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
            hoaDonThanhToan.setNguoiDung(nguoiDung);
            hoaDonThanhToan.setTrangThai(1);
            hoaDonService.saveHoaDon(hoaDonThanhToan);
            this.dsHoaDonCT = null;
            this.idHoaDon = null;
        }
        return "redirect:/ban-hang/counter";
    }

    @GetMapping("/ban-hang/filter-by-name")
    public String filterSanPhamByName(Model model) {
        model.addAttribute("filter", "/ban-hang/filter-by-name");
        List<ChiTietSanPham> listSanPhamCT = ctspService.getList();
        List<ChiTietSanPham> filterByName = listSanPhamCT.stream()
                .filter(ctsp -> Boolean.parseBoolean(ctsp.getSanPham().getTenSP()))
                .collect(Collectors.toList());
        model.addAttribute("filter", filterByName);
        return "redirect:/ban-hang/counter";
    }

    @RequestMapping("/ban-hang/create-invoice")
    public String createInvoice() throws FileNotFoundException {
        String path = "invoice.pdf";
        PdfWriter pdfWriter = new PdfWriter(path);
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A5);
        Document document = new Document(pdfDocument);
        float twocol = 285f;
        float twocol150 = twocol + 150f;
        float twoColumnWith[] = {twocol150, twocol};

        Table table = new Table(twoColumnWith);
        table.addCell(new Cell().add("Hóa đơn mua hàng"));


        document.add(new Paragraph("Hóa đơn mua hàng"));

        document.close();
        return "redirect:/ban-hang/counter";
    }

    @RequestMapping("/ban-hang/scan-qr")
    public String ScanQrCode(Model model, @RequestParam("idCTSP") UUID id) {
        model.addAttribute("view", "../ban_hang_tai_quay/ban-hang.jsp");
        ctsp = ctspService.getOne(id);
        HoaDon hoaDon = hoaDonService.findHoaDon(idHoaDon);
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        System.out.println("hello");
        soLuongTon = ctsp.getSoLuong() - 1;
        ctsp.setSoLuong(soLuongTon);
        ctspService.updateCTSP(ctsp);
        return "redirect:/ban-hang/counter";
    }
}
