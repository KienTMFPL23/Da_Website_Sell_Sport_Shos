package com.poly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "HoaDonChiTiet")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDonChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Double donGia;

    @Column(name = "DonGiaKhiGiam")
    private Double donGiaKhiGiam;

    @ManyToOne
    @JoinColumn(name = "IdHoaDon")
    HoaDon hoaDon;
    @ManyToOne
    @JoinColumn(name = "IdChiTietSP")
    ChiTietSanPham qlSanPham;
}
