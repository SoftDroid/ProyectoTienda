
package Modelo;

import java.sql.Connection;
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
}
