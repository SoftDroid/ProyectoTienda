
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

    public static String [] getDatosPedido(int id) {
        Connection conexion=ConexionDB.conexion();
        String [] datos = new String [5];
        try{
            Statement st=conexion.createStatement();
            String sql="Select p.codigo,p.FechaPedido, p.PrecioTotal, p.FechaEntrega, u.user FROM pedido p, usuario u WHERE p.idPedido="+id+" and p.Usuario_idUsuario=u.idUsuario";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                datos [0]=rs.getString(1);
                datos [1]=rs.getString(2);
                datos [2]=rs.getString(3);
                datos [3]=rs.getString(4);
                datos [4]=rs.getString(5);
            }
        }catch(Exception e){
            System.out.println("Error eliminar pedido "+ e);
        }
        return datos;
    }

    public static void setPrecio(int id, double precioTotal) {
        Connection conexion=ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            String sql="UPDATE pedido SET PrecioTotal="+precioTotal+" WHERE idPedido="+id;
            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error set cantidad Linea");
        }
        
    }

    public static double getPrecio(int id) {
        Connection conexion=ConexionDB.conexion();
        double precio=0;
        try{
            Statement st=conexion.createStatement();
            String sql="SELECT precioTotal FROM pedido WHERE  idPedido="+id;
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                precio=rs.getDouble(1);
            }

        }catch(Exception e){
            System.out.println("Error eliminar pedido "+ e);
        }
        return precio;
    }
}
