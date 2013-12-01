
package Controlador;

import Modelo.ProductoDB;
import Vista.AñadirProducto;
import Vista.ModeloTablaProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;

public class BotonesAlmacen implements ActionListener{
    private JTable tablaAlmacen;
    public BotonesAlmacen(){
    
    }

    public BotonesAlmacen(JTable tablaAlmacen) {
        this.tablaAlmacen=tablaAlmacen;
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
                   
                    break;
            case "actualizarAlmacen":
                    ModeloTablaProductos modeloAlmacen=new ModeloTablaProductos(new ProductoDB().mostrarAlmacen());
                    this.tablaAlmacen.setModel(modeloAlmacen);
                    break;
        }
    }
    
}
