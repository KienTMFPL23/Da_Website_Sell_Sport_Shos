package com.poly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Sanpham")
public class SanPham implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    @NotBlank(message = "khong de trong ma")
    @Column(name = "Masanpham")
    String maSP;
    @Column(name = "Tensanpham")
    String tenSP;

}