package com.poly.service;


import com.poly.entity.ChiTietSanPham;

import com.poly.entity.QLSanPham;
import com.poly.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SanPhamService {
    Page<SanPham> findALlSP(Pageable pageable);
    Page<SanPham> findAllByKeyword(String keyword,Pageable pageable);
    SanPham addSP(SanPham sanPham);
    SanPham update(SanPham sanPham);
    void deleteSP(UUID id);
    SanPham getOne(UUID id);
    SanPham getSP(String maSP);
    SanPham findSanPhamByKeWord(String keyword);

    ChiTietSanPham findCTSPByKey(String keyword);

    QLSanPham findCTSPByKey(String keyword);

}
