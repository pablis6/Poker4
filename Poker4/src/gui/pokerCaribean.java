/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import carta.Baraja;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class pokerCaribean extends javax.swing.JFrame {

    private final JPanelConFondo cartasBanca[];
    private final JPanelConFondo cartasUsuario[];
    private final JPanelConFondo cartasComunes[];
    private int miDinero;
    private int dineroApuesta;
    private Baraja baraja;
    
    /**
     * Creates new form pokerCaribean
     */
    public pokerCaribean() {
        initComponents();
        cartasBanca = new JPanelConFondo[2];
        cartasUsuario = new JPanelConFondo[2];
        cartasComunes = new JPanelConFondo[5];
        baraja = Baraja.getInstance();
        miDinero = 1000;
        
        int ancho = 50;
        int alto = 80;
        int x = this.getWidth()/2 - (ancho*4);
        int y = 120;
        
        cartasBanca[0] = new JPanelConFondo("/resources/reverso.JPG");
        cartasBanca[0].setBounds(this.getWidth()/2 - (ancho*2), 30, ancho, alto);
        this.add(cartasBanca[0]);
        cartasBanca[1] = new JPanelConFondo("/resources/reverso.JPG");
        cartasBanca[1].setBounds(this.getWidth()/2 - ancho, 30, ancho, alto);
        this.add(cartasBanca[1]);
        
        cartasUsuario[0] = new JPanelConFondo("/resources/reverso.JPG");
        cartasUsuario[0].setBounds(this.getWidth()/2 - (ancho*2), 220, ancho, alto);
        this.add(cartasUsuario[0]);
        cartasUsuario[1] = new JPanelConFondo("/resources/reverso.JPG");
        cartasUsuario[1].setBounds(this.getWidth()/2 - ancho, 220, ancho, alto);
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
        
        tfMiStack.setText(Integer.toString(miDinero));
        this.tfMiStack.setEditable(false);
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
        tfMiStack = new javax.swing.JTextField();
        btRetirarse = new javax.swing.JButton();
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

        tfMiStack.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btRetirarse.setText("Retirarse");
        btRetirarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetirarseActionPerformed(evt);
            }
        });

        jmSalir.setText("Salir");
        jMenuBar1.add(jmSalir);

        jmRecargarSaldo.setText("Añadir dinero");
        jMenuBar1.add(jmRecargarSaldo);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(420, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btRetirarse)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfDineroApostado)
                        .addComponent(btApostar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfMiStack)))
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(139, Short.MAX_VALUE)
                .addComponent(tfDineroApostado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btApostar)
                .addGap(18, 18, 18)
                .addComponent(btRetirarse)
                .addGap(18, 18, 18)
                .addComponent(tfMiStack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btApostarActionPerformed
        // TODO add your handling code here:
        if(btApostar.getText().equalsIgnoreCase("Empezar")){
            if(miDinero <= 5){
                JOptionPane.showMessageDialog(this, "No tienes saldo suficiente para jugar." + '\n' +
                   "Por favor, algo de dinero para poder jugar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    miDinero--;
                    dineroApuesta ++;
                    //generar dos cartas aleatorias para banca
                    //generar dos cartas aleatorias para usuario
                    btApostar.setText("Flop");
                    tfDineroApostado.setText(Integer.toString(dineroApuesta));
                    tfMiStack.setText(Integer.toString(miDinero));
                }   
        }
        else if(btApostar.getText().equalsIgnoreCase("Flop")){
            miDinero-=2;
            dineroApuesta+=2;
            //generar tres cartas aleatorias para flop
            btApostar.setText("Turn");
            tfDineroApostado.setText(Integer.toString(dineroApuesta));
            tfMiStack.setText(Integer.toString(miDinero));
        }
        else if(btApostar.getText().equalsIgnoreCase("Turn")){
            miDinero--;
            dineroApuesta++;
            //generar tres cartas aleatorias para turn
            btApostar.setText("River");
            tfDineroApostado.setText(Integer.toString(dineroApuesta));
            tfMiStack.setText(Integer.toString(miDinero));
        }
        else if(btApostar.getText().equalsIgnoreCase("River")){
            miDinero--;
            dineroApuesta++;
            tfDineroApostado.setText(Integer.toString(dineroApuesta));
            tfMiStack.setText(Integer.toString(miDinero));
            //generar tres cartas aleatorias para river
            //analizar showdown y reiniciar el contador de dineroApuesta
            btApostar.setText("Empezar");
            tfDineroApostado.setText(Integer.toString(dineroApuesta));
            tfMiStack.setText(Integer.toString(miDinero));
        }
    }//GEN-LAST:event_btApostarActionPerformed

    private void btRetirarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetirarseActionPerformed
        //quitar cartas de jugador y banca y resetear baraja
        dineroApuesta = 0;
        tfDineroApostado.setText(Integer.toString(dineroApuesta));
    }//GEN-LAST:event_btRetirarseActionPerformed

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
            java.util.logging.Logger.getLogger(pokerCaribean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pokerCaribean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pokerCaribean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pokerCaribean.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pokerCaribean().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btApostar;
    private javax.swing.JButton btRetirarse;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jmRecargarSaldo;
    private javax.swing.JMenu jmSalir;
    private javax.swing.JTextField tfDineroApostado;
    private javax.swing.JTextField tfMiStack;
    // End of variables declaration//GEN-END:variables
}
