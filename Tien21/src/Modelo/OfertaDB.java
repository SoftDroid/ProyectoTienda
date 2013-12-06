
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OfertaDB {
    public static ArrayList <String> getOfertas(){
        ArrayList <String> lista=new ArrayList <String>();
        String sql="SELECT * FROM Oferta;";
        try{
            Connection connect= ConexionDB.conexion();
            PreparedStatement select=connect.prepareStatement(sql);
            ResultSet result=select.executeQuery();
            while(result.next()){
                lista.add(result.getString(2));
            }
            result.close();
            select.close();
            connect.close();
        }catch(SQLException e){
            System.out.println("Error con SQL"+sql);
        }
        return lista;
    }
    
    public static String getId(String nombre){
        String id=null;
        String sql="SELECT * FROM Oferta Where Nombre='"+nombre+"';";
        try{
            Connection connect= ConexionDB.conexion();
            PreparedStatement select=connect.prepareStatement(sql);
            ResultSet result=select.executeQuery();
            while(result.next()){
                id=result.getString(1);
            }
            result.close();
            select.close();
            connect.close();
        }catch(SQLException e){
            System.out.println("Error con SQL"+e);
        }
        return id;
    }
}
