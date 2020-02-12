/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlos.pikopiko;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jcarlosvico
 */
public class Parrilla {

    // Una parrilla es una tabla donde hacemos corresponder el valor 
    // del dado con la ficha. Esto permite ordenar la parrilla por valor, que
    // además no se puede repetir.
    private Map<Integer, Racion> lista;
    public static final int NUMERO_RACIONES = 16;
    public static final int VALOR_RACION_INICIAL = 21;

    // Construye el map con las raciones
    public Parrilla() {
        lista = new HashMap<>(NUMERO_RACIONES);
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

    public Racion getRacionParrilla(Integer i){
        return lista.get(i);
    }
    
    public boolean buscarRacion(Racion r){
        return lista.containsValue(r);
    }
}
