package com.poly.service.Impl;

import com.poly.entity.MauSac;
import com.poly.entity.NguoiDung;
import com.poly.repository.NguoiDungReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NguoiDungServiceimpl {
    @Autowired
    private NguoiDungReponsitory ndr;
    public Page<NguoiDung> searchkh(String key, Pageable pageable){
        if(key != null){
            return ndr.searchkhachhang(key,pageable);
        }
        return ndr.findKhachhang(pageable);
    }
    public Page<NguoiDung> searchnv(String key, Pageable pageable){
        if(key != null){
            return ndr.searchNhanVien(key,pageable);
        }
        return ndr.findNhanVien(pageable);
    }
}
