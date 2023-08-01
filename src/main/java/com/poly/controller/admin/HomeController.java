package com.poly.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {



    @RequestMapping("/optimus/home")
    public String index(Model model){
        return "home/index";
    }

    @RequestMapping("/home/detail")
    public String detail(){
        return "home/single";
    }

    @RequestMapping("/home/category")
    public String category(){
        return "home/category";
    }

    @RequestMapping("/home/cart")
    public String cart() {
        return "home/cart";
    }


}
