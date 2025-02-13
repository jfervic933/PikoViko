package carlos.pikopiko;

import javax.swing.ImageIcon;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public enum Racion {
    
    R21(21, 1, new ImageIcon("resources/r21.png")),
    R22(22, 1, new ImageIcon("resources/r22.png")),
    R23(23, 1, new ImageIcon("resources/r23.png")),
    R24(24, 1, new ImageIcon("resources/r24.png")),
    R25(25, 2, new ImageIcon("resources/r25.png")),
    R26(26, 2, new ImageIcon("resources/r26.png")),
    R27(27, 2, new ImageIcon("resources/r27.png")),
    R28(28, 2, new ImageIcon("resources/r28.png")),
    R29(29, 3, new ImageIcon("resources/r29.png")),
    R30(30, 3, new ImageIcon("resources/r30.png")),
    R31(31, 3, new ImageIcon("resources/r31.png")),
    R32(32, 3, new ImageIcon("resources/r32.png")),
    R33(33, 4, new ImageIcon("resources/r33.png")),
    R34(34, 4, new ImageIcon("resources/r34.png")),
    R35(35, 4, new ImageIcon("resources/r35.png")),
    R36(36, 4, new ImageIcon("resources/r36.png"));
    
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

    @Override
    public String toString() {
        return "Racion{" + "valor=" + valor + ", numeroGusanos=" + numeroGusanos + '}';
    }  
    
}
