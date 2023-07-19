package Controlador;

import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Pasajero;
import Modelo.Trabajador;
import static Vista.Controladores.objPS;
import Vista.frmBusCli;
import Vista.frmEstadis;
import Vista.frmLogin;
import Vista.frmRegAero;
import Vista.frmRegAv;
import Vista.frmRegCli;
import Vista.frmRegTrab;
import Vista.frmRegVue;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class ControladorRegCli implements ActionListener, MouseListener {

    private frmRegCli regCliForm;
    private byte[] imagenUsuarioSes;

    public ControladorRegCli(frmRegCli form) {
        regCliForm = form;
        listado();
        datitos();
        obtenerUsuarioSesionado();
        //Actions
        regCliForm.btnGuardar.addActionListener(this);
        regCliForm.btnActualizar.addActionListener(this);
        regCliForm.btnEliminar.addActionListener(this);

        //MouseListeners
        regCliForm.btnCerrar.addMouseListener(this);
        regCliForm.btnMinimizar.addMouseListener(this);
        regCliForm.TablaDatos.addMouseListener(this);

        //Para el panel Deslizante
        regCliForm.SliderDelMenu.addMouseListener(this);
        regCliForm.cerrarSesion.addMouseListener(this);

        //Elementos del menu principal
        regCliForm.btnBusCli.addMouseListener(this);
        regCliForm.panelBusCli.addMouseListener(this);

        regCliForm.btnReTra.addMouseListener(this);
        regCliForm.panelReTra.addMouseListener(this);

        regCliForm.btnReAero.addMouseListener(this);
        regCliForm.panelReAero.addMouseListener(this);

        regCliForm.btnRegVue.addMouseListener(this);
        regCliForm.panelRegVue.addMouseListener(this);

        regCliForm.btnRegAvion.addMouseListener(this);
        regCliForm.panelRegAvion.addMouseListener(this);

        regCliForm.btnEstadisticas.addMouseListener(this);
        regCliForm.panelEstadisticas.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regCliForm.btnGuardar) {
            guardar();
        }
        if (e.getSource() == regCliForm.btnActualizar) {
            actualizar();
        }
        if (e.getSource() == regCliForm.btnEliminar) {
            eliminar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == regCliForm.btnCerrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "EXIT", dialogButton);
            if (result == 0) {
                System.exit(0);
            }
        }

        if (e.getSource() == regCliForm.btnMinimizar) {
            regCliForm.setState(regCliForm.ICONIFIED);
        }

        if (e.getSource() == regCliForm.TablaDatos) {
            int Pr = regCliForm.TablaDatos.getSelectedRow();
            int DNI = Integer.parseInt(regCliForm.TablaDatos.getValueAt(Pr, 0).toString());

            Pasajero x = objPS.buscarPasajero(DNI);

            regCliForm.txtDni.setText(String.valueOf(x.getDniPasajero()));///
            regCliForm.txtNombre.setText(x.getNombre());
            regCliForm.txtApellido.setText(x.getApellido());
            regCliForm.txtEdad.setText("" + x.getEdad());
            regCliForm.txtGenero.setText(x.getGenero());
            regCliForm.txtNacionalidad.setText(x.getNacionalidad());
        }

        if (e.getSource() == regCliForm.cerrarSesion) {
            cerrarSesion();
            frmLogin frmLogin = new frmLogin();
            frmLogin.setVisible(true);
            regCliForm.setVisible(false);
        }

        //elementos menu principal
        if (e.getSource() == regCliForm.btnReTra | e.getSource() == regCliForm.panelReTra) {
            frmRegTrab frmReTrab = new frmRegTrab();
            frmReTrab.setVisible(true);
            regCliForm.setVisible(false);
        }

        if (e.getSource() == regCliForm.btnBusCli | e.getSource() == regCliForm.panelBusCli) {
            frmBusCli frmBuCli = new frmBusCli();
            frmBuCli.setVisible(true);
            regCliForm.setVisible(false);
        }

        if (e.getSource() == regCliForm.btnReAero | e.getSource() == regCliForm.panelReAero) {
            frmRegAero frmRegAero = new frmRegAero();
            frmRegAero.setVisible(true);
            regCliForm.setVisible(false);
        }

        if (e.getSource() == regCliForm.btnRegVue | e.getSource() == regCliForm.panelRegVue) {
            frmRegVue frmRegVue = new frmRegVue();
            frmRegVue.setVisible(true);
            regCliForm.setVisible(false);
        }

        if (e.getSource() == regCliForm.btnRegAvion | e.getSource() == regCliForm.panelRegAvion) {
            frmRegAv frmRegAv = new frmRegAv();
            frmRegAv.setVisible(true);
            regCliForm.setVisible(false);
        }

        if (e.getSource() == regCliForm.btnEstadisticas | e.getSource() == regCliForm.btnEstadisticas) {
            frmEstadis frmEstadis = new frmEstadis();
            frmEstadis.setVisible(true);
            regCliForm.setVisible(false);
        }

        //Slider
        if (e.getSource() == regCliForm.SliderDelMenu) {
            regCliForm.SliderDelMenu.setEnabled(false);

            int initialSize = regCliForm.jPanel3.getWidth();
            int finalSize = (initialSize == 250) ? 0 : 250;
            int increment = (finalSize < initialSize) ? -5 : 5; // El tamaño cambia de -5 o 5 (puede cambiarse)
            int delay = 5; // Retardo (ms)

            Timer timer = new Timer(delay, new ActionListener() {
                int currentSize = initialSize; // 0 o 250

                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((increment < 0 && currentSize >= finalSize) || (increment > 0 && currentSize <= finalSize)) {
                        regCliForm.jPanel3.setSize(currentSize, 660); //0 o 250 dependiendo :v
                        regCliForm.panelDetras.setLocation(currentSize, regCliForm.panelDetras.getY()); // el panel se mueve mientras el otro aparece :v
                        regCliForm.panelDetras.setSize(250 - currentSize, 660); // Ajustar el tamaño //(desactivar para ver la magia)
                        currentSize += increment;
                        regCliForm.panelDetras.setVisible(true); //UNA HORA POR ESTA WEAAA
                    } else {
                        ((Timer) e.getSource()).stop();

                        if (finalSize == 0) {
                            regCliForm.panelDetras.setVisible(true);
                        } else {
                            regCliForm.panelDetras.setVisible(false);
                        }

                        // activa el botoncito
                        regCliForm.SliderDelMenu.setEnabled(true);
                    }
                }
            });
            timer.start();
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == regCliForm.btnBusCli | e.getSource() == regCliForm.panelBusCli) {
            maus = true;
            cambiarColores(regCliForm.btnBusCli, regCliForm.panelBusCli);
        }

        if (e.getSource() == regCliForm.btnReTra | e.getSource() == regCliForm.panelReTra) {
            maus = true;
            cambiarColores(regCliForm.btnReTra, regCliForm.panelReTra);
        }

        if (e.getSource() == regCliForm.btnReAero | e.getSource() == regCliForm.panelReAero) {
            maus = true;
            cambiarColores(regCliForm.btnReAero, regCliForm.panelReAero);
        }

        if (e.getSource() == regCliForm.btnRegVue | e.getSource() == regCliForm.panelRegVue) {
            maus = true;
            cambiarColores(regCliForm.btnRegVue, regCliForm.panelRegVue);
        }

        if (e.getSource() == regCliForm.btnRegAvion | e.getSource() == regCliForm.panelRegAvion) {
            maus = true;
            cambiarColores(regCliForm.btnRegAvion, regCliForm.panelRegAvion);
        }

        if (e.getSource() == regCliForm.btnEstadisticas | e.getSource() == regCliForm.panelEstadisticas) {
            maus = true;
            cambiarColores(regCliForm.btnEstadisticas, regCliForm.panelEstadisticas);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == regCliForm.btnBusCli | e.getSource() == regCliForm.panelBusCli) {
            maus = false;
            cambiarColores(regCliForm.btnBusCli, regCliForm.panelBusCli);
        }

        if (e.getSource() == regCliForm.btnReTra | e.getSource() == regCliForm.panelReTra) {
            maus = false;
            cambiarColores(regCliForm.btnReTra, regCliForm.panelReTra);
        }

        if (e.getSource() == regCliForm.btnReTra | e.getSource() == regCliForm.panelReTra) {
            maus = false;
            cambiarColores(regCliForm.btnReTra, regCliForm.panelReTra);
        }

        if (e.getSource() == regCliForm.btnReAero | e.getSource() == regCliForm.panelReAero) {
            maus = false;
            cambiarColores(regCliForm.btnReAero, regCliForm.panelReAero);
        }

        if (e.getSource() == regCliForm.btnRegVue | e.getSource() == regCliForm.panelRegVue) {
            maus = false;
            cambiarColores(regCliForm.btnRegVue, regCliForm.panelRegVue);
        }

        if (e.getSource() == regCliForm.btnRegAvion | e.getSource() == regCliForm.panelRegAvion) {
            maus = false;
            cambiarColores(regCliForm.btnRegAvion, regCliForm.panelRegAvion);
        }

        if (e.getSource() == regCliForm.btnEstadisticas | e.getSource() == regCliForm.panelEstadisticas) {
            maus = false;
            cambiarColores(regCliForm.btnEstadisticas, regCliForm.panelEstadisticas);
        }

    }

    private boolean maus = false;
    private int filaSeleccionada = -1;

    //colores panel/jlabel"botones" xd
    private java.awt.Color ColorEnteredBoton = new java.awt.Color(55, 231, 173);
    private java.awt.Color ColorOriginalPanel = new java.awt.Color(67, 90, 132);
    private java.awt.Color ColorEnteredPanel = new java.awt.Color(110, 153, 139);

    private void cambiarColores(Component boton, Component panel) {
        if (maus) {
            boton.setForeground(ColorEnteredBoton);
            panel.setBackground(ColorEnteredPanel);
        } else {
            boton.setForeground(Color.WHITE);
            panel.setBackground(ColorOriginalPanel);
        }
    }

    public void obtenerUsuarioSesionado() {
        Trabajador trabajadorSesionado = LoginControlador.getTrabajadorSesionado();
        if (trabajadorSesionado != null) {

            regCliForm.lblIDUsu.setText("" + trabajadorSesionado.getCodigoTra());
            regCliForm.lblUsuarioSes.setText(trabajadorSesionado.getUsuario());
            regCliForm.lblNombreSes.setText(trabajadorSesionado.getNombre());
            regCliForm.lblApeUsu.setText(trabajadorSesionado.getApellido());
            imagenUsuarioSes = trabajadorSesionado.getFoto();
            ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
            regCliForm.lblFotoSes.setIcon(IconoSelec);
            regCliForm.lblFotoSes2.setIcon(IconoSelec);
            regCliForm.lblUsuarioSes2.setText(trabajadorSesionado.getUsuario());

            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaDeInicio = horaActual.format(formatter);
            regCliForm.lblTiempSes.setText("" + horaDeInicio);
        } else {
            System.out.println("Se supone que esto no debe pasar XD");
        }
    }

    void guardar() {

        try {
            int dni = Integer.parseInt(regCliForm.txtDni.getText());
            String nom = regCliForm.txtApellido.getText();
            String ape = regCliForm.txtNombre.getText();
            int edad = Integer.parseInt(regCliForm.txtEdad.getText());
            String gene = regCliForm.txtGenero.getText();
            String nacio = regCliForm.txtNacionalidad.getText();

            if (nom.length() > 0) {
                if (edad > 0) {
                    Pasajero pr = new Pasajero(dni, nom, ape, edad, gene, nacio);
                    objPS.crearPasajero(pr);
                    regCliForm.txtNombre.setText("");
                    regCliForm.txtApellido.setText("");
                    regCliForm.txtDni.setText("");
                    regCliForm.txtEdad.setText("");
                    regCliForm.txtGenero.setText("");
                    regCliForm.txtNacionalidad.setText("");
                    listado();
                    JOptionPane.showMessageDialog(null, "Pasajero agregado correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "La edad debe ser mayor a 0");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre");
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos en las casillas correctamente");
        }
    }

    void actualizar() {
        try {
            int dni = Integer.parseInt(regCliForm.txtDni.getText());
            String nom = regCliForm.txtApellido.getText();
            String ape = regCliForm.txtNombre.getText();
            int edad = Integer.parseInt(regCliForm.txtEdad.getText());
            String gene = regCliForm.txtGenero.getText();
            String nacio = regCliForm.txtNacionalidad.getText();

            if (nom.length() > 0) {
                if (edad > 1) {
                    String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
                    if (confirm.equals("CONTINUAR")) {
                        Pasajero pr = new Pasajero(dni, nom, ape, edad, gene, nacio);
                        objPS.modificarPasajero(pr);
                        regCliForm.txtDni.setText("");
                        regCliForm.txtApellido.setText("");
                        regCliForm.txtNombre.setText("");
                        regCliForm.txtEdad.setText("");
                        regCliForm.txtGenero.setText("");
                        regCliForm.txtNacionalidad.setText("");
                        JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
                        listado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Proceso cancelado");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La edad debe ser mayor a 1");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un Cliente");
        }
    }

    void eliminar() {
        String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
        try {
            if (confirm.equals("CONTINUAR")) {
                int dni = Integer.parseInt(regCliForm.txtDni.getText());
                objPS.eliminarPasajero(dni);
                regCliForm.txtDni.setText("");
                regCliForm.txtApellido.setText("");
                regCliForm.txtNombre.setText("");
                regCliForm.txtEdad.setText("");
                regCliForm.txtGenero.setText("");
                regCliForm.txtNacionalidad.setText("");
                JOptionPane.showMessageDialog(null, "Eliminacion completada exitosamente");
                listado();
            } else {
                JOptionPane.showMessageDialog(null, "Proceso cancelado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un Cliente");
        }
    }

    void listado() {
        DefaultTableModel dt = (DefaultTableModel) regCliForm.TablaDatos.getModel();

        dt.setRowCount(0);
        for (Pasajero x : objPS.Listado()) {
            Object v[] = {x.getDniPasajero(), x.getNombre(), x.getApellido(), x.getEdad(), x.getGenero(), x.getNacionalidad()};
            dt.addRow(v);
        }
    }
    
        
    void datitos(){
           
        int totalPasajeros = objPS.contarPasajeros();
        regCliForm.lblCantidadPasRegis.setText("" + totalPasajeros);
                
        String nacionalMRegistrada = objPS.obtenerNacionalidadMasRegistrada();
        regCliForm.lblNacMasRegis.setText(""+nacionalMRegistrada);
        
    }
    
  
}
