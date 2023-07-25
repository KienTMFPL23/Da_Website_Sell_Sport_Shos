package com.poly.repository;

import com.poly.entity.NguoiDung;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.UUID;

public interface NguoiDungReponsitory extends JpaRepository<NguoiDung, UUID> {

//    Page<NguoiDung> findAll(Pageable pageable);
    @Query("select nd from NguoiDung nd join nd.tk  tk where tk.role = true and nd.ma like %?1% and nd.ten like %?1% or nd.email like %?1% or nd.sdt like %?1%")
    Page<NguoiDung> searchNhanVien(String key,Pageable pageable);
    @Query("select nd from NguoiDung nd join nd.tk  tk where tk.role = true ")
    Page<NguoiDung> findNhanVien(Pageable pageable);
    @Query("select nd from NguoiDung nd join nd.tk  tk where tk.role = false and nd.ma like %?1% and  nd.ten like %?1% or nd.email like %?1% or nd.sdt like %?1% ")
    Page<NguoiDung> searchkhachhang(String key , Pageable pageable);
    @Query("select nd from NguoiDung nd join nd.tk  tk where tk.role = false ")
    Page<NguoiDung> findKhachhang( Pageable pageable);
    @Query("select nd from NguoiDung  nd where nd.tk.id = ?1")
    NguoiDung findNguoiDungById(UUID id);
    @Query("select  nd from NguoiDung  nd where  nd.tk.role = true")
    List<NguoiDung> findAllKhachHang();
}
