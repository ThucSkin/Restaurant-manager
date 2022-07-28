/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uitil;

import Entity.NV;
import static java.awt.Color.pink;
import static java.awt.Color.white;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author PC
 */
public class Auth {
        /**
     * Đối tượng này chứa thông tin người sử dụng khi đăng nhập
     */
    public static NV user = null;
    /**
     * Xóa thông tin người sử dụng khi có yêu cầu đăng xuất
     */
    public static void clear(){
        Auth.user = null;
    }
    /**
     * Kiểm tra xem đăng nhập hay chưa
     * @return đăng nhập hay chưa
     */
    public static boolean isLogin(){
        return Auth.user !=null;
    }
    public static boolean isManager(){
        return Auth.isLogin() && user.isVaiTro();
    }
    /**
 * Hiển thị thông báo cho người dùng
 * @param parent là cửa sổ chứa thông báo
 * @param message là thông báo
 */
 public static void alert(Component parent, String message) {
    JOptionPane.showMessageDialog(parent, message,
    "Restaurant Manager", JOptionPane.INFORMATION_MESSAGE);
 }
 public static boolean checkNullText(JTextField txt) {
        txt.setBackground(white);
        if (txt.getText().trim().length() > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            Auth.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
 public static boolean checkNullPass(JPasswordField txt) {
        txt.setBackground(white);
        if (txt.getPassword().length > 0) {
            return true;
        } else {
            txt.setBackground(pink);
            Auth.alert(txt.getRootPane(), "Không được để trống " + txt.getName());
            return false;
        }
    }
}
