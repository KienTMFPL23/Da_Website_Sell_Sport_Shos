package com.poly.repository;

import com.poly.entity.HoaDonChiTiet;
import com.poly.entity.QLSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonChiTietRepo extends JpaRepository<HoaDonChiTiet, UUID> {
    @Query("select hdct from HoaDonChiTiet  hdct where hdct.hoaDon.id =? 1")
    List<HoaDonChiTiet> findAllById(UUID id);
    @Query("select hdct from HoaDonChiTiet  hdct where hdct.hoaDon.id =?1")
    List<QLSanPham> findSanPhamInHoaDon(UUID id);
}
