
package Controlador;

import Modelo.LineaPedidoDB;
import Modelo.PedidoDB;
import Modelo.ProductoDB;
import Vista.AñadirPedido;
import Vista.Cantidad;
import Vista.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JTextField;
import Modelo.ModeloTablaProductos;

public class ListenerAñadirPedido implements ActionListener{
    private Inicio inicio;
    private JTable tabla;
    private AñadirPedido ventana;
    private int id;
    
    public ListenerAñadirPedido(Inicio inicio,JTable tabla,AñadirPedido ventana) {
        this.inicio=inicio;
        this.tabla=tabla;
        this.ventana=ventana;
    }

    public ListenerAñadirPedido(JTable tablaAnadirPedido, AñadirPedido ventana, int id) {//añadir pedido para moficicacion
        this.tabla=tablaAnadirPedido;
        this.ventana=ventana;
        this.id=id;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        Cantidad cantidad=null;
        switch (s){
            case "añadirPedido":      
                    cantidad=new Cantidad(null, true,this);
                    cantidad.setVisible(true);
                    break;
            case "añadirModificacion":   
                    cantidad=new Cantidad(null, true,this, this.id);
                    cantidad.setVisible(true);
                    break;
        }
    }

    public void devolverElemento(JTextField jTextField1) {//añadir linea nueva pedido
        int cant=Integer.parseInt(jTextField1.getText().trim());
        int fila=tabla.getSelectedRow();
        Object [] elemento=(Object[]) ((ModeloTablaProductos)tabla.getModel()).getFila(fila);
        inicio.anadirPedido(elemento, cant);
        ventana.dispose();
    }

    public void devolverElementoModificacion(JTextField jTextField1) {
        int cant=Integer.parseInt(jTextField1.getText().trim());
        int fila=tabla.getSelectedRow();
        Object [] elemento=(Object[]) ((ModeloTablaProductos)tabla.getModel()).getFila(fila);
        String nombre=(String) elemento[1];
        String color=(String) elemento[5];
        String talla=(String) elemento[6];    
        double precioUnidad=(double) elemento[2];
        int idProducto=ProductoDB.getId(nombre,color,talla);
        double precio=precioUnidad*cant;
        int idProveedor = LineaPedidoDB.getIdProveedor(id);
        int numLinea = LineaPedidoDB.getCountLinea(id);
        numLinea++;
        String sql="Insert Into LineaPedido (Pedido_idPedido,Proveedor_idProveedor, Producto_idProducto, NumLinea, Cant, PrecioTotal, PrecioUnidad) VALUES ('"+this.id+"','"+idProveedor+"','"+idProducto+"','"+numLinea+"','"+cant+"','"+precio+"','"+precioUnidad+"')";
        LineaPedidoDB.insertarPedido(sql);
        double precioTotal=PedidoDB.getPrecio(id);
        precioTotal+=precio;
        PedidoDB.setPrecio(id, precioTotal);
        ventana.dispose();
    }
    
   
}
