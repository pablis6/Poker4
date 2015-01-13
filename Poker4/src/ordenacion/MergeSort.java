/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenacion;

import constantes.AntiguasConstantes;
import java.util.ArrayList;
import jugada.Jugador;


public class MergeSort {
    
    AntiguasConstantes cons;
    int empatados[];
    int jugadaEmpatados ;
    public MergeSort(int tamano)
    {
        empatados = new int[tamano];
        iniciaEmpatados();
        
        cons = new AntiguasConstantes();
        
    }
    public void reset()
    {
        iniciaEmpatados();
    }
    public  Jugador[] mergeSort(Jugador [] list) {
        
        
        if (list.length <= 1) {
            return list;
        }
        // Split the array in half
        Jugador[] first = new Jugador[list.length / 2];
        Jugador[] second = new Jugador[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
        
        // Sort each half
        mergeSort(first);
        mergeSort(second);
        
        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }
    
    private  void merge(Jugador[] first, Jugador[] second, Jugador [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;
        // Next element to consider in the second array
        int iSecond = 0;
        
        // Next open position in the result
        int j = 0;
        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst].getValorJugada() < second[iSecond].getValorJugada()) {
                result[j] = first[iFirst];
                iFirst++;
            } 
            else 
            {
                if(first[iFirst].getValorJugada() == second[iSecond].getValorJugada())
                {
                    
                      
                    
                    
                    
                    
                    //CARTA ALTA
                    if(first[iFirst].getValorJugada()==cons.HIGH_CARD_INT)
                    {
                        int kick1I = first[iFirst].getJugada()[1];
                        int kick1J = second[iSecond].getJugada()[1];
                        

                        
                        if(kick1I<kick1J)
                        {
                            result[j] = first[iFirst];
                                        iFirst++;

                        }
                        else if(kick1I==kick1J)
                        {
                            int kick2I = first[iFirst].getJugada()[2];
                            int kick2J = second[iSecond].getJugada()[2];

                           
                            if(kick2I<kick2J)
                            {
                                result[j] = first[iFirst];
                                        iFirst++;

                            }
                            else if(kick2I==kick2J)
                            {
                                int kick3I = first[iFirst].getJugada()[3];
                                int kick3J = second[iSecond].getJugada()[3];

                                
                                if(kick3I<kick3J)
                                {
                                    result[j] = first[iFirst];
                                        iFirst++;

                                }
                                else if(kick3I==kick3J)
                                {
                                    int kick4I = first[iFirst].getJugada()[4];
                                    int kick4J = second[iSecond].getJugada()[4];

                                    
                                    if(kick4I<kick4J)
                                    {
                                        result[j] = first[iFirst];
                                        iFirst++;

                                    }
                                    else if(kick4I==kick4J)
                                    {
                                        int kick5I = first[iFirst].getJugada()[5];
                                        int kick5J = second[iSecond].getJugada()[5];
                                        
                                        if(kick5I<kick5J)
                                        {
                                            result[j] = first[iFirst];
                                            iFirst++;

                                        }
                                        else if(kick5I == kick5J)
                                        {


                                            addEmpatadoAJugada(first[iFirst].getId(),cons.HIGH_CARD_INT);
                                            addEmpatadoAJugada(second[iSecond].getId(),cons.HIGH_CARD_INT);

                                            result[j] = second[iSecond];
                                            iSecond++;
                                        }
                                        else
                                        {
                                            result[j] = second[iSecond];
                                            iSecond++;
                                        }
                                    }
                                    else
                                    {
                                        result[j] = second[iSecond];
                                        iSecond++;
                                    }
                                }
                                else
                                {
                                    result[j] = second[iSecond];
                                    iSecond++;
                                }
                            }
                            else
                            {
                                result[j] = second[iSecond];
                                iSecond++;
                            }
                        }
                        else
                        {
                            result[j] = second[iSecond];
                            iSecond++;
                        }
                    }
                    //PAREJA
                    else if(first[iFirst].getValorJugada()==cons.PAIR_INT)
                    {
                        int parI =first[iFirst].getJugada()[1];
                        int parJ =second[iSecond].getJugada()[1];
                        

                       
                        
                        if(parI<parJ)
                        {
                            result[j] = first[iFirst];
                                    iFirst++;

                        }
                        else if(parI==parJ)
                        {
                            int kick1I =first[iFirst].getJugada()[2];
                            int kick1J =second[iSecond].getJugada()[2];
                            
                            if(kick1I<kick1J)
                            {
                                result[j] = first[iFirst];
                                    iFirst++;

                            }
                            else if(kick1I==kick1J)
                            {
                                int kick2I =first[iFirst].getJugada()[3];
                                int kick2J =second[iSecond].getJugada()[3];
                                

                                if(kick2I<kick2J)
                                {
                                    result[j] = first[iFirst];
                                    iFirst++;

                                }
                                else if(kick2I==kick2J)
                                {
                                    int kick3I =first[iFirst].getJugada()[4];
                                    int kick3J =second[iSecond].getJugada()[4];
                                    
                                    if(kick3I<kick3J)
                                    {
                                        result[j] = first[iFirst];
                                        iFirst++;

                                    }
                                    else if(kick3I == kick3J)
                                    {


                                        addEmpatadoAJugada(first[iFirst].getId(),cons.PAIR_INT);
                                        addEmpatadoAJugada(second[iSecond].getId(),cons.PAIR_INT);

                                        result[j] = second[iSecond];
                                        iSecond++;
                                    }
                                    else
                                    {
                                        result[j] = second[iSecond];
                                        iSecond++;
                                    }

                                }
                                else
                                {
                                    result[j] = second[iSecond];
                                    iSecond++;
                                }
                            }
                            else
                            {
                                result[j] = second[iSecond];
                                iSecond++;
                            }
                        }
                        else
                        {
                            result[j] = second[iSecond];
                            iSecond++;
                        }
                    }
                    //DOBLE PAREJA
                    else if(first[iFirst].getValorJugada()==cons.TWO_PAIR_INT)
                    {
                        int par1I = first[iFirst].getJugada()[1];
                        int par1J = second[iSecond].getJugada()[1];
                        
                      
                        

                        
                        if(par1I<par1J)
                        {
                            result[j] = first[iFirst];
                            iFirst++;

                        }
                        else if(par1I==par1J)
                        {
                            int par2I = first[iFirst].getJugada()[2];
                            int par2J = second[iSecond].getJugada()[2];
                            
                            if(par2I < par2J)
                            {
                                result[j] = first[iFirst];
                                iFirst++;
                            }
                            else if(par2I==par2J)
                            {
                                int kickI = first[iFirst].getJugada()[3];
                                int kickJ = second[iSecond].getJugada()[3];
                               
                                if(kickI < kickJ)
                                {
                                    result[j] = first[iFirst];
                                    iFirst++;
                                }
                                else if(kickI == kickJ)
                                {


                                    addEmpatadoAJugada(first[iFirst].getId(),cons.TWO_PAIR_INT);
                                    addEmpatadoAJugada(second[iSecond].getId(),cons.TWO_PAIR_INT);

                                    result[j] = second[iSecond];
                                    iSecond++;
                                }
                                else
                                {
                                    result[j] = second[iSecond];
                                    iSecond++;
                                }


                            }
                            else
                            {
                                result[j] = second[iSecond];
                                iSecond++;
                            }


                        }
                        else
                        {
                            result[j] = second[iSecond];
                            iSecond++;
                        }
                    }
                    //ESCALERA
                    else if(first[iFirst].getValorJugada() ==cons.STRAIGHT_INT)
                    {
                        int valorI =first[iFirst].getJugada()[1];
                        int valorJ =second[iSecond].getJugada()[1];

                        if(valorI == cons.ACE)
                        {
                            valorI = cons.KING +1;
                        }
                        if(valorJ == cons.ACE)
                        {
                            valorJ = cons.KING +1;
                        }
                        if(valorI<valorJ)
                        {
                            result[j] = first[iFirst];
                            iFirst++;
                        }
                        else if(valorI == valorJ)
                        {


                            addEmpatadoAJugada(first[iFirst].getId(),cons.STRAIGHT_INT);
                            addEmpatadoAJugada(second[iSecond].getId(),cons.STRAIGHT_INT);

                            result[j] = second[iSecond];
                            iSecond++;
                        }
                        else 
                        {

                            result[j] = second[iSecond];
                            iSecond++;
                        }
                    }
                    //TRIO
                    else if(first[iFirst].getValorJugada() ==cons.THREE_OF_A_KIND_INT)
                    {
                        int trioI = first[iFirst].getJugada()[1];
                        int trioJ = second[iSecond].getJugada()[1];




                        if(trioI<trioJ)
                        {
                            result[j] = first[iFirst];
                            iFirst++;

                        }
                        else if(trioI==trioJ)
                        {
                            int kick1I = first[iFirst].getJugada()[2];
                            int kick1J = second[iSecond].getJugada()[2];
                           
                            if(kick1I < kick1J)
                            {
                                result[j] = first[iFirst];
                                iFirst++;
                            }
                            else if(kick1I==kick1J)
                            {
                                int kick2I = first[iFirst].getJugada()[3];
                                int kick2J = second[iSecond].getJugada()[3];
                                
                                if(kick2I < kick2J)
                                {
                                    result[j] = first[iFirst];
                                    iFirst++;
                                }
                                else if(kick2I == kick2J)
                                {


                                    addEmpatadoAJugada(first[iFirst].getId(),cons.THREE_OF_A_KIND_INT);
                                    addEmpatadoAJugada(second[iSecond].getId(),cons.THREE_OF_A_KIND_INT);

                                    result[j] = second[iSecond];
                                    iSecond++;
                                }
                                else
                                {
                                    result[j] = second[iSecond];
                                    iSecond++;
                                }

                            }
                            else
                            {
                                result[j] = second[iSecond];
                                iSecond++;
                            }

                        }
                        else
                        {
                            result[j] = second[iSecond];
                            iSecond++;
                        }
                    }
                    //COLOR
                    else if(first[iFirst].getValorJugada() ==cons.FLUSH_INT)
                    {
                        int unoI = first[iFirst].getJugada()[1];
                        int unoJ = second[iSecond].getJugada()[1];
                        
                        
                        
                        if(unoI<unoJ)
                        {
                           result[j] = first[iFirst];
                            iFirst++;

                        }
                        else if(unoI==unoJ)
                        {
                            int dosI = first[iFirst].getJugada()[2];
                            int dosJ = second[iSecond].getJugada()[2];
                            
                            if(dosI < dosJ)
                            {
                                result[j] = first[iFirst];
                                iFirst++;
                            }
                            else if(dosI==dosJ)
                            {
                                
                                int tresI = first[iFirst].getJugada()[3];
                                int tresJ = second[iSecond].getJugada()[3];

                                
                                if(tresI < tresJ)
                                {
                                    result[j] = first[iFirst];
                                    iFirst++;
                                }
                                else if(tresI==tresJ)
                                {
                                    int cuatroI = first[iFirst].getJugada()[4];
                                    int cuatroJ = second[iSecond].getJugada()[4];
                                    
                                    if(cuatroI < cuatroJ)
                                    {
                                        result[j] = first[iFirst];
                                        iFirst++;
                                    }
                                    else if(cuatroI==cuatroJ)
                                    {
                                        int cincoI = first[iFirst].getJugada()[5];
                                        int cincoJ = second[iSecond].getJugada()[5];
                                        
                                        if(cincoI < cincoJ)
                                        {
                                            result[j] = first[iFirst];
                                            iFirst++;
                                        }
                                        else if(cincoI == cincoJ)
                                        {


                                            addEmpatadoAJugada(first[iFirst].getId(),cons.FLUSH_INT);
                                            addEmpatadoAJugada(second[iSecond].getId(),cons.FLUSH_INT);

                                            result[j] = second[iSecond];
                                            iSecond++;
                                        }
                                        else 
                                        {

                                            result[j] = second[iSecond];
                                            iSecond++;
                                        }


                                    }
                                    else
                                    {
                                        result[j] = second[iSecond];
                                        iSecond++;
                                    }


                                }
                                else
                                {
                                    result[j] = second[iSecond];
                                    iSecond++;
                                }


                            }
                            else
                            {
                                result[j] = second[iSecond];
                                iSecond++;
                            }
                        }
                        else
                        {
                            result[j] = second[iSecond];
                            iSecond++;
                        }
                    }
                    //FULL
                    else if(first[iFirst].getValorJugada() ==cons.FULL_HOUSE_INT)
                    {
                        int trioI = first[iFirst].getJugada()[1];
                        int trioJ = second[iSecond].getJugada()[1];
                        

                        
                        if(trioI<trioJ)
                        {
                            result[j] = first[iFirst];
                            iFirst++;

                        }
                        else if(trioI==trioJ)
                        {
                            int parI = first[iFirst].getJugada()[2];
                            int parJ = second[iSecond].getJugada()[2];

                            
                            if(parI < parJ)
                            {
                                result[j] = first[iFirst];
                                 iFirst++;
                            }
                            else if(parI == parJ)
                            {
                                
                          
                                addEmpatadoAJugada(first[iFirst].getId(),cons.FULL_HOUSE_INT);
                                addEmpatadoAJugada(second[iSecond].getId(),cons.FULL_HOUSE_INT);
                            
                                result[j] = second[iSecond];
                                iSecond++;
                            }
                            else
                            {
                                result[j] = second[iSecond];
                                iSecond++;
                            }


                        }
                        else
                        {
                            result[j] = second[iSecond];
                            iSecond++;
                        }
                    }
                    //POKER
                    else if(first[iFirst].getValorJugada() ==cons.FOUR_OF_A_KIND_INT)
                    {
                        int valorI =first[iFirst].getJugada()[1];
                        int valorJ =second[iSecond].getJugada()[1];
                        
                        
                        if(valorI<valorJ)
                        {
                            result[j] = first[iFirst];
                            iFirst++;

                        }
                        else if(valorI==valorJ)
                        {
                            int kickI = first[iFirst].getJugada()[2];
                            int kickJ = second[iSecond].getJugada()[2];
                        
                            if(kickI < kickJ)
                            {
                                 result[j] = first[iFirst];
                                 iFirst++;
                            }
                            else if(kickI == kickJ)
                            {
                                
                          
                                addEmpatadoAJugada(first[iFirst].getId(),cons.FOUR_OF_A_KIND_INT);
                                addEmpatadoAJugada(second[iSecond].getId(),cons.FOUR_OF_A_KIND_INT);
                            
                                result[j] = second[iSecond];
                                iSecond++;
                            }
                            else
                            {
                                result[j] = second[iSecond];
                                iSecond++;
                            }


                        }
                        else
                        {
                            result[j] = second[iSecond];
                            iSecond++;
                        }
                    } 
                    //comprobamos escalera real
                    else if(first[iFirst].getValorJugada() ==cons.STRAIGHT_FLUSH_INT)
                    {
                        int valorI =first[iFirst].getJugada()[1];
                        int valorJ =second[iSecond].getJugada()[1];


                        
                        if(valorI<valorJ)
                        {
                            result[j] = first[iFirst];
                            iFirst++;
                           

                        }
                        else if(valorI==valorJ)
                        {
                            jugadaEmpatados = cons.STRAIGHT_FLUSH_INT;
                           
                            empatados[first[iFirst].getId()] = first[iFirst].getId();
                       
                            empatados[second[iSecond].getId()] = second[iSecond].getId();
                                
                            
                            result[j] = second[iSecond];
                            iSecond++;
                        }
                        else
                        {
                            result[j] = second[iSecond];
                            iSecond++;
                        }
                    }
                    //ELSE de MANOS
                    else
                    {
                        result[j] = second[iSecond];
                        iSecond++;
                    }
                    
                }
                
                
                //ELSE de no ser iguales las jugadas
                else
                {
                    result[j] = second[iSecond];
                    iSecond++;
                }
                
                
            }
            j++;
        }
        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
    
    public void iniciaEmpatados()
    {
        for(int i =0; i < empatados.length;i++)
        {
            empatados[i] = -1;
        }
        jugadaEmpatados = -1;
    }
    
    public int enQueJugadaHayEmpate()
    {
        return jugadaEmpatados;
    }
    public ArrayList<Integer> dameEmpatados()
    {
        ArrayList<Integer>empa = new ArrayList<Integer>();
        for(int i = 0; i < empatados.length;i++)
        {
            if(empatados[i]!= -1)
            {
                empa.add(empatados[i]);
            }
        }
        return empa;
    }
    //para comprobar si el jugador ganador esta en la lista de empatados, se haria desde
    //fuera llamando a esta funcion de la siguiente manera
    // estaJugadorEmpatadoEnLaLista(ArrayListDevuelto.get(Arraylitsdevulveto.size()));
                              
    public boolean estaJugadorEmpatadoEnLaLista(int id)
    {
        for(int i =0; i < empatados.length;i++)
        {
            if(empatados[i]==id)
            {
                return true;
            }
        }
        return false;
    }
    
    public void addEmpatadoAJugada(int id, int jugada)
    {
        if(jugadaEmpatados==jugada)
        {
            jugadaEmpatados = jugada;
             empatados[id] = id;
        }
        else if(jugadaEmpatados<jugada)
        {
            iniciaEmpatados();
            jugadaEmpatados = jugada;
             empatados[id] = id;
        }
            
    }
    /*
     public void mostrarOrdenadoOriginal()
    {
        System.out.println("original");
        for (int i =0 ; i < original.length;i++)
        {
            System.out.println(original[i].getJugada()[0]);
        }
        System.out.println();
    }
    public void mostrarOrdenadoTemp()
    {
        System.out.println("temporal");
        for (int i =0 ; i < tmpArray.length;i++)
        {
            System.out.println(tmpArray[i].getJugada()[0]);
        }
        System.out.println();
    }*/
    
    
    

    
   
}
