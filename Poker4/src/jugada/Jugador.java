/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugada;

import carta.Baraja;
import carta.Carta;
import constantes.AntiguasConstantes;

/**
 *
* @author Juan Carlos, Francisco Javier, Pablo, Raul
 */
public class Jugador 
{

    Carta[] cartas;
    int id;
    int posicion;
    int []jugada;
    Carta [] mezcla;
    int valor ;
    Baraja baraja;
    double puntos;
    ValorMano v ;
    
    public Jugador(int id)
    {
        v = new ValorMano();
        puntos=0;
        valor = 0;
        baraja = Baraja.getInstance();
        this.id = id;
        mezcla = new Carta[7];
    }
    public Jugador(Carta[] cartas,int id)
    {
        v = new ValorMano();
        puntos=0;
        valor = 0;
        this.cartas = cartas;
        baraja = Baraja.getInstance();
        this.id = id;
    }
    public Jugador(String cartas,int id)
    {
        v = new ValorMano();
        valor = 0;
        baraja = Baraja.getInstance();
        this.cartas = baraja.generaCartasConString(cartas);
       
        this.id = id;
    }
    public Carta[] getCartas()
    {
        return cartas;
    }
    public Carta[] combinaCartasDeManoConComunes(Carta [] comunes)
    {
        mezcla= new Carta[comunes.length  + cartas.length];
       
        int j = 0;
        for(int i = 0; i < cartas.length; i++)
        {
            mezcla[i] = cartas[i];
            j = i;
            
        }
        for(int i = 0; i < comunes.length; i++,j++)
        {
            mezcla[j+1] = comunes[i];
        }
        
        jugada =  v.valorarMiMano(mezcla);
        setJugada(jugada);
        return mezcla;
    }
    public Carta[] combinaCartasDeManoConComunes2(Carta [] comunes)
    {
        //mezcla= new Carta[comunes.length  + cartas.length];
       
        int j = 0;
        for(int i = 0; i < cartas.length; i++)
        {
            mezcla[i] = cartas[i];
            j = i;
            
        }
        for(int i = 0; i < comunes.length; i++,j++)
        {
            mezcla[j+1] = comunes[i];
        }
        
        jugada =  v.valorarMiMano(mezcla);
        setJugada(jugada);
        return mezcla;
    }
    public void setCartas(Carta[] cartas)
    {
        this.cartas = cartas;
    }
    
    public void setCartas(String cartas)
    {
        this.cartas = baraja.generaCartasConString(cartas);
    }
    public void setCartasSinUsarCartas(String cartas)
    {
        this.cartas = baraja.generaCartasConStringSinUsarCarta(cartas);
    }
    
    public double getPuntos ()
    {
        return puntos;
    }
    public Carta[] getMezcla()
    {
        return mezcla;
    }
    public void setPosicion(int n)
    {
        posicion = n;
        
    }
    public int getPosicion()
    {
        return posicion;
    }
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
        
    public void setJugada(int[] jugada)
    {
        //AntiguasConstantes cons = new AntiguasConstantes();
        valor = jugada[0];
        /*
        try
        {
            String mano = jugada[0].substring(AntiguasConstantes.BEST_HAND.length());
             mano = mano.substring(0,cons.STRAIGHT_FLUSH.length());
            valor = cons.tablaValoresMano.get(mano);
        }
        catch(Exception e)
        {
            
        }
        try
        {
            if(valor == 0)
            {
                 String mano = jugada[0].substring(AntiguasConstantes.BEST_HAND.length());
             mano = mano.substring(0,cons.FOUR_OF_A_KIND.length());
            valor = cons.tablaValoresMano.get(mano);
            }
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if(valor == 0)
            {
                 String mano = jugada[0].substring(AntiguasConstantes.BEST_HAND.length());
             mano = mano.substring(0,cons.FULL_HOUSE.length());
            valor = cons.tablaValoresMano.get(mano);
                 
            }
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if(valor == 0)
            {
                 String mano = jugada[0].substring(AntiguasConstantes.BEST_HAND.length());
             mano = mano.substring(0,cons.FLUSH.length());
            valor = cons.tablaValoresMano.get(mano);
           }
        }
        catch(Exception e)
        {
            
        }
        try
        {
            if(valor == 0)
            {
                 String mano = jugada[0].substring(AntiguasConstantes.BEST_HAND.length());
             mano = mano.substring(0,cons.STRAIGHT.length());
            valor = cons.tablaValoresMano.get(mano);
            
            }
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if(valor == 0)
            {
                 String mano = jugada[0].substring(AntiguasConstantes.BEST_HAND.length());
             mano = mano.substring(0,cons.THREE_OF_A_KIND.length());
            valor = cons.tablaValoresMano.get(mano);
          
            }
        }
        catch(Exception e)
        {
            
        }
        
        
        try
        {
            if(valor == 0)
            {
                 String mano = jugada[0].substring(AntiguasConstantes.BEST_HAND.length());
                mano = mano.substring(0,cons.TWO_PAIR.length());
            valor = cons.tablaValoresMano.get(mano);
           
            }
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if(valor == 0)
            {
                 String mano = jugada[0].substring(AntiguasConstantes.BEST_HAND.length());
             mano = mano.substring(0,cons.PAIR.length());
            valor = cons.tablaValoresMano.get(mano);
          
            }
        }
        catch(Exception e)
        {
            
        }
        
        try
        {
            if(valor == 0)
            {
                 String mano = jugada[0].substring(AntiguasConstantes.BEST_HAND.length());
             mano = mano.substring(0,cons.HIGH_CARD.length());
            valor = cons.tablaValoresMano.get(mano);
           
            }
        }
        catch(Exception e)
        {
            
        }*/
       
       // System.out.println("valorMano " + valor);
        this.jugada = jugada;
    }
    
    public int getValorJugada()
    {
        return valor;
    }
    public int[] getJugada()
    {
        return jugada;
    }
    public void setValorJugada(int v)
    {
        valor = v;
    }
   
    public Carta cartaMasAlta()
    {
       return  baraja.getCartaMasAlta(cartas);
    }
    public void sumaPuntos(double p)
    {
        puntos = puntos + p;
    }
   
}
