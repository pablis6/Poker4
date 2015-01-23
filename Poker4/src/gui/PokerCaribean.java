/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import carta.*;
import constantes.*;
import equity.Equity;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import jugada.Jugador;
import jugada.ParserJugada;
import jugada.ValorMano;
import jugador.Player;
import ordenacion.MergeSort;

/**
 *
 * @author pablo
 */
public class PokerCaribean extends javax.swing.JFrame {

    private Constantes cons;
    private AntiguasConstantes acons;
    private final JPanelConFondo cartasBanca[];
    private final JPanelConFondo cartasUsuario[];
    private final JPanelConFondo cartasComunes[];
    private int dineroApuesta;
    private Baraja baraja;
    private Player jugador, banca;
    private Carta[] cartasB, cartasJ, aux, board;
    private ValorMano va;
    private String[] resultadoB, resultadoJ;
    private int ganador;
    private String jugadaB, jugadaJ;
    private ParserJugada parser;
    private boolean menorTrio;
    private String nombreJugadaBanca;
    private String nombreJugadaJ;
    static PokerCaribean instance;
    private double equityPreFlop;
    private double equityFlop;
    private double equityTurn;
    /**
     * Creates new form pokerCaribean
     */
    private PokerCaribean() {
        
        initComponents();
        cons = new Constantes();
        acons = new AntiguasConstantes();
        cartasBanca = new JPanelConFondo[2];
        cartasUsuario = new JPanelConFondo[2];
        cartasComunes = new JPanelConFondo[5];
        jugador = new Player(0);
        banca = new Player(1000);
        cartasB = new Carta[7];
        cartasJ = new Carta[7];
        board = new Carta[5];
        baraja = Baraja.getInstance();
        va = new ValorMano();
        parser = new ParserJugada();
        
        equityPreFlop = (4.d/9.d)*100;
        equityFlop = (2.d/9.d)*100;
        equityTurn = (1.d/9.d)*100;
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

    public void setEquity(double eq)
    {
        tfEquity.setText(Double.toString(eq));
    }
    
    public void reiniciaEquity()
    {
        tfEquity.setText("");
    }
    
    public String[] getCartas(int numJug)
    {
        String []cartas = new String[2];
        
        switch(numJug)
        {
            case AntiguasConstantes.JUGADOR:
                cartas[0]= jugador.getCarta1().getDenominacion();
                cartas[1]= jugador.getCarta2().getDenominacion();
                break;
           
            case AntiguasConstantes.BANCA:
                cartas[0]= banca.getCarta1().getDenominacion();
                cartas[1]= banca.getCarta2().getDenominacion();
                break;                
        }
        return cartas;
    }
    
    public String getBoard()
    {
        String miBoard = "";
        for(int i =0; i < 5 && board[i]!= null;i++)
        {
            miBoard = miBoard + board[i].getDenominacion();
        }
        return miBoard;
          
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
        lbJugador = new javax.swing.JLabel();
        lbBanca = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btAuto = new javax.swing.JButton();
        tfEquity = new javax.swing.JTextField();
        tfNumJugadas = new javax.swing.JTextField();
        jbManual = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfPreflop = new javax.swing.JTextField();
        tfFlop = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfTurn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btGuardar = new javax.swing.JButton();
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
        tfResultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfResultadoActionPerformed(evt);
            }
        });

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

        jLabel5.setText("Ganas");
        jLabel5.setVisible(false);

        jLabel6.setText("         ");
        jLabel6.setVisible(false);

        jLabel7.setText("euros");
        jLabel7.setVisible(false);

        btAuto.setText("Auto");
        btAuto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAutoActionPerformed(evt);
            }
        });

        tfEquity.setEditable(false);
        tfEquity.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        jbManual.setText("Manual");
        jbManual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbManualActionPerformed(evt);
            }
        });

        jLabel1.setText("Introduzca los porcentajes minimos de equity para estrategia personalizada");

        jLabel2.setText("pre-flop");

        jLabel8.setText("flop");

        jLabel9.setText("turn");

        btGuardar.setText("guardar");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        jmSalir.setText("Salir");
        jMenuBar1.add(jmSalir);

        jmRecargarSaldo.setText("Añadir dinero");
        jmRecargarSaldo.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jmRecargarSaldoMenuSelected(evt);
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
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
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfEquity, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jbManual)
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(lblEmpatado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblApuestas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblGanado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblPerdido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblStack, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(tfNumJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btAuto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btRetirarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btApostar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(tfDineroApostado)
                                            .addComponent(tfMiStack)
                                            .addComponent(tfGanados)
                                            .addComponent(tfPerdidos)
                                            .addComponent(tfEmpatadas, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tfResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfPreflop, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfFlop, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btGuardar)
                                .addGap(35, 35, 35)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbBanca, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbBanca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(tfResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfEquity, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(36, 36, 36)
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
                            .addComponent(lblStack))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAuto)
                            .addComponent(tfNumJugadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbManual))
                        .addGap(37, 37, 37)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(tfPreflop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(tfFlop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)
                                    .addComponent(tfTurn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btGuardar))))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApostarActionPerformed
        if(btApostar.getText().equalsIgnoreCase("Empezar")){
            lbJugador.setText("");
            lbBanca.setText("");
            jLabel5.setVisible(false);
            jLabel6.setVisible(false);
            jLabel6.setText("");
            jLabel7.setVisible(false);
            
            if(jugador.getDinero() < 5){
                JOptionPane.showMessageDialog(this, "No tienes saldo suficiente para jugar." + '\n' +
                   "Por favor, introduce dinero para poder jugar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    resetearCartas();
                    tfResultado.setText("");
                    jugador.sacarCredito(1);
                    dineroApuesta ++;
                    
                    //banca
                    aux = baraja.generaCartasConString(baraja.getJugadaString(baraja.generaJugada(2)));
                    cartasB[0] = aux[0];
                    cartasB[1] = aux[1];
                    banca.setCarta1(cartasB[0]);
                    banca.setCarta2(cartasB[1]);
                   //jugador
                    aux = baraja.generaCartasConString(baraja.getJugadaString(baraja.generaJugada(2)));
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
            aux = baraja.generaCartasConString(baraja.getJugadaString(baraja.generaJugada(3)));
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
            aux = baraja.generaCartasConString(baraja.getJugadaString(baraja.generaJugada(1)));
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
            aux = baraja.generaCartasConString(baraja.getJugadaString(baraja.generaJugada(1)));
            board[4] = aux[0];
            cartasComunes[4].setImagen("/resources/" + board[4].getDenominacion()+ ".png");
            //mostrar cartas banca
            cartasBanca[0].setImagen("/resources/" + banca.getCarta1().getDenominacion() + ".png");
            cartasBanca[1].setImagen("/resources/" + banca.getCarta2().getDenominacion()+ ".png");
            analizarShowDown();
            
        }
    }//GEN-LAST:event_btApostarActionPerformed

    private void analizarShowDown(){
        //analizar showdown
        for(int i = 0; i < 5; i++){
            cartasB[i+2] = board[i];
            cartasJ[i+2] = board[i];
        }
        MergeSort merge = new MergeSort(2);
         merge.iniciaEmpatados();

         Jugador[] jugadoresConCartas = new Jugador[2];
         va = new ValorMano();
         jugadoresConCartas[0] = new Jugador(cartasJ,acons.JUGADOR);
         jugadoresConCartas[0].setJugada(va.valorarMiMano(cartasJ));

         va = new ValorMano();
         jugadoresConCartas[1] = new Jugador(cartasB,acons.BANCA);
         jugadoresConCartas[1].setJugada(va.valorarMiMano(cartasB));

        Jugador jugConCartasCopy[] = new Jugador[2];
        System.arraycopy(jugadoresConCartas, 0, jugConCartasCopy, 0, jugadoresConCartas.length);
         Jugador jugOrdenados []= merge.mergeSort(jugConCartasCopy);

        //SI estan empatados
        if(merge.estaJugadorEmpatadoEnLaLista(jugOrdenados[1].getId())){

            ganador=acons.EMPATE;
            ponJugadaEnLabel(lbJugador, jugOrdenados[1].getJugada());
            ponJugadaEnLabel(lbBanca, jugOrdenados[0].getJugada());
        }
        else{
            if (jugOrdenados[1].getId() == acons.BANCA){//gana la banca
                ganador = acons.BANCA;
                ponJugadaEnLabel(lbJugador, jugOrdenados[0].getJugada());
                ponJugadaEnLabel(lbBanca, jugOrdenados[1].getJugada());
            }
            else if (jugOrdenados[1].getId() == acons.JUGADOR){//gana el jugador
                ganador = acons.JUGADOR;
                if(jugOrdenados[1].getJugada()[0] == acons.TWO_PAIR_INT || jugOrdenados[1].getJugada()[0] == acons.PAIR_INT || jugOrdenados[1].getJugada()[0] == acons.HIGH_CARD_INT){
                    this.menorTrio = true;
                }
                else{
                    this.menorTrio = false;
                }
                ponJugadaEnLabel(lbJugador, jugOrdenados[1].getJugada());
                ponJugadaEnLabel(lbBanca, jugOrdenados[0].getJugada());
            }
        }if(ganador == acons.EMPATE){//empate
                jugador.aniadirCredito(dineroApuesta);
                tfResultado.setText("EMPATE");
                tfResultado.setForeground(Color.YELLOW);
                jLabel6.setText(Integer.toString(dineroApuesta));
                jLabel5.setVisible(true);
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
                jugador.sumaEmpatado();
                tfEmpatadas.setText(Integer.toString(jugador.getEmpatado()));
            }
            else if(ganador == acons.JUGADOR){//gana jugador
                if(this.menorTrio == false){
                    jugador.aniadirCredito(dineroApuesta*2);
                    jLabel6.setText(Integer.toString(dineroApuesta*2));
                }
                else{
                    jugador.aniadirCredito((dineroApuesta*2)-1);
                    jLabel6.setText(Integer.toString((dineroApuesta*2)-1));
                }
                    
                tfResultado.setText("GANAS");
                tfResultado.setForeground(Color.GREEN);
                jLabel5.setVisible(true);
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
                jugador.sumaGanado();
                tfGanados.setText(Integer.toString(jugador.getGanado()));
            }
            else {
                tfResultado.setText("PIERDES");
                tfResultado.setForeground(Color.RED);
                jLabel6.setText(Integer.toString(0));
                jLabel5.setVisible(true);
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
                jugador.sumaPerdido();
                tfPerdidos.setText(Integer.toString(jugador.getPerdido()));
            }//gana banca

            //reiniciar el contador de dineroApuesta
            dineroApuesta = 0;
            
            btApostar.setText("Empezar");
            tfDineroApostado.setText(Integer.toString(dineroApuesta));
            tfMiStack.setText(Integer.toString(jugador.getDinero()));
    }
    
    private void btRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetirarseActionPerformed
        //quitar cartas de jugador y banca y resetear baraja
        
        lbJugador.setText("");
        lbBanca.setText("");
        tfEquity.setText("");
        jLabel5.setVisible(false);
        jLabel6.setVisible(false);
        jLabel6.setText("");
        jLabel7.setVisible(false);
        
        btApostar.setText("Empezar");
        dineroApuesta = 0;
        tfResultado.setText("");
        tfDineroApostado.setText(Integer.toString(dineroApuesta));
        resetearCartas();
    }//GEN-LAST:event_btRetirarseActionPerformed

    private void ponJugadaEnLabel(JLabel lb, int[] jugada)
    {
        AntiguasConstantes constantes  = new AntiguasConstantes();
        
        switch(jugada[0])
        {
            case AntiguasConstantes.HIGH_CARD_INT:
                lb.setText(constantes.tablaManoValores.get(jugada[0])+ " : "
                +constantes.tablaValorString.get(jugada[1])+ " , "
                +constantes.tablaValorString.get(jugada[2])+ " , "
                +constantes.tablaValorString.get(jugada[3])+ " , "
                +constantes.tablaValorString.get(jugada[4])+ " , "
                +constantes.tablaValorString.get(jugada[5]));
                
                break;
            case AntiguasConstantes.PAIR_INT:
                lb.setText(constantes.tablaManoValores.get(jugada[0])+ " of "
                +constantes.tablaValorString.get(jugada[1])+ " with kickers "
                +constantes.tablaValorString.get(jugada[2])+ " , "
                +constantes.tablaValorString.get(jugada[3])+ " , "
                +constantes.tablaValorString.get(jugada[4]));
                break;
            case AntiguasConstantes.TWO_PAIR_INT:
                lb.setText(constantes.tablaManoValores.get(jugada[0])+ " of "
                +constantes.tablaValorString.get(jugada[1])+ " and "
                +constantes.tablaValorString.get(jugada[2])+ " with kicker "
                +constantes.tablaValorString.get(jugada[3]));
                break;
            case AntiguasConstantes.THREE_OF_A_KIND_INT:
                lb.setText(constantes.tablaManoValores.get(jugada[0])+ " of "
                +constantes.tablaValorString.get(jugada[1])+ " witch kickers "
                +constantes.tablaValorString.get(jugada[2])+ " , " 
                +constantes.tablaValorString.get(jugada[3]));
                break;
                
            case AntiguasConstantes.STRAIGHT_INT:
                lb.setText(constantes.tablaManoValores.get(jugada[0])+ " of "
                +constantes.tablaValorString.get(jugada[1]));
                break;
            case AntiguasConstantes.FLUSH_INT:
                lb.setText(constantes.tablaManoValores.get(jugada[0])+ " : "
                +constantes.tablaValorString.get(jugada[1])+ " , "
                +constantes.tablaValorString.get(jugada[2])+ " , "
                +constantes.tablaValorString.get(jugada[3])+ " , "
                +constantes.tablaValorString.get(jugada[4])+ " , "
                +constantes.tablaValorString.get(jugada[5]));
                break;
            case AntiguasConstantes.FULL_HOUSE_INT:
                lb.setText(constantes.tablaManoValores.get(jugada[0])+ " of "
                +constantes.tablaValorString.get(jugada[1])+ " and "
                +constantes.tablaValorString.get(jugada[2]));
                break;
            case AntiguasConstantes.FOUR_OF_A_KIND_INT:
                lb.setText(constantes.tablaManoValores.get(jugada[0])+ " of "
                +constantes.tablaValorString.get(jugada[1])+ " and "
                +constantes.tablaValorString.get(jugada[2]));
                break;
            case AntiguasConstantes.STRAIGHT_FLUSH_INT:
                lb.setText(constantes.tablaManoValores.get(jugada[0])+ " of "
                +constantes.tablaValorString.get(jugada[1]));
                break;
        }
    }
    private void jmRecargarSaldoMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jmRecargarSaldoMenuSelected
        // TODO add your handling code here:
        new VentanaDinero(this.jugador, this).setVisible(true);
    }//GEN-LAST:event_jmRecargarSaldoMenuSelected

    private void tfResultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfResultadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfResultadoActionPerformed

    private void btAutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAutoActionPerformed
        // TODO add your handling code here:
        Equity equity;
        double e;
        equity = new Equity();
        
        for(int i = 0; i < 1; i++){
            if(jugador.getDinero() < 5){
                JOptionPane.showMessageDialog(this, "No tienes saldo suficiente para jugar." + '\n' +
                   "Por favor, introduce dinero para poder jugar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            else{
                resetearCartas();
                board = new Carta[5];
                jugador.sacarCredito(1);
                dineroApuesta ++;

                //banca
                aux = baraja.generaCartasConString(baraja.getJugadaString(baraja.generaJugada(2)));
                cartasB[0] = aux[0];
                cartasB[1] = aux[1];
                banca.setCarta1(cartasB[0]);
                banca.setCarta2(cartasB[1]);

                //jugador
                aux = baraja.generaCartasConString(baraja.getJugadaString(baraja.generaJugada(2)));
                cartasJ[0] = aux[0];
                cartasJ[1] = aux[1];
                jugador.setCarta1(cartasJ[0]);
                jugador.setCarta2(cartasJ[1]);
                
                baraja.deshabilitarCarta(cartasB[0].getDenominacion());
                baraja.deshabilitarCarta(cartasB[1].getDenominacion());

                tfDineroApostado.setText(Integer.toString(dineroApuesta));
                tfMiStack.setText(Integer.toString(jugador.getDinero()));

                //mano
                e = equity.calculaEquity();
                if(e < equityPreFlop)
                    btRetirarseActionPerformed(evt);
                else{
                    //flop
                    jugador.sacarCredito(2);
                    dineroApuesta+=2;
                    //generar tres cartas aleatorias para flop
                    aux = baraja.generaCartasConString(baraja.getJugadaString(baraja.generaJugada(3)));
                    for(int j = 0; j < 3; j++){
                        board[j] = aux[j];
                    }
                    tfDineroApostado.setText(Integer.toString(dineroApuesta));
                    tfMiStack.setText(Integer.toString(jugador.getDinero()));
                    e = equity.calculaEquity();
                    if(e < equityFlop)
                        btRetirarseActionPerformed(evt);
                    else{
                        //turn
                        jugador.sacarCredito(1);
                        dineroApuesta++;
                        //generar carta aleatoria para turn
                        aux = baraja.generaCartasConString(baraja.getJugadaString(baraja.generaJugada(1)));
                        board[3] = aux[0];
                        
                        tfDineroApostado.setText(Integer.toString(dineroApuesta));
                        tfMiStack.setText(Integer.toString(jugador.getDinero()));
                        e = equity.calculaEquity();
                        if(e < equityTurn)
                            btRetirarseActionPerformed(evt);
                        else{
                            jugador.sacarCredito(1);
                            dineroApuesta++;
                            tfDineroApostado.setText(Integer.toString(dineroApuesta));
                            tfMiStack.setText(Integer.toString(jugador.getDinero()));
                            //generar carta aleatoria para river
                            aux = baraja.generaCartasConString(baraja.getJugadaString(baraja.generaJugada(1)));
                            board[4] = aux[0];
                            //analizar ShowDown
                            analizarShowDown();
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btAutoActionPerformed

    private void jbManualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbManualActionPerformed
        // TODO add your handling code here:
        Equity equity;
        double e;
        equity = new Equity();
        String cartasOriginalesBoard = "";
         String cartasOriginalesBanca = "";
          String cartasOriginalesJugador = "";
        if(jugador.getDinero() < 5){
            JOptionPane.showMessageDialog(this, "No tienes saldo suficiente para jugar." + '\n' +
               "Por favor, introduce dinero para poder jugar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else{
            resetearCartas();
            board = new Carta[5];
            jugador.sacarCredito(1);
            dineroApuesta ++;

            //banca
            aux = baraja.generaJugada(2);
            //guardamos las cartas de la banca
            
            cartasOriginalesBanca=  aux[0].getDenominacion()+aux[1].getDenominacion();
            cartasB[0] = aux[0];
            cartasB[1] = aux[1];
            banca.setCarta1(cartasB[0]);
            banca.setCarta2(cartasB[1]);

            //jugador
            aux = baraja.generaJugada(2);
            cartasOriginalesJugador=  aux[0].getDenominacion()+aux[1].getDenominacion();
            
            cartasJ[0] = aux[0];
            cartasJ[1] = aux[1];
            jugador.setCarta1(cartasJ[0]);
            jugador.setCarta2(cartasJ[1]);
            cartasUsuario[0].setImagen("/resources/" + jugador.getCarta1().getDenominacion()+ ".png");
            cartasUsuario[1].setImagen("/resources/" + jugador.getCarta2().getDenominacion()+ ".png");

            tfDineroApostado.setText(Integer.toString(dineroApuesta));
            tfMiStack.setText(Integer.toString(jugador.getDinero()));

            //mano
            tfEquity.setText("se genera el pre-flop , (calculando equity)");
            this.update(this.getGraphics());
            //para despues ponerlas a false y que no se repitan
            
            
                    e = equity.calculaEquity();
                    tfEquity.setText("Tienes " + e + " % de equity en el pre-flop"); 
                  
            this.update(this.getGraphics());
            
            if(e < equityPreFlop){//44.44 es 4/9
                
                JOptionPane.showMessageDialog(this, "Te retiras." + '\n' +
               "Tiras tus cartas segun te las dan.", "Error", JOptionPane.INFORMATION_MESSAGE);
                btRetirarseActionPerformed(evt);
            }
            else{
                //flop
                jugador.sacarCredito(2);
                dineroApuesta+=2;
                
                //ponemos a false las cartas de la banca y el jugador
                aux = baraja.generaCartasConString(cartasOriginalesJugador);
                aux[0].setDisponible(false);
                aux[1].setDisponible(false);
                
                aux = baraja.generaCartasConString(cartasOriginalesBanca);
                aux[0].setDisponible(false);
                aux[1].setDisponible(false);
                //generar tres cartas aleatorias para flop
                
                aux = baraja.generaJugada(3);
                cartasOriginalesBoard = aux[0].getDenominacion()+aux[1].getDenominacion()+aux[2].getDenominacion();
                
                for(int j = 0; j < 3; j++){
                    board[j] = aux[j];
                    cartasComunes[j].setImagen("/resources/" + board[j].getDenominacion()+ ".png");
                }
                tfDineroApostado.setText(Integer.toString(dineroApuesta));
                tfMiStack.setText(Integer.toString(jugador.getDinero()));
                tfEquity.setText("se genera el flop , (calculando equity)");
                    e = equity.calculaEquity();
                    tfEquity.setText("Tienes " + e + " % de equity en el flop"); 
                this.update(this.getGraphics());
                if(e < equityFlop){//22.22 es 2/9
                    
                    JOptionPane.showMessageDialog(this, "Te retiras." + '\n' +
                    "Tiras tus cartas en el flop.", "Error", JOptionPane.INFORMATION_MESSAGE);
                    btRetirarseActionPerformed(evt);
                }
                else{
                    //turn
                    jugador.sacarCredito(1);
                    dineroApuesta++;
                    //ponemos a false las cartas de la banca y el jugador y del board
                    aux = baraja.generaCartasConString(cartasOriginalesJugador);
                    aux[0].setDisponible(false);
                    aux[1].setDisponible(false);

                    aux = baraja.generaCartasConString(cartasOriginalesBanca);
                    aux[0].setDisponible(false);
                    aux[1].setDisponible(false);
                    
                    aux = baraja.generaCartasConString(cartasOriginalesBoard);
                    aux[0].setDisponible(false);
                    aux[1].setDisponible(false);
                    aux[2].setDisponible(false);
                    //generar carta aleatoria para turn
                    
                    aux = baraja.generaJugada(1);
                    cartasOriginalesBoard= cartasOriginalesBoard + aux[0].getDenominacion();
                    
                    board[3] = aux[0];
                    cartasComunes[3].setImagen("/resources/" + board[3].getDenominacion()+ ".png");
                    tfDineroApostado.setText(Integer.toString(dineroApuesta));
                    tfMiStack.setText(Integer.toString(jugador.getDinero()));
                    tfEquity.setText("se genera el turn , (calculando equity)");
                    e = equity.calculaEquity();
                    tfEquity.setText("Tienes " + e + " % de equity en el turn"); 
                    this.update(this.getGraphics());
                    if(e < equityTurn){//11.11 es 1/9
                        
                        JOptionPane.showMessageDialog(this, "Te retiras." + '\n' +
                        "Tiras tus cartas en el turn.", "Error", JOptionPane.INFORMATION_MESSAGE);
                        btRetirarseActionPerformed(evt);
                    }
                    else{
                        jugador.sacarCredito(1);
                        dineroApuesta++;
                        tfDineroApostado.setText(Integer.toString(dineroApuesta));
                        tfMiStack.setText(Integer.toString(jugador.getDinero()));
                        //generar carta aleatoria para river
                        aux = baraja.generaCartasConString(cartasOriginalesJugador);
                        aux[0].setDisponible(false);
                        aux[1].setDisponible(false);

                        aux = baraja.generaCartasConString(cartasOriginalesBanca);
                        aux[0].setDisponible(false);
                        aux[1].setDisponible(false);

                        aux = baraja.generaCartasConString(cartasOriginalesBoard);
                        aux[0].setDisponible(false);
                        aux[1].setDisponible(false);
                        aux[2].setDisponible(false);
                        aux[3].setDisponible(false);
                        aux = baraja.generaJugada(1);
                        tfEquity.setText("se genera el river");
                        board[4] = aux[0];cartasComunes[4].setImagen("/resources/" + board[4].getDenominacion()+ ".png");
                        //mostrar cartas banca
                        cartasBanca[0].setImagen("/resources/" + banca.getCarta1().getDenominacion() + ".png");
                        cartasBanca[1].setImagen("/resources/" + banca.getCarta2().getDenominacion()+ ".png");
            
                        //analizar ShowDown
                        analizarShowDown();
                        this.update(this.getGraphics());
                    }
                }
            }
        }
        baraja.reset();
         tfEquity.setText("");
    }//GEN-LAST:event_jbManualActionPerformed

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        // TODO add your handling code here:
        try
        {
            
            if(Double.valueOf(tfPreflop.getText()) >0 && Double.valueOf(tfFlop.getText()) >0 && Double.valueOf(tfTurn.getText()) >0 &&
                    Double.valueOf(tfPreflop.getText()) <=100 && Double.valueOf(tfFlop.getText()) <=100 && Double.valueOf(tfTurn.getText()) <=100)
            {
                equityPreFlop = Double.valueOf(tfPreflop.getText());
                equityFlop = Double.valueOf(tfFlop.getText());
                equityTurn = Double.valueOf(tfTurn.getText());
                JOptionPane.showMessageDialog(this, "porcentajes almacenados", "confirmacion", JOptionPane.INFORMATION_MESSAGE);
              
            }
            else
            {
                 JOptionPane.showMessageDialog(this, "introduzca numeros mayores que 0 y menores o iguales a 100 por favor", "Error", JOptionPane.INFORMATION_MESSAGE);
            
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "introduzca numeros por favor", "Error", JOptionPane.INFORMATION_MESSAGE);
                       
        }
    }//GEN-LAST:event_btGuardarActionPerformed

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
    private javax.swing.JButton btAuto;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btRetirarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jbManual;
    private javax.swing.JMenu jmRecargarSaldo;
    private javax.swing.JMenu jmSalir;
    private javax.swing.JLabel lbBanca;
    private javax.swing.JLabel lbJugador;
    private javax.swing.JLabel lblApuestas;
    private javax.swing.JLabel lblEmpatado;
    private javax.swing.JLabel lblGanado;
    private javax.swing.JLabel lblPerdido;
    private javax.swing.JLabel lblStack;
    private javax.swing.JTextField tfDineroApostado;
    private javax.swing.JTextField tfEmpatadas;
    private javax.swing.JTextField tfEquity;
    private javax.swing.JTextField tfFlop;
    private javax.swing.JTextField tfGanados;
    private javax.swing.JTextField tfMiStack;
    private javax.swing.JTextField tfNumJugadas;
    private javax.swing.JTextField tfPerdidos;
    private javax.swing.JTextField tfPreflop;
    private javax.swing.JTextField tfResultado;
    private javax.swing.JTextField tfTurn;
    // End of variables declaration//GEN-END:variables

    public static PokerCaribean getInstance ()
    {
        if(instance == null)
        {
            instance = new PokerCaribean();
            return instance;
        }
        else
        {
            return instance;
        }
        
    }
}