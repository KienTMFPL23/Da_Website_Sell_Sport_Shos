package com.poly.service.Impl;

import com.poly.entity.HoaDon;
import com.poly.entity.HoaDonChiTiet;
import com.poly.entity.QLSanPham;
import com.poly.entity.SanPham;
import com.poly.repository.HoaDonChiTietRepo;
import com.poly.service.ChiTietSPService;
import com.poly.service.HoaDonChiTietService;
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
    ChiTietSPService ctspService;

    private List<HoaDonChiTiet> dsHoaDonCT = new ArrayList<>();

    @Override
    public List<HoaDonChiTiet> findAllById(UUID id) {
        return hoaDonChiTietRepo.findAllById(id);
    }

    @Override
    public List<HoaDonChiTiet> findALl() {
        return hoaDonChiTietRepo.findAll();
    }

    @Override
    public HoaDonChiTiet saveHDCT(HoaDonChiTiet hoaDon) {
        return hoaDonChiTietRepo.save(hoaDon);
    }

    @Override
    public void updateSoLuong(List<QLSanPham> dsSanPham,QLSanPham ctsp) {
        for (QLSanPham sp : dsSanPham){
            if (sp.getId().equals(ctsp.getId())){
                ctsp.setSoLuong(ctsp.getSoLuong() + 1);

            }
        }
    }

    @Override
    public HoaDonChiTiet getOne(UUID id) {
        return hoaDonChiTietRepo.findById(id).orElse(null);
    }

    @Override
    public List<QLSanPham> findSanPhamInHoaDon(UUID id) {
        List<QLSanPham> sanPham = hoaDonChiTietRepo.findSanPhamInHoaDon(id);
        return sanPham;
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
    public void clear() {
        dsHoaDonCT.clear();
    }

    @Override
    public List<HoaDonChiTiet> saveAllHDCT(List<HoaDonChiTiet> list) {
        return hoaDonChiTietRepo.saveAll(list);
    }

    @Override
    public void deleteHoaDonChiTiet(UUID id) {
        hoaDonChiTietRepo.deleteById(id);
    }

    @Override
    public void removeByIdHOaDon(UUID id) {
        hoaDonChiTietRepo.deleteById(id);
    }

}
