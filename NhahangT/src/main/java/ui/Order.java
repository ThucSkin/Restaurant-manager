/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package ui;

import DAO.MenuDAO;
import DAO.OrderDAO;
import Entity.DonChiTiet;
import Entity.DonHang;
import Entity.Oder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import uitil.MsgBox;
import Entity.MN;
import java.awt.Color;
import javax.swing.JButton;
import Entity.GoiMon;
import java.util.ArrayList;
import Entity.Table;
import java.lang.Math;
import java.sql.SQLException;
import java.util.regex.MatchResult;
/**
 *
 * @author PC
 */
public class Order extends javax.swing.JDialog {
    MenuDAO dao = new MenuDAO();
    OrderDAO daoo = new OrderDAO();
    MN list = new MN();
    static DonHang DH = new DonHang();
    ArrayList<Oder> goi = new ArrayList<>();
    String tenban = null;
    DecimalFormat tienFormat = new DecimalFormat("###,###,###");
    /**
     * Creates new form Order
     */
    public Order(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        fillTable();
        txtTong.setText("0"); 
        txtTong.setEditable(false);
    }
    String id(){
      double randomd = Math.random();
      randomd = randomd*99998+1;
      int random = (int) randomd;
      return "DH"+random;             
    }
    
    void insertDH(){
        SimpleDateFormat fr= new SimpleDateFormat("yyyy-MM-dd");
        Date x = new Date();       
        DH.setMaDonHang(id());
        DH.setDate(fr.format(x));
        DH.setMaNV(uitil.Auth.user.getMaNV());
        ArrayList<Entity.Table>list = daoo.DS();
        for(int i=0;i<list.size();++i){
            Entity.Table ban = list.get(i);
            if (tenban.equalsIgnoreCase(ban.getTenBan())){
                DH.setMaban(ban.getMaBan());
            }
        }
        DH.setTong(Double.parseDouble(txtTong.getText().replace(",","").replace("VND","")));
    }
    void DHCT() throws SQLException{
        for(int i=0;i<tblOrder.getRowCount();++i){
            Entity.DonChiTiet ds = new DonChiTiet();
            ds.setMaDonHang(DH.getMaDonHang());
            ds.setMaMenu(tblOrder.getValueAt(i,3).toString());
            ds.setGia(Double.parseDouble(tblOrder.getValueAt(i,1).toString()));
            ds.setSoLuong(Integer.parseInt(tblOrder.getValueAt(i,2).toString()));
            ds.setGhiChu("null");
            daoo.inserthoadonchitiet(ds);
        }      
    }
    
    void clean(){
         for(int i=0;i<goi.size();i++){
            Oder x = goi.get(i);
            if(tenban.equalsIgnoreCase(x.getTenBan())){
                goi.remove(i);
                --i;
            }
         }
        fillTableOd();
    }
       
    void oder(){
        Oder ds = new Oder();
        ds.setTenBan(tenban);
        ds.setMaMon(txtMaMon.getText());
        ds.setTenMon(txtTenMon.getText());
        ds.setGia(Float.parseFloat(txtGia.getText()));
        ds.setSoLuong(Integer.parseInt(cbxSoLuong.getSelectedItem().toString())); 
        goi.add(ds);
    }
    
    float tinhtien(){
        float tong = 0;
        for(int i=0;i<tblOrder.getRowCount();++i){
           float gia = Float.valueOf(tblOrder.getValueAt(i,1).toString());
           float Soluong = Float.parseFloat(tblOrder.getValueAt(i,2).toString());
           tong += gia*Soluong;
        }
        return tong;
    }
    
    void fillTable(){
        DefaultTableModel model = (DefaultTableModel) tblMenu.getModel();
        model.setRowCount(0);
        try {
            List<MN> list = dao.selectAll();
            for(MN mn: list){
                Object[] row = {
                    mn.getMaMenu(),
                    mn.getTenMenu(),
                    mn.getGia(),
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void fillTableOd(){
        DefaultTableModel model = (DefaultTableModel) tblOrder.getModel();
        model.setRowCount(0);
        try {           
            for(Oder gm : goi){
                if(tenban.equalsIgnoreCase(gm.getTenBan())){
                  Object[] row = {gm.getTenMon(),gm.getGia(),gm.getSoLuong(),gm.getMaMon()};
                  model.addRow(row);
                  txtban.setText(gm.getTenBan());
                  tblOrder.setModel(model);
                }                              
            }
            txtTong.setText(tienFormat.format(tinhtien())+" VND");
        } catch (Exception e) {
            MsgBox.alert(this,"Chưa chọn bàn!");
        }
    }
    void setForm(GoiMon model){
        txtMaMon.setText(model.getMaMenu());
        txtGia.setText(String.valueOf(model.getGia()));
        cbxSoLuong.setSelectedIndex((int) model.getSoLuong());
    }
    GoiMon getForm(){
        GoiMon model = new GoiMon();
        model.setMaMenu(txtMaMon.getText());
        model.setGia(Double.parseDouble(txtGia.getText()));
        model.setSoLuong(Integer.valueOf(cbxSoLuong.getToolTipText())); 
        return model;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnBan1 = new javax.swing.JButton();
        btnBan2 = new javax.swing.JButton();
        btnBan4 = new javax.swing.JButton();
        btnBan5 = new javax.swing.JButton();
        btnBan3 = new javax.swing.JButton();
        btnBan6 = new javax.swing.JButton();
        btnBan7 = new javax.swing.JButton();
        btnBan8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMenu = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenMon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbxSoLuong = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtTong = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtMaMon = new javax.swing.JTextField();
        txtban = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Danh sách bàn");

        jPanel1.setBackground(new java.awt.Color(0, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBan1.setBackground(new java.awt.Color(255, 255, 255));
        btnBan1.setText("Bàn 1");
        btnBan1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan1ActionPerformed(evt);
            }
        });

        btnBan2.setBackground(new java.awt.Color(255, 255, 255));
        btnBan2.setText("Bàn 2");
        btnBan2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan2ActionPerformed(evt);
            }
        });

        btnBan4.setBackground(new java.awt.Color(255, 255, 255));
        btnBan4.setText("Ban4");
        btnBan4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan4ActionPerformed(evt);
            }
        });

        btnBan5.setBackground(new java.awt.Color(255, 255, 255));
        btnBan5.setText("Bàn 5");
        btnBan5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan5ActionPerformed(evt);
            }
        });

        btnBan3.setBackground(new java.awt.Color(255, 255, 255));
        btnBan3.setText("Bàn 3");
        btnBan3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan3ActionPerformed(evt);
            }
        });

        btnBan6.setBackground(new java.awt.Color(255, 255, 255));
        btnBan6.setText("Bàn 6");
        btnBan6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBan6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan6ActionPerformed(evt);
            }
        });

        btnBan7.setBackground(new java.awt.Color(255, 255, 255));
        btnBan7.setText("Bàn 7");
        btnBan7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBan7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan7ActionPerformed(evt);
            }
        });

        btnBan8.setBackground(new java.awt.Color(255, 255, 255));
        btnBan8.setText("Bàn 8");
        btnBan8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBan8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBan8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBan2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBan3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBan4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBan5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBan6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBan7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBan8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBan2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBan3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBan4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBan5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBan6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBan7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBan8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(232, Short.MAX_VALUE))
        );

        tblMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã", "Tên", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMenuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblMenu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Menu");

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên món", "Giá", "Số lượng", "Mã"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblOrder);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );

        jLabel3.setText("Món đã gọi");

        jLabel4.setText("Tên món");

        jLabel5.setText("Giá");

        jLabel6.setText("Số lượng");

        cbxSoLuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", " " }));

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel7.setText("Tổng tiền ");

        btnThanhToan.setBackground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Dollar.png"))); // NOI18N
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel8.setText("Mã món");

        txtban.setText("Ban");
        txtban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                none(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(195, 195, 195)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenMon)
                                    .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                    .addComponent(cbxSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMaMon))))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel7)
                        .addGap(26, 26, 26)
                        .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(139, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtban, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(337, 337, 337)
                .addComponent(btnThanhToan)
                .addGap(163, 163, 163))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addComponent(txtban)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtTong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtMaMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txtTenMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThanhToan)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMenuMouseClicked
        // TODO add your handling code here:
        try {
            int row = tblMenu.getSelectedRow();
            if(row >= 0){
            String id = (String) tblMenu.getValueAt(row, 0);
            MenuDAO dao = new MenuDAO();
            MN sv = dao.selectById(id);
            if(sv != null){
                txtMaMon.setText(sv.getMaMenu());
                txtTenMon.setText(sv.getTenMenu());
                txtGia.setText(String.valueOf(sv.getGia()));
            }
            
            
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblMenuMouseClicked
    void check(){
        if (btnBan1.getText().equals(tenban)){
            if (tblOrder.getRowCount()!=0){
                btnBan1.setBackground(Color.yellow);
            }else{btnBan1.setBackground(Color.white);}
        }else if(btnBan2.getText().equals(tenban)){
            if (tblOrder.getRowCount()!=0){btnBan2.setBackground(Color.red);}else{btnBan2.setBackground(Color.white);}
        }else if(btnBan3.getText().equals(tenban)){
            if (tblOrder.getRowCount()!=0){btnBan3.setBackground(Color.red);}else{btnBan3.setBackground(Color.white);}
        }else if(btnBan4.getText().equals(tenban)){
            if (tblOrder.getRowCount()!=0){btnBan4.setBackground(Color.red);}else{btnBan4.setBackground(Color.white);}
        }else if(btnBan5.getText().equals(tenban)){
            if (tblOrder.getRowCount()!=0){btnBan5.setBackground(Color.red);}else{btnBan5.setBackground(Color.white);}
        }else if(btnBan6.getText().equals(tenban)){
            if (tblOrder.getRowCount()!=0){btnBan6.setBackground(Color.red);}else{btnBan6.setBackground(Color.white);}
        }else if(btnBan7.getText().equals(tenban)){
            if (tblOrder.getRowCount()!=0){btnBan7.setBackground(Color.red);}else{btnBan7.setBackground(Color.white);}
        }else if(btnBan8.getText().equals(tenban)){
            if (tblOrder.getRowCount()!=0){btnBan8.setBackground(Color.red);}else{btnBan8.setBackground(Color.white);}
        }
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
           oder();
           fillTableOd();
            check();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnBan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan1ActionPerformed
        tenban = "Bàn 1";
        txtban.setText(tenban);
        tblMenu.clearSelection();
        fillTableOd();
        check();
    }//GEN-LAST:event_btnBan1ActionPerformed

    private void btnBan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan2ActionPerformed
        tenban = "Bàn 2";
        txtban.setText(tenban);
        tblMenu.clearSelection();
        fillTableOd();
    }//GEN-LAST:event_btnBan2ActionPerformed

    private void btnBan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan3ActionPerformed
        tenban = "Bàn 3";
        txtban.setText(tenban);
        tblMenu.clearSelection();
        fillTableOd();
    }//GEN-LAST:event_btnBan3ActionPerformed

    private void btnBan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan4ActionPerformed
        tenban = "Bàn 4";
        txtban.setText(tenban);
        tblMenu.clearSelection();
        fillTableOd();
    }//GEN-LAST:event_btnBan4ActionPerformed

    private void btnBan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan5ActionPerformed
        // TODO add your handling code here:
        tenban = "Bàn 5";
        txtban.setText(tenban);
        tblMenu.clearSelection();
        fillTableOd();
    }//GEN-LAST:event_btnBan5ActionPerformed

    private void btnBan6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan6ActionPerformed
        // TODO add your handling code here:
        tenban = "Bàn 6";
        txtban.setText(tenban);
        tblMenu.clearSelection();
        fillTableOd();
    }//GEN-LAST:event_btnBan6ActionPerformed

    private void btnBan7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan7ActionPerformed
        // TODO add your handling code here:
        tenban = "Bàn 7";
        txtban.setText(tenban);
        tblMenu.clearSelection();
        fillTableOd();
    }//GEN-LAST:event_btnBan7ActionPerformed

    private void btnBan8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBan8ActionPerformed
        // TODO add your handling code here:
        tenban = "Bàn 8";
        txtban.setText(tenban);
        tblMenu.clearSelection();
        fillTableOd();
    }//GEN-LAST:event_btnBan8ActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        try {
            insertDH();
            daoo.inserthoadonhang(DH);
            DHCT();
            clean();           
            check();
            MsgBox.alert(this,"Thanh Toán Thành Công");
        } catch (Exception e) {
            MsgBox.alert(this, "Lỗi");
            System.err.println(e);
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void none(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Order dialog = new Order(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBan1;
    private javax.swing.JButton btnBan2;
    private javax.swing.JButton btnBan3;
    private javax.swing.JButton btnBan4;
    private javax.swing.JButton btnBan5;
    private javax.swing.JButton btnBan6;
    private javax.swing.JButton btnBan7;
    private javax.swing.JButton btnBan8;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbxSoLuong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblMenu;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaMon;
    private javax.swing.JTextField txtTenMon;
    private javax.swing.JTextField txtTong;
    private javax.swing.JLabel txtban;
    // End of variables declaration//GEN-END:variables
}
