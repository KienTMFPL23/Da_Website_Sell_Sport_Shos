package com.poly.repository;

import com.poly.entity.KichCo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface KichCoRepo extends JpaRepository<KichCo, UUID> {
    @Query("select k from KichCo k where  k.loaiSize like ?1 or k.maKichCo like ?1 or ?1 is null")
    Page<KichCo> search(String keyword, Pageable pageable);

    @Query("select k from KichCo k where  k.gioiTinh =?1 or ?1 is null ")
    Page<KichCo> searchGT(Boolean gioitinh, Pageable pageable);

}
