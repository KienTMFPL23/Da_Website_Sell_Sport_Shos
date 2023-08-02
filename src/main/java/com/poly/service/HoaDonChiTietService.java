package com.poly.service;

import com.poly.entity.ChiTietSanPham;
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
    HoaDonChiTiet saveHDCT(HoaDonChiTiet hoaDon,UUID id,UUID idHD);
    HoaDonChiTiet updateHDCT(HoaDonChiTiet hoaDon);
    HoaDonChiTiet getOne(UUID id);
    Double getTotal(List<HoaDonChiTiet> list);
    HoaDonChiTiet getHoaDonChiTiet(UUID id);
}
