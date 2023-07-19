package Controlador;

import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Trabajador;
import Modelo.Vuelo;
import static Vista.Controladores.objVD;
import Vista.frmBusCli;
import Vista.frmCompraBole;
import Vista.frmEstadis;
import Vista.frmLogin;
import Vista.frmRegAero;
import Vista.frmRegAv;
import Vista.frmRegTrab;
import Vista.frmRegVue;
import Vista.frmReserva;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class ControladorCompraBole implements ActionListener, MouseListener, ChangeListener {

    private frmCompraBole compraBoleForm;

    private byte[] imagenUsuarioSes;

    public ControladorCompraBole(frmCompraBole form) {
        compraBoleForm = form;

        listadoVuelosInicial();
        datitos();
        obtenerUsuarioSesionado();

        //ActionListeners
        compraBoleForm.btnBuscar.addActionListener(this);
        compraBoleForm.btnReservar.addActionListener(this);
        //MouseListeners
        compraBoleForm.btnCerrar.addMouseListener(this);
        compraBoleForm.btnMinimizar.addMouseListener(this);

        //StatesChagnged
        compraBoleForm.slifer.addChangeListener(this);
        //Para el panel Deslizante
        compraBoleForm.SliderDelMenu.addMouseListener(this);
        compraBoleForm.cerrarSesion.addMouseListener(this);

        //Elementos del menu principal
        compraBoleForm.btnBusCli.addMouseListener(this);
        compraBoleForm.panelBusCli.addMouseListener(this);

        compraBoleForm.btnReTra.addMouseListener(this);
        compraBoleForm.panelReTra.addMouseListener(this);

        compraBoleForm.btnReAero.addMouseListener(this);
        compraBoleForm.panelReAero.addMouseListener(this);

        compraBoleForm.btnRegVue.addMouseListener(this);
        compraBoleForm.panelRegVue.addMouseListener(this);

        compraBoleForm.btnRegAvion.addMouseListener(this);
        compraBoleForm.panelRegAvion.addMouseListener(this);

        compraBoleForm.btnEstadisticas.addMouseListener(this);
        compraBoleForm.panelEstadisticas.addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compraBoleForm.btnMinimizar) {
            int selectedRow = compraBoleForm.tablaVueloBoleto.getSelectedRow();
            if (selectedRow != -1) {
                int idVuelo = Integer.parseInt(compraBoleForm.tablaVueloBoleto.getValueAt(selectedRow, 0).toString());

                Vuelo vueloSeleccionado = objVD.buscarVuelo(idVuelo);
                frmReserva frmReser = new frmReserva();
                frmReser.cargarPasajeros(vueloSeleccionado);
                frmReser.setVisible(true);
                compraBoleForm.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(compraBoleForm, "Debe seleccionar un vuelo para realizar la reserva", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == compraBoleForm.btnBuscar) {
            filtrarTabla();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == compraBoleForm.btnCerrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "EXIT", dialogButton);
            if (result == 0) {
                System.exit(0);
            }
        }

        if (e.getSource() == compraBoleForm.btnMinimizar) {
            compraBoleForm.setState(compraBoleForm.ICONIFIED);
        }

        if (e.getSource() == compraBoleForm.cerrarSesion) {
            cerrarSesion();
            frmLogin frmLogin = new frmLogin();
            frmLogin.setVisible(true);
            compraBoleForm.setVisible(false);
        }

        //elementos menu principal
        if (e.getSource() == compraBoleForm.btnReTra | e.getSource() == compraBoleForm.panelReTra) {
            frmRegTrab frmReTrab = new frmRegTrab();
            frmReTrab.setVisible(true);
            compraBoleForm.setVisible(false);
        }

        if (e.getSource() == compraBoleForm.btnBusCli | e.getSource() == compraBoleForm.panelBusCli) {
            frmBusCli frmBuCli = new frmBusCli();
            frmBuCli.setVisible(true);
            compraBoleForm.setVisible(false);
        }

        if (e.getSource() == compraBoleForm.btnReAero | e.getSource() == compraBoleForm.panelReAero) {
            frmRegAero frmRegAero = new frmRegAero();
            frmRegAero.setVisible(true);
            compraBoleForm.setVisible(false);
        }

        if (e.getSource() == compraBoleForm.btnRegVue | e.getSource() == compraBoleForm.panelRegVue) {
            frmRegVue frmRegVue = new frmRegVue();
            frmRegVue.setVisible(true);
            compraBoleForm.setVisible(false);
        }

        if (e.getSource() == compraBoleForm.btnRegAvion | e.getSource() == compraBoleForm.panelRegAvion) {
            frmRegAv frmRegAv = new frmRegAv();
            frmRegAv.setVisible(true);
            compraBoleForm.setVisible(false);
        }

        if (e.getSource() == compraBoleForm.btnEstadisticas | e.getSource() == compraBoleForm.btnEstadisticas) {
            frmEstadis frmEstadis = new frmEstadis();
            frmEstadis.setVisible(true);
            compraBoleForm.setVisible(false);
        }

        //Slider
        if (e.getSource() == compraBoleForm.SliderDelMenu) {
            compraBoleForm.SliderDelMenu.setEnabled(false);

            int initialSize = compraBoleForm.jPanel3.getWidth();
            int finalSize = (initialSize == 250) ? 0 : 250;
            int increment = (finalSize < initialSize) ? -5 : 5; // El tamaño cambia de -5 o 5 (puede cambiarse)
            int delay = 5; // Retardo (ms)

            Timer timer = new Timer(delay, new ActionListener() {
                int currentSize = initialSize; // 0 o 250

                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((increment < 0 && currentSize >= finalSize) || (increment > 0 && currentSize <= finalSize)) {
                        compraBoleForm.jPanel3.setSize(currentSize, 660); //0 o 250 dependiendo :v
                        compraBoleForm.panelDetras.setLocation(currentSize, compraBoleForm.panelDetras.getY()); // el panel se mueve mientras el otro aparece :v
                        compraBoleForm.panelDetras.setSize(250 - currentSize, 660); // Ajustar el tamaño //(desactivar para ver la magia)
                        currentSize += increment;
                        compraBoleForm.panelDetras.setVisible(true); //UNA HORA POR ESTA WEAAA
                    } else {
                        ((Timer) e.getSource()).stop();

                        if (finalSize == 0) {
                            compraBoleForm.panelDetras.setVisible(true);
                        } else {
                            compraBoleForm.panelDetras.setVisible(false);
                        }

                        // activa el botoncito
                        compraBoleForm.SliderDelMenu.setEnabled(true);
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
        if (e.getSource() == compraBoleForm.btnBusCli | e.getSource() == compraBoleForm.panelBusCli) {
            maus = true;
            cambiarColores(compraBoleForm.btnBusCli, compraBoleForm.panelBusCli);
        }

        if (e.getSource() == compraBoleForm.btnReTra | e.getSource() == compraBoleForm.panelReTra) {
            maus = true;
            cambiarColores(compraBoleForm.btnReTra, compraBoleForm.panelReTra);
        }

        if (e.getSource() == compraBoleForm.btnReAero | e.getSource() == compraBoleForm.panelReAero) {
            maus = true;
            cambiarColores(compraBoleForm.btnReAero, compraBoleForm.panelReAero);
        }

        if (e.getSource() == compraBoleForm.btnRegVue | e.getSource() == compraBoleForm.panelRegVue) {
            maus = true;
            cambiarColores(compraBoleForm.btnRegVue, compraBoleForm.panelRegVue);
        }

        if (e.getSource() == compraBoleForm.btnRegAvion | e.getSource() == compraBoleForm.panelRegAvion) {
            maus = true;
            cambiarColores(compraBoleForm.btnRegAvion, compraBoleForm.panelRegAvion);
        }

        if (e.getSource() == compraBoleForm.btnEstadisticas | e.getSource() == compraBoleForm.panelEstadisticas) {
            maus = true;
            cambiarColores(compraBoleForm.btnEstadisticas, compraBoleForm.panelEstadisticas);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == compraBoleForm.btnBusCli | e.getSource() == compraBoleForm.panelBusCli) {
            maus = false;
            cambiarColores(compraBoleForm.btnBusCli, compraBoleForm.panelBusCli);
        }

        if (e.getSource() == compraBoleForm.btnReTra | e.getSource() == compraBoleForm.panelReTra) {
            maus = false;
            cambiarColores(compraBoleForm.btnReTra, compraBoleForm.panelReTra);
        }

        if (e.getSource() == compraBoleForm.btnReTra | e.getSource() == compraBoleForm.panelReTra) {
            maus = false;
            cambiarColores(compraBoleForm.btnReTra, compraBoleForm.panelReTra);
        }

        if (e.getSource() == compraBoleForm.btnReAero | e.getSource() == compraBoleForm.panelReAero) {
            maus = false;
            cambiarColores(compraBoleForm.btnReAero, compraBoleForm.panelReAero);
        }

        if (e.getSource() == compraBoleForm.btnRegVue | e.getSource() == compraBoleForm.panelRegVue) {
            maus = false;
            cambiarColores(compraBoleForm.btnRegVue, compraBoleForm.panelRegVue);
        }

        if (e.getSource() == compraBoleForm.btnRegAvion | e.getSource() == compraBoleForm.panelRegAvion) {
            maus = false;
            cambiarColores(compraBoleForm.btnRegAvion, compraBoleForm.panelRegAvion);
        }

        if (e.getSource() == compraBoleForm.btnEstadisticas | e.getSource() == compraBoleForm.panelEstadisticas) {
            maus = false;
            cambiarColores(compraBoleForm.btnEstadisticas, compraBoleForm.panelEstadisticas);
        }

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == compraBoleForm.slifer) {
            if (compraBoleForm.slifer.getValue() < 1000) {
                compraBoleForm.sliderText.setText("Menor o igual a: " + compraBoleForm.slifer.getValue());
            } else {
                compraBoleForm.sliderText.setText("Cualquier Precio");
            }
        }
    }

    //metodos
    public void obtenerUsuarioSesionado() {
        Trabajador trabajadorSesionado = LoginControlador.getTrabajadorSesionado();
        if (trabajadorSesionado != null) {

            compraBoleForm.lblIDUsu.setText("" + trabajadorSesionado.getCodigoTra());
            compraBoleForm.lblUsuarioSes.setText(trabajadorSesionado.getUsuario());
            compraBoleForm.lblNombreSes.setText(trabajadorSesionado.getNombre());
            compraBoleForm.lblApeUsu.setText(trabajadorSesionado.getApellido());
            imagenUsuarioSes = trabajadorSesionado.getFoto();
            ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
            compraBoleForm.lblFotoSes.setIcon(IconoSelec);
            compraBoleForm.lblFotoSes2.setIcon(IconoSelec);
            compraBoleForm.lblUsuarioSes2.setText(trabajadorSesionado.getUsuario());

            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaDeInicio = horaActual.format(formatter);
            compraBoleForm.lblTiempSes.setText("" + horaDeInicio);
        } else {
            System.out.println("Se supone que esto no debe pasar XD");
        }
    }

    void datitos() {

        double promedioPrecios = objVD.calcularTendenciaPromedioPrecios();
        compraBoleForm.lblPromedioPrecios.setText("" + promedioPrecios);

        String destinoPopular = objVD.obtenerDestinoMasPopular();
        compraBoleForm.lblDestinoPopular.setText(destinoPopular);
    }

    void listadoVuelosInicial() {
        DefaultTableModel dt = (DefaultTableModel) compraBoleForm.tablaVueloBoleto.getModel();

        dt.setRowCount(0);
        for (Vuelo x : objVD.obtenerListaVuelosActivos()) {
            Object v[] = {x.getIdVuelo(), x.getOrigen(), x.getDestino(), x.getDuracion(), x.getTipo(), x.getNombreAerolinea(), x.getPrecio()};
            dt.addRow(v);
        }

    }

    private void filtrarTabla() {
        DefaultTableModel dt = (DefaultTableModel) compraBoleForm.tablaVueloBoleto.getModel();
        String origenSeleccionado = (String) compraBoleForm.cboOrigen.getSelectedItem();
        String destinoSeleccionado = (String) compraBoleForm.cboDestino.getSelectedItem();
        String duracionSeleccionada = (String) compraBoleForm.cboDuracion.getSelectedItem();

        int precioElegido = compraBoleForm.slifer.getValue();

        if (origenSeleccionado.equals("Cualquiera")) {
            origenSeleccionado = "";
        }
        if (destinoSeleccionado.equals("Cualquiera")) {
            destinoSeleccionado = "";
        }
        if (duracionSeleccionada.equals("Cualquiera")) {
            duracionSeleccionada = "";
        }

        dt.setRowCount(0);
        List<Vuelo> vuelosFiltrados = objVD.obtenerVuelosFiltrados(origenSeleccionado, destinoSeleccionado, duracionSeleccionada, precioElegido);

        if (vuelosFiltrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron vuelos que cumplan con los criterios de búsqueda.");
        } else {
            for (Vuelo x : vuelosFiltrados) {
                Object v[] = {x.getIdVuelo(), x.getOrigen(), x.getDestino(), x.getDuracion(), x.getTipo(),
                    x.getNombreAerolinea(), String.valueOf(x.getPrecio())};
                dt.addRow(v);
            }
        }
    }

    //COLORES Y COSAS
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

}
