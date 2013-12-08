
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class LineaPedidoDB {
    public static void insertarPedido(String sql){
        Connection conexion=ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error insetar lineapedido");
        }
    }

    public static void eliminarLinea(int idPedido) {
        Connection conexion=ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            String sql="DELETE FROM lineaPedido WHERE Pedido_idPedido="+idPedido;
            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error eliminarLinea");
        }
    }

    public static ArrayList getLineasPedido(int id) {
        Connection conexion=ConexionDB.conexion();
        ArrayList linea=new ArrayList ();
        
        try{
            Statement st=conexion.createStatement();
            String sql="SELECT p.nombre, c.color, t.talla, l.cant, l.precioTotal   FROM lineapedido l, producto p, color c , talla t WHERE  l.Producto_idProducto=p.idProducto and p.Color_idColor=c.idColor and p.Talla_idTalla=t.idTalla and Pedido_idPedido ="+id;
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next()){
                Object [] datos = new Object [5];
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getInt(4);
                datos[4]=rs.getDouble(5);
                linea.add(datos);
            }

        }catch(Exception e){
            System.out.println("Error eliminar pedido "+ e);
        }
        return linea;
    }
    
    public static String getProveedor(int id) {
        Connection conexion=ConexionDB.conexion();
        String provedor="";
        try{
            Statement st=conexion.createStatement();
            String sql="SELECT p.nombre FROM lineapedido l, proveedor p WHERE  l.Proveedor_idProveedor=p.idProveedor and Pedido_idPedido ="+id;
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                provedor=rs.getString(1);
            }

        }catch(Exception e){
            System.out.println("Error eliminar pedido "+ e);
        }
        return provedor;
    }
}
