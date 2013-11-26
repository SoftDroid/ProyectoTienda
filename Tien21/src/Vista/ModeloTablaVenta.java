
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
      public String getColumnName(int col){
        return columnas[col].toString();
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
    
     public Class getColumnClass(int columIndex){
        return types[columIndex];
    }
    
    public boolean isCellEditable(int row, int col) { 
        boolean editar = false;
         if(col==columnas.length-1)
            editar=true;
         
    return editar;}
    
    public void setValueAt(Object value,int row,int col){
        Object[]fila=(Object[]) datos.get(row);
        fila[col]=value;
        fireTableCellUpdated(row,col);
    }
    
    public void addRow(Object [] fila){
        datos.add(fila);
        fireTableDataChanged();
    }
    
    public void removeRow (int fila){
        datos.remove(fila);
        fireTableDataChanged();
    }
    
}
