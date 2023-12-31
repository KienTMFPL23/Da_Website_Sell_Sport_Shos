package com.poly.repository;

import com.poly.entity.LoaiGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface LoaiGiayRepo extends JpaRepository<LoaiGiay, UUID>{

    @Query("select l from LoaiGiay l where l.ma like ?1 or l.tentheloai like ?1 or ?1 is null")
    public Page<LoaiGiay> searchByMaLoaiGiay(String keyword, Pageable pageable);

    @Query("select l from LoaiGiay l")
    public Page<LoaiGiay> getAll(Pageable pageable);
}
