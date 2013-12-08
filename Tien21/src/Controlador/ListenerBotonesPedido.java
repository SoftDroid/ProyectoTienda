
package Controlador;

import Modelo.LineaPedidoDB;
import Modelo.PedidoDB;
import Modelo.ProductoDB;
import Modelo.ProveedoresDB;
import Modelo.UsuarioDB;
import Vista.AñadirPedido;
import Vista.Inicio;
import Vista.ModeloListaProvedores;
import Vista.ModeloTablaEliminarPedido;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import Vista.ModeloTablaPedidos;
import Vista.ModificarPedido;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JList;

public class ListenerBotonesPedido implements ActionListener {
    private Inicio inicio;
    private JTable tabla;
    private JList lista;
    private JLabel precio;
    private String user;
    private String fecha;
    
    public ListenerBotonesPedido(Inicio aThis) {
        this.inicio=aThis;
    }
    
    public ListenerBotonesPedido(Inicio aThis,JTable tabla) {
        this.tabla=tabla;
        this.inicio=aThis;
    }
    
    public ListenerBotonesPedido(JTable tabla) {
        this.tabla=tabla;
    }
    
    public ListenerBotonesPedido(JTable tabla,JList lista,JLabel precio,String user) {
        this.tabla=tabla;
        this.lista=lista;
        this.precio=precio;
        this.user=user;
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
                if(this.tabla.getSelectedRow()!=-1){
                ((ModeloTablaPedidos)this.tabla.getModel()).borrarFila(tabla.getSelectedRow());
                inicio.calcularPrecioPedido(this.tabla);
                }
                break;
            case "realizarPedido":
                if(this.lista.getSelectedIndex()!=-1){
                this.crearPedido();
                this.crearLineasPedido();
                }
                break;
            case "limpiarPedido":
                ModeloTablaPedidos modeloPedido=new ModeloTablaPedidos(new ArrayList());
                this.tabla.setModel(modeloPedido);
                break;
            case "eliminarPedido":
                if(this.tabla.getSelectedRow()!=-1){
                PedidoDB.eliminarPedido((String) ((ModeloTablaEliminarPedido)this.tabla.getModel()).getValueAt(this.tabla.getSelectedRow(), 0));
                ((ModeloTablaEliminarPedido)this.tabla.getModel()).borrarFila(this.tabla.getSelectedRow());
                }
                break;
            case "modificacionPedido":
                if(this.tabla.getSelectedRow()!=-1){
                this.fecha=((String) ((ModeloTablaEliminarPedido)this.tabla.getModel()).getValueAt(this.tabla.getSelectedRow(), 1));
                int id =PedidoDB.getId(fecha);
                ModificarPedido vent= new ModificarPedido(inicio, true,id, this.tabla);
                vent.setVisible(true);
                }
                break;
            case "actualizarPedido":
                ModeloTablaEliminarPedido modeloEliminarPedido=new ModeloTablaEliminarPedido(PedidoDB.mostrarPedidos());
                this.tabla.setModel(modeloEliminarPedido);
                break;              
        }
    }  
    
    public void crearPedido(){
        boolean existe=false;
        String codigo=null;
        while(!existe){
            codigo=this.codigo();
            ArrayList<String> listaCodigos=PedidoDB.listaCodigo();
            existe=true;
            for(int cont=0;cont<listaCodigos.size();cont++){
                if(codigo.equals(listaCodigos.get(cont)))
                    existe=false;
            }
        }
        Date date = new Date();
        this.fecha=dateToMySQLDate(date);
        int idUser=UsuarioDB.getIdUser(user);
        Calendar cal =Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,7);
        String fechaEntrega=dateToMySQLDate(cal);
        String sql="INSERT INTO pedido(Codigo, FechaPedido, PrecioTotal, Usuario_idUsuario, FechaEntrega) values ('"+codigo+"','"+this.fecha+"','"+this.precio.getText().trim()+"','"+idUser+"','"+fechaEntrega+"')";
        PedidoDB.insertarPedido(sql);
    }
    
    public void crearLineasPedido(){
        int idPedido=PedidoDB.getId(fecha);
        String proveedor=(String) ((ModeloListaProvedores)lista.getModel()).getElementAt(lista.getSelectedIndex());
        int idProveedor= ProveedoresDB.getId(proveedor);
        for(int cont=0;cont<((ModeloTablaPedidos)tabla.getModel()).getRowCount();cont++){
            String nombre=(String) ((ModeloTablaPedidos)tabla.getModel()).getValueAt(cont, 0);
            String color=(String) ((ModeloTablaPedidos)tabla.getModel()).getValueAt(cont, 1);
            String talla=(String) ((ModeloTablaPedidos)tabla.getModel()).getValueAt(cont, 2);
            int cantidad=(int) ((ModeloTablaPedidos)tabla.getModel()).getValueAt(cont, 3);
            double precio=(double) ((ModeloTablaPedidos)tabla.getModel()).getValueAt(cont, 4);
            int idProducto=ProductoDB.getId(nombre,color,talla);
            double precioUnidad=precio/cantidad;
            String sql="Insert Into LineaPedido (Pedido_idPedido,Proveedor_idProveedor, Producto_idProducto, NumLinea, Cant, PrecioTotal, PrecioUnidad) VALUES ('"+idPedido+"','"+idProveedor+"','"+idProducto+"','"+(cont+1)+"','"+cantidad+"','"+precio+"','"+precioUnidad+"')";
            LineaPedidoDB.insertarPedido(sql);
        }
    }

    public static String dateToMySQLDate(Date fecha)
    {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(fecha);
    }
    
    private String dateToMySQLDate(Calendar cal) {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(cal.getTime());
    }
    
    public String codigo(){
	String s="";
		for(int cont=0;cont<5 ;cont++){
			s=s+numero();	
		}
		return s;
    }

	
    public char numero(){
	return (char)((Math.random()*10)+48);
    }

    

}
