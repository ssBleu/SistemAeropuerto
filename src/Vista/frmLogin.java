package Vista;

import Modelo.Conexion.Conexion;
import Modelo.DAO.TrabajadorDAO;
import Modelo.Trabajador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class frmLogin extends javax.swing.JFrame {
    //Se necesitan 5 variables
    //Se estableceran rutas de conexiones

    
    Conexion conexion = new Conexion();
    Connection connection = conexion.getConnection();

    //cree esto por mi cuenta y juicio, lo que hace es abrir la pestana de frmRegistrarUsuario
    
    public frmLogin() {
        initComponents();
        //para centrar el jframe
        this.setLocationRelativeTo(null);
    }
    
    public void registrarse(){
        frmRegUsu form = new frmRegUsu();
        form.setVisible(true);
    }
    
    public void validarUsuario(){
        
        String usuario = txtUsuario.getText();
        String contrasena = String.valueOf(txtContra.getPassword());
        
        TrabajadorDAO trabajadorDAO = new TrabajadorDAO(connection);

        try {
            if (trabajadorDAO.validarCredenciales(usuario, contrasena)) {
                frmRegCli form= new frmRegCli();
                form.setVisible(true);
                //para que salga de esta clase y visualice la otra
                this.dispose();
            } else {
                // Credenciales inválidas, mostrar mensaje de error
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            // Manejar el error de la base de datos
            e.printStackTrace();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        btnRegistrarse = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 530));
        setUndecorated(true);
        setSize(new java.awt.Dimension(800, 530));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/avion.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 380, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel2.setText("x");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 20, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 20, 20));

        jLabel4.setBackground(new java.awt.Color(204, 204, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setText("LOG IN");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 130, 60));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("USER:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        txtUsuario.setText("Ingrese usuario");
        txtUsuario.setBorder(null);
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseClicked(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 260, 30));

        txtContra.setText("jPasswordField1");
        txtContra.setBorder(null);
        txtContra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtContraMouseClicked(evt);
            }
        });
        txtContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraActionPerformed(evt);
            }
        });
        jPanel1.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 260, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 260, 10));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 260, 10));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("PASSWORD:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 260, -1, -1));

        btnRegistrarse.setBackground(new java.awt.Color(102, 102, 255));
        btnRegistrarse.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 350, 140, 40));

        btnIngresar.setBackground(new java.awt.Color(102, 102, 255));
        btnIngresar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 120, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 440, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
      String user= txtUsuario.getText();
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(frmLogin.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir del login?","EXIT",dialogButton);
        if(result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseClicked
        txtUsuario.setText("");
    }//GEN-LAST:event_txtUsuarioMouseClicked

    private void txtContraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtContraMouseClicked
       txtContra.setText("");
    }//GEN-LAST:event_txtContraMouseClicked

    private void txtContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraActionPerformed
      String pass = String.valueOf(txtContra.getPassword());
    }//GEN-LAST:event_txtContraActionPerformed

    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed
        this.setVisible(false);
        registrarse();
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        validarUsuario();

    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
