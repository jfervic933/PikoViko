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
    
    R21(21, 1, new ImageIcon());
    
    private final int valor;
    private final int numeroGusanos;
    private final ImageIcon imagen;

    private Racion(int valor, int numeroGusanos, ImageIcon imagen) {
        this.valor = valor;
        this.numeroGusanos = numeroGusanos;
        this.imagen = imagen;
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
    
}
