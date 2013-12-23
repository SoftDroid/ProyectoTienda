
package Controlador;

import Modelo.ProductoDB;
import Vista.AñadirProducto;
import Vista.Buscar;
import Vista.Inicio;
import Modelo.ModeloTablaProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

public class ListenerBotonesAlmacen implements ActionListener{
    private JTable tablaAlmacen;
    private Inicio frame;
    public ListenerBotonesAlmacen(){
    
    }

    public ListenerBotonesAlmacen(JTable tablaAlmacen) {
        this.tablaAlmacen=tablaAlmacen;
    }
    
    public ListenerBotonesAlmacen(Inicio frame) {
        this.frame=frame;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s){
            case "añadirAlmacen":      
                    AñadirProducto nuevaVentana=new AñadirProducto(null, true);
                    nuevaVentana.setVisible(true);
                    break;
            case "buscarAlmacen":   
                    Buscar buscarVentana=new Buscar(null, true, frame);
                    buscarVentana.setVisible(true);
                    break;
            case "actualizarAlmacen":
                    ModeloTablaProductos modeloAlmacen=new ModeloTablaProductos(new ProductoDB().mostrarAlmacen());
                    this.tablaAlmacen.setModel(modeloAlmacen);
                    break;
        }
    }
    
}
