package com.poly.repository;

import com.poly.entity.TaiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaiKhoanRepo extends JpaRepository<TaiKhoan, UUID> {


    TaiKhoan findByUsernameAndPassword(String username, String password);
}
