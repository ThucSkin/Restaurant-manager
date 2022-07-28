/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uitil;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class MsgBox {
    /**
     * Hien thi thong bao cho nguoi dung
     * @param parent la cua so chua thong bao
     * @param message la thong bao
     */
    public static void alert(Component parent, String message){
        JOptionPane.showMessageDialog(parent, message,"Hệ thống quản lý đào tạo ", JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * Hien thi thong bao va yeu cau nguoi dung xac nhan
     * @param parent la cua so chua thong bao
     * @param message la cau hoi yes/no
     * return la ket qua nhan dc
     */
    public static boolean confirm(Component parent, String message){
        int result = JOptionPane.showConfirmDialog(parent, message,
                "Hệ thống quản lý đào tạo",
        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        return result == JOptionPane.YES_OPTION;
    }
    /**
     * Hiển thị thông báo yêu cầu nhập dữ liệu
     * @param parent la cửa sổ thông báo
     * @param message la thong bao nhac nhở đăng nhập
     * @return la ket qua nhan được tu người sử dụng nhập vào
     */
    public static String prompt(Component parent, String message){
        return JOptionPane.showInputDialog(parent, message,"Hệ thống quản lý đào tạo",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
