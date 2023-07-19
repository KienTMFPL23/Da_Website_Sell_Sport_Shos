package com.poly.service;

import com.poly.entity.ChatLieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ChatLieuService {
     Page<ChatLieu> search(String key, Pageable pageable);

     ChatLieu getOne(String maCL) ;
}
