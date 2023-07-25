package com.poly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
//    @NotEmpty(message = "không để trống")
    SanPham sanPham;

    @ManyToOne()
    @JoinColumn(name = "Idmausac")
//    @NotEmpty(message = "không để trống")
    MauSac mauSac;

    @ManyToOne()
    @JoinColumn(name = "Idtheloai")
//    @NotEmpty(message = "không để trống")
    LoaiGiay loaiGiay;

    @ManyToOne()
    @JoinColumn(name = "Idkichco")
//    @NotEmpty(message = "không để trống")
    KichCo kichCo;

    @ManyToOne()
    @JoinColumn(name = "Idchatlieu")
//    @NotEmpty(message = "không để trống")
    ChatLieu chatLieu;

    @ManyToOne()
    @JoinColumn(name = "Iddegiay")
//    @NotEmpty(message = "không để trống")
    DeGiay deGiay;

    @Column(name = "Dongia")
//    @NotNull(message = "không để trống")
    Double donGia;

    @Column(name = "Soluong")
//    @NotNull(message = "không để trống")
    Integer soLuong;

    @Column(name = "Hinhanh")
    @Transient
//    @NotNull(message = "không để trống")
    MultipartFile hinhAnh;
    @Column(name = "Motact")
//    @NotBlank(message = "không để trống")
    String moTaCT;
    @Column(name = "Trangthai")
//    @NotNull(message = "không để trống")
    Integer trangThai;

    @Override
    public String toString() {
        return sanPham.getTenSP();
    }

    public void loadFromDomainModel(ChiTietSanPham domain) {
        this.setHinhAnh(hinhAnh);
        this.setChatLieu(domain.getChatLieu());
        this.setDeGiay(domain.getDeGiay());
        this.setDonGia(domain.getDonGia());
        this.setKichCo(domain.getKichCo());
        this.setSanPham(domain.getSanPham());
        this.setTrangThai(domain.getTrangThai());
        this.setMoTaCT(domain.getMoTaCT());
        this.setSoLuong(domain.getSoLuong());
        this.setLoaiGiay(domain.getLoaiGiay());
        this.setMauSac(domain.getMauSac());
    }

}
