package com.poly.repository;

import com.poly.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MauSacReponsitories extends JpaRepository<MauSac, UUID> {
}