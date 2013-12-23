
package Controlador;

import Vista.ComparVenta;
import Vista.Inicio;
import Modelo.ModeloTablaVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;


public class ListenerBotonesVentas implements ActionListener {
    
    private JTable tablaVenta;
    private Inicio frame;
    ModeloTablaVenta modeloVenta;
    public ListenerBotonesVentas(){}
    
    public ListenerBotonesVentas(JTable tablaVenta,  ModeloTablaVenta modeloVenta){
    
        this.tablaVenta = tablaVenta;
        this.modeloVenta = modeloVenta;
    }
    
    public ListenerBotonesVentas(Inicio frame){
    
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       String s = e.getActionCommand();
        switch (s){
            case "añadirVenta":      
                    ComparVenta compra = new ComparVenta(null, true, frame);
                    compra.setVisible(true);
                    
                    break;
            case "borrarVenta":   
                this.tablaVenta.setModel(modeloVenta);
               modeloVenta.borrarFila(tablaVenta.getSelectedRow());
                    break;
            case "realizarVenta":
                this.frame.realizarVenta();
                    break;
        }
    }
    
}
