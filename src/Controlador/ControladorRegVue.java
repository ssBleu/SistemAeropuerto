package Controlador;

import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Trabajador;
import Modelo.Vuelo;
import static Vista.Controladores.objAvD;
import static Vista.Controladores.objVD;
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
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class ControladorRegVue implements ActionListener, MouseListener {

    private frmRegVue regVueForm;
    private byte[] imagenUsuarioSes;

    public ControladorRegVue(frmRegVue form) {
        regVueForm = form;

        objVD.actualizarEstadosVuelosRealizados();
        listado();
        obtenerUsuarioSesionado();
        datitos();
        //AddListens
        regVueForm.btnGuardar.addActionListener(this);
        regVueForm.btnEliminar.addActionListener(this);
        regVueForm.btnActualizar.addActionListener(this);
        regVueForm.btnCambiarEstado.addActionListener(this);
        //MouseListeners
        regVueForm.btnCerrar.addMouseListener(this);
        regVueForm.btnMinimizar.addMouseListener(this);
        regVueForm.tablaVuelo.addMouseListener(this);

        //Para el panel Deslizante
        regVueForm.SliderDelMenu.addMouseListener(this);
        regVueForm.cerrarSesion.addMouseListener(this);

        //Elementos del menu principal
        regVueForm.btnBusCli.addMouseListener(this);
        regVueForm.panelBusCli.addMouseListener(this);

        regVueForm.btnReTra.addMouseListener(this);
        regVueForm.panelReTra.addMouseListener(this);

        regVueForm.btnReAero.addMouseListener(this);
        regVueForm.panelReAero.addMouseListener(this);

        regVueForm.btnRegVue.addMouseListener(this);
        regVueForm.panelRegVue.addMouseListener(this);

        regVueForm.btnRegAvion.addMouseListener(this);
        regVueForm.panelRegAvion.addMouseListener(this);

        regVueForm.btnEstadisticas.addMouseListener(this);
        regVueForm.panelEstadisticas.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == regVueForm.btnGuardar) {
            guardar();
        }

        if (e.getSource() == regVueForm.btnActualizar) {
            actualizar();
        }

        if (e.getSource() == regVueForm.btnEliminar) {
            eliminar();
        }

        if (e.getSource() == regVueForm.btnCambiarEstado) {
            cambiarEstado();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == regVueForm.btnCerrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "EXIT", dialogButton);
            if (result == 0) {
                System.exit(0);
            }
        }

        if (e.getSource() == regVueForm.btnMinimizar) {
            regVueForm.setState(regVueForm.ICONIFIED);
        }

        if (e.getSource() == regVueForm.tablaVuelo) {
            int VL = regVueForm.tablaVuelo.getSelectedRow();
            int Codigo = Integer.parseInt(regVueForm.tablaVuelo.getValueAt(VL, 0).toString());

            Vuelo x = objVD.buscarVuelo(Codigo);

            regVueForm.txtIDVuelo.setText("" + x.getIdVuelo());
            regVueForm.txtOrigen.setText(x.getOrigen());
            regVueForm.txtDestino.setText(x.getDestino());
            regVueForm.txtDurac.setText(x.getDuracion());
            regVueForm.txtTipo.setText(x.getTipo());
            regVueForm.FSalida.setDate(x.getFechaSalida());
            regVueForm.FLlegada.setDate(x.getFechaSalida());
            regVueForm.txtPrecio.setText("" + x.getPrecio());
            regVueForm.cboAvion.setSelectedItem(x.getIdAvion());
        }

        if (e.getSource() == regVueForm.cerrarSesion) {
            cerrarSesion();
            frmLogin frmLogin = new frmLogin();
            frmLogin.setVisible(true);
            regVueForm.setVisible(false);
        }

        //elementos menu principal
        if (e.getSource() == regVueForm.btnReTra | e.getSource() == regVueForm.panelReTra) {
            frmRegTrab frmReTrab = new frmRegTrab();
            frmReTrab.setVisible(true);
            regVueForm.setVisible(false);
        }

        if (e.getSource() == regVueForm.btnBusCli | e.getSource() == regVueForm.panelBusCli) {
            frmBusCli frmBuCli = new frmBusCli();
            frmBuCli.setVisible(true);
            regVueForm.setVisible(false);
        }

        if (e.getSource() == regVueForm.btnReAero | e.getSource() == regVueForm.panelReAero) {
            frmRegAero frmRegAero = new frmRegAero();
            frmRegAero.setVisible(true);
            regVueForm.setVisible(false);
        }

        if (e.getSource() == regVueForm.btnRegVue | e.getSource() == regVueForm.panelRegVue) {
            frmRegVue frmRegVue = new frmRegVue();
            frmRegVue.setVisible(true);
            regVueForm.setVisible(false);
        }

        if (e.getSource() == regVueForm.btnRegAvion | e.getSource() == regVueForm.panelRegAvion) {
            frmRegAv frmRegAv = new frmRegAv();
            frmRegAv.setVisible(true);
            regVueForm.setVisible(false);
        }

        if (e.getSource() == regVueForm.btnEstadisticas | e.getSource() == regVueForm.btnEstadisticas) {
            frmEstadis frmEstadis = new frmEstadis();
            frmEstadis.setVisible(true);
            regVueForm.setVisible(false);
        }

        //Slider
        if (e.getSource() == regVueForm.SliderDelMenu) {
            regVueForm.SliderDelMenu.setEnabled(false);

            int initialSize = regVueForm.jPanel3.getWidth();
            int finalSize = (initialSize == 250) ? 0 : 250;
            int increment = (finalSize < initialSize) ? -5 : 5; // El tamaño cambia de -5 o 5 (puede cambiarse)
            int delay = 5; // Retardo (ms)

            Timer timer = new Timer(delay, new ActionListener() {
                int currentSize = initialSize; // 0 o 250

                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((increment < 0 && currentSize >= finalSize) || (increment > 0 && currentSize <= finalSize)) {
                        regVueForm.jPanel3.setSize(currentSize, 660); //0 o 250 dependiendo :v
                        regVueForm.panelDetras.setLocation(currentSize, regVueForm.panelDetras.getY()); // el panel se mueve mientras el otro aparece :v
                        regVueForm.panelDetras.setSize(250 - currentSize, 660); // Ajustar el tamaño //(desactivar para ver la magia)
                        currentSize += increment;
                        regVueForm.panelDetras.setVisible(true); //UNA HORA POR ESTA WEAAA
                    } else {
                        ((Timer) e.getSource()).stop();

                        if (finalSize == 0) {
                            regVueForm.panelDetras.setVisible(true);
                        } else {
                            regVueForm.panelDetras.setVisible(false);
                        }

                        // activa el botoncito
                        regVueForm.SliderDelMenu.setEnabled(true);
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
        if (e.getSource() == regVueForm.btnBusCli | e.getSource() == regVueForm.panelBusCli) {
            maus = true;
            cambiarColores(regVueForm.btnBusCli, regVueForm.panelBusCli);
        }

        if (e.getSource() == regVueForm.btnReTra | e.getSource() == regVueForm.panelReTra) {
            maus = true;
            cambiarColores(regVueForm.btnReTra, regVueForm.panelReTra);
        }

        if (e.getSource() == regVueForm.btnReAero | e.getSource() == regVueForm.panelReAero) {
            maus = true;
            cambiarColores(regVueForm.btnReAero, regVueForm.panelReAero);
        }

        if (e.getSource() == regVueForm.btnRegVue | e.getSource() == regVueForm.panelRegVue) {
            maus = true;
            cambiarColores(regVueForm.btnRegVue, regVueForm.panelRegVue);
        }

        if (e.getSource() == regVueForm.btnRegAvion | e.getSource() == regVueForm.panelRegAvion) {
            maus = true;
            cambiarColores(regVueForm.btnRegAvion, regVueForm.panelRegAvion);
        }

        if (e.getSource() == regVueForm.btnEstadisticas | e.getSource() == regVueForm.panelEstadisticas) {
            maus = true;
            cambiarColores(regVueForm.btnEstadisticas, regVueForm.panelEstadisticas);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == regVueForm.btnBusCli | e.getSource() == regVueForm.panelBusCli) {
            maus = false;
            cambiarColores(regVueForm.btnBusCli, regVueForm.panelBusCli);
        }

        if (e.getSource() == regVueForm.btnReTra | e.getSource() == regVueForm.panelReTra) {
            maus = false;
            cambiarColores(regVueForm.btnReTra, regVueForm.panelReTra);
        }

        if (e.getSource() == regVueForm.btnReTra | e.getSource() == regVueForm.panelReTra) {
            maus = false;
            cambiarColores(regVueForm.btnReTra, regVueForm.panelReTra);
        }

        if (e.getSource() == regVueForm.btnReAero | e.getSource() == regVueForm.panelReAero) {
            maus = false;
            cambiarColores(regVueForm.btnReAero, regVueForm.panelReAero);
        }

        if (e.getSource() == regVueForm.btnRegVue | e.getSource() == regVueForm.panelRegVue) {
            maus = false;
            cambiarColores(regVueForm.btnRegVue, regVueForm.panelRegVue);
        }

        if (e.getSource() == regVueForm.btnRegAvion | e.getSource() == regVueForm.panelRegAvion) {
            maus = false;
            cambiarColores(regVueForm.btnRegAvion, regVueForm.panelRegAvion);
        }

        if (e.getSource() == regVueForm.btnEstadisticas | e.getSource() == regVueForm.panelEstadisticas) {
            maus = false;
            cambiarColores(regVueForm.btnEstadisticas, regVueForm.panelEstadisticas);
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

            regVueForm.lblIDUsu.setText("" + trabajadorSesionado.getCodigoTra());
            regVueForm.lblUsuarioSes.setText(trabajadorSesionado.getUsuario());
            regVueForm.lblNombreSes.setText(trabajadorSesionado.getNombre());
            regVueForm.lblApeUsu.setText(trabajadorSesionado.getApellido());
            imagenUsuarioSes = trabajadorSesionado.getFoto();
            ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
            regVueForm.lblFotoSes.setIcon(IconoSelec);
            regVueForm.lblFotoSes2.setIcon(IconoSelec);
            regVueForm.lblUsuarioSes2.setText(trabajadorSesionado.getUsuario());

            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaDeInicio = horaActual.format(formatter);
            regVueForm.lblTiempSes.setText("" + horaDeInicio);
        } else {
            System.out.println("Se supone que esto no debe pasar XD");
        }
    }

    void listado() {
        DefaultTableModel dt = (DefaultTableModel) regVueForm.tablaVuelo.getModel();

        dt.setRowCount(0);
        for (Vuelo x : objVD.obtenerListaVuelos()) {
            Object v[] = {x.getIdVuelo(), x.getIdAvion(), x.getNombreAvion(), x.getNombreAerolinea(), x.getOrigen(),
                x.getDestino(), x.getDuracion(), x.getFechaSalida(), x.getFechaSalida(), x.getTipo(), x.getPrecio(), x.getEstadoVuelo()};
            dt.addRow(v);
        }
    }

    void datitos() {

        double PromPrecioVue = objVD.calcularTendenciaPromedioPrecios();
        regVueForm.lblPromPrecioVue.setText("" + PromPrecioVue);

        String TipoVueloMRegistrado = objVD.obtenerTipoVueloMasRegistrado();
        regVueForm.lblVueloMRegistrado.setText(TipoVueloMRegistrado);

    }

    void guardar() {

        try {
            String IDVuelo = regVueForm.txtIDVuelo.getText();

            String origen = regVueForm.txtOrigen.getText();
            String destino = regVueForm.txtDestino.getText();
            String duracion = regVueForm.txtDurac.getText();
            String tipo = regVueForm.txtTipo.getText();

            JDateChooser dateChooser = regVueForm.FSalida;
            Date Fsali = dateChooser.getDate();
            JDateChooser jdateChooser = regVueForm.FLlegada;
            Date Flleg = jdateChooser.getDate();
            double precio = Double.parseDouble(regVueForm.txtPrecio.getText());

            String modeloAvion = (String) regVueForm.cboAvion.getSelectedItem();
            String idAvion = String.valueOf(objAvD.obtenerIdAvionPorModelo(modeloAvion));
            Vuelo vuelo = new Vuelo(IDVuelo, origen, destino, Fsali, Flleg, duracion, idAvion, precio, tipo, null);
            objVD.crearVuelo(vuelo);
            regVueForm.txtIDVuelo.setText("");
            regVueForm.txtOrigen.setText("");
            regVueForm.txtDestino.setText("");
            regVueForm.txtDurac.setText("");
            regVueForm.txtTipo.setText("");
            regVueForm.FSalida.setDate(null);
            regVueForm.FLlegada.setDate(null);
            regVueForm.txtPrecio.setText("");
            regVueForm.cboAvion.setSelectedItem("");
            listado();

        } catch (SQLException ex) {
            Logger.getLogger(frmRegAv.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void actualizar() {
        try {
            String IDVuelo = regVueForm.txtIDVuelo.getText();

            String origen = regVueForm.txtOrigen.getText();
            String destino = regVueForm.txtDestino.getText();
            String duracion = regVueForm.txtDurac.getText();
            String tipo = regVueForm.txtTipo.getText();

            JDateChooser dateChooser = regVueForm.FSalida;
            Date Fsali = dateChooser.getDate();
            JDateChooser jdateChooser = regVueForm.FLlegada;
            Date Flleg = jdateChooser.getDate();
            double precio = Double.parseDouble(regVueForm.txtPrecio.getText());

            String modeloAvion = (String) regVueForm.cboAvion.getSelectedItem();
            String idAvion = String.valueOf(objAvD.obtenerIdAvionPorModelo(modeloAvion));

            if (origen.length() > 0) {
                if (precio > 0) {
                    String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
                    if (confirm.equals("CONTINUAR")) {
                        Vuelo pr = new Vuelo(IDVuelo, origen, destino, Fsali, Flleg, duracion, idAvion, precio, tipo, null);
                        objVD.modificarVuelo(pr);
                        regVueForm.txtIDVuelo.setText("");
                        regVueForm.txtOrigen.setText("");
                        regVueForm.txtDestino.setText("");
                        regVueForm.txtDurac.setText("");
                        regVueForm.txtTipo.setText("");
                        regVueForm.FSalida.setDate(null);
                        regVueForm.FLlegada.setDate(null);
                        regVueForm.txtPrecio.setText("");
                        regVueForm.cboAvion.setSelectedItem("");
                        JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
                        listado();
                    } else {
                        JOptionPane.showMessageDialog(null, "Proceso cancelado");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El precio de vuelo debe ser mayor a 0");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese un Origen de vuelo");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione una Aerolinea");
        }
    }

    void eliminar() {
        String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
        try {
            if (confirm.equals("CONTINUAR")) {
                String codigo = regVueForm.txtIDVuelo.getText();
                objVD.eliminarVuelo(codigo);
                regVueForm.txtIDVuelo.setText("");
                regVueForm.txtOrigen.setText("");
                regVueForm.txtDestino.setText("");
                regVueForm.txtDurac.setText("");
                regVueForm.txtTipo.setText("");
                regVueForm.FSalida.setDate(null);
                regVueForm.FLlegada.setDate(null);
                regVueForm.txtPrecio.setText("");
                regVueForm.cboAvion.setSelectedItem("");
                JOptionPane.showMessageDialog(null, "Eliminacion completada exitosamente");
                listado();
            } else {
                JOptionPane.showMessageDialog(null, "Proceso cancelado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccionar un Vuelo");
        }
    }

    void cambiarEstado() {
        int filaSeleccionada = regVueForm.tablaVuelo.getSelectedRow();

        if (filaSeleccionada != -1) {
            String idVuelo = regVueForm.tablaVuelo.getValueAt(filaSeleccionada, 0).toString();
            String estadoVuelo = regVueForm.tablaVuelo.getValueAt(filaSeleccionada, 11).toString();

            int confirmacion;
            String mensaje;

            if (estadoVuelo.equalsIgnoreCase("CANCELADO")) {
                confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de descancelar el vuelo?", "Confirmar descancelación", JOptionPane.YES_NO_OPTION);
                mensaje = "Vuelo descancelado exitosamente";
            } else {
                confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de cancelar el vuelo?", "Confirmar cancelación", JOptionPane.YES_NO_OPTION);
                mensaje = "Vuelo cancelado exitosamente";
            }

            if (confirmacion == JOptionPane.YES_OPTION) {
                objVD.cambiarEstadoVuelo(idVuelo, estadoVuelo);
                JOptionPane.showMessageDialog(null, mensaje);
            }
            listado();

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un vuelo de la tabla");
        }
    }

}
