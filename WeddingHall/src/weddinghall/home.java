/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package weddinghall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author safin
 */
public class home extends javax.swing.JFrame {
    private String review_text;
    private int review_stars;
    private Date PresentDate;
    private Date ChosenDate;
    
    public int getReview_stars() {
        return review_stars;
    }

    public Date getPresentDate() {
        return PresentDate;
    }

    public void setPresentDate(Date PresentDate) {
        this.PresentDate = PresentDate;
    }

    public Date getChoosenDate() {
        return ChosenDate;
    }

    public void setChoosenDate(Date ChosenDate) {
        this.ChosenDate = ChosenDate;
    }
    public void setReview_stars(int review_stars) {
        this.review_stars = review_stars;
    }
    public String getReviewText(){
        return this.review_text;
    }
    public void setReviewText(String review_text){
        this.review_text = review_text;
    }
    
    public home() {
        initComponents();
        writeToTable();
    }
    public void writeToTable(){
        try {
            SimpleDateFormat dateForm = new SimpleDateFormat("dd-MM-YYYY");
            Date PresentDateTemporary = new Date();
            this.setPresentDate(PresentDateTemporary);
            String PresentDateFormatted = dateForm.format(this.getPresentDate());
            
            BufferedReader reader = new BufferedReader(new FileReader("Reservations.txt"));
            DefaultTableModel model = (DefaultTableModel)reservedDate.getModel();
            Object[] tableLines = reader.lines().toArray();
            for(int i=0;i< tableLines.length; i++){
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("/");
                String[] date = new String[1];
                date[0] = dataRow[1]; // date[0] is a date are reserved by users
                if(this.ReservedValidDate(PresentDateFormatted, date[0])){
                    model.addRow(date);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(reviews.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(reviews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    boolean ReservedValidDate(String PresentDateFormated, String ChosenDateFormated){
        try{
            String[] ChosenDateArray = ChosenDateFormated.split("-");
            int ChosenDay = Integer.parseInt(ChosenDateArray[0]);
            int ChosenMonth = Integer.parseInt(ChosenDateArray[1]);
            int ChosenYear = Integer.parseInt(ChosenDateArray[2]);
            String[] PresentDateArray = PresentDateFormated.split("-");
            int PresentDay = Integer.parseInt(PresentDateArray[0]);
            int PresentMonth = Integer.parseInt(PresentDateArray[1]);
            int PresentYear = Integer.parseInt(PresentDateArray[2]);
            if(ChosenYear < PresentYear){
            }else{
                 if(ChosenMonth < PresentMonth){
                 }else{
                     if(ChosenDay <= PresentDay){
                     }else{
                         return true;
                     }
                 }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    public void Review(){
        if(reviewTextArea.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(null,"الرجاء ادخال ملاحظاتك");
        }else{
            String review_stars_text = stars.getSelectedItem().toString();
            String review_text_area = reviewTextArea.getText().trim();
            this.setReviewText(review_text_area);
            switch(review_stars_text){
                case "5 نجوم" :
                    this.setReview_stars(5);
                break;
                case "4 نجوم" :
                    this.setReview_stars(4);
                break;
                case "3 نجوم" :
                    this.setReview_stars(3);
                break;
                case "نجمتان" :
                    this.setReview_stars(2);
                break;
                case "نجمة" :
                    this.setReview_stars(1);
                break;
            }
        // write to reviews file
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("review.txt",true));
            writer.write(this.getReview_stars() + "/" + this.getReviewText() + "\n");
            writer.close();
            JOptionPane.showMessageDialog(null, "تم التقييم بنجاح\nشكرا لك ");
        } catch (IOException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    }
    boolean isValidDate(String PresentDateFormated, String ChosenDateFormated){
        try{
            String[] ChosenDateArray = ChosenDateFormated.split("-");
            int ChosenDay = Integer.parseInt(ChosenDateArray[0]);
            int ChosenMonth = Integer.parseInt(ChosenDateArray[1]);
            int ChosenYear = Integer.parseInt(ChosenDateArray[2]);
            String[] PresentDateArray = PresentDateFormated.split("-");
            int PresentDay = Integer.parseInt(PresentDateArray[0]);
            int PresentMonth = Integer.parseInt(PresentDateArray[1]);
            int PresentYear = Integer.parseInt(PresentDateArray[2]);
            if(ChosenYear < PresentYear){
                 throw new Exception("من فضلك اختر سنة لم تنتهي");
            }else{
                 if(ChosenMonth < PresentMonth){
                     throw new Exception("من فضلك اختر شهر لم ينتهي");
                 }else{
                     if(ChosenDay <= PresentDay){
                         throw new Exception("من فضلك اختر يوم لم ينتهي");
                     }else{
                         return true;
                     }
                 }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return false;
    }
    public boolean isUnusedDate(String ChosenDateFormated){
        DefaultTableModel model = (DefaultTableModel)reservedDate.getModel();
        int rowCount = reservedDate.getRowCount();
        System.out.println(rowCount);
        boolean flag = true;
        for(int i=0; i<rowCount; i++){
            String reservedDate_Var = reservedDate.getValueAt(i, 0).toString();
            if(ChosenDateFormated.equals(reservedDate_Var)){
                flag = false;
                break;
            }else{
                flag = true;
            }
        }
        return flag;
    }
    public void Reservation(){
        try{
            SimpleDateFormat dateForm = new SimpleDateFormat("dd-MM-YYYY");
            String ChosenDateFormatted = dateForm.format(Date_for_reservation.getDate());
            String PresentDateFormatted = dateForm.format(this.getPresentDate());
            
            this.setChoosenDate(Date_for_reservation.getDate());
            Date todayDate = new Date();
            this.setPresentDate(todayDate);
            // Check if valid date
            boolean isValidDate = this.isValidDate(PresentDateFormatted, ChosenDateFormatted);
            boolean isUnusedDate = this.isUnusedDate(ChosenDateFormatted);
            if(isValidDate == true){
                if(isUnusedDate == true){
                    confirmReservation obj = new confirmReservation();
                    obj.ReservationDateText.setText(dateForm.format(Date_for_reservation.getDate()));
                    obj.userNameText.setText(this.UserName.getText());
                    obj.setVisible(true);
                    this.setVisible(false);
                }else{
                    throw new Exception("عذرا\nهذا التاريخ محجوز من قبل");
                }
            }

        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void Logout(){
        this.dispose();
        Login obj = new Login();
        obj.setVisible(true);
    }
    public void openReview(){
        reviews obj = new reviews();
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

        headLabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        reservedDate = new javax.swing.JTable();
        TableLabelHead = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ReviewQuestion = new javax.swing.JLabel();
        stars = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        reviewTextArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        ReviewBtnPage = new javax.swing.JButton();
        submitReview = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Date_for_reservation = new com.toedter.calendar.JDateChooser();
        reservevationBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        UserName1 = new javax.swing.JLabel();
        UserName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        headLabel.setText("Wedding Hall Reservation");

        reservedDate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "تاريخ الحجوزات"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(reservedDate);
        if (reservedDate.getColumnModel().getColumnCount() > 0) {
            reservedDate.getColumnModel().getColumn(0).setResizable(false);
        }

        TableLabelHead.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        TableLabelHead.setText("التواريخ التي لا يمكن الحجز فيها - (محجوزة)");

        ReviewQuestion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ReviewQuestion.setText("ما هو تقييمك لنا ؟");

        stars.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "5 نجوم", "4 نجوم", "3 نجوم", "نجمتان", "نجمة" }));
        stars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                starsActionPerformed(evt);
            }
        });

        reviewTextArea.setColumns(20);
        reviewTextArea.setRows(5);
        jScrollPane2.setViewportView(reviewTextArea);

        jLabel4.setText("ملاحظاتك");

        ReviewBtnPage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ReviewBtnPage.setText("عرض تقييم الزبائن");
        ReviewBtnPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReviewBtnPageActionPerformed(evt);
            }
        });

        submitReview.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        submitReview.setText("تقييم");
        submitReview.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitReviewActionPerformed(evt);
            }
        });

        jLabel5.setText("اختر تاريخ للحجز");

        reservevationBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        reservevationBtn.setText("حجز");
        reservevationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservevationBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(reservevationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(Date_for_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(stars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ReviewQuestion))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ReviewBtnPage)
                .addGap(18, 18, 18)
                .addComponent(submitReview, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Date_for_reservation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(reservevationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ReviewQuestion)
                    .addComponent(stars, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitReview, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ReviewBtnPage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logoutBtn.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        logoutBtn.setText("تسجيل خروج");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TableLabelHead)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TableLabelHead)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        UserName1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UserName1.setText("Welcome");

        UserName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        UserName.setText("الاسم");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UserName1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserName, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(headLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(headLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(UserName1)
                            .addComponent(UserName))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReviewBtnPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReviewBtnPageActionPerformed
        openReview();
    }//GEN-LAST:event_ReviewBtnPageActionPerformed

    private void submitReviewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitReviewActionPerformed
        Review();
    }//GEN-LAST:event_submitReviewActionPerformed

    private void reservevationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservevationBtnActionPerformed
        Reservation();
    }//GEN-LAST:event_reservevationBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        Logout();
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void starsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_starsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_starsActionPerformed

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
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Date_for_reservation;
    private javax.swing.JButton ReviewBtnPage;
    private javax.swing.JLabel ReviewQuestion;
    private javax.swing.JLabel TableLabelHead;
    public javax.swing.JLabel UserName;
    public javax.swing.JLabel UserName1;
    private javax.swing.JLabel headLabel;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JTable reservedDate;
    private javax.swing.JButton reservevationBtn;
    private javax.swing.JTextArea reviewTextArea;
    private javax.swing.JComboBox<String> stars;
    private javax.swing.JButton submitReview;
    // End of variables declaration//GEN-END:variables
}
