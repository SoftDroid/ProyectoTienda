
package Vista;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaProductos extends AbstractTableModel {
    ArrayList datos = new ArrayList();
    String [] nombreCol= new String[] {"Codigo","Nombre","Precio Proveedor","Precio Venta","Temporada","Color","Talla","Familia","SubFamilia","Stock","Oferta","Descatalogado"};
    Class [] type = new Class[]{java.lang.String.class,java.lang.String.class,java.lang.Double.class,java.lang.Double.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.String.class,java.lang.Integer.class,java.lang.Integer.class,java.lang.Boolean.class};

    public ModeloTablaProductos(ArrayList list){
        this.datos=list;
    }
    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return nombreCol.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object [] elemento=(Object[])datos.get(rowIndex);
        return elemento[columnIndex];
    }
    
    @Override
    public String getColumnName(int col){
        return nombreCol[col];
    }
    
    @Override
    public Class getColumnClass(int col){
        return type[col];
    }
    
    @Override
    public void setValueAt(Object elemento,int row,int col){
        Object[]fila=(Object[]) datos.get(row);
        fila[col]=elemento;
        fireTableCellUpdated(row,col);
    }
    
    public void anadirFila(Object [] fila){
        datos.add(fila);
        fireTableDataChanged();
    }
    
    public void borrarFila(int fila){
        datos.remove(fila);
        fireTableDataChanged();
    }
    
    public boolean inCellEditable(int row, int col){
        boolean editable;
        if(col==nombreCol.length-1)
            editable=true;
        else
            editable=false;

        return editable;
    }
}
