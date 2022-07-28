/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.NV;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import uitil.jdbcHelper;

/**
 *
 * @author PC
 */
public class NhanVienDAO extends HomeDAO<NV, String>{
    final String INSERT_SQL="INSERT INTO NhanVien(MaNV,MatKhau,TenNV,VaiTro) values(?,?,?,?)";
    final String UPDATE_SQL= "UPDATE NhanVien set MatKhau=?,TenNV=?,VaiTro=? WHERE MaNV =?";
    final String DELETE_SQL= "DELETE FROM NhanVien WHERE MaNV=?";
    final String SELECT_ALL_SQL= "SELECT * FROM NhanVien";
    final String SELECT_BY_ID_SQL= "SELECT * FROM NhanVien WHERE MaNV =?";

    @Override
    public void insert(NV entity) {
        jdbcHelper.update(INSERT_SQL, entity.getMaNV(),entity.getMatKhau(),entity.getTenNV(),entity.isVaiTro());
    }

    @Override
    public void update(NV entity) {
        jdbcHelper.update(UPDATE_SQL,entity.getMatKhau(),entity.getTenNV(),entity.isVaiTro(),entity.getMaNV());
    }
    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL,id); 
    }

    @Override
    public List<NV> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public NV selectById(String id) {
        List<NV> list = selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<NV> selectBySql(String sql, Object... args) {
        List<NV> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while(rs.next()){
                NV entity = new NV();
                entity.setMaNV(rs.getString("MaNV"));
                entity.setMatKhau(rs.getString("MatKhau"));
                entity.setTenNV(rs.getString("TenNV"));
                entity.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
}
