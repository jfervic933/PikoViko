package carlos.pikopiko;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author jcarlosvico@maralboran.es
 */
public class Parrilla {

    // Una parrilla es una tabla donde hacemos corresponder el valor 
    // del dado con la ficha. Esto permite ordenar la parrilla por valor, que
    // además no se puede repetir.
    private SortedMap<Integer, Racion> lista;
    public static final int NUMERO_RACIONES = 16;
    public static final int VALOR_RACION_INICIAL = 21;

    // Construye el map con las raciones. Se usa TreeMap que permite 
    // mantener la parrilla ordenada por key
    public Parrilla() {
        lista = new TreeMap<>();
        rellenarParrilla();
    }

    private void rellenarParrilla() {
        lista.put(Racion.R21.getValor(), Racion.R21);
        lista.put(Racion.R22.getValor(), Racion.R22);
        lista.put(Racion.R23.getValor(), Racion.R23);
        lista.put(Racion.R24.getValor(), Racion.R24);
        lista.put(Racion.R25.getValor(), Racion.R25);
        lista.put(Racion.R26.getValor(), Racion.R26);
        lista.put(Racion.R27.getValor(), Racion.R27);
        lista.put(Racion.R28.getValor(), Racion.R28);
        lista.put(Racion.R29.getValor(), Racion.R29);
        lista.put(Racion.R30.getValor(), Racion.R30);
        lista.put(Racion.R31.getValor(), Racion.R31);
        lista.put(Racion.R32.getValor(), Racion.R32);
        lista.put(Racion.R33.getValor(), Racion.R33);
        lista.put(Racion.R34.getValor(), Racion.R34);
        lista.put(Racion.R35.getValor(), Racion.R35);
        lista.put(Racion.R36.getValor(), Racion.R36);
    }

    public Racion getRacionParrilla(Integer i) {
        return lista.get(i);
    }

    public boolean existeRacion(Racion r) {
        return lista.containsValue(r);
    }

    public boolean existeRacion(Integer i) {
        Racion aux = lista.get(i);
        return aux != null;
    }

    public Racion getRacionMayor() {
        return lista.get(lista.lastKey());
    }

    // Saca la ración de la parrilla, si existe la key valorRacion
    // En caso de no existir no hace nada
    public void borrarRacion(Integer valorRacion) {
        lista.remove(valorRacion);
    }

    // Pone la ración en la parrilla, si no existe
    // En caso de no ser la de mayor valor, retira
    // la ración de mayor valor
    public void devolverRacion(Racion r) {
        if (!lista.containsKey(r.getValor())) {
            lista.put(r.getValor(), r);
            Racion mayor = this.getRacionMayor();
            if (r != mayor) {
                this.borrarRacion(mayor.getValor());
            }
        }
    }

    private void imprimir() {
        for (Racion r : lista.values()) {
            System.out.println(r);
        }
    }

//    public static void main(String[] args) {
//        Parrilla p = new Parrilla();
//        p.imprimir();
//        System.out.println("Racion mayor " + p.getRacionMayor());
//        System.out.println("Racion 22 " + p.getRacionParrilla(22));
//        p.borrarRacion(36);
//        p.borrarRacion(36);
//        p.borrarRacion(35);
//        p.borrarRacion(22);
//        p.borrarRacion(29);
//        p.imprimir();
//        System.out.println("Racion mayor " + p.getRacionMayor());
//        System.out.println("Existe 22 " + p.existeRacion(Racion.R22));
//        System.out.println("Existe 36 " + p.existeRacion(Racion.R36));
//        p.devolverRacion(Racion.R22);
//        p.devolverRacion(Racion.R22);
//        p.borrarRacion(33);
//        p.devolverRacion(Racion.R29);
//        p.imprimir();
//        System.out.println("Existe 29 " + p.existeRacion(29));
//        System.out.println("Existe 21 " + p.existeRacion(21));
//        System.out.println("Existe 36 " + p.existeRacion(36));
//    }
}
