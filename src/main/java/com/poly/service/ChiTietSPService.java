package com.poly.service;

import com.poly.entity.ChiTietSanPham;
import com.poly.entity.KichCo;
import com.poly.entity.QLSanPham;
import com.poly.entity.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    List<ChiTietSanPham> getList();
    Page<ChiTietSanPham> getListSP(Pageable pageable);
    void addKC(ChiTietSanPham qlSanPham);
    void deleteSP(UUID id);

    Integer getSoLuongSP(UUID id);
    ChiTietSanPham updateCTSP(ChiTietSanPham sanPham);
//    QLSanPham findAllSPByKey(String key);
    ChiTietSanPham getOne(UUID id);
    Page<ChiTietSanPham> searchCTSP(String keyword,Pageable pageable);

    List<ChiTietSanPham> filterByTenSP(String tenSP);
    List<ChiTietSanPham> filterByMauSac(String tenMau);
    List<ChiTietSanPham> filterByLoaiGiay(String loaiGiay);
    List<ChiTietSanPham> filterByKichCo(String size);

    QLSanPham getOne(UUID id);
    Page<QLSanPham> searchCTSP(String keyword,Pageable pageable);
    Integer getSoLuongSP(UUID id);
    QLSanPham updateCTSP(QLSanPham sanPham);
//    QLSanPham findAllSPByKey(String key);

}
