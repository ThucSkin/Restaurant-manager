USE [master]
GO
/****** Object:  Database [QL_NhaHang1]    Script Date: 7/28/2022 11:24:33 PM ******/
CREATE DATABASE [QL_NhaHang1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QL_NhaHang1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QL_NhaHang1.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QL_NhaHang1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QL_NhaHang1_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QL_NhaHang1] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QL_NhaHang1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QL_NhaHang1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET ARITHABORT OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [QL_NhaHang1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QL_NhaHang1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QL_NhaHang1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QL_NhaHang1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QL_NhaHang1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QL_NhaHang1] SET  MULTI_USER 
GO
ALTER DATABASE [QL_NhaHang1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QL_NhaHang1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QL_NhaHang1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QL_NhaHang1] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QL_NhaHang1] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QL_NhaHang1] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QL_NhaHang1] SET QUERY_STORE = OFF
GO
USE [QL_NhaHang1]
GO
/****** Object:  Table [dbo].[Ban]    Script Date: 7/28/2022 11:24:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ban](
	[MaBan] [varchar](10) NOT NULL,
	[TenBan] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Ban] PRIMARY KEY CLUSTERED 
(
	[MaBan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonChiTiet]    Script Date: 7/28/2022 11:24:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonChiTiet](
	[MaHoaDon] [varchar](10) NOT NULL,
	[MaMenu] [varchar](10) NOT NULL,
	[Gia] [float] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GhiChu] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DonHang]    Script Date: 7/28/2022 11:24:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[MaHoaDon] [varchar](10) NOT NULL,
	[Tong] [float] NOT NULL,
	[TinhTrang] [varchar](50) NOT NULL,
	[GhiChu] [varchar](max) NULL,
	[MaNV] [varchar](10) NOT NULL,
	[MaBan] [varchar](10) NOT NULL,
 CONSTRAINT [PK_DonHang] PRIMARY KEY CLUSTERED 
(
	[MaHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Menu]    Script Date: 7/28/2022 11:24:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Menu](
	[MaMenu] [varchar](10) NOT NULL,
	[Ten] [varchar](20) NOT NULL,
	[Gia] [float] NOT NULL,
	[Hinh] [nvarchar](200) NOT NULL,
	[Loai] [varchar](20) NOT NULL,
 CONSTRAINT [PK_Menu] PRIMARY KEY CLUSTERED 
(
	[MaMenu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 7/28/2022 11:24:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [varchar](10) NOT NULL,
	[MatKhau] [nchar](3) NOT NULL,
	[TenNV] [nvarchar](50) NULL,
	[VaiTro] [bit] NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS001', N'01')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS002', N'02')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS003', N'03')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS004', N'04')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS005', N'05')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS006', N'06')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS007', N'07')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS008', N'08')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS009', N'09')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS010', N'10')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS011', N'11')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS012', N'12')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS013', N'13')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS014', N'14')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS015', N'15')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS016', N'16')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS017', N'17')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS018', N'18')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS019', N'19')
GO
INSERT [dbo].[Ban] ([MaBan], [TenBan]) VALUES (N'TS020', N'20')
GO
INSERT [dbo].[DonChiTiet] ([MaHoaDon], [MaMenu], [Gia], [SoLuong], [GhiChu]) VALUES (N'H01', N'T5', 500000, 1, NULL)
GO
INSERT [dbo].[DonHang] ([MaHoaDon], [Tong], [TinhTrang], [GhiChu], [MaNV], [MaBan]) VALUES (N'H01', 1, N'1', NULL, N'PV01', N'TS001')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'K01', N'L?u Th?p C?m', 200000, N'Lauthapcam.jpg', N'Lau')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'K02', N'L?u Cá Ðu?i', 100000, N'Laucame.jfif', N'Lau')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'K03', N'L?u Cá Mè', 100000, N'Laucame.jfif', N'Lau')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'K04', N'L?u Bò', 300000, N'1112.png', N'Lau')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'M01', N'Bò Nu?ng', 500000, N'nuong.jfif', N'Nông s?n')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'M02', N'Dê Nu?ng', 500000, N'nuong.jfif', N'Nông s?n')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'M03', N'Gà Lu?c', 200000, N'tải xuống.jfif', N'Nông S?n')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'M04', N'Gà Nu?ng', 300000, N'nuong.jfif', N'Nông s?n')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'M05', N'Gà Chiên M?m', 400000, N'nuong.jfif', N'Nông s?n')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'P01', N'Nho', 50000, N'oc.jfif', N'Tráng Mi?ng')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'P03', N'Cam', 50000, N'oc.jfif', N'Tráng Mi?ng')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'T1', N'Tôm Hùm', 3400000, N'oc.jfif', N'Hai San')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'T2', N'Tôm Alaska', 4400000, N'oc.jfif', N'Hai San')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'T3', N'M?c', 200000, N'oc.jfif', N'Hai San')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'T4', N'Oc', 300000, N'oc.jfif', N'Hai San')
GO
INSERT [dbo].[Menu] ([MaMenu], [Ten], [Gia], [Hinh], [Loai]) VALUES (N'T5', N'Nghêu', 100000, N'tải xuống (1).jfif', N'Hai San')
GO
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [VaiTro]) VALUES (N'PV01', N'123', N'Bùi Tuấn Anh', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [VaiTro]) VALUES (N'PV02', N'123', N'Nguyễn Anh Dũng', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [VaiTro]) VALUES (N'PV03', N'123', N'Đinh Văn Huynh', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [VaiTro]) VALUES (N'PV04', N'123', N'Trần Thị Thanh Ly', 0)
GO
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [VaiTro]) VALUES (N'PV05', N'123', N'Võ Quan Thành', 1)
GO
INSERT [dbo].[NhanVien] ([MaNV], [MatKhau], [TenNV], [VaiTro]) VALUES (N'T1', N'1  ', N'ThucSkin', 1)
GO
ALTER TABLE [dbo].[DonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_DonChiTiet_DonHang] FOREIGN KEY([MaHoaDon])
REFERENCES [dbo].[DonHang] ([MaHoaDon])
GO
ALTER TABLE [dbo].[DonChiTiet] CHECK CONSTRAINT [FK_DonChiTiet_DonHang]
GO
ALTER TABLE [dbo].[DonChiTiet]  WITH CHECK ADD  CONSTRAINT [FK_DonChiTiet_Menu] FOREIGN KEY([MaMenu])
REFERENCES [dbo].[Menu] ([MaMenu])
GO
ALTER TABLE [dbo].[DonChiTiet] CHECK CONSTRAINT [FK_DonChiTiet_Menu]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_Ban] FOREIGN KEY([MaBan])
REFERENCES [dbo].[Ban] ([MaBan])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_Ban]
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD  CONSTRAINT [FK_DonHang_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[DonHang] CHECK CONSTRAINT [FK_DonHang_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [QL_NhaHang1] SET  READ_WRITE 
GO
