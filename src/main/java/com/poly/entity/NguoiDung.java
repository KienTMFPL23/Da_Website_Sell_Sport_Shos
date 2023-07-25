package com.poly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "NguoiDung")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NguoiDung {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "IdTaiKhoan")
    private TaiKhoan tk;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ho")
    private String ho;
    @Column(name = "TenDem")
    private String tendem;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "DiaChi")
    private String diachi;
    @Column(name = "GioiTinh")
    private Boolean gioitinh;
    @Column(name = "NgaySinh")
    private Date ngaysinh;
    @Column(name = "SoDienThoai")
    private String sdt;
    @Column(name = "Email")
    private String email;
    @Column(name = "TrangThai")
    private Integer tt;

    @OneToMany(mappedBy = "nguoiDung")
    private List<HoaDon> hoaDons;

}
