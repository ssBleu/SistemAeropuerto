package Controlador;

import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Pasajero;
import Modelo.Reserva;
import Modelo.Trabajador;
import Modelo.Vuelo;
import static Vista.Controladores.objPS;
import static Vista.Controladores.objRS;
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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class ControladorReserva implements ActionListener, MouseListener {

    private byte[] imagenUsuarioSes;
    private frmReserva reservaForm;

    public ControladorReserva(frmReserva form) {
        reservaForm = form;

        obtenerUsuarioSesionado();
        actualizarTextRCBO();
        //Actions
        reservaForm.btnCambVuelo.addActionListener(this);
        reservaForm.btnComprar.addActionListener(this);
        reservaForm.btnImprimir.addActionListener(this);
        reservaForm.cboDNIs.addActionListener(this);

        //MouseListeners
        reservaForm.btnCerrar.addMouseListener(this);
        reservaForm.btnMinimizar.addMouseListener(this);
        reservaForm.tablaReservas.addMouseListener(this);

        //Para el panel Deslizante
        reservaForm.SliderDelMenu.addMouseListener(this);
        reservaForm.cerrarSesion.addMouseListener(this);

        //Elementos del menu principal
        reservaForm.btnBusCli.addMouseListener(this);
        reservaForm.panelBusCli.addMouseListener(this);

        reservaForm.btnReTra.addMouseListener(this);
        reservaForm.panelReTra.addMouseListener(this);

        reservaForm.btnReAero.addMouseListener(this);
        reservaForm.panelReAero.addMouseListener(this);

        reservaForm.btnRegVue.addMouseListener(this);
        reservaForm.panelRegVue.addMouseListener(this);

        reservaForm.btnRegAvion.addMouseListener(this);
        reservaForm.panelRegAvion.addMouseListener(this);

        reservaForm.btnEstadisticas.addMouseListener(this);
        reservaForm.panelEstadisticas.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == reservaForm.btnCambVuelo) {
            frmCompraBole frmComBole = new frmCompraBole();
            frmComBole.setVisible(true);
            reservaForm.setVisible(false);
        }

        if (e.getSource() == reservaForm.btnComprar) {
            comprar();
        }

        if (e.getSource() == reservaForm.btnImprimir) {

        }

        if (e.getSource() == reservaForm.cboDNIs) {
            actualizarTextRCBO();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == reservaForm.btnCerrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "EXIT", dialogButton);
            if (result == 0) {
                System.exit(0);
            }
        }

        if (e.getSource() == reservaForm.btnMinimizar) {
            reservaForm.setState(reservaForm.ICONIFIED);
        }

        if (e.getSource() == reservaForm.cerrarSesion) {
            cerrarSesion();
            frmLogin frmLogin = new frmLogin();
            frmLogin.setVisible(true);
            reservaForm.setVisible(false);
        }

        //elementos menu principal
        if (e.getSource() == reservaForm.btnReTra | e.getSource() == reservaForm.panelReTra) {
            frmRegTrab frmReTrab = new frmRegTrab();
            frmReTrab.setVisible(true);
            reservaForm.setVisible(false);
        }

        if (e.getSource() == reservaForm.btnBusCli | e.getSource() == reservaForm.panelBusCli) {
            frmBusCli frmBuCli = new frmBusCli();
            frmBuCli.setVisible(true);
            reservaForm.setVisible(false);
        }

        if (e.getSource() == reservaForm.btnReAero | e.getSource() == reservaForm.panelReAero) {
            frmRegAero frmRegAero = new frmRegAero();
            frmRegAero.setVisible(true);
            reservaForm.setVisible(false);
        }

        if (e.getSource() == reservaForm.btnRegVue | e.getSource() == reservaForm.panelRegVue) {
            frmRegVue frmRegVue = new frmRegVue();
            frmRegVue.setVisible(true);
            reservaForm.setVisible(false);
        }

        if (e.getSource() == reservaForm.btnRegAvion | e.getSource() == reservaForm.panelRegAvion) {
            frmRegAv frmRegAv = new frmRegAv();
            frmRegAv.setVisible(true);
            reservaForm.setVisible(false);
        }

        if (e.getSource() == reservaForm.btnEstadisticas | e.getSource() == reservaForm.btnEstadisticas) {
            frmEstadis frmEstadis = new frmEstadis();
            frmEstadis.setVisible(true);
            reservaForm.setVisible(false);
        }

        //Slider
        if (e.getSource() == reservaForm.SliderDelMenu) {
            reservaForm.SliderDelMenu.setEnabled(false);

            int initialSize = reservaForm.jPanel3.getWidth();
            int finalSize = (initialSize == 250) ? 0 : 250;
            int increment = (finalSize < initialSize) ? -5 : 5; // El tamaño cambia de -5 o 5 (puede cambiarse)
            int delay = 5; // Retardo (ms)

            Timer timer = new Timer(delay, new ActionListener() {
                int currentSize = initialSize; // 0 o 250

                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((increment < 0 && currentSize >= finalSize) || (increment > 0 && currentSize <= finalSize)) {
                        reservaForm.jPanel3.setSize(currentSize, 660); //0 o 250 dependiendo :v
                        reservaForm.panelDetras.setLocation(currentSize, reservaForm.panelDetras.getY()); // el panel se mueve mientras el otro aparece :v
                        reservaForm.panelDetras.setSize(250 - currentSize, 660); // Ajustar el tamaño //(desactivar para ver la magia)
                        currentSize += increment;
                        reservaForm.panelDetras.setVisible(true); //UNA HORA POR ESTA WEAAA
                    } else {
                        ((Timer) e.getSource()).stop();

                        if (finalSize == 0) {
                            reservaForm.panelDetras.setVisible(true);
                        } else {
                            reservaForm.panelDetras.setVisible(false);
                        }

                        // activa el botoncito
                        reservaForm.SliderDelMenu.setEnabled(true);
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
        if (e.getSource() == reservaForm.btnBusCli | e.getSource() == reservaForm.panelBusCli) {
            maus = true;
            cambiarColores(reservaForm.btnBusCli, reservaForm.panelBusCli);
        }

        if (e.getSource() == reservaForm.btnReTra | e.getSource() == reservaForm.panelReTra) {
            maus = true;
            cambiarColores(reservaForm.btnReTra, reservaForm.panelReTra);
        }

        if (e.getSource() == reservaForm.btnReAero | e.getSource() == reservaForm.panelReAero) {
            maus = true;
            cambiarColores(reservaForm.btnReAero, reservaForm.panelReAero);
        }

        if (e.getSource() == reservaForm.btnRegVue | e.getSource() == reservaForm.panelRegVue) {
            maus = true;
            cambiarColores(reservaForm.btnRegVue, reservaForm.panelRegVue);
        }

        if (e.getSource() == reservaForm.btnRegAvion | e.getSource() == reservaForm.panelRegAvion) {
            maus = true;
            cambiarColores(reservaForm.btnRegAvion, reservaForm.panelRegAvion);
        }

        if (e.getSource() == reservaForm.btnEstadisticas | e.getSource() == reservaForm.panelEstadisticas) {
            maus = true;
            cambiarColores(reservaForm.btnEstadisticas, reservaForm.panelEstadisticas);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == reservaForm.btnBusCli | e.getSource() == reservaForm.panelBusCli) {
            maus = false;
            cambiarColores(reservaForm.btnBusCli, reservaForm.panelBusCli);
        }

        if (e.getSource() == reservaForm.btnReTra | e.getSource() == reservaForm.panelReTra) {
            maus = false;
            cambiarColores(reservaForm.btnReTra, reservaForm.panelReTra);
        }

        if (e.getSource() == reservaForm.btnReTra | e.getSource() == reservaForm.panelReTra) {
            maus = false;
            cambiarColores(reservaForm.btnReTra, reservaForm.panelReTra);
        }

        if (e.getSource() == reservaForm.btnReAero | e.getSource() == reservaForm.panelReAero) {
            maus = false;
            cambiarColores(reservaForm.btnReAero, reservaForm.panelReAero);
        }

        if (e.getSource() == reservaForm.btnRegVue | e.getSource() == reservaForm.panelRegVue) {
            maus = false;
            cambiarColores(reservaForm.btnRegVue, reservaForm.panelRegVue);
        }

        if (e.getSource() == reservaForm.btnRegAvion | e.getSource() == reservaForm.panelRegAvion) {
            maus = false;
            cambiarColores(reservaForm.btnRegAvion, reservaForm.panelRegAvion);
        }

        if (e.getSource() == reservaForm.btnEstadisticas | e.getSource() == reservaForm.panelEstadisticas) {
            maus = false;
            cambiarColores(reservaForm.btnEstadisticas, reservaForm.panelEstadisticas);
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

            reservaForm.lblIDUsu.setText("" + trabajadorSesionado.getCodigoTra());
            reservaForm.lblUsuarioSes.setText(trabajadorSesionado.getUsuario());
            reservaForm.lblNombreSes.setText(trabajadorSesionado.getNombre());
            reservaForm.lblApeUsu.setText(trabajadorSesionado.getApellido());
            imagenUsuarioSes = trabajadorSesionado.getFoto();
            ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
            reservaForm.lblFotoSes.setIcon(IconoSelec);
            reservaForm.lblFotoSes2.setIcon(IconoSelec);
            reservaForm.lblUsuarioSes2.setText(trabajadorSesionado.getUsuario());

            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaDeInicio = horaActual.format(formatter);
            reservaForm.lblTiempSes.setText("" + horaDeInicio);
        } else {
            System.out.println("Se supone que esto no debe pasar XD");
        }
    }

    void cargarPasajeros(Vuelo vuelo) {
        reservaForm.lblIdVuelo.setText(String.valueOf(vuelo.getIdVuelo()));

        //setear datitos de vuelo
        int idVuelo = Integer.parseInt(vuelo.getIdVuelo());
        String name = vuelo.getOrigen();
        double a = vuelo.getPrecio();
        reservaForm.lblPrecio.setText(String.valueOf(a));
        reservaForm.lblOrigen.setText(name);
        reservaForm.lblDestino.setText(vuelo.getDestino());

        int capacidadAsientos = objRS.obtenerCapacidadAsientos(idVuelo);
        reservaForm.lblCapacidad.setText("" + capacidadAsientos);

        List<Pasajero> pasajeros = objRS.obtenerPasajerosPorVuelo(idVuelo);
        List<Reserva> reservas = objRS.obtenerReservasPorVuelo(idVuelo);
        DefaultTableModel dt = (DefaultTableModel) reservaForm.tablaReservas.getModel();
        dt.setRowCount(0);

        for (Pasajero pasajero : pasajeros) {
            int dniPasajero = pasajero.getDniPasajero();//
            Reserva reservaPasajero = null;

            for (Reserva reserva : reservas) {
                if (reserva.getDniPasajero() == dniPasajero) {//////
                    reservaPasajero = reserva;
                    break;
                }
            }

            if (reservaPasajero != null) {
                int idReserva = reservaPasajero.getIdReserva();
                Date fechaReserva = reservaPasajero.getFechaReserva();
                Object[] row = {idReserva, idVuelo, dniPasajero, fechaReserva, pasajero.getNombre(), pasajero.getApellido()};
                dt.addRow(row);
            } else {
                Object[] row = {null, idVuelo, dniPasajero, null, pasajero.getNombre(), pasajero.getApellido()};
                dt.addRow(row);
            }
        }
    }

    void comprar() {
        int dniPasajero = Integer.parseInt((String) reservaForm.cboDNIs.getSelectedItem());

        try {
            int IdVuelo = Integer.parseInt(reservaForm.lblIdVuelo.getText());
            Vuelo vuelito = objVD.buscarVuelo(IdVuelo);
            // Obtener la capacidad de asientos del vuelo
            int capacidadAsientos = objRS.obtenerCapacidadAsientos(IdVuelo);
            System.out.println("Asientos capaci" + capacidadAsientos);
            // Obtener la cantidad actual de reservas para el vuelo
            int reservasActuales = objRS.obtenerCantidadReservas(IdVuelo);
            System.out.println("reservas actu" + reservasActuales);

            // Verificar si el pasajero ya tiene una reserva en el mismo vuelo
            if (objRS.existeReserva(dniPasajero, IdVuelo)) {
                JOptionPane.showMessageDialog(null, "El pasajero ya tiene una reserva en este vuelo.");
            } else {

                if (reservasActuales >= capacidadAsientos) {

                    JOptionPane.showMessageDialog(null, "No hay más asientos disponibles en este vuelo.\nLa capacidad máxima es: " + capacidadAsientos);
                } else {
                    Date fechaReserva = Calendar.getInstance().getTime();
                    Reserva rs = new Reserva(0, dniPasajero, IdVuelo, fechaReserva, null);
                    objRS.crearReserva(rs);
                    cargarPasajeros(vuelito);
                    JOptionPane.showMessageDialog(null, "Pasajero agregado correctamente");
                }
            }
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos en las casillas correctamente");
        }
    }
    
    void actualizarTextRCBO(){
        String selectedItem = reservaForm.cboDNIs.getSelectedItem().toString();

            List<Pasajero> dnisPasajeros = objPS.Listado();

            for (Pasajero x : dnisPasajeros) {
                // Actualizar los JLabels según el elemento seleccionado
                if (selectedItem.equals(String.valueOf(x.getDniPasajero()))) {
                    reservaForm.lblNombre.setText(x.getNombre());
                    reservaForm.lblApellido.setText(x.getApellido());
                    reservaForm.lblNacionalidad.setText(x.getNacionalidad());

                }
            }
    }
}
