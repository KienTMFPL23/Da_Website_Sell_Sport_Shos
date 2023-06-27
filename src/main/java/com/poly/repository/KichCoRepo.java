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
    @Query("select k from KichCo k where (?1 is null or k.loaiSize=?1) and (?2 is null or k.size=?2)")
    Page<KichCo> search(String loaiSize, Integer size, Pageable pageable);
}
