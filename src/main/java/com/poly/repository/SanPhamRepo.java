package com.poly.repository;

import com.poly.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, UUID> {
    @Query("select  p from SanPham  p where  p.maSP =?1")
    SanPham getSanPhamByMaSP(String masp);
}
