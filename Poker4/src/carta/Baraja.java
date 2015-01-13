/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carta;

import  constantes.AntiguasConstantes;
import java.util.ArrayList;

/**
 *
 * @author Juan Carlos, Francisco Javier, Pablo, Raul
 */
public class Baraja
{
    private static Baraja instancia;
    Carta[] baraja;
    //Carta[] boards;
    //String[] boardsPosibles;
    //ArrayList<Carta[]> boardsPosibles;
   
       AntiguasConstantes constantes;
    private Baraja()
    {
        baraja = new Carta [52];
        //boards = new Carta[5];
        
        //boardsPosibles = new String[1712304];
        //boardsPosibles = new ArrayList<Carta[]>();
       constantes = new AntiguasConstantes ();
        //spades
        baraja[0] = new Carta("ace of spades","as");
        baraja[1] = new Carta("two of spades","2s");
        baraja[2] = new Carta("three of spades","3s");
        baraja[3] = new Carta("four of spades","4s");
        baraja[4] = new Carta("five of spades","5s");
        baraja[5] = new Carta("six of spades","6s");
        baraja[6] = new Carta("seven of spades","7s");
        baraja[7] = new Carta("eight of spades","8s");
        baraja[8] = new Carta("nine of spades","9s");
        baraja[9] = new Carta("ten of spades","ts");
        baraja[10] = new Carta("jack of spades","js");
        baraja[11] = new Carta("queen of spades","qs");
        baraja[12] = new Carta("king of spades","ks");
        
        //hearts
        baraja[13] = new Carta("ace of hearts","ah");
        baraja[14] = new Carta("two of hearts","2h");
        baraja[15] = new Carta("three of hearts","3h");
        baraja[16] = new Carta("four of hearts","4h");
        baraja[17] = new Carta("five of hearts","5h");
        baraja[18] = new Carta("six of hearts","6h");
        baraja[19] = new Carta("seven of hearts","7h");
        baraja[20] = new Carta("eight of hearts","8h");
        baraja[21] = new Carta("nine of hearts","9h");
        baraja[22] = new Carta("ten of hearts","th");
        baraja[23] = new Carta("jack of hearts","jh");
        baraja[24] = new Carta("queen of hearts","qh");
        baraja[25] = new Carta("king of hearts","kh");
        
        //diamonds
        
        baraja[26] = new Carta("ace of diamonds","ad");
        baraja[27] = new Carta("two of diamonds","2d");
        baraja[28] = new Carta("three of diamonds","3d");
        baraja[29] = new Carta("four of diamonds","4d");
        baraja[30] = new Carta("five of diamonds","5d");
        baraja[31] = new Carta("six of diamonds","6d");
        baraja[32] = new Carta("seven of diamonds","7d");
        baraja[33] = new Carta("eight of diamonds","8d");
        baraja[34] = new Carta("nine of diamonds","9d");
        baraja[35] = new Carta("ten of diamonds","td");
        baraja[36] = new Carta("jack of diamonds","jd");
        baraja[37] = new Carta("queen of diamonds","qd");
        baraja[38] = new Carta("king of diamonds","kd");
        
        //clubs
        
        baraja[39] = new Carta("ace of clubs","ac");
        baraja[40] = new Carta("two of clubs","2c");
        baraja[41] = new Carta("three of clubs","3c");
        baraja[42] = new Carta("four of clubs","4c");
        baraja[43] = new Carta("five of clubs","5c");
        baraja[44] = new Carta("six of clubs","6c");
        baraja[45] = new Carta("seven of clubs","7c");
        baraja[46] = new Carta("eight of clubs","8c");
        baraja[47] = new Carta("nine of clubs","9c");
        baraja[48] = new Carta("ten of clubs","tc");
        baraja[49] = new Carta("jack of clubs","jc");
        baraja[50] = new Carta("queen of clubs","qc");
        baraja[51] = new Carta("king of clubs","kc");
        /*
         this.matrizCartas= new boolean[4][14];
         
         f*/
   
    }
    
   public ArrayList<String> dame2cartasDeParejaLibre(String valor)
   {
       ArrayList<String> cartas = new ArrayList<>();
       int cartasSinUsar = 0;
       for(int j = 0; j < 4; j++)
       {
           if(esCartaSinUsar(valor.toLowerCase()+constantes.tablaPaloString.get(j)))
           {
              if(cartasSinUsar == 0)
              {
                 cartas.add( valor.toLowerCase()+constantes.tablaPaloString.get(j));
              }
              if(cartasSinUsar == 1)
              {
                   cartas.add(valor.toLowerCase()+constantes.tablaPaloString.get(j));
              }
              cartasSinUsar++;
          }
       }

        //si hemos encontrado 2 cartas libres entonces las guardamos en la baraja
       //para no repetirlas
        if(cartasSinUsar >=2 )
        {
            usarCarta(cartas.get(0));
            usarCarta(cartas.get(1));
            
            //ahora generamos el resto de cartas de las 6 combinaciones posibles
            if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 'd' || 
                    cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 's')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"h");
            }
            else if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 'c' || 
                    cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 's')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"d");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"h");
            }
            else if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 'h' || 
                    cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 's')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"d");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"h");
            }
            else if(cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 'c' || 
                    cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 'd')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"d");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"h");
            }
            else if(cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 'h' || 
                    cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 'd')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"d");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"h");
            }
            else if(cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 'h' || 
                    cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 'c')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"d");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"h");
            }
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
   public ArrayList<String> dame2cartasDeParejaLibreSinUsarCarta(String valor)
   {
       ArrayList<String> cartas = new ArrayList<>();
       int cartasSinUsar = 0;
       for(int j = 0; j < 4; j++)
       {
           if(esCartaSinUsar(valor.toLowerCase()+constantes.tablaPaloString.get(j)))
           {
              if(cartasSinUsar == 0)
              {
                 cartas.add( valor.toLowerCase()+constantes.tablaPaloString.get(j));
              }
              if(cartasSinUsar == 1)
              {
                   cartas.add(valor.toLowerCase()+constantes.tablaPaloString.get(j));
              }
              cartasSinUsar++;
          }
       }

        //si hemos encontrado 2 cartas libres entonces las guardamos en la baraja
       //para no repetirlas
        if(cartasSinUsar >=2 )
        {
            //ahora generamos el resto de cartas de las 6 combinaciones posibles
            if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 'd' || 
                    cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 's')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"h");
            }
            else if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 'c' || 
                    cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 's')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"d");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"h");
            }
            else if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 'h' || 
                    cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 's')
            {
                
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"d");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"h");
            }
            else if(cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 'c' || 
                    cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 'd')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"d");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"h");
            }
            else if(cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 'h' || 
                    cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 'd')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"d");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"h");
            }
            else if(cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 'h' || 
                    cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 'c')
            {
                //añadimos las cinco combinaciones restantes
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"d");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"h");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"c");
                cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"h");
            }
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
   public ArrayList<String> dame2cartasLibresSuited(String valor1,String valor2)
   {
       ArrayList<String> cartas = new ArrayList<>();
       boolean entro = false;
       for(int j = 0; j < 4; j++)
       {
           if(esCartaSinUsar(valor1.toLowerCase()+constantes.tablaPaloString.get(j)) && esCartaSinUsar(valor2.toLowerCase()+constantes.tablaPaloString.get(j)) && !entro)
           {
               entro = true;
            
                 cartas.add( valor1.toLowerCase()+constantes.tablaPaloString.get(j));
              
                   cartas.add(valor2.toLowerCase()+constantes.tablaPaloString.get(j));
                   //ahora generamos el resto de cartas de las 4 combinaciones posibles
                    if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 's' )
                    {
                        //añadimos las 3 combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(0).charAt(0)+"h");
                    }
                    else if(cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 'd' )
                    {
                        //añadimos las 3 combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(0).charAt(0)+"h");
                    }
                    else if(cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 'c' )
                    {
                        //añadimos las 3 combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(0).charAt(0)+"h");
                    }
                    else if(cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 'h' )
                    {
                        //añadimos las 3 combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(0).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(0).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(0).charAt(0)+"c");
                    }
            
          }
       }

        //si hemos encontrado 2 cartas libres entonces las guardamos en la baraja
       //para no repetirlas
        if(entro )
        {
            usarCarta(cartas.get(0));
            usarCarta(cartas.get(1));
            
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
   public ArrayList<String> dame2cartasLibresSuitedSinUsarCarta(String valor1,String valor2)
   {
       ArrayList<String> cartas = new ArrayList<>();
       boolean entro = false;
       for(int j = 0; j < 4; j++)
       {
           if(esCartaSinUsar(valor1.toLowerCase()+constantes.tablaPaloString.get(j)) && esCartaSinUsar(valor2.toLowerCase()+constantes.tablaPaloString.get(j)) && !entro)
           {
               entro = true;
            
                 cartas.add( valor1.toLowerCase()+constantes.tablaPaloString.get(j));
              
                   cartas.add(valor2.toLowerCase()+constantes.tablaPaloString.get(j));
                   //ahora generamos el resto de cartas de las 4 combinaciones posibles
                    if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 's' )
                    {
                        //añadimos las 3 combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"h");
                    }
                    else if(cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 'd' )
                    {
                        //añadimos las 3 combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"h");
                    }
                    else if(cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 'c' )
                    {
                        //añadimos las 3 combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"h");
                    }
                    else if(cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 'h' )
                    {
                        //añadimos las 3 combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"c");
                    }
            
          }
       }

        //si hemos encontrado 2 cartas libres entonces las guardamos en la baraja
       //para no repetirlas
        if(entro )
        {
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
   public ArrayList<String> dameRangoLibreSuited(String valor1,String valor2)
   {
       valor1 = valor1.toLowerCase();
       valor2 = valor2.toLowerCase();
       ArrayList<String> cartas = new ArrayList<>();
  
       int ini;
       int fin;
       if(valor1.equalsIgnoreCase(constantes.tablaValorString.get(constantes.ACE)))
       {
           fin = constantes.KING+1;
           ini = constantes.tablaStringValor.get(valor2);
       }
       else
       {
           fin = constantes.tablaStringValor.get(valor1);
           ini = constantes.tablaStringValor.get(valor2);
       }
       int meta = fin -ini ;
       int numParejasAsignadas = 0;
       String suitedCombinadas [] = new String [fin];
               
       for(int j = 0; j< fin;j++)
       {
           suitedCombinadas[j]="";
       }
       for(int j = 0; j < 4; j++)
       {
           //comprobamos si todo el rango esta vacio
           
           for(int k = ini; k < fin;k++)
           {
               for(int h = 0; h < 4;h++)
               {
                   if(h == j)
                   {
                       
                        if(esCartaSinUsar(valor1+constantes.tablaPaloString.get(j)) && esCartaSinUsar(constantes.tablaValorString.get(k)+constantes.tablaPaloString.get(h)) && suitedCombinadas[k].equalsIgnoreCase(""))
                        {
                           
                            suitedCombinadas[k] = valor1+constantes.tablaPaloString.get(j)+constantes.tablaValorString.get(k)+constantes.tablaPaloString.get(h);
                            
                            numParejasAsignadas++;
                        } 
                   }
                   
               }
               
           }
       }

       if(meta == numParejasAsignadas)
       {
            
            for(int k = ini; k < fin;k++)
            {
                if(esCartaSinUsar(suitedCombinadas[k].substring(0, 2)))
                {
                    usarCarta(suitedCombinadas[k].substring(0, 2));

                }
                if(esCartaSinUsar(suitedCombinadas[k].substring(2, 4)))
                {
                    usarCarta(suitedCombinadas[k].substring(2, 4));

                }
                cartas.add(suitedCombinadas[k]);
                
               
            }
            
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
   public ArrayList<String> dameRangoLibreSuitedSinUsarCarta(String valor1,String valor2)
   {
       valor1 = valor1.toLowerCase();
       valor2 = valor2.toLowerCase();
       ArrayList<String> cartas = new ArrayList<>();
  
       int ini;
       int fin;
       if(valor1.equalsIgnoreCase(constantes.tablaValorString.get(constantes.ACE)))
       {
           fin = constantes.KING+1;
           ini = constantes.tablaStringValor.get(valor2);
       }
       else
       {
           fin = constantes.tablaStringValor.get(valor1);
           ini = constantes.tablaStringValor.get(valor2);
       }
       int meta = fin -ini ;
       int numParejasAsignadas = 0;
       String suitedCombinadas [] = new String [fin];
               
       for(int j = 0; j< fin;j++)
       {
           suitedCombinadas[j]="";
       }
       for(int j = 0; j < 4; j++)
       {
           //comprobamos si todo el rango esta vacio
           
           for(int k = ini; k < fin;k++)
           {
               for(int h = 0; h < 4;h++)
               {
                   if(h == j)
                   {
                       
                        if(esCartaSinUsar(valor1+constantes.tablaPaloString.get(j)) && esCartaSinUsar(constantes.tablaValorString.get(k)+constantes.tablaPaloString.get(h)) && suitedCombinadas[k].equalsIgnoreCase(""))
                        {
                           
                            suitedCombinadas[k] = valor1+constantes.tablaPaloString.get(j)+constantes.tablaValorString.get(k)+constantes.tablaPaloString.get(h);
                            
                            numParejasAsignadas++;
                        } 
                   }
                   
               }
               
           }
       }

       if(meta == numParejasAsignadas)
       {
            
            for(int k = ini; k < fin;k++)
            {
                
                cartas.add(suitedCombinadas[k]);
                String carta1 = suitedCombinadas[k].substring(0, 2);
                String carta2 = suitedCombinadas[k].substring(2, 4);
                if(carta1.charAt(1) == 's' && carta2.charAt(1) == 's' )
                {
                        //añadimos las 3 combinaciones restantes
                        cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"d");
                        cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"c");
                        cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"h");
                }
                else if(carta1.charAt(1) == 'd' && carta2.charAt(1) == 'd' )
                {
                    //añadimos las 3 combinaciones restantes
                    cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"s");
                    cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"c");
                    cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"h");
                }
                else if(carta1.charAt(1) == 'c' && carta2.charAt(1) == 'c' )
                {
                    //añadimos las 3 combinaciones restantes
                    cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"s");
                    cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"d");
                    cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"h");
                }
                else if(carta1.charAt(1) == 'h' && carta2.charAt(1) == 'h' )
                {
                    //añadimos las 3 combinaciones restantes
                    cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"s");
                    cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"d");
                    cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"c");
                }
               
            }
            
            
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
   public ArrayList<String> dameRangoLibreOffSuited(String valor1,String valor2)
   {
       valor1 = valor1.toLowerCase();
       valor2 = valor2.toLowerCase();
       ArrayList<String> cartas = new ArrayList<>();
  
       int ini = 0;
       int fin = 0;
       if(valor1.equalsIgnoreCase(constantes.tablaValorString.get(constantes.ACE)))
       {
           fin = constantes.KING+1;
           ini = constantes.tablaStringValor.get(valor2);
       }
       else
       {
           fin = constantes.tablaStringValor.get(valor1);
           ini = constantes.tablaStringValor.get(valor2);
       }
       boolean hayRango = true;
       int meta = fin -ini ;
       int numParejasAsignadas = 0;
       String offSuitedCombinadas [] = new String [fin];
               
       for(int j = 0; j< fin;j++)
       {
           offSuitedCombinadas[j]="";
       }
       for(int j = 0; j < 4; j++)
       {
           //comprobamos si todo el rango esta vacio
           
           for(int k = ini; k < fin;k++)
           {
               for(int h = 0; h < 4;h++)
               {
                   if(h != j)
                   {
                       
                        if(esCartaSinUsar(valor1+constantes.tablaPaloString.get(j)) && esCartaSinUsar(constantes.tablaValorString.get(k)+constantes.tablaPaloString.get(h)) && offSuitedCombinadas[k].equalsIgnoreCase(""))
                        {
                           
                            offSuitedCombinadas[k] = valor1+constantes.tablaPaloString.get(j)+constantes.tablaValorString.get(k)+constantes.tablaPaloString.get(h);
                            
                            numParejasAsignadas++;
                        } 
                   }
                   
               }
               
           }
       }

       if(meta == numParejasAsignadas)
       {
            
            for(int k = ini; k < fin;k++)
            {
                if(esCartaSinUsar(offSuitedCombinadas[k].substring(0, 2)))
                {
                    usarCarta(offSuitedCombinadas[k].substring(0, 2));

                }
                if(esCartaSinUsar(offSuitedCombinadas[k].substring(2, 4)))
                {
                    usarCarta(offSuitedCombinadas[k].substring(2, 4));

                }
                cartas.add(offSuitedCombinadas[k]);
                
               
            }
            
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
   public ArrayList<String> dameRangoLibreOffSuitedSinUsarCarta(String valor1,String valor2)
   {
       valor1 = valor1.toLowerCase();
       valor2 = valor2.toLowerCase();
       ArrayList<String> cartas = new ArrayList<>();
  
       int ini ;
       int fin ;
       if(valor1.equalsIgnoreCase(constantes.tablaValorString.get(constantes.ACE)))
       {
           fin = constantes.KING+1;
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
           ini = constantes.tablaStringValor.get(valor2);
       }
       else
       {
           fin = constantes.tablaStringValor.get(valor1);
           ini = constantes.tablaStringValor.get(valor2);
       }
       int meta = fin -ini ;
       int numParejasAsignadas = 0;
       String offSuitedCombinadas [] = new String [fin];
               
       for(int j = 0; j< fin;j++)
       {
           offSuitedCombinadas[j]="";
       }
       for(int j = 0; j < 4; j++)
       {
           //comprobamos si todo el rango esta vacio
           
           for(int k = ini; k < fin;k++)
           {
               for(int h = 0; h < 4;h++)
               {
                   if(h != j)
                   {
                       
                        if(esCartaSinUsar(valor1+constantes.tablaPaloString.get(j)) && esCartaSinUsar(constantes.tablaValorString.get(k)+constantes.tablaPaloString.get(h)) && offSuitedCombinadas[k].equalsIgnoreCase(""))
                        {
                           
                            offSuitedCombinadas[k] = valor1+constantes.tablaPaloString.get(j)+constantes.tablaValorString.get(k)+constantes.tablaPaloString.get(h);
                            String carta1 = offSuitedCombinadas[k].substring(0, 2);
                            String carta2 = offSuitedCombinadas[k].substring(2, 4);
                            //ahora generamos el resto de cartas de las 12 combinaciones posibles
                            if(carta1.charAt(1) == 's' && carta2.charAt(1) == 'd')
                            {
                                cartas.add(carta1.charAt(0)+ "d"+ carta2.charAt(0)+ "s");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");

                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                            }
                            else if(carta1.charAt(1) == 'd' && carta2.charAt(1) == 's')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");

                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                            }
                            //sd ds sc
                            else if(carta1.charAt(1) == 's' && carta2.charAt(1) == 'c')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");

                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                            }
                            //sd ds sc cs
                            else if(carta1.charAt(1) == 'c' && carta2.charAt(1) == 's')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");

                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                            }

                            //sd ds sc cs sh
                            else if(carta1.charAt(1) == 's' && carta2.charAt(1) == 'h')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");

                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                            }

                            //sd ds sc cs sh hs
                            else if(carta1.charAt(1) == 'h' && carta2.charAt(1) == 's')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");

                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                            }

                            //sd ds sc cs sh hs ch
                            else if(carta1.charAt(1) == 'c' && carta2.charAt(1) == 'h')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");

                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                            }

                            //sd ds sc cs sh hs ch hc
                            else if(carta1.charAt(1) == 'h' && carta2.charAt(1) == 'c')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");

                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");
                            }

                            //sd ds sc cs sh hs ch hc dc
                            else if(carta1.charAt(1) == 'd' && carta2.charAt(1) == 'c')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");

                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");
                            }

                            //sd ds sc cs sh hs ch hc dc cd
                            else if(carta1.charAt(1) == 'c' && carta2.charAt(1) == 'd')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");

                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");
                            }

                            //sd ds sc cs sh hs ch hc dc cd dh
                            else if(carta1.charAt(1) == 'd' && carta2.charAt(1) == 'h')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");

                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");
                            }

                            //sd ds sc cs sh hs ch hc dc cd dh hd
                            else if(carta1.charAt(1) == 'h' && carta2.charAt(1) == 'd')
                            {
                                cartas.add(carta1.charAt(0)+ "s"+ carta2.charAt(0)+ "d");
                                //añadimos las cinco combinaciones restantes
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"s");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"d");
                                cartas.add(carta1.charAt(0)+"h"+carta2.charAt(0)+"s");

                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"s"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"c");
                                cartas.add(carta1.charAt(0)+"d"+carta2.charAt(0)+"h");
                                cartas.add(carta1.charAt(0)+"c"+carta2.charAt(0)+"h");
                            }
                            numParejasAsignadas++;
                        } 
                   }
                   
               }
               
           }
       }

       if(meta == numParejasAsignadas)
       {
            
            for(int k = ini; k < fin;k++)
            {
                
                cartas.add(offSuitedCombinadas[k]);
                
               
            }
            
            return cartas;
        }
        else
        {
            return null;
        }
   }
   /*
   public ArrayList<String> dame2cartasLibresOffSuited(String valor1,String valor2)
   {
       ArrayList<String> cartas = new ArrayList<>();
       boolean entro = false;
       for(int k = 0; k < 4; k++)
       {
            for(int j = 0; j < 4; j++)
            {
                if(j!= k && esCartaSinUsar(valor1.toLowerCase()+constantes.tablaPaloString.get(k)) && esCartaSinUsar(valor2.toLowerCase()+constantes.tablaPaloString.get(j)) && !entro)
                {
                    entro = true;

                      cartas.add( valor1.toLowerCase()+constantes.tablaPaloString.get(k));

                        cartas.add(valor2.toLowerCase()+constantes.tablaPaloString.get(j));

               }
            }
       }

        //si hemos encontrado 2 cartas libres entonces las guardamos en la baraja
       //para no repetirlas
        if(entro )
        {
            usarCarta(cartas.get(0));
            usarCarta(carta2);
            return cartas;
        }
        else
        {
            return null;
        }
   }*/
   public ArrayList<String> dame2cartasLibresOffSuitedSinUsarCarta(String valor1,String valor2)
   {
       ArrayList<String> cartas = new ArrayList<>();
       boolean entro = false;
       for(int k = 0; k < 4; k++)
       {
            for(int j = 0; j < 4; j++)
            {
                if(j!= k && esCartaSinUsar(valor1.toLowerCase()+constantes.tablaPaloString.get(k)) && esCartaSinUsar(valor2.toLowerCase()+constantes.tablaPaloString.get(j)) && !entro)
                {
                    entro = true;

                      cartas.add( valor1.toLowerCase()+constantes.tablaPaloString.get(k));

                        cartas.add(valor2.toLowerCase()+constantes.tablaPaloString.get(j));
                    
                    //ahora generamos el resto de cartas de las 12 combinaciones posibles
                    if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 'd')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "d"+ cartas.get(1).charAt(0)+ "s");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                        
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                    }
                    else if(cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 's')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                        
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                    }
                    //sd ds sc
                    else if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 'c')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                        
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                    }
                    //sd ds sc cs
                    else if(cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 's')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                        
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                    }
                    
                    //sd ds sc cs sh
                    else if(cartas.get(0).charAt(1) == 's' && cartas.get(1).charAt(1) == 'h')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                        
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                    }
                    
                    //sd ds sc cs sh hs
                    else if(cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 's')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                        
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                    }
                    
                    //sd ds sc cs sh hs ch
                    else if(cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 'h')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                    }
                    
                    //sd ds sc cs sh hs ch hc
                    else if(cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 'c')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                    }
                    
                    //sd ds sc cs sh hs ch hc dc
                    else if(cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 'c')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                    }
                    
                    //sd ds sc cs sh hs ch hc dc cd
                    else if(cartas.get(0).charAt(1) == 'c' && cartas.get(1).charAt(1) == 'd')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                    }
                    
                    //sd ds sc cs sh hs ch hc dc cd dh
                    else if(cartas.get(0).charAt(1) == 'd' && cartas.get(1).charAt(1) == 'h')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                    }
                    
                    //sd ds sc cs sh hs ch hc dc cd dh hd
                    else if(cartas.get(0).charAt(1) == 'h' && cartas.get(1).charAt(1) == 'd')
                    {
                        cartas.add(cartas.get(0).charAt(0)+ "s"+ cartas.get(1).charAt(0)+ "d");
                        //añadimos las cinco combinaciones restantes
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"s");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"d");
                        cartas.add(cartas.get(0).charAt(0)+"h"+cartas.get(1).charAt(0)+"s");
                        
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"s"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"c");
                        cartas.add(cartas.get(0).charAt(0)+"d"+cartas.get(1).charAt(0)+"h");
                        cartas.add(cartas.get(0).charAt(0)+"c"+cartas.get(1).charAt(0)+"h");
                    }
                    
                    
                    

               }
            }
       }

        //si hemos encontrado 2 cartas libres entonces las guardamos en la baraja
       //para no repetirlas
        if(entro )
        {
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
    public static Baraja getInstance() {
      if(instancia == null) {
         instancia = new Baraja();
      }
      return instancia;
   }
    
    public Carta getCarta(int i)
    {
        return baraja[i];
    }
    
    public int getIdCarta(String siglas)
    {
        int id = -1 ;
        for(int i = 0; i < 52;i++)
        {
            
            if(siglas.compareTo(baraja[i].getDigito()+baraja[i].getPalo()) == 0)
            {
                id = i;
            }
        }
        
        return id;
    }
    
    public Carta[] generaJugada(int n)
            {
        
        int i = 0;
        
        Carta [] cartas = new Carta[n];
        
        while(i < cartas.length)
        {
            //obtenemos 5 cartas aleatorias
            int valor =(int) Math.floor(Math.random()*51);
          //System.out.println(valor);
           //si la carta esta disponible la generamos y la ponemos a no disponible
            if(getCarta(valor).getDisponible())
            {
                getCarta(valor).setDisponible(false);
                
                cartas[i] = getCarta(valor);
                i++;   
                
            }
            
        }
        return cartas;
        
    }
    
    public Carta[] generaJugada(Carta[] cartas)
    {
        
        int i = 0;
        
        //Carta [] cartas = new Carta[n];
        
        while(i < cartas.length)
        {
            //obtenemos 5 cartas aleatorias
            int valor =(int) Math.floor(Math.random()*51);
          //System.out.println(valor);
           //si la carta esta disponible la generamos y la ponemos a no disponible
            if(getCarta(valor).getDisponible())
            {
                getCarta(valor).setDisponible(false);
                
                cartas[i] = getCarta(valor);
                i++;   
                
            }
            
        }
        return cartas;
        
    }
     
     public void usarCarta(String carta)
     {
         int id =getIdCarta(carta.toLowerCase());
         baraja[id].setDisponible(false);
     }
     
     
     public void deshabilitarCarta(String carta)
     {
         int id =getIdCarta(carta.toLowerCase());
         baraja[id].setDisponible(true);
     }
     public boolean esCartaSinUsar(String carta)
     {
         int id =getIdCarta(carta.toLowerCase());
         return baraja[id].getDisponible();
     }
    
    public Carta getCartaMasAlta(Carta [] cartas)
    {
        return getCartasOrdenadasMenorAMayor(cartas)[cartas.length-1];
    }
    //public String getJugadaString(int n)
    public String getJugadaString(Carta[] cartas)
    {
        //Carta [] cartas =generaJugada(n);
        cartas = generaJugada(cartas);
        String cadena = "";
        int i = 0;
        while(i < cartas.length)
        {
            cadena = cadena + cartas[i].getDigito()+cartas[i].getPalo();
            i++;
        }
        
        return cadena.toUpperCase();
    }
    //daria ordenadas todas las cartas usadas hasta el momento
    public String getStringCartasOrdenadasPorPaloMenorAMayor(Carta [] cartas)
    {
        boolean[][] matrizCartas = new boolean[4][14];
        
        for(int i= 0; i < 4;i++)
         {
             for(int j= 0; j < 14;j++)
             {
                 matrizCartas[i][j] = true;
             }
         }
        for(int i = 0; i < cartas.length;i++)
        {
            
            matrizCartas[constantes.tablaStringPalo.get(cartas[i].getPalo())][cartas[i].getValor()] = false;
        }
      
        String cadena = "";
        for(int i = 0; i < 4.; i++)
        {
            for(int j = 0; j < 14;j++)
            {
                if(!matrizCartas[i][j])
                {
                  cadena = cadena + constantes.tablaValorString.get(j) + constantes.tablaPaloString.get(i);
   
                    
                }
            }
           
           
        }
         return cadena;
    }
    
    public Carta[] getCartasOrdenadasMenorAMayor(Carta [] cartas)
    {
        String car = getStringCartasOrdenadasPorPaloMenorAMayor(cartas);
        return generaCartasConString(car);
    }
    public Carta[] generaCartasConString(String cartas)
    {
       int numcartas = cartas.length()/2;
       Carta[] carta = new Carta[numcartas];
       int i = 0;
       int j = 0;
       while(i <= cartas.length() -2)
       {
           carta[j] = this.getCarta(this.getIdCarta(cartas.substring(i, i+2).toLowerCase()));
           usarCarta(cartas.substring(i, i+2));
           j++;
           i = i +2;
       }
       
       return carta;
    }
    public Carta[] generaCartasConStringSinUsarCarta(String cartas)
    {
       int numcartas = cartas.length()/2;
       Carta[] carta = new Carta[numcartas];
       int i = 0;
       int j = 0;
       while(i <= cartas.length() -2)
       {
           carta[j] = this.getCarta(this.getIdCarta(cartas.substring(i, i+2).toLowerCase()));
        
           
           //usarCarta(cartas.substring(i, i+2));
           j++;
           i = i +2;
       }
       
       return carta;
    }
    
    public boolean esJugadaValida(String cartas)
    {
        String jugada = cartas.toLowerCase();
        boolean[][] matrizCartas = new boolean[4][14];
        
        //inicializamos la matriz a true
        for(int i = 0; i < 4.; i++)
        {
            for(int j = 0; j < 14;j++)
            {
                matrizCartas[i][j] = false;
            }
           
           
        }
        //primero comprobamos que las letras son validas
        int i = 0;
        AntiguasConstantes c = new AntiguasConstantes();
        while(i < jugada.length()-1)
        {
            //si no existe, retornamos false
            
            if(!c.tablaStringPalo.containsKey(String.valueOf(jugada.charAt(i+1))) ||
                    !c.tablaStringValor.containsKey(String.valueOf(jugada.charAt(i))))
            {
                return false;
            }
            else
            {
                //si no habiamos incluido aun la carta, la metemos
                if(!matrizCartas[c.tablaStringPalo.get(String.valueOf(jugada.charAt(i+1)))]
                        [c.tablaStringValor.get(String.valueOf(jugada.charAt(i)))])
                {
                    matrizCartas[c.tablaStringPalo.get(String.valueOf(jugada.charAt(i+1)))]
                        [c.tablaStringValor.get(String.valueOf(jugada.charAt(i)))] = true;
                }
                //si ya estaba, entonces nos han metido cartas repetidas
                else
                {
                    return false;
                }
            }
            i = i +2;
        }
        return true;
    }
    //este metodo pondria todo a disponible
    public void reset()
    {
        for(int i = 0; i < 52;i++)
        {
            getCarta(i).setDisponible(true);
        }/*
        for(int i = 0; i < 4.; i++)
        {
            for(int j = 0; j < 14;j++)
            {
                getCarta(i+j).setDisponible(true);
            }
           
           
        }*/
    }
    
}
