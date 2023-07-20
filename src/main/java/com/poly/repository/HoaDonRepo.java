package com.poly.repository;

import com.poly.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, UUID> {
    @Query("select hd from HoaDon  hd where hd.id =? 1")
    HoaDon findHoaDon(UUID id);
    @Query("select hd from HoaDon hd where hd.trangThai = 0 order by hd.ngayTao")
    List<HoaDon> findAllByTrangThai();
}
