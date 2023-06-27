package com.poly.repository;

import com.poly.entity.KichCo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface KichCoRepo extends JpaRepository<KichCo, UUID> {

}
