package com.poly.service;

import com.poly.entity.HoaDon;

import java.util.List;
import java.util.UUID;

public interface HoaDonService {
    List<HoaDon> dsHoaDon();
    HoaDon saveHoaDon(HoaDon hoaDon);
    HoaDon updateHoaDon(HoaDon hoaDon);
    void removeHoaDon(UUID id);
    HoaDon findHoaDon(UUID id);
}
