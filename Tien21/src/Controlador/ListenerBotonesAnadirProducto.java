
package Controlador;

import Vista.AñadirProducto;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class ListenerBotonesAnadirProducto implements ActionListener {
    private AñadirProducto ventana;
    
    public ListenerBotonesAnadirProducto(AñadirProducto aThis) {
        this.ventana=aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        switch(s){
            case "añadir":
                
                break;
            case "cancelar":
                ventana.dispose();
                break;
        }
    }
    
}
