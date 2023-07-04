package com.poly.controller.admin;

import com.poly.entity.DeGiay;
import com.poly.repository.ChatLieuRepo;
import com.poly.repository.DeGiayRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
public class DeGiayController {

    @Autowired
    private DeGiayRepo deGiayRepo;

    @ModelAttribute("dsTrangThai")
    public Map<Integer, String> getDsTrangThai() {
        Map<Integer, String> dsTrangThai = new HashMap<>();
        dsTrangThai.put(1, "Hết hàng");
        dsTrangThai.put(0, "Còn hàng");
        return dsTrangThai;
    }

    @RequestMapping("/de-giay/hien-thi")
    public String hienthi(Model model, @ModelAttribute("degiay") DeGiay degiay, @RequestParam(defaultValue = "0") int p){
        List<DeGiay> listDe = deGiayRepo.findAll();
        Pageable pageable = PageRequest.of(p, 5);
        Page<DeGiay> page = deGiayRepo.findAll(pageable);
        model.addAttribute("page", page);
        return "/degiay/list";
    }

    @RequestMapping("/de-giay/sort")
    public <SearchForm> String Sort( @RequestParam(defaultValue = "0") int p, Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "loaide");
        Pageable pageable = PageRequest.of(p, 5,sort);
        Page<DeGiay> page = deGiayRepo.findAll(pageable);
        model.addAttribute("page", page);

        return "/degiay/list";
    }

    @GetMapping("/de-giay/view-add")
    public String viewAdd(Model model, @ModelAttribute("degiay") DeGiay degiay){
        model.addAttribute("action", "/de-giay/add");
        return "/degiay/add";
    }

    @PostMapping("/de-giay/add")
    public String add(Model model, @Valid @ModelAttribute("degiay") DeGiay degiay, BindingResult result){


        if (result.hasErrors()) {
            return "/degiay/add";
        }

        if (deGiayRepo.findByMa(degiay.getMa()) != null){
            model.addAttribute("mess_Ma", "Lỗi! Mã không được trùng");
            return "/degiay/add";
        }

        deGiayRepo.save(degiay);
        return "redirect:/de-giay/hien-thi";
    }

    @GetMapping("/de-giay/view-update/{id}")
    public String viewUpdate(Model model, @PathVariable(name="id") UUID id){

        DeGiay deGiay = deGiayRepo.findById(id).orElse(null);
        model.addAttribute("degiay", deGiay);
        model.addAttribute("action", "/de-giay/update/" +deGiay.getId());
        return "/degiay/add";
    }

    @PostMapping("/de-giay/update/{id}")
    public String update(Model model,@Valid @ModelAttribute("degiay") DeGiay degiay, BindingResult result){
        if (result.hasErrors()) {
            return "/degiay/add";
        }
        if (deGiayRepo.findByMa(degiay.getMa()) != null){
            model.addAttribute("mess_Ma", "Lỗi! Mã không được trùng");
            return "/degiay/add";
        }
        deGiayRepo.save(degiay);
        return "redirect:/de-giay/hien-thi";
    }

    @GetMapping("/admin")
    public String admin(){
        return "/degiay/admin";
    }

    @PostMapping("/de-giay/search")
    public String search(Model model, @RequestParam(name = "keyword") String keyword) {
        model.addAttribute("search", deGiayRepo.searchByMaAndLoaiDe(keyword));
        return "/degiay/search";
    }
}
