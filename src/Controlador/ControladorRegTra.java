package Controlador;

import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Trabajador;
import static Vista.Controladores.objTR;
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
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import util.ImageRenderer;

public class ControladorRegTra implements ActionListener, MouseListener {

    private frmRegTrab regTraForm;
    private byte[] imagenSeleccionadaBytes;
    private byte[] imagenUsuarioSes;

    public ControladorRegTra(frmRegTrab form) {
        regTraForm = form;

        listado();
        obtenerUsuarioSesionado();
        //Actions
        regTraForm.btnGuardar.addActionListener(this);
        regTraForm.btnActualizar.addActionListener(this);
        regTraForm.btnEliminar.addActionListener(this);
        regTraForm.subirFoto.addActionListener(this);
        //MouseListeners
        regTraForm.btnCerrar.addMouseListener(this);
        regTraForm.btnMinimizar.addMouseListener(this);
        regTraForm.TablaTra.addMouseListener(this);

        //Para el panel Deslizante
        regTraForm.SliderDelMenu.addMouseListener(this);
        regTraForm.cerrarSesion.addMouseListener(this);

        //Elementos del menu principal
        regTraForm.btnBusCli.addMouseListener(this);
        regTraForm.panelBusCli.addMouseListener(this);

        regTraForm.btnReTra.addMouseListener(this);
        regTraForm.panelReTra.addMouseListener(this);

        regTraForm.btnReAero.addMouseListener(this);
        regTraForm.panelReAero.addMouseListener(this);

        regTraForm.btnRegVue.addMouseListener(this);
        regTraForm.panelRegVue.addMouseListener(this);

        regTraForm.btnRegAvion.addMouseListener(this);
        regTraForm.panelRegAvion.addMouseListener(this);

        regTraForm.btnEstadisticas.addMouseListener(this);
        regTraForm.panelEstadisticas.addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == regTraForm.subirFoto) {
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                imagenSeleccionadaBytes = convertirArchivoABytes(file);

                ImageIcon imagenIcono = new ImageIcon(imagenSeleccionadaBytes);
                regTraForm.lblImagenSeleccionada.setIcon(imagenIcono);
            }
        }

        if (e.getSource() == regTraForm.btnGuardar) {
            guardar();
        }

        if (e.getSource() == regTraForm.btnActualizar) {
            actualizar();
        }

        if (e.getSource() == regTraForm.btnEliminar) {
            eliminar();
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == regTraForm.btnCerrar) {
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "EXIT", dialogButton);
            if (result == 0) {
                System.exit(0);
            }
        }

        if (e.getSource() == regTraForm.btnMinimizar) {
            regTraForm.setState(regTraForm.ICONIFIED);
        }

        if (e.getSource() == regTraForm.TablaTra) {
            int idt = regTraForm.TablaTra.getSelectedRow();
            int DNI = Integer.parseInt(regTraForm.TablaTra.getValueAt(idt, 0).toString());

            Trabajador x = objTR.buscarTrabajador(DNI);
            regTraForm.txtIDT.setText("" + x.getCodigoTra());
            regTraForm.txtNombre.setText(x.getNombre());
            regTraForm.txtApellido.setText(x.getApellido());
            regTraForm.DCNacimiento.setDate(x.getFechaNacimiento());
            regTraForm.txtUsuario.setText(x.getUsuario());
            regTraForm.txtContraseña.setText(x.getContrasena());
            regTraForm.txtSalario.setText("" + x.getSalario());
            regTraForm.DCContrato.setDate(x.getFechaContratacion());
            imagenSeleccionadaBytes = x.getFoto();

            ImageIcon IconoSelec = new ImageIcon(imagenSeleccionadaBytes);
            regTraForm.lblImagenSeleccionada.setIcon(IconoSelec);
        }

        if (e.getSource() == regTraForm.cerrarSesion) {
            cerrarSesion();
            frmLogin frmLogin = new frmLogin();
            frmLogin.setVisible(true);
            regTraForm.setVisible(false);
        }

        //elementos menu principal
        if (e.getSource() == regTraForm.btnReTra | e.getSource() == regTraForm.panelReTra) {
            frmRegTrab frmReTrab = new frmRegTrab();
            frmReTrab.setVisible(true);
            regTraForm.setVisible(false);
        }

        if (e.getSource() == regTraForm.btnBusCli | e.getSource() == regTraForm.panelBusCli) {
            frmBusCli frmBuCli = new frmBusCli();
            frmBuCli.setVisible(true);
            regTraForm.setVisible(false);
        }

        if (e.getSource() == regTraForm.btnReAero | e.getSource() == regTraForm.panelReAero) {
            frmRegAero frmRegAero = new frmRegAero();
            frmRegAero.setVisible(true);
            regTraForm.setVisible(false);
        }

        if (e.getSource() == regTraForm.btnRegVue | e.getSource() == regTraForm.panelRegVue) {
            frmRegVue frmRegVue = new frmRegVue();
            frmRegVue.setVisible(true);
            regTraForm.setVisible(false);
        }

        if (e.getSource() == regTraForm.btnRegAvion | e.getSource() == regTraForm.panelRegAvion) {
            frmRegAv frmRegAv = new frmRegAv();
            frmRegAv.setVisible(true);
            regTraForm.setVisible(false);
        }

        if (e.getSource() == regTraForm.btnEstadisticas | e.getSource() == regTraForm.btnEstadisticas) {
            frmEstadis frmEstadis = new frmEstadis();
            frmEstadis.setVisible(true);
            regTraForm.setVisible(false);
        }

        //Slider
        if (e.getSource() == regTraForm.SliderDelMenu) {
            regTraForm.SliderDelMenu.setEnabled(false);

            int initialSize = regTraForm.jPanel3.getWidth();
            int finalSize = (initialSize == 250) ? 0 : 250;
            int increment = (finalSize < initialSize) ? -5 : 5; // El tamaño cambia de -5 o 5 (puede cambiarse)
            int delay = 5; // Retardo (ms)

            Timer timer = new Timer(delay, new ActionListener() {
                int currentSize = initialSize; // 0 o 250

                @Override
                public void actionPerformed(ActionEvent e) {
                    if ((increment < 0 && currentSize >= finalSize) || (increment > 0 && currentSize <= finalSize)) {
                        regTraForm.jPanel3.setSize(currentSize, 660); //0 o 250 dependiendo :v
                        regTraForm.panelDetras.setLocation(currentSize, regTraForm.panelDetras.getY()); // el panel se mueve mientras el otro aparece :v
                        regTraForm.panelDetras.setSize(250 - currentSize, 660); // Ajustar el tamaño //(desactivar para ver la magia)
                        currentSize += increment;
                        regTraForm.panelDetras.setVisible(true); //UNA HORA POR ESTA WEAAA
                    } else {
                        ((Timer) e.getSource()).stop();

                        if (finalSize == 0) {
                            regTraForm.panelDetras.setVisible(true);
                        } else {
                            regTraForm.panelDetras.setVisible(false);
                        }

                        // activa el botoncito
                        regTraForm.SliderDelMenu.setEnabled(true);
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
        if (e.getSource() == regTraForm.btnBusCli | e.getSource() == regTraForm.panelBusCli) {
            maus = true;
            cambiarColores(regTraForm.btnBusCli, regTraForm.panelBusCli);
        }

        if (e.getSource() == regTraForm.btnReTra | e.getSource() == regTraForm.panelReTra) {
            maus = true;
            cambiarColores(regTraForm.btnReTra, regTraForm.panelReTra);
        }

        if (e.getSource() == regTraForm.btnReAero | e.getSource() == regTraForm.panelReAero) {
            maus = true;
            cambiarColores(regTraForm.btnReAero, regTraForm.panelReAero);
        }

        if (e.getSource() == regTraForm.btnRegVue | e.getSource() == regTraForm.panelRegVue) {
            maus = true;
            cambiarColores(regTraForm.btnRegVue, regTraForm.panelRegVue);
        }

        if (e.getSource() == regTraForm.btnRegAvion | e.getSource() == regTraForm.panelRegAvion) {
            maus = true;
            cambiarColores(regTraForm.btnRegAvion, regTraForm.panelRegAvion);
        }

        if (e.getSource() == regTraForm.btnEstadisticas | e.getSource() == regTraForm.panelEstadisticas) {
            maus = true;
            cambiarColores(regTraForm.btnEstadisticas, regTraForm.panelEstadisticas);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == regTraForm.btnBusCli | e.getSource() == regTraForm.panelBusCli) {
            maus = false;
            cambiarColores(regTraForm.btnBusCli, regTraForm.panelBusCli);
        }

        if (e.getSource() == regTraForm.btnReTra | e.getSource() == regTraForm.panelReTra) {
            maus = false;
            cambiarColores(regTraForm.btnReTra, regTraForm.panelReTra);
        }

        if (e.getSource() == regTraForm.btnReTra | e.getSource() == regTraForm.panelReTra) {
            maus = false;
            cambiarColores(regTraForm.btnReTra, regTraForm.panelReTra);
        }

        if (e.getSource() == regTraForm.btnReAero | e.getSource() == regTraForm.panelReAero) {
            maus = false;
            cambiarColores(regTraForm.btnReAero, regTraForm.panelReAero);
        }

        if (e.getSource() == regTraForm.btnRegVue | e.getSource() == regTraForm.panelRegVue) {
            maus = false;
            cambiarColores(regTraForm.btnRegVue, regTraForm.panelRegVue);
        }

        if (e.getSource() == regTraForm.btnRegAvion | e.getSource() == regTraForm.panelRegAvion) {
            maus = false;
            cambiarColores(regTraForm.btnRegAvion, regTraForm.panelRegAvion);
        }

        if (e.getSource() == regTraForm.btnEstadisticas | e.getSource() == regTraForm.panelEstadisticas) {
            maus = false;
            cambiarColores(regTraForm.btnEstadisticas, regTraForm.panelEstadisticas);
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

            regTraForm.lblIDUsu.setText("" + trabajadorSesionado.getCodigoTra());
            regTraForm.lblUsuarioSes.setText(trabajadorSesionado.getUsuario());
            regTraForm.lblNombreSes.setText(trabajadorSesionado.getNombre());
            regTraForm.lblApeUsu.setText(trabajadorSesionado.getApellido());
            imagenUsuarioSes = trabajadorSesionado.getFoto();
            ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
            regTraForm.lblFotoSes.setIcon(IconoSelec);
            regTraForm.lblFotoSes2.setIcon(IconoSelec);
            regTraForm.lblUsuarioSes2.setText(trabajadorSesionado.getUsuario());

            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaDeInicio = horaActual.format(formatter);
            regTraForm.lblTiempSes.setText("" + horaDeInicio);
        } else {
            System.out.println("Se supone que esto no debe pasar XD");
        }
    }

    //metodos
    private boolean validarCampos(String nombre, int idTrabajador) {
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre válido", "Campo Vacío", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (idTrabajador <= 0) {
            JOptionPane.showMessageDialog(null, "El ID del trabajador debe ser mayor a 0", "Campo Inválido", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    void listado() {
        DefaultTableModel dt = (DefaultTableModel) regTraForm.TablaTra.getModel();

        dt.setRowCount(0);
        for (Trabajador x : objTR.Listado()) {
            Object[] v = new Object[9];
            v[0] = x.getCodigoTra();
            v[1] = x.getNombre();
            v[2] = x.getApellido();
            v[3] = x.getFechaNacimiento();
            v[4] = x.getUsuario();
            v[5] = x.getContrasena();
            v[6] = new ImageIcon(x.getFoto());
            v[7] = x.getSalario();
            v[8] = x.getFechaContratacion();
            dt.addRow(v);
        }

        regTraForm.TablaTra.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
    }

    void limpiarCampos() {
        regTraForm.txtIDT.setText("");
        regTraForm.txtNombre.setText("");
        regTraForm.txtApellido.setText("");
        regTraForm.DCNacimiento.setDate(null);
        regTraForm.txtUsuario.setText("");
        regTraForm.txtContraseña.setText("");
        regTraForm.txtSalario.setText("");
        regTraForm.DCContrato.setDate(null);
        regTraForm.lblImagenSeleccionada.setIcon(null);
        imagenSeleccionadaBytes = null;
    }

    private byte[] convertirArchivoABytes(File file) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String extension = obtenerExtensionArchivo(file);
            BufferedImage imagenOriginal = ImageIO.read(file);
            int anchoDeseado = regTraForm.lblImagenSeleccionada.getWidth();
            int altoDeseado = regTraForm.lblImagenSeleccionada.getHeight();
            BufferedImage imagenRedimensionada = new BufferedImage(anchoDeseado, altoDeseado, imagenOriginal.getType());
            Graphics2D g2d = imagenRedimensionada.createGraphics();
            g2d.drawImage(imagenOriginal, 0, 0, anchoDeseado, altoDeseado, null);
            g2d.dispose();
            ImageIcon imagenRedimensionadaIcono = new ImageIcon(imagenRedimensionada);
            regTraForm.lblImagenSeleccionada.setIcon(imagenRedimensionadaIcono);
            ImageIO.write(imagenRedimensionada, extension, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String obtenerExtensionArchivo(File file) {
        String nombreArchivo = file.getName();
        int indicePunto = nombreArchivo.lastIndexOf(".");
        if (indicePunto > 0 && indicePunto < nombreArchivo.length() - 1) {
            return nombreArchivo.substring(indicePunto + 1).toLowerCase();
        }
        return "";
    }

    void guardar() {
        try {
            int idt = Integer.parseInt(regTraForm.txtIDT.getText());
            String nombre = regTraForm.txtNombre.getText();
            String apel = regTraForm.txtApellido.getText();
            JDateChooser dateChooser = regTraForm.DCNacimiento;
            Date naci = dateChooser.getDate();
            String usu = regTraForm.txtUsuario.getText();
            String contra = regTraForm.txtContraseña.getText();
            double sueldo = Double.parseDouble(regTraForm.txtSalario.getText());
            JDateChooser jDateChooser = regTraForm.DCContrato;
            Date contrato = jDateChooser.getDate();

            Trabajador pr = new Trabajador(idt, nombre, apel, naci, usu, contra, imagenSeleccionadaBytes, sueldo, contrato); // Pasar los bytes de la imagen seleccionada al objeto Trabajador
            objTR.crearTrabajador(pr);

            limpiarCampos();

            listado();
            JOptionPane.showMessageDialog(null, "Trabajador agregado correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos en las casillas correctamente");
        }
    }

    void actualizar() {
        try {
            int idTrabajador = Integer.parseInt(regTraForm.txtIDT.getText());
            String nombre = regTraForm.txtNombre.getText();
            String apellido = regTraForm.txtApellido.getText();
            JDateChooser dateChooser = regTraForm.DCNacimiento;
            Date fechaNacimiento = dateChooser.getDate();
            String usuario = regTraForm.txtUsuario.getText();
            String contrasena = regTraForm.txtContraseña.getText();
            double salario = Double.parseDouble(regTraForm.txtSalario.getText());
            JDateChooser jDateChooser = regTraForm.DCContrato;
            Date fechaContratacion = jDateChooser.getDate();

            if (validarCampos(nombre, idTrabajador)) {
                String confirmacion = JOptionPane.showInputDialog(null, "Escriba CONTINUAR para completar el proceso");

                if ("CONTINUAR".equals(confirmacion)) {
                    Trabajador trabajador = new Trabajador(idTrabajador, nombre, apellido, fechaNacimiento, usuario, contrasena, imagenSeleccionadaBytes, salario, fechaContratacion);
                    objTR.modificarTrabajador(trabajador);

                    limpiarCampos();
                    regTraForm.lblImagenSeleccionada.setIcon(null);

                    JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
                    listado();
                } else {
                    JOptionPane.showMessageDialog(null, "Proceso cancelado");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al procesar la solicitud");
        }
    }

    void eliminar() {
        String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
        try {
            if (confirm.equals("CONTINUAR")) {
                int codi = Integer.parseInt(regTraForm.txtIDT.getText());
                objTR.eliminarTrabajdor(codi);
                regTraForm.txtIDT.setText("");
                listado();
                JOptionPane.showMessageDialog(null, "Eliminacion completada exitosamente");

            } else {
                JOptionPane.showMessageDialog(null, "Proceso cancelado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccione un Producto");
        }
    }

}
