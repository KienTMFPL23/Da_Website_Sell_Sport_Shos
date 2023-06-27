package com.poly.repository;

import com.poly.entity.DeGiay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DeGiayRepo extends JpaRepository<DeGiay, UUID> {

    @Query(value = "select d from DeGiay d where d.ma = ?1")
    DeGiay findByMa(String ma);

    @Query(value = "select d from DeGiay d where d.ma LIKE :keyword or d.loaide LIKE :keyword")
    List<DeGiay> searchByMaAndLoaiDe(@Param("keyword") String keyword);

}
