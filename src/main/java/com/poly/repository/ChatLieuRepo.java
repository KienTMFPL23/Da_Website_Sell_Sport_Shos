package com.poly.repository;

import com.poly.entity.ChatLieu;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChatLieuRepo extends JpaRepository<ChatLieu, UUID> {
    @Query(value = "select * from ChatLieu where TenChatLieu = ?1", nativeQuery = true)
    Page<ChatLieu> searchTen(String ten, Pageable pageable);
}
