package com.poly.repository;

import com.poly.entity.ChatLieu;
import com.poly.entity.MauSac;
import com.poly.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatLieuRepo extends JpaRepository<ChatLieu, UUID> {
    @Query("SELECT cl FROM ChatLieu cl where cl.ten LIKE %?1% or cl.ma like %?1%")

    Page<ChatLieu> search(String key, Pageable pageable);

    Page<ChatLieu> findAll(Pageable pageable );

    @Query("select cl from ChatLieu cl where  cl.ma =?1")
    ChatLieu getSanPhamByMaSP(String maCl);
}
