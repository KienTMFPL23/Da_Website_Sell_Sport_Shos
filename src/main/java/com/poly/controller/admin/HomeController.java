package com.poly.controller.admin;

import com.poly.entity.ChiTietSanPham;
import com.poly.entity.TaiKhoan;
import com.poly.repository.ChiTietSanPhamRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class HomeController {

    @Autowired
    private ChiTietSanPhamRepo chiTietSanPhamRepo;


    @RequestMapping("/optimus/home")
    public String index(Model model, @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize,
                        @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum) {

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<ChiTietSanPham> page = chiTietSanPhamRepo.findAll(pageable);


        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listHome", page.getContent());

        model.addAttribute("listSP",  chiTietSanPhamRepo.findAll());
        return "home/index";
    }



    @RequestMapping("/home/detail/{id}")
    public String detail(Model model, @PathVariable(name= "id") UUID id) {

        model.addAttribute("spDetail", chiTietSanPhamRepo.findById(id).orElse(null));
        return "home/single";
    }

    @RequestMapping("/home/category")
    public String category(Model model, @RequestParam(name = "pageSize", defaultValue = "8") Integer pageSize,
                           @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum) {

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<ChiTietSanPham> page = chiTietSanPhamRepo.findAll(pageable);

        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listHome", page.getContent());

        return "home/category";
    }

    @RequestMapping("/home/cart")
    public String cart() {
        return "home/cart";
    }

    @RequestMapping("/addtocart")
    public String addToCart(Model model,
//                            @PathVariable(name="productId")UUID productId,
                            HttpSession session) {

//        ChiTietSanPham ctsp = chiTietSanPhamRepo.findById(productId).orElse(null);

        TaiKhoan taikhoan = (TaiKhoan) session.getAttribute("userLogged");
        if (taikhoan == null) {
            return "redirect:/login";
        }
        return "home/cart";
    }

}
