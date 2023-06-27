package com.poly.service;

import com.poly.entity.KichCo;

import java.util.List;
import java.util.UUID;

public interface KichCoService {
    List<KichCo> getList();
    void addKC(KichCo kichCo);
    void deleteKC(UUID id);
    KichCo getOne(UUID id);
}
