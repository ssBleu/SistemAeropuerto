package Controlador;

import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Aerolinea;
import Modelo.Trabajador;
import static Vista.Controladores.objAD;
import Vista.frmBusCli;
import Vista.frmEstadis;
import Vista.frmLogin;
import Vista.frmRegAero;
import Vista.frmRegAv;
import Vista.frmRegTrab;
import Vista.frmRegVue;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class ControladorRegAero implements ActionListener, MouseListener {

    private frmRegAero regAeroForm;

    private byte[] imagenUsuarioSes;

    public ControladorRegAero(frmRegAero form) {
        regAeroForm = form;

        listado();
        obtenerUsuarioSesionado();
        datitos();

        regAeroForm.btnActualizar.addActionListener(this);
        regAeroForm.btnGuardar.addActionListener(this);
        regAeroForm.btnEliminar.addActionListener(this);

        //MouseListeners
        regAeroForm.btnCerrar.addMouseListener(this);
        regAeroForm.btnMinimizar.addMouseListener(this);
        regAeroForm.tablaAerolinea.addMouseListener(this);

        //Para el panel Deslizante
        regAeroForm.SliderDelMenu.addMouseListener(this);
        regAeroForm.cerrarSesion.addMouseListener(this);

        //Elementos del menu principal
        regAeroForm.btnBusCli.addMouseListener(this);
        regAeroForm.panelBusCli.addMouseListener(this);

        regAeroForm.btnReTra.addMouseListener(this);
        regAeroForm.panelReTra.addMouseListener(this);

        regAeroForm.btnReAero.addMouseListener(this);
        regAeroForm.panelReAero.addMouseListener(this);

        regAeroForm.btnRegVue.addMouseListener(this);
        regAeroForm.panelRegVue.addMouseListener(this);

        regAeroForm.btnRegAvion.addMouseListener(this);
        regAeroForm.panelRegAvion.addMouseListener(this);

        regAeroForm.btnEstadisticas.addMouseListener(this);
        regAeroForm.panelEstadisticas.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regAeroForm.btnGuardar) {
            guardar();
        }
        if (e.getSource() == regAeroForm.btnActualizar) {
            actualizar();
        }

        if (e.getSource() == regAeroForm.btnEliminar) {
            eliminar();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == regAeroForm.btnCerrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "EXIT", dialogButton);
            if (result == 0) {
                System.exit(0);
            }
        }

        if (e.getSource() == regAeroForm.btnMinimizar) {
            regAeroForm.setState(regAeroForm.ICONIFIED);
        }

        if (e.getSource() == regAeroForm.tablaAerolinea) {
            int Pr = regAeroForm.tablaAerolinea.getSelectedRow();
            int Codigo = Integer.parseInt(regAeroForm.tablaAerolinea.getValueAt(Pr, 0).toString());

            Aerolinea x = objAD.buscarAerolinea(Codigo);

            regAeroForm.txtID.setText("" + x.getIdAerolinea());
            regAeroForm.txtNombre.setText(x.getNombre());
            regAeroForm.txtPais.setText(x.getPaisOrigen());
            regAeroForm.txtTelefono.setText(x.getTelefono());
            regAeroForm.txtPagina.setText(x.getPaginaWeb());
            regAeroForm.DCDate.setDate(x.getFechaFundacion());
        }

        if (e.getSource() == regAeroForm.cerrarSesion) {
            cerrarSesion();
            frmLogin frmLogin = new frmLogin();
            frmLogin.setVisible(true);
            regAeroForm.setVisible(false);
        }

        //elementos menu principal
        if (e.getSource() == regAeroForm.btnReTra | e.getSource() == regAeroForm.panelReTra) {
            frmRegTrab frmReTrab = new frmRegTrab();
            frmReTrab.setVisible(true);
            regAeroForm.setVisible(false);
        }

        if (e.getSource() == regAeroForm.btnBusCli | e.getSource() == regAeroForm.panelBusCli) {
            frmBusCli frmBuCli = new frmBusCli();
            frmBuCli.setVisible(true);
            regAeroForm.setVisible(false);
        }

        if (e.getSource() == regAeroForm.btnReAero | e.getSource() == regAeroForm.panelReAero) {
            frmRegAero frmRegAero = new frmRegAero();
            frmRegAero.setVisible(true);
            regAeroForm.setVisible(false);
        }

        if (e.getSource() == regAeroForm.btnRegVue | e.getSource() == regAeroForm.panelRegVue) {
            frmRegVue frmRegVue = new frmRegVue();
            frmRegVue.setVisible(true);
            regAeroForm.setVisible(false);
        }

        if (e.getSource() == regAeroForm.btnRegAvion | e.getSource() == regAeroForm.panelRegAvion) {
            frmRegAv frmRegAv = new frmRegAv();
            frmRegAv.setVisible(true);
            regAeroForm.setVisible(false);
        }

        if (e.getSource() == regAeroForm.btnEstadisticas | e.getSource() == regAeroForm.btnEstadisticas) {
            frmEstadis frmEstadis = new frmEstadis();
            frmEstadis.setVisible(true);
            regAeroForm.setVisible(false);
        }

        //Slider
        if (e.getSource() == regAeroForm.SliderDelMenu) {
            regAeroForm.SliderDelMenu.setEnabled(false);

            int initialSize = regAeroForm.jPanel3.getWidth();
            int finalSize = (initialSize == 250) ? 0 : 250;
            int increment = (finalSize < initialSize) ? -5 : 5; // El tamaño cambia de -5 o 5 (puede cambiarse)
            int delay = 5; // Retardo (ms)

            Timer timer = new Timer(delay, new ActionListener() {
                int currentSize = initialSize; // 0 o 250

                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((increment < 0 && currentSize >= finalSize) || (increment > 0 && currentSize <= finalSize)) {
                        regAeroForm.jPanel3.setSize(currentSize, 660); //0 o 250 dependiendo :v
                        regAeroForm.panelDetras.setLocation(currentSize, regAeroForm.panelDetras.getY()); // el panel se mueve mientras el otro aparece :v
                        regAeroForm.panelDetras.setSize(250 - currentSize, 660); // Ajustar el tamaño //(desactivar para ver la magia)
                        currentSize += increment;
                        regAeroForm.panelDetras.setVisible(true); //UNA HORA POR ESTA WEAAA
                    } else {
                        ((Timer) e.getSource()).stop();

                        if (finalSize == 0) {
                            regAeroForm.panelDetras.setVisible(true);
                        } else {
                            regAeroForm.panelDetras.setVisible(false);
                        }

                        // activa el botoncito
                        regAeroForm.SliderDelMenu.setEnabled(true);
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
        if (e.getSource() == regAeroForm.btnBusCli | e.getSource() == regAeroForm.panelBusCli) {
            maus = true;
            cambiarColores(regAeroForm.btnBusCli, regAeroForm.panelBusCli);
        }

        if (e.getSource() == regAeroForm.btnReTra | e.getSource() == regAeroForm.panelReTra) {
            maus = true;
            cambiarColores(regAeroForm.btnReTra, regAeroForm.panelReTra);
        }

        if (e.getSource() == regAeroForm.btnReAero | e.getSource() == regAeroForm.panelReAero) {
            maus = true;
            cambiarColores(regAeroForm.btnReAero, regAeroForm.panelReAero);
        }

        if (e.getSource() == regAeroForm.btnRegVue | e.getSource() == regAeroForm.panelRegVue) {
            maus = true;
            cambiarColores(regAeroForm.btnRegVue, regAeroForm.panelRegVue);
        }

        if (e.getSource() == regAeroForm.btnRegAvion | e.getSource() == regAeroForm.panelRegAvion) {
            maus = true;
            cambiarColores(regAeroForm.btnRegAvion, regAeroForm.panelRegAvion);
        }

        if (e.getSource() == regAeroForm.btnEstadisticas | e.getSource() == regAeroForm.panelEstadisticas) {
            maus = true;
            cambiarColores(regAeroForm.btnEstadisticas, regAeroForm.panelEstadisticas);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == regAeroForm.btnBusCli | e.getSource() == regAeroForm.panelBusCli) {
            maus = false;
            cambiarColores(regAeroForm.btnBusCli, regAeroForm.panelBusCli);
        }

        if (e.getSource() == regAeroForm.btnReTra | e.getSource() == regAeroForm.panelReTra) {
            maus = false;
            cambiarColores(regAeroForm.btnReTra, regAeroForm.panelReTra);
        }

        if (e.getSource() == regAeroForm.btnReTra | e.getSource() == regAeroForm.panelReTra) {
            maus = false;
            cambiarColores(regAeroForm.btnReTra, regAeroForm.panelReTra);
        }

        if (e.getSource() == regAeroForm.btnReAero | e.getSource() == regAeroForm.panelReAero) {
            maus = false;
            cambiarColores(regAeroForm.btnReAero, regAeroForm.panelReAero);
        }

        if (e.getSource() == regAeroForm.btnRegVue | e.getSource() == regAeroForm.panelRegVue) {
            maus = false;
            cambiarColores(regAeroForm.btnRegVue, regAeroForm.panelRegVue);
        }

        if (e.getSource() == regAeroForm.btnRegAvion | e.getSource() == regAeroForm.panelRegAvion) {
            maus = false;
            cambiarColores(regAeroForm.btnRegAvion, regAeroForm.panelRegAvion);
        }

        if (e.getSource() == regAeroForm.btnEstadisticas | e.getSource() == regAeroForm.panelEstadisticas) {
            maus = false;
            cambiarColores(regAeroForm.btnEstadisticas, regAeroForm.panelEstadisticas);
        }

    }

    void datitos() {

        int TotalAerolineasRegistradas = objAD.obtenerTotalAerolineasRegistradas();
        regAeroForm.lblAeroRegistradas.setText("" + TotalAerolineasRegistradas);

        String AerolineaConMasReservas = objAD.obtenerAerolineaConMasReservas();
        regAeroForm.lblAeroCMReservas.setText(AerolineaConMasReservas);

    }

    void listado() {
        DefaultTableModel dt = (DefaultTableModel) regAeroForm.tablaAerolinea.getModel();
        dt.setRowCount(0);
        for (Aerolinea x : objAD.Listado()) {
            Object v[] = {x.getIdAerolinea(), x.getNombre(), x.getPaisOrigen(), x.getTelefono(), x.getPaginaWeb(), x.getFechaFundacion()};
            dt.addRow(v);
        }
    }

    public void obtenerUsuarioSesionado() {
        Trabajador trabajadorSesionado = LoginControlador.getTrabajadorSesionado();
        if (trabajadorSesionado != null) {

            regAeroForm.lblIDUsu.setText("" + trabajadorSesionado.getCodigoTra());
            regAeroForm.lblUsuarioSes.setText(trabajadorSesionado.getUsuario());
            regAeroForm.lblNombreSes.setText(trabajadorSesionado.getNombre());
            regAeroForm.lblApeUsu.setText(trabajadorSesionado.getApellido());
            imagenUsuarioSes = trabajadorSesionado.getFoto();
            ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
            regAeroForm.lblFotoSes.setIcon(IconoSelec);
            regAeroForm.lblFotoSes2.setIcon(IconoSelec);
            regAeroForm.lblUsuarioSes2.setText(trabajadorSesionado.getUsuario());

            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaDeInicio = horaActual.format(formatter);
            regAeroForm.lblTiempSes.setText("" + horaDeInicio);
        } else {
            System.out.println("Se supone que esto no debe pasar XD");
        }
    }

    void guardar() {
        try {
            int codigo = Integer.parseInt(regAeroForm.txtID.getText());
            String nombre = regAeroForm.txtNombre.getText();
            String paisOrigen = regAeroForm.txtPais.getText();
            String telefono = regAeroForm.txtTelefono.getText();
            String paginaWeb = regAeroForm.txtPagina.getText();

            JDateChooser dateChooser = regAeroForm.DCDate;
            Date fechaFundacion = dateChooser.getDate();
            if (nombre.length() > 0) {
                if (codigo > 0) {
                    Aerolinea pr = new Aerolinea(codigo, nombre, paisOrigen, telefono, paginaWeb, fechaFundacion);
                    objAD.crearAerolinea(pr);
                    regAeroForm.txtID.setText("");
                    regAeroForm.txtNombre.setText("");
                    regAeroForm.txtPais.setText("");
                    regAeroForm.txtTelefono.setText("");
                    regAeroForm.txtPagina.setText("");
                    regAeroForm.DCDate.setDate(null);
                    listado();
                    JOptionPane.showMessageDialog(null, "Aerolinea agregada correctamente");
                } else {
                    JOptionPane.showMessageDialog(null, "El codigo debe ser mayor a 0");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre");
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos en las casillas correctamente");
        }
    }

    void eliminar() {
        String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
        try {
            if (confirm.equals("CONTINUAR")) {
                int codigo = Integer.parseInt(regAeroForm.txtID.getText());
                objAD.eliminarAerolinea(codigo);
                regAeroForm.txtID.setText("");
                regAeroForm.txtNombre.setText("");
                regAeroForm.txtPais.setText("");
                regAeroForm.txtTelefono.setText("");
                regAeroForm.txtPagina.setText("");
                regAeroForm.DCDate.setDate(null);
                JOptionPane.showMessageDialog(null, "Eliminacion completada exitosamente");
                listado();
            } else {
                JOptionPane.showMessageDialog(null, "Proceso cancelado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una Aerolinea");
        }        // TODO add your handling code here:
    }

    void actualizar() {
        try {
            int idAerolinea = Integer.parseInt(regAeroForm.txtID.getText());
            String nombre = regAeroForm.txtNombre.getText();
            String paisOrigen = regAeroForm.txtPais.getText();
            String telefono = regAeroForm.txtTelefono.getText();
            String paginaWeb = regAeroForm.txtPagina.getText();
            JDateChooser dateChooser = regAeroForm.DCDate;
            Date fechaFundacion = dateChooser.getDate();

            if (nombre.length() > 0) {
                if (idAerolinea > 0) {
                    String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
                    if (confirm.equals("CONTINUAR")) {
                        Aerolinea pr = new Aerolinea(idAerolinea, nombre, paisOrigen, telefono, paginaWeb, fechaFundacion);
                        objAD.modificarAerolinea(pr);
                        regAeroForm.txtID.setText("");
                        regAeroForm.txtNombre.setText("");
                        regAeroForm.txtPais.setText("");
                        regAeroForm.txtTelefono.setText("");
                        regAeroForm.txtPagina.setText("");
                        regAeroForm.DCDate.setDate(null);
                        JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
                        listado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Proceso cancelado");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El codigo debe ser mayor a 0");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un nombre");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una Aerolinea");
        }
    }

    //colores panel/jlabel"botones" xd
    private java.awt.Color ColorEnteredBoton = new java.awt.Color(55, 231, 173);
    private java.awt.Color ColorOriginalPanel = new java.awt.Color(67, 90, 132);
    private java.awt.Color ColorEnteredPanel = new java.awt.Color(110, 153, 139);

    private boolean maus = false;

    private void cambiarColores(Component boton, Component panel) {
        if (maus) {
            boton.setForeground(ColorEnteredBoton);
            panel.setBackground(ColorEnteredPanel);
        } else {
            boton.setForeground(Color.WHITE);
            panel.setBackground(ColorOriginalPanel);
        }
    }
}
