/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugada;

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
    
    int matCartas [][] ;
    //String[] cadena;
    
    int car[];
    int palos[];
    int cadena[];
            
    public ValorMano()
    {
       cons = new AntiguasConstantes();
       matCartas = new int[4][14];
       cadena= new int[6];
       car = new int[13];
       palos = new int[4];
    }
    
    public int[] escaleraColor(Carta []cartas)
    {
        //matriz de cartas de 4 palos y 14 tipos de carta
        
       
       
       //car = new int[13];
       //palos = new int[4];
        
        //inicializacion
        /*
        for(int i =0; i < 4; i++)
        {
            for(int j = 0; j < 14;j++)
            {
                matCartas[i][j] = 0;
            }
        }
        */
        //String[] cadena= new String[2];
        /*for(int j = 0; j < 6;j++)
            cadena[j]= 0;*/
        //colocamos las cartas en la matriz
        /*
        for(int i = 0; i < cartas.length ;i++)
        {
            matCartas[cons.tablaStringPalo.get(cartas[i].getPalo())] [cons.tablaStringValor.get(cartas[i].getDigito())]= 1;
        }*/
        //caso excepcional, escalera real
        boolean hayEscalera = false;
        
        
        
            //recorremos los 4 palos y vemos si hay cartas correlativas
            for(int i = 0; i < 4;i++)
            {
                for(int j = cons.TEN; j >= cons.TWO;j--)
                {

                    if(matCartas[i][j] + matCartas[i][j+1] + matCartas[i][j+2]+ matCartas[i][j+3] + matCartas[i][j+4]==5)
                    {
                        //int cadena [] = new int [2];
                        cadena[0] = cons.STRAIGHT_FLUSH_INT;
                        cadena[1] = j+4;
                        return cadena;
                    }
                   
                    
                    
                }
                
            }
            //comprobamos el caso excepcional de la escalera empezada en as
                for(int i = 0; i < 4;i++)
                {
                    
                    //mejor mano
                     if(matCartas[i][cons.ACE] + 
                             matCartas[i][cons.TWO] + 
                             matCartas[i][cons.THREE] + 
                             matCartas[i][cons.FOUR] + 
                             matCartas[i][cons.FIVE] == 5)
                     {
                         //int []cadena= new int[2];
                         cadena[0]= cons.STRAIGHT_FLUSH_INT ;                                    
                         cadena[1] =cons.FIVE;
                         return cadena;
                     }
                }
        
        return null;
    }
    
    
    public int[] poker(Carta [] cartas)
    {
      
       
        //boolean iguales = true;
        //int car[] = new int[13];
        /*for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
        for(int j = 0; j < 6;j++)
            cadena[j]= 0;
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }*/
        
        boolean hayPoker = false;
        
        int poker =-1;
        int kick = -1;
            
            for(int i = cons.ACE  ;i >=0;i--)
            {
                
                if(car[i] ==4 && poker==-1)
                {
                    
                    poker = i;
                    //cadena[0]  = cons.BEST_HAND + cons.FOUR_OF_A_KIND + " of " + cadena[1] + " with kicker " + cadena[2].toUpperCase()+ "\n";
            
                    hayPoker = true;
                }
                if(car[i] < 4  && car[i] > 0 && kick == -1){
                    kick = i;
                }
                if(hayPoker && poker!=-1 && kick!=-1)
                {
                    //int cadena[] = new int[3];
                    cadena[1] = poker;
                    cadena[2] = kick;
                    cadena[0]  = cons.FOUR_OF_A_KIND_INT ;
                    return cadena;
                }
            }
        
        return null;
    }
    
    public int[] full (Carta[] cartas)
    {
       
        //int car[] = new int[13];
        /*for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
        for(int j = 0; j < 6;j++)
            cadena[j]= 0;
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
                  
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }*/
      
        
        
            boolean trio = false;
            int tri = -1;
            for(int i = cons.ACE; i >=0 && !trio; i--)
            {
                //posible draw = 2 parejas

                if(car[i]==3)
                {
                    tri =i;
                    
                    trio = true;
                }
                
            }
            if(trio)
            {
                //int []cadena= new int[3];
       
                cadena[1] = tri;
        
                //String cadena []= new String[3];
                
                boolean par = false;
            
                for(int i = cons.ACE; i >=0 && !par; i--)
                {
                    if(car[i]>=2 && cadena[1]!=i)
                    {

                        par= true;
                        cadena[2] = i;

                    }
                }
                if(par)
                {
                    
                    cadena[0] = cons.FULL_HOUSE_INT;
                    return cadena;
                }
            }
        
       
         
       /* else if(drawpar1 && drawpar2 && cartasComunes<5)
        {
            cadena = cons.DRAW + cons.FULL_HOUSE + " of possible "+ cons.THREE_OF_A_KIND+ " of " + par1.toUpperCase() + " and pair of " + par2.toUpperCase()+ "\n"; 
            cadena = cadena +cons.DRAW + cons.FULL_HOUSE + " of possible "+ cons.THREE_OF_A_KIND+ " of " + par2.toUpperCase() + " and pair of " + par1.toUpperCase()+ "\n";
        }*/
       
        
        return null;
    }
    public int [] color(Carta [] cartas)
    {

       
        //int palos[] = new int[4];
        /*for(int j = 0; j < 6;j++)
            cadena[j]= 0;
      */
        
        palos[0] = 0;
        palos[1] = 0;
        palos[2] = 0;
        palos[3] = 0;
        /*
        for(int i =0; i < 4; i++)
        {
            for(int j = 0; j < 13;j++)
            {
                matCartas[i][j] = 0;
            }
        }
       */
        //colocamos las cartas en la matriz
        /*
        for(int i = 0; i < cartas.length ;i++)
        {
            matCartas[cons.tablaStringPalo.get(cartas[i].getPalo())] [cons.tablaStringValor.get(cartas[i].getDigito())]= 1;
        }*/
        
        int palo;
        for (int i = 0; i < cartas.length;i++)
        {
            palo = cons.tablaStringPalo.get(cartas[i].getPalo());
            
            palos[palo] = palos[palo] + 1;          
        }
        
        if(palos[cons.CLUBS]>=5 )
        {
            //int []cadena= new int[6];

            //String cadena [] = new String[6];
            /*
            cadena[0] ="";
            cadena[1] ="";
            cadena[2] ="";
            cadena[3] ="";
            cadena[4] ="";
            cadena[5] ="";*/
            palo = cons.CLUBS;
            
            //miramos el as
             int j = 1;
            
           
            for(int i = 12; i >=0 ; i--)
            {
                
                if(matCartas[cons.CLUBS][i] == 1 && j <6)
                {
                    cadena[j] = i;
                    j++;
                }
                
            }
            cadena[0] = cons.FLUSH_INT;
            //cadena[0] = cons.BEST_HAND + cons.FLUSH+ " " +cadena[1].toUpperCase() + " " + cadena[2].toUpperCase() + " "+cadena[3].toUpperCase() + " "+cadena[4].toUpperCase() + " "+cadena[5].toUpperCase() +"\n";
            return cadena;
        }
        else if(palos[cons.DIAMONDS] >=5)
        {
            //int []cadena= new int[6];

            palo = cons.DIAMONDS;
             int j = 1;
            
           
            for(int i = 12; i >=0 ; i--)
            {
                
                if(matCartas[cons.DIAMONDS][i] == 1 && j <6)
                {
                    cadena[j] = i;
                    j++;
                }
                
            }
            cadena[0] = cons.FLUSH_INT;
            return cadena;
        }
        else if(palos[cons.HEARTS] >=5)
        {
            //int []cadena= new int[6];

            
            palo = cons.HEARTS;
             int j = 1;
           
            for(int i = 12; i >=0 ; i--)
            {
                
                if(matCartas[cons.HEARTS][i] == 1 && j <6)
                {
                    cadena[j] = i;
                    j++;
                }
                
            }
            cadena[0] = cons.FLUSH_INT;
            return cadena;
        }
        else if(palos[cons.SPADES] >=5)
        {
            //int []cadena= new int[6];

            
            palo = cons.SPADES;
             int j = 1;
           
           
            for(int i = 12; i >=0 ; i--)
            {
                
                if(matCartas[cons.SPADES][i] == 1 && j <6)
                {
                    cadena[j] = i;
                    j++;
                }
                
            }
            cadena[0] = cons.FLUSH_INT;
            return cadena;
            
        }
       
        
        
        return null;
    }
    
    public int[] escalera(Carta [] cartas)
    {
       /*
       for(int j = 0; j < 6;j++)
            cadena[j]= 0;
       *//*
        for(int i =0; i < 4; i++)
        {
            for(int j = 0; j < 14;j++)
            {
                matCartas[i][j] = 0;
            }
        }*/
        //colocamos las cartas en la matriz
        /*
        for(int i = 0; i < cartas.length ;i++)
        {
            matCartas[cons.tablaStringPalo.get(cartas[i].getPalo())] [cons.tablaStringValor.get(cartas[i].getDigito())]= 1;
        }*/
        boolean hayEscalera = false;
        
        if(!hayEscalera)
        {
            int i = 0;
            for(int j = 9; j >= 0;j--)
            {
                if((matCartas[i][j] + matCartas[i+1][j] + matCartas[i+2][j] + matCartas[i+3][j]) >=1
                && (matCartas[i][j+1]+ matCartas[i+1][j+1] + matCartas[i+2][j+1] + matCartas[i+3][j+1])>=1
                && (matCartas[i][j+2] + matCartas[i+1][j+2] + matCartas[i+2][j+2] + matCartas[i+3][j+2])>=1
                && (matCartas[i][j+3] + matCartas[i+1][j+3] + matCartas[i+2][j+3] + matCartas[i+3][j+3])>=1
                && (matCartas[i][j+4] + matCartas[i+1][j+4] + matCartas[i+2][j+4] + matCartas[i+3][j+4])>=1)
                 {       
                    // int []cadena= new int[2];
       
                     cadena[0] = cons.STRAIGHT_INT;
                  /*
                    cadena[0] = cons.BEST_HAND + cons.STRAIGHT + " of " + cons.tablaValorString.get(j).toUpperCase() 
                            + " " + cons.tablaValorString.get(j+1).toUpperCase()
                            + " " + cons.tablaValorString.get(j+2).toUpperCase()
                            + " " + cons.tablaValorString.get(j+3).toUpperCase()
                            + " " + cons.tablaValorString.get(j+4).toUpperCase()+ "\n";*/
                     cadena[1] =j+4;
                 
                     return cadena;
                }
                
            }
            //caso excepcional, escalera empezada en as
            if((matCartas[cons.CLUBS][cons.ACE] + 
                matCartas[cons.DIAMONDS][cons.ACE] + 
                matCartas[cons.HEARTS][cons.ACE] + 
                matCartas[cons.SPADES][cons.ACE] )>=1 
             && (matCartas[cons.CLUBS][cons.TWO] + 
                 matCartas[cons.DIAMONDS][cons.TWO] + 
                 matCartas[cons.HEARTS][cons.TWO] +
                 matCartas[cons.SPADES][cons.TWO] )>=1
             && (matCartas[cons.CLUBS][cons.THREE] + 
                 matCartas[cons.DIAMONDS][cons.THREE] + 
                 matCartas[cons.HEARTS][cons.THREE] + 
                 matCartas[cons.SPADES][cons.THREE] )>=1
             && (matCartas[cons.CLUBS][cons.FOUR] + 
                 matCartas[cons.DIAMONDS][cons.FOUR] +
                 matCartas[cons.HEARTS][cons.FOUR] + 
                 matCartas[cons.SPADES][cons.FOUR] )>=1
             && (matCartas[cons.CLUBS][cons.FIVE] +  
                 matCartas[cons.DIAMONDS][cons.FIVE] + 
                 matCartas[cons.HEARTS][cons.FIVE] + 
                 matCartas[cons.SPADES][cons.FIVE])>=1)
            {
                //int []cadena= new int[2];


                //String cadena[] = new String[2] ;
                cadena[0] = cons.STRAIGHT_INT;
                /*
                cadena[0] = "";
                cadena[1] = "";
                cadena[0] = cons.BEST_HAND + cons.STRAIGHT + " of " 
                                + cons.tablaValorString.get(0).toUpperCase()
                                + " " + cons.tablaValorString.get(1).toUpperCase()
                                + " " + cons.tablaValorString.get(2).toUpperCase()
                                + " " + cons.tablaValorString.get(3).toUpperCase()
                                + " " + cons.tablaValorString.get(4).toUpperCase() + "\n";*/
                cadena[1] = cons.FIVE;
             
                return cadena;
            }
        }
        
        return null;
    }
    public int [] trio (Carta[] cartas)
    {
        /*for(int j = 0; j < 6;j++)
            cadena[j]= 0;
        //int car[] = new int[13];
        for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }*/
        
        
        //caso excepcional de tener doble pareja, ya que si sale una tercera carta , no hariamos trio
        //sino full
        
        //recorremos desde el a hasta k y vemos cuantos de cada hay
        boolean tri = false;
        int trio = -1;
        for(int i = cons.ACE; i >= cons.TWO && !tri; i--)
        {
            //mejor mano
            if(car[i]==3 )
            {
                trio = i;
                tri = true;
            }
           
        }
        
        if(tri)
        {
            //int []cadena= new int[4];
            cadena[1] = trio;
            cadena[0] = cons.THREE_OF_A_KIND_INT;
            //cadena[0] = cons.BEST_HAND + cons.THREE_OF_A_KIND + " of " + cadena[1].toUpperCase() + "\n";
           
            
            //comprobamos el kicker mas alto
            int indKick = 2;
            
            
            int i = cons.ACE;
            
            while(i >=cons.TWO  && indKick <4)
            {
                
                
               
                if(car[i] == 1)
                {
                 
                    cadena[indKick] = i;
                    
                   indKick++;
                }
                i--;
            }
        
            //si tenemos un trio, tambien podemos optar a hacer un full
            /*if(cartasComunes < 5)
            {
                cadena += cons.DRAW + cons.FULL_HOUSE + " of " + trio.toUpperCase() + " with other pair" + "\n";
            }*/
            return cadena;
            
        }
       
        
        return null;
    }
    // falla la doble pareja con este patron, arreglar!  
    // 2h4h2s3s4s5s3d
    public int[] dobleParejaYPareja(Carta [] cartas)
    {
        /*
       for(int j = 0; j < 6;j++)
            cadena[j]= 0;
        
        //int car[] = new int[13];
        for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
                  
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }
      */
        int par1 =-1;
        int par2=-1;
        int kicker=-1;
   
        
        
            
            for(int i = cons.ACE; i >= 0; i--)
            {
               
                //buscamos la pareja menor
                if(car[i] == 2 && par1!=-1 && par2==-1)
                {
                    par2 = i;
                }
                //buscamos la pareja mayor
                if(car[i] == 2 && par1==-1)
                {
                    par1 = i;
                    
                }
            }
            //buscamos el kicker
            int i = cons.ACE;
            boolean encontrado = false;
            
            
                while(i >= 0 && !encontrado)
                {
                    if(car[i] >0)
                    {
                      if(par1!=i && par2!=i)
                      {
                            kicker = i;
                            encontrado = true;
                      }  

                    }

                    i--;
                }
            
        
       
        if( par1!=-1 && par2!=-1)
        {
            
            //int []cadena= new int[4];
      
            cadena[0] = cons.TWO_PAIR_INT;
            //cadena[0] =cons.BEST_HAND + cons.TWO_PAIR + " of " + par1.toUpperCase() + " with pair of " + par2.toUpperCase()+ " with kicker " + kicker.toUpperCase() + "\n";
            cadena[1] = par1;
            cadena[2] = par2;
            cadena[3] = kicker;
            return cadena;
            
            
            
        }
         if(par1!=-1)
            //caso de pareja
            {//comop ya tenemos una pareja, buscamos los kicker
                //buscamos los kicker
                int contKicker =0 ;
                i = cons.ACE;
                if(encontrado)
                {
                    int kicks[] = new int[3];
                    while(i >= 0 && contKicker <3)
                    {

                        if(car[i] == 1)
                        {
                            kicks[contKicker] = i;
                            contKicker++;
                        }
                        i--;
                    }

                        //int []cadena= new int[5];

                        //String cadena[] = new String[5];
                         //int car[] = new int[13];
                        cadena[0] = cons.PAIR_INT;
                        //cadena[0] =cons.BEST_HAND + cons.PAIR + " of " + pareja.toUpperCase() + " with kickers of " + kicker[0].toUpperCase()+ " , " + kicker[1].toUpperCase()+ " , " + kicker[2].toUpperCase() + "\n";
                        cadena[1] = par1;
                        cadena[2] = kicks[0];
                        cadena[3] = kicks[1];
                        cadena[4] = kicks[2];
                        return cadena;

                }
        }
        
        
        return null;
    }
    public int[] pareja(Carta [] cartas)
    {
        /*
       for(int j = 0; j < 6;j++)
            cadena[j]= 0;
        
        for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }
        */
        int pareja =-1;
        
            //buscamos la pareja mas alta
            int i = cons.ACE;
            boolean encontrado = false;
            while(i >= 0 && !encontrado)
            {
                if(car[i] == 2)
                {   
                    encontrado = true;
                    pareja =i;
                }
                i--;
            }
            //buscamos los kicker
            int contKicker =0 ;
            i = cons.ACE;
            if(encontrado)
            {
                int kicker[] = new int[3];
                while(i >= 0 && contKicker <3)
                {
                   
                    if(car[i] == 1)
                    {
                        kicker[contKicker] = i;
                        contKicker++;
                    }
                    i--;
                }
               
                    //int []cadena= new int[5];

                    //String cadena[] = new String[5];
                     //int car[] = new int[13];
                    cadena[0] = cons.PAIR_INT;
                    //cadena[0] =cons.BEST_HAND + cons.PAIR + " of " + pareja.toUpperCase() + " with kickers of " + kicker[0].toUpperCase()+ " , " + kicker[1].toUpperCase()+ " , " + kicker[2].toUpperCase() + "\n";
                    cadena[1] = pareja;
                    cadena[2] = kicker[0];
                    cadena[3] = kicker[1];
                    cadena[4] = kicker[2];
                    return cadena;
                
            }
            
        return null;
    }
    /*
    public String[] cartaAlta(Carta [] cartas)
    {
       String []cadena= new String[6];
      
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
    }*/
    public int[] cartaAlta(Carta [] cartas)
    {
       //int []cadena= new int[6];
      /*for(int j = 0; j < 6;j++)
            cadena[j]= 0;
       //String cadena[] = new String[6];
        
        //int car[] = new int[13];
        for (int i = 0; i < car.length;i++){
            car[i]= 0;
        }
         
        //vemos que cartas tenemos y las vamos metiendo en el array
        for (int i = 0; i < cartas.length;i++)
        {
            
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }
        */
        //comprobamos los ases primero
        int indice = 1;
        
        
        //cadena[1] = cons.tablaValorString.get(i).toLowerCase();
        //indice ++;
        cadena[0] = cons.HIGH_CARD_INT;
        
        int j = cons.ACE;
        while(j >= 0 && indice < 6)
        {
            if(car[j] >0)
            {
                
                cadena[indice] = j;
                //System.out.print(cadena[indice]);
                indice++;
            }
            j--;
        }
        
       
        return cadena;
    }
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public int [] valorarMiMano(Carta []cartas)
    {
        
        int[] cad ;
        int[] cadAux ;
        //COMPROBAMOS ESCALERA DE COLOR
        //cadena = escaleraColor(cartas);
        
        for(int j = 0; j < 6;j++)
            cadena[j]= 0;
        
        for (int i = 0; i < car.length;i++)
            car[i]= 0;
        
        for (int i = 0; i < cartas.length;i++)
        {
            //System.out.println(cartas[i].getValor());
            car[cartas[i].getValor()]= car[cartas[i].getValor()] +1;
        }
        
        for(int i =0; i < 4; i++)
        {
            for(int j = 0; j < 14;j++)
            {
                matCartas[i][j] = 0;
            }
        }
        for(int i = 0; i < cartas.length ;i++)
            matCartas[cons.tablaStringPalo.get(cartas[i].getPalo())] [cons.tablaStringValor.get(cartas[i].getDigito())]= 1;
        
        
        
        
            cad = poker(cartas);
            if(cad == null )
            {
                
                    cad = color(cartas);
                    if(cad == null )
                    {
                        cad = escalera(cartas);
                        if(cad == null )
                        {
                            cad = trio(cartas);
                            if(cad == null )
                            {
                                cad = dobleParejaYPareja(cartas);
                                
                                    if(cad == null )
                                    {
                                        cad = cartaAlta(cartas);
                                    }
                                   
                               
                            }
                            //si hay trio, quizas haya full
                            else
                            {
                                cadAux = full(cartas);
                                if(cadAux != null )
                                {
                                    cad = cadAux;
                                }
                            }
                       }
                    }
                    //si hay color, quizas haya escalera de color
                    else
                    {
                        cadAux = escaleraColor(cartas);
                        if(cadAux != null)
                        {
                           cad = cadAux;
                        }
                    }
            
            }
        
        /*
        String draws = "";
        ValorMano.java:960
        
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
        
        return cad;
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
