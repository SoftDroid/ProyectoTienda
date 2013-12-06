
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
    

public class ProductoDB {

    public ArrayList<Object> mostrarAlmacen(){
        ArrayList<Object> lista=new ArrayList<Object>();
        String sql="SELECT p.Nombre, p.Codigo, p.Stock,p.Descatalogado,c.Color, f.Nombre, o.Descuento , sf.Nombre,ta.Talla, t.Nombre ,p.PrecioProveedor, p.PrecioVenta FROM producto p,color c, temporada t, subfamilia sf, familia f,talla ta,oferta o WHERE p.Temporada_idTemporada= t.idTemporada and p.Color_idColor=c.idColor and p.Talla_idTalla=ta.idTalla and p.SubFAmilia_idSubFamilia=sf.idSubfamilia and f.idFamilia=sf.Familia_idFamilia and p.Oferta_idOferta=o.idOferta";
        try{
            Connection conexion=ConexionDB.conexion();
            Statement st=conexion.createStatement();
            ResultSet result=st.executeQuery(sql);
            while(result.next()){
                String nombre=result.getString(1);
                String codigo=result.getString(2);
                int stock=Integer.parseInt(result.getString(3));
                boolean descatalogado=Boolean.parseBoolean(result.getString(4));
                String color=result.getString(5);
                String familia=result.getString(6);
                int oferta=Integer.parseInt(result.getString(7));
                String subFamilia=result.getString(8);
                String talla=result.getString(9);
                String temporada=result.getString(10);
                double precioPro=Double.parseDouble(result.getString(11));
                double precioVe=Double.parseDouble(result.getString(12));
                Object[]producto=new Object[]{codigo,nombre,precioPro,precioVe,temporada,color,talla,familia,subFamilia,stock,oferta,descatalogado};
                lista.add(producto);
            }
        }catch(Exception e){
            System.out.println("Error pDB "+e);
        }
        return lista;
    }
    
    public ArrayList <Object> buscarNombre(String nombreBuscar){
        ArrayList<Object> lista=new ArrayList<Object>();
        String sql="SELECT p.Nombre, p.Codigo, p.Stock,p.Descatalogado,c.Color, f.Nombre, o.Descuento , sf.Nombre,ta.Talla, t.Nombre ,p.PrecioProveedor, p.PrecioVenta FROM producto p,color c, temporada t, subfamilia sf, familia f,talla ta,oferta o WHERE p.Temporada_idTemporada= t.idTemporada and p.Color_idColor=c.idColor and p.Talla_idTalla=ta.idTalla and p.SubFAmilia_idSubFamilia=sf.idSubfamilia and f.idFamilia=sf.Familia_idFamilia and p.Oferta_idOferta=o.idOferta and p.Nombre='"+nombreBuscar+"';";
        try{
            Connection conexion=ConexionDB.conexion();
            Statement st=conexion.createStatement();
            ResultSet result=st.executeQuery(sql);
            while(result.next()){
                String nombre=result.getString(1);
                String codigo=result.getString(2);
                int stock=Integer.parseInt(result.getString(3));
                boolean descatalogado=Boolean.parseBoolean(result.getString(4));
                String color=result.getString(5);
                String familia=result.getString(6);
                int oferta=Integer.parseInt(result.getString(7));
                String subFamilia=result.getString(8);
                String talla=result.getString(9);
                String temporada=result.getString(10);
                double precioPro=Double.parseDouble(result.getString(11));
                double precioVe=Double.parseDouble(result.getString(12));
                Object[]producto=new Object[]{codigo,nombre,precioPro,precioVe,temporada,color,talla,familia,subFamilia,stock,oferta,descatalogado};
                lista.add(producto);
            }
        }catch(Exception e){
            System.out.println("Error pDB "+e);
        }
        return lista;
    }
    
    public ArrayList <Object> buscarCodigo(String codigoBuscar){
        ArrayList<Object> lista=new ArrayList<Object>();
        String sql="SELECT p.Nombre, p.Codigo, p.Stock,p.Descatalogado,c.Color, f.Nombre, o.Descuento , sf.Nombre,ta.Talla, t.Nombre ,p.PrecioProveedor, p.PrecioVenta FROM producto p,color c, temporada t, subfamilia sf, familia f,talla ta,oferta o WHERE p.Temporada_idTemporada= t.idTemporada and p.Color_idColor=c.idColor and p.Talla_idTalla=ta.idTalla and p.SubFAmilia_idSubFamilia=sf.idSubfamilia and f.idFamilia=sf.Familia_idFamilia and p.Oferta_idOferta=o.idOferta and p.Codigo='"+codigoBuscar+"';";
        try{
            Connection conexion=ConexionDB.conexion();
            Statement st=conexion.createStatement();
            ResultSet result=st.executeQuery(sql);
            while(result.next()){
                String nombre=result.getString(1);
                String codigo=result.getString(2);
                int stock=Integer.parseInt(result.getString(3));
                boolean descatalogado=Boolean.parseBoolean(result.getString(4));
                String color=result.getString(5);
                String familia=result.getString(6);
                int oferta=Integer.parseInt(result.getString(7));
                String subFamilia=result.getString(8);
                String talla=result.getString(9);
                String temporada=result.getString(10);
                double precioPro=Double.parseDouble(result.getString(11));
                double precioVe=Double.parseDouble(result.getString(12));
                Object[]producto=new Object[]{codigo,nombre,precioPro,precioVe,temporada,color,talla,familia,subFamilia,stock,oferta,descatalogado};
                lista.add(producto);  
            }
        }catch(Exception e){
            System.out.println("Error pDB "+e);
        }
        return lista;
    }
    
    public static void insertar(String sql){
        Connection conexion=ConexionDB.conexion();
        try{
            Statement st=conexion.createStatement();
            st.executeUpdate(sql);
        }catch(Exception e){
            System.out.println("Error pDB "+e);
        }
    }
}
