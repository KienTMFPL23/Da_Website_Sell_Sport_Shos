package com.poly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.UUID;

@Entity
@Table(name="DeGiay")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeGiay {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="Id")
    private UUID id;

    @Column(name="Ma")
    @Size(min = 4, max = 100, message = "Mã phải từ 4 đến 150 kí tự")
    @NotBlank(message = "Mã không được để trống")
    private String ma;

    @Column(name="LoaiDe")
    @NotBlank(message = "Loại đế không được để trống")
    @Size(max = 150, message = "Loại đế không được quá 150 kí tự")
    private String loaide;

    @Column(name="MoTa")
    @NotBlank(message = "Mô tả không được để trống")
    private String mota;

    @Column(name="TrangThai")
    @NotNull(message = "Trạng thái không được để trống")
    private Integer trangthai;
}
