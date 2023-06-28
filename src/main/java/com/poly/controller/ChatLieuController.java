package com.poly.controller;

import com.poly.entity.ChatLieu;
import com.poly.repository.ChatLieuRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("chat-lieu")
public class ChatLieuController {
    @Autowired
    private ChatLieuRepo chatLieuRepo;

    @GetMapping("hien-thi")
    public String index(@RequestParam(defaultValue = "0",name = "page")Integer number, Model model){
        Pageable pageable = PageRequest.of(number,5);
        Page<ChatLieu> list = this.chatLieuRepo.findAll(pageable);
        model.addAttribute("list", list);
        return "chat_lieu/list-chat-lieu";
    }

    @GetMapping("view-add")
    public String viewAdd(Model model, ChatLieu cl){
        model.addAttribute("vm",cl);
        model.addAttribute("action" , "/chat-lieu/add");
        return "chat_lieu/add_update";
    }

    @PostMapping("add")
    public String store(Model model,
            @Valid @ModelAttribute("vm") ChatLieu cl,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            // Báo lỗi
            return "chat_lieu/add_update";
        } else {

            this.chatLieuRepo.save(cl);
        }
        return "redirect:/chat-lieu/hien-thi";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChatLieu cl, Model model)
    {

        model.addAttribute("vm", cl);
        model.addAttribute("action", "/chat-lieu/update/" + cl.getId());
        return "chat_lieu/add_update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") UUID id, Model model,
                         @Valid @ModelAttribute("vm") ChatLieu cl,
                         BindingResult result
    ) {
        if (result.hasErrors()) {
            // Báo lỗi
            return "chat_lieu/add_update";
        } else {

            this.chatLieuRepo.save(cl);
        }
        return "redirect:/chat-lieu/hien-thi";
    }

    @GetMapping("search/{ten}")
    public String search(@PathVariable("ten")
                             @ModelAttribute("vm") ChatLieu cl,
                         @RequestParam(defaultValue = "0") Integer number, Model model,
                         @RequestParam("ten") String ten) {
        Pageable pageable = PageRequest.of(number, 3);
        Page<ChatLieu> list = chatLieuRepo.searchTen(ten, pageable);
        model.addAttribute("list", list);
        return "chat_lieu/list-chat-lieu";
    }
}
