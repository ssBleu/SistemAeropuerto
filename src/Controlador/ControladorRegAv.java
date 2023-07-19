package Controlador;

import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Avion;
import Modelo.Trabajador;
import static Vista.Controladores.objAD;
import static Vista.Controladores.objAvD;
import Vista.frmBusCli;
import Vista.frmEstadis;
import Vista.frmLogin;
import Vista.frmRegAero;
import Vista.frmRegAv;
import Vista.frmRegTrab;
import Vista.frmRegVue;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class ControladorRegAv implements ActionListener, MouseListener {

    private frmRegAv regAvionForm;
    private byte[] imagenUsuarioSes;

    public ControladorRegAv(frmRegAv form) {
        regAvionForm = form;
        listado();
        obtenerUsuarioSesionado();
        datitos();

        //ActionListener
        regAvionForm.btnGuardar.addActionListener(this);
        regAvionForm.btnActualizar.addActionListener(this);
        regAvionForm.btnEliminar.addActionListener(this);
        //MouseListeners
        regAvionForm.btnCerrar.addMouseListener(this);
        regAvionForm.btnMinimizar.addMouseListener(this);
        regAvionForm.tablaAvion.addMouseListener(this);

        //Para el panel Deslizante
        regAvionForm.SliderDelMenu.addMouseListener(this);
        regAvionForm.cerrarSesion.addMouseListener(this);

        //Elementos del menu principal
        regAvionForm.btnBusCli.addMouseListener(this);
        regAvionForm.panelBusCli.addMouseListener(this);

        regAvionForm.btnReTra.addMouseListener(this);
        regAvionForm.panelReTra.addMouseListener(this);

        regAvionForm.btnReAero.addMouseListener(this);
        regAvionForm.panelReAero.addMouseListener(this);

        regAvionForm.btnRegVue.addMouseListener(this);
        regAvionForm.panelRegVue.addMouseListener(this);

        regAvionForm.btnRegAvion.addMouseListener(this);
        regAvionForm.panelRegAvion.addMouseListener(this);

        regAvionForm.btnEstadisticas.addMouseListener(this);
        regAvionForm.panelEstadisticas.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == regAvionForm.btnGuardar) {
            guardar();
        }

        if (e.getSource() == regAvionForm.btnActualizar) {
            actualizar();
        }

        if (e.getSource() == regAvionForm.btnEliminar) {
            eliminar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == regAvionForm.btnCerrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "EXIT", dialogButton);
            if (result == 0) {
                System.exit(0);
            }
        }

        if (e.getSource() == regAvionForm.btnMinimizar) {
            regAvionForm.setState(regAvionForm.ICONIFIED);
        }

        if (e.getSource() == regAvionForm.tablaAvion) {
            int Pr = regAvionForm.tablaAvion.getSelectedRow();
            int ID = Integer.parseInt(regAvionForm.tablaAvion.getValueAt(Pr, 0).toString());

            Avion x = objAvD.buscarAvion(ID);

            regAvionForm.txtIDAvion.setText("" + x.getIdAvion());
            regAvionForm.txtModelo.setText(x.getModelo());
            regAvionForm.txtCapacidad.setText("" + x.getCapacidadPasajeros());
        }

        if (e.getSource() == regAvionForm.cerrarSesion) {
            cerrarSesion();
            frmLogin frmLogin = new frmLogin();
            frmLogin.setVisible(true);
            regAvionForm.setVisible(false);
        }

        //elementos menu principal
        if (e.getSource() == regAvionForm.btnReTra | e.getSource() == regAvionForm.panelReTra) {
            frmRegTrab frmReTrab = new frmRegTrab();
            frmReTrab.setVisible(true);
            regAvionForm.setVisible(false);
        }

        if (e.getSource() == regAvionForm.btnBusCli | e.getSource() == regAvionForm.panelBusCli) {
            frmBusCli frmBuCli = new frmBusCli();
            frmBuCli.setVisible(true);
            regAvionForm.setVisible(false);
        }

        if (e.getSource() == regAvionForm.btnReAero | e.getSource() == regAvionForm.panelReAero) {
            frmRegAero frmRegAero = new frmRegAero();
            frmRegAero.setVisible(true);
            regAvionForm.setVisible(false);
        }

        if (e.getSource() == regAvionForm.btnRegVue | e.getSource() == regAvionForm.panelRegVue) {
            frmRegVue frmRegVue = new frmRegVue();
            frmRegVue.setVisible(true);
            regAvionForm.setVisible(false);
        }

        if (e.getSource() == regAvionForm.btnRegAvion | e.getSource() == regAvionForm.panelRegAvion) {
            frmRegAv frmRegAv = new frmRegAv();
            frmRegAv.setVisible(true);
            regAvionForm.setVisible(false);
        }

        if (e.getSource() == regAvionForm.btnEstadisticas | e.getSource() == regAvionForm.btnEstadisticas) {
            frmEstadis frmEstadis = new frmEstadis();
            frmEstadis.setVisible(true);
            regAvionForm.setVisible(false);
        }

        //Slider
        if (e.getSource() == regAvionForm.SliderDelMenu) {
            regAvionForm.SliderDelMenu.setEnabled(false);

            int initialSize = regAvionForm.jPanel3.getWidth();
            int finalSize = (initialSize == 250) ? 0 : 250;
            int increment = (finalSize < initialSize) ? -5 : 5; // El tamaño cambia de -5 o 5 (puede cambiarse)
            int delay = 5; // Retardo (ms)

            Timer timer = new Timer(delay, new ActionListener() {
                int currentSize = initialSize; // 0 o 250

                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((increment < 0 && currentSize >= finalSize) || (increment > 0 && currentSize <= finalSize)) {
                        regAvionForm.jPanel3.setSize(currentSize, 660); //0 o 250 dependiendo :v
                        regAvionForm.panelDetras.setLocation(currentSize, regAvionForm.panelDetras.getY()); // el panel se mueve mientras el otro aparece :v
                        regAvionForm.panelDetras.setSize(250 - currentSize, 660); // Ajustar el tamaño //(desactivar para ver la magia)
                        currentSize += increment;
                        regAvionForm.panelDetras.setVisible(true); //UNA HORA POR ESTA WEAAA
                    } else {
                        ((Timer) e.getSource()).stop();

                        if (finalSize == 0) {
                            regAvionForm.panelDetras.setVisible(true);
                        } else {
                            regAvionForm.panelDetras.setVisible(false);
                        }

                        // activa el botoncito
                        regAvionForm.SliderDelMenu.setEnabled(true);
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
        if (e.getSource() == regAvionForm.btnBusCli | e.getSource() == regAvionForm.panelBusCli) {
            maus = true;
            cambiarColores(regAvionForm.btnBusCli, regAvionForm.panelBusCli);
        }

        if (e.getSource() == regAvionForm.btnReTra | e.getSource() == regAvionForm.panelReTra) {
            maus = true;
            cambiarColores(regAvionForm.btnReTra, regAvionForm.panelReTra);
        }

        if (e.getSource() == regAvionForm.btnReAero | e.getSource() == regAvionForm.panelReAero) {
            maus = true;
            cambiarColores(regAvionForm.btnReAero, regAvionForm.panelReAero);
        }

        if (e.getSource() == regAvionForm.btnRegVue | e.getSource() == regAvionForm.panelRegVue) {
            maus = true;
            cambiarColores(regAvionForm.btnRegVue, regAvionForm.panelRegVue);
        }

        if (e.getSource() == regAvionForm.btnRegAvion | e.getSource() == regAvionForm.panelRegAvion) {
            maus = true;
            cambiarColores(regAvionForm.btnRegAvion, regAvionForm.panelRegAvion);
        }

        if (e.getSource() == regAvionForm.btnEstadisticas | e.getSource() == regAvionForm.panelEstadisticas) {
            maus = true;
            cambiarColores(regAvionForm.btnEstadisticas, regAvionForm.panelEstadisticas);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == regAvionForm.btnBusCli | e.getSource() == regAvionForm.panelBusCli) {
            maus = false;
            cambiarColores(regAvionForm.btnBusCli, regAvionForm.panelBusCli);
        }

        if (e.getSource() == regAvionForm.btnReTra | e.getSource() == regAvionForm.panelReTra) {
            maus = false;
            cambiarColores(regAvionForm.btnReTra, regAvionForm.panelReTra);
        }

        if (e.getSource() == regAvionForm.btnReTra | e.getSource() == regAvionForm.panelReTra) {
            maus = false;
            cambiarColores(regAvionForm.btnReTra, regAvionForm.panelReTra);
        }

        if (e.getSource() == regAvionForm.btnReAero | e.getSource() == regAvionForm.panelReAero) {
            maus = false;
            cambiarColores(regAvionForm.btnReAero, regAvionForm.panelReAero);
        }

        if (e.getSource() == regAvionForm.btnRegVue | e.getSource() == regAvionForm.panelRegVue) {
            maus = false;
            cambiarColores(regAvionForm.btnRegVue, regAvionForm.panelRegVue);
        }

        if (e.getSource() == regAvionForm.btnRegAvion | e.getSource() == regAvionForm.panelRegAvion) {
            maus = false;
            cambiarColores(regAvionForm.btnRegAvion, regAvionForm.panelRegAvion);
        }

        if (e.getSource() == regAvionForm.btnEstadisticas | e.getSource() == regAvionForm.panelEstadisticas) {
            maus = false;
            cambiarColores(regAvionForm.btnEstadisticas, regAvionForm.panelEstadisticas);
        }

    }

    private boolean maus = false;
    private int filaSeleccionada = -1;

    //colores panel/jlabel"botones" xd
    private java.awt.Color ColorEnteredBoton = new java.awt.Color(55, 231, 173);
    private java.awt.Color ColorOriginalPanel = new java.awt.Color(67, 90, 132);
    private java.awt.Color ColorEnteredPanel = new java.awt.Color(110, 153, 139);

    //metodos
    private void cambiarColores(Component boton, Component panel) {
        if (maus) {
            boton.setForeground(ColorEnteredBoton);
            panel.setBackground(ColorEnteredPanel);
        } else {
            boton.setForeground(Color.WHITE);
            panel.setBackground(ColorOriginalPanel);
        }
    }

    void guardar() {
        try {
            int IDAvion = Integer.parseInt(regAvionForm.txtIDAvion.getText());
            String modelo = regAvionForm.txtModelo.getText();

            int capacidadPasajeros = Integer.parseInt(regAvionForm.txtCapacidad.getText());

            String nombreAerolinea = (String) regAvionForm.cboAerol.getSelectedItem();
            int idAerolinea = objAD.obtenerIdAerolineaPorNombre(nombreAerolinea);

            Avion avion = new Avion(IDAvion, modelo, capacidadPasajeros, idAerolinea);
            objAvD.crearAvion(avion);
            listado();

        } catch (SQLException ex) {
            Logger.getLogger(frmRegAv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void eliminar() {
        String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
        try {
            if (confirm.equals("CONTINUAR")) {
                int dni = Integer.parseInt(regAvionForm.txtIDAvion.getText());
                objAvD.eliminarAvion(dni);
                regAvionForm.txtModelo.setText("");
                JOptionPane.showMessageDialog(null, "Eliminacion completada exitosamente");
                listado();
            } else {
                JOptionPane.showMessageDialog(null, "Proceso cancelado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un Cliente");
        }
        limpiarCampos();
    }

    void actualizar() {
        //falta xd
    }

    void listado() {
        DefaultTableModel dt = (DefaultTableModel) regAvionForm.tablaAvion.getModel();

        dt.setRowCount(0);
        for (Avion x : objAvD.obtenerListaAviones()) {
            Object v[] = {x.getIdAvion(), x.getIdAerolinea(), x.getNombreAerolinea(), x.getModelo(), x.getCapacidadPasajeros()};
            dt.addRow(v);
        }
    }

    void limpiarCampos() {
        regAvionForm.txtIDAvion.setText("");
        //cboAerol;
        regAvionForm.txtModelo.setText("");
        regAvionForm.txtCapacidad.setText("");
    }

    void datitos() {

        String avionPreferido = objAvD.obtenerAvionPreferido();
        regAvionForm.lblAvionPreferido.setText("" + avionPreferido);

        int capacidadPromAvion = objAvD.obtenerCapacidadPromedioAvion();
        regAvionForm.lblcapacPromAviones.setText("" + capacidadPromAvion);

    }

    public void obtenerUsuarioSesionado() {
        Trabajador trabajadorSesionado = LoginControlador.getTrabajadorSesionado();
        if (trabajadorSesionado != null) {

            regAvionForm.lblIDUsu.setText("" + trabajadorSesionado.getCodigoTra());
            regAvionForm.lblUsuarioSes.setText(trabajadorSesionado.getUsuario());
            regAvionForm.lblNombreSes.setText(trabajadorSesionado.getNombre());
            regAvionForm.lblApeUsu.setText(trabajadorSesionado.getApellido());
            imagenUsuarioSes = trabajadorSesionado.getFoto();
            ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
            regAvionForm.lblFotoSes.setIcon(IconoSelec);
            regAvionForm.lblFotoSes2.setIcon(IconoSelec);
            regAvionForm.lblUsuarioSes2.setText(trabajadorSesionado.getUsuario());

            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaDeInicio = horaActual.format(formatter);
            regAvionForm.lblTiempSes.setText("" + horaDeInicio);
        } else {
            System.out.println("Se supone que esto no debe pasar XD");
        }
    }

}
