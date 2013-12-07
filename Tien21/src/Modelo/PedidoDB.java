
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
    
    public static ArrayList mostrarPedidos(){
        ArrayList<Object> lista = new ArrayList<Object>();
        Connection conexion=ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            String sql="Select * from pedido";
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                Object[] linea = new Object[3];
                linea[0]=rs.getString(2);
                linea[1]=rs.getString(3);
                linea[2]=rs.getString(4);
                lista.add(linea);
            }
        }catch(Exception e){
            System.out.println("Error");
        }
        return lista;
    }
    
    public static void eliminarPedido(String codigo){
        Connection conexion=ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            String sql="Select idPedido FROM pedido WHERE codigo="+codigo;
            ResultSet rs=st.executeQuery(sql);
            int idPedido=0;
            while(rs.next()){
                idPedido = rs.getInt(1);
            }
            LineaPedidoDB.eliminarLinea(idPedido);
            sql="DELETE FROM pedido WHERE codigo="+codigo;
            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error eliminar pedido "+ e);
        }
    }
}
