
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ProveedoresDB {
    public static ArrayList<String> listaProveedores(){
        ArrayList <String> lista=new ArrayList<String>();
        Connection conexion =ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            String sql="SELECT nombre FROM proveedor";
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                lista.add(rs.getString(1));
            }
        }catch(Exception e){
            System.out.println("Error");
        }
        return lista;
    }
}
