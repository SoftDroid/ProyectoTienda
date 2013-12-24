
package Modelo;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class renderTabla implements TableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel etiqueta=new JLabel();
        if(value instanceof Boolean){
            boolean valor= ((boolean)value);
            if(valor){
                ImageIcon im= new ImageIcon(getClass().getResource("/Recursos/si.png"));
                etiqueta.setIcon(im);
            }else{
            }
                
        }
        return etiqueta;
    }
    
}
