package com.poly.repository;

import com.poly.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, UUID> {
    @Query("select hd from HoaDon  hd where hd.id =? 1")
    HoaDon findHoaDon(UUID id);
    @Query("select hd from HoaDon hd where hd.trangThai = 0 order by hd.ngayTao")
    List<HoaDon> findAllByTrangThai();
    @Query("select hd from HoaDon hd ")
    Page<HoaDon> AllHoaDon(Pageable pageable);
    @Query("select hd from HoaDon hd where hd.maHD like %?1%  ")
    HoaDon searchtheoma( String mahd);
    @Query("select  hd from HoaDon  hd where hd.tenNguoiNhan like %?1% ")
    Page<HoaDon> searchtheoten(  String ten,Pageable pageable);
    @Query("select  hd from HoaDon  hd where hd.tenNguoiNhan like  %?1% or hd.maHD like  %?2%")
    Page<HoaDon> searchtheoten(  String ten,String ma,Pageable pageable);
    @Query("select  hd from HoaDon   hd where hd.ngayTao = %?1% or hd.ngayThanhToan = %?2% ")
    Page<HoaDon> searchtheongay(java.sql.Date ngaybt, Date ngaykt, Pageable pageable);
    @Query("select  hd from HoaDon   hd where between hd.ngayTao = %?1% and hd.ngayThanhToan = %?2%")
    Page<HoaDon> searchtheokhoangngay(java.sql.Date ngaybt, Date ngaykt, Pageable pageable);
}
