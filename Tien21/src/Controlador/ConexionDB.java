
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class ConexionDB {
    private static Connection conexion;
    private Statement st;

    public static Connection conexion(){
        conexion=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String servidor="jdbc:mysql://localhost/tien21";
            String usuarioDB="root";
            String passwordDB="";
            conexion=(Connection)DriverManager.getConnection(servidor,usuarioDB,passwordDB);
            
        }catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }finally
        {
            return conexion;
        }
    }
}
