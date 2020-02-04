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
    private Dado[] dadosSeleccionados;
    private boolean turno;
    private PilaRaciones misRaciones;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tiradaDados = new Dado[8];
        this.dadosSeleccionados = new Dado[8];
        // Rellena el array de dados del jugador
        for (int i = 0; i < tiradaDados.length; i++) {
            tiradaDados[i] = new Dado();
        }
        turno = false;
        misRaciones = new PilaRaciones();
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
        dadosSeleccionados[numeroDado] = tiradaDados[numeroDado];
        System.out.println("Dados seleccionados: " + numeroDado);
        System.out.println("Valor de ese dado: " + dadosSeleccionados[numeroDado].getCaraSeleccionada());

    }

    public int getValorSeleccionados() {
        int acumulador = 0;
        for (Dado aux : dadosSeleccionados) {
            //Si hay dado seleccionado
            if (aux != null) {
                int valor = aux.getCaraSeleccionada() == 6 ? 5 : aux.getCaraSeleccionada();
                acumulador += valor;
            }
        }
        return acumulador;
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

    public boolean todosBloqueados() {
        for (Dado aux : tiradaDados) {
            if (!aux.isBloqueado()) {
                return false;
            }
        }
        return true;
    }

    // El jugador guarda en su pila de raciones la Racion 
    // especificada en r de la parrilla de raciones
    public boolean cogerRacion(Parrilla parrilla, Racion r) {
        // Obtengo el valor de dados seleccionados del jugador
        int valorSeleccionados = this.getValorSeleccionados();
        // Si es un valor válido
        if (valorSeleccionados >= 21 && valorSeleccionados <= 36) {
            // Compruebo que esa ración está en la parrilla
            Racion aux = parrilla.getRacionParrilla(valorSeleccionados);
            // Si la ración no es null significa que existe en la parrilla
            if (aux != null) {
                if (aux.isDisponible()) {
                    System.out.println("El jugador coge la ración de valor " + r.getValor());
                    // Guardo la ración en la pila del jugador
                    this.misRaciones.ponerRacion(r);
                    // La pongo no disponible
                    aux.ocultarRacion();
                    System.out.println("Ahora la ración en la parrilla está " + aux.isDisponible());
                    return true;
                }
            }
        }
        return false;
    }
}
