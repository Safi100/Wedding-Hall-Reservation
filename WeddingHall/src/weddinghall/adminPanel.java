/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package weddinghall;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author safin
 */
public class adminPanel extends javax.swing.JFrame {
    private String username;
    private String email;
    private String password;
    private String role;
    private String package_Type;
    private int Seat_number;
    private String dinner;
    private String photographer;
    private String singing_group;
    private String sweets;
    private int price;
    
    public String getPackage_Type() {
        return package_Type;
    }
    public void setPackage_Type(String package_Type) {
        this.package_Type = package_Type;
    }
    public int getSeat_number() {
        return Seat_number;
    }
    public void setSeat_number(int Seat_number) {
        this.Seat_number = Seat_number;
    }
    public String getDinner() {
        return dinner;
    }
    public void setDinner(String dinner) {
        this.dinner = dinner;
    }
    public String getPhotographer() {
        return photographer;
    }
    public void setPhotographer(String photographer) {
        this.photographer = photographer;
    }
    public String getSinging_group() {
        return singing_group;
    }
    public void setSinging_group(String singing_group) {
        this.singing_group = singing_group;
    }
    public String getSweets() {
        return sweets;
    }
    public void setSweets(String sweets) {
        this.sweets = sweets;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    } 
    public String getRole(){
        return this.role;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setRole(String role){
        this.role = role;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public adminPanel() {
        initComponents();
    }
    // reuse from https://simplifyingtechcode.wordpress.com/2021/10/16/java-password-password-encrypt-decrypt-basic-advanced/
    public String EncryptionPassword(String password){
        Base64.Encoder encoder = Base64.getEncoder();
        String originalString = password;
        String encodedString = encoder.encodeToString(originalString.getBytes());
        return encodedString;
    }
    public void AddNewAdmin(){
        if(usernameText.getText().trim().isEmpty() || emailText.getText().trim().isEmpty() || passwordText.getText().trim().isEmpty()){
            // Display message if some input is null
            JOptionPane.showMessageDialog(null, "الرجاء ادخال جميع الحقول المطلوبة");
        }else{
            // if all inputs not null -> write new user to users file
            this.setUsername(usernameText.getText().trim());
            this.setEmail(emailText.getText().trim());
            this.setPassword(passwordText.getText().trim());
            this.setRole("admin");
            String EncryptionPassword = this.EncryptionPassword(this.getPassword());
            this.setPassword(EncryptionPassword);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt",true));
                writer.write(this.getUsername() + "/"  + this.getEmail() + "/" + this.getPassword() + "/" + this.getRole() + "\n");
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(adminPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            // successfull message
            JOptionPane.showMessageDialog(null, "تم إضافة مسؤول جديد بنجاح");
        }
    }
    public void addNewPackage(){
        try{
            if(packageTypeText.getText().trim().isEmpty() || seat_numberText.getText().trim().isEmpty() || priceText.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "الرجاء ادخال جميع الحقول المطلوبة");
            }else{
                // if all inputs not null -> write new wedding Package to weddingPackages file
                String package_Type = packageTypeText.getText().trim();
                int seat_number = Integer.parseInt(seat_numberText.getText().trim());
                String dinner = dinnerText.getSelectedItem().toString();
                String singing_group = singing_groupText.getSelectedItem().toString();
                String photographer = photographerText.getSelectedItem().toString();
                String sweets = sweetsText.getSelectedItem().toString();
                int price = Integer.parseInt(priceText.getText().trim());
                
                this.setPackage_Type(package_Type);
                this.setSeat_number(seat_number);
                this.setDinner(dinner);
                this.setSinging_group(singing_group);
                this.setPhotographer(photographer);
                this.setSweets(sweets);
                this.setPrice(price);
                
                // add wedding Package to weddingPackages file
                try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("weddingPackages.txt",true));
                writer.write(this.getPackage_Type() + "/"  + this.getSeat_number() + "/" + this.getDinner() + "/" 
                        + this.getSinging_group() + "/" + this.getSinging_group() + "/" + this.getSweets() + "/" + this.getPrice() + "\n");
                writer.close();
                JOptionPane.showMessageDialog(null, "تم إضافة البكج بنجاح");
            } catch (IOException ex) {
                Logger.getLogger(adminPanel.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void logout(){
        this.dispose();
        Login obj = new Login();
        obj.setVisible(true);
    }
    public void goToReview(){
        reviews obj = new reviews();
        obj.setVisible(true);
    }
    public void goToReservationList(){
        ReservationList obj = new ReservationList();
        obj.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        NewAdminBtn = new javax.swing.JButton();
        usernameText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        AddPackageBtn = new javax.swing.JButton();
        packageTypeText = new javax.swing.JTextField();
        seat_numberText = new javax.swing.JTextField();
        priceText = new javax.swing.JTextField();
        P_type = new javax.swing.JLabel();
        Seat_no = new javax.swing.JLabel();
        Dinner = new javax.swing.JLabel();
        Sing = new javax.swing.JLabel();
        photo = new javax.swing.JLabel();
        dinnerText = new javax.swing.JComboBox<>();
        pricee = new javax.swing.JLabel();
        singing_groupText = new javax.swing.JComboBox<>();
        photographerText = new javax.swing.JComboBox<>();
        sweetsText = new javax.swing.JComboBox<>();
        sweet = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JButton();
        ReviewsBtn = new javax.swing.JButton();
        ReservationListBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        headTitle.setText("صفحة المسؤول");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "إضافة مسؤول جديد", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        NewAdminBtn.setText("تسجيل");
        NewAdminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewAdminBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("اسم المستخدم");

        jLabel3.setText("الايميل");

        jLabel4.setText("كلمة المرور");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NewAdminBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(usernameText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                            .addComponent(emailText, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(passwordText))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NewAdminBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "إضافة بكج", javax.swing.border.TitledBorder.RIGHT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        AddPackageBtn.setText("إضافة");
        AddPackageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddPackageBtnActionPerformed(evt);
            }
        });

        P_type.setText("نوع البكج");

        Seat_no.setText("عدد الكراسي");

        Dinner.setText("عشاء");

        Sing.setText("فرقة غناء");

        photo.setText("مصور");

        dinnerText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نعم", "لا" }));

        pricee.setText("السعر");

        singing_groupText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نعم", "لا" }));

        photographerText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نعم", "لا" }));

        sweetsText.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "نعم", "لا" }));

        sweet.setText("حلويات");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(Sing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Dinner))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(Seat_no)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(P_type))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(AddPackageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(singing_groupText, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(sweetsText, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(priceText)
                                    .addComponent(photographerText, 0, 98, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pricee))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(seat_numberText, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dinnerText, 0, 98, Short.MAX_VALUE)
                            .addComponent(packageTypeText)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(sweet, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(photo)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(P_type)
                    .addComponent(Seat_no))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(packageTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat_numberText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Dinner)
                    .addComponent(Sing))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dinnerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(singing_groupText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(photo)
                    .addComponent(sweet))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(photographerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sweetsText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(pricee)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AddPackageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        logoutBtn.setText("تسجيل الخروج");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        ReviewsBtn.setText("عرض التقييم");
        ReviewsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewsBtnActionPerformed(evt);
            }
        });

        ReservationListBtn.setText("عرض سجل الحجز");
        ReservationListBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReservationListBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ReservationListBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ReviewsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ReviewsBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(ReservationListBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(headTitle)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(headTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewAdminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewAdminBtnActionPerformed
        AddNewAdmin();
    }//GEN-LAST:event_NewAdminBtnActionPerformed

    private void AddPackageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddPackageBtnActionPerformed
        addNewPackage();
    }//GEN-LAST:event_AddPackageBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        logout();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void ReviewsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReviewsBtnActionPerformed
        goToReview();
    }//GEN-LAST:event_ReviewsBtnActionPerformed

    private void ReservationListBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReservationListBtnActionPerformed
        goToReservationList();
    }//GEN-LAST:event_ReservationListBtnActionPerformed

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
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddPackageBtn;
    private javax.swing.JLabel Dinner;
    private javax.swing.JButton NewAdminBtn;
    private javax.swing.JLabel P_type;
    private javax.swing.JButton ReservationListBtn;
    private javax.swing.JButton ReviewsBtn;
    private javax.swing.JLabel Seat_no;
    private javax.swing.JLabel Sing;
    private javax.swing.JComboBox<String> dinnerText;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel headTitle;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTextField packageTypeText;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JLabel photo;
    private javax.swing.JComboBox<String> photographerText;
    private javax.swing.JTextField priceText;
    private javax.swing.JLabel pricee;
    private javax.swing.JTextField seat_numberText;
    private javax.swing.JComboBox<String> singing_groupText;
    private javax.swing.JLabel sweet;
    private javax.swing.JComboBox<String> sweetsText;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
