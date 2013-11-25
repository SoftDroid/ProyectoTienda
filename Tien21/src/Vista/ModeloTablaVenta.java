
package Vista;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class ModeloTablaVenta extends AbstractTableModel {

    ArrayList datos = new ArrayList();
    String [] columnas = {"Nombre", "Precio", "Cantidad"};
     Class[] types = new Class[]{
            java.lang.String.class, java.lang.Integer.class,
            java.lang.Integer.class};
     
     public ModeloTablaVenta(ArrayList list){
            
         this.datos = list;
     
                                      }
     
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
       return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Object[] element = (Object[]) datos.get(rowIndex);
        return element[columnIndex];
    }
    
    
    
}
