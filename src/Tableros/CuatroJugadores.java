/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tableros;

import static Tableros.TresJugadores.Card1;
import static Tableros.TresJugadores.Card2;
import static Tableros.TresJugadores.Card3;
import static Tableros.TresJugadores.EstablecerImagen;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Carlollos Pc
 */
public class CuatroJugadores extends javax.swing.JPanel {

    /**
     * Creates new form CuatroJugadores
     */
    public CuatroJugadores(String J1 , String J2 , String J3 , String J4) {
        initComponents();
        
        this.PlayerName1.setText(J1);
        this.PlayerName2.setText(J2);
        this.PlayerName3.setText(J3);
        this.PlayerName4.setText(J4);
        
        Card1.setBounds(190, 340, 70, 100);
        Card2.setBounds(370, 40, 70, 100);
        Card3.setBounds(30, 40, 70, 100);
        Card4.setBounds(30, 40, 70, 100);

        EstablecerImagen(Card1, "src\\src\\images\\FondoCartas.jpg");
        EstablecerImagen(Card2, "src\\src\\images\\FondoCartas.jpg");
        EstablecerImagen(Card3, "src\\src\\images\\FondoCartas.jpg");
        EstablecerImagen(Card4, "src\\src\\images\\FondoCartas.jpg");
        
        this.repaint();
    }

    public static void EstablecerImagen(JLabel label , String Route){
   
        Image img= new ImageIcon(Route).getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
        
        label.setIcon(img2);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Card2 = new javax.swing.JLabel();
        Card3 = new javax.swing.JLabel();
        Card1 = new javax.swing.JLabel();
        PlayerName1 = new javax.swing.JLabel();
        PlayerName2 = new javax.swing.JLabel();
        PlayerName3 = new javax.swing.JLabel();
        Card4 = new javax.swing.JLabel();
        PlayerName4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(40, 171, 185));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(Card2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 330, 71, 101));
        add(Card3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 71, 101));
        add(Card1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 71, 101));
        add(PlayerName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 133, 24));
        add(PlayerName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 133, 24));
        add(PlayerName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 133, 24));
        add(Card4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 71, 101));
        add(PlayerName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 133, 24));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel Card1;
    public static javax.swing.JLabel Card2;
    public static javax.swing.JLabel Card3;
    public static javax.swing.JLabel Card4;
    private javax.swing.JLabel PlayerName1;
    private javax.swing.JLabel PlayerName2;
    private javax.swing.JLabel PlayerName3;
    private javax.swing.JLabel PlayerName4;
    // End of variables declaration//GEN-END:variables
}
