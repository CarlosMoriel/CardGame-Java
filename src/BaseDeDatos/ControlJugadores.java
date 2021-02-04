/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import Logica.UsuariosRegistrados;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carlollos Pc
 */
public class ControlJugadores {

    
    static String userName;
    
    public ControlJugadores(String userName) {
        this.userName = userName;
    }
    
    public ControlJugadores(){
        
    }
    
    public static void aumentarJuegosJugados(String userName, int actualPlayedGames){
         try {
            String sql;
            Conection con = new Conection();
            Statement sentenciaSQL=con.Conectarse().createStatement(); //crear consulta
            int newPlayedGames = actualPlayedGames + 1;
            sql = "UPDATE users SET gamesPlayed="+newPlayedGames+" WHERE userName='"+userName+"'";
            
            int rs= sentenciaSQL.executeUpdate(sql);
            
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: "+ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public static void aumentarJuegosGanados(String userName, int actualWinedGames){
         try {
            String sql;
            Conection con = new Conection();
            Statement sentenciaSQL=con.Conectarse().createStatement(); //crear consulta
            int newPlayedGames = actualWinedGames + 1;
            sql = "UPDATE users SET 'gamesWined'="+newPlayedGames+" WHERE userName='"+userName+"'";
            
             int rs= sentenciaSQL.executeUpdate(sql);
            
            
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error: "+ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
        
        
          
    public static void saveNewGame(UsuariosRegistrados newUser , int roundNumber , int numberPlayers , String winner) throws IOException{
        
        String sentenciaSql="INSERT INTO games(idUser,winner,rounds,players)VALUES(?,?,?,?)";
        
       try {
           
            Conection con = new Conection();
            PreparedStatement pst = con.Conectarse().prepareStatement(sentenciaSql);
            
            pst.setInt(1, newUser.id);
            pst.setString(2, winner);
            pst.setInt(3, roundNumber);
            pst.setInt(4, numberPlayers);
            
            int n=pst.executeUpdate();
            if (n>0) {
                JOptionPane.showMessageDialog(null, "Juego creado correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);   
            }
            con.CerrarConexion();
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Clase no encontrada: "+ex,"Error",JOptionPane.ERROR_MESSAGE);
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(null,"Error de instancia "+ex,"Error",JOptionPane.ERROR_MESSAGE);
        } catch (IllegalAccessException ex){
            JOptionPane.showMessageDialog(null,"Mal acceso a la BD: "+ex,"Error",JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error en la sentencia: "+ex,"Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
}
