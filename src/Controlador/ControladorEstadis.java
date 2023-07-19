package Controlador;

import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Graficos;
import Modelo.Trabajador;
import static Vista.Controladores.objAD;
import static Vista.Controladores.objRS;
import static Vista.Controladores.objVD;
import Vista.frmBusCli;
import Vista.frmEstadis;
import Vista.frmLogin;
import Vista.frmRegAero;
import Vista.frmRegAv;
import Vista.frmRegTrab;
import Vista.frmRegVue;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.jfree.chart.ChartPanel;

public class ControladorEstadis implements ActionListener, MouseListener {

    private frmEstadis estadForm;

    private byte[] imagenUsuarioSes;

    public ControladorEstadis(frmEstadis form) {
        estadForm = form;

        obtenerUsuarioSesionado();

        //ActionListeners
        estadForm.btnCerrar.addMouseListener(this);
        estadForm.btnMinimizar.addMouseListener(this);

        estadForm.btnOrigenPop.addActionListener(this);
        estadForm.btnAerolineaPop.addActionListener(this);
        estadForm.btnDestinoPop.addActionListener(this);
        estadForm.btnGananPerdid.addActionListener(this);
        estadForm.btnGraficoCancelActiv.addActionListener(this);
        estadForm.btnReservCancel.addActionListener(this);

        //Para el panel Deslizante
        estadForm.SliderDelMenu.addMouseListener(this);
        estadForm.cerrarSesion.addMouseListener(this);

        //Elementos del menu principal
        estadForm.btnBusCli.addMouseListener(this);
        estadForm.panelBusCli.addMouseListener(this);

        estadForm.btnReTra.addMouseListener(this);
        estadForm.panelReTra.addMouseListener(this);

        estadForm.btnReAero.addMouseListener(this);
        estadForm.panelReAero.addMouseListener(this);

        estadForm.btnRegVue.addMouseListener(this);
        estadForm.panelRegVue.addMouseListener(this);

        estadForm.btnRegAvion.addMouseListener(this);
        estadForm.panelRegAvion.addMouseListener(this);

        estadForm.btnEstadisticas.addMouseListener(this);
        estadForm.panelEstadisticas.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == estadForm.btnDestinoPop) {

            estadForm.panelGrafic.removeAll();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaI = dateFormat.format(estadForm.desPopFechaInic.getDate());
            String fechaF = dateFormat.format(estadForm.desPopFechaFinal.getDate());

            ChartPanel chartPanel = Graficos.crearGrafico3(objRS.obtenerDatos3(fechaI, fechaF));
            chartPanel.setPreferredSize(new Dimension(788, 328));
            estadForm.panelGrafic.add(chartPanel);
            estadForm.jPanel1.revalidate();
        }

        if (e.getSource() == estadForm.btnOrigenPop) {

            estadForm.panelGrafic.removeAll();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaI = dateFormat.format(estadForm.desPopFechaInic.getDate());
            String fechaF = dateFormat.format(estadForm.desPopFechaFinal.getDate());

            ChartPanel chartPanel = Graficos.crearGrafico2(objVD.obtenerDatos2(fechaI, fechaF));
            chartPanel.setPreferredSize(new Dimension(788, 328));
            estadForm.panelGrafic.add(chartPanel);
            estadForm.jPanel1.revalidate();
        }

        if (e.getSource() == estadForm.btnAerolineaPop) {

            estadForm.panelGrafic.removeAll();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaI = dateFormat.format(estadForm.desPopFechaInic.getDate());
            String fechaF = dateFormat.format(estadForm.desPopFechaFinal.getDate());

            ChartPanel chartPanel = Graficos.crearGrafico1(objAD.obtenerDatosAerolineaPreferida(fechaI, fechaF));
            chartPanel.setPreferredSize(new Dimension(788, 328));
            estadForm.panelGrafic.add(chartPanel);
            estadForm.jPanel1.revalidate();
        }

        if (e.getSource() == estadForm.btnReservCancel) {

            estadForm.panelGrafic.removeAll();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaI = dateFormat.format(estadForm.desPopFechaInic.getDate());
            String fechaF = dateFormat.format(estadForm.desPopFechaFinal.getDate());

            ChartPanel chartPanel = Graficos.crearGraficoReservasCanceladas(objRS.obtenerDatosReservasCanceladas(fechaI, fechaF));
            chartPanel.setPreferredSize(new Dimension(788, 328));
            estadForm.panelGrafic.add(chartPanel);
            estadForm.jPanel1.revalidate();
        }

        if (e.getSource() == estadForm.btnGananPerdid) {

            estadForm.panelGrafic.removeAll();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaI = dateFormat.format(estadForm.desPopFechaInic.getDate());
            String fechaF = dateFormat.format(estadForm.desPopFechaFinal.getDate());

            ChartPanel chartPanel = Graficos.crearGraficoGananciasPerdidas(objRS.obtenerDatosGananciasPerdidas(fechaI, fechaF));
            chartPanel.setPreferredSize(new Dimension(788, 328));
            estadForm.panelGrafic.add(chartPanel);
            estadForm.jPanel1.revalidate();
        }

        if (e.getSource() == estadForm.btnGraficoCancelActiv) {
            estadForm.panelGrafic.removeAll();

            ChartPanel chartPanel = Graficos.crearGraficoVuelosCanceladosActivos(objVD.obtenerDatosVuelosCanceladosActivos());
            chartPanel.setPreferredSize(new Dimension(788, 328));
            estadForm.panelGrafic.add(chartPanel);
            estadForm.jPanel1.revalidate();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == estadForm.btnCerrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "EXIT", dialogButton);
            if (result == 0) {
                System.exit(0);
            }
        }

        if (e.getSource() == estadForm.btnMinimizar) {
            estadForm.setState(estadForm.ICONIFIED);
        }

        if (e.getSource() == estadForm.cerrarSesion) {
            cerrarSesion();
            frmLogin frmLogin = new frmLogin();
            frmLogin.setVisible(true);
            estadForm.setVisible(false);
        }
        //elementos menu principal
        if (e.getSource() == estadForm.btnReTra | e.getSource() == estadForm.panelReTra) {
            frmRegTrab frmReTrab = new frmRegTrab();
            frmReTrab.setVisible(true);
            estadForm.setVisible(false);
        }

        if (e.getSource() == estadForm.btnBusCli | e.getSource() == estadForm.panelBusCli) {
            frmBusCli frmBuCli = new frmBusCli();
            frmBuCli.setVisible(true);
            estadForm.setVisible(false);
        }

        if (e.getSource() == estadForm.btnReAero | e.getSource() == estadForm.panelReAero) {
            frmRegAero frmRegAero = new frmRegAero();
            frmRegAero.setVisible(true);
            estadForm.setVisible(false);
        }

        if (e.getSource() == estadForm.btnRegVue | e.getSource() == estadForm.panelRegVue) {
            frmRegVue frmRegVue = new frmRegVue();
            frmRegVue.setVisible(true);
            estadForm.setVisible(false);
        }

        if (e.getSource() == estadForm.btnRegAvion | e.getSource() == estadForm.panelRegAvion) {
            frmRegAv frmRegAv = new frmRegAv();
            frmRegAv.setVisible(true);
            estadForm.setVisible(false);
        }

        if (e.getSource() == estadForm.btnEstadisticas | e.getSource() == estadForm.btnEstadisticas) {
            frmEstadis frmEstadis = new frmEstadis();
            frmEstadis.setVisible(true);
            estadForm.setVisible(false);
        }

        //Slider
        if (e.getSource() == estadForm.SliderDelMenu) {
            estadForm.SliderDelMenu.setEnabled(false);

            int initialSize = estadForm.jPanel3.getWidth();
            int finalSize = (initialSize == 250) ? 0 : 250;
            int increment = (finalSize < initialSize) ? -5 : 5; // El tamaño cambia de -5 o 5 (puede cambiarse)
            int delay = 5; // Retardo (ms)

            Timer timer = new Timer(delay, new ActionListener() {
                int currentSize = initialSize; // 0 o 250

                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((increment < 0 && currentSize >= finalSize) || (increment > 0 && currentSize <= finalSize)) {
                        estadForm.jPanel3.setSize(currentSize, 660); //0 o 250 dependiendo :v
                        estadForm.panelDetras.setLocation(currentSize, estadForm.panelDetras.getY()); // el panel se mueve mientras el otro aparece :v
                        estadForm.panelDetras.setSize(250 - currentSize, 660); // Ajustar el tamaño //(desactivar para ver la magia)
                        currentSize += increment;
                        estadForm.panelDetras.setVisible(true); //UNA HORA POR ESTA WEAAA
                    } else {
                        ((Timer) e.getSource()).stop();

                        if (finalSize == 0) {
                            estadForm.panelDetras.setVisible(true);
                        } else {
                            estadForm.panelDetras.setVisible(false);
                        }

                        // activa el botoncito
                        estadForm.SliderDelMenu.setEnabled(true);
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
        if (e.getSource() == estadForm.btnBusCli | e.getSource() == estadForm.panelBusCli) {
            maus = true;
            cambiarColores(estadForm.btnBusCli, estadForm.panelBusCli);
        }

        if (e.getSource() == estadForm.btnReTra | e.getSource() == estadForm.panelReTra) {
            maus = true;
            cambiarColores(estadForm.btnReTra, estadForm.panelReTra);
        }

        if (e.getSource() == estadForm.btnReAero | e.getSource() == estadForm.panelReAero) {
            maus = true;
            cambiarColores(estadForm.btnReAero, estadForm.panelReAero);
        }

        if (e.getSource() == estadForm.btnRegVue | e.getSource() == estadForm.panelRegVue) {
            maus = true;
            cambiarColores(estadForm.btnRegVue, estadForm.panelRegVue);
        }

        if (e.getSource() == estadForm.btnRegAvion | e.getSource() == estadForm.panelRegAvion) {
            maus = true;
            cambiarColores(estadForm.btnRegAvion, estadForm.panelRegAvion);
        }

        if (e.getSource() == estadForm.btnEstadisticas | e.getSource() == estadForm.panelEstadisticas) {
            maus = true;
            cambiarColores(estadForm.btnEstadisticas, estadForm.panelEstadisticas);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == estadForm.btnBusCli | e.getSource() == estadForm.panelBusCli) {
            maus = false;
            cambiarColores(estadForm.btnBusCli, estadForm.panelBusCli);
        }

        if (e.getSource() == estadForm.btnReTra | e.getSource() == estadForm.panelReTra) {
            maus = false;
            cambiarColores(estadForm.btnReTra, estadForm.panelReTra);
        }

        if (e.getSource() == estadForm.btnReTra | e.getSource() == estadForm.panelReTra) {
            maus = false;
            cambiarColores(estadForm.btnReTra, estadForm.panelReTra);
        }

        if (e.getSource() == estadForm.btnReAero | e.getSource() == estadForm.panelReAero) {
            maus = false;
            cambiarColores(estadForm.btnReAero, estadForm.panelReAero);
        }

        if (e.getSource() == estadForm.btnRegVue | e.getSource() == estadForm.panelRegVue) {
            maus = false;
            cambiarColores(estadForm.btnRegVue, estadForm.panelRegVue);
        }

        if (e.getSource() == estadForm.btnRegAvion | e.getSource() == estadForm.panelRegAvion) {
            maus = false;
            cambiarColores(estadForm.btnRegAvion, estadForm.panelRegAvion);
        }

        if (e.getSource() == estadForm.btnEstadisticas | e.getSource() == estadForm.panelEstadisticas) {
            maus = false;
            cambiarColores(estadForm.btnEstadisticas, estadForm.panelEstadisticas);
        }

    }

    //metodos
    public void obtenerUsuarioSesionado() {
        Trabajador trabajadorSesionado = LoginControlador.getTrabajadorSesionado();
        if (trabajadorSesionado != null) {

            estadForm.lblIDUsu.setText("" + trabajadorSesionado.getCodigoTra());
            estadForm.lblUsuarioSes.setText(trabajadorSesionado.getUsuario());
            estadForm.lblNombreSes.setText(trabajadorSesionado.getNombre());
            estadForm.lblApeUsu.setText(trabajadorSesionado.getApellido());
            imagenUsuarioSes = trabajadorSesionado.getFoto();
            ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
            estadForm.lblFotoSes.setIcon(IconoSelec);
            estadForm.lblFotoSes2.setIcon(IconoSelec);
            estadForm.lblUsuarioSes2.setText(trabajadorSesionado.getUsuario());

            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaDeInicio = horaActual.format(formatter);
            estadForm.lblTiempSes.setText("" + horaDeInicio);
        } else {
            System.out.println("Se supone que esto no debe pasar XD");
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
