
package Modelo;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class ModeloCombo extends DefaultComboBoxModel{
    private ArrayList lista;

    public ModeloCombo(){
        this.lista=new ArrayList ();
    }
    
     public ModeloCombo(ArrayList list){
        this.lista=list;
    }
    
    @Override
    public int getSize() {
        return this.lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.lista.get(index);
    }
    
    public void addElement(Object element){
        this.lista.add(element);
        this.fireIntervalRemoved(this,this.lista.size(),this.lista.size()+1);
    }
    
    public void removeElement(Object element){
        this.lista.remove(element);
        this.fireIntervalAdded(this,this.lista.size(),this.lista.size()-1);
    }    
}