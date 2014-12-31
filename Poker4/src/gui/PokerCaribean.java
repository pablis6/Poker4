/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import carta.*;
import constantes.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import jugada.ParserJugada;
import jugada.ValorMano;
import jugador.Jugador;

/**
 *
 * @author pablo
 */
public class PokerCaribean extends javax.swing.JFrame {

    private Constantes cons;
    private final JPanelConFondo cartasBanca[];
    private final JPanelConFondo cartasUsuario[];
    private final JPanelConFondo cartasComunes[];
    private int dineroApuesta;
    private Baraja baraja;
    private Jugador jugador, banca;
    private Carta[] cartasB, cartasJ, aux, board;
    private ValorMano va;
    private String[] resultadoB, resultadoJ;
    private int ganador;
    private String jugadaB, jugadaJ;
    private ParserJugada parser;
    private boolean menorTrio;
    private String nombreJugadaBanca;
    private String nombreJugadaJ;
    
    /**
     * Creates new form pokerCaribean
     */
    public PokerCaribean() {
        
        initComponents();
        cons = new Constantes();
        cartasBanca = new JPanelConFondo[2];
        cartasUsuario = new JPanelConFondo[2];
        cartasComunes = new JPanelConFondo[5];
        jugador = new Jugador(1000);
        banca = new Jugador(1000);
        cartasB = new Carta[7];
        cartasJ = new Carta[7];
        board = new Carta[5];
        baraja = Baraja.getInstance();
        va = new ValorMano();
        parser = new ParserJugada();
        
        int ancho = 65;
        int alto = 104;
        int x = this.getWidth()/2 - (ancho*4);
        int y = 150;
        
        cartasBanca[0] = new JPanelConFondo("/resources/reverso.JPG");
        cartasBanca[0].setBounds(this.getWidth()/2 - (ancho*2), 30, ancho, alto);
        this.add(cartasBanca[0]);
        cartasBanca[1] = new JPanelConFondo("/resources/reverso.JPG");
        cartasBanca[1].setBounds(this.getWidth()/2 - ancho, 30, ancho, alto);
        this.add(cartasBanca[1]);
        
        cartasUsuario[0] = new JPanelConFondo("/resources/reverso.JPG");
        cartasUsuario[0].setBounds(this.getWidth()/2 - (ancho*2), alto+y+16, ancho, alto);
        this.add(cartasUsuario[0]);
        cartasUsuario[1] = new JPanelConFondo("/resources/reverso.JPG");
        cartasUsuario[1].setBounds(this.getWidth()/2 - ancho, alto+y+16, ancho, alto);
        this.add(cartasUsuario[1]);
        
        cartasComunes[0] = new JPanelConFondo("/resources/reverso.JPG");
        cartasComunes[0].setBounds(x, y, ancho, alto);
        this.add(cartasComunes[0]);
        cartasComunes[1] = new JPanelConFondo("/resources/reverso.JPG");
        cartasComunes[1].setBounds(x+ancho, y, ancho, alto);
        this.add(cartasComunes[1]);
        cartasComunes[2] = new JPanelConFondo("/resources/reverso.JPG");
        cartasComunes[2].setBounds(x+(ancho*2), y, ancho, alto);
        this.add(cartasComunes[2]);
        cartasComunes[3] = new JPanelConFondo("/resources/reverso.JPG");
        cartasComunes[3].setBounds(x+(ancho*3), y, ancho, alto);
        this.add(cartasComunes[3]);
        cartasComunes[4] = new JPanelConFondo("/resources/reverso.JPG");
        cartasComunes[4].setBounds(x+(ancho*4), y, ancho, alto);
        this.add(cartasComunes[4]);
        
        this.tfMiStack.setText(Integer.toString(jugador.getDinero()));
        this.tfMiStack.setEditable(false);
        this.tfGanados.setText(Integer.toString(jugador.getGanado()));
        this.tfPerdidos.setText(Integer.toString(jugador.getPerdido()));
        this.tfEmpatadas.setText(Integer.toString(jugador.getEmpatado()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        btApostar = new javax.swing.JButton();
        tfDineroApostado = new javax.swing.JTextField();
        lblApuestas = new javax.swing.JLabel();
        tfMiStack = new javax.swing.JTextField();
        lblStack = new javax.swing.JLabel();
        btRetirarse = new javax.swing.JButton();
        tfResultado = new javax.swing.JTextField();
        tfGanados = new javax.swing.JTextField();
        lblGanado = new javax.swing.JLabel();
        tfPerdidos = new javax.swing.JTextField();
        lblPerdido = new javax.swing.JLabel();
        tfEmpatadas = new javax.swing.JTextField();
        lblEmpatado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmSalir = new javax.swing.JMenu();
        jmRecargarSaldo = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btApostar.setText("Empezar");
        btApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btApostarActionPerformed(evt);
            }
        });

        tfDineroApostado.setEditable(false);

        lblApuestas.setText("Apuestas");

        tfMiStack.setEditable(false);
        tfMiStack.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        lblStack.setText("Tu stack");

        btRetirarse.setText("Retirarse");
        btRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetirarseActionPerformed(evt);
            }
        });

        tfResultado.setEditable(false);
        tfResultado.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        tfResultado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        tfGanados.setEditable(false);

        lblGanado.setText("Ganadas");

        tfPerdidos.setEditable(false);

        lblPerdido.setText("Perdidas");

        tfEmpatadas.setEditable(false);

        lblEmpatado.setText("Empatadas");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Banca:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Jugador:");

        jmSalir.setText("Salir");
        jMenuBar1.add(jmSalir);

        jmRecargarSaldo.setText("Añadir dinero");
        jmRecargarSaldo.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jmRecargarSaldoMenuSelected(evt);
            }
        });
        jMenuBar1.add(jmRecargarSaldo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblEmpatado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApuestas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGanado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPerdido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblStack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btRetirarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btApostar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfDineroApostado)
                            .addComponent(tfMiStack)
                            .addComponent(tfGanados)
                            .addComponent(tfPerdidos)
                            .addComponent(tfEmpatadas))
                        .addGap(49, 49, 49))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tfResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmpatado)
                    .addComponent(tfEmpatadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPerdidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPerdido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfGanados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGanado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDineroApostado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblApuestas))
                .addGap(18, 18, 18)
                .addComponent(btApostar)
                .addGap(18, 18, 18)
                .addComponent(btRetirarse)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfMiStack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblStack)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApostarActionPerformed
        if(btApostar.getText().equalsIgnoreCase("Empezar")){
            
            jLabel1.setText("");
            jLabel2.setText("");
            
            if(jugador.getDinero() <= 5){
                JOptionPane.showMessageDialog(this, "No tienes saldo suficiente para jugar." + '\n' +
                   "Por favor, algo de dinero para poder jugar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    resetearCartas();
                    tfResultado.setText("");
                    jugador.sacarCredito(1);
                    dineroApuesta ++;
                    
                    //banca
                    aux = baraja.generaCartasConString(baraja.getJugadaString(2));
                    cartasB[0] = aux[0];
                    cartasB[1] = aux[1];
                    banca.setCarta1(cartasB[0]);
                    banca.setCarta2(cartasB[1]);
                   //jugador
                    aux = baraja.generaCartasConString(baraja.getJugadaString(2));
                    cartasJ[0] = aux[0];
                    cartasJ[1] = aux[1];
                    jugador.setCarta1(cartasJ[0]);
                    jugador.setCarta2(cartasJ[1]);
                    cartasUsuario[0].setImagen("/resources/" + jugador.getCarta1().getDenominacion()+ ".png");
                    cartasUsuario[1].setImagen("/resources/" + jugador.getCarta2().getDenominacion()+ ".png");
                    
                    btApostar.setText("Flop");
                    tfDineroApostado.setText(Integer.toString(dineroApuesta));
                    tfMiStack.setText(Integer.toString(jugador.getDinero()));
                }   
        }
        else if(btApostar.getText().equalsIgnoreCase("Flop")){
            jugador.sacarCredito(2);
            dineroApuesta+=2;
            //generar tres cartas aleatorias para flop
            aux = baraja.generaCartasConString(baraja.getJugadaString(3));
            for(int i = 0; i < 3; i++){
                board[i] = aux[i];
                cartasComunes[i].setImagen("/resources/" + board[i].getDenominacion()+ ".png");
            }            
            btApostar.setText("Turn");
            tfDineroApostado.setText(Integer.toString(dineroApuesta));
            tfMiStack.setText(Integer.toString(jugador.getDinero()));
        }
        else if(btApostar.getText().equalsIgnoreCase("Turn")){
            jugador.sacarCredito(1);
            dineroApuesta++;
            //generar carta aleatoria para turn
            aux = baraja.generaCartasConString(baraja.getJugadaString(1));
            board[3] = aux[0];
            cartasComunes[3].setImagen("/resources/" + board[3].getDenominacion()+ ".png");
            
            btApostar.setText("River");
            tfDineroApostado.setText(Integer.toString(dineroApuesta));
            tfMiStack.setText(Integer.toString(jugador.getDinero()));
        }
        else if(btApostar.getText().equalsIgnoreCase("River")){
            
            jugador.sacarCredito(1);
            dineroApuesta++;
            tfDineroApostado.setText(Integer.toString(dineroApuesta));
            tfMiStack.setText(Integer.toString(jugador.getDinero()));
            //generar carta aleatoria para river
            aux = baraja.generaCartasConString(baraja.getJugadaString(1));
            board[4] = aux[0];
            cartasComunes[4].setImagen("/resources/" + board[4].getDenominacion()+ ".png");
            //mostrar cartas banca
            cartasBanca[0].setImagen("/resources/" + banca.getCarta1().getDenominacion() + ".png");
            cartasBanca[1].setImagen("/resources/" + banca.getCarta2().getDenominacion()+ ".png");
            //analizar showdown
            for(int i = 0; i < 5; i++){
                cartasB[i+2] = board[i];
                cartasJ[i+2] = board[i];
            }
            resultadoJ = va.valorarMiMano(cartasJ);
            resultadoB = va.valorarMiMano(cartasB);
            ganador = ganador(resultadoJ, resultadoB);
            
            jLabel1.setText(this.jugadaJ);
            jLabel2.setText(this.jugadaB);
            
            if(ganador == 0){//empate
                jugador.aniadirCredito(dineroApuesta);
                tfResultado.setText("EMPATE");
                tfResultado.setForeground(Color.YELLOW);
                jugador.sumaEmpatado();
                tfEmpatadas.setText(Integer.toString(jugador.getEmpatado()));
            }
            else if(ganador == 1){//gana jugador
                if(this.menorTrio == false)
                    jugador.aniadirCredito(dineroApuesta*2);
                else
                    jugador.aniadirCredito((dineroApuesta*2)-1);
                
                tfResultado.setText("GANAS");
                tfResultado.setForeground(Color.GREEN);
                jugador.sumaGanado();
                tfGanados.setText(Integer.toString(jugador.getGanado()));
            }
            else {
                tfResultado.setText("PIERDES");
                tfResultado.setForeground(Color.RED);
                jugador.sumaPerdido();
                tfPerdidos.setText(Integer.toString(jugador.getPerdido()));
            }//gana banca

            //reiniciar el contador de dineroApuesta
            dineroApuesta = 0;
            
            btApostar.setText("Empezar");
            tfDineroApostado.setText(Integer.toString(dineroApuesta));
            tfMiStack.setText(Integer.toString(jugador.getDinero()));
        }
    }//GEN-LAST:event_btApostarActionPerformed

    private void btRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetirarseActionPerformed
        //quitar cartas de jugador y banca y resetear baraja
        
        jLabel1.setText("");
        jLabel2.setText("");
        
        btApostar.setText("Empezar");
        dineroApuesta = 0;
        tfResultado.setText("");
        tfDineroApostado.setText(Integer.toString(dineroApuesta));
        resetearCartas();
    }//GEN-LAST:event_btRetirarseActionPerformed

    private void jmRecargarSaldoMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jmRecargarSaldoMenuSelected
        // TODO add your handling code here:
        new VentanaDinero(this.jugador, this).setVisible(true);
    }//GEN-LAST:event_jmRecargarSaldoMenuSelected

    public void setDinero(){
        tfMiStack.setText(Integer.toString(this.jugador.getDinero()));
    }
    
    private int ganador(String[] resultadoJ, String[] resultadoB) { //0 empate, 1 jugador, 2 banca
        jugadaJ = parser.getJugada(resultadoJ);
        jugadaB = parser.getJugada(resultadoB);
        //explicacion en pseudocodigo de los siguiente:
        /*
        if(jugada del jugador es igual que la de la banca) (los carta alta por ejemplo)
            if(kiker1 iguales)
                if(kiker2 iguales)
                    if(kiker3 iguales)
                        if(kiker4 iguales)
                            if(kiker5 iguales)
                                es la misma mano
                            else if(kiker5 jugador es mejor que kiker5 banca
                                gana jugador
                            else gana banca
                        los mismos elses
                    los mismos elses
                los mismos elses
            los mismos elses
        else if jugada del jugador es mejor que la de la banca
        else jugada del jugador es peor que la de la banca
                
        */
        if(cons.tablaValoresMano.get(jugadaJ) == cons.tablaValoresMano.get(jugadaB))
            if(cons.tablaStringValor.get(resultadoJ[1]) == cons.tablaStringValor.get(resultadoB[1]))
                if(cons.tablaStringValor.get(resultadoJ[2]) == cons.tablaStringValor.get(resultadoB[2]))
                    if(cons.tablaStringValor.get(resultadoJ[3]) == cons.tablaStringValor.get(resultadoB[3]))
                        if(cons.tablaStringValor.get(resultadoJ[4]) == cons.tablaStringValor.get(resultadoB[4]))
                            if(cons.tablaStringValor.get(resultadoJ[5]) == cons.tablaStringValor.get(resultadoB[5]))
                                return 0;
                            else if (cons.tablaStringValor.get(resultadoJ[4]) < cons.tablaStringValor.get(resultadoB[4]))
                                return 1;
                            else return 2;
                        else if (cons.tablaStringValor.get(resultadoJ[4]) < cons.tablaStringValor.get(resultadoB[4]))
                            return 1;
                        else return 2;
                    else if (cons.tablaStringValor.get(resultadoJ[3]) < cons.tablaStringValor.get(resultadoB[3]))
                        return 1;
                    else return 2;
                else if (cons.tablaStringValor.get(resultadoJ[2]) < cons.tablaStringValor.get(resultadoB[2]))
                    return 1;
                else return 2;
            else if (cons.tablaStringValor.get(resultadoJ[1]) < cons.tablaStringValor.get(resultadoB[1]))
                return 1;
            else return 2;
        
        else if(cons.tablaValoresMano.get(jugadaJ) > cons.tablaValoresMano.get(jugadaB)){
            //mejor jugada de jugador
            if(jugadaJ.equalsIgnoreCase(cons.TWO_PAIR) || jugadaJ.equalsIgnoreCase(cons.PAIR)
                    || jugadaJ.equalsIgnoreCase(cons.HIGH_CARD)){
                this.menorTrio = true;
            }
            else
                this.menorTrio = false;
            return 1;
        }
        else return 2; // por descarte la mejor jugada es de la banca
    }
    
    private void resetearCartas(){
        //ponemos reverso
        baraja.reset();
        for(int i = 0; i < 5;i++)
            cartasComunes[i].setImagen("/resources/reverso.JPG"); 
        cartasUsuario[0].setImagen("/resources/reverso.JPG");
        cartasUsuario[1].setImagen("/resources/reverso.JPG");
        cartasBanca[0].setImagen("/resources/reverso.JPG");
        cartasBanca[1].setImagen("/resources/reverso.JPG");
        this.repaint();        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PokerCaribean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PokerCaribean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PokerCaribean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PokerCaribean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PokerCaribean().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btApostar;
    private javax.swing.JButton btRetirarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmRecargarSaldo;
    private javax.swing.JMenu jmSalir;
    private javax.swing.JLabel lblApuestas;
    private javax.swing.JLabel lblEmpatado;
    private javax.swing.JLabel lblGanado;
    private javax.swing.JLabel lblPerdido;
    private javax.swing.JLabel lblStack;
    private javax.swing.JTextField tfDineroApostado;
    private javax.swing.JTextField tfEmpatadas;
    private javax.swing.JTextField tfGanados;
    private javax.swing.JTextField tfMiStack;
    private javax.swing.JTextField tfPerdidos;
    private javax.swing.JTextField tfResultado;
    // End of variables declaration//GEN-END:variables

}