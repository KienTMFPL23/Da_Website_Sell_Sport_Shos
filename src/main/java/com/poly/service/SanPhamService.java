package com.poly.service;

import com.poly.entity.SanPham;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SanPhamService {
    List<SanPham> findALlSP();
    SanPham addSP(SanPham sanPham);
    SanPham update(SanPham sanPham);
    void deleteSP(UUID id);
    SanPham getOne(UUID id);
    SanPham getSP(String maSP);
}
