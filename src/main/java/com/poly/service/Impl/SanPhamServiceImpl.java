package com.poly.service.Impl;

import com.poly.entity.SanPham;
import com.poly.repository.SanPhamRepo;
import com.poly.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamRepo sanPhamRepo;

    @Override
    public List<SanPham> findALlSP() {
        return sanPhamRepo.findAll();
    }

    @Override
    public SanPham addSP(SanPham sanPham) {
        return sanPhamRepo.save(sanPham);
    }

    @Override
    public SanPham update(SanPham sanPham) {
        return sanPhamRepo.save(sanPham);
    }

    @Override
    public void deleteSP(UUID id) {

    }

    @Override
    public SanPham getOne(UUID id) {
       return sanPhamRepo.findById(id).orElse(null);
    }

    @Override
    public SanPham getSP(String maSP) {
        return sanPhamRepo.getSanPhamByMaSP(maSP);
    }
}