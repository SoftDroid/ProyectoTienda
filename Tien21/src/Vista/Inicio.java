
package Vista;

import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class Inicio extends javax.swing.JFrame {

    public Inicio() {
        initComponents();
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());//Para Maximizar la ventana
        jPanelMenu.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanelVista.setBorder(BorderFactory.createLineBorder(Color.black));
        jPanelVista.setOpaque(false);
        inicializarMenuBar();//Inicializamos la barra de menu

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
        jPanelPedido = new javax.swing.JPanel();
        jPanelAlmacen = new javax.swing.JPanel();
        jPanelOferta = new javax.swing.JPanel();
        Estadistica = new javax.swing.JPanel();
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
        ventas = new javax.swing.JButton();
        pedidos = new javax.swing.JButton();
        almacen = new javax.swing.JButton();
        ofertas = new javax.swing.JButton();
        estadistica = new javax.swing.JButton();
        jPanelVista = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanelVentaLayout = new javax.swing.GroupLayout(jPanelVenta);
        jPanelVenta.setLayout(jPanelVentaLayout);
        jPanelVentaLayout.setHorizontalGroup(
            jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 736, Short.MAX_VALUE)
        );
        jPanelVentaLayout.setVerticalGroup(
            jPanelVentaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelPedidoLayout = new javax.swing.GroupLayout(jPanelPedido);
        jPanelPedido.setLayout(jPanelPedidoLayout);
        jPanelPedidoLayout.setHorizontalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 860, Short.MAX_VALUE)
        );
        jPanelPedidoLayout.setVerticalGroup(
            jPanelPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 543, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelAlmacenLayout = new javax.swing.GroupLayout(jPanelAlmacen);
        jPanelAlmacen.setLayout(jPanelAlmacenLayout);
        jPanelAlmacenLayout.setHorizontalGroup(
            jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 873, Short.MAX_VALUE)
        );
        jPanelAlmacenLayout.setVerticalGroup(
            jPanelAlmacenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 548, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelOfertaLayout = new javax.swing.GroupLayout(jPanelOferta);
        jPanelOferta.setLayout(jPanelOfertaLayout);
        jPanelOfertaLayout.setHorizontalGroup(
            jPanelOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        jPanelOfertaLayout.setVerticalGroup(
            jPanelOfertaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout EstadisticaLayout = new javax.swing.GroupLayout(Estadistica);
        Estadistica.setLayout(EstadisticaLayout);
        EstadisticaLayout.setHorizontalGroup(
            EstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 882, Short.MAX_VALUE)
        );
        EstadisticaLayout.setVerticalGroup(
            EstadisticaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage((new ImageIcon("Desert.jpg").getImage()));
        setUndecorated(true);

        jPanelfondo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelfondo.setOpaque(false);

        jPanelMenu.setBackground(new java.awt.Color(0, 32, 71));

        ventas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ventas.png"))); // NOI18N
        ventas.setBorder(null);
        ventas.setBorderPainted(false);
        ventas.setContentAreaFilled(false);
        ventas.setPreferredSize(new java.awt.Dimension(50, 20));
        ventas.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ventas1.png"))); // NOI18N
        ventas.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ventas2.png"))); // NOI18N

        pedidos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pedidos.setText("Pedidos");
        pedidos.setPreferredSize(new java.awt.Dimension(50, 20));
        pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosActionPerformed(evt);
            }
        });

        almacen.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        almacen.setText("Almacen");
        almacen.setPreferredSize(new java.awt.Dimension(50, 20));
        almacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                almacenActionPerformed(evt);
            }
        });

        ofertas.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ofertas.setText("Ofertas");
        ofertas.setPreferredSize(new java.awt.Dimension(50, 20));

        estadistica.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        estadistica.setText("Estadisticas");
        estadistica.setPreferredSize(new java.awt.Dimension(50, 20));

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(almacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ofertas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(estadistica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ventas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(ventas, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(pedidos, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addComponent(almacen, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addGap(39, 39, 39)
                .addComponent(ofertas, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(estadistica, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanelVistaLayout = new javax.swing.GroupLayout(jPanelVista);
        jPanelVista.setLayout(jPanelVistaLayout);
        jPanelVistaLayout.setHorizontalGroup(
            jPanelVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
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

    private void almacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_almacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_almacenActionPerformed

    private void pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pedidosActionPerformed

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
    private javax.swing.JPanel Estadistica;
    private javax.swing.JButton almacen;
    private javax.swing.JButton estadistica;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelAlmacen;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelOferta;
    private javax.swing.JPanel jPanelPedido;
    private javax.swing.JPanel jPanelVenta;
    private javax.swing.JPanel jPanelVista;
    private javax.swing.JPanel jPanelfondo;
    private javax.swing.JButton ofertas;
    private javax.swing.JButton pedidos;
    private javax.swing.JButton ventas;
    // End of variables declaration//GEN-END:variables
}
