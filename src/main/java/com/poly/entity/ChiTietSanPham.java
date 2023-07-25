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

@Entity
@Table(name = "ChiTietSanPham")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPham {
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
//    @NotNull(message = "không để trống")
    Double donGia;

    @Column(name = "Soluong")
//    @NotNull(message = "không để trống")
    Integer soLuong;

    @Column(name = "Hinhanh")
//    @Transient
//    @NotBlank(message = "không để trống")
    String hinhAnh;

    @Column(name = "Motact")
//    @NotBlank(message = "không để trống")
    String moTaCT;

    @Column(name = "Trangthai")
//    @NotNull(message = "không để trống")
    Integer trangThai;

    public void loadFromViewModel(QLSanPham vm)
    {
        this.setHinhAnh( vm.getHinhAnh().getName());
        this.setChatLieu( vm.getChatLieu() );
        this.setDeGiay( vm.getDeGiay() );
        this.setDonGia( vm.getDonGia() );
        this.setKichCo( vm.getKichCo() );
        this.setSanPham( vm.getSanPham() );
        this.setTrangThai( vm.getTrangThai() );
        this.setMoTaCT( vm.getMoTaCT() );
        this.setSoLuong( vm.getSoLuong() );
        this.setLoaiGiay( vm.getLoaiGiay() );
        this.setMauSac( vm.getMauSac() );
    }
    public ChiTietSanPham(SanPham sanPham, ChatLieu chatLieu, DeGiay deGiay, LoaiGiay loaiGiay, Double donGia, MultipartFile hinhAnh, KichCo kichCo, MauSac mauSac, String moTaCT, Double donGia1) {
    }
}
