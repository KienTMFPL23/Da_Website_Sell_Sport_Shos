package com.poly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "HoaDon")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaHD")
    private String maHD;

    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "DiaChiShip")
    private String diaChiShip;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "TrangThai")
    private Integer trangThai;


    @ManyToOne
    @JoinColumn(name = "IdND")
    private NguoiDung nguoiDung;

}
