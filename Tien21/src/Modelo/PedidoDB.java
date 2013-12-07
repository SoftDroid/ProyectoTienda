
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class PedidoDB {
    public static void insertarPedido(String sql){
        Connection conexion=ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            System.out.println(sql);
            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error insertar pedido");
        }
    }
    
    public static ArrayList <String> listaCodigo(){
        ArrayList <String> lista=new ArrayList <String>();
        Connection conexion=ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            String sql="Select codigo from pedido";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(rs.getString(1));
            }
        }catch(Exception e){
            System.out.println("Error");
        }
        return lista;
    }

    public static int getId(String fecha) {
        int id=0;
        Connection conexion=ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            String sql="Select idPedido from pedido where  FechaPedido='"+fecha+"';";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id=rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println("Error");
        }
        return id;
    }
}
