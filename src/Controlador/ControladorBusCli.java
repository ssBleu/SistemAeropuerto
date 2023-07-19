package Controlador;

import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Trabajador;
import static Vista.Controladores.objPS;
import static Vista.Controladores.objRS;
import Vista.frmBusCli;
import Vista.frmCompraBole;
import Vista.frmEstadis;
import Vista.frmLogin;
import Vista.frmRegAero;
import Vista.frmRegAv;
import Vista.frmRegCli;
import Vista.frmRegTrab;
import Vista.frmRegVue;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class ControladorBusCli implements ActionListener, MouseListener {

    private frmBusCli busCliForm;

    private byte[] imagenUsuarioSes;

    public ControladorBusCli(frmBusCli form) {
        busCliForm = form;

        listado();
        datitos();
        obtenerUsuarioSesionado();
        //objRS.actualizarReservasEstadoRealizado();
        //ActionListeners
        busCliForm.btnLimpiar.addActionListener(this);
        busCliForm.btnBuscarCli.addActionListener(this);
        busCliForm.btnCompraBoleta.addActionListener(this);
        busCliForm.btnCancelarRes.addActionListener(this);
        busCliForm.btnEliminarReserva.addActionListener(this);
        busCliForm.btnRegistrarCli.addActionListener(this);
        //MouseListeners
        busCliForm.btnCerrar.addMouseListener(this);
        busCliForm.btnMinimizar.addMouseListener(this);
        busCliForm.TablaBuscCliente.addMouseListener(this);

        //Para el panel Deslizante
        busCliForm.SliderDelMenu.addMouseListener(this);
        busCliForm.cerrarSesion.addMouseListener(this);

        //Elementos del menu principal
        busCliForm.btnBusCli.addMouseListener(this);
        busCliForm.panelBusCli.addMouseListener(this);

        busCliForm.btnReTra.addMouseListener(this);
        busCliForm.panelReTra.addMouseListener(this);

        busCliForm.btnReAero.addMouseListener(this);
        busCliForm.panelReAero.addMouseListener(this);

        busCliForm.btnRegVue.addMouseListener(this);
        busCliForm.panelRegVue.addMouseListener(this);

        busCliForm.btnRegAvion.addMouseListener(this);
        busCliForm.panelRegAvion.addMouseListener(this);

        busCliForm.btnEstadisticas.addMouseListener(this);
        busCliForm.panelEstadisticas.addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == busCliForm.btnLimpiar) {
            limpiarCampos();
        }

        if (e.getSource() == busCliForm.btnBuscarCli) {
            filtrarTabla();
        }

        if (e.getSource() == busCliForm.btnCompraBoleta) {
            frmCompraBole frmComBole = new frmCompraBole();
            frmComBole.setVisible(true);
            busCliForm.setVisible(false);
        }

        if (e.getSource() == busCliForm.btnCancelarRes) {
            cancelarReserva();
        }

        if (e.getSource() == busCliForm.btnEliminarReserva) {
            eliminarReserva();
        }

        if (e.getSource() == busCliForm.btnRegistrarCli) {
            frmRegCli frmRegCli = new frmRegCli();
            frmRegCli.setVisible(true);
            busCliForm.setVisible(false);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == busCliForm.btnCerrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "EXIT", dialogButton);
            if (result == 0) {
                System.exit(0);
            }
        }

        if (e.getSource() == busCliForm.btnMinimizar) {
            busCliForm.setState(busCliForm.ICONIFIED);
        }

        if (e.getSource() == busCliForm.TablaBuscCliente) {
            int fila = busCliForm.TablaBuscCliente.getSelectedRow();
            filaSeleccionada = fila;
        }

        if (e.getSource() == busCliForm.cerrarSesion) {
            cerrarSesion();
            frmLogin frmLogin = new frmLogin();
            frmLogin.setVisible(true);
            busCliForm.setVisible(false);
        }

        //elementos menu principal
        if (e.getSource() == busCliForm.btnReTra | e.getSource() == busCliForm.panelReTra) {
            frmRegTrab frmReTrab = new frmRegTrab();
            frmReTrab.setVisible(true);
            busCliForm.setVisible(false);
        }

        if (e.getSource() == busCliForm.btnBusCli | e.getSource() == busCliForm.panelBusCli) {
            frmBusCli frmBuCli = new frmBusCli();
            frmBuCli.setVisible(true);
            busCliForm.setVisible(false);
        }

        if (e.getSource() == busCliForm.btnReAero | e.getSource() == busCliForm.panelReAero) {
            frmRegAero frmRegAero = new frmRegAero();
            frmRegAero.setVisible(true);
            busCliForm.setVisible(false);
        }

        if (e.getSource() == busCliForm.btnRegVue | e.getSource() == busCliForm.panelRegVue) {
            frmRegVue frmRegVue = new frmRegVue();
            frmRegVue.setVisible(true);
            busCliForm.setVisible(false);
        }

        if (e.getSource() == busCliForm.btnRegAvion | e.getSource() == busCliForm.panelRegAvion) {
            frmRegAv frmRegAv = new frmRegAv();
            frmRegAv.setVisible(true);
            busCliForm.setVisible(false);
        }

        if (e.getSource() == busCliForm.btnEstadisticas | e.getSource() == busCliForm.btnEstadisticas) {
            frmEstadis frmEstadis = new frmEstadis();
            frmEstadis.setVisible(true);
            busCliForm.setVisible(false);
        }

        //Slider
        if (e.getSource() == busCliForm.SliderDelMenu) {
            busCliForm.SliderDelMenu.setEnabled(false);

            int initialSize = busCliForm.jPanel3.getWidth();
            int finalSize = (initialSize == 250) ? 0 : 250;
            int increment = (finalSize < initialSize) ? -5 : 5; // El tamaño cambia de -5 o 5 (puede cambiarse)
            int delay = 5; // Retardo (ms)

            Timer timer = new Timer(delay, new ActionListener() {
                int currentSize = initialSize; // 0 o 250

                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((increment < 0 && currentSize >= finalSize) || (increment > 0 && currentSize <= finalSize)) {
                        busCliForm.jPanel3.setSize(currentSize, 660); //0 o 250 dependiendo :v
                        busCliForm.panelDetras.setLocation(currentSize, busCliForm.panelDetras.getY()); // el panel se mueve mientras el otro aparece :v
                        busCliForm.panelDetras.setSize(250 - currentSize, 660); // Ajustar el tamaño //(desactivar para ver la magia)
                        currentSize += increment;
                        busCliForm.panelDetras.setVisible(true); //UNA HORA POR ESTA WEAAA
                    } else {
                        ((Timer) e.getSource()).stop();

                        if (finalSize == 0) {
                            busCliForm.panelDetras.setVisible(true);
                        } else {
                            busCliForm.panelDetras.setVisible(false);
                        }

                        // activa el botoncito
                        busCliForm.SliderDelMenu.setEnabled(true);
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
        if (e.getSource() == busCliForm.btnBusCli | e.getSource() == busCliForm.panelBusCli) {
            maus = true;
            cambiarColores(busCliForm.btnBusCli, busCliForm.panelBusCli);
        }

        if (e.getSource() == busCliForm.btnReTra | e.getSource() == busCliForm.panelReTra) {
            maus = true;
            cambiarColores(busCliForm.btnReTra, busCliForm.panelReTra);
        }

        if (e.getSource() == busCliForm.btnReAero | e.getSource() == busCliForm.panelReAero) {
            maus = true;
            cambiarColores(busCliForm.btnReAero, busCliForm.panelReAero);
        }

        if (e.getSource() == busCliForm.btnRegVue | e.getSource() == busCliForm.panelRegVue) {
            maus = true;
            cambiarColores(busCliForm.btnRegVue, busCliForm.panelRegVue);
        }

        if (e.getSource() == busCliForm.btnRegAvion | e.getSource() == busCliForm.panelRegAvion) {
            maus = true;
            cambiarColores(busCliForm.btnRegAvion, busCliForm.panelRegAvion);
        }

        if (e.getSource() == busCliForm.btnEstadisticas | e.getSource() == busCliForm.panelEstadisticas) {
            maus = true;
            cambiarColores(busCliForm.btnEstadisticas, busCliForm.panelEstadisticas);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == busCliForm.btnBusCli | e.getSource() == busCliForm.panelBusCli) {
            maus = false;
            cambiarColores(busCliForm.btnBusCli, busCliForm.panelBusCli);
        }

        if (e.getSource() == busCliForm.btnReTra | e.getSource() == busCliForm.panelReTra) {
            maus = false;
            cambiarColores(busCliForm.btnReTra, busCliForm.panelReTra);
        }

        if (e.getSource() == busCliForm.btnReTra | e.getSource() == busCliForm.panelReTra) {
            maus = false;
            cambiarColores(busCliForm.btnReTra, busCliForm.panelReTra);
        }

        if (e.getSource() == busCliForm.btnReAero | e.getSource() == busCliForm.panelReAero) {
            maus = false;
            cambiarColores(busCliForm.btnReAero, busCliForm.panelReAero);
        }

        if (e.getSource() == busCliForm.btnRegVue | e.getSource() == busCliForm.panelRegVue) {
            maus = false;
            cambiarColores(busCliForm.btnRegVue, busCliForm.panelRegVue);
        }

        if (e.getSource() == busCliForm.btnRegAvion | e.getSource() == busCliForm.panelRegAvion) {
            maus = false;
            cambiarColores(busCliForm.btnRegAvion, busCliForm.panelRegAvion);
        }

        if (e.getSource() == busCliForm.btnEstadisticas | e.getSource() == busCliForm.panelEstadisticas) {
            maus = false;
            cambiarColores(busCliForm.btnEstadisticas, busCliForm.panelEstadisticas);
        }

    }

    private boolean maus = false;
    private int filaSeleccionada = -1;

    //colores panel/jlabel"botones" xd
    private java.awt.Color ColorEnteredBoton = new java.awt.Color(55, 231, 173);
    private java.awt.Color ColorOriginalPanel = new java.awt.Color(67, 90, 132);
    private java.awt.Color ColorEnteredPanel = new java.awt.Color(110, 153, 139);

    //metodos
    void limpiarCampos() {
        busCliForm.txtDNIbusc.setText("");
        busCliForm.txtNombreBusc.setText("");
        busCliForm.txtApeBusc.setText("");
        busCliForm.txtOrigenBusc.setText("");
        busCliForm.txtDestinoBusc.setText("");
        busCliForm.dateInicial.setDate(null);
        busCliForm.dateFinal.setDate(null);
    }

    void listado() {
        DefaultTableModel dt = (DefaultTableModel) busCliForm.TablaBuscCliente.getModel();

        dt.setRowCount(0);

        for (Object[] ClientesCReserva : objPS.listarPasajerosVuelo()) {
            dt.addRow(ClientesCReserva);
        }
    }

    private void filtrarTabla() {
        DefaultTableModel dt = (DefaultTableModel) busCliForm.TablaBuscCliente.getModel();
        String dni = busCliForm.txtDNIbusc.getText();
        String nom = busCliForm.txtNombreBusc.getText();
        String ape = busCliForm.txtApeBusc.getText();
        String ori = busCliForm.txtOrigenBusc.getText();
        String des = busCliForm.txtDestinoBusc.getText();

        JDateChooser dateChooser1 = busCliForm.dateInicial;
        JDateChooser dateChooser2 = busCliForm.dateFinal;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String fecIni = dateChooser1.getDate() != null ? dateFormat.format(dateChooser1.getDate()) : null;
        String fecFin = dateChooser2.getDate() != null ? dateFormat.format(dateChooser2.getDate()) : null;

        dt.setRowCount(0);
        List<Object[]> pasajerosReserFiltro;
        pasajerosReserFiltro = objPS.obtenerPasajerosReservadosFiltrados(dni, nom, ape, ori, des, fecIni, fecFin);

        if (pasajerosReserFiltro.isEmpty()) {
            listado();
            JOptionPane.showMessageDialog(null, "No se encontraron pasajeros que cumplan con los criterios de búsqueda.");
        } else {
            for (Object[] fila : pasajerosReserFiltro) {
                dt.addRow(fila);
            }
        }
    }

    void datitos() {

        int totalClienteCReserva = objPS.contarPasajerosConReservas();
        busCliForm.lblClientesReserva.setText("" + totalClienteCReserva);

        int totalClientes = objPS.contarPasajeros();
        busCliForm.lblTotalClientes.setText("" + totalClientes);

    }

    void eliminarReserva() {
        if (filaSeleccionada != -1) {
            String dniPasajero = busCliForm.TablaBuscCliente.getValueAt(filaSeleccionada, 0).toString(); // Obtiene el DNI de la columna 0
            String fechaReserva = busCliForm.TablaBuscCliente.getValueAt(filaSeleccionada, 6).toString(); // Obtiene la fecha de reserva de la columna 6

            // Mostrar un cuadro de diálogo de confirmación
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar la reserva?", "Confirmación", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                objPS.eliminarReservaPorDniYFechaReserva(dniPasajero, fechaReserva);

                // Eliminar la fila seleccionada de la tabla
                DefaultTableModel model = (DefaultTableModel) busCliForm.TablaBuscCliente.getModel();
                model.removeRow(filaSeleccionada);

                // Reiniciar la variable filaSeleccionada
                filaSeleccionada = -1;
            }
        } else {
            JOptionPane.showMessageDialog(busCliForm, "No se ha seleccionado una reserva", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    void cancelarReserva() {
        int filaSeleccionada = busCliForm.TablaBuscCliente.getSelectedRow();

        if (filaSeleccionada != -1) {
            String idReserva = busCliForm.TablaBuscCliente.getValueAt(filaSeleccionada, 7).toString();
            String estadoReserva = busCliForm.TablaBuscCliente.getValueAt(filaSeleccionada, 8).toString();

            int confirmacion;
            String mensaje;

            if (estadoReserva.equalsIgnoreCase("CANCELADO")) {
                confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de descancelar la reserva?", "Confirmar descancelación", JOptionPane.YES_NO_OPTION);
                mensaje = "Vuelo descancelado exitosamente";
            } else if (estadoReserva.equalsIgnoreCase("REALIZADO")) {
                JOptionPane.showMessageDialog(null, "No se puede cancelar un vuelo realizado");
                return; // Finaliza el método sin realizar ninguna acción
            } else {
                confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de cancelar la reserva?", "Confirmar cancelación", JOptionPane.YES_NO_OPTION);
                mensaje = "Vuelo cancelado exitosamente";
            }

            if (confirmacion == JOptionPane.YES_OPTION) {
                objRS.cambiarEstadoReserva(idReserva, estadoReserva);
                JOptionPane.showMessageDialog(null, mensaje);
            }
            listado();

        } else {
            JOptionPane.showMessageDialog(null, "Selecciona un vuelo de la tabla");
        }
    }

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

            busCliForm.lblIDUsu.setText("" + trabajadorSesionado.getCodigoTra());
            busCliForm.lblUsuarioSes.setText(trabajadorSesionado.getUsuario());
            busCliForm.lblNombreSes.setText(trabajadorSesionado.getNombre());
            busCliForm.lblApeUsu.setText(trabajadorSesionado.getApellido());
            imagenUsuarioSes = trabajadorSesionado.getFoto();
            ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
            busCliForm.lblFotoSes.setIcon(IconoSelec);
            busCliForm.lblFotoSes2.setIcon(IconoSelec);
            busCliForm.lblUsuarioSes2.setText(trabajadorSesionado.getUsuario());

            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaDeInicio = horaActual.format(formatter);
            busCliForm.lblTiempSes.setText("" + horaDeInicio);
        } else {
            System.out.println("Se supone que esto no debe pasar XD");
        }
    }
}
