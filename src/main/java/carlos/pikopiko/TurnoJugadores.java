/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlos.pikopiko;

import static carlos.pikopiko.VentanaJuego.turnoJugador;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author carlos
 */
public class TurnoJugadores {

    // Guarda la lista de jugadores
    private ArrayList<Jugador> listaJugadores;
    // Guarda el número del jugador al que le toca (0,1,2,3)
    // de un máximo de cuatro jugadores
    public static int turnoJugador;

    public TurnoJugadores(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
        // Aleatoriamente selecciono uno para que comience su turno
        Random aux = new Random();
        turnoJugador = aux.nextInt(this.listaJugadores.size());
        // Establece el turno de ese jugador
        this.listaJugadores.get(turnoJugador).setTurno(true);
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public static int getTurnoJugador() {
        return turnoJugador;
    }
    
    public Jugador getJugadorTurno(){
        return this.listaJugadores.get(turnoJugador);
    }
    
    public void pasarSiguiente(){
        // Quita el turno del jugador que lo tiene
        this.listaJugadores.get(turnoJugador).setTurno(false);
        // Establece el siguiente jugador
        turnoJugador++;
        if (turnoJugador == this.listaJugadores.size()){
            turnoJugador = 0;
        }
        // Establece que el nuevo jugador tiene el turno
        this.listaJugadores.get(turnoJugador).setTurno(true);
    }
    
    public static void main(String[] args) {
        Jugador a = new Jugador("PEpe");
        Jugador b = new Jugador ("juan");
        Jugador c = new Jugador("lucas");
        Jugador d = new Jugador ("Inma");
        
        ArrayList<Jugador> lista = new ArrayList<>();
        lista.add(a);
        lista.add(b);
        lista.add(c);
        lista.add(d);

        TurnoJugadores t = new TurnoJugadores(lista);
        for (int i = 0; i<12;i++){
            System.out.println(t.getJugadorTurno().getNombre());
            t.pasarSiguiente();
        }
    }
}
