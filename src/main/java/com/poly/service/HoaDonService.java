package com.poly.service;

import com.poly.entity.HoaDon;
import com.poly.repository.HoaDonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {

    List<HoaDon> dsHoaDon();
    HoaDon saveHoaDon(HoaDon hoaDon);
    HoaDon updateHoaDon(HoaDon hoaDon);
    void removeHoaDon(UUID id);
    HoaDon findHoaDon(UUID id);
    Page<HoaDon> allListHoaDon(Pageable pageable);

}
