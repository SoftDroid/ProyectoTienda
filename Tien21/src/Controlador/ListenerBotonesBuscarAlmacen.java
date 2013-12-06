
package Controlador;

import Vista.Buscar;
import Vista.Inicio;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ListenerBotonesBuscarAlmacen implements ActionListener {
    private Inicio frame;
    private JTextField campo;
    private Buscar ventana;

    public ListenerBotonesBuscarAlmacen(JTextField campo, Inicio frame,Buscar ventana) {
        this.campo=campo;
        this.frame=frame;
        this.ventana=ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        String valor=this.campo.getText().trim();
        switch(s){
            case "buscarNombre":
                frame.buscarAlmacen("nombre", valor);
                ventana.dispose();
                break;
            case "buscarCodigo":
                frame.buscarAlmacen("codigo", valor);
                ventana.dispose();
                break;
        }
    }
    
}
