package com.poly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ChiTietSanPham")
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
    String hinhAnh;
    @Column(name = "Motact")
    String moTaCT;
    @Column(name = "Trangthai")
    Integer trangThai;

}
