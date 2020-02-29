package carlos.pikopiko;

import java.util.ArrayList;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public class Jugador {

    // Atributos del jugador
    private final String nombre;
    private final Dado[] tiradaDados;
    private final Dado[] dadosSeleccionados;
    private boolean turno;
    private final PilaRaciones misRaciones;
    private boolean tieneGusano;
    private int contadorNoBloqueados;

    // Constructor del jugador en función del nombre
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.tiradaDados = new Dado[8];
        this.dadosSeleccionados = new Dado[8];
        // Rellena el array de dados del jugador
        for (int i = 0; i < tiradaDados.length; i++) {
            tiradaDados[i] = new Dado();
        }
        turno = false;
        tieneGusano = false;
        misRaciones = new PilaRaciones();
    }

    // Mueve los dados no seleccionados y los cuenta
    public void tirarDados() {
        // Mueve los dados no bloqueados
        contadorNoBloqueados = 0;
        for (Dado aux : tiradaDados) {
            if (!aux.isBloqueado()) {
                contadorNoBloqueados++;
                aux.moverDado();
            }
        }
    }

    // Este método devuelve si la tirada es fallida o no
    // Se mira si en la tirada se han sacado todos los valores 
    // que ya estaban bloqueados, entonces tirada fallida
    public boolean tiradaFallida() {
        int contador = 0;
        for (Dado aux : tiradaDados) {
            if (!aux.isBloqueado()) {
                for (Dado aux2 : tiradaDados) {
                    if (aux != aux2
                            && aux2.isBloqueado()
                            && aux.getCaraSeleccionada() == aux2.getCaraSeleccionada()) {
                        contador++;
                        break;
                    }
                }
            }
        }
        // True si la tirada es fallida
        return (contador == contadorNoBloqueados);
    }

    // Selecciona ese dado y lo bloquea
    public void seleccionarDado(int numeroDado) {
        tiradaDados[numeroDado].bloquear();
        dadosSeleccionados[numeroDado] = tiradaDados[numeroDado];
        if (dadosSeleccionados[numeroDado].getCaraSeleccionada() == 6) {
            tieneGusano = true;
        }
    }

    public boolean tieneGusano() {
        return tieneGusano;
    }

    public PilaRaciones getMisRaciones() {
        return misRaciones;
    }

    public void quitarGusano() {
        tieneGusano = false;
    }

    // Suma los valores de los dados seleccionados del jugador y lo devuelve
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

    public Dado[] getDadosSeleccionados() {
        return dadosSeleccionados;
    }

    // Indica si todos los dados de la tirada están bloqueados
    public boolean todosBloqueados() {
        for (Dado aux : tiradaDados) {
            if (!aux.isBloqueado()) {
                return false;
            }
        }
        return true;
    }

    // Este método sirve para reiniciar los dados cuando se cambia el turno
    public void desbloquearDados() {
        for (int i = 0; i < tiradaDados.length; i++) {
            tiradaDados[i].desbloquear();
            dadosSeleccionados[i] = null;
        }
    }

    // Método que roba una ración en función de los valores de dados del
    // jugador. Si no hay ningún jugador al que robar devuelve false
    public boolean robarRacion(TurnoJugadores turno) {
        // Obtengo el valor de dados seleccionados del jugador
        int valorSeleccionados = this.getValorSeleccionados();
        // Si es un valor válido
        if (valorSeleccionados >= Parrilla.VALOR_RACION_INICIAL
                && valorSeleccionados < Parrilla.VALOR_RACION_INICIAL + Parrilla.NUMERO_RACIONES) {

            ArrayList<Jugador> listaJugadores = turno.getListaJugadores();
            // Recorre la lista de jugadores buscando otros jugadores que 
            // puedan tener la ración
            for (Jugador j : listaJugadores) {
                if (j != this) {
                    Racion aux = j.getMisRaciones().consultarUltimaRacion();
                    // Se puede robar
                    if (aux!=null && aux.getValor() == valorSeleccionados) {
                        // Se la quito al jugador que la tiene
                        j.getMisRaciones().sacarRacion();
                        // Se la pongo al jugador que le toca
                        this.misRaciones.ponerRacion(aux);
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    // El jugador guarda en su pila de raciones la Racion 
    // que indique la suma de sus dados. Si la ración no existe en la 
    // parrilla entonces debe robarla o coger una de menor valor
    public boolean cogerRacion(Parrilla parrilla) {
        Racion aux = null;
        // Obtengo el valor de dados seleccionados del jugador
        int valorSeleccionados = this.getValorSeleccionados();
        // Si es un valor válido
        if (valorSeleccionados >= Parrilla.VALOR_RACION_INICIAL
                && valorSeleccionados < Parrilla.VALOR_RACION_INICIAL + Parrilla.NUMERO_RACIONES) {

            // Busco en la parrilla si está esa ración
            if (this.existeRacionEnParrilla(valorSeleccionados, parrilla)) { //Existe
                aux = parrilla.getRacionParrilla(valorSeleccionados);
                // Guardo la ración en la pila del jugador
                this.misRaciones.ponerRacion(aux);
                // Se elimina de la parrilla
                parrilla.borrarRacion(aux);
                // La pongo no disponible
                //aux.ocultarRacion();
                System.out.println("El jugador " + this.nombre + " coge la racion "
                        + aux.name());
                return true;
            } else {
                System.out.println("Esa racion no existe en la parrilla" + valorSeleccionados);
            }
        }
        return false;
    }
    
    // Coge una ración menor al valor que indican sus dados
    // En caso de éxito devuelve true
    public boolean cogerRacionMenor(Parrilla parrilla){
        // Obtengo el valor de dados seleccionados del jugador
        int valorSeleccionados = this.getValorSeleccionados();
        Racion aux = null;
        // Si es un valor válido
        if (valorSeleccionados >= Parrilla.VALOR_RACION_INICIAL
                && valorSeleccionados < Parrilla.VALOR_RACION_INICIAL + Parrilla.NUMERO_RACIONES) {
            // Si no está en la parrilla tengo que recorrer hasta encontrar la inmediatamente menor
            if (!this.existeRacionEnParrilla(valorSeleccionados, parrilla)) { //No existe
                 // No existe en la parrilla, intenta coger una menor
                aux = parrilla.buscarRacionMenor(valorSeleccionados);
                // Si existe una menor
                if (aux!=null){
                    this.misRaciones.ponerRacion(aux);
                    parrilla.borrarRacion(aux);
                    return true;
                }else{
                    System.out.println("No existe ninguna ración menor a ese valor");
                }
            } else {
                // Existe en la parrilla
                System.out.println("Esa racion existe en la parrilla" + valorSeleccionados);
            }
        }
        return false;
    }
    
    public Racion devolverRacion(Parrilla parrilla) {
        // Saca la última ración que tiene el jugador
        Racion racion = this.getMisRaciones().sacarRacion();
        if (racion != null) {
            return parrilla.devolverRacion(racion);

        }
        return null;
    }

    public boolean existeRacionEnParrilla(int valorBuscar, Parrilla parrilla) {
        return parrilla.existeRacion(valorBuscar);
    }

    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", turno=" + turno + ", misRaciones=" + misRaciones.toString() + ", tieneGusano=" + tieneGusano + '}';
    }

}
