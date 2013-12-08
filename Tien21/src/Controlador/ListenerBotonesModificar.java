
package Controlador;

import Modelo.LineaPedidoDB;
import Modelo.PedidoDB;
import Vista.AñadirPedido;
import Vista.Buscar;
import Vista.Cantidad;
import Vista.ModeloTablaEliminarPedido;
import Vista.ModeloTablaPedidos;
import Vista.ModificarPedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JTable;

public class ListenerBotonesModificar implements ActionListener {
    private JTable tabla;
    private int id;
    private JLabel precioVentana;
    private JTable tablaInicio;
    
    public ListenerBotonesModificar(JTable tablaLineaPedido, int id,JLabel precioVentana,JTable tablaInicio) {
        this.tabla=tablaLineaPedido;
        this.id=id;
        this.precioVentana=precioVentana;
        this.tablaInicio=tablaInicio;
    }
    
    public ListenerBotonesModificar() {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        ModeloTablaPedidos newModelo;
        switch (s){
            case "añadirProducto":      
                AñadirPedido ventanaAnadir=new AñadirPedido(null, true, id);
                ventanaAnadir.setVisible(true);
                newModelo=new ModeloTablaPedidos(LineaPedidoDB.getLineasPedido(id));
                this.tabla.setModel(newModelo);
                actualizar();
                break;
            case "borrarProducto":  
                if(tabla.getSelectedRow()!=-1){
                    String datos[]=new String [3];
                    datos[0]=(String) ((ModeloTablaPedidos)tabla.getModel()).getValueAt(tabla.getSelectedRow(), 0);
                    datos[1]=(String) ((ModeloTablaPedidos)tabla.getModel()).getValueAt(tabla.getSelectedRow(), 1);
                    datos[2]=(String) ((ModeloTablaPedidos)tabla.getModel()).getValueAt(tabla.getSelectedRow(), 2); 
                    LineaPedidoDB.eliminarLinea(datos, id);
                    newModelo=new ModeloTablaPedidos(LineaPedidoDB.getLineasPedido(id));
                    this.tabla.setModel(newModelo);
                    double precioTotal=0;
                    for(int cont=0;cont<((ModeloTablaPedidos)tabla.getModel()).getRowCount();cont++){
                        precioTotal+=(double)((ModeloTablaPedidos)tabla.getModel()).getValueAt(cont, 4);
                    }
                    PedidoDB.setPrecio(id,precioTotal);
                    actualizar();
                }
                break;
            case "modificarProducto":
                if(tabla.getSelectedRow()!=-1){
                    Cantidad nuevaVentana = new Cantidad(null, true, this.tabla , this.id);
                    nuevaVentana.setVisible(true);
                    actualizar();
                }
                break;          
        }
    }

    private void actualizar() {
        ModeloTablaEliminarPedido modeloEliminarPedido=new ModeloTablaEliminarPedido(PedidoDB.mostrarPedidos());
        this.tablaInicio.setModel(modeloEliminarPedido);
        String [] datos =PedidoDB.getDatosPedido(id);
        this.precioVentana.setText(datos[2]);
    }
    
}
