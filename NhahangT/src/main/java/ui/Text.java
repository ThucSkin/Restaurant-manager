/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import DAO.NhanVienDAO;
import Entity.NV;

import ui.NhanVien;
import java.util.List;
import java.util.ArrayList;
import Entity.Nhanvien;

/**
 *
 * @author PC
 */
public class Text {
    public static void main(String[] args) {
        NhanVienDAO dao = new NhanVienDAO();
        List<NV> ls = dao.selectAll();
        for (NV nv : ls){
            if(nv.isVaiTro()){
                  System.out.println("Qly");
            }
            
            System.out.println(">>"+nv.getTenNV()+nv.getMatKhau()+">>");
        }
}
}
