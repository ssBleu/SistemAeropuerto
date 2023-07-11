
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
        
        int rowHeight = 80; // Altura deseada de las celdas en píxeles
        TablaTra.setRowHeight(rowHeight);

        //int columnWidth = 100; // Ancho deseado de la columna en píxeles
        //TablaTra.getColumnModel().getColumn(indiceColumna).setPreferredWidth(columnWidth);

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
            v[6] = new ImageIcon(x.getFoto()); // Crear un ImageIcon a partir de los bytes de la imagen
            v[7] = x.getSalario();
            v[8] = x.getFechaContratacion();
            dt.addRow(v);
        }

        // Establecer el renderizador personalizado para la columna de la imagen
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
        lblImagenSeleccionada.setIcon(null); // Restablecer la imagen en el JLabel
        imagenSeleccionadaBytes = null; // Restablecer los bytes de la imagen seleccionada
    }
    
    
    private byte[] convertirArchivoABytes(File file) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            String extension = obtenerExtensionArchivo(file);
            BufferedImage imagenOriginal = ImageIO.read(file);
            // Obtener el tamaño deseado del JLabel
            int anchoDeseado = lblImagenSeleccionada.getWidth();
            int altoDeseado = lblImagenSeleccionada.getHeight();
            // Redimensionar la imagen al tamaño deseado
            BufferedImage imagenRedimensionada = new BufferedImage(anchoDeseado, altoDeseado, imagenOriginal.getType());
            Graphics2D g2d = imagenRedimensionada.createGraphics();
            g2d.drawImage(imagenOriginal, 0, 0, anchoDeseado, altoDeseado, null);
            g2d.dispose();
            // Mostrar la imagen redimensionada en el JLabel
            ImageIcon imagenRedimensionadaIcono = new ImageIcon(imagenRedimensionada);
            lblImagenSeleccionada.setIcon(imagenRedimensionadaIcono);
            // Obtener los bytes de la imagen redimensionada
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        btnBusCli2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnReVue2 = new javax.swing.JLabel();
        btnReAero2 = new javax.swing.JLabel();
        btnReTra2 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel21 = new javax.swing.JLabel();
        btnEstadis2 = new javax.swing.JLabel();
        btnRegVue = new javax.swing.JLabel();
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(812, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addComponent(jLabel6)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 20, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))))
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 860, -1));

        jPanel6.setBackground(new java.awt.Color(102, 153, 255));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/usuario (1).png"))); // NOI18N

        jSeparator8.setForeground(new java.awt.Color(0, 0, 0));

        jSeparator9.setForeground(new java.awt.Color(0, 0, 0));

        btnBusCli2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBusCli2.setText("    Busqueda de Cliente");
        btnBusCli2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBusCli2MouseClicked(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscli (1).png"))); // NOI18N

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retra (1).png"))); // NOI18N

        btnReVue2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReVue2.setText("     Registro de Avión");
        btnReVue2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReVue2MouseClicked(evt);
            }
        });

        btnReAero2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReAero2.setText("   Registro de Aerolínea");
        btnReAero2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReAero2MouseClicked(evt);
            }
        });

        btnReTra2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnReTra2.setText("  Registro de Trabajador");
        btnReTra2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReTra2MouseClicked(evt);
            }
        });

        jSeparator10.setForeground(new java.awt.Color(0, 0, 0));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estadis (1).png"))); // NOI18N

        btnEstadis2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEstadis2.setText("            Estadísticas");
        btnEstadis2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEstadis2MouseClicked(evt);
            }
        });

        btnRegVue.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegVue.setText("  Registro de Vuelos");
        btnRegVue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegVueMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator9, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(btnBusCli2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jSeparator10)
            .addComponent(btnReVue2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReAero2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnReTra2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
            .addComponent(btnEstadis2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel11))
                .addGap(0, 67, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(65, 65, 65))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel20))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btnRegVue)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBusCli2)
                .addGap(17, 17, 17)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReVue2)
                .addGap(11, 11, 11)
                .addComponent(btnReAero2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReTra2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(btnRegVue, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEstadis2)
                .addGap(23, 23, 23))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 860, 420));

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

    private void btnBusCli2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusCli2MouseClicked
        frmBusCli frmBuCli=new frmBusCli();
        frmBuCli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBusCli2MouseClicked

    private void btnReVue2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReVue2MouseClicked
        frmRegAv frmReVue=new frmRegAv();
        frmReVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReVue2MouseClicked

    private void btnReAero2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReAero2MouseClicked
        frmRegAero frmReAero=new frmRegAero();
        frmReAero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReAero2MouseClicked

    private void btnReTra2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReTra2MouseClicked
        frmRegTrab frmReTrab=new frmRegTrab();
        frmReTrab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReTra2MouseClicked

    private void btnEstadis2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadis2MouseClicked
        frmEstadis frmEsta=new frmEstadis();
        frmEsta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEstadis2MouseClicked

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

                // Restablecer los campos y la imagen en el JLabel
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

                    // Limpiar los campos y la imagen seleccionada
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

    private void btnRegVueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegVueMouseClicked
        frmRegVue frmRegVue=new frmRegVue();
        frmRegVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegVueMouseClicked

    private void subirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subirFotoActionPerformed
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                imagenSeleccionadaBytes = convertirArchivoABytes(file);

                // Mostrar la imagen seleccionada en el JLabel
                ImageIcon imagenIcono = new ImageIcon(imagenSeleccionadaBytes);
                lblImagenSeleccionada.setIcon(imagenIcono);
            }

    }//GEN-LAST:event_subirFotoActionPerformed

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
    private javax.swing.JLabel btnEstadis2;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel btnReAero2;
    private javax.swing.JLabel btnReTra2;
    private javax.swing.JLabel btnReVue2;
    private javax.swing.JLabel btnRegVue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lblImagenSeleccionada;
    private javax.swing.JButton subirFoto;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtIDT;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtSalario;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
