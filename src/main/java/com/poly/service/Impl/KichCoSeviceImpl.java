package com.poly.service.Impl;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.poly.entity.KichCo;
import com.poly.repository.KichCoRepo;
import com.poly.service.KichCoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class KichCoSeviceImpl implements KichCoService {
    @Autowired
    KichCoRepo repo;

    @Override
    public List<KichCo> getList() {
        return repo.findAll();
    }

    @Override
    public void addKC(KichCo kichCo) {
        Random random = new Random();
        kichCo.setMaKichCo("KC" + random.nextInt());
        repo.save(kichCo);
    }

    @Override
    public void deleteKC(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public KichCo getOne(UUID id) {
        return repo.findById(id).orElse(null);
    }
}
