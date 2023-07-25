package com.poly.service.Impl;

import com.poly.entity.ChiTietSanPham;
import com.poly.entity.QLSanPham;
import com.poly.entity.SanPham;
import com.poly.repository.ChiTietSanPhamRepo;
import com.poly.service.ChiTietSPService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSPService {
    @Autowired
    ChiTietSanPhamRepo repo;
    @Autowired
    HttpServletRequest request;

    @Override
    public List<ChiTietSanPham> getList() {
        return repo.findAll();
    }

    @Override
    public Page<ChiTietSanPham> getListSP(Pageable pageable) {
        return repo.findAll(pageable);
    }
    @Override
    public void addKC(ChiTietSanPham qlSanPham) {
        repo.save(qlSanPham);
    }
    @Override
    public void deleteSP(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public ChiTietSanPham getOne(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Page<ChiTietSanPham> searchCTSP(String keyword,String tenmau, Pageable pageable) {
        return repo.searchCTSP(keyword,tenmau, pageable);
    }

    @Override

    public Page<ChiTietSanPham> searchMau(String tenmau, Pageable pageable) {
        return repo.searchMau(tenmau,pageable);
    }



    public List<ChiTietSanPham> filterByTenSP(String tenSP) {
        return repo.filterBySanPham(tenSP);
    }

    @Override
    public List<ChiTietSanPham> filterByMauSac(String tenMau) {
        return repo.filterByMauSac(tenMau);
    }

    @Override
    public List<ChiTietSanPham> filterByLoaiGiay(String loaiGiay) {
        return repo.filterByLoaiGiay(loaiGiay);
    }

    @Override
    public List<ChiTietSanPham> filterByKichCo(String size) {
        return repo.filterByKichCo(size);
    }

    @Override
    public Integer getSoLuongSP(UUID id) {
        Integer soLuong = 0;
        ChiTietSanPham sanPham = repo.findById(id).orElse(null);

    public Integer getSoLuongSP(UUID id) {
        Integer soLuong = 0;
        QLSanPham sanPham = repo.findById(id).orElse(null);

        soLuong = sanPham.getSoLuong();
        return soLuong;
    }

    @Override

    public ChiTietSanPham updateCTSP(ChiTietSanPham sanPham) {

    public QLSanPham updateCTSP(QLSanPham sanPham) {

        return repo.save(sanPham);
    }

}
