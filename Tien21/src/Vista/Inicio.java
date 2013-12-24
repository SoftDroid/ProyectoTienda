
package Vista;

import Modelo.ModeloTablaProductos;
import Modelo.ModeloTablaPedidos;
import Modelo.ModeloTablaEliminarPedido;
import Modelo.ModeloTablaVenta;
import Modelo.ModeloListaProvedores;
import Controlador.ListenerBotonesAlmacen;
import Controlador.ListenerBotonesInicio;
import Controlador.ListenerBotonesPedido;
import Controlador.ListenerBotonesVentas;
import Modelo.PedidoDB;
import Modelo.ProductoDB;
import Modelo.ProveedoresDB;
import Modelo.UsuarioDB;
import Modelo.VentaDB;
import Modelo.renderTabla;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Inicio extends javax.swing.JFrame {
    private ArrayList listProductosAlmacen;
    private String user;
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

        ModeloTablaProductos modeloAlmacen=new ModeloTablaProductos(new ProductoDB().mostrarAlmacen());
        this.tablaAlmacen.setModel(modeloAlmacen);
        
        ModeloTablaPedidos modeloPedido=new ModeloTablaPedidos(new ArrayList());
        this.tablaPedido.setModel(modeloPedido);
        
        ModeloTablaEliminarPedido modeloEliminarPedido=new ModeloTablaEliminarPedido(PedidoDB.mostrarPedidos());
        this.tablaMostrarPedido.setModel(modeloEliminarPedido);
        renderTabla miRender=new renderTabla();
        this.tablaMostrarPedido.setDefaultRenderer(Boolean.class, miRender);
        
        ModeloTablaVenta modeloVenta = new ModeloTablaVenta(new ArrayList ());
        this.tablaVenta.setModel(modeloVenta);
        
        ModeloListaProvedores modeloListaProveedores=new ModeloListaProvedores(ProveedoresDB.listaProveedores());
        this.listaProvedores.setModel(modeloListaProveedores);
        
        this.inicio.addActionListener(new ListenerBotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));//Se inicializan los listeners de los botones del menu
        this.ventas.addActionListener(new ListenerBotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.pedidos.addActionListener(new ListenerBotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.almacen.addActionListener(new ListenerBotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.ofertas.addActionListener(new ListenerBotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.estadistica.addActionListener(new ListenerBotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        
        this.botonActualizarAlmacen.addActionListener(new ListenerBotonesAlmacen(tablaAlmacen));
        this.botonAnadirAlmacen.addActionListener(new ListenerBotonesAlmacen());
        this.botonBuscarAlmacen.addActionListener(new ListenerBotonesAlmacen(this));
        
        this.botonAnadirElementoPedido.addActionListener(new ListenerBotonesPedido(this,this.listaProvedores));
        this.botonBorrarElementoPedido.addActionListener(new ListenerBotonesPedido(this,this.tablaPedido));
        this.botonRealizarPedido.addActionListener(new ListenerBotonesPedido(this.tablaPedido,this.listaProvedores,this.precioPedido,this.user));
        this.botonLimpiarPedido.addActionListener(new ListenerBotonesPedido(this.tablaPedido));
        this.botonActualizarPedido.addActionListener(new ListenerBotonesPedido(this.tablaMostrarPedido));
        this.botonEliminarPedido.addActionListener(new ListenerBotonesPedido(this.tablaMostrarPedido));
        this.botonLlamarModificacion.addActionListener(new ListenerBotonesPedido(this.tablaMostrarPedido));
        
        this.anadirVentas.addActionListener(new ListenerBotonesVentas(this));
        this.borrarVentas.addActionListener(new ListenerBotonesVentas(tablaVenta, modeloVenta));
        this.realizarVenta.addActionListener(new ListenerBotonesVentas(this));
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
        anadirVentas = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        borrarVentas = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        realizarVenta = new javax.swing.JButton();
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
        jLabel12 = new javax.swing.JLabel();
        precioPedido = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listaProvedores = new javax.swing.JList();
        jLabel13 = new javax.swing.JLabel();
        botonLimpiarPedido = new javax.swing.JButton();
        jPanelMostrar = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaMostrarPedido = new javax.swing.JTable();
        botonEliminarPedido = new javax.swing.JButton();
        botonLlamarModificacion = new javax.swing.JButton();
        botonActualizarPedido = new javax.swing.JButton();
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

        anadirVentas.setText("Añadir");

        borrarVentas.setText("Borrar");

        jLabel7.setText("Precio total");

        jLabel8.setText("Pago");

        jLabel9.setText("Devolución");

        jLabel10.setText("0");
        jLabel10.setToolTipText("");

        jLabel11.setText("0");

        realizarVenta.setText("Realizar Venta");

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
                        .addComponent(anadirVentas)
                        .addGap(60, 60, 60)
                        .addComponent(borrarVentas))
                    .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(realizarVenta)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        jPanelVentaVentasLayout.setVerticalGroup(
            jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelVentaVentasLayout.createSequentialGroup()
                        .addGroup(jPanelVentaVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anadirVentas)
                            .addComponent(borrarVentas))
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
                            .addComponent(jLabel11))
                        .addGap(79, 79, 79)
                        .addComponent(realizarVenta))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(197, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Realizar venta", jPanelVentaVentas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
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

        tablaPedido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

        botonAnadirElementoPedido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonAnadirElementoPedido.setText("Añadir");
        botonAnadirElementoPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirElementoPedidoActionPerformed(evt);
            }
        });

        botonBorrarElementoPedido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonBorrarElementoPedido.setText("Borrar");

        botonRealizarPedido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonRealizarPedido.setText("Realizar Pedido");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel12.setText("Total:");

        precioPedido.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N

        listaProvedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        listaProvedores.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(listaProvedores);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Lista Proveedores:");

        botonLimpiarPedido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonLimpiarPedido.setText("Limpiar");

        javax.swing.GroupLayout jPanelNuevoPedidoLayout = new javax.swing.GroupLayout(jPanelNuevoPedido);
        jPanelNuevoPedido.setLayout(jPanelNuevoPedidoLayout);
        jPanelNuevoPedidoLayout.setHorizontalGroup(
            jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoPedidoLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                        .addComponent(precioPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelNuevoPedidoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(botonRealizarPedido)
                            .addGroup(jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(botonBorrarElementoPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonAnadirElementoPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botonLimpiarPedido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelNuevoPedidoLayout.setVerticalGroup(
            jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addGroup(jPanelNuevoPedidoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel13)
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonAnadirElementoPedido)
                        .addGap(18, 18, 18)
                        .addComponent(botonLimpiarPedido)
                        .addGap(18, 18, 18)
                        .addComponent(botonBorrarElementoPedido)
                        .addGap(18, 18, 18)
                        .addComponent(botonRealizarPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelNuevoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(precioPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Nuevo", jPanelNuevoPedido);

        tablaMostrarPedido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tablaMostrarPedido.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tablaMostrarPedido);

        botonEliminarPedido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonEliminarPedido.setText("Eliminar");
        botonEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarPedidoActionPerformed(evt);
            }
        });

        botonLlamarModificacion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonLlamarModificacion.setText("Modificar");

        botonActualizarPedido.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonActualizarPedido.setText("Actualizar");

        javax.swing.GroupLayout jPanelMostrarLayout = new javax.swing.GroupLayout(jPanelMostrar);
        jPanelMostrar.setLayout(jPanelMostrarLayout);
        jPanelMostrarLayout.setHorizontalGroup(
            jPanelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addGroup(jPanelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonActualizarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonLlamarModificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanelMostrarLayout.setVerticalGroup(
            jPanelMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMostrarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanelMostrarLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(botonActualizarPedido)
                .addGap(18, 18, 18)
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

        botonBuscarAlmacen.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonBuscarAlmacen.setText("Buscar");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 255, 102));
        jLabel6.setText("ALMACEN");

        botonAnadirAlmacen.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonAnadirAlmacen.setText("Añadir");
        botonAnadirAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAnadirAlmacenActionPerformed(evt);
            }
        });

        botonActualizarAlmacen.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        botonActualizarAlmacen.setText("Actualizar");

        javax.swing.GroupLayout jPanelAlmacenLayout = new javax.swing.GroupLayout(jPanelAlmacen);
        jPanelAlmacen.setLayout(jPanelAlmacenLayout);
        jPanelAlmacenLayout.setHorizontalGroup(
            jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1085, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlmacenLayout.createSequentialGroup()
                        .addGap(0, 454, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(0, 454, Short.MAX_VALUE))
                    .addGroup(jPanelAlmacenLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonBuscarAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 288, Short.MAX_VALUE)
                        .addComponent(botonAnadirAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addComponent(botonActualizarAlmacen)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelAlmacenLayout.setVerticalGroup(
            jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
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
                .addContainerGap(535, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(348, 348, 348))
        );
        jPanelOfertaLayout.setVerticalGroup(
            jPanelOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOfertaLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel3)
                .addContainerGap(754, Short.MAX_VALUE))
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
                .addContainerGap(459, Short.MAX_VALUE))
        );
        jPanelEstadisticaLayout.setVerticalGroup(
            jPanelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadisticaLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel4)
                .addContainerGap(668, Short.MAX_VALUE))
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
                .addContainerGap(598, Short.MAX_VALUE))
        );
        jPanelInicioLayout.setVerticalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addContainerGap(755, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelVistaLayout = new javax.swing.GroupLayout(jPanelVista);
        jPanelVista.setLayout(jPanelVistaLayout);
        jPanelVistaLayout.setHorizontalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1105, Short.MAX_VALUE)
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
            .addGap(0, 860, Short.MAX_VALUE)
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

    private void botonEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarPedidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonEliminarPedidoActionPerformed

    private void botonAnadirAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAnadirAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAnadirAlmacenActionPerformed

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
    private javax.swing.JButton anadirVentas;
    private javax.swing.JButton borrarVentas;
    private javax.swing.JButton botonActualizarAlmacen;
    private javax.swing.JButton botonActualizarPedido;
    private javax.swing.JButton botonAnadirAlmacen;
    private javax.swing.JButton botonAnadirElementoPedido;
    private javax.swing.JButton botonBorrarElementoPedido;
    private javax.swing.JButton botonBuscarAlmacen;
    private javax.swing.JButton botonEliminarPedido;
    private javax.swing.JButton botonLimpiarPedido;
    private javax.swing.JButton botonLlamarModificacion;
    private javax.swing.JButton botonRealizarPedido;
    private javax.swing.JButton estadistica;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JList listaProvedores;
    private javax.swing.JButton ofertas;
    private javax.swing.JButton pedidos;
    private javax.swing.JLabel precioPedido;
    private javax.swing.JButton realizarVenta;
    private javax.swing.JTable tablaAlmacen;
    private javax.swing.JTable tablaMostrarPedido;
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
                    this.user=login.getUsuario();
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
        this.botonAnadirElementoPedido.setActionCommand("añadirElementoPedido");
        this.botonBorrarElementoPedido.setActionCommand("borrarElementoPedido");
        this.botonRealizarPedido.setActionCommand("realizarPedido");
        this.botonEliminarPedido.setActionCommand("eliminarPedido");
        this.botonLlamarModificacion.setActionCommand("modificacionPedido");
        this.botonActualizarPedido.setActionCommand("actualizarPedido");
        this.botonLimpiarPedido.setActionCommand("limpiarPedido");
        this.anadirVentas.setActionCommand("añadirVenta");
        this.borrarVentas.setActionCommand("borrarVenta");
        this.realizarVenta.setActionCommand("realizarVenta");
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
    
    public void buscarAlmacen(String tipo,String valor){
        if(tipo.equals("nombre")){
            ArrayList<Object> listaBucar=new ProductoDB().buscarNombre(valor);
            ModeloTablaProductos modeloAlmacen=new ModeloTablaProductos(listaBucar);
            this.tablaAlmacen.setModel(modeloAlmacen);
        }else{
            ArrayList<Object> listaBucar=new ProductoDB().buscarCodigo(valor);
            ModeloTablaProductos modeloAlmacen=new ModeloTablaProductos(listaBucar);
            this.tablaAlmacen.setModel(modeloAlmacen);
        }
    }
    
    public void anadirPedido(Object [] elemento,int cant){
        Object [] elem=new Object[5];
        elem[0]=elemento[1];
        elem[1]=elemento[5];
        elem[2]=elemento[6];
        elem[3]=cant;
        elem[4]=((double)elemento[2])*cant;
        ((ModeloTablaPedidos)this.tablaPedido.getModel()).anadirFila(elem);
        this.calcularPrecioPedido(tablaPedido);
    }
    
    public void calcularPrecioPedido(JTable tabla){
        double precio=0;
        for(int cont=0;cont<((ModeloTablaPedidos)tabla.getModel()).getRowCount();cont++){
            System.out.println(((ModeloTablaPedidos)tabla.getModel()).getValueAt(cont, 4));
            precio+=(double)((ModeloTablaPedidos)tabla.getModel()).getValueAt(cont, 4);
        }
        this.precioPedido.setText(precio+"");
    }
    
    private int cont = 0;
     
    public void buscarVenta(String tipo,String valor, String cantidad){
       if(tipo.equals("nombre")){
            Object[] listaBucar=new VentaDB().buscarNombre(valor);
            ((ModeloTablaVenta)this.tablaVenta.getModel()).anadirFila(listaBucar);
            ((ModeloTablaVenta)this.tablaVenta.getModel()).setValueAt(cantidad,cont,2);
            
            System.out.println(cantidad);
            System.out.println(this.tablaVenta.getModel().getValueAt(0,2));
             cont++;     
             
             
       }
    }
    
    double precioTotal;
    double sumaTotal;
    Double cantidad;
    public void anadeVenta (){
        precioTotal = 0;
        sumaTotal =0;
        int cantFila = ((ModeloTablaVenta)this.tablaVenta.getModel()).getRowCount();
        System.out.println("Cantidad de filas " + cantFila);
        for(int i =0; i < cantFila; i++){     
            Double precio = null;
            cantidad = 1.0;

            Object pre = ((ModeloTablaVenta)this.tablaVenta.getModel()).getValueAt(i, 1);
            if (pre instanceof Double) {
               precio = (Double) pre;
            }     
            cantidad = Double.parseDouble((String)((ModeloTablaVenta)this.tablaVenta.getModel()).getValueAt(i, 2));

            System.out.println("Cantidad :" + cantidad);
            System.out.println("p:" + precio);

            precioTotal = precio * cantidad ;
            sumaTotal = sumaTotal + precioTotal;
            jLabel10.setText(sumaTotal + "");
        }
    }
 
    public void realizarVenta(){
        Double pago = 0.0;
        pago = Double.parseDouble((String) jTextField2.getText());
         
        double devolucion = sumaTotal - pago;
        jLabel11.setText(devolucion + "");
       
        int cantFila = ((ModeloTablaVenta)this.tablaVenta.getModel()).getRowCount();
        for(int i = 0; i < cantFila; i++ ){
            String nombre = (String) ((ModeloTablaVenta)this.tablaVenta.getModel()).getValueAt(i, 0);
            Object[] listaStock=new VentaDB().buscarStock(nombre);

            int stockAlma = (int) listaStock[1];
    
            int cantRestante = (int) (stockAlma - cantidad);
            System.out.println("LA CANTIDAd restante es" + cantRestante);
        
            new VentaDB().nuevoStock(nombre, cantRestante);
       }  
    }
}
