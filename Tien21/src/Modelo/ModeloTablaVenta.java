package Modelo;

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
        Object [] elemento=(Object[])datos.get(rowIndex);
        return elemento[columnIndex];
    }
    
    @Override
    public String getColumnName(int col){
        return columnas[col];
    }
    
    @Override
    public Class getColumnClass(int col){
        return types[col];
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
        if(col==columnas.length-1)
            editable=true;
        else
            editable=false;

        return editable;
    }
}
