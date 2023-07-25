package com.poly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

//@Entity
//@Table(name = "ChiTietSanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class QLSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    UUID id;
    @ManyToOne()
    @JoinColumn(name = "Idsp")
    SanPham sanPham;
    @ManyToOne()
    @JoinColumn(name = "Idmausac")
    MauSac mauSac;
    @ManyToOne()
    @JoinColumn(name = "Idtheloai")
    LoaiGiay loaiGiay;
    @ManyToOne()
    @JoinColumn(name = "Idkichco")
    KichCo kichCo;
    @ManyToOne()
    @JoinColumn(name = "Idchatlieu")
    ChatLieu chatLieu;
    @ManyToOne()
    @JoinColumn(name = "Iddegiay")
    DeGiay deGiay;
    @Column(name = "Dongia")
    Double donGia;
    @Column(name = "Soluong")
    Integer soLuong;

    @Column(name = "Hinhanh")
    @Transient
    MultipartFile hinhAnh;
    @Column(name = "Motact")
    String moTaCT;
    @Column(name = "Trangthai")
    Integer trangThai;

    @Override
    public String toString() {
        return sanPham.getTenSP();
    }
    public void loadFromDomainModel(ChiTietSanPham domain)
    {
        this.setHinhAnh(hinhAnh);
        this.setChatLieu( domain.getChatLieu() );
        this.setDeGiay( domain.getDeGiay() );
        this.setDonGia( domain.getDonGia() );
        this.setKichCo( domain.getKichCo() );
        this.setSanPham( domain.getSanPham() );
        this.setTrangThai( domain.getTrangThai() );
        this.setMoTaCT( domain.getMoTaCT() );
        this.setSoLuong( domain.getSoLuong() );
        this.setLoaiGiay( domain.getLoaiGiay() );
        this.setMauSac( domain.getMauSac() );
    }

}
