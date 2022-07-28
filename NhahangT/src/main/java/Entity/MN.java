/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author PC
 */
public class MN {
    private String MaMenu;
    private String TenMenu;
    private double Gia;
    private String Hinh;
    private String Loai;
    private double khuyenmai;

    public MN() {
    }

    public MN(String MaMenu, String TenMenu, double Gia, String Hinh, String Loai, double khuyenmai) {
        this.MaMenu = MaMenu;
        this.TenMenu = TenMenu;
        this.Gia = Gia;
        this.Hinh = Hinh;
        this.Loai = Loai;
        this.khuyenmai = khuyenmai;
    }

    public String getMaMenu() {
        return MaMenu;
    }

    public void setMaMenu(String MaMenu) {
        this.MaMenu = MaMenu;
    }

    public String getTenMenu() {
        return TenMenu;
    }

    public void setTenMenu(String TenMenu) {
        this.TenMenu = TenMenu;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getLoai() {
        return Loai;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }

    public double getKhuyenmai() {
        return khuyenmai;
    }

    public void setKhuyenmai(double khuyenmai) {
        this.khuyenmai = khuyenmai;
    }
    
    
}
