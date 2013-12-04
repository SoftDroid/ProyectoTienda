
package Controlador;

import Vista.Inicio;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class BotonesBuscar implements ActionListener {
    private Inicio frame;
    private int aux;
    private JTextField campo;

    public BotonesBuscar(JTextField campo, Inicio frame, int aux) {
        this.campo=campo;
        this.frame=frame;
        this.aux=aux;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        String valor=this.campo.getText().trim();
        switch(s){
            case "buscarNombre":
                if(aux==1){
                    frame.buscarVenta("nombre", valor);
                }else{
                    frame.buscarAlmacen("nombre", valor);
                }
                break;
            case "buscarCodigo":
                if(aux==1){
                    frame.buscarVenta("codigo", valor);
                }else{
                    frame.buscarAlmacen("codigo", valor);
                }
                
                break;
        }
    }
    
}
