package com.poly.controller.admin;

import com.poly.entity.NguoiDung;
import com.poly.repository.NguoiDungReponsitory;
import com.poly.repository.TaiKhoanRepo;
import com.poly.service.Impl.NguoiDungServiceimpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("nguoi-dung")
public class NguoiDungController {
    @Autowired
    private NguoiDungReponsitory ngr;
    @Autowired
    private TaiKhoanRepo tkr;
    @Autowired
    private NguoiDungServiceimpl nds;

    @GetMapping("hien-thi/khach-hang")

    public String hien(@Param("key") String key, Model model, @RequestParam(defaultValue = "1") int page) {


        if (page < 1) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page - 1, 6);
        Page<NguoiDung> pgg = this.nds.searchkh(key, pageable);
        model.addAttribute("list", pgg);
//        return "nguoi_dung/index";
        model.addAttribute("view", "../nguoi_dung/index.jsp");
        return "/admin/index";
    }

    @GetMapping("hien-thi/nhan-vien")

    public String hien1(@Param("key") String key, Model model, @RequestParam(defaultValue = "1") int page) {


        if (page < 1) {
            page = 1;
        }
        Pageable pageable = PageRequest.of(page - 1, 6);
        Page<NguoiDung> pgg = this.nds.searchnv(key, pageable);
        model.addAttribute("list1", pgg);
//        return "nguoi_dung/index1";
        model.addAttribute("view", "../nguoi_dung/index1.jsp");
        return "/admin/index";
    }

    //
    @GetMapping("view/update/{id}")
    public String viewupdate(@PathVariable("id") UUID id, @ModelAttribute("nd") NguoiDung nguoiDung, Model model) {
        NguoiDung nd = ngr.findById(id).orElse(null);
        model.addAttribute("nd", nd);
        model.addAttribute("listTK", this.tkr.findAll());

        model.addAttribute("view", "../nguoi_dung/update.jsp");
        return "/admin/index";
    }

    @GetMapping("view/update1/{id}")
    public String viewupdate1(@PathVariable("id") UUID id, @ModelAttribute("nd") NguoiDung nguoiDung, Model model) {
        NguoiDung nd = ngr.findById(id).orElse(null);
        model.addAttribute("nd", nd);
        model.addAttribute("listTK", this.tkr.findAll());
        model.addAttribute("view", "../nguoi_dung/update1.jsp");
        return "/admin/index";
    }


    @PostMapping("update")
    public String update(@Valid @ModelAttribute("nd") NguoiDung nguoiDung, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "../nguoi_dung/update1.jsp");
            return "/admin/index";
        } else {


            this.ngr.save(nguoiDung);
        }
        return "redirect:/nguoi-dung/hien-thi/nhan-vien";
    }

    @PostMapping("update1")
    public String update1(@Valid @ModelAttribute("nd") NguoiDung nguoiDung, BindingResult result,Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "../nguoi_dung/update.jsp");
            return "/admin/index";
        } else {


            this.ngr.save(nguoiDung);
        }
        return "redirect:/nguoi-dung/hien-thi/khach-hang";
    }
}
