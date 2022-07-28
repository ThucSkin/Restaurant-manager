/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author PC
 */
public class Nhanvien {
    private String maNV;
    private String TenNV;
    private String matKhau;
    private boolean vaiTro;

    public Nhanvien() {
    }

    public Nhanvien(String maNV, String TenNV, String matKhau, boolean vaiTro) {
        this.maNV = maNV;
        this.TenNV = TenNV;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }
    @Override
    public String toString() {
        return this.TenNV;
    }
    
}
