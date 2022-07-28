/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Entity.Table;
import Entity.Table;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import uitil.jdbcHelper;
/**
 *
 * @author PC
 */
public class TableDAO extends HomeDAO<Table, String>{
    final String INSERT_SQL="INSERT INTO Ban(MaBan,TenBan) values(?,?)";
    final String UPDATE_SQL= "UPDATE Ban set TenBan=? WHERE MaBan =?";
    final String DELETE_SQL= "DELETE FROM Ban WHERE MaBan=?";
    final String SELECT_ALL_SQL= "SELECT * FROM Ban";
    final String SELECT_BY_ID_SQL= "SELECT * FROM Ban WHERE MaBan=?";
    @Override
    public void insert(Table entity) {
        jdbcHelper.update(INSERT_SQL,entity.getMaBan(),entity.getTenBan());
    }

    @Override
    public void update(Table entity) {
        jdbcHelper.update(UPDATE_SQL,entity.getTenBan(),entity.getMaBan());
    }

    @Override
    public void delete(String id) {
        jdbcHelper.update(DELETE_SQL,id);
    }

    @Override
    public List<Table> selectAll() {
        return selectBySql(SELECT_ALL_SQL);
    }

    @Override
    public Table selectById(String id) {
        List<Table> list = selectBySql(SELECT_BY_ID_SQL, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Table> selectBySql(String sql, Object... args) {
        List<Table> list = new ArrayList<>();
        try {
            ResultSet rs = jdbcHelper.query(sql, args);
            while(rs.next()){
                Table entity = new Table();
                entity.setMaBan(rs.getString("MaBan"));
                entity.setTenBan(rs.getString("TenBan"));
                list.add(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }
    
    
}
