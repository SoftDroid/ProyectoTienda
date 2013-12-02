
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TallaDB {
     public static ArrayList <String> getTallas(){
        ArrayList <String> lista=new ArrayList <String>();
        String sql="SELECT * FROM Talla;";
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
}
