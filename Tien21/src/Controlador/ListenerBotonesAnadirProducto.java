
package Controlador;

import Modelo.ColorDB;
import Modelo.FamiliaDB;
import Modelo.OfertaDB;
import Modelo.PedidoDB;
import Modelo.ProductoDB;
import Modelo.ProveedoresDB;
import Modelo.SubFamiliaDB;
import Modelo.TallaDB;
import Modelo.TemporadaDB;
import Vista.AñadirProducto;
import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;


public class ListenerBotonesAnadirProducto implements ActionListener {
    private AñadirProducto ventana;
    private JTextField nombre;
    private String codigo;
    private JTextField stock;
    private JTextField precioP;
    private JTextField precioV;
    private JComboBox temporada;
    private JComboBox familia;
    private JComboBox subFamilia;
    private JComboBox oferta;
    private JCheckBox checkOferta;
    private ArrayList<Object> listCheckColores;
    private ArrayList<Object> listCheckTallas;
    private JList listaProveedores;
    
    public ListenerBotonesAnadirProducto(AñadirProducto aThis) {
        this.ventana=aThis;
    }

    public ListenerBotonesAnadirProducto(AñadirProducto aThis, JTextField nombreAnadirProducto, JTextField stockAnadirProducto, JTextField precioPAnadirProducto, JTextField precioVAnadirProducto, JComboBox temporadaAnadirProducto, JComboBox familiaAnadirProducto, JComboBox subfaAnadirProducto, JCheckBox jCheckBoxOferta, JComboBox ofertaAnadirProducto, ArrayList<Object> listColores, ArrayList<Object> listTallas, JList listaProveedores) {
        this.ventana=aThis;
        this.nombre=nombreAnadirProducto;
        this.stock=stockAnadirProducto;
        this.precioP=precioPAnadirProducto;
        this.precioV=precioVAnadirProducto;
        this.temporada=temporadaAnadirProducto;
        this.familia=familiaAnadirProducto;
        this.subFamilia=subfaAnadirProducto;
        this.oferta=ofertaAnadirProducto;
        this.checkOferta=jCheckBoxOferta;
        this.listCheckColores=listColores;
        this.listCheckTallas=listTallas;
        this.listaProveedores=listaProveedores;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        switch(s){
            case "añadir":
                String sNombre=this.nombre.getText().trim();
                String sStock=this.stock.getText().trim();
                String sPrecioP=this.precioP.getText().trim();
                String sPrecioV=this.precioV.getText().trim();
                String sTemporada=TemporadaDB.getId((String) this.temporada.getSelectedItem());
                String sFamilia=FamiliaDB.getId((String) this.familia.getSelectedItem());
                String sSubFamilia=SubFamiliaDB.getId((String) this.subFamilia.getSelectedItem());
                String sOferta;
                String proveedor=(String) listaProveedores.getSelectedValue();
                if(this.checkOferta.isSelected()){
                    sOferta=OfertaDB.getId((String) this.oferta.getSelectedItem());
                }else{
                    sOferta="1";
                }
                ArrayList <String> listColor=new ArrayList <String>();
                ArrayList <String> listTalla=new ArrayList <String>();
                for(int cont=0;cont<listCheckColores.size();cont++){
                    Checkbox check=(Checkbox) listCheckColores.get(cont);
                    if(check.getState())
                        listColor.add(ColorDB.getId(check.getLabel()));
                }
                for(int cont=0;cont<listCheckTallas.size();cont++){
                    Checkbox check=(Checkbox) listCheckTallas.get(cont);
                    if(check.getState())
                        listTalla.add(TallaDB.getId(check.getLabel()));
                } 
                for(int cont=0;cont<listColor.size();cont++){
                    String sColor=listColor.get(cont);
                    for(int aux=0;aux<listTalla.size();aux++){
                        String sTalla=listTalla.get(aux);
                        this.codigo=generarCodigo();
                        int idProveedor= ProveedoresDB.getId(proveedor);
                        String sql="INSERT INTO `producto` (`Nombre`, `Codigo`, `PrecioProveedor`, `PrecioVenta`, `Temporada_idTemporada`, `Color_idColor`, `Talla_idTalla`, `SubFamilia_idSubFamilia`, `Descatalogado`, `Stock`, `Oferta_idOferta`, `Proveedor_idProveedor`) VALUES ('"+sNombre+"', '"+this.codigo+"', '"+sPrecioP+"', '"+sPrecioV+"', '"+sTemporada+"', '"+sColor+"', '"+sTalla+"', '"+sSubFamilia+"', '0', '"+sStock+"', '"+sOferta+"','"+idProveedor+"')";
                        System.out.println(sql);
                        ProductoDB.insertar(sql);
                    }
                }
            case "cancelar":
                ventana.dispose();
                break;
        }
    }

    private String generarCodigo() {
       boolean existe=false;
       String newCodigo=null;
       while(!existe){
           newCodigo=this.codigo();
           ArrayList<String> listaCodigos=ProductoDB.listaCodigo();
           existe=true;
           for(int cont=0;cont<listaCodigos.size();cont++){
               if(newCodigo.equals(listaCodigos.get(cont)))
                   existe=false;
           }
       }
       return newCodigo;
    }

    private String codigo() {
        String s="";
		for(int cont=0;cont<6 ;cont++){
			int num=(int)(Math.random()*2);
			if(num==0){
				s=s+mayusculas();
			}else
				s=s+numero();
		}
		return s;
    }
    
    public char mayusculas(){
	return (char)((Math.random()*26)+65);
    }
	
    public char numero(){
	return (char)((Math.random()*10)+48);
    }
    
}
