
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


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

    static void eliminarLinea(int idPedido) {
        Connection conexion=ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            String sql="DELETE FROM lineaPedido WHERE Pedido_idPedido="+idPedido;
            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error eliminarLinea");
        }
    }
}
