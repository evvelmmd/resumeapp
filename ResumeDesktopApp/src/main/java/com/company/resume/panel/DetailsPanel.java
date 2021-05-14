/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.panel;

import DaoInter.CountryDaoInter;
import com.company.resume.Config;
import dao.impl.CountryDaoImpl;
import entity.Country;
import entity.User;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Avval Mammadov
 */
public class DetailsPanel extends javax.swing.JPanel {
    private CountryDaoInter countryDao=new CountryDaoImpl();
      private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    
 public DetailsPanel() {
        initComponents();
    }
    public void fillUserComponents(){
   
        fillWindow();
    User loggedInUser = Config.loggedInUser;
    txtAdress.setText(loggedInUser.getAdress());
    txtPhone.setText(loggedInUser.getPhone());
    txtEmail.setText(loggedInUser.getEmail());
    Date dt=loggedInUser.getBirthdate();
    String dtSdf = sdf.format(dt);
    txtBirthDate.setText(dtSdf);
    
    cbBirthPlace.setSelectedItem(loggedInUser.getBirthplace());
    cbNationality.setSelectedItem(loggedInUser.getNationality());
    }
    
    public void fillUser(User user){
    
       
        String adress = txtAdress.getText();
        String phone = txtPhone.getText();
        String email = txtEmail.getText();
        String birthdate = txtBirthDate.getText();
        Country birthplace= (Country)cbBirthPlace.getSelectedItem();
        Country nationality= (Country)cbNationality.getSelectedItem();
        Date bd;
        
        try {
            bd = new Date(sdf.parse(birthdate).getTime());
            
            user.setBirthdate(bd);
            user.setEmail(email);
            user.setPhone(phone);
            user.setAdress(adress);
            user.setBirthplace(birthplace);
            user.setNationality(nationality);
        } catch (ParseException ex) {    
            ex.printStackTrace(); 
        }
    }
    /**
     * Creates new form DetailsPanel
     */
   
    private void fillWindow(){
       List<Country> countries = countryDao.getAll();  
         for(Country c: countries){
         cbBirthPlace.addItem(c);
    }
         List<Country> nationalities = countryDao.getAll();  
         for(Country n: nationalities){
         cbNationality.addItem(n);
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetails = new javax.swing.JPanel();
        lblAdress = new javax.swing.JLabel();
        txtAdress = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblBirthDate = new javax.swing.JLabel();
        txtBirthDate = new javax.swing.JTextField();
        lblBirthPlace = new javax.swing.JLabel();
        lblNationality = new javax.swing.JLabel();
        cbNationality = new javax.swing.JComboBox<>();
        cbBirthPlace = new javax.swing.JComboBox<>();

        pnlDetails.setBackground(new java.awt.Color(153, 153, 153));

        lblAdress.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblAdress.setText("Adress");
        lblAdress.setToolTipText("Enter your name");

        txtAdress.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtAdress.setForeground(new java.awt.Color(51, 51, 51));

        lblPhone.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblPhone.setText("Phone Number");
        lblPhone.setToolTipText("Enter your name");

        txtPhone.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(51, 51, 51));

        lblEmail.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblEmail.setText("Email");
        lblEmail.setToolTipText("Enter your name");

        txtEmail.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(51, 51, 51));

        lblBirthDate.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBirthDate.setText("Birth Date");
        lblBirthDate.setToolTipText("Enter your name");

        txtBirthDate.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBirthDate.setForeground(new java.awt.Color(51, 51, 51));

        lblBirthPlace.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblBirthPlace.setText("Birth Place");
        lblBirthPlace.setToolTipText("Enter your name");

        lblNationality.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNationality.setText("Nationality");
        lblNationality.setToolTipText("Enter your name");

        cbNationality.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        cbBirthPlace.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        cbBirthPlace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbBirthPlaceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailsLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addComponent(lblPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41))
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addComponent(lblAdress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(56, 56, 56))
                    .addGroup(pnlDetailsLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlDetailsLayout.createSequentialGroup()
                                .addComponent(lblBirthPlace, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(pnlDetailsLayout.createSequentialGroup()
                                .addComponent(lblBirthDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(pnlDetailsLayout.createSequentialGroup()
                                .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(24, 24, 24)))))
                .addGap(18, 18, 18)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAdress, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                    .addComponent(txtPhone)
                    .addComponent(txtEmail)
                    .addComponent(txtBirthDate)
                    .addComponent(cbNationality, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(601, 601, 601))
            .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlDetailsLayout.createSequentialGroup()
                    .addGap(193, 193, 193)
                    .addComponent(cbBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(600, Short.MAX_VALUE)))
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(lblBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDetailsLayout.createSequentialGroup()
                    .addContainerGap(289, Short.MAX_VALUE)
                    .addComponent(cbBirthPlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(134, 134, 134)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 955, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbBirthPlaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbBirthPlaceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbBirthPlaceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Country> cbBirthPlace;
    private javax.swing.JComboBox<Country> cbNationality;
    private javax.swing.JLabel lblAdress;
    private javax.swing.JLabel lblBirthDate;
    private javax.swing.JLabel lblBirthPlace;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtBirthDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
