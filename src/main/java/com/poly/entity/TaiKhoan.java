package com.poly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "TaiKhoan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaiKhoan {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="Id")
    private UUID id;

    @Column(name="Username")
    private String username;

    @Column(name="Password")
    private String password;

    @Column(name="Role")
    private Boolean role;

    @OneToOne(mappedBy = "tk")
    private NguoiDung nguoiDung;
}
