package carlos.pikopiko;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public class Jugador {

    private String nombre;
    private Dado[] tiradaDados;
    private Dado[] dadosSeleccionados;
    private boolean turno;
    private PilaRaciones misRaciones;
    private boolean tieneGusano;
    private int contadorNoBloqueados;

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

    // Tira de nuevo los dados no seleccionados
    // Devuelve el número de dados movidos
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
        
    // Miro si en la tirada he sacado valores que ya estaban bloqueados
    // entonces tirada fallida
    public boolean tiradaFallida(){
        int contador = 0;
        for (Dado aux : tiradaDados) {
            if (!aux.isBloqueado()) {
                for (Dado aux2: tiradaDados){
                    if (aux!=aux2 && 
                        aux2.isBloqueado() &&
                        aux.getCaraSeleccionada() == aux2.getCaraSeleccionada()){
                        contador++;
                        break;
                    }
                }
            }
        }
        System.out.println("Contador no bloqueado " + contadorNoBloqueados);
        System.out.println("Contador " + contador);
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

    public Dado[] getDadosSeleccionados() {
        return dadosSeleccionados;
    }

    public boolean todosBloqueados() {
        for (Dado aux : tiradaDados) {
            if (!aux.isBloqueado()) {
                return false;
            }
        }
        return true;
    }

    public void desbloquearDados() {
        for (int i = 0; i < tiradaDados.length; i++) {
            tiradaDados[i].desbloquear();
            dadosSeleccionados[i] = null;
        }
    }

    // El jugador guarda en su pila de raciones la Racion 
    // especificada en r de la parrilla de raciones
    public boolean cogerRacion(Parrilla parrilla, Racion r) {
        // Obtengo el valor de dados seleccionados del jugador
        int valorSeleccionados = this.getValorSeleccionados();
        // Si es un valor válido
        if (valorSeleccionados >= 21 && valorSeleccionados <= 36) {
            // Recorro todas las raciones posibles desde la que tenga el valor
            // seleccionado hasta la primera, porque puede que el jugador
            // se haya plantado con un valor que no está disponible pero
            // alguna ración anterior si que lo puede estar
            for (int i = valorSeleccionados; i >= Parrilla.VALOR_RACION_INICIAL; i--) {
                // Compruebo que esa ración está en la parrilla
                Racion aux = parrilla.getRacionParrilla(i);
                // Si la ración no es null significa que existe en la parrilla
                if (aux != null) {
                    if (aux.isDisponible()) { // La ración se puede coger
                        // Guardo la ración en la pila del jugador
                        this.misRaciones.ponerRacion(aux);
                        // La pongo no disponible
                        aux.ocultarRacion();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean devolverRacion(Parrilla parrilla){
        Racion racion = this.getMisRaciones().sacarRacion();
        parrilla.devolverRacion(racion);
        return true;
    }
    @Override
    public String toString() {
        return "Jugador{" + "nombre=" + nombre + ", turno=" + turno + ", misRaciones=" + misRaciones.toString() + ", tieneGusano=" + tieneGusano + '}';
    }

}
