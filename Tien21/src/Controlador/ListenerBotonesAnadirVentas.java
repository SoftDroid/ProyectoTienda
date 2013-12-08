package Controlador;

import Vista.Inicio;
import Vista.ComparVenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class ListenerBotonesAnadirVentas implements ActionListener {
    
    private Inicio frame;
    private JTextField campo;
    private ComparVenta ventana;
    private JTextField cantidad;

    public ListenerBotonesAnadirVentas(JTextField campo, JTextField cant, Inicio frame, ComparVenta ventana){
    
           this.campo = campo;
           this.frame = frame;
           this.ventana = ventana;
           this.cantidad = cant;
    
    }

   
      
    @Override
    public void actionPerformed(ActionEvent e) {
       String s=e.getActionCommand();
        String valor=this.campo.getText().trim();
        String cant = this.cantidad.getText().trim();
        switch(s){
            case "correcto":
                frame.buscarVenta("nombre", valor, cant);
                frame.anadeVenta();
                ventana.dispose();
                
              break;
            case "cancelar":
                ventana.dispose();
              break;
    }
    
}
}
