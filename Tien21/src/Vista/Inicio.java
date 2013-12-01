
package Vista;

import Controlador.BotonesAlmacen;
import Controlador.BotonesInicio;
import Modelo.ProductoDB;
import Modelo.UsuarioDB;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Inicio extends javax.swing.JFrame {
    private ArrayList listProductosAlmacen;
    
    public Inicio() {
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());//Para Maximizar la ventana
        this.jPanelMenu.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jPanelVista.setBorder(BorderFactory.createLineBorder(Color.black));
        this.jPanelVista.setOpaque(false);
        jPanelPedido.setOpaque(false);
        inicializarMenuBar();//Inicializamos la barra de menu
        llamarLogin();
        ocultarPaneles();// metodo para ocultar los paneles que no se deben ver al inicializar la aplicacion
        inicializarActionCommand();//metodo para añadir el ActionComand a los botones del menu y reconocer la llamada de cada boton en los listeners del controlador

        this.inicio.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));//Se inicializan los listeners de los botones del menu
        this.ventas.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.pedidos.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.almacen.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.ofertas.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.estadistica.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        
        this.botonActualizarAlmacen.addActionListener(new BotonesAlmacen(tablaAlmacen));
        this.botonAnadirAlmacen.addActionListener(new BotonesAlmacen());
        this.botonBuscarAlmacen.addActionListener(new BotonesAlmacen());
        
        
        ModeloTablaProductos modeloAlmacen=new ModeloTablaProductos(new ProductoDB().mostrarAlmacen());
        this.tablaAlmacen.setModel(modeloAlmacen);
        
        ModeloTablaPedidos modeloPedido=new ModeloTablaPedidos(new ArrayList());
        this.tablaPedido.setModel(modeloPedido);
        
        ModeloTablaPedidos modeloModificarPedido=new ModeloTablaPedidos(new ArrayList());
        this.tablaModificarPedido.setModel(modeloModificarPedido);
        
        ModeloTablaEliminarPedido modeloEliminarPedido=new ModeloTablaEliminarPedido(new ArrayList());
        this.tablaEliminarPedido.setModel(modeloEliminarPedido);
        
        ModeloTablaVenta modeloVenta = new ModeloTablaVenta(new ArrayList ());
        this.tablaVenta.setModel(modeloVenta);
    }
    
    public void inicializarMenuBar(){
        JMenuItem minimizar=new JMenuItem("Minimizar");
        JMenuItem cerrar=new JMenuItem("Cerrar");
        this.jMenu1.add(minimizar);
        this.jMenu1.add(cerrar);
        cerrar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        minimizar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Inicio.this.setState( JFrame.ICONIFIED );
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelfondo = new javax.swing.JPanel(){
            @Override
            public void paint(Graphics g){
                ImageIcon im = new ImageIcon(getClass().getResource("/Recursos/fondo.png"));
                System.out.println(im);
                g.drawImage(im.getImage(), 0, 0, getWidth(), getHeight(), this);
                this.setOpaque(false);
                super.paint(g);

            }
        };
        jPanelMenu = new javax.swing.JPanel();
        inicio = new javax.swing.JButton();
        ventas = new javax.swing.JButton();
        pedidos = new javax.swing.JButton();
        almacen = new javax.swing.JButton();
        ofertas = new javax.swing.JButton();
        estadistica = new javax.swing.JButton();
        jPanelVista = new javax.swing.JPanel();
        jPanelVenta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanelVentaVentas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaVenta = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanelPedido = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanelNuevoPedido = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPedido = new javax.swing.JTable();
        botonAnadirElementoPedido = new javax.swing.JButton();
        botonBorrarElementoPedido = new javax.swing.JButton();
        botonRealizarPedido = new javax.swing.JButton();
        jPanelModificarPedido = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaModificarPedido = new javax.swing.JTable();
        comboPedidoModificacion = new javax.swing.JComboBox();
        botonGuardarModificacion = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanelMostrar = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaEliminarPedido = new javax.swing.JTable();
        botonEliminarPedido = new javax.swing.JButton();
        botonLlamarModificacion = new javax.swing.JButton();
        jPanelAlmacen = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlmacen = new javax.swing.JTable();
        botonBuscarAlmacen = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        botonAnadirAlmacen = new javax.swing.JButton();
        botonActualizarAlmacen = new javax.swing.JButton();
        jPanelOferta = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelEstadistica = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanelInicio = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage((new ImageIcon("Desert.jpg").getImage()));
        setUndecorated(true);

        jPanelfondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelfondo.setOpaque(false);

        jPanelMenu.setBackground(new java.awt.Color(0, 32, 71));

        inicio.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/InicioA.png"))); // NOI18N
        inicio.setBorder(null);
        inicio.setBorderPainted(false);
        inicio.setContentAreaFilled(false);
        inicio.setPreferredSize(new java.awt.Dimension(50, 20));
        inicio.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/InicioB.png"))); // NOI18N
        inicio.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/InicioC.png"))); // NOI18N

        ventas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ventasA.png"))); // NOI18N
        ventas.setBorderPainted(false);
        ventas.setContentAreaFilled(false);
        ventas.setPreferredSize(new java.awt.Dimension(50, 20));
        ventas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/VentasB.png"))); // NOI18N
        ventas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/VentasC.png"))); // NOI18N
        ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventasActionPerformed(evt);
            }
        });

        pedidos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/PedidoA.png"))); // NOI18N
        pedidos.setBorderPainted(false);
        pedidos.setContentAreaFilled(false);
        pedidos.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/pedidoinactivo.png"))); // NOI18N
        pedidos.setPreferredSize(new java.awt.Dimension(50, 20));
        pedidos.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/PedidoB.png"))); // NOI18N
        pedidos.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/PedidoC.png"))); // NOI18N
        pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosActionPerformed(evt);
            }
        });

        almacen.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        almacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/AlmacenA.png"))); // NOI18N
        almacen.setBorderPainted(false);
        almacen.setContentAreaFilled(false);
        almacen.setPreferredSize(new java.awt.Dimension(50, 20));
        almacen.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/AlmacenB.png"))); // NOI18N
        almacen.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/AlmacenC.png"))); // NOI18N

        ofertas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ofertas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/OfertasA.png"))); // NOI18N
        ofertas.setBorderPainted(false);
        ofertas.setContentAreaFilled(false);
        ofertas.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ofertasinactivo.png"))); // NOI18N
        ofertas.setPreferredSize(new java.awt.Dimension(50, 20));
        ofertas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/OfertasB.png"))); // NOI18N
        ofertas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/OfertasC.png"))); // NOI18N

        estadistica.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        estadistica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/EstadisticasA.png"))); // NOI18N
        estadistica.setBorderPainted(false);
        estadistica.setContentAreaFilled(false);
        estadistica.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/estadisticainactivo.png"))); // NOI18N
        estadistica.setPreferredSize(new java.awt.Dimension(50, 20));
        estadistica.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/EstadisticasB.png"))); // NOI18N
        estadistica.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/EstadisticasC.png"))); // NOI18N

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ofertas, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(ofertas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(estadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        inicio.getAccessibleContext().setAccessibleDescription("");

        jPanelVenta.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 255, 153));
        jLabel1.setText("VENTAS");

        jTabbedPane1.setToolTipText("");

        tablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tablaVenta);

        jButton1.setText("Añadir");

        jButton2.setText("Borrar");

        jLabel7.setText("Precio total");

        jLabel8.setText("Pago");

        jLabel9.setText("Devolución");

        jLabel10.setText("jLabel10");

        jLabel11.setText("jLabel11");

        javax.swing.GroupLayout jPanelVentaVentasLayout = new javax.swing.GroupLayout(jPanelVentaVentas);
        jPanelVentaVentas.setLayout(jPanelVentaVentasLayout);
        jPanelVentaVentasLayout.setHorizontalGroup(
            jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(60, 60, 60)
                        .addComponent(jButton2))
                    .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(306, Short.MAX_VALUE))
        );
        jPanelVentaVentasLayout.setVerticalGroup(
            jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                        .addGroup(jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10))
                        .addGap(32, 32, 32)
                        .addGroup(jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(34, 34, 34)
                        .addGroup(jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Realizar venta", jPanelVentaVentas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1023, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Devoluciones", jPanel1);

        javax.swing.GroupLayout jPanelVentaLayout = new javax.swing.GroupLayout(jPanelVenta);
        jPanelVenta.setLayout(jPanelVentaLayout);
        jPanelVentaLayout.setHorizontalGroup(
            jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(jPanelVentaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelVentaLayout.setVerticalGroup(
            jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("");

        jPanelPedido.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 102));
        jLabel2.setText("PEDIDOS");

        tablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tablaPedido);

        botonAnadirElementoPedido.setText("Añadir");
        botonAnadirElementoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirElementoPedidoActionPerformed(evt);
            }
        });

        botonBorrarElementoPedido.setText("Borrar");

        botonRealizarPedido.setText("Realizar Pedido");

        javax.swing.GroupLayout jPanelNuevoPedidoLayout = new javax.swing.GroupLayout(jPanelNuevoPedido);
        jPanelNuevoPedido.setLayout(jPanelNuevoPedidoLayout);
        jPanelNuevoPedidoLayout.setHorizontalGroup(
            jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addGroup(jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botonAnadirElementoPedido)
                        .addComponent(botonBorrarElementoPedido))
                    .addComponent(botonRealizarPedido))
                .addContainerGap(286, Short.MAX_VALUE))
        );
        jPanelNuevoPedidoLayout.setVerticalGroup(
            jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelNuevoPedidoLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(botonAnadirElementoPedido)
                .addGap(35, 35, 35)
                .addComponent(botonBorrarElementoPedido)
                .addGap(31, 31, 31)
                .addComponent(botonRealizarPedido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Nuevo", jPanelNuevoPedido);

        tablaModificarPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(tablaModificarPedido);

        comboPedidoModificacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        botonGuardarModificacion.setText("Guardar Modificación");

        jLabel12.setText("Pedido:");

        javax.swing.GroupLayout jPanelModificarPedidoLayout = new javax.swing.GroupLayout(jPanelModificarPedido);
        jPanelModificarPedido.setLayout(jPanelModificarPedidoLayout);
        jPanelModificarPedidoLayout.setHorizontalGroup(
            jPanelModificarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelModificarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelModificarPedidoLayout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addGroup(jPanelModificarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboPedidoModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)))
                    .addGroup(jPanelModificarPedidoLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(botonGuardarModificacion)))
                .addContainerGap(207, Short.MAX_VALUE))
        );
        jPanelModificarPedidoLayout.setVerticalGroup(
            jPanelModificarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelModificarPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelModificarPedidoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(comboPedidoModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(botonGuardarModificacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Modificar", jPanelModificarPedido);

        tablaEliminarPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(tablaEliminarPedido);

        botonEliminarPedido.setText("Eliminar");

        botonLlamarModificacion.setText("Modificar");

        javax.swing.GroupLayout jPanelMostrarLayout = new javax.swing.GroupLayout(jPanelMostrar);
        jPanelMostrar.setLayout(jPanelMostrarLayout);
        jPanelMostrarLayout.setHorizontalGroup(
            jPanelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addGroup(jPanelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonEliminarPedido)
                    .addComponent(botonLlamarModificacion))
                .addGap(70, 70, 70))
        );
        jPanelMostrarLayout.setVerticalGroup(
            jPanelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelMostrarLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(botonEliminarPedido)
                .addGap(18, 18, 18)
                .addComponent(botonLlamarModificacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Mostrar", jPanelMostrar);

        javax.swing.GroupLayout jPanelPedidoLayout = new javax.swing.GroupLayout(jPanelPedido);
        jPanelPedido.setLayout(jPanelPedidoLayout);
        jPanelPedidoLayout.setHorizontalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPedidoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );
        jPanelPedidoLayout.setVerticalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane2.getAccessibleContext().setAccessibleName("");

        jPanelAlmacen.setOpaque(false);

        tablaAlmacen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaAlmacen);

        botonBuscarAlmacen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBuscarAlmacen.setText("Buscar");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 102));
        jLabel6.setText("ALMACEN");

        botonAnadirAlmacen.setText("Añadir");

        botonActualizarAlmacen.setText("Actualizar");

        javax.swing.GroupLayout jPanelAlmacenLayout = new javax.swing.GroupLayout(jPanelAlmacen);
        jPanelAlmacen.setLayout(jPanelAlmacenLayout);
        jPanelAlmacenLayout.setHorizontalGroup(
            jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1028, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlmacenLayout.createSequentialGroup()
                .addContainerGap(364, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap(364, Short.MAX_VALUE))
            .addGroup(jPanelAlmacenLayout.createSequentialGroup()
                .addGap(228, 228, 228)
                .addComponent(botonBuscarAlmacen)
                .addGap(129, 129, 129)
                .addComponent(botonAnadirAlmacen)
                .addGap(102, 102, 102)
                .addComponent(botonActualizarAlmacen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelAlmacenLayout.setVerticalGroup(
            jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonBuscarAlmacen)
                    .addComponent(botonAnadirAlmacen)
                    .addComponent(botonActualizarAlmacen))
                .addGap(47, 47, 47))
        );

        jPanelOferta.setOpaque(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 153));
        jLabel3.setText("OFERTAS");

        javax.swing.GroupLayout jPanelOfertaLayout = new javax.swing.GroupLayout(jPanelOferta);
        jPanelOferta.setLayout(jPanelOfertaLayout);
        jPanelOfertaLayout.setHorizontalGroup(
            jPanelOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelOfertaLayout.createSequentialGroup()
                .addContainerGap(324, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(348, 348, 348))
        );
        jPanelOfertaLayout.setVerticalGroup(
            jPanelOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOfertaLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addContainerGap(674, Short.MAX_VALUE))
        );

        jPanelEstadistica.setOpaque(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 0));
        jLabel4.setText("ESTADISTICA");

        javax.swing.GroupLayout jPanelEstadisticaLayout = new javax.swing.GroupLayout(jPanelEstadistica);
        jPanelEstadistica.setLayout(jPanelEstadisticaLayout);
        jPanelEstadisticaLayout.setHorizontalGroup(
            jPanelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadisticaLayout.createSequentialGroup()
                .addGap(399, 399, 399)
                .addComponent(jLabel4)
                .addContainerGap(248, Short.MAX_VALUE))
        );
        jPanelEstadisticaLayout.setVerticalGroup(
            jPanelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadisticaLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel4)
                .addContainerGap(588, Short.MAX_VALUE))
        );

        jPanelInicio.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 102));
        jLabel5.setText("Inicio");

        javax.swing.GroupLayout jPanelInicioLayout = new javax.swing.GroupLayout(jPanelInicio);
        jPanelInicio.setLayout(jPanelInicioLayout);
        jPanelInicioLayout.setHorizontalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jLabel5)
                .addContainerGap(380, Short.MAX_VALUE))
        );
        jPanelInicioLayout.setVerticalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addContainerGap(675, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelVistaLayout = new javax.swing.GroupLayout(jPanelVista);
        jPanelVista.setLayout(jPanelVistaLayout);
        jPanelVistaLayout.setHorizontalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1048, Short.MAX_VALUE)
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelEstadistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelVistaLayout.setVerticalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelOferta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelEstadistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelfondoLayout = new javax.swing.GroupLayout(jPanelfondo);
        jPanelfondo.setLayout(jPanelfondoLayout);
        jPanelfondoLayout.setHorizontalGroup(
            jPanelfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelfondoLayout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanelVista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelfondoLayout.setVerticalGroup(
            jPanelfondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelVista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setText("Archivo");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Editar");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelfondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelfondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedidosActionPerformed

    private void ventasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ventasActionPerformed

    private void botonAnadirElementoPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirElementoPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAnadirElementoPedidoActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);           
            }
        });

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton almacen;
    private javax.swing.JButton botonActualizarAlmacen;
    private javax.swing.JButton botonAnadirAlmacen;
    private javax.swing.JButton botonAnadirElementoPedido;
    private javax.swing.JButton botonBorrarElementoPedido;
    private javax.swing.JButton botonBuscarAlmacen;
    private javax.swing.JButton botonEliminarPedido;
    private javax.swing.JButton botonGuardarModificacion;
    private javax.swing.JButton botonLlamarModificacion;
    private javax.swing.JButton botonRealizarPedido;
    private javax.swing.JComboBox comboPedidoModificacion;
    private javax.swing.JButton estadistica;
    private javax.swing.JButton inicio;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAlmacen;
    private javax.swing.JPanel jPanelEstadistica;
    private javax.swing.JPanel jPanelInicio;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelModificarPedido;
    private javax.swing.JPanel jPanelMostrar;
    private javax.swing.JPanel jPanelNuevoPedido;
    private javax.swing.JPanel jPanelOferta;
    private javax.swing.JPanel jPanelPedido;
    private javax.swing.JPanel jPanelVenta;
    private javax.swing.JPanel jPanelVentaVentas;
    private javax.swing.JPanel jPanelVista;
    private javax.swing.JPanel jPanelfondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton ofertas;
    private javax.swing.JButton pedidos;
    private javax.swing.JTable tablaAlmacen;
    private javax.swing.JTable tablaEliminarPedido;
    private javax.swing.JTable tablaModificarPedido;
    private javax.swing.JTable tablaPedido;
    private javax.swing.JTable tablaVenta;
    private javax.swing.JButton ventas;
    // End of variables declaration//GEN-END:variables

    private void llamarLogin() throws HeadlessException {
        Login login=new Login();
        boolean usuarioCorrecto=false;
        while(!usuarioCorrecto){
            if(JOptionPane.showConfirmDialog(this,login , "Introduce Usuario y Contraseña", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE)==JOptionPane.OK_OPTION){
                if(login.comprobarUsuario()){
                    JOptionPane.showMessageDialog(this, "Bienvenido "+login.getUsuario(), "Saludo", WIDTH);
                    usuarioCorrecto=true;
                    comprobarTipo(login.getUsuario());
                }else{
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                System.exit(0);
            }    
        }
    }

    private void inicializarActionCommand() {
        this.inicio.setActionCommand("inicio");
        this.ventas.setActionCommand("ventas");
        this.pedidos.setActionCommand("pedidos");
        this.almacen.setActionCommand("almacen");
        this.ofertas.setActionCommand("ofertas");
        this.estadistica.setActionCommand("estadistica");
        this.botonAnadirAlmacen.setActionCommand("añadirAlmacen");
        this.botonBuscarAlmacen.setActionCommand("buscarAlmacen");
        this.botonActualizarAlmacen.setActionCommand("actualizarAlmacen");
    }

    private void comprobarTipo(String usuario) {
        if(!UsuarioDB.getTipoUsuario(usuario).equals("ADMINISTRADOR")){
            this.pedidos.setEnabled(false);
            this.ofertas.setEnabled(false);
            this.estadistica.setEnabled(false);
        }
    }

    private void ocultarPaneles() {
        this.jPanelVenta.setVisible(false);//Todos los paneles se inicializan no visibles menos el panel de inicio
        this.jPanelPedido.setVisible(false);
        this.jPanelAlmacen.setVisible(false);
        this.jPanelOferta.setVisible(false);
        this.jPanelEstadistica.setVisible(false);
    }
}
