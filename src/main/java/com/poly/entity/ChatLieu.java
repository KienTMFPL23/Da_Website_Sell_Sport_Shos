package com.poly.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "ChatLieu")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ChatLieu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "MaChatLieu")
    private String maChatLieu;

    @Column(name = "TenChatLieu")
    private String tenChatLieu;
}
