
package Vista;

import Controlador.ControladorRegAv;
import Controlador.LoginControlador;
import static Controlador.LoginControlador.cerrarSesion;
import Modelo.Aerolinea;
import Modelo.Avion;
import Modelo.Trabajador;
import static Vista.Controladores.objAD;
import static Vista.Controladores.objAvD;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

public class frmRegAv extends javax.swing.JFrame {
        private ControladorRegAv controladorRegAv;
    private byte[] imagenUsuarioSes;
    public frmRegAv() {
        initComponents();
        controladorRegAv = new ControladorRegAv(this);
        JLayeredPane layeredPane = getLayeredPane();
        layeredPane.add(panelDetras, JLayeredPane.PALETTE_LAYER);
        panelDetras.setVisible(false);
        
        
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        List<String> nombresAerolineas = objAD.obtenerNombresAerolineas();
          for (String nombreAerolinea : nombresAerolineas) {
            cboAerol.addItem(nombreAerolinea);
        }
          
          
        //tablita
        tablaAvion.getTableHeader().setFont(new Font("Segou UI", Font.BOLD, 12));
        tablaAvion.getTableHeader().setOpaque(false);
        tablaAvion.getTableHeader().setBackground(new Color(12, 64, 160));
        tablaAvion.getTableHeader().setForeground(new Color(255,255,255));
        tablaAvion.setRowHeight(25);

    }
    

    

    


    @SuppressWarnings("unchecked")
    int x = 210;
    int a = 0;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new util.PanelRound();
        txtIDAvion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        cboAerol = new util.Cbox();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        txtCapacidad = new javax.swing.JTextField();
        panelRound2 = new util.PanelRound();
        panel1 = new util.panel();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblAvionPreferido = new javax.swing.JLabel();
        panel2 = new util.panel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblcapacPromAviones = new javax.swing.JLabel();
        panelRound3 = new util.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAvion = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        panelReTra = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        btnReTra = new javax.swing.JLabel();
        panelBusCli = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        btnBusCli = new javax.swing.JLabel();
        lblFotoSes2 = new javax.swing.JLabel();
        panelReAero = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        btnReAero = new javax.swing.JLabel();
        panelRegVue = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        btnRegVue = new javax.swing.JLabel();
        panelRegAvion = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        btnRegAvion = new javax.swing.JLabel();
        panelEstadisticas = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btnEstadisticas = new javax.swing.JLabel();
        panelDetras = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
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
        btnMinimizar = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        SliderDelMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(239, 231, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("ID Avion:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Aerolinea:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Modelo:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Capacidad de pasajeros:");

        cboAerol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboAerolActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");

        btnActualizar.setText("Actualizar");

        btnEliminar.setText("Eliminar");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel4))
                                .addGap(96, 96, 96)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboAerol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIDAvion, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel8)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnActualizar)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIDAvion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cboAerol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnActualizar)))
                .addGap(17, 17, 17)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCapacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 480, 190));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modelo de avión preferido:");
        panel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 6, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/frmAv/modeloAvion.png"))); // NOI18N
        panel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 6, -1, -1));

        lblAvionPreferido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAvionPreferido.setForeground(new java.awt.Color(255, 255, 255));
        lblAvionPreferido.setText("Datito1");
        panel1.add(lblAvionPreferido, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Capacidad Promedio de Avión:");
        panel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 6, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/frmAv/capacidadPasajeros.png"))); // NOI18N
        panel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 6, -1, -1));

        lblcapacPromAviones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblcapacPromAviones.setForeground(new java.awt.Color(255, 255, 255));
        lblcapacPromAviones.setText("Datito2");
        panel2.add(lblcapacPromAviones, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 28, -1, -1));

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 110, 280, 190));

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        tablaAvion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Avion", "ID Aerolinea", "Aerolinea", "Modelo", "Capacidad"
            }
        ));
        tablaAvion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaAvionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaAvion);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 780, 320));

        jPanel3.setBackground(new java.awt.Color(67, 90, 132));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelReTra.setBackground(new java.awt.Color(67, 90, 132));
        panelReTra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retra (1).png"))); // NOI18N
        panelReTra.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnReTra.setBackground(new java.awt.Color(67, 90, 132));
        btnReTra.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnReTra.setForeground(new java.awt.Color(255, 255, 255));
        btnReTra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReTra.setText("Registro de Trabajador");
        panelReTra.add(btnReTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelReTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 250, 50));

        panelBusCli.setBackground(new java.awt.Color(67, 90, 132));
        panelBusCli.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscli (1).png"))); // NOI18N
        panelBusCli.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnBusCli.setBackground(new java.awt.Color(255, 255, 255));
        btnBusCli.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnBusCli.setForeground(new java.awt.Color(255, 255, 255));
        btnBusCli.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBusCli.setText("Búsqueda de Cliente");
        panelBusCli.add(btnBusCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelBusCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 250, 50));

        lblFotoSes2.setText("jLabel15");
        jPanel3.add(lblFotoSes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 80, 90));

        panelReAero.setBackground(new java.awt.Color(67, 90, 132));
        panelReAero.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/viajE1.png"))); // NOI18N
        panelReAero.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnReAero.setBackground(new java.awt.Color(255, 255, 255));
        btnReAero.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnReAero.setForeground(new java.awt.Color(255, 255, 255));
        btnReAero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReAero.setText("Registro de Aerolínea");
        panelReAero.add(btnReAero, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelReAero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 250, 50));

        panelRegVue.setBackground(new java.awt.Color(67, 90, 132));
        panelRegVue.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario.png"))); // NOI18N
        panelRegVue.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnRegVue.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRegVue.setForeground(new java.awt.Color(255, 255, 255));
        btnRegVue.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegVue.setText("Registro de Vuelos");
        panelRegVue.add(btnRegVue, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelRegVue, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 250, -1));

        panelRegAvion.setBackground(new java.awt.Color(67, 90, 132));
        panelRegAvion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boletos-deavion.png"))); // NOI18N
        panelRegAvion.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnRegAvion.setBackground(new java.awt.Color(255, 255, 255));
        btnRegAvion.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnRegAvion.setForeground(new java.awt.Color(255, 255, 255));
        btnRegAvion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnRegAvion.setText("Registro de Avion");
        panelRegAvion.add(btnRegAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelRegAvion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 250, -1));

        panelEstadisticas.setBackground(new java.awt.Color(67, 90, 132));
        panelEstadisticas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/estadis (1).png"))); // NOI18N
        panelEstadisticas.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnEstadisticas.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEstadisticas.setForeground(new java.awt.Color(255, 255, 255));
        btnEstadisticas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEstadisticas.setText("Estadísticas");
        panelEstadisticas.add(btnEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 250, -1));

        panelDetras.setBackground(new java.awt.Color(69, 80, 135));
        panelDetras.setPreferredSize(new java.awt.Dimension(250, 660));
        panelDetras.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Nombre:");
        panelDetras.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 30));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Usuario:");
        panelDetras.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, 30));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Apellido:");
        panelDetras.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, 30));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Inicio de sesión:");
        panelDetras.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("ID Usuario:");
        panelDetras.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, 30));

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

        btnMinimizar.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        btnMinimizar.setText("-");
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCerrar.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        btnCerrar.setText("x");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("REGISTRO DE AVIÓN");

        SliderDelMenu.setBackground(new java.awt.Color(12, 64, 160));
        SliderDelMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        SliderDelMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menuGOD.png"))); // NOI18N
        SliderDelMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SliderDelMenu.setOpaque(true);

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
                        .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jLabel31)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnMinimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCerrar))
                        .addGap(1, 1, 1)
                        .addComponent(jLabel31)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(SliderDelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 840, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tablaAvionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaAvionMouseClicked

    }//GEN-LAST:event_tablaAvionMouseClicked

    
    private void cboAerolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboAerolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboAerolActionPerformed

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
            java.util.logging.Logger.getLogger(frmRegAv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmRegAv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmRegAv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmRegAv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmRegAv().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel SliderDelMenu;
    public javax.swing.JButton btnActualizar;
    public javax.swing.JLabel btnBusCli;
    public javax.swing.JLabel btnCerrar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JLabel btnEstadisticas;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JLabel btnMinimizar;
    public javax.swing.JLabel btnReAero;
    public javax.swing.JLabel btnReTra;
    public javax.swing.JLabel btnRegAvion;
    public javax.swing.JLabel btnRegVue;
    public util.Cbox cboAerol;
    public javax.swing.JLabel cerrarSesion;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblApeUsu;
    public javax.swing.JLabel lblAvionPreferido;
    public javax.swing.JLabel lblFotoSes;
    public javax.swing.JLabel lblFotoSes2;
    public javax.swing.JLabel lblIDUsu;
    public javax.swing.JLabel lblNombreSes;
    public javax.swing.JLabel lblTiempSes;
    public javax.swing.JLabel lblUsuarioSes;
    public javax.swing.JLabel lblUsuarioSes2;
    public javax.swing.JLabel lblcapacPromAviones;
    private util.panel panel1;
    private util.panel panel2;
    public javax.swing.JPanel panelBusCli;
    public javax.swing.JPanel panelDetras;
    public javax.swing.JPanel panelEstadisticas;
    public javax.swing.JPanel panelReAero;
    public javax.swing.JPanel panelReTra;
    public javax.swing.JPanel panelRegAvion;
    public javax.swing.JPanel panelRegVue;
    private util.PanelRound panelRound1;
    private util.PanelRound panelRound2;
    private util.PanelRound panelRound3;
    public javax.swing.JTable tablaAvion;
    public javax.swing.JTextField txtCapacidad;
    public javax.swing.JTextField txtIDAvion;
    public javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables
private void labelcolor(JLabel label){
        label.setBackground(new java.awt.Color(53,162,107));
    }
    
    private void resetlabelcolor(JLabel label){
        label.setBackground(new java.awt.Color(54,70,78));
    }
}
