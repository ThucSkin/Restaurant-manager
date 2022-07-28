package Entity;


public class Oder {
    private String TenBan,MaMon;
    private String TenMon;
    private float Gia;
    private int SoLuong;

    public String getTenBan() {
        return TenBan;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }
    
    public String getTenMon() {
        return TenMon;
    }

    public float getGia() {
        return Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setTenBan(String TenBan) {
        this.TenBan = TenBan;
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    
}
