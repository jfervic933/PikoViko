/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlos.pikopiko;

import javax.swing.JTextArea;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public class Mensajes {
    
    private JTextArea mensaje;

    public Mensajes(JTextArea mensaje) {
        this.mensaje = mensaje;
    }
    
    public void bienvenida(String nombreJugador){
        this.mensaje.setText("Bienvenido al Juego del Piko Piko.\n"
                    + "Comienza el jugador: ... " + nombreJugador
                    + " lanzando los dados...");
    }
    public void dadosDiferentes(){
        this.mensaje.setText("La selección de dados que has realizado tiene"
                + "dados de diferente valor");
    }
    
}
