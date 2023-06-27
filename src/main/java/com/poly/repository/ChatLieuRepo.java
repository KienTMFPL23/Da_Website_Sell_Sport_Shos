package com.poly.repository;

import com.poly.entity.ChatLieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChatLieuRepo extends JpaRepository<ChatLieu, UUID> {
}
