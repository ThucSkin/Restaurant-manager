package Entity;



public class DonHang {
    private String MaDonHang,MaNV,Maban;
    private String Date;
    private double Tong;

    public String getMaDonHang() {
        return MaDonHang;
    }

    public String getMaNV() {
        return MaNV;
    }

    public String getMaban() {
        return Maban;
    }

    public String getDate() {
        return Date;
    }

    public double getTong() {
        return Tong;
    }

    public void setMaDonHang(String MaDonHang) {
        this.MaDonHang = MaDonHang;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setMaban(String Maban) {
        this.Maban = Maban;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setTong(double Tong) {
        this.Tong = Tong;
    }
    
    
}
