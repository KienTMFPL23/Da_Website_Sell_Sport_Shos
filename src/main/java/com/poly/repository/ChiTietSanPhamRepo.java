package com.poly.repository;

import com.poly.entity.QLSanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepo extends JpaRepository<QLSanPham, UUID> {

}
