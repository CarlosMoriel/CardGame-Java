
import BaseDeDatos.Conection;
import Logica.UsuariosRegistrados;
import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlollos Pc
 */
public class MainMenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MainMenuPanel
     */
    public MainMenuPanel(Container frame , String UserName , LinkedList<UsuariosRegistrados> allUsers) throws SQLException{
        initComponents();
        
        String[] bestPlayer = getBestPlayer(allUsers);
        
        this.lblUserName.setText("Mejor Jugador: "+bestPlayer[0]);
        this.lblGamesWin.setText("Juegos Ganados: "+bestPlayer[1]);
        
        
        getGamesHistory();
    }

    //Metodo para detectar el mejor usuario de la partida
    public static String[] getBestPlayer(LinkedList<UsuariosRegistrados> allUsers) throws SQLException{
        int bestRecord = 0;
        String bestPlayer = "Sin mejor jugador";
        String bestPlayerIcon;
        
        ImageIcon img = null;
       
        LinkedList<UsuariosRegistrados> users = allUsers;
        
        for (UsuariosRegistrados user : users) {
            if(user.gamesWined > bestRecord){
                bestPlayer = user.userName;
                bestRecord = user.gamesWined;
            }
        }
        
        
        String[] bestUserStats = new String[2];
        bestUserStats[0] = bestPlayer;
        bestUserStats[1] = Integer.toString(bestRecord);
        
        return bestUserStats;
    }
    
    
    public void getGamesHistory(){
        
        try {
            String sql;
            Conection con = new Conection();
            Statement sentenciaSQL=con.Conectarse().createStatement(); //crear consulta
            sql = "SELECT idGame,winner,rounds,players FROM games";
            ResultSet rs= sentenciaSQL.executeQuery(sql);
            ResultSetMetaData rsm=rs.getMetaData();
            int col=rsm.getColumnCount();
            DefaultTableModel modelo=new DefaultTableModel();
            for(int i=1;i<=col;i++){
                modelo.addColumn(rsm.getColumnLabel(i));//para poner los encabezados de la tabla
            }
            while (rs.next()) {//mientras la tabla tenga registros
                String [] fila=new String[col];
                for(int j=0;j<col;j++){
                    fila[j]=rs.getString(j+1);
                }
                modelo.addRow(fila);
            }
            this.tableHistory.setModel(modelo);//asignando una tabla llena a una tabla vacía
            rs.close();
            con.CerrarConexion();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: "+ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    
   public static ImageIcon obtenerImagen(String userName) throws SQLException{
        InputStream is = null;
        ImageIcon img = null;
        String sql="SELECT image FROM users WHERE userName='"+userName+"'";
        
        Conection con = null;
        Statement sentenciaSQL = null;
        
        try {
            con=new Conection();
            sentenciaSQL=con.Conectarse().createStatement();
            ResultSet rs=sentenciaSQL.executeQuery(sql);
            if(rs.next()){
                is=rs.getBinaryStream(1);
                BufferedImage bi = ImageIO.read(is);
                img = new ImageIcon(bi);
            }
        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error: "+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        con.CerrarConexion();
        sentenciaSQL.close();
        return img;
       
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblUserName = new javax.swing.JLabel();
        lblUserName1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistory = new javax.swing.JTable();
        lblGamesWin = new javax.swing.JLabel();
        lbImageBestPlayer = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 420, 30));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblUserName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblUserName.setText("Mejor Jugador:");
        jPanel1.add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        lblUserName1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblUserName1.setText("Hisotrial de todas las partidas: ");
        jPanel1.add(lblUserName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableHistory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tableHistory);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 590, 320));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 670, 450));

        lblGamesWin.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblGamesWin.setText("Juegos ganados:");
        jPanel1.add(lblGamesWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        lbImageBestPlayer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/images/cards.png"))); // NOI18N
        lbImageBestPlayer.setMaximumSize(new java.awt.Dimension(190, 170));
        lbImageBestPlayer.setMinimumSize(new java.awt.Dimension(190, 170));
        lbImageBestPlayer.setPreferredSize(new java.awt.Dimension(190, 170));
        jPanel1.add(lbImageBestPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 130, 130));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 660));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbImageBestPlayer;
    private javax.swing.JLabel lblGamesWin;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JLabel lblUserName1;
    private javax.swing.JTable tableHistory;
    // End of variables declaration//GEN-END:variables
}
