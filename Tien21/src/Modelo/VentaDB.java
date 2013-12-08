
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class VentaDB {
    
    public Object[] buscarNombre(String nombreBuscar){
       Object[] lista=new Object[3];
        String sql="SELECT Nombre, PrecioVenta, 1  FROM producto  WHERE  Nombre='"+nombreBuscar+"';";
        try{
            Connection conexion=ConexionDB.conexion();
            Statement st=conexion.createStatement();
            ResultSet result=st.executeQuery(sql);
            while(result.next()){
                String nombre=result.getString(1);
                double precioVe=Double.parseDouble(result.getString(2));
                
                Object[]producto=new Object[]{nombre,precioVe, 0};
               lista = producto;
            }
        }catch(Exception e){
            System.out.println("Error pDB "+e);
        }
        return lista;
    }
    
     public Object[] buscarStock(String nombreBuscar){
       Object[] lista=new Object[2];
        String sql="SELECT Nombre,Stock  FROM producto  WHERE  Nombre='"+nombreBuscar+"';";
        try{
            Connection conexion=ConexionDB.conexion();
            Statement st=conexion.createStatement();
            ResultSet result=st.executeQuery(sql);
            while(result.next()){
                String nombre=result.getString(1);
                 int stock=Integer.parseInt(result.getString(2));
                
                Object[]producto=new Object[]{nombre,stock};
                lista = producto;
            }
        }catch(Exception e){
            System.out.println("Error pDB "+e);
        }
        return lista;
    }
     
       public  void nuevoStock(String nombreBuscar, int valor){
           
        try{
            Connection conexion=ConexionDB.conexion();
            Statement st=conexion.createStatement();
    
            String cadena="Update producto set Stock ='"+ valor +"' where Nombre='"+ nombreBuscar +"';";
	    st.executeUpdate(cadena);
             
        }catch(Exception e){
            System.out.println("Error pDB "+e);
        }
  
    }
}
