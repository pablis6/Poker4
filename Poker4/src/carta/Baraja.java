/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carta;

import  constantes.AntiguasConstantes;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Juan Carlos, Francisco Javier, Pablo, Raul
 */
public class Baraja
{
    private static Baraja instancia;
    Carta[] baraja;
   
    private Baraja()
    {
        baraja = new Carta [52];
        
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
       ArrayList<String> cartas = new ArrayList<String>();
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
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
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
   public ArrayList<String> dame2cartasDeParejaLibreSinUsarCarta(String valor)
   {
       ArrayList<String> cartas = new ArrayList<String>();
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
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
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
   public ArrayList<String> dame2cartasLibresSuited(String valor1,String valor2)
   {
       ArrayList<String> cartas = new ArrayList<String>();
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
       boolean entro = false;
       for(int j = 0; j < 4; j++)
       {
           if(esCartaSinUsar(valor1.toLowerCase()+constantes.tablaPaloString.get(j)) && esCartaSinUsar(valor2.toLowerCase()+constantes.tablaPaloString.get(j)) && !entro)
           {
               entro = true;
            
                 cartas.add( valor1.toLowerCase()+constantes.tablaPaloString.get(j));
              
                   cartas.add(valor2.toLowerCase()+constantes.tablaPaloString.get(j));
            
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
       ArrayList<String> cartas = new ArrayList<String>();
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
       boolean entro = false;
       for(int j = 0; j < 4; j++)
       {
           if(esCartaSinUsar(valor1.toLowerCase()+constantes.tablaPaloString.get(j)) && esCartaSinUsar(valor2.toLowerCase()+constantes.tablaPaloString.get(j)) && !entro)
           {
               entro = true;
            
                 cartas.add( valor1.toLowerCase()+constantes.tablaPaloString.get(j));
              
                   cartas.add(valor2.toLowerCase()+constantes.tablaPaloString.get(j));
            
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
       ArrayList<String> cartas = new ArrayList<String>();
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
  
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
       ArrayList<String> cartas = new ArrayList<String>();
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
  
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
       ArrayList<String> cartas = new ArrayList<String>();
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
  
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
       ArrayList<String> cartas = new ArrayList<String>();
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
  
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
                
                cartas.add(offSuitedCombinadas[k]);
                
               
            }
            
            return cartas;
        }
        else
        {
            return null;
        }
   }
   
   public ArrayList<String> dame2cartasLibresOffSuited(String valor1,String valor2)
   {
       ArrayList<String> cartas = new ArrayList<String>();
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
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
            usarCarta(cartas.get(1));
            return cartas;
        }
        else
        {
            return null;
        }
   }
    
   public ArrayList<String> dame2cartasLibresOffSuitedSinUsarCarta(String valor1,String valor2)
   {
       ArrayList<String> cartas = new ArrayList<String>();
       int cartasSinUsar = 0;
       AntiguasConstantes constantes = new AntiguasConstantes ();
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
        
        while(i < n)
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
         if(baraja[id].getDisponible())
         {
             return true;
         }
         else
         {
             return false;
         }
     }
    
    public Carta getCartaMasAlta(Carta [] cartas)
    {
        return getCartasOrdenadasMenorAMayor(cartas)[cartas.length-1];
    }
    public String getJugadaString(int n)
    {
        Carta [] cartas =generaJugada(n);
        String cadena = "";
        int i = 0;
        while(i < n)
        {
            cadena = cadena + cartas[i].getDigito()+cartas[i].getPalo();
            i++;
        }
        
        return cadena.toUpperCase();
    }
    //daria ordenadas todas las cartas usadas hasta el momento
    public String getStringCartasOrdenadasPorPaloMenorAMayor(Carta [] cartas)
    {
        int max = 0;
        boolean[][] matrizCartas = new boolean[4][14];
        AntiguasConstantes c = new AntiguasConstantes();
        
        for(int i= 0; i < 4;i++)
         {
             for(int j= 0; j < 14;j++)
             {
                 matrizCartas[i][j] = true;
             }
         }
        for(int i = 0; i < cartas.length;i++)
        {
            String digito = cartas[i].getDigito();
            String palo = cartas[i].getPalo();
            
            matrizCartas[c.tablaStringPalo.get(palo)][cartas[i].getValor()] = false;
        }
      
        String cadena = "";
        for(int i = 0; i < 4.; i++)
        {
            for(int j = 0; j < 14;j++)
            {
                if(!matrizCartas[i][j])
                {
                  cadena = cadena + c.tablaValorString.get(j) + c.tablaPaloString.get(i);
   
                    
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
