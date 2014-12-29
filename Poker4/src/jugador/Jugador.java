/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugador;

import carta.Carta;

/**
 *
 * @author Javier
 */
public class Jugador {
    
    private Carta carta1, carta2;
    private int dinero;
    
    /*Constructor de Jugador. Inicializa el dinero que posee el jugador
    actual a 0*/
    public Jugador(int dinero){        
        this.dinero = dinero;       
    }
    
    /*Getters y Setters de la clase*/
    public Carta getCarta1(){
        return this.carta1;
    }
    
    public Carta getCarta2(){
        return this.carta2;
    }
    
    public int getDinero(){
        return this.dinero;
    }
    
     public void setCarta1(Carta c1){
       this.carta1 = c1;
    }
    
    public void setCarta2(Carta c2){
        this.carta2 = c2;    
    }
    
    /*Añade el dinero introducido al total del jugador actual*/
    public void aniadirCredito(int credito){
        this.dinero += credito;
    }
    
    /*Permite sacar el dinero deseado siempre y cuando el total
    sea mayor o igual*/
    public void sacarCredito(int credito){
        if(this.dinero >= credito)
            this.dinero -= credito;
        else
            System.out.println("El credito es insuficiente");
    }
}
