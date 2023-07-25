package com.poly.repository;

import com.poly.entity.ChiTietSanPham;
import com.poly.entity.MauSac;
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
            "  Where s.TenSanPham like %?1% or m.TenMau like %?2% \n" +
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
    Page<ChiTietSanPham> searchCTSP(String keyword, String tenmau, Pageable pageable);

    @Query("SELECT ctsp FROM ChiTietSanPham  ctsp  where (?1 is null or ctsp.mauSac.ten LIKE ?1) ")
    Page<ChiTietSanPham> searchMau(String tenmau, Pageable pageable);

}
