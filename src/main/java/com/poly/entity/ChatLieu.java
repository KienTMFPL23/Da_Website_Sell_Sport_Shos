package com.poly.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

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
    @NotBlank(message = "không để trống")
    @Length(min = 4, max = 100, message = "không quá 100 kí tự")
    private String ma;

    @NotBlank(message = "không để trống")
    @Length(min = 4, max = 100, message = "không quá 100 kí tự")
    @Column(name = "TenChatLieu")
    private String ten;

    @Column(name = "TrangThai")
    private Integer trangThai;
}
