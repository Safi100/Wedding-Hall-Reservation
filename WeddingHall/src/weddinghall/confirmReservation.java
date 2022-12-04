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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author safin
 */
public class confirmReservation extends javax.swing.JFrame {
    private String UserName;
    private String ReservationDate;
    private String package_Type;
    private int Seat_number;
    private String dinner;
    private String photographer;
    private String singing_group;
    private String sweets;
    private int price;
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
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
    
    public String getReservationDate() {
        return ReservationDate;
    }
    public void setReservationDate(String ReservationDate) {
        this.ReservationDate = ReservationDate;
    }
    /**
     * Creates new form confirmReservation
     */
    public confirmReservation() {
        initComponents();
        writeToTable();
    }
    
    public void writeToTable(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("weddingPackages.txt"));
            DefaultTableModel model = (DefaultTableModel)packagesTable.getModel();
            Object[] tableLines = reader.lines().toArray();
            for(int i=0;i< tableLines.length; i++){
                String packagee = tableLines[i].toString().trim();
                String[] dataRow = packagee.split("/");
                model.addRow(dataRow);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(reviews.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(reviews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ConfirmReservation(){
        try{
            int index = packagesTable.getSelectedRow();
            TableModel model = packagesTable.getModel();
            String packageType = model.getValueAt(index, 0).toString();
            int number_of_seats = Integer.parseInt(model.getValueAt(index, 1).toString());
            String Dinner = model.getValueAt(index, 2).toString();
            String Photographer = model.getValueAt(index, 3).toString();
            String singingGroup = model.getValueAt(index, 4).toString();
            String Sweets = model.getValueAt(index, 5).toString();
            int Price = Integer.parseInt(model.getValueAt(index, 6).toString());
            // set values for attrubites
            this.setPackage_Type(packageType);
            this.setSeat_number(number_of_seats);
            this.setDinner(Dinner);
            this.setPhotographer(Photographer);
            this.setSinging_group(singingGroup);
            this.setSweets(Sweets);
            this.setPrice(Price);
            this.setReservationDate(ReservationDateText.getText().trim());
            this.setUserName(userNameText.getText().trim());
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("Reservations.txt",true));
                writer.write(this.getUserName() + "/" + this.getReservationDate() + "/" + this.getPackage_Type() + "/" +
                        this.getSeat_number() + "/" + this.getDinner() + "/" + this.getSinging_group() + "/" +
                        this.getPhotographer() + "/" + this.getSweets() + "/" + this.getPrice() + "\n");
                writer.close();
                home obj = new home();
                this.setVisible(false);
                this.setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(confirmReservation.class.getName()).log(Level.SEVERE, null, ex);
            }
            // successfull message
            JOptionPane.showMessageDialog(null, "تم حجز قاعة بنجاح");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void cancel(){
        home obj = new home();
        obj.UserName.setText(this.userNameText.getText());
        obj.setVisible(true);
        this.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        packagesTable = new javax.swing.JTable();
        confirmReservationBtn = new javax.swing.JButton();
        note = new javax.swing.JLabel();
        note_two = new javax.swing.JLabel();
        HeadLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        ReservationDateText = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        userNameText = new javax.swing.JLabel();
        cancelBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        packagesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "نوع المناسبة", "عدد الكراسي", "عشاء", "فرقة غناء", "مصور", "حلويات", "السعر"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(packagesTable);

        confirmReservationBtn.setText("تأكيد الحجز");
        confirmReservationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmReservationBtnActionPerformed(evt);
            }
        });

        note.setText("ملاحظة : هذه البكجات موفرة من القاعة، بإمكانك احضار مصورك الخاص والفرقة بنفسك");

        note_two.setText("اذا كنت تريد بكج مخصص تواصل مع صفحتنا على الفيسبوك للاتفاق على السعر");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(note, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(note_two, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addComponent(confirmReservationBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmReservationBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(note)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(note_two)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        HeadLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        HeadLabel.setText("Reservation");

        date.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        date.setText("التاريخ الذي تود الحجز فيه :");

        ReservationDateText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        name.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        name.setText("الاسم :");

        userNameText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        cancelBtn.setText("الغاء");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ReservationDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(date))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(userNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(name)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(name)
                                .addGap(0, 3, Short.MAX_VALUE))
                            .addComponent(userNameText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(ReservationDateText, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addComponent(date)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HeadLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(16, 16, 16))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HeadLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmReservationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmReservationBtnActionPerformed
        ConfirmReservation();
    }//GEN-LAST:event_confirmReservationBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        cancel();
    }//GEN-LAST:event_cancelBtnActionPerformed

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
            java.util.logging.Logger.getLogger(confirmReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(confirmReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(confirmReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(confirmReservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new confirmReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HeadLabel;
    public javax.swing.JLabel ReservationDateText;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JButton confirmReservationBtn;
    private javax.swing.JLabel date;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel note;
    private javax.swing.JLabel note_two;
    private javax.swing.JTable packagesTable;
    public javax.swing.JLabel userNameText;
    // End of variables declaration//GEN-END:variables
}
