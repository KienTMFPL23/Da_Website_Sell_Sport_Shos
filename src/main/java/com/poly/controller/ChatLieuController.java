package com.poly.controller;

import com.poly.entity.ChatLieu;
import com.poly.repository.ChatLieuRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("chat-lieu")
public class ChatLieuController {
    @Autowired
    private ChatLieuRepo chatLieuRepo;

    @GetMapping("hien-thi")
    public String index(@RequestParam(defaultValue = "0", name = "page")
                                Integer number, Model model) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<ChatLieu> listCL = this.chatLieuRepo.findAll(pageable);
        model.addAttribute("list", listCL);
        return "chat_lieu/index";
    }
}
