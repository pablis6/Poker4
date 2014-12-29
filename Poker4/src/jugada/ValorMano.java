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
 * aqui se haran las combinaciones posibles para generar la 
 * mejor mano. Habra que incluir todas las manos existentes
 * en el poker, escalera de color, poker, full.....
 * 
 * 
 */
public class ValorMano
{
    AntiguasConstantes cons;
    /*
    int matCartas [][] ;
    String[] cadena;
    int car[];
    int palos[];*/
    public ValorMano()
    {
       AntiguasConstantes cons = new AntiguasConstantes();
       int [][] matCartas = new int[4][14];
       
       int []car = new int[13];
       int []palos = new int[4];
    }
    
    public String[] escaleraColor(Carta []cartas)
    {
        //matriz de cartas de 4 palos y 14 tipos de carta
        
        AntiguasConstantes cons = new AntiguasConstantes();
       int [][] matCartas = new int[4][14];
       String []cadena= new String[6];
       int []car = new int[13];
       int []palos = new int[4];
        
        //inicializacion
        
        for(int i =0; i < 4; i++)
        {
            for(int j = 0; j < 14;j++)
            {
                matCartas[i][j] = 0;
            }
        }
        
        //String[] cadena= new String[2];
        cadena[0] = "";
        cadena[1] = "";
        cadena[2] = "";
        cadena[3] = "";
        cadena[4] = "";
        cadena[5] = "";
        //colocamos las cartas en la matriz
        for(int i = 0; i < cartas.length ;i++)
        {
            String digito = cartas[i].getDigito();
            String palo = cartas[i].getPalo();
            matCartas[cons.tablaStringPalo.get(palo)] [cons.tablaStringValor.get(digito)]= 1;
        }
        //caso excepcional, escalera real
        boolean hayEscalera = false;
        boolean faltaCartaEnMedio = false;
        for(int i = 0; i < 4;i++)
        {
            /*
            //posible draw
            if( matCartas[i][cons.KING] + matCartas[i][cons.QUEEN] + matCartas[i][cons.JACK] <3)
            {
                faltaCartaEnMedio = true;
            }
            if(matCartas[i][cons.ACE] + matCartas[i][cons.KING] + matCartas[i][cons.QUEEN] + matCartas[i][cons.JACK] + matCartas[i][cons.TEN] == 4
                     && cartasComunes<5 )
            {
                
                if(!faltaCartaEnMedio)
                {
                    cadena[0] = cons.DRAW + cons.STRAIGHT_FLUSH+ cons.OPEN_ENDED+ "\n";
                }
                else
                {
                      cadena[0] = cons.DRAW + cons.STRAIGHT_FLUSH+ cons.GUTSHOT+ "\n";
            
                }
            }
            */
            //mejor mano
             if(matCartas[i][cons.ACE] + 
                     matCartas[i][cons.KING] + 
                     matCartas[i][cons.QUEEN] + 
                     matCartas[i][cons.JACK] + 
                     matCartas[i][cons.TEN] == 5)
             {
                 cadena[0]= cons.BEST_HAND +cons.STRAIGHT_FLUSH + " of " + cons.tablaValorString.get(0).toUpperCase()
                            + " " + cons.tablaValorString.get(9).toUpperCase()
                            + " " + cons.tablaValorString.get(10).toUpperCase()
                            + " " + cons.tablaValorString.get(11).toUpperCase()
                            + " " + cons.tablaValorString.get(12).toUpperCase()
                            + " of " + cons.tablaPaloString.get(i).toUpperCase() + "\n";
                 cadena[1] =cons.tablaValorString.get(cons.ACE).toLowerCase();
                 hayEscalera= true;
             }
        }
        
        //resto de escaleras de color
        if(!hayEscalera)
        {
            //recorremos los 4 palos y vemos si hay cartas correlativas
            for(int i = 0; i < 4;i++)
            {
                for(int j = cons.ACE; j <= cons.NINE;j++)
                {

                    if(matCartas[i][j] + matCartas[i][j+1] + matCartas[i][j+2]+ matCartas[i][j+3] + matCartas[i][j+4]==5)
                    {
                        cadena[0] = cons.BEST_HAND +cons.STRAIGHT_FLUSH + " of " + cons.tablaValorString.get(j).toUpperCase() 
                                + " " + cons.tablaValorString.get(j+1).toUpperCase()
                                + " " + cons.tablaValorString.get(j+2).toUpperCase()
                                + " " + cons.tablaValorString.get(j+3).toUpperCase()
                                + " " + cons.tablaValorString.get(j+4).toUpperCase()
                                + " of " + cons.tablaPaloString.get(i).toUpperCase()+ "\n";
                        cadena[1] = cons.tablaValorString.get(j+4).toLowerCase();
                        hayEscalera = true;
                    }
                    /*
                    else if(!hayEscalera)
                    {
                       //posible draw
                        faltaCartaEnMedio = false;
                        if(matCartas[i][j+1] + matCartas[i][j+2] + matCartas[i][j+3] <3)
                        {
                            faltaCartaEnMedio = true;
                        }
                        if(matCartas[i][j] + matCartas[i][j+1] + matCartas[i][j+2] + matCartas[i][j+3] + matCartas[i][j+4] == 4
                                 && cartasComunes<5)
                        {
                            if(!faltaCartaEnMedio)
                            {
                                cadena[0] = cons.DRAW + cons.STRAIGHT_FLUSH+ cons.OPEN_ENDED+ "\n";
                            }
                            else
                            {
                                  cadena[0] = cons.DRAW + cons.STRAIGHT_FLUSH+ cons.GUTSHOT+ "\n";

                            }
                        } 
                    }*/
                    
                    
                }
            }
        }
        return cadena;
    }
    
    
    public String[] poker(Carta [] cartas)
    {
        AntiguasConstantes cons = new AntiguasConstantes();
       int [][] matCartas = new int[4][14];
       String []cadena= new String[6];
       int []car = new int[13];
       int []palos = new int[4];
        //String[] cadena = new String[3];
        cadena[0] = "";
        cadena[1] = "";
        cadena[2] = "";
        cadena[3] = "";
        cadena[4] = "";
        cadena[5] = "";
        //boolean iguales = true;
        //int car[] = new int[13];
        for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }
        
        boolean hayPoker = false;
        boolean hayKicker = false;
        if(car[cons.ACE] == 4)
        {
            hayPoker = true;
            cadena[1] = cons.tablaValorString.get(cons.ACE);
            
            for(int i = cons.KING  ;i >0 && !hayKicker;i--)
            {
                if(car[i] > 0)
                {
                    cadena[2] = cons.tablaValorString.get(i);
                    hayKicker=true;
                }
                
            }  
            cadena[0]  = cons.BEST_HAND + cons.FOUR_OF_A_KIND + " of " + cadena[1] + " with kicker " + cadena[2].toUpperCase()+ "\n";
            
        }
        else
        {
            
            for(int i = cons.KING  ;i >0;i--)
            {
                
                if(car[i] ==4 && cadena[1].equalsIgnoreCase(""))
                {
                    
                    cadena[1] = cons.tablaValorString.get(i);
                    cadena[0]  = cons.BEST_HAND + cons.FOUR_OF_A_KIND + " of " + cadena[1] + " with kicker " + cadena[2].toUpperCase()+ "\n";
            
                    hayPoker = true;
                }
                if(hayPoker && !cadena[1].equalsIgnoreCase("") && cadena[2].equalsIgnoreCase(""))
                {
                    cadena[2] = cons.tablaValorString.get(i);        
                }
            }
        }
        return cadena;
    }
    
    public String[] full (Carta[] cartas)
    {
        AntiguasConstantes cons = new AntiguasConstantes();
       int [][] matCartas = new int[4][14];
       String []cadena= new String[6];
       int []car = new int[13];
       int []palos = new int[4];
        //String cadena []= new String[3];
        cadena[0] = "";
        cadena[1] = "";
        cadena[2] = "";
        cadena[3] = "";
        cadena[4] = "";
        cadena[5] = "";
        //int car[] = new int[13];
        for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
                  
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }
      
        boolean drawpar1 = false;
        boolean drawpar2 = false;
        String par1 = "";
        String par2 = "";
        
        //caso trio ASES
        if(car[cons.ACE] == 3)
        {
            cadena[1] = cons.tablaValorString.get(0);
            for(int i = 1; i < 13; i++)
            {
                if(car[i]>=2 && !cadena[1].equalsIgnoreCase(cons.tablaValorString.get(i)))
                {
                    if(drawpar1)
                    {
                        drawpar2 = true;
                        par2 = cons.tablaValorString.get(i);
                    }
                    if(!drawpar1)
                    {
                        drawpar1= true;
                        par1 = cons.tablaValorString.get(i);
                    }

                    cadena[2] = cons.tablaValorString.get(i);

                }
            }
        }
        else
        {
            for(int i = 0; i < 13; i++)
            {
                //posible draw = 2 parejas

                if(car[i]==3)
                {
                    cadena[1] = cons.tablaValorString.get(i);
                }
                if(car[i]>=2 && !cadena[1].equalsIgnoreCase(cons.tablaValorString.get(i)))
                {
                    if(drawpar1)
                    {
                        drawpar2 = true;
                        par2 = cons.tablaValorString.get(i);
                    }
                    if(!drawpar1)
                    {
                        drawpar1= true;
                        par1 = cons.tablaValorString.get(i);
                    }

                    cadena[2] = cons.tablaValorString.get(i);

                }
            }
        }
       
        if(cadena[1].compareTo("")!=0 && cadena[2].compareTo("")!=0)
        {
            cadena[0] =cons.BEST_HAND + cons.FULL_HOUSE + " of " + cadena[1].toUpperCase() + " with pair of " + cadena[2].toUpperCase()+ "\n";
            
        }
       /* else if(drawpar1 && drawpar2 && cartasComunes<5)
        {
            cadena = cons.DRAW + cons.FULL_HOUSE + " of possible "+ cons.THREE_OF_A_KIND+ " of " + par1.toUpperCase() + " and pair of " + par2.toUpperCase()+ "\n"; 
            cadena = cadena +cons.DRAW + cons.FULL_HOUSE + " of possible "+ cons.THREE_OF_A_KIND+ " of " + par2.toUpperCase() + " and pair of " + par1.toUpperCase()+ "\n";
        }*/
       
        
        return cadena;
    }
    public String [] color(Carta [] cartas)
    {
        AntiguasConstantes cons = new AntiguasConstantes();
       int [][] matCartas = new int[4][14];
       String []cadena= new String[6];
       int []car = new int[13];
       int []palos = new int[4];
        //String cadena [] = new String[6];
        cadena[0] ="";
        cadena[1] ="";
        cadena[2] ="";
        cadena[3] ="";
        cadena[4] ="";
        cadena[5] ="";
       
        boolean hayColor = false;
        //int palos[] = new int[4];
        palos[0] = 0;
        palos[1] = 0;
        palos[2] = 0;
        palos[3] = 0;
        
        for(int i =0; i < 4; i++)
        {
            for(int j = 0; j < 14;j++)
            {
                matCartas[i][j] = 0;
            }
        }
       
        //colocamos las cartas en la matriz
        for(int i = 0; i < cartas.length ;i++)
        {
            String digito = cartas[i].getDigito();
            String palo = cartas[i].getPalo();
            matCartas[cons.tablaStringPalo.get(palo)] [cons.tablaStringValor.get(digito)]= 1;
        }
        
        int palo;
        for (int i = 0; i < cartas.length;i++)
        {
            palo = cons.tablaStringPalo.get(cartas[i].getPalo());
            
            palos[palo] = palos[palo] + 1;          
        }
        
        if(palos[cons.CLUBS]>=5 )
        {
            hayColor = true;
            palo = cons.CLUBS;
            
            //miramos el as
             int j = 1;
            if(matCartas[cons.CLUBS][0] == 1)
            {
                cadena[j] = cons.tablaValorString.get(cons.ACE);
                j++;
            }
           
            for(int i = 13; i >0 ; i--)
            {
                
                if(matCartas[cons.CLUBS][i] == 1 && j <6)
                {
                    cadena[j] = cons.tablaValorString.get(i);
                    j++;
                }
                
            }
        }
        else if(palos[cons.DIAMONDS] >=5)
        {
            hayColor = true;
            palo = cons.DIAMONDS;
             int j = 1;
            if(matCartas[cons.DIAMONDS][0] == 1)
            {
                cadena[j] = cons.tablaValorString.get(cons.ACE);
                j++;
            }
           
            for(int i = 13; i >0 ; i--)
            {
                
                if(matCartas[cons.DIAMONDS][i] == 1 && j <6)
                {
                    cadena[j] = cons.tablaValorString.get(i);
                    j++;
                }
                
            }
        }
        else if(palos[cons.HEARTS] >=5)
        {
            hayColor = true;
            palo = cons.HEARTS;
             int j = 1;
            if(matCartas[cons.HEARTS][0] == 1)
            {
                cadena[j] = cons.tablaValorString.get(cons.ACE);
                j++;
            }
           
            for(int i = 13; i >0 ; i--)
            {
                
                if(matCartas[cons.HEARTS][i] == 1 && j <6)
                {
                    cadena[j] = cons.tablaValorString.get(i);
                    j++;
                }
                
            }
        }
        else if(palos[cons.SPADES] >=5)
        {
            hayColor = true;
            
            palo = cons.SPADES;
             int j = 1;
            if(matCartas[cons.SPADES][0] == 1)
            {
                cadena[j] = cons.tablaValorString.get(cons.ACE);
                j++;
            }
           
            for(int i = 13; i >0 ; i--)
            {
                
                if(matCartas[cons.SPADES][i] == 1 && j <6)
                {
                    cadena[j] = cons.tablaValorString.get(i);
                    j++;
                }
                
            }
            
        }
        
        
        if(hayColor)
        {
            cadena[0] = cons.BEST_HAND + cons.FLUSH+ " " +cadena[1].toUpperCase() + " " + cadena[2].toUpperCase() + " "+cadena[3].toUpperCase() + " "+cadena[4].toUpperCase() + " "+cadena[5].toUpperCase() +"\n";

        }
        
        
        return cadena;
    }
    
    public String[] escalera(Carta [] cartas)
    {
        AntiguasConstantes cons = new AntiguasConstantes();
       int [][] matCartas = new int[4][14];
       String []cadena= new String[6];
       int []car = new int[13];
       int []palos = new int[4];
        
       //String cadena[] = new String[2] ;
        cadena[0] ="";
        cadena[1] ="";
        cadena[2] ="";
        cadena[3] ="";
        cadena[4] ="";
        cadena[5] ="";
       
        
        
        for(int i =0; i < 4; i++)
        {
            for(int j = 0; j < 14;j++)
            {
                matCartas[i][j] = 0;
            }
        }
        //colocamos las cartas en la matriz
        for(int i = 0; i < cartas.length ;i++)
        {
            matCartas[cons.tablaStringPalo.get(cartas[i].getPalo())] [cons.tablaStringValor.get(cartas[i].getDigito())]= 1;
        }
        boolean hayEscalera = false;
        
        //caso excepcional, escalera acabada en as
        if((matCartas[cons.CLUBS][cons.ACE] + 
            matCartas[cons.DIAMONDS][cons.ACE] + 
            matCartas[cons.HEARTS][cons.ACE] + 
            matCartas[cons.SPADES][cons.ACE] )>=1 
         && (matCartas[cons.CLUBS][cons.TEN] + 
             matCartas[cons.DIAMONDS][cons.TEN] + 
             matCartas[cons.HEARTS][cons.TEN] +
             matCartas[cons.SPADES][cons.TEN] )>=1
         && (matCartas[cons.CLUBS][cons.JACK] + 
             matCartas[cons.DIAMONDS][cons.JACK] + 
             matCartas[cons.HEARTS][cons.JACK] + 
             matCartas[cons.SPADES][cons.JACK] )>=1
         && (matCartas[cons.CLUBS][cons.QUEEN] + 
             matCartas[cons.DIAMONDS][cons.QUEEN] +
             matCartas[cons.HEARTS][cons.QUEEN] + 
             matCartas[cons.SPADES][cons.QUEEN] )>=1
         && (matCartas[cons.CLUBS][cons.KING] +  
             matCartas[cons.DIAMONDS][cons.KING] + 
             matCartas[cons.HEARTS][cons.KING] + 
             matCartas[cons.SPADES][cons.KING])>=1)
        {
            cadena[0] = cons.BEST_HAND + cons.STRAIGHT + " of " 
                            + cons.tablaValorString.get(9).toUpperCase()
                            + " " + cons.tablaValorString.get(10).toUpperCase()
                            + " " + cons.tablaValorString.get(11).toUpperCase()
                            + " " + cons.tablaValorString.get(12).toUpperCase()
                            + " " + cons.tablaValorString.get(0).toUpperCase() + "\n";
            cadena[1] = cons.tablaValorString.get(cons.ACE).toLowerCase();
            hayEscalera= true;
        }
       
     
        if(!hayEscalera)
        {
            int i = 0;
            for(int j = 0; j < 9;j++)
            {
                if((matCartas[i][j] + matCartas[i+1][j] + matCartas[i+2][j] + matCartas[i+3][j]) >=1
                && (matCartas[i][j+1]+ matCartas[i+1][j+1] + matCartas[i+2][j+1] + matCartas[i+3][j+1])>=1
                && (matCartas[i][j+2] + matCartas[i+1][j+2] + matCartas[i+2][j+2] + matCartas[i+3][j+2])>=1
                && (matCartas[i][j+3] + matCartas[i+1][j+3] + matCartas[i+2][j+3] + matCartas[i+3][j+3])>=1
                && (matCartas[i][j+4] + matCartas[i+1][j+4] + matCartas[i+2][j+4] + matCartas[i+3][j+4])>=1)
                 {       
                    cadena[0] = cons.BEST_HAND + cons.STRAIGHT + " of " + cons.tablaValorString.get(j).toUpperCase() 
                            + " " + cons.tablaValorString.get(j+1).toUpperCase()
                            + " " + cons.tablaValorString.get(j+2).toUpperCase()
                            + " " + cons.tablaValorString.get(j+3).toUpperCase()
                            + " " + cons.tablaValorString.get(j+4).toUpperCase()+ "\n";
                     cadena[1] =cons.tablaValorString.get(j+4).toLowerCase();
                 
                }
                
            }
        }
        
        return cadena;
    }
    public String [] trio (Carta[] cartas)
    {
        AntiguasConstantes cons = new AntiguasConstantes();
       int [][] matCartas = new int[4][14];
       String []cadena= new String[6];
       int []car = new int[13];
       int []palos = new int[4];
        //String cadena[] = new String[4];
         cadena[0] ="";
        cadena[1] ="";
        cadena[2] ="";
        cadena[3] ="";
        cadena[4] ="";
        cadena[5] ="";
        //int car[] = new int[13];
        for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }
        
        
        //caso excepcional de tener doble pareja, ya que si sale una tercera carta , no hariamos trio
        //sino full
        
        //recorremos desde el a hasta k y vemos cuantos de cada hay
        boolean tri = false;
        if(car[cons.ACE] ==3)
        {
            cadena[1] = cons.tablaValorString.get(cons.ACE);
            tri = true;
        }
        for(int i = 12; i > 0 && !tri; i--)
        {
            //mejor mano
            if(car[i]==3 )
            {
                cadena[1] = cons.tablaValorString.get(i);
                tri = true;
            }
           
        }
        
        if(tri)
        {
            cadena[0] = cons.BEST_HAND + cons.THREE_OF_A_KIND + " of " + cadena[1].toUpperCase() + "\n";
           
            
            //comprobamos el kicker mas alto
            int indKick = 2;
            //primeros los ases
            if(car[cons.ACE] == 1)
            {
                
                cadena[indKick] =cons.tablaValorString.get(cons.ACE).toLowerCase();
                indKick ++;
            }
            
            int i = cons.KING;
            
            while(i >0  && indKick <4)
            {
                
                
               
                if(car[i] == 1)
                {
                 
                    cadena[indKick] = cons.tablaValorString.get(i).toLowerCase();
                    
                   indKick++;
                }
                i--;
            }
        
            //si tenemos un trio, tambien podemos optar a hacer un full
            /*if(cartasComunes < 5)
            {
                cadena += cons.DRAW + cons.FULL_HOUSE + " of " + trio.toUpperCase() + " with other pair" + "\n";
            }*/
            
            
        }
       
        
        return cadena;
    }
    // falla la doble pareja con este patron, arreglar!  
    // 2h4h2s3s4s5s3d
    public String[] doblePareja(Carta [] cartas)
    {
        AntiguasConstantes cons = new AntiguasConstantes();
       int [][] matCartas = new int[4][14];
       String []cadena= new String[6];
       int []car = new int[13];
       int []palos = new int[4];
        //String cadena []= new String[4];
         cadena[0] ="";
        cadena[1] ="";
        cadena[2] ="";
        cadena[3] ="";
        cadena[4] ="";
        cadena[5] ="";
        //int car[] = new int[13];
        for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
                  
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }
      
        String par1 ="";
        String par2="";
        String kicker="";
   
        
        //caso pareja ASES
        if(car[cons.ACE] == 2)
        {
            par1 = cons.tablaValorString.get(cons.ACE);
            for(int i = cons.KING; i > 0; i--)
            {
                
                //buscamos la pareja menor
                if(car[i] == 2 && !par1.equalsIgnoreCase("") && par2.equalsIgnoreCase(""))
                {
                    par2 = cons.tablaValorString.get(i);
                }
                
            }
            
            //buscamos el kicker
            int i = cons.KING;
            boolean encontrado = false;
            while(i > 0 && !encontrado)
            {
                if(car[i] >0)
                {
                  if(!par1.equalsIgnoreCase(cons.tablaValorString.get(i)) && !par2.equalsIgnoreCase(cons.tablaValorString.get(i)))
                  {
                        kicker = cons.tablaValorString.get(i);
                        encontrado = true;
                  }  
                  
                }
                
                i--;
            }
        }
        else
        {
            
            for(int i = cons.KING; i > 0; i--)
            {
               
                //buscamos la pareja menor
                if(car[i] == 2 && !par1.equalsIgnoreCase("") && par2.equalsIgnoreCase(""))
                {
                    par2 = cons.tablaValorString.get(i);
                }
                //buscamos la pareja mayor
                if(car[i] == 2 && par1.equalsIgnoreCase(""))
                {
                    par1 = cons.tablaValorString.get(i);
                    
                }
            }
            //buscamos el kicker
            int i = cons.KING;
            boolean encontrado = false;
            
            if(car[cons.ACE] == 1)
            {
                kicker = cons.tablaValorString.get(cons.ACE);
            }
            else
            {
                while(i > 0 && !encontrado)
                {
                    if(car[i] >0)
                    {
                      if(!par1.equalsIgnoreCase(cons.tablaValorString.get(i)) && !par2.equalsIgnoreCase(cons.tablaValorString.get(i)))
                      {
                            kicker = cons.tablaValorString.get(i);
                            encontrado = true;
                      }  

                    }

                    i--;
                }
            }
        }
       
        if(!par1.equalsIgnoreCase("")&& !par2.equalsIgnoreCase(""))
        {
            cadena[0] =cons.BEST_HAND + cons.TWO_PAIR + " of " + par1.toUpperCase() + " with pair of " + par2.toUpperCase()+ " with kicker " + kicker.toUpperCase() + "\n";
            cadena[1] = par1.toLowerCase();
            cadena[2] = par2.toLowerCase();
            cadena[3] = kicker.toLowerCase();
        }
        
        return cadena;
    }
    public String[] pareja(Carta [] cartas)
    {
        AntiguasConstantes cons = new AntiguasConstantes();
       int [][] matCartas = new int[4][14];
       String []cadena= new String[6];
       int []car = new int[13];
       int []palos = new int[4];
       //String cadena[] = new String[5];
        //int car[] = new int[13];
       
         cadena[0] ="";
        cadena[1] ="";
        cadena[2] ="";
        cadena[3] ="";
        cadena[4] ="";
        cadena[5] ="";
        
        for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }
        
        String pareja ="";
        String kick1 = "";
        String kick2 = "";
        String kick3 = "";
        
        
        //caso AS
        if(car[cons.ACE] == 2)
        {
            pareja = cons.tablaValorString.get(cons.ACE);
            int i = cons.KING;
            //buscamos los kicker
            int contKicker =0 ;
            while(i > 0 && contKicker <3)
            {
                if (car[i] == 1 && !kick1.equalsIgnoreCase("") && !kick2.equalsIgnoreCase("") && kick3.equalsIgnoreCase(""))
                {
                    kick3 = cons.tablaValorString.get(i);
                    contKicker++;
                }
                if (car[i] == 1 && !kick1.equalsIgnoreCase("") && kick2.equalsIgnoreCase("") )
                {
                    kick2 = cons.tablaValorString.get(i);
                    contKicker++;
                }
                if (car[i] == 1 && kick1.equalsIgnoreCase(""))
                {
                    kick1 = cons.tablaValorString.get(i);
                    contKicker++;
                }

                i--;
            }
        }
        else
        {
            //buscamos la pareja mas alta
            int i = cons.KING;
            boolean encontrado = false;
            while(i > 0 && !encontrado)
            {
                if(car[i] == 2)
                {   
                    encontrado = true;
                    pareja =cons.tablaValorString.get(i);
                }
                i--;
            }
            //buscamos los kicker
            int contKicker =0 ;
            i = cons.KING;
            if(encontrado)
            {
                while(i > 0 && contKicker <3)
                {
                    if (car[i] == 1 && !kick1.equalsIgnoreCase("") && !kick2.equalsIgnoreCase("") && kick3.equalsIgnoreCase(""))
                    {
                        kick3 = cons.tablaValorString.get(i);
                        contKicker++;
                    }
                    if (car[i] == 1 && !kick1.equalsIgnoreCase("") && kick2.equalsIgnoreCase("") )
                    {
                        kick2 = cons.tablaValorString.get(i);
                        contKicker++;
                    }
                    if (car[i] == 1 && kick1.equalsIgnoreCase(""))
                    {
                        kick1 = cons.tablaValorString.get(i);
                        contKicker++;
                    }

                    i--;
                }
            }
           
        }
        
        if(!pareja.equalsIgnoreCase(""))
        {
            cadena[0] =cons.BEST_HAND + cons.PAIR + " of " + pareja.toUpperCase() + " with kickers of " + kick1.toUpperCase()+ " , " + kick2.toUpperCase()+ " , " + kick3.toUpperCase() + "\n";
            cadena[1] = pareja.toLowerCase();
            cadena[2] = kick1.toLowerCase();
            cadena[3] = kick2.toLowerCase();
            cadena[4] = kick3.toLowerCase();
        }
        
        return cadena;
    }
    
    public String[] cartaAlta(Carta [] cartas)
    {
        AntiguasConstantes cons = new AntiguasConstantes();
       int [][] matCartas = new int[4][14];
       String []cadena= new String[6];
       int []car = new int[13];
       int []palos = new int[4];
       //String cadena[] = new String[6];
        cadena[0] = "";
        cadena[1] = "";
        cadena[2] = "";
        cadena[3] = "";
        cadena[4] = "";
        cadena[5] = "";
        
        //int car[] = new int[13];
        for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
         
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }
        
        //comprobamos los ases primero
        int indice = 1;
        if(car[0] ==1)
        {
            cadena[0] = cons.BEST_HAND + cons.HIGH_CARD + " ";
            cadena[indice] = cons.tablaValorString.get(cons.ACE).toLowerCase();
            indice++;
            int j = cons.KING;
            while(j > 0 && indice < 6)
            {
                if(car[j] >0)
                {
                    cadena[indice] = cons.tablaValorString.get(j).toLowerCase();
                    indice++;
                }
                j--;
                
            }
            
            //metemos los kickers a la cadena final
            for(int i = 1; i < 6;i++)
            {
                cadena[0] = cadena[0] + " " + cadena[i].toUpperCase();
            }
            cadena[0] = cadena[0] + "\n";
        }
        else
        {
            int i = cons.KING;
            while(car[i] != 1)
            {
                //cadena[1] = cons.tablaValorString.get(i).toLowerCase();
                i--;
                
            }
            //cadena[1] = cons.tablaValorString.get(i).toLowerCase();
            //indice ++;
            cadena[0] = cons.BEST_HAND + cons.HIGH_CARD + " ";
            
            int j = i;
            while(j > 0 && indice < 6)
            {
                if(car[j] >0)
                {
                    cadena[indice] = cons.tablaValorString.get(j).toLowerCase();
                    indice++;
                }
                j--;
            }
            
            //metemos los kickers a la cadena final
            for(int k = 1; k < 6;k++)
            {
                cadena[0] = cadena[0] + " " + cadena[k].toUpperCase();
            }
            cadena[0] = cadena[0] + "\n";
        }
        return cadena;
    }
    public String [] valorarMiMano(Carta []cartas)
    {
        
        String cadena [] ;
        
        for(int i = 0; i < cartas.length;i++)
        {
            System.out.println(cartas[i].getDenominacion());
        }
        //COMPROBAMOS ESCALERA DE COLOR
        //cadena = escaleraColor(cartas);
        cadena = escaleraColor(cartas);
        System.out.println(cadena[0]);
        if(cadena[0].length() ==0 )
        {
            cadena = poker(cartas);
             System.out.println(cadena[0]);
            if(cadena[0].length() ==0 )
            {
                cadena = full(cartas);
                if(cadena[0].length() ==0 )
                {
                    cadena = color(cartas);
                    if(cadena[0].length() ==0 )
                    {
                        cadena = escalera(cartas);
                        if(cadena[0].length() ==0 )
                        {
                            cadena = trio(cartas);
                            if(cadena[0].length() ==0 )
                            {
                                cadena = doblePareja(cartas);
                                if(cadena[0].length() ==0 )
                                {
                                    cadena = pareja(cartas);
                                    
                                    if(cadena[0].length() ==0 )
                                    {
                                        cadena = cartaAlta(cartas);
                                    }
                                }
                            }
                        }
                    }
                }
           }
        }
        
        /*
        String draws = "";
        
        
        //COMPROBAMOS ESCALERA DE COLOR
        //cadena = escaleraColor(cartas);
        cadena = escaleraColor(cartas,cartasComunes);
        
        //usamos los try porque se puede dar la situacion de intentar sacar un substring
        //del vacio, ya que hay jugadas que no se dan y la cadena es vacia.
        try
        {
            if(cadena[0].substring(0, cons.DRAW.length()).compareTo(cons.DRAW)==0)
            {
                draws =  draws + cadena[0];
                cadena[0] = "";
            
            }
        }
        catch(Exception e)
        {
                 
        }
        
            
        //comprobamos poker
        if(cadena[0].equalsIgnoreCase(""))
        {
            cadena = poker(cartas,cartasComunes);
        }
        
        try
        {
            if(cadena[0].substring(0, cons.DRAW.length()).compareTo(cons.DRAW)==0)
            {
                draws =  draws + cadena[0];
                cadena[0] = "";
            
            }   
        }
        catch(Exception e)
        {
              
        }
        
        //COMPROBAMOS FULL
        if(cadena[0].equalsIgnoreCase(""))
        {
            cadena = full(cartas);
        }
        
        try
        {
            if(cadena[0].substring(0, cons.DRAW.length()).compareTo(cons.DRAW)==0)
            {
                draws =  draws  + cadena[0];
                cadena[0] = "";
            
            }   
        }
        catch(Exception e)
        {
              
        }
        //comprobamos color
        
        if(cadena[0].equalsIgnoreCase(""))
        {
            cadena = color(cartas,cartasComunes);
        }
        
        try
        {
            if(cadena[0].substring(0, cons.DRAW.length()).compareTo(cons.DRAW)==0)
            {
                draws =  draws  + cadena[0];
                cadena[0] = "";
            
            }   
        }
        catch(Exception e)
        {
              
        }
        //COMPROBAMOS ESCALERA
       if(cadena[0].equalsIgnoreCase(""))
        {
            cadena = escalera(cartas,cartasComunes);
        }
        
        try
        {
            if(cadena[0].substring(0, cons.DRAW.length()).compareTo(cons.DRAW)==0)
            {
                draws =  draws  + cadena[0];
                cadena[0] = "";
            
            }   
        }
        catch(Exception e)
        {
              
        }
        
        //COMPROBAMOS TRIO
        if(cadena[0].equalsIgnoreCase(""))
        {
            cadena = trio(cartas,cartasComunes);
        }
        
        try
        {
            if(cadena[0].substring(0, cons.DRAW.length()).compareTo(cons.DRAW)==0)
            {           
                draws =  draws  + cadena[0];
                cadena[0] = "";            
            }   
        }
        catch(Exception e)
        {
              
        }
        //COMPROBAMOS DOBLE Pareja
        if(cadena[0].equalsIgnoreCase(""))
        {
                
            cadena = doblePareja(cartas);
        }
        
        try
        {
            if(cadena[0].substring(0, cons.DRAW.length()).compareTo(cons.DRAW)==0)
            {
                draws =  draws  + cadena[0];
                cadena[0] = "";
            
            }   
        }
        catch(Exception e)
        {
              
        }
        //COMPROBAMOS Pareja
        if(cadena[0].equalsIgnoreCase(""))
        {
            cadena = pareja(cartas,cartasComunes);
        }
        
        try
        {
            if(cadena[0].substring(0, cons.DRAW.length()).compareTo(cons.DRAW)==0)
            {
                draws =  draws  + cadena[0];
                cadena[0] = "";
            
            }   
        }
        catch(Exception e)
        {
              
        }
        try
        {
            if(cadena[0].equalsIgnoreCase(""))
            {
                cadena = cartaAlta(cartas,cartasComunes);
            }
        }
        catch(Exception e)
        {
             cadena = new String[6];   
             cadena = cartaAlta(cartas,cartasComunes);
        }
        
        
        cadena[0] += draws;*/
        
        return cadena;
    }
    /*
    public String[] mejorMano(int jugadoresMax, String cartas[], String board[], Baraja baraja){
        String mejor;
        String cadena = "";
        String auxCartas[] = new String[cartas.length];
        int index = 0;
        
        for(int k = 0; k< jugadoresMax; k++){
            mejor = "";
            
            for (int j = 0; j < cartas.length; j++){
                cadena = valorarMiMano(baraja.generaCartasConString(cartas[j].substring(2) + board[0]), 5);
                mejor = esMejor(cadena[1], mejor);
                if(mejor.equalsIgnoreCase(cadena[1])){
                    index = j;
                }
            }
            auxCartas[k]= cartas[index];
            cartas = borra(cartas, index);
        }
        return auxCartas;
    }

    //borra una mano que ya hemos valorado como la mejor
    private String[] borra(String[] cartas, int indice){
        String[] aux = new String [cartas.length - 1]; 
        int j = 0;//indice de pegado
        
        for(int i = 0; i < cartas.length; i++){
            if (i != indice){
                aux[j] = cartas[i];
                j++;
            }
        }
        return aux;
    }
    
    //comueba si "cadena" es mejor que "mejor"
    private String esMejor(String cadena, String mejor) {
        if(mejor.equalsIgnoreCase(""))
            mejor = cadena;
        else if(cadena.equalsIgnoreCase(cons.STRAIGHT_FLUSH)) //es escalera
            mejor = cadena;
        else if(cadena.equalsIgnoreCase(cons.FOUR_OF_A_KIND) && //es un poker
                !mejor.equalsIgnoreCase(cons.STRAIGHT_FLUSH))   //y la mejor no es mejor que la nueva
            mejor = cadena;
        else if(cadena.equalsIgnoreCase(cons.FULL_HOUSE) && //es un full
                (!mejor.equalsIgnoreCase(cons.STRAIGHT_FLUSH) && //y la mejor no es mejor que la nueva
                !mejor.equalsIgnoreCase(cons.FOUR_OF_A_KIND)))   
            mejor = cadena;
        else if(cadena.equalsIgnoreCase(cons.FLUSH) && //es un color
                (!mejor.equalsIgnoreCase(cons.STRAIGHT_FLUSH) && //y la mejor no es mejor que la nueva
                !mejor.equalsIgnoreCase(cons.FOUR_OF_A_KIND) &&
                !mejor.equalsIgnoreCase(cons.FULL_HOUSE)))
            mejor = cadena;
        else if(cadena.equalsIgnoreCase(cons.STRAIGHT) && //es un escalera
                (!mejor.equalsIgnoreCase(cons.STRAIGHT_FLUSH) && //y la mejor no es mejor que la nueva
                !mejor.equalsIgnoreCase(cons.FOUR_OF_A_KIND) &&
                !mejor.equalsIgnoreCase(cons.FULL_HOUSE) &&
                !mejor.equalsIgnoreCase(cons.FLUSH)))
            mejor = cadena;
        else if(cadena.equalsIgnoreCase(cons.THREE_OF_A_KIND) && //es un trio
                (!mejor.equalsIgnoreCase(cons.STRAIGHT_FLUSH) && //y la mejor no es mejor que la nueva
                !mejor.equalsIgnoreCase(cons.FOUR_OF_A_KIND) &&
                !mejor.equalsIgnoreCase(cons.FULL_HOUSE) &&
                !mejor.equalsIgnoreCase(cons.FLUSH) &&
                !mejor.equalsIgnoreCase(cons.STRAIGHT)))
            mejor = cadena;
        else if(cadena.equalsIgnoreCase(cons.TWO_PAIR) && //es una dobles parejas
                (!mejor.equalsIgnoreCase(cons.STRAIGHT_FLUSH) && //y la mejor no es mejor que la nueva
                !mejor.equalsIgnoreCase(cons.FOUR_OF_A_KIND) &&
                !mejor.equalsIgnoreCase(cons.FULL_HOUSE) &&
                !mejor.equalsIgnoreCase(cons.FLUSH) &&
                !mejor.equalsIgnoreCase(cons.STRAIGHT) &&
                !mejor.equalsIgnoreCase(cons.THREE_OF_A_KIND)))
            mejor = cadena;
        else if(cadena.equalsIgnoreCase(cons.PAIR) && //es una pareja
                (!mejor.equalsIgnoreCase(cons.STRAIGHT_FLUSH) && //y la mejor no es mejor que la nueva
                !mejor.equalsIgnoreCase(cons.FOUR_OF_A_KIND) &&
                !mejor.equalsIgnoreCase(cons.FULL_HOUSE) &&
                !mejor.equalsIgnoreCase(cons.FLUSH) &&
                !mejor.equalsIgnoreCase(cons.STRAIGHT) &&
                !mejor.equalsIgnoreCase(cons.THREE_OF_A_KIND) &&
                !mejor.equalsIgnoreCase(cons.TWO_PAIR)))   
            mejor = cadena;
        else if(cadena.equalsIgnoreCase(cons.PAIR) && //es una carta alta
                (!mejor.equalsIgnoreCase(cons.STRAIGHT_FLUSH) && //y la mejor no es mejor que la nueva
                !mejor.equalsIgnoreCase(cons.FOUR_OF_A_KIND) &&
                !mejor.equalsIgnoreCase(cons.FULL_HOUSE) &&
                !mejor.equalsIgnoreCase(cons.FLUSH) &&
                !mejor.equalsIgnoreCase(cons.STRAIGHT) &&
                !mejor.equalsIgnoreCase(cons.THREE_OF_A_KIND) &&
                !mejor.equalsIgnoreCase(cons.TWO_PAIR) &&
                !mejor.equalsIgnoreCase(cons.PAIR)))
            mejor = cadena;
        
        return mejor;
    }*/
}
