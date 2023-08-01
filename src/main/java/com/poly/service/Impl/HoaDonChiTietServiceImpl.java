package com.poly.service.Impl;

import com.poly.entity.ChiTietSanPham;
import com.poly.entity.HoaDon;
import com.poly.entity.HoaDonChiTiet;
import com.poly.entity.QLSanPham;
import com.poly.repository.ChiTietSanPhamRepo;
import com.poly.repository.HoaDonChiTietRepo;
import com.poly.repository.HoaDonRepo;
import com.poly.service.ChiTietSPService;
import com.poly.service.HoaDonChiTietService;
import com.poly.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {
    @Autowired
    HoaDonChiTietRepo hoaDonChiTietRepo;
    @Autowired
    ChiTietSanPhamRepo ctspRepo;
    @Autowired
    HoaDonRepo hoaDonRepo;

    @Override
    public List<HoaDonChiTiet> findAllById(UUID id) {
        return hoaDonChiTietRepo.findAllById(id);
    }

    @Override
    public List<HoaDonChiTiet> findALl() {
        return hoaDonChiTietRepo.findAll();
    }

    @Override
    public HoaDonChiTiet saveHDCT(HoaDonChiTiet hoaDon,UUID id,UUID idHD) {
        List<HoaDonChiTiet> list = hoaDonChiTietRepo.findAllById(idHD);
        HoaDonChiTiet item = list
                .stream()
                .filter(p -> p.getQlSanPham().getId() == id)
                .findFirst()
                .orElse(null);
        if (item != null){
            item.setSoLuong(item.getSoLuong() + 1);
            return item;
        }
        return hoaDonChiTietRepo.save(hoaDon);
    }

    @Override
    public HoaDonChiTiet updateHDCT(HoaDonChiTiet hoaDon) {
        return hoaDonChiTietRepo.save(hoaDon);
    }

    @Override
    public HoaDonChiTiet getOne(UUID id) {
        return hoaDonChiTietRepo.findById(id).orElse(null);
    }

    @Override
    public Double getTotal(List<HoaDonChiTiet> list) {
        Double sum = 0.0;
        for (HoaDonChiTiet hdct : list){
            sum += hdct.getDonGia() * hdct.getSoLuong();
        }
        return sum;
    }

    @Override
    public HoaDonChiTiet getHoaDonChiTiet(UUID id) {
        return hoaDonChiTietRepo.getHoaDonChiTiet(id);
    }


    @Override
    public List<HoaDonChiTiet> saveAllHDCT(List<HoaDonChiTiet> list) {
        return hoaDonChiTietRepo.saveAll(list);
    }

    @Override
    public void deleteHoaDonChiTiet(UUID id) {
        hoaDonChiTietRepo.deleteById(id);
    }

}
