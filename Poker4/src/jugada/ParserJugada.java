/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jugada;

import constantes.*;

/**
 *
 * @author pablo
 */
public class ParserJugada {
    private AntiguasConstantes cons;
    
    public ParserJugada() {
        cons = new AntiguasConstantes();
    }
    
    public String getJugada(String[] jugadaCompleta){
        if(jugadaCompleta[0].length() >=  cons.BEST_HAND.length() + cons.STRAIGHT_FLUSH.length()
                && jugadaCompleta[0].substring(cons.BEST_HAND.length(), cons.BEST_HAND.length() + cons.STRAIGHT_FLUSH.length()).equals(cons.STRAIGHT_FLUSH))
            return cons.STRAIGHT_FLUSH;
        if(jugadaCompleta[0].length() >= cons.BEST_HAND.length() + cons.FOUR_OF_A_KIND.length()
                && jugadaCompleta[0].substring(cons.BEST_HAND.length(), cons.BEST_HAND.length() + cons.FOUR_OF_A_KIND.length()).equals(cons.FOUR_OF_A_KIND))
            return cons.FOUR_OF_A_KIND;
        if(jugadaCompleta[0].length() >= cons.BEST_HAND.length() + cons.FULL_HOUSE.length()
                && jugadaCompleta[0].substring(cons.BEST_HAND.length(), cons.BEST_HAND.length() + cons.FULL_HOUSE.length()).equals(cons.FULL_HOUSE))
            return cons.FULL_HOUSE;
        if(jugadaCompleta[0].length() >= cons.BEST_HAND.length() + cons.FLUSH.length()
                && jugadaCompleta[0].substring(cons.BEST_HAND.length(), cons.BEST_HAND.length() + cons.FLUSH.length()).equals(cons.FLUSH))
            return cons.FLUSH;
        if(jugadaCompleta[0].length() >= cons.BEST_HAND.length() + cons.STRAIGHT.length()
                && jugadaCompleta[0].substring(cons.BEST_HAND.length(), cons.BEST_HAND.length() + cons.STRAIGHT.length()).equals(cons.STRAIGHT))
            return cons.STRAIGHT;
        if(jugadaCompleta[0].length() >= cons.BEST_HAND.length() + cons.THREE_OF_A_KIND.length()
                && jugadaCompleta[0].substring(cons.BEST_HAND.length(), cons.BEST_HAND.length() + cons.THREE_OF_A_KIND.length()).equals(cons.THREE_OF_A_KIND))
            return cons.THREE_OF_A_KIND;
        if(jugadaCompleta[0].length() >= cons.BEST_HAND.length() + cons.TWO_PAIR.length()
                && jugadaCompleta[0].substring(cons.BEST_HAND.length(), cons.BEST_HAND.length() + cons.TWO_PAIR.length()).equals(cons.TWO_PAIR))
            return cons.TWO_PAIR;
        if(jugadaCompleta[0].length() >= cons.BEST_HAND.length() + cons.PAIR.length()
                && jugadaCompleta[0].substring(cons.BEST_HAND.length(), cons.BEST_HAND.length() + cons.PAIR.length()).equals(cons.PAIR))
            return cons.PAIR;
        if(jugadaCompleta[0].length() >= cons.BEST_HAND.length() + cons.HIGH_CARD.length()
                && jugadaCompleta[0].substring(cons.BEST_HAND.length(), cons.BEST_HAND.length() + cons.HIGH_CARD.length()).equals(cons.HIGH_CARD))
            return cons.HIGH_CARD;
        return "";
    }
}

