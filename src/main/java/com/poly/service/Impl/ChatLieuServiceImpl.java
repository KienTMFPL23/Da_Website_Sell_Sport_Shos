package com.poly.service.Impl;


import com.poly.entity.ChatLieu;
import com.poly.entity.MauSac;
import com.poly.entity.SanPham;
import com.poly.repository.ChatLieuRepo;
import com.poly.repository.MauSacReponsitories;
import com.poly.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ChatLieuServiceImpl implements ChatLieuService {
    @Autowired
    ChatLieuRepo clRepo;
    public Page<ChatLieu> search(String key, Pageable pageable){
        if(key != null){
            return clRepo.search(key, pageable);
        }
        return clRepo.findAll(pageable);
    }

    public ChatLieu getOne(String maCL) {
        return clRepo.getSanPhamByMaSP(maCL);
    }
}
