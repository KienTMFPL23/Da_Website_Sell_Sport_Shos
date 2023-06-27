Create Database JAVA_DA_Sell_Sports_Shoes
GO

Use JAVA_DA_Sell_Sports_Shoes
GO

CREATE TABLE SanPham(
	Id  UNIQUEIDENTIFIER 
		DEFAULT NEWID() PRIMARY KEY,
	MaSanPham    VARCHAR (100) UNIQUE,
	TenSanPham   NVARCHAR(150)
)
GO

CREATE TABLE ChatLieu(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    MaChatLieu  VARCHAR(100) UNIQUE,
    TenChatLieu  NVARCHAR(150),
	TrangThai INT
)
GO

CREATE TABLE KichCo(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    MaKichCo  VARCHAR(100) UNIQUE,
    Size   INT ,
    LoaiSize  VARCHAR(20),
	GioiTinh  BIT,
	TrangThai INT
)
GO

CREATE TABLE LoaiGiay(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    Ma  VARCHAR(100) UNIQUE,
    TenTheLoai  NVARCHAR(150),
	TrangThai INT
)
GO

CREATE TABLE DeGiay(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    Ma  VARCHAR(100) UNIQUE,
    LoaiDe  NVARCHAR(150),
	MoTa  NVARCHAR(255),
	TrangThai INT
)
GO

CREATE TABLE MauSac(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    Ma  VARCHAR(100) UNIQUE,
    TenMau  NVARCHAR(150),
	TrangThai INT
)
GO

CREATE TABLE ChiTietSanPham(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdSP  UNIQUEIDENTIFIER REFERENCES SanPham(Id),
    IdMauSac UNIQUEIDENTIFIER REFERENCES MauSac(Id),
    IdTheLoai UNIQUEIDENTIFIER REFERENCES LoaiGiay(Id),
    IdKichCo UNIQUEIDENTIFIER REFERENCES KichCo(Id),
    IdChatLieu UNIQUEIDENTIFIER REFERENCES ChatLieu(Id),
    IdDeGiay UNIQUEIDENTIFIER REFERENCES DeGiay(Id),
    DonGia   MONEY,
    SoLuong INT,
    HinhAnh   VARCHAR(50),
    MoTaCT   NVARCHAR(255),
    TrangThai INT
)
GO

CREATE TABLE TaiKhoan(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    Username VARCHAR(100) UNIQUE,
    Password VARCHAR(100) UNIQUE, 
    Role     BIT
)
GO

CREATE TABLE NguoiDung(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdTaiKhoan  UNIQUEIDENTIFIER REFERENCES TaiKhoan(Id),
    Ma    VARCHAR(50),
    Ho    NVARCHAR(50),
    TenDem NVARCHAR(50),
    Ten    NVARCHAR(50),
    GioiTinh  BIT,
    NgaySinh  DATE,
    DiaChi   NVARCHAR(255),
    SoDienThoai  VARCHAR(15) UNIQUE,
    Email    VARCHAR(200),
    TrangThai INT
)
GO

CREATE TABLE GioHang(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdND  UNIQUEIDENTIFIER REFERENCES NguoiDung(Id),
    NgayTao   DATE,
    NgayThanhToan    DATE,
    TenND NVARCHAR(100),
    SoDienThoai    VARCHAR(15) UNIQUE,
    TrangThai INT
)
GO

CREATE TABLE HoaDon(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdND  UNIQUEIDENTIFIER REFERENCES NguoiDung(Id),
    MaHD    VARCHAR(150),
    NgayTao  DATE,
    NgayThanhToan  DATE,
    DiaChiShip   NVARCHAR(255),
    SoDienThoai  VARCHAR(15) UNIQUE,
    TenNguoiNhan    NVARCHAR(100),
    TrangThai INT
)
GO

CREATE TABLE HoaDonChiTiet(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdHoaDon   UNIQUEIDENTIFIER REFERENCES HoaDon(Id),
    IdChiTietSP UNIQUEIDENTIFIER REFERENCES ChiTietSanPham(Id),
    SoLuong INT,
    DonGia   MONEY,
    DonGiaKhiGiam   MONEY
)
GO

CREATE TABLE PhieuGiaoHang(
    Id UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdHoaDon   UNIQUEIDENTIFIER REFERENCES HoaDon(Id),
    NgayTao   DATE,
    NgayThanhToan   DATE,
    NgayShip   DATE,
    NgayNhan  DATE,
    DiaChi   NVARCHAR(200)
)
GO

CREATE TABLE GioHangChiTiet(
    Id  UNIQUEIDENTIFIER DEFAULT NEWID() PRIMARY KEY,
    IdChiTietSP  UNIQUEIDENTIFIER REFERENCES ChiTietSanPham(Id),
    IdGioHang  UNIQUEIDENTIFIER REFERENCES GioHang(Id),
    SoLuong INT,
    DonGia  MONEY,
    DonGiaKhiGiam MONEY
)

