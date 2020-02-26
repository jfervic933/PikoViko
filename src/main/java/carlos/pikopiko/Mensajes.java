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

    public void bienvenida(String nombreJugador) {
        this.mensaje.setText("Bienvenido al Juego del Piko Piko.\n"
                + "Comienza el jugador: ... " + nombreJugador
                + " lanzando los dados...");
    }

    public void dadosDiferentes() {
        this.mensaje.setText("La selección de dados que has realizado tiene"
                + " dados de diferente valor. Prueba a realizar otra selección");
    }

    public void dadoSeleccionadoPreviamente() {
        this.mensaje.setText("Ese valor de dado ya se seleccionó "
                + "con anterioridad en otra jugada. Prueba a realizar otra selección");
    }

    public void noHayDadosSeleccionados() {
        this.mensaje.setText("No hay dados seleccionados porque no has "
                + " cogido ninguno o porque ya están todos seleccionados."
                + "Prueba a realizar otra selección o a coger una ración,"
                + " robar una ración o terminar tu turno");
    }

    public void faltanDadosPorSeleccionar() {
        this.mensaje.setText("La selección está incompleta. Selecciona todos"
                + " los dados del mismo valor");
    }

    public void todosDadosBloqueados() {
        this.mensaje.setText("No te quedan dados. Debes"
                + "\tA - Coger una ración\n"
                + "\tB - Robar una ración\n"
                + "\tC - Terminar tu turno");
    }

    public void noPuedeCogerRacion() {
        this.mensaje.setText("Sin al menos un dado de gusano no puedes coger"
                + " ninguna ración de gusanos");
    }

    public void hayQueSeleccionarGruposDeDados() {
        this.mensaje.setText("Si hay parejas, tríos o grupos de dados no se "
                + "puede seleccionar un solo dado, a menos que sea un gusano");
    }
    
    public void tiradaFallida(){
        this.mensaje.setText("Has realizado una tirada fallida. Debes devolver"
                + " una ración de gusanos de tu pila o si no tienes terminar tu turno");
    }
    
    public void todosSeleccionados(){
        this.mensaje.setText("Ya no quedan dados por tirar.\n "
                + "Ahora debes coger una ración, robar o bien terminar tu turno");
    }
    
    public void racionNoExisteEnParrilla(){
        this.mensaje.setText("La ración no existe en la parrilla. Prueba a robarla " 
                + "o a coger una de menor valor");
    }
    
    public void informarTurno(String nombreJugador){
        this.mensaje.setText("SE CAMBIA EL TURNO AL JUGADOR: " + nombreJugador);
    }
}
