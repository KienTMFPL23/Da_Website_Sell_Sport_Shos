package com.poly.service.Impl;

import com.poly.entity.ChiTietSanPham;
import com.poly.entity.QLSanPham;
import com.poly.entity.SanPham;
import com.poly.repository.ChiTietSanPhamRepo;
import com.poly.service.ChiTietSPService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSPService {
    @Autowired
    ChiTietSanPhamRepo repo;
    @Autowired
    HttpServletRequest request;

    @Override
    public List<ChiTietSanPham> getList() {
        return repo.findAll();
    }

    @Override
    public Page<ChiTietSanPham> getListSP(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public void addKC(ChiTietSanPham qlSanPham) {
//        String uploadRootPath = request.getServletContext().getRealPath("images");
//        System.out.println("uploadRootPath" + uploadRootPath);
//
//        File uploadRootDir = new File(uploadRootPath);
//        //create directory if it not exits
//        if (!uploadRootDir.exists()) {
//            uploadRootDir.mkdirs();
//        }
////        MultipartFile fileData = qlSanPham.getHinhAnh();
////        String name = fileData.getOriginalFilename();
//        String name = qlSanPham.getHinhAnh();
//        System.out.println("client file name=" + name);
//        if (name != null && name.length() > 0) {
//            try {
//                // Create the file at server
//                File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + qlSanPham.getId()+".jpg");
//
//                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
//                stream.write(qlSanPham.getHinhAnh().getBytes());
//                stream.close();
//                //
//                System.out.println("Write file: " + serverFile);
//
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//
//        }
//        qlSanPham.setHinhAnh(name);
        repo.save(qlSanPham);

    }

    @Override
    public void deleteSP(UUID id) {
        repo.deleteById(id);
    }

    @Override
    public ChiTietSanPham getOne(UUID id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Page<ChiTietSanPham> searchCTSP(String keyword, Pageable pageable) {
        return repo.searchCTSP(keyword, pageable);
    }

    @Override
    public Integer getSoLuongSP(UUID id) {
        Integer soLuong = 0;
        QLSanPham sanPham = repo.findById(id).orElse(null);
        soLuong = sanPham.getSoLuong();
        return soLuong;
    }

    @Override
    public QLSanPham updateCTSP(QLSanPham sanPham) {
        return repo.save(sanPham);
    }


//    @Override
//    public QLSanPham findAllSPByKey(String key) {
//        return repo.findAllSPByKey(key);
//    }
}
