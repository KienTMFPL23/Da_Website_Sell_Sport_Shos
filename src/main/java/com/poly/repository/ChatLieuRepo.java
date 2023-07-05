package com.poly.repository;

import com.poly.entity.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatLieuRepo extends JpaRepository<ChatLieu, UUID> {
    @Query("select cl from ChatLieu cl where  cl.ma like ?1 or cl.ten like ?1 or ?1 is null")
    Page<ChatLieu> search(String keyword, Pageable pageable);
}
