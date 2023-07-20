package com.poly.service;

import com.poly.entity.HoaDon;
import com.poly.entity.HoaDonChiTiet;
import com.poly.entity.QLSanPham;

import java.util.List;
import java.util.UUID;

public interface HoaDonChiTietService {
    List<HoaDonChiTiet> findAllById(UUID id);
    List<HoaDonChiTiet> findALl();
    List<HoaDonChiTiet> saveAllHDCT(List<HoaDonChiTiet> list);
    void deleteHoaDonChiTiet(UUID id);
    void removeByIdHOaDon(UUID id);
    HoaDonChiTiet saveHDCT(HoaDonChiTiet hoaDon);
    void updateSoLuong(List<QLSanPham> list,QLSanPham sanPham);
    HoaDonChiTiet getOne(UUID id);
    List<QLSanPham> findSanPhamInHoaDon(UUID id);
    Double getTotal(List<HoaDonChiTiet> list);
    void clear();
}
