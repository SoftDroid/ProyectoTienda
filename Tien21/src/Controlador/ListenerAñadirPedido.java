
package Controlador;

import Vista.AñadirPedido;
import Vista.Cantidad;
import Vista.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JTextField;
import Vista.ModeloTablaProductos;

public class ListenerAñadirPedido implements ActionListener{
    private Inicio inicio;
    private JTable tabla;
    private AñadirPedido ventana;
    
    public ListenerAñadirPedido(Inicio inicio,JTable tabla,AñadirPedido ventana) {
        this.inicio=inicio;
        this.tabla=tabla;
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cantidad cantidad=new Cantidad(null, true,this);
        cantidad.setVisible(true);
    }

    public void devolverElemento(JTextField jTextField1) {
        int cant=Integer.parseInt(jTextField1.getText().trim());
        int fila=tabla.getSelectedRow();
        Object [] elemento=(Object[]) ((ModeloTablaProductos)tabla.getModel()).getFila(fila);
        inicio.anadirPedido(elemento, cant);
        ventana.dispose();
    }
    
   
}
