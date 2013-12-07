
package Vista;

import Controlador.ListenerBotonesAlmacen;
import Controlador.ListenerBotonesAnadirProducto;
import Modelo.ColorDB;
import Modelo.FamiliaDB;
import Modelo.OfertaDB;
import Modelo.SubFamiliaDB;
import Modelo.TallaDB;
import Modelo.TemporadaDB;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;


public class AñadirProducto extends javax.swing.JDialog {

    public AñadirProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ArrayList<Object> listColores=new ArrayList <Object>();
        ArrayList<Object> listTallas=new ArrayList <Object>();
        setLocationRelativeTo(null);//coloca ventana en el centro
        this.jButtonAnadir.setActionCommand("añadir");
        this.jButtonCancelar.setActionCommand("cancelar");
        this.jLabelSubFamilia.setVisible(false);
        this.subfaAnadirProducto.setVisible(false);
        this.ofertaAnadirProducto.setVisible(false);
        
        this.temporadaAnadirProducto.setModel(new ModeloCombo(TemporadaDB.getTemporadas()));
        this.familiaAnadirProducto.setModel(new ModeloCombo(FamiliaDB.getFamilias()));
        
        ArrayList <String>color=ColorDB.getColor();//array con todos los colores del a base de datos
        jPanelScrollColor.setLayout(new BoxLayout(jPanelScrollColor, BoxLayout.Y_AXIS));

        for(int cont=0;cont<color.size();cont++){//bucle que recorre el array de colores
            Checkbox aux = new Checkbox(color.get(cont));//creo el checkbox
            aux.setFont(new java.awt.Font("Tahoma", 0, 14));
            listColores.add(aux);
            jPanelScrollColor.add(aux);//añado el checbox al panel de colores
            jPanelScrollColor.repaint();//repinto
            jPanelScrollColor.updateUI();
        }
        
        ArrayList <String>talla=TallaDB.getTallas();//array con todos los tallas del a base de datos
        jPanelScrollTalla.setLayout(new BoxLayout(jPanelScrollTalla,BoxLayout.Y_AXIS));
        
        for(int cont=0;cont<talla.size();cont++){//bucle que recorre el array de talla
            Checkbox aux = new Checkbox(talla.get(cont));//creo el checkbox
            aux.setFont(new java.awt.Font("Tahome", 0, 14));
            listTallas.add(aux);
            jPanelScrollTalla.add(aux);//añado el checbox al panel de tallas
            jPanelScrollTalla.repaint();//repinto
            jPanelScrollTalla.updateUI();
        }
        
        this.familiaAnadirProducto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                subfaAnadirProducto.setModel(new ModeloCombo(SubFamiliaDB.getSubFamilias((String)familiaAnadirProducto.getSelectedItem())));
                jLabelSubFamilia.setVisible(true);
                subfaAnadirProducto.setVisible(true);
            }
        });
        
        this.jCheckBoxOferta.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if(jCheckBoxOferta.isSelected()){
                    ofertaAnadirProducto.setVisible(true);
                    ofertaAnadirProducto.setModel(new ModeloCombo(OfertaDB.getOfertas()));
                }else{
                    ofertaAnadirProducto.setVisible(true);
                    ofertaAnadirProducto.setModel(null);
                }
            }
        });
        
       this.jButtonCancelar.addActionListener(new ListenerBotonesAnadirProducto(this));
       this.jButtonAnadir.addActionListener(new ListenerBotonesAnadirProducto(this,this.nombreAnadirProducto,this.codigoAnadirProducto,this.stockAnadirProducto,this.precioPAnadirProducto,this.precioVAnadirProducto,this.temporadaAnadirProducto,this.familiaAnadirProducto,this.subfaAnadirProducto,this.jCheckBoxOferta,this.ofertaAnadirProducto,listColores,listTallas));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelScrollTalla = new javax.swing.JPanel();
        jScrollPaneColor = new javax.swing.JScrollPane();
        jPanelScrollColor = new javax.swing.JPanel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAnadir = new javax.swing.JButton();
        ofertaAnadirProducto = new javax.swing.JComboBox();
        jCheckBoxOferta = new javax.swing.JCheckBox();
        subfaAnadirProducto = new javax.swing.JComboBox();
        familiaAnadirProducto = new javax.swing.JComboBox();
        jLabelSubFamilia = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        temporadaAnadirProducto = new javax.swing.JComboBox();
        stockAnadirProducto = new javax.swing.JTextField();
        precioVAnadirProducto = new javax.swing.JTextField();
        precioPAnadirProducto = new javax.swing.JTextField();
        codigoAnadirProducto = new javax.swing.JTextField();
        nombreAnadirProducto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout jPanelScrollTallaLayout = new javax.swing.GroupLayout(jPanelScrollTalla);
        jPanelScrollTalla.setLayout(jPanelScrollTallaLayout);
        jPanelScrollTallaLayout.setHorizontalGroup(
            jPanelScrollTallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanelScrollTallaLayout.setVerticalGroup(
            jPanelScrollTallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelScrollTalla);

        jScrollPaneColor.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneColor.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPaneColor.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        javax.swing.GroupLayout jPanelScrollColorLayout = new javax.swing.GroupLayout(jPanelScrollColor);
        jPanelScrollColor.setLayout(jPanelScrollColorLayout);
        jPanelScrollColorLayout.setHorizontalGroup(
            jPanelScrollColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 144, Short.MAX_VALUE)
        );
        jPanelScrollColorLayout.setVerticalGroup(
            jPanelScrollColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 167, Short.MAX_VALUE)
        );

        jScrollPaneColor.setViewportView(jPanelScrollColor);

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonCancelar.setText("Cancelar");

        jButtonAnadir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonAnadir.setText("Aceptar");

        ofertaAnadirProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ofertaAnadirProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBoxOferta.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jCheckBoxOferta.setText("Oferta");

        subfaAnadirProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subfaAnadirProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        familiaAnadirProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        familiaAnadirProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabelSubFamilia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabelSubFamilia.setText("SubFamilia:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Familia:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Color:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Talla:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Temporada:");
        jLabel7.setToolTipText("");

        temporadaAnadirProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        temporadaAnadirProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        stockAnadirProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        precioVAnadirProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        precioPAnadirProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        codigoAnadirProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        nombreAnadirProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Stock:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Precio Proveedor:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Codigo:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Nombre:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 102));
        jLabel1.setText("AÑADIR PRODUCTO");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Precio Venta:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(387, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(309, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subfaAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(temporadaAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(precioVAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(precioPAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel6))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(nombreAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel4))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(codigoAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(stockAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelSubFamilia)
                                            .addComponent(jLabel7)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(familiaAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jCheckBoxOferta)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(ofertaAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPaneColor, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(312, 312, 312)
                            .addComponent(jButtonAnadir)
                            .addGap(96, 96, 96)
                            .addComponent(jButtonCancelar)))
                    .addGap(341, 341, 341)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(precioPAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(precioVAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(temporadaAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(subfaAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(278, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(58, 58, 58)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(nombreAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(codigoAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(stockAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(familiaAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSubFamilia)))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCheckBoxOferta)
                        .addComponent(ofertaAnadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addComponent(jScrollPaneColor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAnadir)
                        .addComponent(jButtonCancelar))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(AñadirProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AñadirProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AñadirProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AñadirProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AñadirProducto dialog = new AñadirProducto(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigoAnadirProducto;
    private javax.swing.JComboBox familiaAnadirProducto;
    private javax.swing.JButton jButtonAnadir;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JCheckBox jCheckBoxOferta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSubFamilia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelScrollColor;
    private javax.swing.JPanel jPanelScrollTalla;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneColor;
    private javax.swing.JTextField nombreAnadirProducto;
    private javax.swing.JComboBox ofertaAnadirProducto;
    private javax.swing.JTextField precioPAnadirProducto;
    private javax.swing.JTextField precioVAnadirProducto;
    private javax.swing.JTextField stockAnadirProducto;
    private javax.swing.JComboBox subfaAnadirProducto;
    private javax.swing.JComboBox temporadaAnadirProducto;
    // End of variables declaration//GEN-END:variables
}
