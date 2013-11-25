package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDB {
    private final String USER="User";
    private final String PASS="Pass";
    private final String USUARIO="usuario";
 
    public boolean authenticate(String user,String password){
        boolean authenticate=false;
        String sql="SELECT * FROM "+USUARIO+" WHERE "+USER+"='"+user+"' && "+PASS+"='"+password+"'";
        try{
            Connection connect= ConexionDB.conexion();
            PreparedStatement select=connect.prepareStatement(sql);
            ResultSet result=select.executeQuery();
            if(result.next()){
                if(result.getString(USER).equals(user))
                    authenticate=true;
            }
            result.close();
            select.close();
            connect.close();
        }catch(SQLException e){
            System.out.println("Error con SQL"+sql);
        }
        return authenticate;
    }
}
