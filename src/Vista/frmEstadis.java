
package Vista;

import Modelo.DAO.Aerolinea_preferidaDAO;
import Modelo.DAO.Reserva_del_diaDAO;
import Modelo.DAO.Vuelos_mas_vendidosDAO;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.time.LocalDate;

import javax.swing.JOptionPane;

public class frmEstadis extends javax.swing.JFrame {

    public frmEstadis() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
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
        btnRegVue = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Grafico");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, -1));

        jButton3.setText("Grafico");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, -1, -1));

        jButton4.setText("Grafico");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 240, -1, -1));

        jButton5.setText("Ver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        jButton6.setText("Ver");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, -1, -1));

        jButton7.setText("Ver");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, -1, -1));

        jLabel1.setText("Aerolinea preferida");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel4.setText("Vuelos mas vendidos");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel5.setText("Reservas del dia");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 620, 420));

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
        jLabel6.setText("ESTADÍSTICAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(230, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(197, 197, 197)))
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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 620, -1));

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
        btnReVue2.setText("     Registro de Avión");
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

        btnRegVue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegVue.setText("  Registro de Vuelos");
        btnRegVue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegVueMouseClicked(evt);
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
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel18))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRegVue)))
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
                .addComponent(btnRegVue, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstadis2)
                .addGap(17, 17, 17))
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

    private void btnRegVueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegVueMouseClicked
        frmRegVue frmRegVue=new frmRegVue();
        frmRegVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegVueMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String url = "jdbc:mysql://localhost:3306/bd_vuelos";
    String username = "root";
    String password = "";

    // Variables para almacenar la aerolínea preferida
    String aerolineaPreferida = "";
    int vuelosMaximos = 0;

    try {
        // Establecer conexión con la base de datos
        Connection connection = DriverManager.getConnection(url, username, password);

        // Crear una declaración SQL para obtener la aerolínea preferida
        String query = "SELECT a.nombre AS aerolinea, COUNT(*) AS total "
                + "FROM aerolinea a "
                + "JOIN avion av ON a.id_aerolinea = av.id_aerolinea "
                + "JOIN vuelo v ON av.id_avion = v.id_avion "
                + "GROUP BY a.nombre "
                + "ORDER BY total DESC "
                + "LIMIT 1";

        // Crear una declaración SQL
        Statement statement = connection.createStatement();

        // Ejecutar la consulta SQL
        ResultSet resultSet = statement.executeQuery(query);

        // Obtener la aerolínea preferida
        if (resultSet.next()) {
            aerolineaPreferida = resultSet.getString("aerolinea");
            vuelosMaximos = resultSet.getInt("total");
        }

        // Cerrar la conexión y liberar recursos
        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Mostrar el mensaje con la aerolínea preferida en un aviso
    JOptionPane.showMessageDialog(this, "La aerolínea preferida es: " + aerolineaPreferida);

    // Resto de tu código dentro del método jButton5ActionPerformed
    // ...
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Aerolinea_preferidaDAO ae = new Aerolinea_preferidaDAO();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        // Obtener los datos de la base de datos
    String url = "jdbc:mysql://localhost:3306/bd_vuelos";
    String username = "root";
    String password = "";

    // Variables para almacenar el vuelo más vendido
    String vueloMasVendido = "";

    try {
        // Establecer conexión con la base de datos
        Connection connection = DriverManager.getConnection(url, username, password);

        // Crear una declaración SQL para obtener el vuelo más vendido
        String query = "SELECT v.destino "
                + "FROM reserva_vuelo rv "
                + "JOIN vuelo v ON rv.id_vuelo = v.id_vuelo "
                + "GROUP BY v.destino "
                + "ORDER BY COUNT(*) DESC "
                + "LIMIT 1";

        // Crear una declaración SQL
        Statement statement = connection.createStatement();

        // Ejecutar la consulta SQL
        ResultSet resultSet = statement.executeQuery(query);

        // Obtener el vuelo más vendido
        if (resultSet.next()) {
            vueloMasVendido = resultSet.getString("destino");
        }

        // Cerrar la conexión y liberar recursos
        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Mostrar el mensaje con el vuelo más vendido en un aviso
    JOptionPane.showMessageDialog(this, "El vuelo más vendido es: " + vueloMasVendido);

    // Resto de tu código dentro del método jButton6ActionPerformed
    // ...
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        // Obtener los datos de la base de datos
    String url = "jdbc:mysql://localhost:3306/bd_vuelos";
    String username = "root";
    String password = "";

    // Variables para almacenar el destino más popular
    String destinoPopular = "";
    int ventasMaximas = 0;

    // Obtener la fecha actual
    LocalDate fechaActual = LocalDate.now();

    try {
        // Establecer conexión con la base de datos
        Connection connection = DriverManager.getConnection(url, username, password);

        // Crear una declaración SQL para obtener el destino más popular del día actual
        String query = "SELECT v.destino, COUNT(*) AS total "
                + "FROM reserva_vuelo rv "
                + "JOIN vuelo v ON rv.id_vuelo = v.id_vuelo "
                + "WHERE DATE(rv.fecha_reserva) = ? "
                + "GROUP BY v.destino "
                + "ORDER BY total DESC "
                + "LIMIT 1";

        // Crear una declaración SQL
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setDate(1, java.sql.Date.valueOf(fechaActual));

        // Ejecutar la consulta SQL
        ResultSet resultSet = statement.executeQuery();

        // Obtener el destino más popular del día actual
        if (resultSet.next()) {
            destinoPopular = resultSet.getString("destino");
            ventasMaximas = resultSet.getInt("total");
        }

        // Cerrar la conexión y liberar recursos
        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    // Mostrar el mensaje con el destino más popular en un aviso
    JOptionPane.showMessageDialog(this, "El destino más popular del día de hoy es: " + destinoPopular);
    
    // Resto de tu código dentro del método jButton4ActionPerformed
    // ...
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Vuelos_mas_vendidosDAO vu = new Vuelos_mas_vendidosDAO();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Reserva_del_diaDAO res = new Reserva_del_diaDAO();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(frmEstadis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEstadis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEstadis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEstadis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEstadis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBusCli2;
    private javax.swing.JLabel btnEstadis2;
    private javax.swing.JLabel btnReAero2;
    private javax.swing.JLabel btnReTra2;
    private javax.swing.JLabel btnReVue2;
    private javax.swing.JLabel btnRegVue;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
