/*
package Controlador;

import Vista.frmBusCli;
import Vista.frmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class ControladorLogin {
        private frmLogin loginForm;

    public ControladorLogin(frmLogin form) {
        loginForm = form;
    }

    public void validarUsuario() {
        String usuario = loginForm.getTxtUsuario().getText();
        String contrasena = String.valueOf(loginForm.getTxtContra().getPassword());

        try {
            if (LoginControlador.validarTrabajador(usuario, contrasena)) {
                frmBusCli form = new frmBusCli();
                form.setVisible(true);
                loginForm.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error de inicio de sesión", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void txtUsuarioActionPerformed(ActionEvent evt) {
        String user = loginForm.getTxtUsuario().getText();
    }

    public void jLabel3MouseClicked(MouseEvent evt) {
        loginForm.setState(frmLogin.ICONIFIED);
    }

    public void jLabel2MouseClicked(MouseEvent evt) {
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir del login?", "EXIT", dialogButton);
        if (result == 0) {
            System.exit(0);
        }
    }

    public void txtUsuarioMouseClicked(MouseEvent evt) {
        loginForm.getTxtUsuario().setText("");
    }

    public void txtContraMouseClicked(MouseEvent evt) {
        loginForm.getTxtContra().setText("");
    }

    public void txtContraActionPerformed(ActionEvent evt) {
        String pass = String.valueOf(loginForm.getTxtContra().getPassword());
    }

    public void btnIngresarActionPerformed(ActionEvent evt) {
        validarUsuario();
    }
}*/
