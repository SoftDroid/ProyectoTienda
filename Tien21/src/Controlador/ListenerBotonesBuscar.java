
package Controlador;

import Vista.AñadirPedido;
import Vista.Buscar;
import Vista.Inicio;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ListenerBotonesBuscar implements ActionListener {
    private Inicio inicio;
    private JTextField campo;
    private Buscar ventana;
    private AñadirPedido anadirPedido;

    public ListenerBotonesBuscar(JTextField campo, Inicio padre,Buscar ventana) {
        this.campo=campo;
        this.inicio=padre;
        this.ventana=ventana;
        this.anadirPedido=null;
    }

    public ListenerBotonesBuscar(JTextField campo, AñadirPedido padre, Buscar aThis) {
        this.campo=campo;
        this.inicio=null;
        this.ventana=aThis;
        this.anadirPedido=padre;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        String valor=this.campo.getText().trim();
        switch(s){
            case "buscarNombre":
                if(inicio!=null){
                    inicio.buscarAlmacen("nombre", valor);
                    ventana.dispose();
                }else {
                    anadirPedido.buscarElementoPedido("nombre", valor);
                    ventana.dispose();
                }
                break;
            case "buscarCodigo":
                if(inicio!=null){
                    inicio.buscarAlmacen("codigo", valor);
                ventana.dispose();
                }else {
                    anadirPedido.buscarElementoPedido("codigo", valor);
                    ventana.dispose();
                }
                break;
        }
    }
    
}
