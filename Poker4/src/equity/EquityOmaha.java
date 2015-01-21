/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package equity;


import carta.Baraja;
import carta.Carta;
import constantes.Constantes;
import gui.PokerCaribean;
import java.awt.Color;
import java.util.Arrays;
import jugada.Jugador;
import jugada.ValorMano;
import ordenacion.MergeSort;

public class EquityOmaha {
    
    Baraja baraja;
    String combiJ1;
    String combiJ2;
    Carta [] cartasjug1;
    Carta [] cartasjug2;
    Carta [] cartasComunes;
    Carta [] cartasComunesAux;
    MergeSort merge;
    ValorMano vm;
    Jugador[] ordenados;
    Jugador[] mejorOrd;
    double cont1, cont2;
    int juegos;
    boolean hayCartasBoard; 
    String board;
    PokerCaribean v;
    
    public EquityOmaha()
    {
        vm = new ValorMano();
        v = PokerCaribean.getInstance();
        merge = new MergeSort(2);
        baraja = Baraja.getInstance();
        hayCartasBoard = false; 
        cartasComunes = new Carta[5];
        cartasjug1 = new Carta[2];
        cartasjug2 = new Carta[2];
        ordenados = new Jugador [2];
        mejorOrd = new Jugador [2];
        cont1 = 0;
        cont2 = 0;
        juegos = 0;
        
    }
    
    public String calculaEquityOmaha(){
        String info = "";
        long s = System.currentTimeMillis();
        
        baraja.reset();
      
        
        String [] jugadas = v.getRangos();
        boolean hayCartaRepetidaEnBoardODead = false;
        
        if(!hayCartaRepetidaEnBoardODead)
        {
            if(jugadas[0].compareTo("")!=0 && jugadas[1].compareTo("")!=0 &&
               baraja.esJugadaValida(jugadas[0]) && baraja.esJugadaValida(jugadas[1]))
            {
                //comprobamos que las cartas de los jugadores no estan repetidas
                //en el board o en las deads o entre ellos
                
                
                cartasjug1 = baraja.generaCartasConString(jugadas[0]);
                cartasjug2 = baraja.generaCartasConString(jugadas[1]);

               

                baraja.usarCarta(cartasjug1[0].getDenominacion());
                baraja.usarCarta(cartasjug1[1].getDenominacion());

                baraja.usarCarta(cartasjug2[0].getDenominacion());
                baraja.usarCarta(cartasjug2[1].getDenominacion());

                board = "";
                if(v.getBoard().length() >= 6 && v.getBoard().length() <=10)
                    {
                     hayCartasBoard = true;
                     board = v.getBoard();
                     cartasComunesAux = baraja.generaCartasConString(board);
                     for(int l = 0; l <= board.length()-2; l+=2){
                        baraja.usarCarta(board.substring(l, l+2));
                        cartasComunes[l/2]= cartasComunesAux[l/2];
                     }
                    }
                if(v.getAproximacion())
                    for (int i=0; i<Constantes.NUM_ITERACIONES; i++){
                        generaJuego();
                    }
                else {
                    //metemos las cartas que podemos poner como board
                    int longi = 44-(board.length()/2);
                    Carta[] cartas = new Carta[longi];
                    int indexCartas = 0;
                    for(int c= 0; c< 52; c++){
                        if(baraja.esCartaSinUsar(baraja.getCarta(c).getDenominacion())){
                            cartas[indexCartas]= baraja.getCarta(c);
                            indexCartas++;
                        }
                    }
                    if(board.length()/2 == 5){
                        generaJuego();
                    }
                    else if (board.length()/2 == 4){
                        for(int i = 0; i < longi; i++){
                            cartasComunes[4] = cartas[i];
                            generaJuego();
                        }
                    }
                    else if (board.length()/2 == 3){
                        for(int i = 0; i < longi-1; i++){
                            for(int j = i+1; j< longi; j++){
                                cartasComunes[3] = cartas[i];
                                cartasComunes[4] = cartas[j];
                                generaJuego();
                            }
                        }
                    }
                    else{
                        for(int i = 0; i < longi-4; i++){
                            for(int j = i+1; j < longi-3; j++){
                                for(int k = j+1; k < longi-2; k++){
                                    for(int l = k+1; l < longi-1; l++){
                                        for(int m = l+1; m < longi; m++){
                                            cartasComunes[0] = cartas[i];
                                            cartasComunes[1] = cartas[j];
                                            cartasComunes[2] = cartas[k];
                                            cartasComunes[3] = cartas[l];
                                            cartasComunes[4] = cartas[m];
                                            generaJuego();
                                        }
                                    }
                                }
                            }
                        }
                    }
                
                v.reiniciaEquity();
                double equity1 = Math.round(((cont1/(juegos))*100)*Math.pow(10,3))/Math.pow(10,3);
                double equity2 = Math.round(((cont2/(juegos))*100)*Math.pow(10,3))/Math.pow(10,3);
                
                v.setEquity(0, equity1);
                v.setEquity(1, equity2);
                long total = System.currentTimeMillis()-s;
                info += "Tiempo :"+total + " ms" + '\n';
                info += "Juegos: " + juegos + '\n';
                int juegostotal = juegos*1000;
                double op = juegostotal/total;
                info += "juegos por segundo: " + op + '\n';
                //Math.round((*Math.pow(10,2))/Math.pow(10,2);
                try
                {
                op = total/juegostotal;
                }
                catch(Exception e)
                {
                    v.setEquityColor("ERROR",Color.red);
                    return "CARTAS REPETIDAS";
                    //v.setEquityColor("ERROR",Color.red);
                }
                info += "segundos por juego: " + op + '\n';
                    //System.out.println("j1: " + contJ1/200 + "%");
                    //System.out.println("j2: " + contJ2/200 + "%");
                }
            else {
                    if(jugadas[0].compareTo("")==0 || jugadas[1].compareTo("")==0 )
                    {
                        System.err.println("Jugada no valida");
                        return "Introduzca cartas en los 2 jugadores";
                    }
                
                    v.setEquityColor("ERROR",Color.red);
                    return "CARTAS REPETIDAS";
                }
            }
            else
            {
                if(jugadas[0].compareTo("")==0 || jugadas[1].compareTo("")==0 )
                    {
                        System.err.println("Jugada no valida");
                        return "Introduzca cartas en los 2 jugadores";
                    }
                
                    v.setEquityColor("ERROR",Color.red);
                    return "CARTAS REPETIDAS";
            }
        }
        else
        {
            if(jugadas[0].compareTo("")==0 || jugadas[1].compareTo("")==0 )
                    {
                        System.err.println("Jugada no valida");
                        return "Introduzca cartas en los 2 jugadores";
                    }
                
                    v.setEquityColor("ERROR",Color.red);
                    return "CARTAS REPETIDAS";
        }
        return info;
    }
    //public void generaJuego(Carta[] cartasJug1, Carta[] cartasJug2, String board){
    public void generaJuego(){
        if(v.getAproximacion()){
            if(hayCartasBoard){
                if(board.length()== 6){
                    Carta[] aux = baraja.generaJugada(2);
                    cartasComunes[3]= aux [0];
                    cartasComunes[4]= aux [1];
                }
                else if(board.length()== 8){
                    Carta[] aux = baraja.generaJugada(1);
                    cartasComunes[4]= aux [0];
                }
            }
            else{
                cartasComunes = baraja.generaJugada(5);
            }
        }
       
        if(juegos==0){
            mejorOrd = combinaciones.CrearPrimeraMejorCombinacion(combiJ1, combiJ2, cartasComunes);
        }
        else {
            mejorOrd = combinaciones.CrearMejorCombinacion(combiJ1, combiJ2, cartasComunes);
        }

        mejorOrd[0].setId(0);
        mejorOrd[1].setId(1);
        
        //merge = new MergeSort(mejorOrd.length);
        merge.iniciaEmpatados();
        ordenados = merge.mergeSort(mejorOrd);
        
        if(merge.estaJugadorEmpatadoEnLaLista(ordenados[ordenados.length-1].getId())){
            cont1 += 0.5;
            cont2 += 0.5;
        }
        else if(ordenados[ordenados.length-1].getId() == 0){
            cont1 += 1.0;
        }
        else if(ordenados[ordenados.length-1].getId() == 1){
            cont2 += 1.0;
        }
        juegos++;
        
        if(v.getAproximacion()){
            if(hayCartasBoard){
                if(board.length()== 6){
                    cartasComunes[3].setDisponible(true);
                    cartasComunes[4].setDisponible(true);
                }
                else if(board.length()== 8){
                    cartasComunes[4].setDisponible(true);
                }
            }
            else{
                cartasComunes[0].setDisponible(true);
                cartasComunes[1].setDisponible(true);
                cartasComunes[2].setDisponible(true);
                cartasComunes[3].setDisponible(true);
                cartasComunes[4].setDisponible(true);
            }
        }
       
    }
}*/