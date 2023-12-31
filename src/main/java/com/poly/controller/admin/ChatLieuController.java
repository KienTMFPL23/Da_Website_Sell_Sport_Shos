package com.poly.controller.admin;

import com.poly.entity.ChatLieu;
import com.poly.entity.MauSac;
import com.poly.entity.SanPham;
import com.poly.repository.ChatLieuRepo;
import com.poly.service.Impl.ChatLieuServiceImpl;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Autowired
    private ChatLieuServiceImpl clService;

    @Data
    public static class SearchForm {
        String keyword;
    }

    @GetMapping("hien-thi")
    public String index(@RequestParam(defaultValue = "0", name = "page") Integer page, Model model) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ChatLieu> list = this.chatLieuRepo.findAll(pageable);
        model.addAttribute("list", list);
        model.addAttribute("searchForm", new SearchForm());
        model.addAttribute("view", "../chat_lieu/list-chat-lieu.jsp");
        return "/admin/index";
    }


    @GetMapping("view-add")
    public String viewAdd(Model model, ChatLieu cl) {
        model.addAttribute("vm", cl);
        model.addAttribute("action", "/chat-lieu/add");
        model.addAttribute("view", "../chat_lieu/add_update.jsp");
        return "/admin/index";
    }

    @RequestMapping("add")
    public String store(Model model,
                        @Valid @ModelAttribute("vm") ChatLieu cl,
                        BindingResult result
    ) {
        Boolean hasError = result.hasErrors();
        ChatLieu product = clService.getOne(cl.getMa());
        if (product != null) {
            hasError = true;
            model.addAttribute("maspError", "Vui lòng không nhập trùng mã");
            model.addAttribute("view", "../chat_lieu/add_update.jsp");
            return "/admin/index";
        }
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "../chat_lieu/add_update.jsp");
            return "/admin/index";
        }
        this.chatLieuRepo.save(cl);
        model.addAttribute("view", "../chat_lieu/list-chat-lieu.jsp");
        model.addAttribute("searchForm", new SearchForm());
        return "redirect:/chat-lieu/hien-thi";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChatLieu cl, Model model) {
        model.addAttribute("vm", cl);
        model.addAttribute("action", "/chat-lieu/update/" + cl.getId());
        model.addAttribute("view", "../chat_lieu/add_update.jsp");
        return "/admin/index";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") UUID id, Model model,
                         @Valid @ModelAttribute("vm") ChatLieu cl,
                         BindingResult result
    ) {
        Boolean hasError = result.hasErrors();
        if (hasError) {
            // Báo lỗi
            model.addAttribute("view", "../chat_lieu/add_update.jsp");
            return "/admin/index";
        }

        this.chatLieuRepo.save(cl);
        model.addAttribute("view", "../chat_lieu/list-chat-lieu.jsp");
        model.addAttribute("searchForm", new SearchForm());
        return "redirect:/chat-lieu/hien-thi";
    }

    @GetMapping("search")
    public String search(Model model, @ModelAttribute("searchForm") SearchForm searchForm,
                         @RequestParam(defaultValue = "0", name = "page") Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        Page<ChatLieu> list = this.chatLieuRepo.search(searchForm.keyword, pageable);
        model.addAttribute("list", list);
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("view", "../chat_lieu/list-chat-lieu.jsp");
        return "/admin/index";
    }

    @GetMapping("sort")
    public String Sort(Model model, @ModelAttribute("searchForm") SearchForm searchForm,
                       @RequestParam(defaultValue = "0") Integer page) {
        Sort sort = Sort.by(Sort.Direction.ASC, "ten");
        Pageable pageable = PageRequest.of(page, 5, sort);
        Page<ChatLieu> list = chatLieuRepo.findAll(pageable);
        model.addAttribute("list", list);
        model.addAttribute("vm", new ChatLieu());
        model.addAttribute("view", "../chat_lieu/list-chat-lieu.jsp");
        return "/admin/index";
    }
}