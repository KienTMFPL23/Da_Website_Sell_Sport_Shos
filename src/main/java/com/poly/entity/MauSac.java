package com.poly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "Mausac")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @NotBlank(message = "Không dc để trống thông tin")
    @Length(max = 255,message = "không dc nhập quá kí tự ")
    @Column(name = "Ma")
    private String ma;
    @NotBlank(message = "Không dc để trống thông tin")
    @Length(max = 255,message = "không dc nhập quá kí tự ")
    @Column(name = "TenMau")
    private String ten;
    @Column(name = "TrangThai")
    private Integer tt;

    @OneToMany(mappedBy = "mauSac")
    private List<ChiTietSanPham> danhSachChiTietSanPham;
}
