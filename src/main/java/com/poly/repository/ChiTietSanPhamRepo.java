package com.poly.repository;

import com.poly.entity.ChiTietSanPham;
import com.poly.entity.QLSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChiTietSanPhamRepo extends JpaRepository<ChiTietSanPham, UUID> {

    @Query(value = "SELECT sp.Id\n" +
            "      ,IdSP,s.TenSanPham\n" +
            "      ,IdMauSac\n" +
            "      ,IdTheLoai\n" +
            "      ,IdKichCo\n" +
            "      ,IdChatLieu\n" +
            "      ,IdDeGiay\n" +
            "      ,DonGia\n" +
            "      ,SoLuong\n" +
            "      ,HinhAnh\n" +
            "      ,MoTaCT\n" +
            "      ,sp.TrangThai\n" +
            "  FROM [dbo].[ChiTietSanPham]\n" +
            "  sp join SanPham s on s.Id=sp.IdSP\n" +
            "  join MauSac m on m.Id=sp.IdMauSac\n" +
            "  Where s.TenSanPham like ?1 or m.TenMau like ?1 or s.MaSanPham like ?1\n" +
            "  group by sp.Id\n" +
            "      ,IdSP,s.TenSanPham\n" +
            "      ,IdMauSac\n" +
            "      ,IdTheLoai\n" +
            "      ,IdKichCo\n" +
            "      ,IdChatLieu\n" +
            "      ,IdDeGiay\n" +
            "      ,DonGia\n" +
            "      ,SoLuong\n" +
            "      ,HinhAnh\n" +
            "      ,MoTaCT\n" +
            "      ,sp.TrangThai,s.MaSanPham,m.TenMau,\n" +
            "\t  m.Id", nativeQuery = true)


//    @Query("select ctsp from QLSanPham ctsp where  ctsp.sanPham.tenSP like ?1 or ctsp.sanPham.maSP ?1")
//    QLSanPham findAllSPByKey(String keyword);

    Page<ChiTietSanPham> searchCTSP(String keyword, Pageable pageable);

    @Query("select ctsp from ChiTietSanPham  ctsp where  ctsp.sanPham.tenSP =? 1")
    List<ChiTietSanPham> filterBySanPham(String tenSanPham);
    @Query("select ctsp from ChiTietSanPham  ctsp where  ctsp.mauSac.ten =? 1")
    List<ChiTietSanPham> filterByMauSac(String tenMau);
    @Query("select ctsp from ChiTietSanPham  ctsp where  ctsp.kichCo.size =? 1")
    List<ChiTietSanPham> filterByKichCo(String size);
    @Query("select ctsp from ChiTietSanPham  ctsp where  ctsp.loaiGiay.tentheloai =? 1")
    List<ChiTietSanPham> filterByLoaiGiay(String loaiGiay);

    Page<QLSanPham> searchCTSP(String keyword, Pageable pageable);

}
