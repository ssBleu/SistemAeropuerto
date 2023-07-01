
package Vista;

import Modelo.Aerolinea;
import static Vista.Controladores.objAD;
import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmRegAero extends javax.swing.JFrame {

    public frmRegAero() {
        initComponents();
    listado();
    }
    void listado(){
        DefaultTableModel dt=(DefaultTableModel)jTable1.getModel();
        
        dt.setRowCount(0);
        for(Aerolinea x:objAD.Listado()){
            Object v[]={x.getIdAerolinea(),x.getNombre(),x.getPaisOrigen(),x.getTelefono(),x.getPaginaWeb(),x.getFechaFundacion()};
            dt.addRow(v);
        }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtPagina = new javax.swing.JTextField();
        txtPais = new javax.swing.JTextField();
        DCDate = new com.toedter.calendar.JDateChooser();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        btnBusCli2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnReVue2 = new javax.swing.JLabel();
        btnReAero2 = new javax.swing.JLabel();
        btnReTra2 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        btnEstadis2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel2.setText("x");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("REGISTROS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(259, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(202, 202, 202)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addComponent(jLabel6)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ID Aerolínea:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nombre:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("País de Origen:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Año de fundación:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Aerolínea", "Nombre", "Origen", "Telefono", "Pagina Web", "Fecha fundación"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 580, 180));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 170, -1));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 160, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("AEROLÍNEA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 80, -1));

        jButton2.setText("Actualizar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 80, -1));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 170, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Teléfono:");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Pagina web:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 20));

        txtPagina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaginaActionPerformed(evt);
            }
        });
        jPanel1.add(txtPagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 170, -1));

        txtPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaisActionPerformed(evt);
            }
        });
        jPanel1.add(txtPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 170, -1));

        DCDate.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(DCDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 180, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 620, 420));

        jPanel6.setBackground(new java.awt.Color(102, 153, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario (1).png"))); // NOI18N

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));

        btnBusCli2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBusCli2.setText("    Busqueda de Cliente");
        btnBusCli2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusCli2MouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscli (1).png"))); // NOI18N

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retra (1).png"))); // NOI18N

        btnReVue2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReVue2.setText("     Registro de Vuelo");
        btnReVue2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReVue2MouseClicked(evt);
            }
        });

        btnReAero2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReAero2.setText("   Registro de Aerolínea");
        btnReAero2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReAero2MouseClicked(evt);
            }
        });

        btnReTra2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReTra2.setText("  Registro de Trabajador");
        btnReTra2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReTra2MouseClicked(evt);
            }
        });

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estadis (1).png"))); // NOI18N

        btnEstadis2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEstadis2.setText("            Estadísticas");
        btnEstadis2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstadis2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btnBusCli2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator10)
            .addComponent(btnReVue2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReAero2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReTra2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
            .addComponent(btnEstadis2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel19)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBusCli2)
                .addGap(17, 17, 17)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReVue2)
                .addGap(11, 11, 11)
                .addComponent(btnReAero2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReTra2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstadis2)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(frmLogin.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?","EXIT",dialogButton);
        if(result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
        int codigo = Integer.parseInt(txtID.getText());
        String nombre =txtNombre.getText();
        String paisOrigen =txtPais.getText();
        String telefono =txtTelefono.getText();
        String paginaWeb =txtPagina.getText();
        
        JDateChooser dateChooser = DCDate; // Asigna el JDateChooser a una variable
        Date fechaFundacion = dateChooser.getDate(); // Obtiene la fecha seleccionada
        if(nombre.length()>0){
            if(codigo>0){
         Aerolinea pr=new Aerolinea(codigo,nombre,paisOrigen,telefono,paginaWeb, fechaFundacion);
          objAD.crearAerolinea(pr);
                txtID.setText("");
                txtNombre.setText("");
                txtPais.setText("");
                txtTelefono.setText("");
                txtPagina.setText("");
                DCDate.setDate(null);
                listado();
               JOptionPane.showMessageDialog(null, "Aerolinea agregada correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "El codigo debe ser mayor a 0");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre");
        }
        } catch (Exception e1){
            JOptionPane.showMessageDialog(null, "Ingrese los datos en las casillas correctamente");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtPaginaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaginaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaginaActionPerformed

    private void txtPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaisActionPerformed

    private void btnBusCli2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusCli2MouseClicked
        frmBusCli frmBuCli=new frmBusCli();
        frmBuCli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBusCli2MouseClicked

    private void btnReVue2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReVue2MouseClicked
        frmRegAv frmReVue=new frmRegAv();
        frmReVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReVue2MouseClicked

    private void btnReAero2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReAero2MouseClicked
        frmRegAero frmReAero=new frmRegAero();
        frmReAero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReAero2MouseClicked

    private void btnReTra2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReTra2MouseClicked
        frmRegTrab frmReTrab=new frmRegTrab();
        frmReTrab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReTra2MouseClicked

    private void btnEstadis2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadis2MouseClicked
        frmEstadis frmEsta=new frmEstadis();
        frmEsta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEstadis2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
        try {
            if (confirm.equals("CONTINUAR")){
                int codigo=Integer.parseInt(txtID.getText());
                objAD.eliminarAerolinea(codigo);
                txtID.setText("");
                txtNombre.setText("");
                txtPais.setText("");
                txtTelefono.setText("");
                txtPagina.setText("");
                DCDate.setDate(null);
                JOptionPane.showMessageDialog(null,"Eliminacion completada exitosamente");
                listado();
        } else {
            JOptionPane.showMessageDialog(null,"Proceso cancelado");
        }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Seleccione una Aerolinea");
            }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int Pr = jTable1.getSelectedRow();
        int Codigo = Integer.parseInt(jTable1.getValueAt(Pr, 0).toString());
        
        Aerolinea x = objAD.buscarAerolinea(Codigo);
        
        txtID.setText(""+x.getIdAerolinea());
        txtNombre.setText(x.getNombre());
        txtPais.setText(x.getPaisOrigen());
        txtTelefono.setText(x.getTelefono());
        txtPagina.setText(x.getPaginaWeb());
        DCDate.setDate(x.getFechaFundacion());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          try {
            int idAerolinea = Integer.parseInt(txtID.getText());
            String nombre =txtNombre.getText();
            String paisOrigen =txtPais.getText();
            String telefono =txtTelefono.getText();
            String paginaWeb =txtPagina.getText();
            JDateChooser dateChooser = DCDate; // Asigna el JDateChooser a una variable
            Date fechaFundacion = dateChooser.getDate(); // Obtiene la fecha seleccionada
           
                if(nombre.length()>0){
                    if(idAerolinea>0){
                        String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
                        if (confirm.equals("CONTINUAR")){
                                Aerolinea pr=new Aerolinea(idAerolinea,nombre,paisOrigen,telefono,paginaWeb, fechaFundacion);
                                objAD.modificarAerolinea(pr);
                                txtID.setText("");
                                txtNombre.setText("");
                                txtPais.setText("");
                                txtTelefono.setText("");
                                txtPagina.setText("");
                                DCDate.setDate(null);
                                JOptionPane.showMessageDialog(null,"Datos actualizados exitosamente");
                                listado();
                            }else {
                            JOptionPane.showMessageDialog(null,"Proceso cancelado");}
                    } else {
                        JOptionPane.showMessageDialog(null,"El codigo debe ser mayor a 0");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un nombre");
                }
            
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Seleccione una Aerolinea");
            }
    }//GEN-LAST:event_jButton2ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmRegAero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegAero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegAero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegAero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegAero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCDate;
    private javax.swing.JLabel btnBusCli2;
    private javax.swing.JLabel btnEstadis2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel btnReAero2;
    private javax.swing.JLabel btnReTra2;
    private javax.swing.JLabel btnReVue2;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPagina;
    private javax.swing.JTextField txtPais;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
