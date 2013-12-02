
package Controlador;

import Vista.AñadirProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BotonesAnadirProducto implements ActionListener {
    private AñadirProducto ventana;
    public BotonesAnadirProducto(AñadirProducto aThis) {
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
