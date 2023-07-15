
package Vista;

import Modelo.Trabajador;
import Modelo.Vuelo;
import static Vista.Controladores.objTR;
import static Vista.Controladores.objVD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane; //para poner un panel detras
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


public class frmCompraBole extends javax.swing.JFrame {
        
    private byte[] imagenUsuarioSes;
    
    public frmCompraBole() {
        initComponents();
        
        JLayeredPane layeredPane = getLayeredPane();
        layeredPane.add(panelDetras, JLayeredPane.PALETTE_LAYER);
        panelDetras.setVisible(false);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        
        
        listadoVuelosInicial();

        tablaVueloBoleto.getTableHeader().setFont(new Font("Segou UI", Font.BOLD, 12));
        tablaVueloBoleto.getTableHeader().setOpaque(false);
        tablaVueloBoleto.getTableHeader().setBackground(new Color(12, 64, 160));
        tablaVueloBoleto.getTableHeader().setForeground(new Color(255,255,255));
        tablaVueloBoleto.setRowHeight(25);
        
        List<String> origenes = objVD.obtenerOrigenes();
        List<String> duraciones = objVD.obtenerDuraciones();
        List<String> destinos = objVD.obtenerDestino();
  
        // Añadir los orígenes al JComboBox
        cboOrigen.addItem("Cualquiera");
        cboDuracion.addItem("Cualquiera");
        cboDestino.addItem("Cualquiera");
        
        for (String origen : origenes) {
            cboOrigen.addItem(origen);
        }
        for (String duracion : duraciones) {
            cboDuracion.addItem(duracion);
        }
        for (String destino : destinos) {
            cboDestino.addItem(destino);
        }
    }
    
    void obtenerUsuarioSes(int ID){ //PARA SEGUIRLA XD (PROVISIONAL)
        lblIDUsu.setText(""+ID);
        Trabajador trabajador = objTR.buscarTrabajador(ID);
   
         if (trabajador != null) {
        //para parte no visible
        lblUsuarioSes.setText(trabajador.getUsuario());
        lblNombreSes.setText(trabajador.getNombre());
        lblApeUsu.setText(trabajador.getApellido());
        imagenUsuarioSes = trabajador.getFoto();
        ImageIcon IconoSelec = new ImageIcon(imagenUsuarioSes);
        lblFotoSes.setIcon(IconoSelec);
        
        //parte visible
        lblFotoSes2.setIcon(IconoSelec);
        lblUsuarioSes2.setText(trabajador.getUsuario());
        } else {
             System.out.println("Se supone que esto no debe pasar XD");
        }
         
        LocalTime horaActual = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaDeInicio = horaActual.format(formatter);
        lblTiempSes.setText(""+horaDeInicio);
 
    }
   
    void listadoVuelosInicial(){
        DefaultTableModel dt=(DefaultTableModel)tablaVueloBoleto.getModel();

        dt.setRowCount(0);
        for(Vuelo x:objVD.obtenerListaVuelos()){
            Object v[]={x.getIdVuelo(), x.getOrigen(),x.getDestino(), x.getDuracion(),x.getTipo(),x.getNombreAerolinea(), x.getPrecio()};
            dt.addRow(v);
        }
    }
    
    private void filtrarTabla() {
        DefaultTableModel dt = (DefaultTableModel) tablaVueloBoleto.getModel();
        String origenSeleccionado = (String) cboOrigen.getSelectedItem();
        String destinoSeleccionado = (String) cboDestino.getSelectedItem();
        String duracionSeleccionada = (String) cboDuracion.getSelectedItem();
   
        int precioElegido = slifer.getValue();

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
 
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SliderDelMenu = new javax.swing.JLabel();
        panelRound1 = new util.PanelRound();
        cboDestino = new util.Cbox();
        cboOrigen = new util.Cbox();
        jLabel9 = new javax.swing.JLabel();
        cboDuracion = new util.Cbox();
        btnBuscar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        slifer = new javax.swing.JSlider();
        sliderText = new javax.swing.JLabel();
        panelRound2 = new util.PanelRound();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVueloBoleto = new javax.swing.JTable();
        btnReservar = new javax.swing.JButton();
        panelRound3 = new util.PanelRound();
        panel1 = new util.panel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panel2 = new util.panel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        panelReTra = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnReTra = new javax.swing.JLabel();
        panelBusCli = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
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
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblTiempSes = new javax.swing.JLabel();
        lblUsuarioSes = new javax.swing.JLabel();
        lblNombreSes = new javax.swing.JLabel();
        lblApeUsu = new javax.swing.JLabel();
        lblIDUsu = new javax.swing.JLabel();
        lblFotoSes = new javax.swing.JLabel();
        lblUsuarioSes2 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(239, 231, 231));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel1.setText("COMPRA DE BOLETOS");

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

        cboOrigen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboOrigenActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Duración:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Destino:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Origen:");

        slifer.setMaximum(1000);
        slifer.setMinimum(200);
        slifer.setValue(1000);
        slifer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliferStateChanged(evt);
            }
        });

        sliderText.setText("Filtrar por Precio");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(25, 25, 25)
                        .addComponent(cboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRound1Layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addGap(112, 112, 112)
                                        .addComponent(sliderText))
                                    .addGroup(panelRound1Layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(slifer, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(30, 30, 30))))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboDestino, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btnBuscar))
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(slifer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sliderText)))
                .addGap(24, 24, 24))
        );

        jPanel1.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 480, 150));

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        tablaVueloBoleto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID_Vuelo", "Origen", "Destino", "Duración", "Tipo", "Aerolínea", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tablaVueloBoleto);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 800, 310));

        btnReservar.setText("Reservar");
        btnReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarActionPerformed(evt);
            }
        });
        jPanel1.add(btnReservar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 620, 100, -1));

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(20);
        panelRound3.setRoundBottomRight(20);
        panelRound3.setRoundTopLeft(20);
        panelRound3.setRoundTopRight(20);

        panel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Destino más popular:");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/frmBole/viajecito.png"))); // NOI18N

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8)
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tendencia promedio de precios:");

        jLabel7.setText("alrededor de: 50");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/frmBole/incrementar.png"))); // NOI18N

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel1.add(panelRound3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 300, 150));

        jPanel3.setBackground(new java.awt.Color(67, 90, 132));
        jPanel3.setPreferredSize(new java.awt.Dimension(250, 660));
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

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscli (1).png"))); // NOI18N
        panelBusCli.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 50, 50));

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

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Nombre:");
        panelDetras.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 30));

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
        panelDetras.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, -1, -1));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("ID Usuario:");
        panelDetras.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, 30));

        lblTiempSes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTiempSes.setForeground(new java.awt.Color(204, 255, 204));
        lblTiempSes.setText("TIME");
        panelDetras.add(lblTiempSes, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 600, 70, 20));

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

        jPanel3.add(panelDetras, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 730));

        lblUsuarioSes2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUsuarioSes2.setForeground(new java.awt.Color(204, 255, 204));
        lblUsuarioSes2.setText("USER");
        lblUsuarioSes2.setMaximumSize(new java.awt.Dimension(55, 20));
        lblUsuarioSes2.setMinimumSize(new java.awt.Dimension(55, 20));
        lblUsuarioSes2.setPreferredSize(new java.awt.Dimension(55, 20));
        jPanel3.add(lblUsuarioSes2, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 160, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Usuario:");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 160, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 680));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 660));

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

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarActionPerformed

        int selectedRow = tablaVueloBoleto.getSelectedRow();
        if (selectedRow != -1) {
            int idVuelo = Integer.parseInt(tablaVueloBoleto.getValueAt(selectedRow, 0).toString());
            frmReserva frmReser = new frmReserva();
            frmReser.cargarPasajeros(idVuelo);
            frmReser.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un vuelo para realizar la reserva", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReservarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        filtrarTabla();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void cboOrigenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOrigenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboOrigenActionPerformed

    private void sliferStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliferStateChanged
        
        if (slifer.getValue() < 1000) {
            sliderText.setText("Menor o igual a: " + slifer.getValue());
        } else{
            sliderText.setText("Cualquier Precio");
        }
    }//GEN-LAST:event_sliferStateChanged

    private void btnReTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReTraMouseClicked
        frmRegTrab frmReTrab=new frmRegTrab();
        frmReTrab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReTraMouseClicked

    private void btnBusCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBusCliMouseClicked
        frmBusCli frmBuCli=new frmBusCli();
        frmBuCli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBusCliMouseClicked

    private void btnReAeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReAeroMouseClicked
        frmRegAero frmReAero=new frmRegAero();
        frmReAero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnReAeroMouseClicked

    private void btnEstadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadisticasMouseClicked
        frmEstadis frmEsta=new frmEstadis();
        frmEsta.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnEstadisticasMouseClicked

    private void btnRegAvionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegAvionMouseClicked
        frmRegAv frmReVue=new frmRegAv();
        frmReVue.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnRegAvionMouseClicked

    private void btnRegVueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegVueMouseClicked
        frmRegVue frmRegVue=new frmRegVue();
        frmRegVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegVueMouseClicked


    @SuppressWarnings("unchecked")


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
    
    //colores panel/jlabel"botones" xd
    private java.awt.Color ColorEnteredBoton = new java.awt.Color(55, 231, 173);
    private java.awt.Color ColorOriginalPanel = new java.awt.Color(67,90,132);
    private java.awt.Color ColorEnteredPanel = new java.awt.Color(110, 153, 139);
    
    private void cambiarColores(Component component, Color color) {
    component.setForeground(color);
    }
    
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

    private void btnReTraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReTraMouseEntered
        maus = true;
        cambiarColores(btnReTra,panelReTra);
    }//GEN-LAST:event_btnReTraMouseEntered

    private void btnReTraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReTraMouseExited
        maus = false;
        cambiarColores(btnReTra,panelReTra);
    }//GEN-LAST:event_btnReTraMouseExited

    private void btnReAeroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReAeroMouseEntered
        maus = true;
        cambiarColores(btnReAero,panelReAero);
    }//GEN-LAST:event_btnReAeroMouseEntered

    private void btnReAeroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReAeroMouseExited
        maus = false;
        cambiarColores(btnReAero,panelReAero);
    }//GEN-LAST:event_btnReAeroMouseExited

    private void btnRegVueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegVueMouseEntered
        maus = true;
        cambiarColores(btnRegVue,panelRegVue);
    }//GEN-LAST:event_btnRegVueMouseEntered

    private void btnRegVueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegVueMouseExited
        maus = false;
        cambiarColores(btnRegVue,panelRegVue);
    }//GEN-LAST:event_btnRegVueMouseExited

    private void btnRegAvionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegAvionMouseEntered
        maus = true;
        cambiarColores(btnRegAvion,panelRegAvion);
    }//GEN-LAST:event_btnRegAvionMouseEntered

    private void btnRegAvionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegAvionMouseExited
        maus = false;
        cambiarColores(btnRegAvion,panelRegAvion);
    }//GEN-LAST:event_btnRegAvionMouseExited

    private void btnEstadisticasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadisticasMouseEntered
        maus = true;
        cambiarColores(btnEstadisticas,panelEstadisticas);
    }//GEN-LAST:event_btnEstadisticasMouseEntered

    private void btnEstadisticasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstadisticasMouseExited
        maus = false;
        cambiarColores(btnEstadisticas,panelEstadisticas);
    }//GEN-LAST:event_btnEstadisticasMouseExited
//paneles
    private void panelBusCliMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBusCliMouseExited
        maus = false;
        cambiarColores(btnBusCli,panelBusCli);
    }//GEN-LAST:event_panelBusCliMouseExited

    private void panelBusCliMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBusCliMouseEntered
        maus = true;
        cambiarColores(btnBusCli, panelBusCli);
    }//GEN-LAST:event_panelBusCliMouseEntered

    private void panelReTraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReTraMouseExited
        maus = false;
        cambiarColores(btnReTra, panelReTra);
    }//GEN-LAST:event_panelReTraMouseExited

    private void panelReTraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReTraMouseEntered
        maus = true;
        cambiarColores(btnReTra, panelReTra);
    }//GEN-LAST:event_panelReTraMouseEntered

    private void panelReAeroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReAeroMouseExited
        maus = false;
        cambiarColores(btnReAero, panelReAero);
    }//GEN-LAST:event_panelReAeroMouseExited

    private void panelReAeroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReAeroMouseEntered
        maus = true;
        cambiarColores(btnReAero, panelReAero);
    }//GEN-LAST:event_panelReAeroMouseEntered

    private void panelRegVueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegVueMouseExited
        maus = false;
        cambiarColores(btnRegVue, panelRegVue);
    }//GEN-LAST:event_panelRegVueMouseExited

    private void panelRegVueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegVueMouseEntered
        maus = true;
        cambiarColores(btnRegVue, panelRegVue);
    }//GEN-LAST:event_panelRegVueMouseEntered

    private void panelRegAvionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegAvionMouseExited
        maus = false;
        cambiarColores(btnRegAvion, panelRegAvion);
    }//GEN-LAST:event_panelRegAvionMouseExited

    private void panelRegAvionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegAvionMouseEntered
        maus = true;
        cambiarColores(btnRegAvion, panelRegAvion);
    }//GEN-LAST:event_panelRegAvionMouseEntered

    private void panelEstadisticasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEstadisticasMouseExited
        maus = false;
        cambiarColores(btnEstadisticas, panelEstadisticas);
    }//GEN-LAST:event_panelEstadisticasMouseExited

    private void panelEstadisticasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEstadisticasMouseEntered
        maus = true;
        cambiarColores(btnEstadisticas, panelEstadisticas);
    }//GEN-LAST:event_panelEstadisticasMouseEntered

    private void panelBusCliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBusCliMouseClicked
        frmBusCli frmBuCli=new frmBusCli();
        frmBuCli.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelBusCliMouseClicked

    private void panelReTraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReTraMouseClicked
        frmRegTrab frmRegTrab=new frmRegTrab();
        frmRegTrab.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelReTraMouseClicked

    private void panelReAeroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelReAeroMouseClicked
        frmRegAero frmRegAero=new frmRegAero();
        frmRegAero.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelReAeroMouseClicked

    private void panelRegVueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegVueMouseClicked
        frmRegVue frmRegVue=new frmRegVue();
        frmRegVue.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelRegVueMouseClicked

    private void panelRegAvionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegAvionMouseClicked
        frmRegAv frmRegAv=new frmRegAv();
        frmRegAv.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelRegAvionMouseClicked

    private void panelEstadisticasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEstadisticasMouseClicked
        frmEstadis frmEstadis=new frmEstadis();
        frmEstadis.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_panelEstadisticasMouseClicked
    

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
            java.util.logging.Logger.getLogger(frmCompraBole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCompraBole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCompraBole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCompraBole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create alblImalblFotoSesgenSesnd display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCompraBole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SliderDelMenu;
    private javax.swing.JLabel btnBusCli;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel btnEstadisticas;
    private javax.swing.JLabel btnReAero;
    private javax.swing.JLabel btnReTra;
    private javax.swing.JLabel btnRegAvion;
    private javax.swing.JLabel btnRegVue;
    private javax.swing.JButton btnReservar;
    private util.Cbox cboDestino;
    private util.Cbox cboDuracion;
    private util.Cbox cboOrigen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApeUsu;
    private javax.swing.JLabel lblFotoSes;
    private javax.swing.JLabel lblFotoSes2;
    private javax.swing.JLabel lblIDUsu;
    private javax.swing.JLabel lblNombreSes;
    private javax.swing.JLabel lblTiempSes;
    private javax.swing.JLabel lblUsuarioSes;
    private javax.swing.JLabel lblUsuarioSes2;
    private util.panel panel1;
    private util.panel panel2;
    private javax.swing.JPanel panelBusCli;
    private javax.swing.JPanel panelDetras;
    private javax.swing.JPanel panelEstadisticas;
    private javax.swing.JPanel panelReAero;
    private javax.swing.JPanel panelReTra;
    private javax.swing.JPanel panelRegAvion;
    private javax.swing.JPanel panelRegVue;
    private util.PanelRound panelRound1;
    private util.PanelRound panelRound2;
    private util.PanelRound panelRound3;
    private javax.swing.JLabel sliderText;
    private javax.swing.JSlider slifer;
    private javax.swing.JTable tablaVueloBoleto;
    // End of variables declaration//GEN-END:variables
private void labelcolor(JLabel label){
        label.setBackground(new java.awt.Color(53,162,107));
    }
    
    private void resetlabelcolor(JLabel label){
        label.setBackground(new java.awt.Color(54,70,78));
    }
}
