
package Vista;

import Controlador.BotonesInicio;
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
        //llamarLogin();
        this.jPanelVenta.setVisible(false);//Todos los paneles se inicializan no visibles menos el panel de inicio
        this.jPanelPedido.setVisible(false);
        this.jPanelAlmacen.setVisible(false);
        this.jPanelOferta.setVisible(false);
        this.jPanelEstadistica.setVisible(false);
        inicializarActionCommand();//metodo para añadir el ActionComand a los botones del menu y reconocer la llamada de cada boton en los listeners del controlador

        this.inicio.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));//Se inicializan los listeners de los botones del menu
        this.ventas.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.pedidos.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.almacen.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.ofertas.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        this.estadistica.addActionListener(new BotonesInicio(jPanelInicio,jPanelVenta,jPanelPedido,jPanelAlmacen,jPanelOferta,jPanelEstadistica, this));
        
        this.listProductosAlmacen=new ArrayList();
        this.listProductosAlmacen.add(new Object []{1234,"Camiseta corta",12.90,14.90,"Verano","Rojo","M","","",11,"Sin oferta",false});
        ModeloTablaProductos modeloAlmacen=new ModeloTablaProductos(listProductosAlmacen);
        this.tablaAlmacen.setModel(modeloAlmacen);
        
        
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanelPedido = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanelAlmacen = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlmacen = new javax.swing.JTable();
        textFieldBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
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
        ofertas.setPreferredSize(new java.awt.Dimension(50, 20));
        ofertas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/OfertasB.png"))); // NOI18N
        ofertas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/OfertasC.png"))); // NOI18N

        estadistica.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        estadistica.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/EstadisticasA.png"))); // NOI18N
        estadistica.setBorderPainted(false);
        estadistica.setContentAreaFilled(false);
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
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(ofertas, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(estadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        inicio.getAccessibleContext().setAccessibleDescription("");

        jPanelVenta.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("VENTAS");

        jTabbedPane1.setToolTipText("");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(396, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Realizar venta", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        javax.swing.GroupLayout jPanelVentaLayout = new javax.swing.GroupLayout(jPanelVenta);
        jPanelVenta.setLayout(jPanelVentaLayout);
        jPanelVentaLayout.setHorizontalGroup(
            jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 102));
        jLabel2.setText("PEDIDOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab1", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab2", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 869, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("tab3", jPanel5);

        javax.swing.GroupLayout jPanelPedidoLayout = new javax.swing.GroupLayout(jPanelPedido);
        jPanelPedido.setLayout(jPanelPedidoLayout);
        jPanelPedidoLayout.setHorizontalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addGap(271, 271, 271)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
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

        textFieldBuscar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        botonBuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        botonBuscar.setText("Buscar");

        javax.swing.GroupLayout jPanelAlmacenLayout = new javax.swing.GroupLayout(jPanelAlmacen);
        jPanelAlmacen.setLayout(jPanelAlmacenLayout);
        jPanelAlmacenLayout.setHorizontalGroup(
            jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlmacenLayout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(botonBuscar)
                .addGap(94, 94, 94)
                .addComponent(textFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        jPanelAlmacenLayout.setVerticalGroup(
            jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar))
                .addGap(29, 29, 29))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 204, 153));
        jLabel3.setText("OFERTAS");

        javax.swing.GroupLayout jPanelOfertaLayout = new javax.swing.GroupLayout(jPanelOferta);
        jPanelOferta.setLayout(jPanelOfertaLayout);
        jPanelOfertaLayout.setHorizontalGroup(
            jPanelOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOfertaLayout.createSequentialGroup()
                .addGap(378, 378, 378)
                .addComponent(jLabel3)
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanelOfertaLayout.setVerticalGroup(
            jPanelOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOfertaLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel3)
                .addContainerGap(576, Short.MAX_VALUE))
        );

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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Inicio");

        javax.swing.GroupLayout jPanelInicioLayout = new javax.swing.GroupLayout(jPanelInicio);
        jPanelInicio.setLayout(jPanelInicioLayout);
        jPanelInicioLayout.setHorizontalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(jLabel5)
                .addContainerGap(455, Short.MAX_VALUE))
        );
        jPanelInicioLayout.setVerticalGroup(
            jPanelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInicioLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addContainerGap(704, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelVistaLayout = new javax.swing.GroupLayout(jPanelVista);
        jPanelVista.setLayout(jPanelVistaLayout);
        jPanelVistaLayout.setHorizontalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 894, Short.MAX_VALUE)
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
            .addGap(0, 780, Short.MAX_VALUE)
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
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton estadistica;
    private javax.swing.JButton inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelAlmacen;
    private javax.swing.JPanel jPanelEstadistica;
    private javax.swing.JPanel jPanelInicio;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelOferta;
    private javax.swing.JPanel jPanelPedido;
    private javax.swing.JPanel jPanelVenta;
    private javax.swing.JPanel jPanelVista;
    private javax.swing.JPanel jPanelfondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton ofertas;
    private javax.swing.JButton pedidos;
    private javax.swing.JTable tablaAlmacen;
    private javax.swing.JTextField textFieldBuscar;
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
                }else{
                    JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else{
                System.exit(0);
            }    
        }
    }

    private void inicializarActionCommand() {
        inicio.setActionCommand("inicio");
        ventas.setActionCommand("ventas");
        pedidos.setActionCommand("pedidos");
        almacen.setActionCommand("almacen");
        ofertas.setActionCommand("ofertas");
        estadistica.setActionCommand("estadistica");
    }
}
