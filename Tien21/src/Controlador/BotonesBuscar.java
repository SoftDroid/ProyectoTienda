
package Controlador;

import Vista.Inicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonesBuscar implements ActionListener {
    private String valor;
    private Inicio frame;
    private int aux;
    public BotonesBuscar(String valor) {
        this.valor=valor;
    }

    public BotonesBuscar(String valor, Inicio frame, int aux) {
        this.valor=valor;
        this.frame=frame;
        this.aux=aux;
        System.out.println(valor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s=e.getActionCommand();
        switch(s){
            case "buscarNombre":
                if(aux==1){
                    frame.buscarVenta("nombre", valor);
                }else{
                    frame.buscarAlmacen("nombre", valor);
                }
                frame.buscarAlmacen("nombre", valor);
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
