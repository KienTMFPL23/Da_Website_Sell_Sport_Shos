package com.poly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "SanPham")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaSanPham")
    @Min(value = 5,message = "Mã sản phẩm phải lớn hơn hoặc bằng 5")
    @Max(value = 100,message = "Mã sản phẩm phải nhỏ hơn hoặc bằng 100")
    @NotBlank(message = "Không được để trống")
    private String maSP;
    @NotBlank(message = "Không được để trống")
    @Max(value = 150,message = "Mã sản phẩm phải nhỏ hơn hoặc bằng 150")
    @Column(name = "TenSanPham")
    private String tenSP;

}
