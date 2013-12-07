
package Controlador;

import Vista.AñadirPedido;
import Vista.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import Vista.ModeloTablaPedidos;
import javax.swing.JList;

public class ListenerBotonesPedido implements ActionListener {
    private Inicio inicio;
    private JTable tabla;
    private JList lista;
    
    public ListenerBotonesPedido(Inicio aThis) {
        this.inicio=aThis;
    }
    
    public ListenerBotonesPedido(Inicio aThis,JTable tabla) {
        this.tabla=tabla;
        this.inicio=aThis;
    }
    
    public ListenerBotonesPedido(JTable tabla,JList lista) {
        this.tabla=tabla;
        this.lista=lista;
    }
    
    public ListenerBotonesPedido() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s){
            case "añadirElementoPedido":      
                AñadirPedido ventana=new AñadirPedido(null, true,inicio);
                ventana.setVisible(true);
                break;
            case "borrarElementoPedido":   
                ((ModeloTablaPedidos)tabla.getModel()).borrarFila(tabla.getSelectedRow());
                inicio.calcularPrecioPedido(tabla);
                break;
            case "realizarPedido":
                
                break;
            case "eliminarPedido":

                break;
            case "modificacionPedido":

                break;
        }
    }  
}
