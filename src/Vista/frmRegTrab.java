
package Vista;

import Modelo.Trabajador;
import static Vista.Controladores.objTR;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import util.ImageRenderer;

public class frmRegTrab extends javax.swing.JFrame {
    private byte[] imagenSeleccionadaBytes;
    public frmRegTrab() {
        initComponents();
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
        
        lblImagenSeleccionada.setBorder(BorderFactory.createLineBorder(Color.BLACK));

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

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTra = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        DCNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtSalario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        DCContrato = new com.toedter.calendar.JDateChooser();
        txtIDT = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        subirFoto = new javax.swing.JButton();
        lblImagenSeleccionada = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnReTra2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnBusCli2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnReAero2 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnRegVue = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        btnRegVue2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 102, 255));

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

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("REGISTROS");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("TRABAJADOR");

        jLabel26.setBackground(new java.awt.Color(0, 102, 204));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menuGOD.png"))); // NOI18N
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel26.setOpaque(true);
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel6)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 300, Short.MAX_VALUE)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 860, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, 80, -1));

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 80, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 830, 200));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Codigo");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 180, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Apellido:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 180, -1));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Nacimiento:");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        DCNacimiento.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(DCNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 120, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Usuario:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 20));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 90, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Contraseña:");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 20));
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 80, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Salario:");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, 20));
        jPanel1.add(txtSalario, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 110, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Foto:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, 20));

        DCContrato.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(DCContrato, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));
        jPanel1.add(txtIDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 90, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Nombre:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Fecha de contrato:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, 20));

        subirFoto.setText("Subir Foto");
        subirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subirFotoActionPerformed(evt);
            }
        });
        jPanel1.add(subirFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        lblImagenSeleccionada.setText("imagen");
        jPanel1.add(lblImagenSeleccionada, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 80, 90));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 860, 420));

        jPanel3.setBackground(new java.awt.Color(54, 70, 78));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(54, 70, 78));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retra (1).png"))); // NOI18N
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        btnReTra2.setBackground(new java.awt.Color(255, 255, 255));
        btnReTra2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnReTra2.setForeground(new java.awt.Color(255, 255, 255));
        btnReTra2.setText("Registro de Trabajador");
        btnReTra2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReTra2MouseClicked(evt);
            }
        });
        jPanel4.add(btnReTra2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 190, 60));

        jPanel5.setBackground(new java.awt.Color(54, 70, 78));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscli (1).png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        btnBusCli2.setBackground(new java.awt.Color(255, 255, 255));
        btnBusCli2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBusCli2.setForeground(new java.awt.Color(255, 255, 255));
        btnBusCli2.setText("    Busqueda de Cliente");
        btnBusCli2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusCli2MouseClicked(evt);
            }
        });
        jPanel5.add(btnBusCli2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 150, -1));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 180, 50));

        jPanel7.setBackground(new java.awt.Color(54, 70, 78));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/viajE1.png"))); // NOI18N
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 50));

        btnReAero2.setBackground(new java.awt.Color(255, 255, 255));
        btnReAero2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnReAero2.setForeground(new java.awt.Color(255, 255, 255));
        btnReAero2.setText("   Registro de Aerolínea");
        btnReAero2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReAero2MouseClicked(evt);
            }
        });
        jPanel7.add(btnReAero2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jPanel3.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 180, 70));

        jPanel8.setBackground(new java.awt.Color(54, 70, 78));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estadis (1).png"))); // NOI18N
        jPanel8.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        jLabel14.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Estadisticas");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 80, 20));

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 180, 40));

        jPanel9.setBackground(new java.awt.Color(54, 70, 78));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boletos-deavion.png"))); // NOI18N
        jPanel9.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        btnRegVue.setBackground(new java.awt.Color(255, 255, 255));
        btnRegVue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRegVue.setForeground(new java.awt.Color(255, 255, 255));
        btnRegVue.setText("  Registro de Avion");
        btnRegVue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegVueMouseClicked(evt);
            }
        });
        jPanel9.add(btnRegVue, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 180, 50));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario (1).png"))); // NOI18N
        jPanel3.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jPanel10.setBackground(new java.awt.Color(54, 70, 78));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario.png"))); // NOI18N
        jPanel10.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        btnRegVue2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRegVue2.setForeground(new java.awt.Color(255, 255, 255));
        btnRegVue2.setText("  Registro de Vuelos");
        btnRegVue2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegVue2MouseClicked(evt);
            }
        });
        jPanel10.add(btnRegVue2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 180, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 490));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void btnReTra2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReTra2MouseClicked
        frmRegTrab frmReTrab=new frmRegTrab();
        frmReTrab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReTra2MouseClicked

    private void btnBusCli2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusCli2MouseClicked
        frmBusCli frmBuCli=new frmBusCli();
        frmBuCli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBusCli2MouseClicked

    private void btnReAero2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReAero2MouseClicked
        frmRegAero frmReAero=new frmRegAero();
        frmReAero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReAero2MouseClicked

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        frmEstadis frmEsta=new frmEstadis();
        frmEsta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void btnRegVueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegVueMouseClicked
        frmRegAv frmReVue=new frmRegAv();
        frmReVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegVueMouseClicked

    private void btnRegVue2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegVue2MouseClicked
        frmRegVue frmRegVue=new frmRegVue();
        frmRegVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegVue2MouseClicked

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        if ( x == 210 ) {
            jPanel3.setSize(210, 552);
            Thread th = new Thread() {
                @Override
                public void run(){
                    try {

                        for ( int i = 210; i >= 0; i--){
                            Thread.sleep(1);
                            jPanel3.setSize(i, 552);

                            a++;
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
            x=0;
        } else if( x == 0 ){
            jPanel3.setSize(x, 552);
            Thread th = new Thread(){
                @Override
                public void run(){
                    try {
                        for (int i = 0; i <= x; i++){
                            Thread.sleep(1);
                            jPanel3.setSize(i, 552);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };th.start();
            x = 210;
        }
    }//GEN-LAST:event_jLabel26MouseClicked

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
    private javax.swing.JTable TablaTra;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel btnBusCli2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel btnReAero2;
    private javax.swing.JLabel btnReTra2;
    private javax.swing.JLabel btnRegVue;
    private javax.swing.JLabel btnRegVue2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagenSeleccionada;
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
