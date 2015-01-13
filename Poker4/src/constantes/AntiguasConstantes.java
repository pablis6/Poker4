/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constantes;

import java.util.HashMap;
import java.util.Map;

/**
 *
* @author Juan Carlos, Francisco Javier, Pablo, Raul
 */

public class AntiguasConstantes {
    public static final String MANO = "Mano";
    public static final String FLOP = "Flop";
     public static final String TURN = "Turn";
    public static final String RIVER = "River";
   
    public static final String DRAW  = "  - Draw: ";
    public static final String BEST_HAND  = "  - Best hand: ";
    public static final String JUG_INVALID = "  - Jugada invalida";
    //palos
   public static final int SPADES  = 0;
   public static final int HEARTS  = 1;
   public static final int DIAMONDS  = 2;
   public static final int CLUBS  = 3;
   
   //valores
   
   public static final int TWO  = 0;
   public static final int THREE  = 1;
   public static final int FOUR  = 2;
   public static final int FIVE  = 3;
   public static final int SIX  = 4;
   public static final int SEVEN  = 5;
   public static final int EIGHT  = 6;
   public static final int NINE  = 7;
   public static final int TEN  = 8;
   public static final int JACK  = 9;
   public static final int QUEEN  = 10;
   public static final int KING  = 11;
   public static final int ACE  = 12;
   
   public static final int BANCA = 2;
   public static final int JUGADOR = 1;
   public static final int EMPATE = 0;
   
   
   //jugadas
   public static final String STRAIGHT_FLUSH = "Straight flush";
   public static final String FOUR_OF_A_KIND = "Four of a kind (POKER)";
   public static final String FULL_HOUSE = "Full house";
   public static final String FLUSH = "Flush";
   public static final String STRAIGHT = "Straight";
        public static final String OPEN_ENDED = " open ended";
        public static final String GUTSHOT = " gutshot";
   public static final String THREE_OF_A_KIND = "Three of a kind";
   public static final String TWO_PAIR = "Two pair";
   public static final String PAIR = "pair";
   public static final String HIGH_CARD = "High card";
   
   public static final int STRAIGHT_FLUSH_INT = 8;
   public static final int FOUR_OF_A_KIND_INT = 7;
   public static final int FULL_HOUSE_INT = 6;
   public static final int FLUSH_INT = 5;
   public static final int STRAIGHT_INT = 4;
   public static final int THREE_OF_A_KIND_INT = 3;
   public static final int TWO_PAIR_INT = 2;
   public static final int PAIR_INT = 1;
   public static final int HIGH_CARD_INT = 0;
   
   //conversores de constantes a string
   public static  Map<Integer, String> tablaValorString = new HashMap<Integer, String>();
   public static  Map<Integer, String> tablaPaloString = new HashMap<Integer, String>();
   
   //conversores de string a constantes
   public static  Map<String,Integer> tablaStringValor = new HashMap<String,Integer>();
   public static  Map<String,Integer> tablaStringPalo = new HashMap<String,Integer>();
   
   public static  Map<String,Integer> tablaValoresMano = new HashMap<String,Integer>();
   public static  Map<Integer,String> tablaManoValores = new HashMap<Integer,String>();
   public AntiguasConstantes()
   {
       
       tablaPaloString.put( SPADES,"s");
       tablaPaloString.put(CLUBS,"c");
       tablaPaloString.put(DIAMONDS,"d");
       tablaPaloString.put(HEARTS,"h");
       
       tablaValorString.put(ACE,"a");
       tablaValorString.put(TWO,"2");
       tablaValorString.put(THREE,"3");
       tablaValorString.put(FOUR,"4");
       tablaValorString.put(FIVE,"5");
       tablaValorString.put(SIX,"6");
       tablaValorString.put(SEVEN,"7");
       tablaValorString.put(EIGHT,"8");
       tablaValorString.put(NINE,"9");
       tablaValorString.put(TEN,"t");
       tablaValorString.put(JACK,"j");
       tablaValorString.put(QUEEN,"q");
       tablaValorString.put(KING,"k");
       
       tablaStringPalo.put( "s",SPADES);
       tablaStringPalo.put("c",CLUBS);
       tablaStringPalo.put("d",DIAMONDS);
       tablaStringPalo.put("h",HEARTS);
       
       tablaStringValor.put("a",ACE);
       tablaStringValor.put("2",TWO);
       tablaStringValor.put("3",THREE);
       tablaStringValor.put("4",FOUR);
       tablaStringValor.put("5",FIVE);
       tablaStringValor.put("6",SIX);
       tablaStringValor.put("7",SEVEN);
       tablaStringValor.put("8",EIGHT);
       tablaStringValor.put("9",NINE);
       tablaStringValor.put("t",TEN);
       tablaStringValor.put("j",JACK);
       tablaStringValor.put("q",QUEEN);
       tablaStringValor.put("k",KING);
       
       tablaValoresMano.put(HIGH_CARD, 0);
       tablaValoresMano.put(PAIR, 1);
       tablaValoresMano.put(TWO_PAIR, 2);
       tablaValoresMano.put(THREE_OF_A_KIND, 3);
       tablaValoresMano.put(STRAIGHT, 4);
       tablaValoresMano.put(FLUSH, 5);
       tablaValoresMano.put(FULL_HOUSE, 6);
       tablaValoresMano.put(FOUR_OF_A_KIND, 7);
       tablaValoresMano.put(STRAIGHT_FLUSH, 8);
       
       tablaManoValores.put(HIGH_CARD_INT,HIGH_CARD);
       tablaManoValores.put(1,PAIR);
       tablaManoValores.put(2,TWO_PAIR);
       tablaManoValores.put(3,THREE_OF_A_KIND);
       tablaManoValores.put(4,STRAIGHT);
       tablaManoValores.put(5,FLUSH);
       tablaManoValores.put(6,FULL_HOUSE);
       tablaManoValores.put(7,FOUR_OF_A_KIND);
       tablaManoValores.put(8,STRAIGHT_FLUSH);
   }  
   
}
