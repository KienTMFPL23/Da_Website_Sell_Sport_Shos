package com.poly.service;

import com.poly.entity.KichCo;
import com.poly.entity.QLSanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPService {
    List<QLSanPham> getList();
    Page<QLSanPham> getListSP(Pageable pageable);
    void addKC(QLSanPham qlSanPham);
    void deleteSP(UUID id);
    QLSanPham getOne(UUID id);
    Page<QLSanPham> searchCTSP(String keyword,Pageable pageable);

}
