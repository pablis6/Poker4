package constantes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
* @author Juan Carlos, Francisco Javier, Pablo, Raul
 */

public class Constantes {
    
    public static final double NUM_ITERACIONES = 100000;
    //posiciones
    public static final int UTG = 0;
    public static final int UTG1 = 1;
    public static final int CO = 2;
    public static final int BTN = 3;
    public static final int SB = 4;
    public static final int BB = 5;
    //posiciones en String
    public static final String UTGs = "UTG";
    public static final String UTG1s = "UTG+1";
    public static final String COs = "CO";
    public static final String BTNs = "BTN";
    public static final String SBs = "SB";
    public static final String BBs  = "BB";
    
    
    
    public static final String RUTA_RANKINGS = "rankingsPersonalizados/";
    public static final String RUTA_RANGOS = "rangosPersonalizados/";
    public static final String RUTA_MANOS_POKERSTARS = "manosPokerStars/";
    public static final String PATRON_SEPARACION = ", ";
    public static final String MANO = "Mano";
    public static final String FLOP = "Flop";
    public static final String TURN = "Turn";
    public static final String RIVER = "River";
    
    public static final String MA = "Will Ma";
    public static final String Janda = "Janda";
    public static final String CHUBUKOV = "Sklansky-Chubukov";
   
    public static final String DRAW  = "  - Draw: ";
    public static final String BEST_HAND  = "  - Best hand: ";
    public static final String JUG_INVALID = "  - Jugada invalida";
    //palos
   public static final int SPADES  = 0;
   public static final int HEARTS  = 1;
   public static final int DIAMONDS  = 2;
   public static final int CLUBS  = 3;
   
   public static final int NUM_CARTAS_POR_PALO = 13;
   
   //valores
   
   public static final int TWO  = 12;
   public static final int THREE  = 11;
   public static final int FOUR  = 10;
   public static final int FIVE  = 9;
   public static final int SIX  = 8;
   public static final int SEVEN  = 7;
   public static final int EIGHT  = 6;
   public static final int NINE  = 5;
   public static final int TEN  = 4;
   public static final int JACK  = 3;
   public static final int QUEEN  = 2;
   public static final int KING  = 1;
   public static final int ACE  = 0;
   
   
   //
   public static final int TACE  = 0;
   public static final int TTWO  = 1;
   public static final int TTHREE  = 2;
   public static final int TFOUR  = 3;
   public static final int TFIVE  = 4;
   public static final int TSIX  = 5;
   public static final int TSEVEN  = 6;
   public static final int TEIGHT  = 7;
   public static final int TNINE  = 8;
   public static final int TTEN  = 9;
   public static final int TJACK  = 10;
   public static final int TQUEEN  = 11;
   public static final int TKING  = 12;
   
   
   //valores
   public static final int VACE  = 0;
   public static final int VTWO  = 1;
   public static final int VTHREE  = 2;
   public static final int VFOUR  = 3;
   public static final int VFIVE  = 4;
   public static final int VSIX  = 5;
   public static final int VSEVEN  = 6;
   public static final int VEIGHT  = 7;
   public static final int VNINE  = 8;
   public static final int VTEN  = 9;
   public static final int VJACK  = 10;
   public static final int VQUEEN  = 11;
   public static final int VKING  = 12;
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
   
   //conversores de constantes a string
   public static  Map<Integer, String> tablaPosicionString = new HashMap<Integer,String>();
   public static  Map<String, Integer> tablaStringPosicion = new HashMap<String,Integer>();
   
   
   //conversores de constantes a string
   public static  Map<Integer, String> tablaValorString = new HashMap<Integer,String>();
   public static  Map<Integer, String> tablaPaloString = new HashMap<Integer,String>();
   
   //tabla correspondiente al modulo de clasificarManos
   public static  Map<String,Integer> tablaVStringValor = new HashMap<String,Integer>();
   public static  Map<Integer, String> tablaVValorString = new HashMap<Integer,String>();
   
   //conversores de string a constantes
   public static  Map<String,Integer> tablaStringValor = new HashMap<String,Integer>();
   public static  Map<String,Integer> tablaStringPalo = new HashMap<String,Integer>();
   
   
   //conversores de string a constantes
   public static  Map<String,Integer> tablaStringTValor = new HashMap<String,Integer>();
   public static  Map<Integer, String> tablaTValorString = new HashMap<Integer,String>();
   
   public static  Map<String,Integer> tablaValoresMano = new HashMap<String,Integer>();
   public static  Map<Integer,String> tablaManoValores = new HashMap<Integer,String>();
   
   //conversor dado un numero, devuelve el texto del boton Integer To String;
   
   public static  Map<Integer,String> valoresBotonesITS = new HashMap<Integer,String>();
   
   //conversor dado un String, devuelve el numero del boton String To Integer;
   public static  Map<String,Integer> valoresBotonesSTI = new HashMap<String,Integer>();
   
   //conversor dado una sigla de carta, te devuelve su valor
   
   public static  Map<String,Integer> tablaCartaString = new HashMap<String,Integer>();
   
   //Matriz de valores
   public static int[][] valores = new int[13][13];

   //Matriz de rangos
   public double[][] rangos = new double[13][13];
   public class rangos{
       private int x;
       private int y;
       public rangos(int prim, int seg){
       x = prim;
       y = seg;
       }
       public int getX(){
           return x;
       }
       public int getY(){
           return y;
       }
   }
   public static rangos [] rangoOrdenadoChubukov = new rangos[169];
   public static rangos [] rangoOrdenadoWillMa = new rangos[169];
   public static rangos [] rangoOrdenadoJanda = new rangos[169];
   public static rangos [] rangoCargado = new rangos[169];
   public Constantes()
   {
       
       tablaPosicionString.put(UTG,UTGs);
       tablaPosicionString.put(UTG1,UTG1s);
       tablaPosicionString.put(CO,COs);
       tablaPosicionString.put(BTN,BTNs);
       tablaPosicionString.put(SB,SBs);
       tablaPosicionString.put(BB,BBs);
       
       tablaStringPosicion.put(UTGs,UTG);
       tablaStringPosicion.put(UTG1s,UTG1);
       tablaStringPosicion.put(COs,CO);
       tablaStringPosicion.put(BTNs,BTN);
       tablaStringPosicion.put(SBs,SB);
       tablaStringPosicion.put(BBs,BB);
       
       tablaCartaString.put("A", ACE);
       tablaCartaString.put("2", TWO);
       tablaCartaString.put("3", THREE);
       tablaCartaString.put("4", FOUR);
       tablaCartaString.put("5", FIVE);
       tablaCartaString.put("6", SIX);
       tablaCartaString.put("7", SEVEN);
       tablaCartaString.put("8", EIGHT);
       tablaCartaString.put("9", NINE);
       tablaCartaString.put("T", TEN);
       tablaCartaString.put("J", JACK);
       tablaCartaString.put("Q", QUEEN);
       tablaCartaString.put("K", KING);
       
       valoresBotonesITS.put(0,"AA");
       valoresBotonesITS.put(1, "AKs");
       valoresBotonesITS.put(2, "AQs");
       valoresBotonesITS.put(3, "AJs");
       valoresBotonesITS.put(4, "ATs");
       valoresBotonesITS.put(5, "A9s");
       valoresBotonesITS.put(6, "A8s");
       valoresBotonesITS.put(7, "A7s");
       valoresBotonesITS.put(8, "A6s");
       valoresBotonesITS.put(9, "A5s");
       valoresBotonesITS.put(10, "A4s");
       valoresBotonesITS.put(11, "A3s");
       valoresBotonesITS.put(12, "A2s");
       
       valoresBotonesITS.put(13, "AKo");
       valoresBotonesITS.put(14, "KK");
       valoresBotonesITS.put(15, "KQs");
       valoresBotonesITS.put(16, "KJs");
       valoresBotonesITS.put(17, "KTs");
       valoresBotonesITS.put(18, "K9s");
       valoresBotonesITS.put(19, "K8s");
       valoresBotonesITS.put(20, "K7s");
       valoresBotonesITS.put(21, "K6s");
       valoresBotonesITS.put(22, "K5s");
       valoresBotonesITS.put(23, "K4s");
       valoresBotonesITS.put(24, "K3s");
       valoresBotonesITS.put(25, "K2s");
       
       valoresBotonesITS.put(26, "AQo");
       valoresBotonesITS.put(27, "KQo");
       valoresBotonesITS.put(28, "QQ");
       valoresBotonesITS.put(29, "QJs");
       valoresBotonesITS.put(30, "QTs");
       valoresBotonesITS.put(31, "Q9s");
       valoresBotonesITS.put(32, "Q8s");
       valoresBotonesITS.put(33, "Q7s");
       valoresBotonesITS.put(34, "Q6s");
       valoresBotonesITS.put(35, "Q5s");
       valoresBotonesITS.put(36, "Q4s");
       valoresBotonesITS.put(37, "Q3s");
       valoresBotonesITS.put(38, "Q2s");
       
       
       valoresBotonesITS.put(39, "AJo");
       valoresBotonesITS.put(40, "KJo");
       valoresBotonesITS.put(41, "QJo");
       valoresBotonesITS.put(42, "JJ");
       valoresBotonesITS.put(43, "JTs");
       valoresBotonesITS.put(44, "J9s");
       valoresBotonesITS.put(45, "J8s");
       valoresBotonesITS.put(46, "J7s");
       valoresBotonesITS.put(47, "J6s");
       valoresBotonesITS.put(48, "J5s");
       valoresBotonesITS.put(49, "J4s");
       valoresBotonesITS.put(50, "J3s");
       valoresBotonesITS.put(51, "J2s");
       
       valoresBotonesITS.put(52, "ATo");
       valoresBotonesITS.put(53, "KTo");
       valoresBotonesITS.put(54, "QTo");
       valoresBotonesITS.put(55, "JTo");
       valoresBotonesITS.put(56, "TT");
       valoresBotonesITS.put(57, "T9s");
       valoresBotonesITS.put(58, "T8s");
       valoresBotonesITS.put(59, "T7s");
       valoresBotonesITS.put(60, "T6s");
       valoresBotonesITS.put(61, "T5s");
       valoresBotonesITS.put(62, "T4s");
       valoresBotonesITS.put(63, "T3s");
       valoresBotonesITS.put(64, "T2s");
       
       valoresBotonesITS.put(65, "A9o");
       valoresBotonesITS.put(66, "K9o");
       valoresBotonesITS.put(67, "Q9o");
       valoresBotonesITS.put(68, "J9o");
       valoresBotonesITS.put(69, "T9o");
       valoresBotonesITS.put(70, "99");
       valoresBotonesITS.put(71, "98s");
       valoresBotonesITS.put(72, "97s");
       valoresBotonesITS.put(73, "96s");
       valoresBotonesITS.put(74, "95s");
       valoresBotonesITS.put(75, "94s");
       valoresBotonesITS.put(76, "93s");
       valoresBotonesITS.put(77, "92s");
       
       valoresBotonesITS.put(78, "A8o");
       valoresBotonesITS.put(79, "K8o");
       valoresBotonesITS.put(80, "Q8o");
       valoresBotonesITS.put(81, "J8o");
       valoresBotonesITS.put(82, "T8o");
       valoresBotonesITS.put(83, "98o");
       valoresBotonesITS.put(84, "88");
       valoresBotonesITS.put(85, "87s");
       valoresBotonesITS.put(86, "86s");
       valoresBotonesITS.put(87, "85s");
       valoresBotonesITS.put(88, "84s");
       valoresBotonesITS.put(89, "83s");
       valoresBotonesITS.put(90, "82s");
       
       valoresBotonesITS.put(91, "A7o");
       valoresBotonesITS.put(92, "K7o");
       valoresBotonesITS.put(93, "Q7o");
       valoresBotonesITS.put(94, "J7o");
       valoresBotonesITS.put(95, "T7o");
       valoresBotonesITS.put(96, "97o");
       valoresBotonesITS.put(97, "87o");
       valoresBotonesITS.put(98, "77");
       valoresBotonesITS.put(99, "76s");
       valoresBotonesITS.put(100, "75s");
       valoresBotonesITS.put(101, "74s");
       valoresBotonesITS.put(102, "73s");
       valoresBotonesITS.put(103, "72s");
       
       valoresBotonesITS.put(104, "A6o");
       valoresBotonesITS.put(105, "K6o");
       valoresBotonesITS.put(106, "Q6o");
       valoresBotonesITS.put(107, "J6o");
       valoresBotonesITS.put(108, "T6o");
       valoresBotonesITS.put(109, "96o");
       valoresBotonesITS.put(110, "86o");
       valoresBotonesITS.put(111, "76o");
       valoresBotonesITS.put(112, "66");
       valoresBotonesITS.put(113, "65s");
       valoresBotonesITS.put(114, "64s");
       valoresBotonesITS.put(115, "63s");
       valoresBotonesITS.put(116, "62s");
       
       valoresBotonesITS.put(117, "A5o");
       valoresBotonesITS.put(118, "K5o");
       valoresBotonesITS.put(119, "Q5o");
       valoresBotonesITS.put(120, "J5o");
       valoresBotonesITS.put(121, "T5o");
       valoresBotonesITS.put(122, "95o");
       valoresBotonesITS.put(123, "85o");
       valoresBotonesITS.put(124, "75o");
       valoresBotonesITS.put(125, "65o");
       valoresBotonesITS.put(126, "55");
       valoresBotonesITS.put(127, "54s");
       valoresBotonesITS.put(128, "53s");
       valoresBotonesITS.put(129, "52s");
       
       valoresBotonesITS.put(130, "A4o");
       valoresBotonesITS.put(131, "K4o");
       valoresBotonesITS.put(132, "Q4o");
       valoresBotonesITS.put(133, "J4o");
       valoresBotonesITS.put(134, "T4o");
       valoresBotonesITS.put(135, "94o");
       valoresBotonesITS.put(136, "84o");
       valoresBotonesITS.put(137, "74o");
       valoresBotonesITS.put(138, "64o");
       valoresBotonesITS.put(139, "54o");
       valoresBotonesITS.put(140, "44");
       valoresBotonesITS.put(141, "43s");
       valoresBotonesITS.put(142, "42s");
       
       valoresBotonesITS.put(143, "A3o");
       valoresBotonesITS.put(144, "K3o");
       valoresBotonesITS.put(145, "Q3o");
       valoresBotonesITS.put(146, "J3o");
       valoresBotonesITS.put(147, "T3o");
       valoresBotonesITS.put(148, "93o");
       valoresBotonesITS.put(149, "83o");
       valoresBotonesITS.put(150, "73o");
       valoresBotonesITS.put(151, "63o");
       valoresBotonesITS.put(152, "53o");
       valoresBotonesITS.put(153, "43o");
       valoresBotonesITS.put(154, "33");
       valoresBotonesITS.put(155, "32s");
       
       valoresBotonesITS.put(156, "A2o");
       valoresBotonesITS.put(157, "K2o");
       valoresBotonesITS.put(158, "Q2o");
       valoresBotonesITS.put(159, "J2o");
       valoresBotonesITS.put(160, "T2o");
       valoresBotonesITS.put(161, "92o");
       valoresBotonesITS.put(162, "82o");
       valoresBotonesITS.put(163, "72o");
       valoresBotonesITS.put(164, "62o");
       valoresBotonesITS.put(165, "52o");
       valoresBotonesITS.put(166, "42o");
       valoresBotonesITS.put(167, "32o");
       valoresBotonesITS.put(168, "22");
       
       ///////////////////////////////7
       
       valoresBotonesSTI.put("AA",0);
       valoresBotonesSTI.put("AKs",1);
       valoresBotonesSTI.put("AQs",2);
       valoresBotonesSTI.put( "AJs",3);
       valoresBotonesSTI.put( "ATs",4);
       valoresBotonesSTI.put( "A9s",5);
       valoresBotonesSTI.put( "A8s",6);
       valoresBotonesSTI.put( "A7s",7);
       valoresBotonesSTI.put( "A6s",8);
       valoresBotonesSTI.put( "A5s",9);
       valoresBotonesSTI.put( "A4s",10);
       valoresBotonesSTI.put("A3s",11);
       valoresBotonesSTI.put( "A2s",12);
       
       valoresBotonesSTI.put("AKo",13);
       valoresBotonesSTI.put( "KK",14);
       valoresBotonesSTI.put("KQs",15);
       valoresBotonesSTI.put( "KJs",16);
       valoresBotonesSTI.put( "KTs",17);
       valoresBotonesSTI.put( "K9s",18);
       valoresBotonesSTI.put( "K8s",19);
       valoresBotonesSTI.put( "K7s",20);
       valoresBotonesSTI.put( "K6s",21);
       valoresBotonesSTI.put( "K5s",22);
       valoresBotonesSTI.put( "K4s",23);
       valoresBotonesSTI.put( "K3s",24);
       valoresBotonesSTI.put( "K2s",25);
       
       valoresBotonesSTI.put( "AQo",26);
       valoresBotonesSTI.put( "KQo",27);
       valoresBotonesSTI.put( "QQ",28);
       valoresBotonesSTI.put( "QJs",29);
       valoresBotonesSTI.put( "QTs",30);
       valoresBotonesSTI.put( "Q9s",31);
       valoresBotonesSTI.put( "Q8s",32);
       valoresBotonesSTI.put( "Q7s",33);
       valoresBotonesSTI.put( "Q6s",34);
       valoresBotonesSTI.put( "Q5s",35);
       valoresBotonesSTI.put( "Q4s",36);
       valoresBotonesSTI.put( "Q3s",37);
       valoresBotonesSTI.put( "Q2s",38);
              
       valoresBotonesSTI.put( "AJo",39);
       valoresBotonesSTI.put( "KJo",40);
       valoresBotonesSTI.put( "QJo",41);
       valoresBotonesSTI.put( "JJ",42);
       valoresBotonesSTI.put( "JTs",43);
       valoresBotonesSTI.put( "J9s",44);
       valoresBotonesSTI.put( "J8s",45);
       valoresBotonesSTI.put( "J7s",46);
       valoresBotonesSTI.put( "J6s",47);
       valoresBotonesSTI.put( "J5s",48);
       valoresBotonesSTI.put( "J4s",49);
       valoresBotonesSTI.put( "J3s",50);
       valoresBotonesSTI.put( "J2s",51);
       
       valoresBotonesSTI.put( "ATo",52);
       valoresBotonesSTI.put( "KTo",53);
       valoresBotonesSTI.put( "QTo",54);
       valoresBotonesSTI.put( "JTo",55);
       valoresBotonesSTI.put( "TT",56);
       valoresBotonesSTI.put( "T9s",57);
       valoresBotonesSTI.put( "T8s",58);
       valoresBotonesSTI.put( "T7s",59);
       valoresBotonesSTI.put( "T6s",60);
       valoresBotonesSTI.put( "T5s",61);
       valoresBotonesSTI.put( "T4s",62);
       valoresBotonesSTI.put( "T3s",63);
       valoresBotonesSTI.put( "T2s",64);
       
       valoresBotonesSTI.put( "A9o",65);
       valoresBotonesSTI.put( "K9o",66);
       valoresBotonesSTI.put( "Q9o",67);
       valoresBotonesSTI.put( "J9o",68);
       valoresBotonesSTI.put( "T9o",69);
       valoresBotonesSTI.put( "99",70);
       valoresBotonesSTI.put( "98s",71);
       valoresBotonesSTI.put( "97s",72);
       valoresBotonesSTI.put( "96s",73);
       valoresBotonesSTI.put( "95s",74);
       valoresBotonesSTI.put( "94s",75);
       valoresBotonesSTI.put( "93s",76);
       valoresBotonesSTI.put( "92s",77);
       
       valoresBotonesSTI.put( "A8o",78);
       valoresBotonesSTI.put( "K8o",79);
       valoresBotonesSTI.put( "Q8o",80);
       valoresBotonesSTI.put( "J8o",81);
       valoresBotonesSTI.put( "T8o",82);
       valoresBotonesSTI.put( "98o",83);
       valoresBotonesSTI.put( "88",84);
       valoresBotonesSTI.put( "87s",85);
       valoresBotonesSTI.put( "86s",86);
       valoresBotonesSTI.put( "85s",87);
       valoresBotonesSTI.put( "84s",88);
       valoresBotonesSTI.put( "83s",89);
       valoresBotonesSTI.put( "82s",90);
       
       valoresBotonesSTI.put( "A7o",91);
       valoresBotonesSTI.put( "K7o",92);
       valoresBotonesSTI.put( "Q7o",93);
       valoresBotonesSTI.put( "J7o",94);
       valoresBotonesSTI.put( "T7o",95);
       valoresBotonesSTI.put( "97o",96);
       valoresBotonesSTI.put( "87o",97);
       valoresBotonesSTI.put( "77",98);
       valoresBotonesSTI.put( "76s",99);
       valoresBotonesSTI.put( "75s",100);
       valoresBotonesSTI.put( "74s",101);
       valoresBotonesSTI.put( "73s",102);
       valoresBotonesSTI.put( "72s",103);
      
       valoresBotonesSTI.put( "A6o",104);
       valoresBotonesSTI.put( "K6o",105);
       valoresBotonesSTI.put( "Q6o",106);
       valoresBotonesSTI.put( "J6o",107);
       valoresBotonesSTI.put( "T6o",108);
       valoresBotonesSTI.put("96o",109);
       valoresBotonesSTI.put( "86o",110);
       valoresBotonesSTI.put( "76o",111);
       valoresBotonesSTI.put( "66",112);
       valoresBotonesSTI.put( "65s",113);
       valoresBotonesSTI.put( "64s",114);
       valoresBotonesSTI.put( "63s",115);
       valoresBotonesSTI.put( "62s",116);
      
       valoresBotonesSTI.put( "A5o",117);
       valoresBotonesSTI.put( "K5o",118);
       valoresBotonesSTI.put( "Q5o",119);
       valoresBotonesSTI.put( "J5o",120);
       valoresBotonesSTI.put( "T5o",121);
       valoresBotonesSTI.put( "95o",122);
       valoresBotonesSTI.put( "85o",123);
       valoresBotonesSTI.put( "75o",124);
       valoresBotonesSTI.put( "65o",125);
       valoresBotonesSTI.put( "55",126);
       valoresBotonesSTI.put( "54s",127);
       valoresBotonesSTI.put( "53s",128);
       valoresBotonesSTI.put( "52s",129);
       
       valoresBotonesSTI.put( "A4o",130);
       valoresBotonesSTI.put( "K4o",131);
       valoresBotonesSTI.put( "Q4o",132);
       valoresBotonesSTI.put( "J4o",133);
       valoresBotonesSTI.put( "T4o",134);
       valoresBotonesSTI.put( "94o",135);
       valoresBotonesSTI.put( "84o",136);
       valoresBotonesSTI.put( "74o",137);
       valoresBotonesSTI.put( "64o",138);
       valoresBotonesSTI.put( "54o",139);
       valoresBotonesSTI.put( "44",140);
       valoresBotonesSTI.put( "43s",141);
       valoresBotonesSTI.put( "42s",142);
      
       valoresBotonesSTI.put( "A3o",143);
       valoresBotonesSTI.put( "K3o",144);
       valoresBotonesSTI.put( "Q3o",145);
       valoresBotonesSTI.put( "J3o",146);
       valoresBotonesSTI.put( "T3o",147);
       valoresBotonesSTI.put( "93o",148);
       valoresBotonesSTI.put( "83o",149);
       valoresBotonesSTI.put( "73o",150);
       valoresBotonesSTI.put( "63o",151);
       valoresBotonesSTI.put( "53o",152);
       valoresBotonesSTI.put( "43o",153);
       valoresBotonesSTI.put( "33",154);
       valoresBotonesSTI.put( "32s",155);
       
       valoresBotonesSTI.put( "A2o",156);
       valoresBotonesSTI.put( "K2o",157);
       valoresBotonesSTI.put( "Q2o",158);
       valoresBotonesSTI.put( "J2o",159);
       valoresBotonesSTI.put( "T2o",160);
       valoresBotonesSTI.put( "92o",161);
       valoresBotonesSTI.put( "82o",162);
       valoresBotonesSTI.put( "72o",163);
       valoresBotonesSTI.put( "62o",164);
       valoresBotonesSTI.put( "52o",165);
       valoresBotonesSTI.put( "42o",166);
       valoresBotonesSTI.put( "32o",167);
       valoresBotonesSTI.put( "22",168);
      
       tablaPaloString.put( SPADES,"s");
       tablaPaloString.put(CLUBS,"c");
       tablaPaloString.put(DIAMONDS,"d");
       tablaPaloString.put(HEARTS,"h");
       
       tablaTValorString.put(TACE,"a");
       tablaTValorString.put(TTWO,"2");
       tablaTValorString.put(TTHREE,"3");
       tablaTValorString.put(TFOUR,"4");
       tablaTValorString.put(TFIVE,"5");
       tablaTValorString.put(TSIX,"6");
       tablaTValorString.put(TSEVEN,"7");
       tablaTValorString.put(TEIGHT,"8");
       tablaTValorString.put(TNINE,"9");
       tablaTValorString.put(TTEN,"t");
       tablaTValorString.put(TJACK,"j");
       tablaTValorString.put(TQUEEN,"q");
       tablaTValorString.put(TKING,"k");
       
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
       
       tablaVValorString.put(VACE,"a");
       tablaVValorString.put(VTWO,"2");
       tablaVValorString.put(VTHREE,"3");
       tablaVValorString.put(VFOUR,"4");
       tablaVValorString.put(VFIVE,"5");
       tablaVValorString.put(VSIX,"6");
       tablaVValorString.put(VSEVEN,"7");
       tablaVValorString.put(VEIGHT,"8");
       tablaVValorString.put(VNINE,"9");
       tablaVValorString.put(VTEN,"t");
       tablaVValorString.put(VJACK,"j");
       tablaVValorString.put(VQUEEN,"q");
       tablaVValorString.put(VKING,"k");
       
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
       
       
       tablaVStringValor.put("a",VACE);
       tablaVStringValor.put("2",VTWO);
       tablaVStringValor.put("3",VTHREE);
       tablaVStringValor.put("4",VFOUR);
       tablaVStringValor.put("5",VFIVE);
       tablaVStringValor.put("6",VSIX);
       tablaVStringValor.put("7",VSEVEN);
       tablaVStringValor.put("8",VEIGHT);
       tablaVStringValor.put("9",VNINE);
       tablaVStringValor.put("t",VTEN);
       tablaVStringValor.put("j",VJACK);
       tablaVStringValor.put("q",VQUEEN);
       tablaVStringValor.put("k",VKING);
       
       tablaVStringValor.put("a",VACE);
       tablaVStringValor.put("2",VTWO);
       tablaVStringValor.put("3",VTHREE);
       tablaVStringValor.put("4",VFOUR);
       tablaVStringValor.put("5",VFIVE);
       tablaVStringValor.put("6",VSIX);
       tablaVStringValor.put("7",VSEVEN);
       tablaVStringValor.put("8",VEIGHT);
       tablaVStringValor.put("9",VNINE);
       tablaVStringValor.put("t",VTEN);
       tablaVStringValor.put("j",VJACK);
       tablaVStringValor.put("q",VQUEEN);
       tablaVStringValor.put("k",VKING);
       
       tablaStringTValor.put("a",TACE);
       tablaStringTValor.put("2",TTWO);
       tablaStringTValor.put("3",TTHREE);
       tablaStringTValor.put("4",TFOUR);
       tablaStringTValor.put("5",TFIVE);
       tablaStringTValor.put("6",TSIX);
       tablaStringTValor.put("7",TSEVEN);
       tablaStringTValor.put("8",TEIGHT);
       tablaStringTValor.put("9",TNINE);
       tablaStringTValor.put("t",TTEN);
       tablaStringTValor.put("j",TJACK);
       tablaStringTValor.put("q",TQUEEN);
       tablaStringTValor.put("k",TKING);
       
       tablaValoresMano.put(Constantes.HIGH_CARD, 0);
       tablaValoresMano.put(Constantes.PAIR, 1);
       tablaValoresMano.put(Constantes.TWO_PAIR, 2);
       tablaValoresMano.put(Constantes.THREE_OF_A_KIND, 3);
       tablaValoresMano.put(Constantes.STRAIGHT, 4);
       tablaValoresMano.put(Constantes.FLUSH, 5);
       tablaValoresMano.put(Constantes.FULL_HOUSE, 6);
       tablaValoresMano.put(Constantes.FOUR_OF_A_KIND, 7);
       tablaValoresMano.put(Constantes.STRAIGHT_FLUSH, 8);
       
       tablaManoValores.put(0,Constantes.HIGH_CARD);
       tablaManoValores.put(1,Constantes.PAIR);
       tablaManoValores.put(2,Constantes.TWO_PAIR);
       tablaManoValores.put(3,Constantes.THREE_OF_A_KIND);
       tablaManoValores.put(4,Constantes.STRAIGHT);
       tablaManoValores.put(5,Constantes.FLUSH);
       tablaManoValores.put(6,Constantes.FULL_HOUSE);
       tablaManoValores.put(7,Constantes.FOUR_OF_A_KIND);
       tablaManoValores.put(8,Constantes.STRAIGHT_FLUSH);
   
       for(int fila = 0; fila < 13; fila++){
           for(int col = 0; col < 13; col++){
               if (fila == col) //pareja 
                   valores[fila][col] = 6;
               else if (fila < col)//suited 
                   valores[fila][col] = 4;
               else if (fila > col)//ofsuited 
                   valores[fila][col] = 12;
           }
       }
       // asignarRangos();
        
        //asignarRangos2();
        
        
   }  
   
  /* public void asignarRangos2(){
       
        rangoOrdenadoChubukov[0] = new rangos(Constantes.ACE, Constantes.ACE);
        rangoOrdenadoChubukov[1] = new rangos(Constantes.KING, Constantes.KING);
        rangoOrdenadoChubukov[2] = new rangos(Constantes.ACE, Constantes.KING);
        rangoOrdenadoChubukov[3] = new rangos(Constantes.QUEEN, Constantes.QUEEN);
        rangoOrdenadoChubukov[4] = new rangos(Constantes.KING, Constantes.ACE);
        rangoOrdenadoChubukov[5] = new rangos(Constantes.JACK, Constantes.JACK);
        rangoOrdenadoChubukov[6] = new rangos(Constantes.ACE, Constantes.QUEEN);
        rangoOrdenadoChubukov[7] = new rangos(Constantes.TEN, Constantes.TEN);
        rangoOrdenadoChubukov[8] = new rangos(Constantes.QUEEN, Constantes.ACE);
        rangoOrdenadoChubukov[9] = new rangos(Constantes.NINE, Constantes.NINE);
        rangoOrdenadoChubukov[10] = new rangos(Constantes.ACE, Constantes.JACK);
        rangoOrdenadoChubukov[11] = new rangos(Constantes.EIGHT, Constantes.EIGHT);
        rangoOrdenadoChubukov[12] = new rangos(Constantes.ACE, Constantes.TEN);
        rangoOrdenadoChubukov[13] = new rangos(Constantes.JACK, Constantes.ACE);
        rangoOrdenadoChubukov[14] = new rangos(Constantes.SEVEN, Constantes.SEVEN);
        rangoOrdenadoChubukov[15] = new rangos(Constantes.SIX, Constantes.SIX);
        rangoOrdenadoChubukov[16] = new rangos(Constantes.TEN, Constantes.ACE);
        rangoOrdenadoChubukov[17] = new rangos(Constantes.ACE, Constantes.NINE);
        rangoOrdenadoChubukov[18] = new rangos(Constantes.FIVE, Constantes.FIVE);
        rangoOrdenadoChubukov[19] = new rangos(Constantes.ACE, Constantes.EIGHT);
        rangoOrdenadoChubukov[20] = new rangos(Constantes.KING, Constantes.QUEEN);
        rangoOrdenadoChubukov[21] = new rangos(Constantes.FOUR, Constantes.FOUR);
        rangoOrdenadoChubukov[22] = new rangos(Constantes.NINE, Constantes.ACE);
        rangoOrdenadoChubukov[23] = new rangos(Constantes.ACE, Constantes.SEVEN);
        rangoOrdenadoChubukov[24] = new rangos(Constantes.KING, Constantes.JACK);
        rangoOrdenadoChubukov[25] = new rangos(Constantes.ACE, Constantes.FIVE);
        rangoOrdenadoChubukov[26] = new rangos(Constantes.EIGHT, Constantes.ACE);
        rangoOrdenadoChubukov[27] = new rangos(Constantes.ACE, Constantes.SIX);
        rangoOrdenadoChubukov[28] = new rangos(Constantes.ACE, Constantes.FOUR);
        rangoOrdenadoChubukov[29] = new rangos(Constantes.THREE, Constantes.THREE);
        rangoOrdenadoChubukov[30] = new rangos(Constantes.KING, Constantes.TEN);
        rangoOrdenadoChubukov[31] = new rangos(Constantes.SEVEN, Constantes.ACE);
        rangoOrdenadoChubukov[32] = new rangos(Constantes.ACE, Constantes.THREE);
        rangoOrdenadoChubukov[33] = new rangos(Constantes.QUEEN, Constantes.KING);
        rangoOrdenadoChubukov[34] = new rangos(Constantes.ACE, Constantes.TWO);
        rangoOrdenadoChubukov[35] = new rangos(Constantes.FIVE, Constantes.ACE);
        rangoOrdenadoChubukov[36] = new rangos(Constantes.SIX, Constantes.ACE);
        rangoOrdenadoChubukov[37] = new rangos(Constantes.FOUR, Constantes.ACE);
        rangoOrdenadoChubukov[38] = new rangos(Constantes.JACK, Constantes.KING);
        rangoOrdenadoChubukov[39] = new rangos(Constantes.QUEEN, Constantes.JACK);
        rangoOrdenadoChubukov[40] = new rangos(Constantes.THREE, Constantes.ACE);
        rangoOrdenadoChubukov[41] = new rangos(Constantes.TWO, Constantes.TWO);
        rangoOrdenadoChubukov[42] = new rangos(Constantes.KING, Constantes.NINE);
        rangoOrdenadoChubukov[43] = new rangos(Constantes.TWO, Constantes.ACE);
        rangoOrdenadoChubukov[44] = new rangos(Constantes.TEN, Constantes.KING);
        rangoOrdenadoChubukov[45] = new rangos(Constantes.QUEEN, Constantes.TEN);
        rangoOrdenadoChubukov[46] = new rangos(Constantes.KING, Constantes.EIGHT);
        rangoOrdenadoChubukov[47] = new rangos(Constantes.KING, Constantes.SEVEN);
        rangoOrdenadoChubukov[48] = new rangos(Constantes.JACK, Constantes.TEN);
        rangoOrdenadoChubukov[49] = new rangos(Constantes.NINE, Constantes.KING);
        rangoOrdenadoChubukov[50] = new rangos(Constantes.KING, Constantes.SIX);
        rangoOrdenadoChubukov[51] = new rangos(Constantes.JACK, Constantes.QUEEN);
        rangoOrdenadoChubukov[52] = new rangos(Constantes.QUEEN, Constantes.NINE);
        rangoOrdenadoChubukov[53] = new rangos(Constantes.KING, Constantes.FIVE);
        rangoOrdenadoChubukov[54] = new rangos(Constantes.EIGHT, Constantes.KING);
        rangoOrdenadoChubukov[55] = new rangos(Constantes.KING, Constantes.FOUR);
        rangoOrdenadoChubukov[56] = new rangos(Constantes.TEN, Constantes.QUEEN);
        rangoOrdenadoChubukov[57] = new rangos(Constantes.SEVEN, Constantes.KING);
        rangoOrdenadoChubukov[58] = new rangos(Constantes.KING, Constantes.THREE);
        rangoOrdenadoChubukov[59] = new rangos(Constantes.SIX, Constantes.KING);
        rangoOrdenadoChubukov[60] = new rangos(Constantes.QUEEN, Constantes.EIGHT);
        rangoOrdenadoChubukov[61] = new rangos(Constantes.KING, Constantes.TWO);
        rangoOrdenadoChubukov[62] = new rangos(Constantes.JACK, Constantes.NINE);
        rangoOrdenadoChubukov[63] = new rangos(Constantes.FIVE, Constantes.KING);
        rangoOrdenadoChubukov[64] = new rangos(Constantes.NINE, Constantes.QUEEN);
        rangoOrdenadoChubukov[65] = new rangos(Constantes.TEN, Constantes.JACK);
        rangoOrdenadoChubukov[66] = new rangos(Constantes.FOUR, Constantes.KING);
        rangoOrdenadoChubukov[67] = new rangos(Constantes.QUEEN, Constantes.SEVEN);
        rangoOrdenadoChubukov[68] = new rangos(Constantes.TEN, Constantes.NINE);
        rangoOrdenadoChubukov[69] = new rangos(Constantes.QUEEN, Constantes.SIX);
        rangoOrdenadoChubukov[70] = new rangos(Constantes.THREE, Constantes.KING);
        rangoOrdenadoChubukov[71] = new rangos(Constantes.JACK, Constantes.EIGHT);
        rangoOrdenadoChubukov[72] = new rangos(Constantes.QUEEN, Constantes.FIVE);
        rangoOrdenadoChubukov[73] = new rangos(Constantes.TWO, Constantes.KING);
        rangoOrdenadoChubukov[74] = new rangos(Constantes.EIGHT, Constantes.QUEEN);
        rangoOrdenadoChubukov[75] = new rangos(Constantes.QUEEN, Constantes.FOUR);
        rangoOrdenadoChubukov[76] = new rangos(Constantes.QUEEN, Constantes.THREE);
        rangoOrdenadoChubukov[77] = new rangos(Constantes.NINE, Constantes.JACK);
        rangoOrdenadoChubukov[78] = new rangos(Constantes.TEN, Constantes.EIGHT);
        rangoOrdenadoChubukov[79] = new rangos(Constantes.JACK, Constantes.SEVEN);
        rangoOrdenadoChubukov[80] = new rangos(Constantes.SEVEN, Constantes.QUEEN);
        rangoOrdenadoChubukov[81] = new rangos(Constantes.QUEEN, Constantes.TWO);
        rangoOrdenadoChubukov[82] = new rangos(Constantes.SIX, Constantes.QUEEN);
        rangoOrdenadoChubukov[83] = new rangos(Constantes.NINE, Constantes.EIGHT);
        rangoOrdenadoChubukov[84] = new rangos(Constantes.FIVE, Constantes.QUEEN);
        rangoOrdenadoChubukov[85] = new rangos(Constantes.EIGHT, Constantes.JACK);
        rangoOrdenadoChubukov[86] = new rangos(Constantes.NINE, Constantes.TEN);
        rangoOrdenadoChubukov[87] = new rangos(Constantes.JACK, Constantes.SIX);
        rangoOrdenadoChubukov[88] = new rangos(Constantes.JACK, Constantes.FIVE);
        rangoOrdenadoChubukov[89] = new rangos(Constantes.TEN, Constantes.SEVEN);
        rangoOrdenadoChubukov[90] = new rangos(Constantes.FOUR, Constantes.QUEEN);
        rangoOrdenadoChubukov[91] = new rangos(Constantes.JACK, Constantes.FOUR);
        rangoOrdenadoChubukov[92] = new rangos(Constantes.SEVEN, Constantes.JACK);
        rangoOrdenadoChubukov[93] = new rangos(Constantes.THREE, Constantes.QUEEN);
        rangoOrdenadoChubukov[94] = new rangos(Constantes.NINE, Constantes.SEVEN);
        rangoOrdenadoChubukov[95] = new rangos(Constantes.JACK, Constantes.THREE);
        rangoOrdenadoChubukov[96] = new rangos(Constantes.EIGHT, Constantes.TEN);
        rangoOrdenadoChubukov[97] = new rangos(Constantes.TEN, Constantes.SIX);
        rangoOrdenadoChubukov[98] = new rangos(Constantes.TWO, Constantes.QUEEN);
        rangoOrdenadoChubukov[99] = new rangos(Constantes.EIGHT, Constantes.SEVEN);
        rangoOrdenadoChubukov[100] = new rangos(Constantes.JACK, Constantes.TWO);
        rangoOrdenadoChubukov[101] = new rangos(Constantes.SIX, Constantes.JACK);
        rangoOrdenadoChubukov[102] = new rangos(Constantes.SEVEN, Constantes.TEN);
        rangoOrdenadoChubukov[103] = new rangos(Constantes.EIGHT, Constantes.NINE);
        rangoOrdenadoChubukov[104] = new rangos(Constantes.FIVE, Constantes.JACK);
        rangoOrdenadoChubukov[105] = new rangos(Constantes.NINE, Constantes.SIX);
        rangoOrdenadoChubukov[106] = new rangos(Constantes.TEN, Constantes.FIVE);
        rangoOrdenadoChubukov[107] = new rangos(Constantes.TEN, Constantes.FOUR);
        rangoOrdenadoChubukov[108] = new rangos(Constantes.EIGHT, Constantes.SIX);
        rangoOrdenadoChubukov[109] = new rangos(Constantes.FOUR, Constantes.JACK);
        rangoOrdenadoChubukov[110] = new rangos(Constantes.SIX, Constantes.TEN);
        rangoOrdenadoChubukov[111] = new rangos(Constantes.SEVEN, Constantes.NINE);
        rangoOrdenadoChubukov[112] = new rangos(Constantes.TEN, Constantes.THREE);
        rangoOrdenadoChubukov[113] = new rangos(Constantes.NINE, Constantes.FIVE);
        rangoOrdenadoChubukov[114] = new rangos(Constantes.SEVEN, Constantes.SIX);
        rangoOrdenadoChubukov[115] = new rangos(Constantes.THREE, Constantes.JACK);
        rangoOrdenadoChubukov[116] = new rangos(Constantes.SEVEN, Constantes.EIGHT);
        rangoOrdenadoChubukov[117] = new rangos(Constantes.TEN, Constantes.TWO);
        rangoOrdenadoChubukov[118] = new rangos(Constantes.EIGHT, Constantes.FIVE);
        rangoOrdenadoChubukov[119] = new rangos(Constantes.SIX, Constantes.NINE);
        rangoOrdenadoChubukov[120] = new rangos(Constantes.TWO, Constantes.JACK);
        rangoOrdenadoChubukov[121] = new rangos(Constantes.FIVE, Constantes.TEN);
        rangoOrdenadoChubukov[122] = new rangos(Constantes.NINE, Constantes.FOUR);
        rangoOrdenadoChubukov[123] = new rangos(Constantes.SEVEN, Constantes.FIVE);
        rangoOrdenadoChubukov[124] = new rangos(Constantes.FOUR, Constantes.TEN);
        rangoOrdenadoChubukov[125] = new rangos(Constantes.SIX, Constantes.FIVE);
        rangoOrdenadoChubukov[126] = new rangos(Constantes.SIX, Constantes.EIGHT);
        rangoOrdenadoChubukov[127] = new rangos(Constantes.NINE, Constantes.THREE);
        rangoOrdenadoChubukov[128] = new rangos(Constantes.FIVE, Constantes.NINE);
        rangoOrdenadoChubukov[129] = new rangos(Constantes.EIGHT, Constantes.FOUR);
        rangoOrdenadoChubukov[130] = new rangos(Constantes.THREE, Constantes.TEN);
        rangoOrdenadoChubukov[131] = new rangos(Constantes.SIX, Constantes.SEVEN);
        rangoOrdenadoChubukov[132] = new rangos(Constantes.NINE, Constantes.TWO);
        rangoOrdenadoChubukov[133] = new rangos(Constantes.SEVEN, Constantes.FOUR);
        rangoOrdenadoChubukov[134] = new rangos(Constantes.TWO, Constantes.TEN);
        rangoOrdenadoChubukov[135] = new rangos(Constantes.FIVE, Constantes.EIGHT);
        rangoOrdenadoChubukov[136] = new rangos(Constantes.FIVE, Constantes.FOUR);
        rangoOrdenadoChubukov[137] = new rangos(Constantes.SIX, Constantes.FOUR);
        rangoOrdenadoChubukov[138] = new rangos(Constantes.EIGHT, Constantes.THREE);
        rangoOrdenadoChubukov[139] = new rangos(Constantes.FOUR, Constantes.NINE);
        rangoOrdenadoChubukov[140] = new rangos(Constantes.FIVE, Constantes.SEVEN);
        rangoOrdenadoChubukov[141] = new rangos(Constantes.THREE, Constantes.NINE);
        rangoOrdenadoChubukov[142] = new rangos(Constantes.SEVEN, Constantes.THREE);
        rangoOrdenadoChubukov[143] = new rangos(Constantes.EIGHT, Constantes.TWO);
        rangoOrdenadoChubukov[144] = new rangos(Constantes.FIVE, Constantes.SIX);
        rangoOrdenadoChubukov[145] = new rangos(Constantes.FIVE, Constantes.THREE);
        rangoOrdenadoChubukov[146] = new rangos(Constantes.SIX, Constantes.THREE);
        rangoOrdenadoChubukov[147] = new rangos(Constantes.FOUR, Constantes.EIGHT);
        rangoOrdenadoChubukov[148] = new rangos(Constantes.TWO, Constantes.NINE);
        rangoOrdenadoChubukov[149] = new rangos(Constantes.FOUR, Constantes.THREE);
        rangoOrdenadoChubukov[150] = new rangos(Constantes.SEVEN, Constantes.TWO);
        rangoOrdenadoChubukov[151] = new rangos(Constantes.FOUR, Constantes.SEVEN);
        rangoOrdenadoChubukov[152] = new rangos(Constantes.FOUR, Constantes.FIVE);
        rangoOrdenadoChubukov[153] = new rangos(Constantes.THREE, Constantes.EIGHT);
        rangoOrdenadoChubukov[154] = new rangos(Constantes.FOUR, Constantes.SIX);
        rangoOrdenadoChubukov[155] = new rangos(Constantes.SIX, Constantes.TWO);
        rangoOrdenadoChubukov[156] = new rangos(Constantes.FIVE, Constantes.TWO);
        rangoOrdenadoChubukov[157] = new rangos(Constantes.TWO, Constantes.EIGHT);
        rangoOrdenadoChubukov[158] = new rangos(Constantes.FOUR, Constantes.TWO);
        rangoOrdenadoChubukov[159] = new rangos(Constantes.THREE, Constantes.SEVEN);
        rangoOrdenadoChubukov[160] = new rangos(Constantes.THREE, Constantes.SIX);
        rangoOrdenadoChubukov[161] = new rangos(Constantes.THREE, Constantes.FIVE);
        rangoOrdenadoChubukov[162] = new rangos(Constantes.THREE, Constantes.TWO);
        rangoOrdenadoChubukov[163] = new rangos(Constantes.TWO, Constantes.SEVEN);
        rangoOrdenadoChubukov[164] = new rangos(Constantes.THREE, Constantes.FOUR);
        rangoOrdenadoChubukov[165] = new rangos(Constantes.TWO, Constantes.SIX);
        rangoOrdenadoChubukov[166] = new rangos(Constantes.TWO, Constantes.FIVE);
        rangoOrdenadoChubukov[167] = new rangos(Constantes.TWO, Constantes.FOUR);
        rangoOrdenadoChubukov[168] = new rangos(Constantes.TWO, Constantes.THREE);
        
        
        
       
        rangoOrdenadoWillMa[0] = new rangos(TACE, TACE);
        rangoOrdenadoWillMa[1] = new rangos(TKING, TKING);
        rangoOrdenadoWillMa[2] = new rangos(TQUEEN, TQUEEN);
        rangoOrdenadoWillMa[3] = new rangos(TJACK, TJACK);
        rangoOrdenadoWillMa[4] = new rangos(TACE, TKING);//s
        rangoOrdenadoWillMa[5] = new rangos(TKING, TACE);//o
        rangoOrdenadoWillMa[6] = new rangos(TTEN, TTEN);
        rangoOrdenadoWillMa[7] = new rangos(TACE, TQUEEN);//s
        rangoOrdenadoWillMa[8] = new rangos(TQUEEN, TACE);//o
        rangoOrdenadoWillMa[9] = new rangos(TNINE, TNINE);
        rangoOrdenadoWillMa[10] = new rangos(TACE, TJACK);//s
        rangoOrdenadoWillMa[11] = new rangos(TKING, TQUEEN);//s
        rangoOrdenadoWillMa[12] = new rangos(TEIGHT, TEIGHT);
        rangoOrdenadoWillMa[13] = new rangos(TSEVEN, TSEVEN);
        rangoOrdenadoWillMa[14] = new rangos(TJACK, TACE);//o
        rangoOrdenadoWillMa[15] = new rangos(TQUEEN, TKING);//o
        rangoOrdenadoWillMa[16] = new rangos(TACE, TTEN);//s
        rangoOrdenadoWillMa[17] = new rangos(TSIX, TSIX);//
        rangoOrdenadoWillMa[18] = new rangos(TTEN, TACE);//o
        rangoOrdenadoWillMa[19] = new rangos(TACE, TNINE);//s
        rangoOrdenadoWillMa[20] = new rangos(TKING, TJACK);//S
        rangoOrdenadoWillMa[21] = new rangos(TFIVE, TFIVE);
        rangoOrdenadoWillMa[22] = new rangos(TACE, TEIGHT);//S
        rangoOrdenadoWillMa[23] = new rangos(TKING, TTEN);//s
        rangoOrdenadoWillMa[24] = new rangos(TQUEEN, TJACK);//s
        rangoOrdenadoWillMa[25] = new rangos(TQUEEN, TTEN);//s
        rangoOrdenadoWillMa[26] = new rangos(TJACK, TTEN);//s
        rangoOrdenadoWillMa[27] = new rangos(TNINE, TACE);//O
        rangoOrdenadoWillMa[28] = new rangos(TJACK, TKING);//O
        rangoOrdenadoWillMa[29] = new rangos(TFOUR, TFOUR);
        rangoOrdenadoWillMa[30] = new rangos(TTHREE, TTHREE);
        rangoOrdenadoWillMa[31] = new rangos(TTWO, TTWO);
        rangoOrdenadoWillMa[32] = new rangos(TACE, TSEVEN);
        rangoOrdenadoWillMa[33] = new rangos(TACE, TSIX);
       
        
        rangoOrdenadoJanda[0] = new rangos(TACE, TACE);
        rangoOrdenadoJanda[0] = new rangos(TKING, TKING);
        rangoOrdenadoJanda[0] = new rangos(TQUEEN, TQUEEN);
        rangoOrdenadoJanda[0] = new rangos(TJACK, TJACK);
        rangoOrdenadoJanda[0] = new rangos(TACE, TACE);
        
   }*/
   /*
   public void asignarRangos(){
       //FILA 0
       rangos[0][0] = 300; //por poner un numero grande
       rangos[0][1] = 277;
       rangos[0][2] = 137;
       rangos[0][3] = 91.6;
       rangos[0][4] = 69.5;
       rangos[0][5] = 52;
       rangos[0][6] = 44.9;
       rangos[0][7] = 39.5;
       rangos[0][8] = 35.3;
       rangos[0][9] = 36.1;
       rangos[0][10] = 33.3;
       rangos[0][11] = 31.1;
       rangos[0][12] = 29;
       //FILA 1
       rangos[1][0] = 166;
       rangos[1][1] = 477;
       rangos[1][2] = 43.3;
       rangos[1][3] = 36.3;
       rangos[1][4] = 31.4;
       rangos[1][5] = 23.9;
       rangos[1][6] = 19.9;
       rangos[1][7] = 18.6;
       rangos[1][8] = 17.4;
       rangos[1][9] = 16.1;
       rangos[1][10] = 15;
       rangos[1][11] = 14.1;
       rangos[1][12] = 13.3;
       //FILA 2
       rangos[2][0] = 96;
       rangos[2][1] = 29.3;
       rangos[2][2] = 239;
       rangos[2][3] = 24.7;
       rangos[2][4] = 21.9;
       rangos[2][5] = 16.2;
       rangos[2][6] = 13.3;
       rangos[2][7] = 11.3;
       rangos[2][8] = 10.9;
       rangos[2][9] = 10.1;
       rangos[2][10] = 9.4;
       rangos[2][11] = 8.8;
       rangos[2][12] = 8.3;
       //FILA 3
       rangos[3][0] = 68.1;
       rangos[3][1] = 25.4;
       rangos[3][2] = 16.4;
       rangos[3][3] = 159;
       rangos[3][4] = 18;
       rangos[3][5] = 12.8;
       rangos[3][6] = 10.3;
       rangos[3][7] = 8.5;
       rangos[3][8] = 7.3;
       rangos[3][9] = 7;
       rangos[3][10] = 6.4;
       rangos[3][11] = 6;
       rangos[3][12] = 5.5;
       //FILA 4
       rangos[4][0] = 53.1;
       rangos[4][1] = 22.4;
       rangos[4][2] = 14.8;
       rangos[4][3] = 11.5;
       rangos[4][4] = 120;
       rangos[4][5] = 11.2;
       rangos[4][6] = 8.7;
       rangos[4][7] = 7;
       rangos[4][8] = 5.9;
       rangos[4][9] = 4.9;
       rangos[4][10] = 4.6;
       rangos[4][11] = 4.2;
       rangos[4][12] = 3.7;
       //FILA 5
       rangos[5][0] = 40.8;
       rangos[5][1] = 17.8;
       rangos[5][2] = 11.7;
       rangos[5][3] = 8.8;
       rangos[5][4] = 7.4;
       rangos[5][5] = 95.7;
       rangos[5][6] = 7.6;
       rangos[5][7] = 6.1;
       rangos[5][8] = 5;
       rangos[5][9] = 4.1;
       rangos[5][10] = 3.2;
       rangos[5][11] = 3;
       rangos[5][12] = 2.6;
       //FILA 6
       rangos[6][0] = 35.4;
       rangos[6][1] = 15.2;
       rangos[6][2] = 9.9;
       rangos[6][3] = 7.4;
       rangos[6][4] = 6;
       rangos[6][5] = 5.1;
       rangos[6][6] = 79.6;
       rangos[6][7] = 5.5;
       rangos[6][8] = 4.5;
       rangos[6][9] = 3.6;
       rangos[6][10] = 2.8;
       rangos[6][11] = 2.2;
       rangos[6][12] = 2;
       //FILA 7
       rangos[7][0] = 31.3;
       rangos[7][1] = 14.2;
       rangos[7][2] = 8.5;
       rangos[7][3] = 6.3;
       rangos[7][4] = 5.1;
       rangos[7][5] = 4.2;
       rangos[7][6] = 3.7;
       rangos[7][7] = 67.4;
       rangos[7][8] = 4.1;
       rangos[7][9] = 3.2;
       rangos[7][10] = 2.5;
       rangos[7][11] = 2;
       rangos[7][12] = 1.6;
      //FILA 8
       rangos[8][0] = 28;
       rangos[8][1] = 13.3;
       rangos[8][2] = 8.1;
       rangos[8][3] = 5.3;
       rangos[8][4] = 4.2;
       rangos[8][5] = 3.5;
       rangos[8][6] = 3;
       rangos[8][7] = 2.7;
       rangos[8][8] = 57.6;
       rangos[8][9] = 3.1;
       rangos[8][10] = 2.3;
       rangos[8][11] = 1.8;
       rangos[8][12] = 1.5;
       //FILA 9
       rangos[9][0] = 28.2;
       rangos[9][1] = 12.3;
       rangos[9][2] = 7.5;
       rangos[9][3] = 5;
       rangos[9][4] = 3.4;
       rangos[9][5] = 2.8;
       rangos[9][6] = 2.4;
       rangos[9][7] = 2.1;
       rangos[9][8] = 1.9;
       rangos[9][9] = 49.3;
       rangos[9][10] = 2.4;
       rangos[9][11] = 1.9;
       rangos[9][12] = 1.5;
        //FILA 10
       rangos[10][0] = 25.9;
       rangos[10][1] = 11.4;
       rangos[10][2] = 6.8;
       rangos[10][3] = 4.4;
       rangos[10][4] = 3.1;
       rangos[10][5] = 2.1;
       rangos[10][6] = 1.8;
       rangos[10][7] = 1.6;
       rangos[10][8] = 1.5;
       rangos[10][9] = 1.6;
       rangos[10][10] = 40.9;
       rangos[10][11] = 1.7;
       rangos[10][12] = 1.4;
       //FILA 11
       rangos[11][0] = 24.2;
       rangos[11][1] = 10.6;
       rangos[11][2] = 6.2;
       rangos[11][3] = 3.9;
       rangos[11][4] = 2.7;
       rangos[11][5] = 2;
       rangos[11][6] = 1.5;
       rangos[11][7] = 1.3;
       rangos[11][8] = 1.3;
       rangos[11][9] = 1.3;
       rangos[11][10] = 1.1;
       rangos[11][11] = 32.7;
       rangos[11][12] = 1.2;
       //FILA 12
       rangos[12][0] = 22.5;
       rangos[12][1] = 10;
       rangos[12][2] = 5.6;
       rangos[12][3] = 3.44;
       rangos[12][4] = 2.4;
       rangos[12][5] = 1.8;
       rangos[12][6] = 1.4;
       rangos[12][7] = 1.1;
       rangos[12][8] = 1;
       rangos[12][9] = 1;
       rangos[12][10] = 0.9;
       rangos[12][11] = 0.9;
       rangos[12][12] = 24;
   }*/
   
   public void cargarRangos(FileReader fr, BufferedReader br) throws IOException{
       
       String cad, cad1, cad2;
       
       for(int i = 0; i < 169; i++){
           cad = br.readLine();
           cad1 = cad.substring(0, 1);
           cad2 = cad.substring(1, 2);
           if(cad.length()>2)
           {
               if(cad.charAt(2)=='s')
               {
                        rangoCargado[i] = new rangos(tablaCartaString.get(cad1), tablaCartaString.get(cad2));
           
               }
               else if(cad.charAt(2)=='o')
               {
                   rangoCargado[i] = new rangos( tablaCartaString.get(cad2),tablaCartaString.get(cad1));
           
               }
           }
           else if(cad.length()==2)
           {
              rangoCargado[i] = new rangos(tablaCartaString.get(cad1), tablaCartaString.get(cad2));
            
           }
           else
           {
               rangoCargado[i] = null;
           }
           
       }      
   }
   
   public double getRangos(int i, int j){
       return rangos[i][j];
   }
}
