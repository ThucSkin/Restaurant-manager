/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entity.MN;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import uitil.jdbcHelper;
import java.util.List;
/**
 *
 * @author PC
 */
public class MenuDAO extends HomeDAO<MN, String>{
    final String INSERT_SQL= "INSERT INTO Menu(MaMenu,Ten,Gia,Hinh,Loai) values(?,?,?,?,?)";
    final String UPDATE_SQL= "UPDATE Menu set Ten=?, Gia=?, Hinh=?,Loai=? WHERE MaMenu =?";
    final String DELETE_SQL= "DELETE FROM Menu WHERE MaMenu=?";
    final String SELECT_ALL_SQL= "SELECT * FROM Menu";
    final String SELECT_BY_ID_SQL= "SELECT * FROM Menu WHERE MaMenu =?";

    @Override
    public void insert(MN entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaMenu(),entity.getTenMenu()
                ,entity.getGia(),entity.getHinh(),entity.getLoai());
    }

    @Override
    public void update(MN entity) {
        jdbcHelper.update(UPDATE_SQL,entity.getTenMenu()
                ,entity.getGia(),entity.getHinh(),entity.getLoai(),entity.getMaMenu());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<MN> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public MN selectById(String id) {
        List<MN> list = selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<MN> selectBySql(String sql, Object... args) {
        List<MN> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while(rs.next()){
                MN entity = new MN();
                entity.setMaMenu(rs.getString("MaMenu"));
                entity.setTenMenu(rs.getString("Ten"));
                entity.setGia(rs.getDouble("Gia"));
                entity.setHinh(rs.getString("Hinh"));
                entity.setLoai(rs.getString("Loai"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}