/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author PC
 */
public class GoiMon {
    private String MaHoaDon;
    private String MaMenu;
    private double Gia;
    private double SoLuong;
    private String MaBan;
    private String TenMon;

    public GoiMon(String MaHoaDon, String MaMenu, double Gia, double SoLuong, String MaBan, String TenMon) {
        this.MaHoaDon = MaHoaDon;
        this.MaMenu = MaMenu;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.MaBan = MaBan;
        this.TenMon = TenMon;
    }

    public GoiMon() {
    }

    public String getMaHoaDon() {
        return MaHoaDon;
    }

    public void setMaHoaDon(String MaHoaDon) {
        this.MaHoaDon = MaHoaDon;
    }

    public String getMaMenu() {
        return MaMenu;
    }

    public void setMaMenu(String MaMenu) {
        this.MaMenu = MaMenu;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public double getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(double SoLuong) {
        this.SoLuong = SoLuong;
    }

    public String getMaBan() {
        return MaBan;
    }

    public void setMaBan(String MaBan) {
        this.MaBan = MaBan;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }
}