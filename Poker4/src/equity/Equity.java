/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package equity;

import carta.Baraja;
import carta.Carta;
import constantes.AntiguasConstantes;
import gui.PokerCaribean;
import constantes.Constantes;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import jugada.Jugador;
import ordenacion.MergeSort;

/**
 *
 * @author juancly
 */
public class Equity 
{
   
    Baraja baraja;
    AntiguasConstantes constantes;
    MergeSort merge;
    Carta[] uno, dos, cinco;
    int its, longi;
    double juegos;
    String info;
    //String[] arrayBoards;
    //ArrayList<Carta[]> arrayBoards;
    //String[] cartasQueNohayQueUsar;
    Carta[] barajaRestante;
    Carta[] cartasBoard;
    Carta[] boards;
    double[] puntos;
    PokerCaribean v;
    public Equity()
    {
        baraja = Baraja.getInstance();
        boards = new Carta[5];
        constantes = new AntiguasConstantes();
        cartasBoard = new Carta[5];
        puntos = new double[2];
        v = PokerCaribean.getInstance();
        
    }
    public double calculaEquity()
    {
        baraja.reset();
        //cogemos las cartas
        String [] rangos = v.getCartas(AntiguasConstantes.JUGADOR);
        int jugadoresConCartas = 2;
            
        Jugador jugConCartas[] = new Jugador[2];
        merge = new MergeSort(jugConCartas.length);
        
        
        jugConCartas[0] = new Jugador(AntiguasConstantes.JUGADOR);
        jugConCartas[1] = new Jugador(AntiguasConstantes.BANCA);
        Jugador jugConCartasCopy[] = new Jugador[jugadoresConCartas];
        System.arraycopy(jugConCartas, 0, jugConCartasCopy, 0, jugConCartas.length);
      
        boolean hayCartasBoard = false;
        String board = "";
        if(v.getBoard().length() >= 6 && v.getBoard().length() <=10){
            hayCartasBoard = true;
            board = v.getBoard();
            cartasBoard = baraja.generaCartasConString(board);
            for(int l = 0; l <= board.length()-2; l+=2){
                baraja.usarCarta(board.substring(l, l+2));
            }
        }
        double equity = 0;
        int tamEmpatados = 0;
        merge.reset();

        jugConCartas[0].setCartas(rangos[0]+rangos[1]);
        Carta cartasJug [] = baraja.generaJugada(2);
        jugConCartas[1].setCartas(cartasJug[0].getDenominacion()+cartasJug[1].getDenominacion());
        
        //metemos las cartas que podemos poner como board
        longi = 48-(board.length()/2);
        System.out.println(board.length()/2);
        Carta[] cartas = new Carta[longi];
        int e = 0;
        int unoIndex, dosIndex, tresIndex, cuatroIndex, cincoIndex;
        for(int c= 0; c< 52; c++){
            if(baraja.esCartaSinUsar(baraja.getCarta(c).getDenominacion())){
                cartas[e]= baraja.getCarta(c);
                e++;
            }
        }
        if(hayCartasBoard){
            if(board.length()>= 6 && board.length() < 8){
                boards[0] = cartasBoard[0];
                boards[1] = cartasBoard[1];
                boards[2] = cartasBoard[2];
                for(unoIndex = 0; unoIndex < longi-1; unoIndex++){
                    for(dosIndex = unoIndex+1; dosIndex < longi; dosIndex++){
                        boards[3] = cartas[unoIndex];
                        boards[4] = cartas[dosIndex];
                        //arrayBoards.add(boards);
                        //analisis
                        for(int u = 0 ; u < jugConCartas.length;u++){
                            jugConCartas[u].combinaCartasDeManoConComunes2(boards); //System.out.println(its);
                        }
                        juegos++;

                         merge.iniciaEmpatados();
                         Jugador jugOrdenados []= merge.mergeSort(jugConCartasCopy);
                         tamEmpatados =  merge.dameEmpatados().size();
                        if(merge.estaJugadorEmpatadoEnLaLista(jugOrdenados[jugOrdenados.length-1].getId())){
                            for(int z = 0; z < tamEmpatados;z++)
                            {
                                puntos[jugOrdenados[jugOrdenados.length-1-z].getId()] += (1.0d/(double) tamEmpatados);
                            }
                        }
                        else{
                            puntos[jugOrdenados[jugOrdenados.length-1].getId()] += 1.0;
                        }
                    }
                }
            }
            else if(board.length()>= 8 && board.length() < 10){
                boards[0] = cartasBoard[0];
                boards[1] = cartasBoard[1];
                boards[2] = cartasBoard[2];
                boards[3] = cartasBoard[3];
                for(unoIndex = 0; unoIndex < longi; unoIndex++){
                    boards[4] = cartas[unoIndex];
                    //analisis
                    for(int u = 0 ; u < jugConCartas.length;u++){
                        jugConCartas[u].combinaCartasDeManoConComunes2(boards); //System.out.println(its);
                    }
                    juegos++;

                     merge.iniciaEmpatados();
                     Jugador jugOrdenados []= merge.mergeSort(jugConCartasCopy);
                     tamEmpatados =  merge.dameEmpatados().size();
                    if(merge.estaJugadorEmpatadoEnLaLista(jugOrdenados[jugOrdenados.length-1].getId())){

                        for(int z = 0; z < tamEmpatados;z++)
                        {
                            puntos[jugOrdenados[jugOrdenados.length-1-z].getId()] += (1.0d/(double) tamEmpatados);
                        }
                    }
                    else{
                        puntos[jugOrdenados[jugOrdenados.length-1].getId()] += 1.0;
                    }
                }
            }
            else{
                boards[0] = cartasBoard[0];
                boards[1] = cartasBoard[1];
                boards[2] = cartasBoard[2];
                boards[3] = cartasBoard[3];
                boards[4] = cartasBoard[4];
                for(int u = 0 ; u < jugConCartas.length;u++){
                    jugConCartas[u].combinaCartasDeManoConComunes2(boards); //System.out.println(its);
                }
                juegos++;

                merge.iniciaEmpatados();
                Jugador jugOrdenados []= merge.mergeSort(jugConCartasCopy);
                tamEmpatados =  merge.dameEmpatados().size();
                if(merge.estaJugadorEmpatadoEnLaLista(jugOrdenados[jugOrdenados.length-1].getId())){
                   for(int z = 0; z < tamEmpatados;z++){
                       puntos[jugOrdenados[jugOrdenados.length-1-z].getId()] += (1.0d/(double) tamEmpatados);
                    }
                }
                else{
                    puntos[jugOrdenados[jugOrdenados.length-1].getId()] += 1.0;
                }
            }

        }
        else
        {
            //random nuevo
            for(unoIndex = 0; unoIndex < longi-4; unoIndex++){
                for(dosIndex = unoIndex+1; dosIndex < longi-3; dosIndex++){
                    for(tresIndex = dosIndex+1; tresIndex < longi-2; tresIndex++){
                        for(cuatroIndex = tresIndex+1; cuatroIndex < longi-1; cuatroIndex++){
                            for(cincoIndex = cuatroIndex+1; cincoIndex < longi; cincoIndex++){
                                boards[0] = cartas[unoIndex];
                                boards[1] = cartas[dosIndex];
                                boards[2] = cartas[tresIndex];
                                boards[3] = cartas[cuatroIndex];
                                boards[4] = cartas[cincoIndex];
                                //analisis
                                for(int u = 0 ; u < jugConCartas.length;u++){
                                    jugConCartas[u].combinaCartasDeManoConComunes2(boards); //System.out.println(its);
                                }
                                juegos++;
                                merge.iniciaEmpatados();
                                Jugador jugOrdenados []= merge.mergeSort(jugConCartasCopy);
                                tamEmpatados =  merge.dameEmpatados().size();
                                if(merge.estaJugadorEmpatadoEnLaLista(jugOrdenados[jugOrdenados.length-1].getId())){
                                    for(int z = 0; z < tamEmpatados;z++){
                                        puntos[jugOrdenados[jugOrdenados.length-1-z].getId()] += (1.0d/(double) tamEmpatados);
                                   }
                               }
                               else{
                                    puntos[jugOrdenados[jugOrdenados.length-1].getId()] += 1.0;
                               }
                            }
                        }    
                    }
                }
            }
        }

        for(int u = 0 ; u < jugConCartas.length;u++)
        {
            baraja.deshabilitarCarta(jugConCartas[u].getCartas()[0].getDenominacion());
            baraja.deshabilitarCarta(jugConCartas[u].getCartas()[1].getDenominacion());
        }

        v.reiniciaEquity();

        equity = Math.round(((puntos[0]/(juegos))*100)*Math.pow(10,3))/Math.pow(10,3);
        v.setEquity(equity);
        return equity;
    }
    
}
