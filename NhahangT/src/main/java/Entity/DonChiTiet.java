package Entity;


public class DonChiTiet {
    private String MaDonHang,MaMenu,GhiChu;
    private int SoLuong;
    private double Gia;

    public String getMaDonHang() {
        return MaDonHang;
    }

    public String getMaMenu() {
        return MaMenu;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public double getGia() {
        return Gia;
    }

    public void setMaDonHang(String MaDonHang) {
        this.MaDonHang = MaDonHang;
    }

    public void setMaMenu(String MaMenu) {
        this.MaMenu = MaMenu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setGia(double Gia) {
        this.Gia = Gia;
    }
    
    
}
