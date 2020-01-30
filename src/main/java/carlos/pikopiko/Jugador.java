/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlos.pikopiko;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Jugador {

    private String nombre;
    private Dado[] tiradaDados;
    private boolean turno;
    private ArrayList<Ficha> misFichas;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tiradaDados = new Dado[8];
        // Rellena el array de dados del jugador
        for (int i = 0; i < tiradaDados.length; i++) {
            tiradaDados[i] = new Dado();
        }
        turno = false;
        misFichas = new ArrayList<>();
    }

    // Tira de nuevo los dados no seleccionados
    public void tirarDados() {
        for (Dado aux : tiradaDados) {
            if (!aux.isBloqueado()) {
                aux.moverDado();
            }
        }
    }

    // Selecciona ese dado y lo bloquea
    public void seleccionarDado(int numeroDado) {
        tiradaDados[numeroDado].bloquear();
    }

    // Establece si le toca o no al jugador
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public Dado[] getTiradaDados() {
        return tiradaDados;
    }

    public boolean isTurno() {
        return turno;
    }

    public ArrayList<Ficha> getMisFichas() {
        return misFichas;
    }
}
