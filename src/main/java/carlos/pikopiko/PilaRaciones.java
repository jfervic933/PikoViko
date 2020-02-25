/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carlos.pikopiko;

import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class PilaRaciones {
    
    private ArrayList<Racion> pila;
    
    public PilaRaciones(){
        pila = new ArrayList<>();
    }
    
    public void ponerRacion(Racion r){
        pila.add(r);
    }
    
    public Racion sacarRacion(){
        if (!pila.isEmpty()){
            return pila.remove(pila.size()-1);
        }
        return null;
    }
    public int numeroRaciones(){
        return pila.size();
    }
    
    public boolean estaVacia(){
        return pila.isEmpty();
    }
    // Este método devuelve la ración que ocupa el última lugar de la pila
    // pero no la elimina de la pila de raciones
    public Racion consultarUltimaRacion(){
        if (!pila.isEmpty()){
            return pila.get(pila.size()-1);
        }
        return null;
    }
    
    public boolean compararConUltimaRacion(Racion r){
        return consultarUltimaRacion() == r;
    }
    
    public void imprimirRaciones(){
        pila.forEach(System.out::println);
    }

    @Override
    public String toString() {
        String raciones = "";
        for (Racion racion : pila) {
            raciones += racion.toString() + "\n";
        }
        return raciones;
    }
    
    
}
