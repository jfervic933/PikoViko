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
 * @author carlos
 */
public class Parrilla {
    
    // Una parrilla es una tabla donde hacemos corresponder el valor 
    // del dado con la ficha. Esto permite ordenar la parrilla por valor, que
    // además no se puede repetir.
    private final Map<Integer,Racion> lista;
    public static final int NUMERO_RACIONES = 16;
    
    // Construye el map con las raciones
    public Parrilla(){
        lista = new HashMap<>(NUMERO_RACIONES);
        rellenarParrilla();
    }
    
    private void rellenarParrilla(){
        lista.put(Racion.R21.getValor(), Racion.R21);
        lista.put(Racion.R22.getValor(), Racion.R22);
        lista.put(Racion.R23.getValor(), Racion.R23);
        lista.put(Racion.R24.getValor(), Racion.R24);
    }
    public void imprimirParrilla(){
        
        lista.values().forEach(System.out::println);
        
    }
    
    public static void main(String ... args){
        new Parrilla().imprimirParrilla();
    }
    
}
