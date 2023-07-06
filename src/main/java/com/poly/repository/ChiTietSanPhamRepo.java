package com.poly.repository;

import com.poly.entity.QLSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepo extends JpaRepository<QLSanPham, UUID> {
@Query("select sp from QLSanPham sp where sp.loaiGiay.tentheloai like ?1 or sp.kichCo.loaiSize like ?1 or sp.chatLieu.ten like ?1 or sp.mauSac.ten like ?1 or sp.sanPham.maSP like ?1 or sp.sanPham.tenSP like ?1 or sp.deGiay.loaide like ?1 or ?1 is null")
    Page<QLSanPham> searchSP(String keyword, Pageable pageable);
}
