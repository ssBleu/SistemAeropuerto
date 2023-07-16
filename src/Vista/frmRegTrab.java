
package Vista;

import Controlador.LoginControlador;
import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Trabajador;
import static Vista.Controladores.objTR;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import util.ImageRenderer;

public class frmRegTrab extends javax.swing.JFrame {
    private byte[] imagenSeleccionadaBytes;
    private byte[] imagenUsuarioSes;
    public frmRegTrab() {
        initComponents();
        
        JLayeredPane layeredPane = getLayeredPane();
        layeredPane.add(panelDetras, JLayeredPane.PALETTE_LAYER);
        panelDetras.setVisible(false);
        
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        //tablita
        TablaTra.getTableHeader().setFont(new Font("Segou UI", Font.BOLD, 12));
        TablaTra.getTableHeader().setOpaque(false);
        TablaTra.getTableHeader().setBackground(new Color(12, 64, 160));
        TablaTra.getTableHeader().setForeground(new Color(255,255,255));
        TablaTra.setRowHeight(25);
        
        int rowHeight = 80;
        TablaTra.setRowHeight(rowHeight);

        listado();
        
        obtenerUsuarioSesionado();
        
        lblImagenSeleccionada.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    }
    
        public void obtenerUsuarioSesionado() {
        Trabajador trabajadorSesionado = LoginControlador.getTrabajadorSesionado();
        if (trabajadorSesionado != null) {

            lblIDUsu.setText(""+trabajadorSesionado.getCodigoTra());
            lblUsuarioSes.setText(trabajadorSesionado.getUsuario());
            lblNombreSes.setText(trabajadorSesionado.getNombre());
            lblApeUsu.setText(trabajadorSesionado.getApellido());
            imagenUsuarioSes = trabajadorSesionado.getFoto();
            ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
            lblFotoSes.setIcon(IconoSelec);
            lblFotoSes2.setIcon(IconoSelec);
            lblUsuarioSes2.setText(trabajadorSesionado.getUsuario());

            LocalTime horaActual = LocalTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            String horaDeInicio = horaActual.format(formatter);
            lblTiempSes.setText(""+horaDeInicio);
        } else {
            System.out.println("Se supone que esto no debe pasar XD");
        }
    }
    
    
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
        DefaultTableModel dt = (DefaultTableModel) TablaTra.getModel();

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

        TablaTra.getColumnModel().getColumn(6).setCellRenderer(new ImageRenderer());
    }
    
    void limpiarCampos(){
        txtIDT.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        DCNacimiento.setDate(null);
        txtUsuario.setText("");
        txtContraseña.setText("");
        txtSalario.setText("");
        DCContrato.setDate(null);
        lblImagenSeleccionada.setIcon(null); 
        imagenSeleccionadaBytes = null; 
    }
    
    
    private byte[] convertirArchivoABytes(File file) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String extension = obtenerExtensionArchivo(file);
            BufferedImage imagenOriginal = ImageIO.read(file);
            int anchoDeseado = lblImagenSeleccionada.getWidth();
            int altoDeseado = lblImagenSeleccionada.getHeight();
            BufferedImage imagenRedimensionada = new BufferedImage(anchoDeseado, altoDeseado, imagenOriginal.getType());
            Graphics2D g2d = imagenRedimensionada.createGraphics();
            g2d.drawImage(imagenOriginal, 0, 0, anchoDeseado, altoDeseado, null);
            g2d.dispose();
            ImageIcon imagenRedimensionadaIcono = new ImageIcon(imagenRedimensionada);
            lblImagenSeleccionada.setIcon(imagenRedimensionadaIcono);
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

    @SuppressWarnings("unchecked")
    int x = 210;
    int a = 0;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelReTra = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnReTra = new javax.swing.JLabel();
        panelBusCli = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        btnBusCli = new javax.swing.JLabel();
        lblFotoSes2 = new javax.swing.JLabel();
        panelReAero = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnReAero = new javax.swing.JLabel();
        panelRegVue = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        btnRegVue = new javax.swing.JLabel();
        panelRegAvion = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnRegAvion = new javax.swing.JLabel();
        panelEstadisticas = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnEstadisticas = new javax.swing.JLabel();
        panelDetras = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblTiempSes = new javax.swing.JLabel();
        lblUsuarioSes = new javax.swing.JLabel();
        lblNombreSes = new javax.swing.JLabel();
        lblApeUsu = new javax.swing.JLabel();
        lblIDUsu = new javax.swing.JLabel();
        lblFotoSes = new javax.swing.JLabel();
        cerrarSesion = new javax.swing.JLabel();
        lblUsuarioSes2 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SliderDelMenu = new javax.swing.JLabel();
        panelRound1 = new util.PanelRound();
        txtContraseña = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        DCNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtIDT = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        DCContrato = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        subirFoto = new javax.swing.JButton();
        lblImagenSeleccionada = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        panelRound2 = new util.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTra = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(239, 231, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(67, 90, 132));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelReTra.setBackground(new java.awt.Color(67, 90, 132));
        panelReTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelReTraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelReTraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelReTraMouseExited(evt);
            }
        });
        panelReTra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retra (1).png"))); // NOI18N
        panelReTra.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnReTra.setBackground(new java.awt.Color(67, 90, 132));
        btnReTra.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnReTra.setForeground(new java.awt.Color(255, 255, 255));
        btnReTra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReTra.setText("Registro de Trabajador");
        btnReTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReTraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReTraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReTraMouseExited(evt);
            }
        });
        panelReTra.add(btnReTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelReTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 250, 50));

        panelBusCli.setBackground(new java.awt.Color(67, 90, 132));
        panelBusCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelBusCliMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelBusCliMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelBusCliMouseExited(evt);
            }
        });
        panelBusCli.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscli (1).png"))); // NOI18N
        panelBusCli.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnBusCli.setBackground(new java.awt.Color(255, 255, 255));
        btnBusCli.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBusCli.setForeground(new java.awt.Color(255, 255, 255));
        btnBusCli.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBusCli.setText("Búsqueda de Cliente");
        btnBusCli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusCliMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBusCliMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBusCliMouseExited(evt);
            }
        });
        panelBusCli.add(btnBusCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelBusCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 250, 50));

        lblFotoSes2.setText("jLabel15");
        jPanel3.add(lblFotoSes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 80, 90));

        panelReAero.setBackground(new java.awt.Color(67, 90, 132));
        panelReAero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelReAeroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelReAeroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelReAeroMouseExited(evt);
            }
        });
        panelReAero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/viajE1.png"))); // NOI18N
        panelReAero.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnReAero.setBackground(new java.awt.Color(255, 255, 255));
        btnReAero.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnReAero.setForeground(new java.awt.Color(255, 255, 255));
        btnReAero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReAero.setText("Registro de Aerolínea");
        btnReAero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReAeroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReAeroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReAeroMouseExited(evt);
            }
        });
        panelReAero.add(btnReAero, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelReAero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 250, 50));

        panelRegVue.setBackground(new java.awt.Color(67, 90, 132));
        panelRegVue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRegVueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRegVueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRegVueMouseExited(evt);
            }
        });
        panelRegVue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario.png"))); // NOI18N
        panelRegVue.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnRegVue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRegVue.setForeground(new java.awt.Color(255, 255, 255));
        btnRegVue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegVue.setText("Registro de Vuelos");
        btnRegVue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegVueMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegVueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegVueMouseExited(evt);
            }
        });
        panelRegVue.add(btnRegVue, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelRegVue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 250, -1));

        panelRegAvion.setBackground(new java.awt.Color(67, 90, 132));
        panelRegAvion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelRegAvionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRegAvionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRegAvionMouseExited(evt);
            }
        });
        panelRegAvion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boletos-deavion.png"))); // NOI18N
        panelRegAvion.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnRegAvion.setBackground(new java.awt.Color(255, 255, 255));
        btnRegAvion.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRegAvion.setForeground(new java.awt.Color(255, 255, 255));
        btnRegAvion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegAvion.setText("Registro de Avion");
        btnRegAvion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegAvionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegAvionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegAvionMouseExited(evt);
            }
        });
        panelRegAvion.add(btnRegAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelRegAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 250, -1));

        panelEstadisticas.setBackground(new java.awt.Color(67, 90, 132));
        panelEstadisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelEstadisticasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelEstadisticasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelEstadisticasMouseExited(evt);
            }
        });
        panelEstadisticas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estadis (1).png"))); // NOI18N
        panelEstadisticas.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnEstadisticas.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEstadisticas.setForeground(new java.awt.Color(255, 255, 255));
        btnEstadisticas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEstadisticas.setText("Estadísticas");
        btnEstadisticas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstadisticasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEstadisticasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEstadisticasMouseExited(evt);
            }
        });
        panelEstadisticas.add(btnEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 250, -1));

        panelDetras.setBackground(new java.awt.Color(69, 80, 135));
        panelDetras.setPreferredSize(new java.awt.Dimension(250, 660));
        panelDetras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Nombre:");
        panelDetras.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 30));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Usuario:");
        panelDetras.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, 30));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Apellido:");
        panelDetras.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, 30));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Inicio de sesión:");
        panelDetras.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("ID Usuario:");
        panelDetras.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, 30));

        lblTiempSes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTiempSes.setForeground(new java.awt.Color(204, 255, 204));
        lblTiempSes.setText("TIME");
        panelDetras.add(lblTiempSes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 70, 20));

        lblUsuarioSes.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblUsuarioSes.setForeground(new java.awt.Color(204, 255, 204));
        lblUsuarioSes.setText("USER");
        panelDetras.add(lblUsuarioSes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 80, 30));

        lblNombreSes.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblNombreSes.setForeground(new java.awt.Color(204, 255, 204));
        lblNombreSes.setText("NAME");
        panelDetras.add(lblNombreSes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 80, 30));

        lblApeUsu.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblApeUsu.setForeground(new java.awt.Color(204, 255, 204));
        lblApeUsu.setText("APE");
        panelDetras.add(lblApeUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 80, 30));

        lblIDUsu.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        lblIDUsu.setForeground(new java.awt.Color(204, 255, 204));
        lblIDUsu.setText("ID");
        panelDetras.add(lblIDUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 80, 30));

        lblFotoSes.setForeground(new java.awt.Color(255, 255, 255));
        lblFotoSes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelDetras.add(lblFotoSes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 90, 90));

        cerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        cerrarSesion.setText("Cerrar Sesión");
        cerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSesionMouseClicked(evt);
            }
        });
        panelDetras.add(cerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 600, -1, -1));

        jPanel3.add(panelDetras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 660));

        lblUsuarioSes2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUsuarioSes2.setForeground(new java.awt.Color(204, 255, 204));
        lblUsuarioSes2.setText("USER");
        lblUsuarioSes2.setMaximumSize(new java.awt.Dimension(55, 20));
        lblUsuarioSes2.setMinimumSize(new java.awt.Dimension(55, 20));
        lblUsuarioSes2.setPreferredSize(new java.awt.Dimension(55, 20));
        jPanel3.add(lblUsuarioSes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 160, -1, -1));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Usuario:");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 160, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 660));

        jPanel2.setBackground(new java.awt.Color(12, 64, 160));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        jLabel3.setText("-");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        jLabel2.setText("x");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO DE TRABAJADOR");

        SliderDelMenu.setBackground(new java.awt.Color(12, 64, 160));
        SliderDelMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SliderDelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menuGOD.png"))); // NOI18N
        SliderDelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SliderDelMenu.setOpaque(true);
        SliderDelMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SliderDelMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SliderDelMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SliderDelMenuMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(SliderDelMenu)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 695, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SliderDelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 840, 80));

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelRound1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 140, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Contraseña:");
        panelRound1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Usuario:");
        panelRound1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 20));
        panelRound1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 140, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Nacimiento:");
        panelRound1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, 20));

        DCNacimiento.setDateFormatString("yyyy-MM-dd");
        panelRound1.add(DCNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 140, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Apellido:");
        panelRound1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 20));
        panelRound1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 140, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Nombre:");
        panelRound1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 20));
        panelRound1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 140, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Codigo");
        panelRound1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, 20));
        panelRound1.add(txtIDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 140, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Salario:");
        panelRound1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Fecha de contrato:");
        panelRound1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, -1, 20));
        panelRound1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, 140, -1));

        DCContrato.setDateFormatString("yyyy-MM-dd");
        panelRound1.add(DCContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 140, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Foto:");
        panelRound1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, 20));

        subirFoto.setText("Subir Foto");
        subirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirFotoActionPerformed(evt);
            }
        });
        panelRound1.add(subirFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 100, -1));

        lblImagenSeleccionada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagenSeleccionada.setText("imagen");
        panelRound1.add(lblImagenSeleccionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 80, 90));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelRound1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 90, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        panelRound1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 90, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelRound1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 90, -1));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 800, 230));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaTra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Trabajador", "Nombre", "Apellido", "Nacimiento", "Usuario", "Contraseña", "Foto", "Salario", "Contrato"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaTraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTra);

        panelRound2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 760, 260));

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 800, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
                int idt = Integer.parseInt(txtIDT.getText());
                String nombre = txtNombre.getText();
                String apel = txtApellido.getText();
                JDateChooser dateChooser = DCNacimiento;
                Date naci = dateChooser.getDate();
                String usu = txtUsuario.getText();
                String contra = txtContraseña.getText();
                double sueldo = Double.parseDouble(txtSalario.getText());
                JDateChooser jDateChooser = DCContrato;
                Date contrato = jDateChooser.getDate();

                Trabajador pr = new Trabajador(idt, nombre, apel, naci, usu, contra, imagenSeleccionadaBytes, sueldo, contrato); // Pasar los bytes de la imagen seleccionada al objeto Trabajador
                objTR.crearTrabajador(pr);

                limpiarCampos();

                listado();
                JOptionPane.showMessageDialog(null, "Trabajador agregado correctamente");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ingrese los datos en las casillas correctamente");
            }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            int idTrabajador = Integer.parseInt(txtIDT.getText());
            String nombre = txtNombre.getText();
            String apellido = txtApellido.getText();
            JDateChooser dateChooser = DCNacimiento;
            Date fechaNacimiento = dateChooser.getDate();
            String usuario = txtUsuario.getText();
            String contrasena = txtContraseña.getText();
            double salario = Double.parseDouble(txtSalario.getText());
            JDateChooser jDateChooser = DCContrato;
            Date fechaContratacion = jDateChooser.getDate();

            if (validarCampos(nombre, idTrabajador)) {
                String confirmacion = JOptionPane.showInputDialog(null, "Escriba CONTINUAR para completar el proceso");

                if ("CONTINUAR".equals(confirmacion)) {
                    Trabajador trabajador = new Trabajador(idTrabajador, nombre, apellido, fechaNacimiento, usuario, contrasena, imagenSeleccionadaBytes, salario, fechaContratacion);
                    objTR.modificarTrabajador(trabajador);

                    limpiarCampos();
                    lblImagenSeleccionada.setIcon(null);

                    JOptionPane.showMessageDialog(null, "Datos actualizados exitosamente");
                    listado();
                } else {
                    JOptionPane.showMessageDialog(null, "Proceso cancelado");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al procesar la solicitud");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        String confirm = JOptionPane.showInputDialog("Escriba CONTINUAR  para completar el proceso");
        try {
            if (confirm.equals("CONTINUAR")){
                int codi=Integer.parseInt(txtIDT.getText());
                objTR.eliminarTrabajdor(codi);
                txtIDT.setText("");
                listado();
                JOptionPane.showMessageDialog(null,"Eliminacion completada exitosamente");

            } else {
                JOptionPane.showMessageDialog(null,"Proceso cancelado");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Seleccione un Producto");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TablaTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTraMouseClicked
       int idt = TablaTra.getSelectedRow();
        int DNI = Integer.parseInt(TablaTra.getValueAt(idt, 0).toString());

            Trabajador x = objTR.buscarTrabajador(DNI);
            txtIDT.setText(""+x.getCodigoTra());
            txtNombre.setText(x.getNombre());
            txtApellido.setText(x.getApellido());
            DCNacimiento.setDate(x.getFechaNacimiento());
            txtUsuario.setText(x.getUsuario());
            txtContraseña.setText(x.getContrasena()); 
            txtSalario.setText(""+x.getSalario());
            DCContrato.setDate(x.getFechaContratacion());
            imagenSeleccionadaBytes = x.getFoto();
 
            ImageIcon IconoSelec = new ImageIcon(imagenSeleccionadaBytes);
            lblImagenSeleccionada.setIcon(IconoSelec);
            
    }//GEN-LAST:event_TablaTraMouseClicked

    private void subirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirFotoActionPerformed
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                imagenSeleccionadaBytes = convertirArchivoABytes(file);

                ImageIcon imagenIcono = new ImageIcon(imagenSeleccionadaBytes);
                lblImagenSeleccionada.setIcon(imagenIcono);
            }

    }//GEN-LAST:event_subirFotoActionPerformed

    private void btnReTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReTraMouseClicked
        frmRegTrab frmReTrab=new frmRegTrab();
        frmReTrab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReTraMouseClicked

    private void btnReTraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReTraMouseEntered
        maus = true;
        cambiarColores(btnReTra,panelReTra);
    }//GEN-LAST:event_btnReTraMouseEntered

    private void btnReTraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReTraMouseExited
        maus = false;
        cambiarColores(btnReTra,panelReTra);
    }//GEN-LAST:event_btnReTraMouseExited

    private void panelReTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReTraMouseClicked
        frmRegTrab frmRegTrab=new frmRegTrab();
        frmRegTrab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelReTraMouseClicked

    private void panelReTraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReTraMouseEntered
        maus = true;
        cambiarColores(btnReTra, panelReTra);
    }//GEN-LAST:event_panelReTraMouseEntered

    private void panelReTraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReTraMouseExited
        maus = false;
        cambiarColores(btnReTra, panelReTra);
    }//GEN-LAST:event_panelReTraMouseExited

    private void btnBusCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusCliMouseClicked
        frmBusCli frmBuCli=new frmBusCli();
        frmBuCli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBusCliMouseClicked

        //colores panel/jlabel"botones" xd
    private java.awt.Color ColorEnteredBoton = new java.awt.Color(55, 231, 173);
    private java.awt.Color ColorOriginalPanel = new java.awt.Color(67,90,132);
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
    
    private void btnBusCliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusCliMouseEntered
        maus = true;
        cambiarColores(btnBusCli,panelBusCli);
    }//GEN-LAST:event_btnBusCliMouseEntered

    private void btnBusCliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusCliMouseExited
        maus = false;
        cambiarColores(btnBusCli,panelBusCli);
    }//GEN-LAST:event_btnBusCliMouseExited

    private void panelBusCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBusCliMouseClicked
        frmBusCli frmBuCli=new frmBusCli();
        frmBuCli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelBusCliMouseClicked

    private void panelBusCliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBusCliMouseEntered
        maus = true;
        cambiarColores(btnBusCli, panelBusCli);
    }//GEN-LAST:event_panelBusCliMouseEntered

    private void panelBusCliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBusCliMouseExited
        maus = false;
        cambiarColores(btnBusCli,panelBusCli);
    }//GEN-LAST:event_panelBusCliMouseExited

    private void btnReAeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReAeroMouseClicked
        frmRegAero frmReAero=new frmRegAero();
        frmReAero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReAeroMouseClicked

    private void btnReAeroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReAeroMouseEntered
        maus = true;
        cambiarColores(btnReAero,panelReAero);
    }//GEN-LAST:event_btnReAeroMouseEntered

    private void btnReAeroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReAeroMouseExited
        maus = false;
        cambiarColores(btnReAero,panelReAero);
    }//GEN-LAST:event_btnReAeroMouseExited

    private void panelReAeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReAeroMouseClicked
        frmRegAero frmRegAero=new frmRegAero();
        frmRegAero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelReAeroMouseClicked

    private void panelReAeroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReAeroMouseEntered
        maus = true;
        cambiarColores(btnReAero, panelReAero);
    }//GEN-LAST:event_panelReAeroMouseEntered

    private void panelReAeroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReAeroMouseExited
        maus = false;
        cambiarColores(btnReAero, panelReAero);
    }//GEN-LAST:event_panelReAeroMouseExited

    private void btnRegVueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegVueMouseClicked
        frmRegVue frmRegVue=new frmRegVue();
        frmRegVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegVueMouseClicked

    private void btnRegVueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegVueMouseEntered
        maus = true;
        cambiarColores(btnRegVue,panelRegVue);
    }//GEN-LAST:event_btnRegVueMouseEntered

    private void btnRegVueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegVueMouseExited
        maus = false;
        cambiarColores(btnRegVue,panelRegVue);
    }//GEN-LAST:event_btnRegVueMouseExited

    private void panelRegVueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegVueMouseClicked
        frmRegVue frmRegVue=new frmRegVue();
        frmRegVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelRegVueMouseClicked

    private void panelRegVueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegVueMouseEntered
        maus = true;
        cambiarColores(btnRegVue, panelRegVue);
    }//GEN-LAST:event_panelRegVueMouseEntered

    private void panelRegVueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegVueMouseExited
        maus = false;
        cambiarColores(btnRegVue, panelRegVue);
    }//GEN-LAST:event_panelRegVueMouseExited

    private void btnRegAvionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegAvionMouseClicked
        frmRegAv frmReVue=new frmRegAv();
        frmReVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegAvionMouseClicked

    private void btnRegAvionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegAvionMouseEntered
        maus = true;
        cambiarColores(btnRegAvion,panelRegAvion);
    }//GEN-LAST:event_btnRegAvionMouseEntered

    private void btnRegAvionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegAvionMouseExited
        maus = false;
        cambiarColores(btnRegAvion,panelRegAvion);
    }//GEN-LAST:event_btnRegAvionMouseExited

    private void panelRegAvionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegAvionMouseClicked
        frmRegAv frmRegAv=new frmRegAv();
        frmRegAv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelRegAvionMouseClicked

    private void panelRegAvionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegAvionMouseEntered
        maus = true;
        cambiarColores(btnRegAvion, panelRegAvion);
    }//GEN-LAST:event_panelRegAvionMouseEntered

    private void panelRegAvionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegAvionMouseExited
        maus = false;
        cambiarColores(btnRegAvion, panelRegAvion);
    }//GEN-LAST:event_panelRegAvionMouseExited

    private void btnEstadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadisticasMouseClicked
        frmEstadis frmEsta=new frmEstadis();
        frmEsta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEstadisticasMouseClicked

    private void btnEstadisticasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadisticasMouseEntered
        maus = true;
        cambiarColores(btnEstadisticas,panelEstadisticas);
    }//GEN-LAST:event_btnEstadisticasMouseEntered

    private void btnEstadisticasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadisticasMouseExited
        maus = false;
        cambiarColores(btnEstadisticas,panelEstadisticas);
    }//GEN-LAST:event_btnEstadisticasMouseExited

    private void panelEstadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEstadisticasMouseClicked
        frmEstadis frmEstadis=new frmEstadis();
        frmEstadis.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelEstadisticasMouseClicked

    private void panelEstadisticasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEstadisticasMouseEntered
        maus = true;
        cambiarColores(btnEstadisticas, panelEstadisticas);
    }//GEN-LAST:event_panelEstadisticasMouseEntered

    private void panelEstadisticasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEstadisticasMouseExited
        maus = false;
        cambiarColores(btnEstadisticas, panelEstadisticas);
    }//GEN-LAST:event_panelEstadisticasMouseExited

    private void cerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionMouseClicked
        cerrarSesion();
        frmLogin frmLogin=new frmLogin();
        frmLogin.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_cerrarSesionMouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.setState(frmLogin.ICONIFIED);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?","EXIT",dialogButton);
        if(result == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void SliderDelMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SliderDelMenuMouseClicked
        // desactiva el botoncito para que no presiones a cada rato :,v
        SliderDelMenu.setEnabled(false);

        int initialSize = jPanel3.getWidth();
        int finalSize = (initialSize == 250) ? 0 : 250;
        int increment = (finalSize < initialSize) ? -5 : 5; // El tamaño cambia de -5 o 5 (puede cambiarse)
        int delay = 5; // Retardo (ms)

        Timer timer = new Timer(delay, new ActionListener() {
            int currentSize = initialSize; // 0 o 250

            @Override
            public void actionPerformed(ActionEvent e) {
                if ((increment < 0 && currentSize >= finalSize) || (increment > 0 && currentSize <= finalSize)) {
                    jPanel3.setSize(currentSize, 660); //0 o 250 dependiendo :v
                    panelDetras.setLocation(currentSize, panelDetras.getY()); // el panel se mueve mientras el otro aparece :v
                    panelDetras.setSize(250 - currentSize, 660); // Ajustar el tamaño //(desactivar para ver la magia)
                    currentSize += increment;
                    panelDetras.setVisible(true); //UNA HORA POR ESTA WEAAA
                } else {
                    ((Timer) e.getSource()).stop();

                    if (finalSize == 0) {
                        panelDetras.setVisible(true);
                    } else {
                        panelDetras.setVisible(false);
                    }

                    // activa el botoncito
                    SliderDelMenu.setEnabled(true);
                }
            }
        });
        timer.start();
    }//GEN-LAST:event_SliderDelMenuMouseClicked

    private void SliderDelMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SliderDelMenuMouseEntered

    }//GEN-LAST:event_SliderDelMenuMouseEntered

    private void SliderDelMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SliderDelMenuMouseExited

    }//GEN-LAST:event_SliderDelMenuMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmRegTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegTrab.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegTrab().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCContrato;
    private com.toedter.calendar.JDateChooser DCNacimiento;
    private javax.swing.JLabel SliderDelMenu;
    private javax.swing.JTable TablaTra;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel btnBusCli;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel btnEstadisticas;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel btnReAero;
    private javax.swing.JLabel btnReTra;
    private javax.swing.JLabel btnRegAvion;
    private javax.swing.JLabel btnRegVue;
    private javax.swing.JLabel cerrarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApeUsu;
    private javax.swing.JLabel lblFotoSes;
    private javax.swing.JLabel lblFotoSes2;
    private javax.swing.JLabel lblIDUsu;
    private javax.swing.JLabel lblImagenSeleccionada;
    private javax.swing.JLabel lblNombreSes;
    private javax.swing.JLabel lblTiempSes;
    private javax.swing.JLabel lblUsuarioSes;
    private javax.swing.JLabel lblUsuarioSes2;
    private javax.swing.JPanel panelBusCli;
    private javax.swing.JPanel panelDetras;
    private javax.swing.JPanel panelEstadisticas;
    private javax.swing.JPanel panelReAero;
    private javax.swing.JPanel panelReTra;
    private javax.swing.JPanel panelRegAvion;
    private javax.swing.JPanel panelRegVue;
    private util.PanelRound panelRound1;
    private util.PanelRound panelRound2;
    private javax.swing.JButton subirFoto;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtIDT;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
private void labelcolor(JLabel label){
        label.setBackground(new java.awt.Color(53,162,107));
    }
    
    private void resetlabelcolor(JLabel label){
        label.setBackground(new java.awt.Color(54,70,78));
    }
}
