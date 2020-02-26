
package carlos.pikopiko;

import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public class Dado {

    // Atributos del dado
    private int caraSeleccionada;
    private ImageIcon imagen;
    private boolean bloqueado;
    
    // Este atributo es para generar números aleatorios
    // No es un atributo propio del dado
    private static final Random ALEATORIOS = new Random();

    // Constructor por defecto crea un dado con su cara seleccionada
    // con valor 1 y no bloqueado
    public Dado() {
        this.caraSeleccionada = CaraDado.UNO.getId();
        this.imagen = CaraDado.UNO.getImagen();
        this.bloqueado = false;
    }

    // Este método simula el lanzamiento, de forma que cada vez que
    // se llame, cambia el valor de los atributos
    public void moverDado() {
        int valor = ALEATORIOS.nextInt(6) + 1; // Entre 1 y 6
        switch (valor) {
            case 1:
                this.caraSeleccionada = CaraDado.UNO.getId();
                this.imagen = CaraDado.UNO.getImagen();
                break;
            case 2:
                this.caraSeleccionada = CaraDado.DOS.getId();
                this.imagen = CaraDado.DOS.getImagen();
                break;
            case 3:
                this.caraSeleccionada = CaraDado.TRES.getId();
                this.imagen = CaraDado.TRES.getImagen();
                break;
            case 4:
                this.caraSeleccionada = CaraDado.CUATRO.getId();
                this.imagen = CaraDado.CUATRO.getImagen();
                break;
            case 5:
                this.caraSeleccionada = CaraDado.CINCO.getId();
                this.imagen = CaraDado.CINCO.getImagen();
                break;
            default:
                this.caraSeleccionada = CaraDado.GUSANO.getId();
                this.imagen = CaraDado.GUSANO.getImagen();
                break;
        }
    }
   
    public ImageIcon getImagen(){
        return this.imagen;
    }
    public void setCaraSeleccionada(CaraDado cara){
        this.caraSeleccionada = cara.getId();
    }
    public int getCaraSeleccionada() {
        return this.caraSeleccionada;
    }
    public void bloquear(){
        this.bloqueado = true;
    }
    public void desbloquear(){
        this.bloqueado = false;
    }
    public boolean isBloqueado(){
        return this.bloqueado;
    }
}
