/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entity.DonChiTiet;
import Entity.DonHang;
import Entity.GoiMon;
import Entity.Table;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import uitil.jdbcHelper;
/**
 *
 * @author PC
 */
public class OrderDAO extends HomeDAO<GoiMon, String>{
    final String INSERT_SQL= "INSERT INTO DonHang(MaHoaDon,MaMenu,SoLuong,MaBan) values (?,?,?,?,?)";
    final String UPDATE_SQL= "UPDATE Order set MaMenu=?,SoLuong=?,MaBan=? where MaHoaDon=?";
    final String DELETE_SQL= "DELETE FROM Order where MaHoaDon=?";
    final String SELECT_ALL_SQL= "SELECT * FROM Order";
    final String SELECT_BY_ID_SQL= "SELECT * FROM Order WHERE MaHoaDon =?";
    final String SELECT_KH_SQL= "SELECT * FROM Order WHERE MaMon =?";

    @Override
    public void insert(GoiMon entity) {
        jdbcHelper.update(INSERT_SQL,entity.getMaMenu(),entity.getSoLuong(),entity.getMaBan());
    }

    @Override
    public void update(GoiMon entity) {
        jdbcHelper.update(UPDATE_SQL,entity.getMaMenu(),entity.getSoLuong(),entity.getMaBan(),entity.getMaHoaDon());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<GoiMon> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public GoiMon selectById(String id) {
        List<GoiMon> list = selectBySql(SELECT_BY_ID_SQL,id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<GoiMon> selectBySql(String sql, Object... args) {
       List<GoiMon> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while(rs.next()){
                GoiMon entity = new GoiMon();
                entity.setMaHoaDon(rs.getString("MaHoaDon"));
                entity.setMaMenu(rs.getString("MaMenu"));
                entity.setSoLuong(rs.getDouble("SoLuong"));
                entity.setMaBan(rs.getString("MaBan"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    public ArrayList<Entity.Table>DS(){
      ArrayList<Entity.Table> ds = new ArrayList<>();
       try {
            String sql = "SELECT * FROM Ban";
            ResultSet rs = jdbcHelper.query(sql);
            while(rs.next()){
                Entity.Table entity = new Table();
                entity.setMaBan(rs.getString("MaBan"));
                entity.setTenBan(rs.getString("TenBan"));                
                ds.add(entity);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
        return ds;   
    }
    
    public void inserthoadonchitiet(DonChiTiet dct) throws SQLException{
        String sql = "INSERT INTO DonChiTiet(MaDonHang,MaMenu,Gia,SoLuong,GhiChu)VALUES(?,?,?,?,?)";
        uitil.jdbcHelper.getStmt(sql,dct.getMaDonHang(),dct.getMaMenu(),dct.getGia(),dct.getSoLuong(),dct.getGhiChu()).executeUpdate();        
    }
    public void inserthoadonhang(DonHang dct) throws SQLException{
        String sql = "INSERT INTO DonHang(MaDonHang,MaNV,NgayLap,TongHoaDon,MaBan)VALUES(?,?,?,?,?)";
        uitil.jdbcHelper.getStmt(sql,dct.getMaDonHang(),dct.getMaNV(),dct.getDate(),dct.getTong(),dct.getMaban()).executeUpdate();       
    }
    
    public List<Integer> selectYears(){
        String sql = "SELECT DISTINCT year(NgayLap) Year FROM DonHang ORDER BY Year DESC";
        List<Integer> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql);
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
