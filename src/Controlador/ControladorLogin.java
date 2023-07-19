
package Controlador;

import Modelo.DAO.TrabajadorDAO;
import Modelo.Trabajador;
import Vista.frmBusCli;
import Vista.frmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorLogin implements ActionListener, MouseListener {
    private frmLogin loginForm;

    public ControladorLogin(frmLogin form) {
        loginForm = form;

        //ActionListeners
        loginForm.btnIngresar.addActionListener(this);
        
        //MouseListeners
        loginForm.btnCerrar.addMouseListener(this);
        loginForm.btnMinimizar.addMouseListener(this);
        loginForm.txtUsuario.addMouseListener(this);
        loginForm.txtContra.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginForm.btnIngresar) {
            validarUsuario();
        }
        // Agregar más condiciones para otros eventos de acción si es necesario

    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == loginForm.btnCerrar){
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea salir del login?","EXIT",dialogButton);
            if(result == 0){
                System.exit(0);
            }
        }
        
        if (e.getSource() == loginForm.btnMinimizar){
           loginForm.setState(frmLogin.ICONIFIED);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == loginForm.txtUsuario){
           loginForm.txtUsuario.setText("");
        }
        if (e.getSource() == loginForm.txtContra){
           loginForm.txtContra.setText("");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    
        //metodos
    
    public void validarUsuario() {
        String usuario = loginForm.txtUsuario.getText();
        String contrasena = String.valueOf(loginForm.txtContra.getPassword());

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
}