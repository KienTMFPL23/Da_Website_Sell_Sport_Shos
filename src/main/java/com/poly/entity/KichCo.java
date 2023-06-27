package com.poly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "kichco")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KichCo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @Column(name = "Makichco")
//    @NotBlank(message = "Không để trống")
    String maKichCo;
    @Column(name = "Size")
    @NotNull(message = "Không để trống")
    @Min(value = 5,message = "Size phải lớn hơn hoặc bằng 5")
    @Max(value = 100,message = "Size phải nhỏ hơn hoặc bằng 100")
    Integer size;
    @NotBlank(message = "Không để trống")
    @Column(name = "Loaisize")
    String loaiSize;
    @NotNull(message = "Mời chọn giới tính")
    @Column(name = "Gioitinh")
    Boolean gioiTinh;
    @NotNull(message = "Chọn trạng thái")
    @Column(name = "Trangthai")
    Integer trangThai;
}
