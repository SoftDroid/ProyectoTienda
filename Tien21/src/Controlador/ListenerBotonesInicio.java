
package Controlador;

import Vista.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class ListenerBotonesInicio implements ActionListener {
    private JPanel panelInicio;
    private JPanel panelVenta;
    private JPanel panelPedido;
    private JPanel panelAlmacen;
    private JPanel panelOferta;
    private JPanel panelEstadistica;
    private JFrame frame;

    public ListenerBotonesInicio(JPanel jPanelInicio, JPanel jPanelVenta, JPanel jPanelPedido, JPanel jPanelAlmacen, JPanel jPanelOferta, JPanel jPanelEstadistica, Inicio frame) {
        this.panelInicio=jPanelInicio;
        this.panelVenta=jPanelVenta;
        this.panelPedido=jPanelPedido;
        this.panelAlmacen=jPanelAlmacen;
        this.panelOferta=jPanelOferta;
        this.panelEstadistica=jPanelEstadistica;
        this.frame=frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s){
            case "inicio":      
                    this.panelInicio.setVisible(true);
                    this.panelVenta.setVisible(false);
                    this.panelPedido.setVisible(false);
                    this.panelAlmacen.setVisible(false);
                    this.panelOferta.setVisible(false);
                    this.panelEstadistica.setVisible(false);
                    this.panelInicio.repaint();
                    break;
            case "ventas":   
                    this.panelInicio.setVisible(false);
                    this.panelVenta.setVisible(true);
                    this.panelPedido.setVisible(false);
                    this.panelAlmacen.setVisible(false);
                    this.panelOferta.setVisible(false);
                    this.panelEstadistica.setVisible(false);
                    this.panelInicio.repaint();
                    break;
            case "pedidos":
                    this.panelInicio.setVisible(false);
                    this.panelVenta.setVisible(false);
                    this.panelPedido.setVisible(true);
                    this.panelAlmacen.setVisible(false);
                    this.panelOferta.setVisible(false);
                    this.panelEstadistica.setVisible(false);
                    this.panelInicio.repaint();
                    break;
            case "almacen":
                    this.panelInicio.setVisible(false);
                    this.panelVenta.setVisible(false);
                    this.panelPedido.setVisible(false);
                    this.panelAlmacen.setVisible(true);
                    this.panelOferta.setVisible(false);
                    this.panelEstadistica.setVisible(false);
                    this.panelInicio.repaint();
                    break;
            case "ofertas":
                    this.panelInicio.setVisible(false);
                    this.panelVenta.setVisible(false);
                    this.panelPedido.setVisible(false);
                    this.panelAlmacen.setVisible(false);
                    this.panelOferta.setVisible(true);
                    this.panelEstadistica.setVisible(false);
                    this.panelInicio.repaint();
                    break;
            case "estadistica":
                    this.panelInicio.setVisible(false);
                    this.panelVenta.setVisible(false);
                    this.panelPedido.setVisible(false);
                    this.panelAlmacen.setVisible(false);
                    this.panelOferta.setVisible(false);
                    this.panelEstadistica.setVisible(true);
                    this.panelInicio.repaint();
                    break;
        }
    }
    
}
