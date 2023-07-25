package com.poly.service.Impl;

import com.poly.entity.HoaDon;
import com.poly.repository.HoaDonRepo;
import com.poly.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HoaDonServiceImpl implements HoaDonService {
   @Autowired
    HoaDonRepo hoaDonRepo;

    @Override
    public List<HoaDon> dsHoaDon() {
        return hoaDonRepo.findAllByTrangThai();
    }

    @Override
    public HoaDon saveHoaDon(HoaDon hoaDon) {
        return hoaDonRepo.save(hoaDon);
    }

    @Override
    public HoaDon updateHoaDon(HoaDon hoaDon) {
        return null;
    }

    @Override
    public void removeHoaDon(UUID id) {
        hoaDonRepo.deleteById(id);
    }

    @Override
    public HoaDon findHoaDon(UUID id) {
        return hoaDonRepo.findHoaDon(id);
    }
}
