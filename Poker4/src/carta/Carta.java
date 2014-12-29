/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carta;

import constantes.AntiguasConstantes;

/**
 *
* @author Juan Carlos, Francisco Javier, Pablo, Raul
*/
public class Carta 
{
    private final String img;
    private final String nombre;
    private final String palo;
    private final String digito;
    private final int valor;
    boolean disponible;
    
    public Carta(String nombre,String siglas)
    {
        this.nombre = nombre;
        this.img = siglas + ".png";
        digito = String.valueOf(siglas.charAt(0));
        palo = String.valueOf(siglas.charAt(1));
        if(digito.compareTo("a")==0)
        {
            valor = AntiguasConstantes.ACE;
        }
        else if(digito.compareTo("k")==0)
        {
            valor = AntiguasConstantes.KING;
        }
        else if(digito.compareTo("q")==0)
        {
            valor = AntiguasConstantes.QUEEN;
        }
        else if(digito.compareTo("j")==0)
        {
            valor = AntiguasConstantes.JACK;
        }
            
        else if( digito.compareTo("t")==0)
        {
            valor = AntiguasConstantes.TEN;
        }
        else
        {
            valor = Integer.parseInt(digito)-1;
        }
        disponible = true;
    }
    
    
    public String getDigito()
    {
        return digito;
    }
    
    public String getPalo()
    {
        return palo;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public String getDenominacion()
    {
        return digito+palo;
    }
    
    public int getValor()
    {
        return valor;
    }
    
    public void setDisponible(boolean b)
    {
        disponible = b;
        
    }
    public boolean getDisponible()
    {
        return disponible;
    }
}
