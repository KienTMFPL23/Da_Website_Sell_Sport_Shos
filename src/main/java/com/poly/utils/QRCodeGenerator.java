package com.poly.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.poly.entity.ChiTietSanPham;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.Map;

public class QRCodeGenerator {
    public static void generatorQRCode(ChiTietSanPham sp) throws WriterException, IOException {
        //generate code:
        String qrCodePath = "C:\\Users\\Admin\\Desktop\\QRCode\\";
        String qrCodeName = qrCodePath + sp.getId() + "-QRCODE.png";
        var qrCodeWriter = new QRCodeWriter();

        // Tạo thông tin sản phẩm dưới dạng UTF-8
        String qrCodeData = "ID: " + sp.getId() + "\n"
                + "Tên SP: " + sp.getSanPham().getTenSP() + "\n"
                + "Mã SP: " + sp.getSanPham().getMaSP() + "\n"
                + "Màu sắc: " + sp.getMauSac().getTen() + "\n"
                + "Mô tả: " + sp.getMoTaCT() + "\n";

        // Cấu hình mã hóa UTF-8
        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.CHARACTER_SET, StandardCharsets.UTF_8.name());

        BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeData, BarcodeFormat.QR_CODE, 400, 400, hints);
        Path path = FileSystems.getDefault().getPath(qrCodeName);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }
}
