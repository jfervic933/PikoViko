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
public enum CaraDado {
    
    UNO (1, 1, new ImageIcon("resources/carauno.png")),
    DOS (2, 2, new ImageIcon("resources/carados.png")),
    TRES (3, 3, new ImageIcon("resources/caratres.png")),
    CUATRO (4, 4, new ImageIcon("resources/caracuatro.png")),
    CINCO (5, 5, new ImageIcon("resources/caracinco.png")),
    GUSANO (6, 5, new ImageIcon("resources/caragusano.png"));
    
    private final int id;
    private final int puntos;
    private final ImageIcon imagen;
    
    private CaraDado(int id, int puntos, ImageIcon imagen){
        this.id = id;
        this.puntos = puntos;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public ImageIcon getImagen() {
        return imagen;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
}
