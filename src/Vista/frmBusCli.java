
package Vista;

import Controlador.ControladorBusCli;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLayeredPane; //para poner un panel detras


public class frmBusCli extends javax.swing.JFrame {
    
    private ControladorBusCli controladorBusCli;
    private byte[] imagenUsuarioSes;
    
    public frmBusCli() {
        initComponents();
        controladorBusCli = new ControladorBusCli(this);

        JLayeredPane layeredPane = getLayeredPane();
        layeredPane.add(panelDetras, JLayeredPane.PALETTE_LAYER);
        panelDetras.setVisible(false);

        //tablita
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        TablaBuscCliente.getTableHeader().setFont(new Font("Segou UI", Font.BOLD, 12));
        TablaBuscCliente.getTableHeader().setOpaque(false);
        TablaBuscCliente.getTableHeader().setBackground(new Color(12, 64, 160));
        TablaBuscCliente.getTableHeader().setForeground(new Color(255,255,255));
        TablaBuscCliente.setRowHeight(25);   
    }

    @SuppressWarnings("unchecked")

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
        jLabel19 = new javax.swing.JLabel();
        btnEstadisticas = new javax.swing.JLabel();
        panelDetras = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lblTiempSes = new javax.swing.JLabel();
        lblUsuarioSes = new javax.swing.JLabel();
        lblNombreSes = new javax.swing.JLabel();
        lblApeUsu = new javax.swing.JLabel();
        lblIDUsu = new javax.swing.JLabel();
        lblFotoSes = new javax.swing.JLabel();
        cerrarSesion = new javax.swing.JLabel();
        lblUsuarioSes2 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SliderDelMenu = new javax.swing.JLabel();
        panelRound1 = new util.PanelRound();
        txtDNIbusc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnBuscarCli = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        dateInicial = new com.toedter.calendar.JDateChooser();
        dateFinal = new com.toedter.calendar.JDateChooser();
        txtNombreBusc = new javax.swing.JTextField();
        txtApeBusc = new javax.swing.JTextField();
        txtOrigenBusc = new javax.swing.JTextField();
        txtDestinoBusc = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        panelRound3 = new util.PanelRound();
        panel4 = new util.panel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblClientesReserva = new javax.swing.JLabel();
        panel1 = new util.panel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTotalClientes = new javax.swing.JLabel();
        panelRound4 = new util.PanelRound();
        btnCancelarRes = new javax.swing.JButton();
        btnRegistrarCli = new javax.swing.JButton();
        btnCompraBoleta = new javax.swing.JButton();
        btnEliminarReserva = new javax.swing.JButton();
        panelRound5 = new util.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaBuscCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(239, 231, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(67, 90, 132));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelReTra.setBackground(new java.awt.Color(67, 90, 132));
        panelReTra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/retra (1).png"))); // NOI18N
        panelReTra.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

        btnReTra.setBackground(new java.awt.Color(67, 90, 132));
        btnReTra.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnReTra.setForeground(new java.awt.Color(255, 255, 255));
        btnReTra.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReTra.setText("Registro de Trabajador");
        panelReTra.add(btnReTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 150, 30));

        jPanel3.add(panelReTra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 250, 50));

        panelBusCli.setBackground(new java.awt.Color(67, 90, 132));
        panelBusCli.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscli (1).png"))); // NOI18N
        panelBusCli.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

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

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/viajE1.png"))); // NOI18N
        panelReAero.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

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

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("ID Usuario:");
        panelDetras.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, 30));

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

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Usuario:");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 160, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 660));

        jPanel2.setBackground(new java.awt.Color(12, 64, 160));

        btnMinimizar.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 36)); // NOI18N
        btnMinimizar.setText("-");
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnCerrar.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 24)); // NOI18N
        btnCerrar.setText("x");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BÚSQUEDA CLIENTES CON RESERVA");

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
                        .addComponent(jLabel1)
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
        panelRound1.add(txtDNIbusc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 170, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("DNI:");
        panelRound1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 20));

        btnBuscarCli.setText("Buscar");
        panelRound1.add(btnBuscarCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 80, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Nombre:");
        panelRound1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Apellido:");
        panelRound1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Origen:");
        panelRound1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Fecha Reserva");
        panelRound1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, 20));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Destino:");
        panelRound1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 20));

        dateInicial.setDateFormatString("yyyy-MM-dd");
        panelRound1.add(dateInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, -1, -1));

        dateFinal.setDateFormatString("yyyy-MM-dd");
        panelRound1.add(dateFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 60, -1, -1));
        panelRound1.add(txtNombreBusc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 170, -1));
        panelRound1.add(txtApeBusc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 170, -1));
        panelRound1.add(txtOrigenBusc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 170, -1));
        panelRound1.add(txtDestinoBusc, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 170, -1));

        btnLimpiar.setText("Limpiar");
        panelRound1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 80, -1));

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 570, 190));

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        panel4.setBackground(new java.awt.Color(255, 255, 255));
        panel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Clientes con Reserva");
        panel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 6, -1, -1));

        jLabel7.setText("alrededor de: 50");
        panel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 52, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/frmBuscCli/clientesReservados.png"))); // NOI18N
        panel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        lblClientesReserva.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblClientesReserva.setForeground(new java.awt.Color(255, 255, 255));
        lblClientesReserva.setText("Datito");
        panel4.add(lblClientesReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Total de Clientes");
        panel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/frmBuscCli/clientes.png"))); // NOI18N
        panel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 6, -1, -1));

        lblTotalClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalClientes.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalClientes.setText("Datito2");
        panel1.add(lblTotalClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(panel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 100, 210, 190));

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);
        panelRound4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelarRes.setText("Cancelar Reserva");
        panelRound4.add(btnCancelarRes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 134, 20));

        btnRegistrarCli.setText("Registrar Cliente");
        panelRound4.add(btnRegistrarCli, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 250, 134, -1));

        btnCompraBoleta.setText("Comprar Boletos");
        panelRound4.add(btnCompraBoleta, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 35, 134, -1));

        btnEliminarReserva.setText("Eliminar Reserva");
        panelRound4.add(btnEliminarReserva, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 130, -1));

        jPanel1.add(panelRound4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 310, 160, 320));

        panelRound5.setBackground(new java.awt.Color(255, 255, 255));
        panelRound5.setRoundBottomLeft(20);
        panelRound5.setRoundBottomRight(20);
        panelRound5.setRoundTopLeft(20);
        panelRound5.setRoundTopRight(20);

        TablaBuscCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombre", "Apellido", "Origen", "Destino", "Aerolínea", "Fecha Reserva", "ID Reserva", "Estado Reserva"
            }
        ));
        jScrollPane1.setViewportView(TablaBuscCliente);

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 620, 320));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 660));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmBusCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmBusCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmBusCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmBusCli.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmBusCli().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel SliderDelMenu;
    public javax.swing.JTable TablaBuscCliente;
    public javax.swing.JLabel btnBusCli;
    public javax.swing.JButton btnBuscarCli;
    public javax.swing.JButton btnCancelarRes;
    public javax.swing.JLabel btnCerrar;
    public javax.swing.JButton btnCompraBoleta;
    public javax.swing.JButton btnEliminarReserva;
    public javax.swing.JLabel btnEstadisticas;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JLabel btnMinimizar;
    public javax.swing.JLabel btnReAero;
    public javax.swing.JLabel btnReTra;
    public javax.swing.JLabel btnRegAvion;
    public javax.swing.JLabel btnRegVue;
    public javax.swing.JButton btnRegistrarCli;
    public javax.swing.JLabel cerrarSesion;
    public com.toedter.calendar.JDateChooser dateFinal;
    public com.toedter.calendar.JDateChooser dateInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblApeUsu;
    public javax.swing.JLabel lblClientesReserva;
    public javax.swing.JLabel lblFotoSes;
    public javax.swing.JLabel lblFotoSes2;
    public javax.swing.JLabel lblIDUsu;
    public javax.swing.JLabel lblNombreSes;
    public javax.swing.JLabel lblTiempSes;
    public javax.swing.JLabel lblTotalClientes;
    public javax.swing.JLabel lblUsuarioSes;
    public javax.swing.JLabel lblUsuarioSes2;
    private util.panel panel1;
    private util.panel panel4;
    public javax.swing.JPanel panelBusCli;
    public javax.swing.JPanel panelDetras;
    public javax.swing.JPanel panelEstadisticas;
    public javax.swing.JPanel panelReAero;
    public javax.swing.JPanel panelReTra;
    public javax.swing.JPanel panelRegAvion;
    public javax.swing.JPanel panelRegVue;
    private util.PanelRound panelRound1;
    private util.PanelRound panelRound3;
    private util.PanelRound panelRound4;
    private util.PanelRound panelRound5;
    public javax.swing.JTextField txtApeBusc;
    public javax.swing.JTextField txtDNIbusc;
    public javax.swing.JTextField txtDestinoBusc;
    public javax.swing.JTextField txtNombreBusc;
    public javax.swing.JTextField txtOrigenBusc;
    // End of variables declaration//GEN-END:variables

   
}
