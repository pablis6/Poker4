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
        /*Carta cartasJug [] = baraja.generaJugada(2);
        jugConCartas[1].setCartas(cartasJug[0].getDenominacion()+cartasJug[1].getDenominacion());*/
        
        //metemos las cartas que podemos poner como board
        /*longi = 50-(board.length()/2);
        System.out.println(board.length()/2);
        Carta[] cartas = new Carta[longi];
        int e = 0;
        int unoIndex, dosIndex, tresIndex, cuatroIndex, cincoIndex;
        for(int c= 0; c< 52; c++){
            if(baraja.esCartaSinUsar(baraja.getCarta(c).getDenominacion())){
                cartas[e]= baraja.getCarta(c);
                e++;
            }
        }*/
        if(hayCartasBoard){
            if(board.length()>= 6 && board.length() < 8){
                boards[0] = cartasBoard[0];
                boards[1] = cartasBoard[1];
                boards[2] = cartasBoard[2];
                for(int i = 0; i < 180000; i++){//son 178365 posibilidades, aprox 180000
                    Carta cartasJug [] = baraja.generaJugada(2);//cartas para la banca
                    jugConCartas[1].setCartas(cartasJug[0].getDenominacion()+cartasJug[1].getDenominacion());
                    Carta[] aux = baraja.generaJugada(2);//cartas board
                    boards[3] = aux[0];
                    boards[4] = aux[1];
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
                    //liberamos cartas
                    baraja.deshabilitarCarta(jugConCartas[1].getCartas()[0].getDenominacion());
                    baraja.deshabilitarCarta(jugConCartas[1].getCartas()[1].getDenominacion());
                    baraja.deshabilitarCarta(boards[3].getDenominacion());
                    baraja.deshabilitarCarta(boards[4].getDenominacion());
                }
            }
            else if(board.length()>= 8 && board.length() < 10){
                boards[0] = cartasBoard[0];
                boards[1] = cartasBoard[1];
                boards[2] = cartasBoard[2];
                boards[3] = cartasBoard[3];
                for(int i = 0; i < 16000; i++){//son 15180 posibilidades, aprox 16000
                    Carta cartasJug [] = baraja.generaJugada(2);//cartas para la banca
                    jugConCartas[1].setCartas(cartasJug[0].getDenominacion()+cartasJug[1].getDenominacion());
                    Carta[] aux = baraja.generaJugada(1);//cartas board
                    boards[4] = aux[0];
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
                    //liberamos cartas
                    baraja.deshabilitarCarta(jugConCartas[1].getCartas()[0].getDenominacion());
                    baraja.deshabilitarCarta(jugConCartas[1].getCartas()[1].getDenominacion());
                    baraja.deshabilitarCarta(boards[4].getDenominacion());
                }
            }
            else{
                boards[0] = cartasBoard[0];
                boards[1] = cartasBoard[1];
                boards[2] = cartasBoard[2];
                boards[3] = cartasBoard[3];
                boards[4] = cartasBoard[4];
                for(int i = 0; i < 1000; i++){//son 990 posibilidades, aprox 1000
                    Carta cartasJug [] = baraja.generaJugada(2);//cartas para la banca
                    jugConCartas[1].setCartas(cartasJug[0].getDenominacion()+cartasJug[1].getDenominacion());
                    
                    for(int u = 0 ; u < jugConCartas.length;u++){
                        jugConCartas[u].combinaCartasDeManoConComunes2(boards);
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
                    //liberamos cartas
                    baraja.deshabilitarCarta(jugConCartas[1].getCartas()[0].getDenominacion());
                    baraja.deshabilitarCarta(jugConCartas[1].getCartas()[1].getDenominacion());
                }
            }

        }
        else{   //random nuevo
            for(int i = 0; i < 200000; i++){
                if(i%100000==0){
                    System.out.println(i);
                }
                Carta cartasJug [] = baraja.generaJugada(2);//cartas para la banca
                jugConCartas[1].setCartas(cartasJug[0].getDenominacion()+cartasJug[1].getDenominacion());
                boards = baraja.generaJugada(5);//cartas board
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
                
                //liberamos cartas
                baraja.deshabilitarCarta(jugConCartas[1].getCartas()[0].getDenominacion());
                baraja.deshabilitarCarta(jugConCartas[1].getCartas()[1].getDenominacion());
                baraja.deshabilitarCarta(boards[0].getDenominacion());
                baraja.deshabilitarCarta(boards[1].getDenominacion());
                baraja.deshabilitarCarta(boards[2].getDenominacion());
                baraja.deshabilitarCarta(boards[3].getDenominacion());
                baraja.deshabilitarCarta(boards[4].getDenominacion());
            }
            
        }

        for(int u = 0 ; u < jugConCartas.length;u++)
        {
            baraja.deshabilitarCarta(jugConCartas[u].getCartas()[0].getDenominacion());
            baraja.deshabilitarCarta(jugConCartas[u].getCartas()[1].getDenominacion());
        }

        v.reiniciaEquity();

        equity = Math.round(((puntos[1]/(juegos))*100)*Math.pow(10,3))/Math.pow(10,3);
        v.setEquity(equity);
        return equity;
    }
    
}
