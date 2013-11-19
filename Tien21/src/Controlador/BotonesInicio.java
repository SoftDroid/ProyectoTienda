
package Controlador;

import Vista.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;



public class BotonesInicio implements ActionListener {
    private JPanel panel1;
    private JPanel panel2;
    public BotonesInicio(JPanel jPanel1, JPanel jPanel2) {
        panel1=jPanel1;
        panel2=jPanel2;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        switch (s){
            case "inicio":      
                    panel1=panel2;
                    break;
            case "ventas":
                    panel1=panel2;
                    break;
            case "pedidos":
                    panel1=panel2;
                    break;
            case "almacen":
                    panel1=panel2;
                    break;
            case "ofertas":
                    panel1=panel2;
                    break;
            case "estadistica":
                    panel1=panel2;
                    break;
            default:
                    panel1=panel2;
                    break;
        }
    }
    
}
