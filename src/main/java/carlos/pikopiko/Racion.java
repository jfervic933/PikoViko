/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlos.pikopiko;

import javax.swing.ImageIcon;

/**
 *
 * @author carlos
 */
public enum Racion {
    
    R21(21, 1, new ImageIcon("resources/r21.png")),
    R22(22, 1, new ImageIcon("resources/r22.png")),
    R23(23, 1, new ImageIcon("resources/r23.png")),
    R24(24, 1, new ImageIcon("resources/r24.png"));
    
    private final int valor;
    private final int numeroGusanos;
    private final ImageIcon imagen;
    private boolean disponible; // La ración está dada la vuelta o no

    private Racion(int valor, int numeroGusanos, ImageIcon imagen) {
        this.valor = valor;
        this.numeroGusanos = numeroGusanos;
        this.imagen = imagen;
        this.disponible = true;
    }

    public int getValor() {
        return valor;
    }

    public int getNumeroGusanos() {
        return numeroGusanos;
    }

    public ImageIcon getImagen() {
        return imagen;
    }
    
    // Este método hace que la Racion quede fuera del juego
    public void ocultarRacion(){
        this.disponible = false;
    }
}
