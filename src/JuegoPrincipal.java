
import BaseDeDatos.ControlJugadores;
import Logica.Juego;
import Logica.Jugador;
import Logica.UsuariosRegistrados;
import Tableros.CincoJugadores;
import Tableros.CuatroJugadores;
import Tableros.TresJugadores;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sun.awt.RepaintArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlollos Pc
 */
public class JuegoPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JuegoPrincipal
     * @param NombresJugadores
     */
    
    static Juego Jugar;
    static TresJugadores JuegoDe3;
    static CuatroJugadores JuegoDe4;
    static CincoJugadores JuegoDe5;
    
    static int RondasParaVictoria;
    
    static MainFrame VentanaPrincipal;
    
    static int NumberPlayers;
    
    static UsuariosRegistrados usuarioActual;
    
    public JuegoPrincipal(String[] NombresJugadores , int RondasParaVictoria , MainFrame VentanaPrincipal, UsuariosRegistrados usuarioActual) {
        initComponents();
        
         //Centrar pantalla
        this.setLocationRelativeTo(null);
        //Titulo del frame
        this.setTitle("Friegate al vecino");
        
        //Establecer el icono del frame
        URL iconURL = getClass().getResource("\\src\\images\\FondoCartas.jpg");
        ImageIcon icon = new ImageIcon(iconURL);
        this.setIconImage(icon.getImage());
        
        this.Jugar = new Juego(NombresJugadores , RondasParaVictoria , usuarioActual);
        
        this.RondasParaVictoria = RondasParaVictoria;
        
        ActualizarTextos();
        
        //Definir numero de jugadores
        NumeroDeJugadores(NombresJugadores);
        
        //Definir tablero
        EstablecerTablero(NombresJugadores);
        
        //Mensaje de inicio de juego
        JOptionPane.showMessageDialog(null , "El juego ah iniciado, es tu turno... Suerte :D");
        
        this.VentanaPrincipal = VentanaPrincipal;
        
        IniciarRonda();
        
        BtnContinuar.setVisible(false);
        
        new ControlJugadores(usuarioActual.userName).aumentarJuegosJugados(usuarioActual.userName, usuarioActual.gamesPlayed);
        
        this.usuarioActual = usuarioActual;
    }

    public static void EstablecerTablero(String[] NombresJugadores){
        
        switch (NumberPlayers) {
         case 3:
             JuegoDe3 = new TresJugadores(NombresJugadores[0] , NombresJugadores[1] , NombresJugadores[2]);
             PlayZone.add(JuegoDe3);
             break;
         case 4:
             JuegoDe4 = new CuatroJugadores(NombresJugadores[0] , NombresJugadores[1] , NombresJugadores[2] , NombresJugadores[3]);
             PlayZone.add(JuegoDe4);
             break;
         case 5:
             JuegoDe5 = new CincoJugadores(NombresJugadores[0] , NombresJugadores[1] , NombresJugadores[2] , NombresJugadores[3] , NombresJugadores[4]);
             PlayZone.add(JuegoDe5);
             break;
         case 6:
             
             break;
         default:
             break;
        }
           
    }
    
    public static void NumeroDeJugadores(String[] Nombres){
        
        switch (Nombres.length) {
            case 3:
                NumberPlayers = 3;
                break;
            case 4:
                NumberPlayers = 4;
                break;
            case 5:
                NumberPlayers = 5;
                break;
            case 6:
                NumberPlayers = 6;
                break;
            default:
                break;
        }
        
    }
    
    public void IniciarRonda(){
        
        int linea = Log.getLineCount();
        String TextAnterior = Log.getText();
        Log.setText((linea) + "- La ronda "+ Jugar.Ronda +" inicio \n" + TextAnterior);
        
        ActualizarTextos();
        
        RepartirCartas();
        
        linea = Log.getLineCount();
        TextAnterior = Log.getText();
        Log.setText((linea) + "- Seleccione una accion \n" + TextAnterior);
       
    }
    
    public void Fase2Ronda() throws IOException{
        
        for (int i = 0; i < NumberPlayers-1; i++) {
            int valorDado = (int) Math.floor(Math.random()*2+1);
            
            if(valorDado == 1){
                this.Jugar.CambiarCarta();
        
                int linea = Log.getLineCount();
                String TextAnterior = Log.getText();
                Log.setText((linea) + "- "+ Jugar.TurnoJugador.NombreUsuario +" A cambiado la carta \n" + TextAnterior);

                this.Jugar.AvanzarJugador();
            }else{
                int linea = Log.getLineCount();
                String TextAnterior = Log.getText();
                Log.setText((linea) + "- "+ Jugar.TurnoJugador.NombreUsuario +" A pasado \n" + TextAnterior);

                this.Jugar.AvanzarJugador();
            }
        }
        
        int linea = Log.getLineCount();
        String TextAnterior = Log.getText();
        Log.setText((linea) + "- La ronda "+ Jugar.Ronda +" termino \n" + TextAnterior);
        
        BuscarGanadorDeRonda();
        
    }
    
    public void BuscarGanadorDeRonda() throws IOException{
        
       Jugador ganadorRonda = Jugar.BuscarGanador(NumberPlayers);
       Jugar.AumentarRondaGanador(ganadorRonda);

        int linea = Log.getLineCount();
        String TextAnterior = Log.getText();
        Log.setText((linea) + "- El ganador de la ronda fue: "+ ganadorRonda.NombreUsuario +" \n" + TextAnterior);
        
        //System.out.println("El ganador tiene " + ganadorRonda.RondasGanadas + " Rondas ganadas y se ocupan " + RondasParaVictoria + " para ganar"); 
       
       if(ganadorRonda.RondasGanadas >= RondasParaVictoria){
           RevelarTodasCartas();
           JOptionPane.showMessageDialog(null, "FIN DEL JUEGO \n El ganador de este juego es: "+ ganadorRonda.NombreUsuario);
           if(ganadorRonda.NombreUsuario.equals(usuarioActual.userName)){
               new ControlJugadores().aumentarJuegosGanados(usuarioActual.userName, usuarioActual.gamesWined);
               
              
           }
            new ControlJugadores().saveNewGame(usuarioActual, RondasParaVictoria , NumberPlayers, ganadorRonda.NombreUsuario);
           VentanaPrincipal.setVisible(true);
           this.setVisible(false);
       }else{
           Jugar.AvanzarRonda();
           Jugar.AvanzarRepatidor();
           //IniciarRonda();
            linea = Log.getLineCount();
            TextAnterior = Log.getText();
            Log.setText((linea) + "- Precione Continuar \n" + TextAnterior);
       }
       
       RevelarTodasCartas();
       ActualizarTextos();
    }
    
    public static void RepartirCartas(){
        
        Jugar.RepartirCarta();
        int linea = Log.getLineCount();
        String TextAnterior = Log.getText();
        Log.setText((linea) + "- Se Repartieron las cartas \n" + TextAnterior);
        
        Revelar1Carta();
        
        
    }
    
    
    public static void Revelar1Carta(){
        if(NumberPlayers == 3){
           String ruta =  "src\\src\\cartas\\"+Jugar.PrimerJugador.CartaActual+".jpg";
           JuegoDe3.EstablecerImagen(JuegoDe3.Card1,ruta);
           JuegoDe3.repaint();
        }
        if(NumberPlayers == 4){
            String ruta =  "src\\src\\cartas\\"+Jugar.PrimerJugador.CartaActual+".jpg";
           JuegoDe4.EstablecerImagen(JuegoDe4.Card1,ruta);
           JuegoDe4.repaint();
        }
        if(NumberPlayers == 5){
            String ruta =  "src\\src\\cartas\\"+Jugar.PrimerJugador.CartaActual+".jpg";
           JuegoDe5.EstablecerImagen(JuegoDe5.Card1,ruta);
           JuegoDe5.repaint();
        }
        if(NumberPlayers == 6){
            
        }
    }
    
    public static void RevelarTodasCartas(){
        if(NumberPlayers == 3){
            Jugador Aux = Jugar.PrimerJugador;
            
            String ruta;
                    
            for (int i = 0; i < 3; i++) {
                switch (i){
                    case 0:
                         ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                        JuegoDe3.EstablecerImagen(JuegoDe3.Card1,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 1:
                         ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                        JuegoDe3.EstablecerImagen(JuegoDe3.Card2,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 2:
                         ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                        JuegoDe3.EstablecerImagen(JuegoDe3.Card3,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                }
            }
             JuegoDe3.repaint();
        }
        if(NumberPlayers == 4){
            Jugador Aux = Jugar.PrimerJugador;
            
            String ruta;
                    
            for (int i = 0; i < 4; i++) {
                switch (i){
                    case 0:
                         ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                        JuegoDe4.EstablecerImagen(JuegoDe4.Card1,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 1:
                         ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                        JuegoDe4.EstablecerImagen(JuegoDe4.Card2,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 2:
                         ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                        JuegoDe4.EstablecerImagen(JuegoDe4.Card3,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 3:
                        ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                       JuegoDe4.EstablecerImagen(JuegoDe4.Card4,ruta);
                       Aux = Aux.SiguienteJugador;
                       break;
                }
            }
             JuegoDe4.repaint();
        }
        
        if(NumberPlayers == 5){
            Jugador Aux = Jugar.PrimerJugador;
            
            String ruta;
                    
            for (int i = 0; i < 5; i++) {
                switch (i){
                    case 0:
                         ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                        JuegoDe5.EstablecerImagen(JuegoDe5.Card1,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 1:
                         ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                        JuegoDe5.EstablecerImagen(JuegoDe5.Card2,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 2:
                         ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                        JuegoDe5.EstablecerImagen(JuegoDe5.Card3,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 3:
                        ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                       JuegoDe5.EstablecerImagen(JuegoDe5.Card4,ruta);
                       Aux = Aux.SiguienteJugador;
                       break;
                    case 4:
                        ruta =  "src\\src\\cartas\\"+Aux.CartaActual+".jpg";
                       JuegoDe5.EstablecerImagen(JuegoDe5.Card5,ruta);
                       Aux = Aux.SiguienteJugador;
                       break;
                       
                }
            }
             JuegoDe5.repaint();
        }
    }
    
   public void ActualizarTextos(){
        this.lblRepartio.setText("Repartio: "+Jugar.Repartidor.NombreUsuario);
        this.lblTurno.setText("Turno de: "+Jugar.TurnoJugador.NombreUsuario);
        this.lblRondasGanadas.setText("Rondas ganadas: "+Jugar.TurnoJugador.RondasGanadas);
        this.lblRonda.setText("Ronda: "+Jugar.Ronda);
        this.lblRondasParaGanar.setText("Rondas para ganar: "+Jugar.RondasParaVictoria);
   }
            
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlayZone = new javax.swing.JPanel();
        lblRonda = new javax.swing.JLabel();
        lblRepartio = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Log = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnChange = new javax.swing.JButton();
        btnPass = new javax.swing.JButton();
        lblRondasGanadas = new javax.swing.JLabel();
        lblRondasParaGanar = new javax.swing.JLabel();
        BtnContinuar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PlayZone.setLayout(new java.awt.CardLayout());
        getContentPane().add(PlayZone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 500, 500));

        lblRonda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRonda.setText("Ronda:");
        getContentPane().add(lblRonda, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, -1, -1));

        lblRepartio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRepartio.setText("Repartio:");
        getContentPane().add(lblRepartio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        Log.setColumns(20);
        Log.setRows(5);
        Log.setFocusable(false);
        jScrollPane1.setViewportView(Log);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 280, 380));

        jLabel4.setText("Log");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, -1, -1));

        lblTurno.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTurno.setText("Turno de:");
        getContentPane().add(lblTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Acciones:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, -1, -1));

        btnChange.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChange.setText("Cambiar de carta");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });
        getContentPane().add(btnChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 150, -1));

        btnPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPass.setText("Pasar");
        btnPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPassActionPerformed(evt);
            }
        });
        getContentPane().add(btnPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 150, -1));

        lblRondasGanadas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRondasGanadas.setText("Rondas ganadas:");
        getContentPane().add(lblRondasGanadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, -1));

        lblRondasParaGanar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRondasParaGanar.setText("Rondas para ganar:");
        getContentPane().add(lblRondasParaGanar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 170, -1, -1));

        BtnContinuar.setText("Continuar");
        BtnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnContinuarActionPerformed(evt);
            }
        });
        getContentPane().add(BtnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 580, 90, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/logout.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPassActionPerformed
        
        
        
        try {
            int linea = Log.getLineCount();
            String TextAnterior = Log.getText();
            Log.setText((linea) + "- "+ Jugar.TurnoJugador.NombreUsuario +" A pasado \n" + TextAnterior);
            
            this.Jugar.AvanzarJugador();
            Fase2Ronda();
            
            
            this.BtnContinuar.setVisible(true);
            this.btnChange.setVisible(false);
            this.btnPass.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(JuegoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnPassActionPerformed

    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
       
        try {
            this.Jugar.CambiarCarta();
            
            int linea = Log.getLineCount();
            String TextAnterior = Log.getText();
            Log.setText((linea) + "- "+ Jugar.TurnoJugador.NombreUsuario +" A cambiado la carta \n" + TextAnterior);
            
            this.Jugar.AvanzarJugador();
            Fase2Ronda();
            
            this.BtnContinuar.setVisible(true);
            this.btnChange.setVisible(false);
            this.btnPass.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(JuegoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnChangeActionPerformed

    private void BtnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnContinuarActionPerformed
        
        this.BtnContinuar.setVisible(false);
        this.btnChange.setVisible(true);
        this.btnPass.setVisible(true);
        
        
          if(NumberPlayers == 3){
            Jugador Aux = Jugar.PrimerJugador;
            String ruta;
            for (int i = 0; i < 3; i++) {
                switch (i){
                    case 0:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe3.EstablecerImagen(JuegoDe3.Card1,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 1:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe3.EstablecerImagen(JuegoDe3.Card2,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 2:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe3.EstablecerImagen(JuegoDe3.Card3,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                }
            }
             JuegoDe3.repaint();
        }
          
             if(NumberPlayers == 4){
            Jugador Aux = Jugar.PrimerJugador;
            String ruta;
            for (int i = 0; i < 4; i++) {
                switch (i){
                    case 0:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe4.EstablecerImagen(JuegoDe4.Card1,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 1:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe4.EstablecerImagen(JuegoDe4.Card2,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 2:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe4.EstablecerImagen(JuegoDe4.Card3,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                     case 3:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe4.EstablecerImagen(JuegoDe4.Card4,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                }
            }
             JuegoDe4.repaint();
        }
             
                if(NumberPlayers == 5){
            Jugador Aux = Jugar.PrimerJugador;
            String ruta;
            for (int i = 0; i < 5; i++) {
                switch (i){
                    case 0:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe5.EstablecerImagen(JuegoDe5.Card1,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 1:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe5.EstablecerImagen(JuegoDe5.Card2,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 2:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe5.EstablecerImagen(JuegoDe5.Card3,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 3:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe5.EstablecerImagen(JuegoDe5.Card4,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                    case 4:
                         ruta =  "src\\src\\images\\FondoCartas.jpg";
                        JuegoDe5.EstablecerImagen(JuegoDe5.Card5,ruta);
                        Aux = Aux.SiguienteJugador;
                        break;
                }
            }
             JuegoDe5.repaint();
        }
        
        IniciarRonda();
    }//GEN-LAST:event_BtnContinuarActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        
          VentanaPrincipal.setVisible(true);
           this.setVisible(false);
        
    }//GEN-LAST:event_jLabel1MouseClicked

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnContinuar;
    public static javax.swing.JTextArea Log;
    public static javax.swing.JPanel PlayZone;
    private javax.swing.JButton btnChange;
    private javax.swing.JButton btnPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRepartio;
    private javax.swing.JLabel lblRonda;
    private javax.swing.JLabel lblRondasGanadas;
    private javax.swing.JLabel lblRondasParaGanar;
    private javax.swing.JLabel lblTurno;
    // End of variables declaration//GEN-END:variables
}
