package com.poly.service.Impl;

import com.poly.entity.MauSac;
import com.poly.repository.MauSacReponsitories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class MauSacServiceImpl {
    @Autowired
    MauSacReponsitories msr;
    public Page<MauSac> search(String key, Pageable pageable){
        if(key != null){
            return msr.search(key,pageable);
        }
        return msr.findAll(pageable);
    }
}
