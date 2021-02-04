
import Logica.UsuariosRegistrados;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



/**
 *
 * @author Carlollos Pc
 */
public class OnePlayer extends javax.swing.JPanel {

    
    String ArrayNamePlayers[];
    String PlayerName;
    JFrame VentanaMain;
    
    UsuariosRegistrados userActual;
    
    public OnePlayer(String NombreJugador , JFrame Ventana , UsuariosRegistrados userActual) {
        initComponents();
        
      this.GrupoBotones.add(Players3);
      this.GrupoBotones.add(Players4);
      this.GrupoBotones.add(Players5);
        
      this.PlayerName = NombreJugador;
      
      this.VentanaMain = Ventana;
      
      this.userActual = userActual;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoBotones = new javax.swing.ButtonGroup();
        Players5 = new javax.swing.JRadioButton();
        Players3 = new javax.swing.JRadioButton();
        Players4 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtRondasVictoria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Players5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Players5.setText("5 Jugadores");
        Players5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Players5ActionPerformed(evt);
            }
        });
        add(Players5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        Players3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Players3.setText("3 Jugadores");
        Players3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Players3ActionPerformed(evt);
            }
        });
        add(Players3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        Players4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Players4.setText("4 Jugadores");
        Players4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Players4ActionPerformed(evt);
            }
        });
        add(Players4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Numero de jugadores");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setText("Iniciar juego");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 60, 260, 150));

        txtRondasVictoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(txtRondasVictoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 170, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Rondas para ganar:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        jLabel3.setText("Reglas del juego:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel4.setText("Cada jugador tendra una carta, el jugador decidira si cambiar la carta que le toco, si la cambia no se podra negar ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jLabel5.setText("El jugador con la carta de valor y peso mas alta gana la ronda, se deben ganar un numero espesifico de rondas para");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jLabel6.setText("Ganar la partida, el peso de las cartas es el siguiente:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Corazones");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Treboles");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Diamantes");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Espadas");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, -1, -1));

        jLabel11.setText("El mas debil son corazones y el mas fuerte son las espadas");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 600, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
      try{
          
        JuegoPrincipal Jp = new JuegoPrincipal(ArrayNamePlayers , Integer.parseInt(txtRondasVictoria.getText()), (MainFrame) VentanaMain , this.userActual);
        Jp.setVisible(true);
        this.VentanaMain.setVisible(false); 
        
      }catch(Exception e){
          
        JOptionPane.showMessageDialog(null, "Debe seleccionar el numero de jugadores y ingresar un numero de rondas correctamente");
        
      }
     
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Players3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Players3ActionPerformed
       
       ArrayNamePlayers = new String[3];
       ArrayNamePlayers[0] = this.PlayerName;
       ArrayNamePlayers[1] = "Jugador 2";
       ArrayNamePlayers[2] = "Jugador 3";
       
    }//GEN-LAST:event_Players3ActionPerformed

    private void Players4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Players4ActionPerformed
        
       ArrayNamePlayers = new String[4];
       ArrayNamePlayers[0] = this.PlayerName;
       ArrayNamePlayers[1] = "Jugador 2";
       ArrayNamePlayers[2] = "Jugador 3";
       ArrayNamePlayers[3] = "Jugador 4";
        
    }//GEN-LAST:event_Players4ActionPerformed

    private void Players5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Players5ActionPerformed
       
       ArrayNamePlayers = new String[5];
       ArrayNamePlayers[0] = this.PlayerName;
       ArrayNamePlayers[1] = "Jugador 2";
       ArrayNamePlayers[2] = "Jugador 3";
       ArrayNamePlayers[3] = "Jugador 4";
       ArrayNamePlayers[4] = "Jugador 5";
       
    }//GEN-LAST:event_Players5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoBotones;
    private javax.swing.JRadioButton Players3;
    private javax.swing.JRadioButton Players4;
    private javax.swing.JRadioButton Players5;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JTextField txtRondasVictoria;
    // End of variables declaration//GEN-END:variables
}
