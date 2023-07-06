package com.poly.service.Impl;

import com.poly.entity.QLSanPham;
import com.poly.repository.ChiTietSanPhamRepo;
import com.poly.service.ChiTietSPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSPService {
    @Autowired
    ChiTietSanPhamRepo repo;

    @Override
    public List<QLSanPham> getList() {
        return repo.findAll();
    }

    @Override
    public Page<QLSanPham> getListSP(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public void addKC(QLSanPham qlSanPham) {
        repo.save(qlSanPham);
    }

    @Override
    public void deleteSP(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public QLSanPham getOne(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Page<QLSanPham> searchSP(String keyword, Pageable pageable) {
        return null;
    }
}
