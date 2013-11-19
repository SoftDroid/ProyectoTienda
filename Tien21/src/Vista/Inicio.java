
package Vista;

import Controlador.BotonesInicio;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Inicio extends javax.swing.JFrame {
    private JPanel jPanelInicio;

    public Inicio() {
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());//Para Maximizar la ventana
        jPanelMenu.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanelVista.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanelVista.setOpaque(false);
        inicializarMenuBar();//Inicializamos la barra de menu
        this.jPanelInicio=this.jPanelVista;
        //llamarLogin();
        inicializarActionCommand();

        
        inicio.addActionListener(new BotonesInicio(jPanelVista,jPanelInicio));
        ventas.addActionListener(new BotonesInicio(jPanelVista,jPanelVenta));
        pedidos.addActionListener(new BotonesInicio(jPanelVista,jPanelPedido));
        almacen.addActionListener(new BotonesInicio(jPanelVista,jPanelAlmacen));
        ofertas.addActionListener(new BotonesInicio(jPanelVista,jPanelOferta));
        estadistica.addActionListener(new BotonesInicio(jPanelVista,jPanelEstadistica));
    }
    
    public void inicializarMenuBar(){
        JMenuItem minimizar=new JMenuItem("Minimizar");
        JMenuItem cerrar=new JMenuItem("Cerrar");
        jMenu1.add(minimizar);
        jMenu1.add(cerrar);
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

        jPanelVenta = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelPedido = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanelAlmacen = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlmacen = new javax.swing.JTable();
        textFieldBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        jPanelOferta = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanelEstadistica = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jPanelVenta.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("VENTAS");

        javax.swing.GroupLayout jPanelVentaLayout = new javax.swing.GroupLayout(jPanelVenta);
        jPanelVenta.setLayout(jPanelVentaLayout);
        jPanelVentaLayout.setHorizontalGroup(
            jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel1)
                .addContainerGap(329, Short.MAX_VALUE))
        );
        jPanelVentaLayout.setVerticalGroup(
            jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelVentaLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel1)
                .addContainerGap(419, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 102));
        jLabel2.setText("PEDIDOS");

        javax.swing.GroupLayout jPanelPedidoLayout = new javax.swing.GroupLayout(jPanelPedido);
        jPanelPedido.setLayout(jPanelPedidoLayout);
        jPanelPedidoLayout.setHorizontalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jLabel2)
                .addContainerGap(255, Short.MAX_VALUE))
        );
        jPanelPedidoLayout.setVerticalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPedidoLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel2)
                .addContainerGap(355, Short.MAX_VALUE))
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
                .addContainerGap(191, Short.MAX_VALUE))
        );
        jPanelAlmacenLayout.setVerticalGroup(
            jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlmacenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
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
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanelOfertaLayout.setVerticalGroup(
            jPanelOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOfertaLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabel3)
                .addContainerGap(343, Short.MAX_VALUE))
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
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanelEstadisticaLayout.setVerticalGroup(
            jPanelEstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEstadisticaLayout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel4)
                .addContainerGap(350, Short.MAX_VALUE))
        );

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
                    .addComponent(pedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(almacen, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ofertas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadistica, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ventas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout jPanelVistaLayout = new javax.swing.GroupLayout(jPanelVista);
        jPanelVista.setLayout(jPanelVistaLayout);
        jPanelVistaLayout.setHorizontalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        jPanelVistaLayout.setVerticalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelAlmacen;
    private javax.swing.JPanel jPanelEstadistica;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelOferta;
    private javax.swing.JPanel jPanelPedido;
    private javax.swing.JPanel jPanelVenta;
    private javax.swing.JPanel jPanelVista;
    private javax.swing.JPanel jPanelfondo;
    private javax.swing.JScrollPane jScrollPane1;
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
