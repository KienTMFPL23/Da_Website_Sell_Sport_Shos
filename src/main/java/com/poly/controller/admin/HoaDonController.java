package com.poly.controller.admin;

import com.poly.entity.HoaDon;


import com.poly.repository.HoaDonRepo;
import com.poly.service.HoaDonService;
import com.poly.service.Impl.HoaDonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping("hoa-don")
public class HoaDonController {
    @Autowired
    HoaDonRepo hdr;


    @GetMapping("hien-thi")
    public String hien_thi_giao_dien(@Param("maHD") String mahd,
                                     @Param("tenNguoiNhan") String ten,
                                     @Param("ngayDau") Date ngayTao,
                                     @Param("NgayKet") Date ngayKet

            , Model model, @RequestParam(defaultValue = "1") int page) {
        if (page < 1) {
            page = 1;
        }

        Pageable pageable = PageRequest.of(page - 1, 6);
        if (mahd == null || ten == null || ngayTao == null || ngayKet == null ) {

            Page<HoaDon> list = this.hdr.AllHoaDon(pageable);
            model.addAttribute("hd", list);
        } else {
            if (mahd != null) {

                HoaDon hd = this.hdr.searchtheoma(mahd);
                model.addAttribute("hd", hd);
            } else if (ten != null) {

                Page<HoaDon> pgg = this.hdr.searchtheoten(ten, pageable);
                model.addAttribute("hd", pgg);

            } else if (ngayKet != null || ngayTao != null  ){
                Page<HoaDon> pgg = this.hdr.searchtheongay(ngayTao,ngayKet, pageable);
                model.addAttribute("hd", pgg);
            }
            else if (ngayKet != null && ngayTao != null  ){
                Page<HoaDon> pgg = this.hdr.searchtheokhoangngay(ngayTao,ngayKet, pageable);
                model.addAttribute("hd", pgg);
            }
        }
        model.addAttribute("view", "../quan_li_hoa_don/index.jsp");
        return "admin/index";
    }
}
