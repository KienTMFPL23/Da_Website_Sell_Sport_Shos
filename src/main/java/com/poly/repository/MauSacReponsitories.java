package com.poly.repository;

import com.poly.entity.MauSac;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacReponsitories extends JpaRepository<MauSac, UUID> {
    @Query("SELECT ms FROM MauSac ms where ms.ten LIKE %?1% or ms.ma like %?1%")

    Page<MauSac> search(String key,Pageable pageable);

    Page<MauSac> findAll(Pageable pageable );
}
